package com.spring.henallux.service;

import java.io.File;

import org.bitcoinj.core.Address;
import org.bitcoinj.core.Coin;
import org.bitcoinj.core.ECKey;
import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.core.Transaction;
import org.bitcoinj.core.TransactionOutput;
import org.bitcoinj.kits.WalletAppKit;
import org.bitcoinj.params.TestNet3Params;
import org.bitcoinj.wallet.Wallet;
import org.bitcoinj.wallet.listeners.AbstractWalletEventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.spring.henallux.dataAccess.dao.CommandeDAO;
import com.spring.henallux.model.Commande;

@Service
public class BitcoinWallet {

	private WalletAppKit kit;
	
	@Autowired
	private CommandeDAO commandeDAO;

	public BitcoinWallet(){
		NetworkParameters params = TestNet3Params.get();
		String filePrefix = "forwarding-service-testnet";
		kit = new WalletAppKit(params, new File(".wallet"), filePrefix) {
			@Override
			protected void onSetupCompleted() {
				// This is called in a background thread after startAndWait is called, as setting up various objects
				// can do disk and network IO that may cause UI jank/stuttering in wallet apps if it were to be done
				// on the main thread.
				if (wallet().getKeyChainGroupSize() < 1)
					wallet().importKey(new ECKey());
			}
		};

		// Download the block chain and wait until it's done.
		kit.startAsync();
		kit.awaitRunning();
		kit.wallet().addEventListener(new AbstractWalletEventListener() {
			@Override
			public void onCoinsReceived(Wallet w, Transaction tx, Coin prevBalance, Coin newBalance) {
				// Runs in the dedicated "user thread".
				//
				// The transaction "tx" can either be pending, or included into a block (we didn't see the broadcast).
				Coin value = tx.getValueSentToMe(w);
				System.out.println("Received tx for " + value.toFriendlyString() + ": " + tx);
				for(TransactionOutput out : tx.getOutputs()){
					if(out.isMine(w)){
						Address adr = out.getAddressFromP2PKHScript(TestNet3Params.get());
						Commande commande = commandeDAO.getCommandeByBitcoinAddress(adr.toString());
						if(commande != null){
							if(value.getValue() >= commande.getPrixTotal()){
								commande.setEtat(Commande.ETATPAYE);
								commandeDAO.setEtatCommande(commande);
								System.out.println("Recu payment pour commande " + commande.getNumero());
							}
						}
					}
				}
			}
		});
	}
	public void Run(){

	}
	
	public String getNewAddress(){
		return kit.wallet().freshReceiveAddress().toString();
	}
}
