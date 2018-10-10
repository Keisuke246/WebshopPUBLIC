package com.spring.henallux;

import java.io.File;

import org.bitcoinj.core.ECKey;
import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.kits.WalletAppKit;
import org.bitcoinj.params.TestNet3Params;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.spring.henallux.service.BitcoinWallet;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application {
	@Autowired
	private BitcoinWallet wallet;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
