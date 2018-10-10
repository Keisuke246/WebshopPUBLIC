create table promotion
(
	id		  int	 auto_increment primary key,
    dateDebut date 	 not null,
    dateFin   date	 not null,
    pourcPromo double not null check (pourcPromo > 0),
	nom		  varchar(50) not null
);
insert into promotion (dateDebut,dateFin,pourcPromo,nom) values (STR_TO_DATE('18/01/16','%d/%m/%y'),STR_TO_DATE('28/01/17','%d/%m/%y'),10,"Semaine verte");
insert into promotion (dateDebut,dateFin,pourcPromo,nom) values (STR_TO_DATE('01/01/17','%d/%m/%y'), STR_TO_DATE('31/01/17','%d/%m/%y') ,33.33,"Mois du camping!");

create table fournisseur
(
	id		  int 	 auto_increment primary key,
    nom	      varchar(50) not null,
    adresse	  varchar(150) not null,
    email 	  varchar(50) not null
);
insert into fournisseur (nom,adresse,email) values ('Dufour', 'Rue de la Grange, 45, 5530 Godinne','j.dufourpro@gmail.com');
insert into fournisseur (nom,adresse,email) values ('Dupont', 'Rue de la Scène, 12, 5150 Franière','jdbc.dupont@gmail.com');

create table langage
(
	id 		  int    auto_increment primary key,
    nom       varchar(50) not null
);
insert into langage(nom) values('English');
insert into langage(nom) values('Français');

create table categorie
(
	id		  int	 auto_increment primary key,
    nom		  varchar(50) not null
);
insert into categorie (nom) values ('Tentes');
insert into categorie (nom) values ('Literie');
insert into categorie (nom) values ('Accessoires');
insert into categorie (nom) values ('Camping gaz,réchaud,barbecue');
insert into categorie (nom) values ('Gourdes,poches à eau');
insert into categorie (nom) values ('Hygiène,moustiquaires');



create table commande
(
	numero    int    auto_increment primary key,
    dateCommande      date   not null,
    etat 	  varchar(50) not null,
	idUtilisateur int not null references utilisateur(id),
    bitcoinAddress varchar(60) not null,
    prixTotal double not null check(prixTotal > 0)
);
insert into commande (dateCommande,etat,idUtilisateur,bitcoinAddress,prixTotal) values (STR_TO_DATE('17/01/16','%d/%m/%y'),"attente",2,"miBvtQumed1P7qRU62a7sOVwzYAUFezPb",89.99);
insert into commande (dateCommande,etat,idUtilisateur,bitcoinAddress,prixTotal) values (STR_TO_DATE('19/01/16','%d/%m/%y'),"attente",3,"miBvtAvmed1P7qRU62a7sOVwzYAUFezPb",80.991);
create table ligne
(
	numero	  int 	 auto_increment primary key,
    quantite  int    not null check(quantité > 0),
    prixArticle double not null check(prixArticle > 0),
    idArticle int not null references article(id) ,
    numCommande int not null references commande(numero)
);
insert into ligne (quantite,prixArticle,idArticle,numCommande) values (1,89.99,3,1);
insert into ligne (quantite,prixArticle,idArticle,numCommande) values (1,80.991,3,2);
create table utilisateur
(
	id		  int    auto_increment primary key,
    nom		  varchar(50) not null,
    prenom    varchar(50) not null,
    telephone varchar(25),
    email	  varchar(50) not null unique,
    motDePasse varchar(85) not null,
    rue		  varchar(50) not null,
    numero    int	not null check(numero > 0),
    etage     int,
    localite  varchar(50) not null,
    codePostal int not null,
    pays  	  varchar(50) not null
);
/* mot de passe des utilisateurs créés : password1 */
insert into utilisateur (nom,prenom,telephone,email,motDePasse,rue,numero,etage,localite,codePostal,pays) values('Dupont','Jean',null,'jean@outlook.com','7c6a18b36896aa8c2787eeafbe4c','Rue du pré',5,1,'Namur',5000,'Belgique');
insert into utilisateur (nom,prenom,telephone,email,motDePasse,rue,numero,etage,localite,codePostal,pays) values('Hérion','Valérie',null,'valerie.herion@cfwb.be','7c6a18b36896aa8c2787eeafbe4c','Rue du pont',5,null,'Namur',5000,'Belgique');
insert into utilisateur (nom,prenom,telephone,email,motDePasse,rue,numero,etage,localite,codePostal,pays) values('Delfosse','Nicolas',null,'delfosse.nicolas@outlook.com','7c6a18b36896aa8c2787eeafbe4c','Rue du pont',5,null,'Namur',5000,'Belgique');
insert into utilisateur (nom,prenom,telephone,email,motDePasse,rue,numero,etage,localite,codePostal,pays) values('Vanrussel','Olivier','0496547918','olivier.vanrussel@hotmail.com','7c6a18b36896aa8c2787eeafbe4c','Rue du pont',5,2,'Namur',5000,'Belgique');
insert into utilisateur (nom,prenom,telephone,email,motDePasse,rue,numero,etage,localite,codePostal,pays) values('Mordit','Anne','083248472','morditanne@gmail.com','7c6a18b36896aa8c2787eeafbe4c','Rue du pont',5,4,'Namur',5000,'Belgique');
insert into utilisateur (nom,prenom,telephone,email,motDePasse,rue,numero,etage,localite,codePostal,pays) values('Dubois','Marc','0497514892','marc.dubois@henallux.be','7c6a18b36896aa8c2787eeafbe4c','Rue du pont',5,null,'Namur',5000,'Belgique');

create table article
(
	id		 int    auto_increment primary key,
	libelle  varchar(120) not null,
	description varchar(200) not null,
    prix	 double not null check(prix > 0),
    stock	 int 	not null check(stock >= 0),
    idPromotion int references promotion(id),
    idFournisseur int not null references fournisseur(id),
	idCategorie int not null references categorie(id)
);
insert into article (libelle,description,prix,stock,idPromotion,idFournisseur,idCategorie) values ('Tente QUECHUA 2p BLEU Montage 140" express','LA tente de base du camping façon QUECHUA. Spacieuse et confortable, elle convient parfaitement à tout campeur débutant ou confirmé',39.99,50,1,1,1); /*tente 2 personnes*/
insert into article (libelle,description,prix,stock,idPromotion,idFournisseur,idCategorie) values ('Tente QUECHUA FAMILLE 6m²','Pour vos randonnées familliales, rien de tel que la tente QUECHUA familliale 4p 6m². Confort et sécurité garantie, elle tient unie toute la famille!',299.99,10,2,1,1); /*tente familliale*/
insert into article (libelle,description,prix,stock,idPromotion,idFournisseur,idCategorie) values ('Matelas gonflable 2 personnes QUECHUA 60sec','Conçu pour dormir très confortablement en CAMPING. 200 x 80 cm. Le matelas à Gonflage/Dégonflage "Seconds" ultra-rapide ! ',89.99,20,1,1,2); /*matelas gonflable*/
insert into article (libelle,description,prix,stock,idPromotion,idFournisseur,idCategorie) values ('Oreiller confort QUECHUA','Léger et confortable. Accueille vos vêtements ou l''oreiller gonflable AIR BASIC et s''adapte a votre besoin de fermeté. ',6.99,150,null,1,2); /*oreiller*/
insert into article (libelle,description,prix,stock,idPromotion,idFournisseur,idCategorie) values ('Glacière CAMPINGAZ ICETIME 26L bleu','Rigide, 26 Litres. Protège et garde au frais. ',24.89,50,null,2,3); /*glacière*/
insert into article (libelle,description,prix,stock,idPromotion,idFournisseur,idCategorie) values ('Douche portable avec eau sous pression QUECHUA','Eau sous pression, comme une vraie douche ! ',44.99,5,null,2,3); /*douche portable*/
insert into article (libelle,description,prix,stock,idPromotion,idFournisseur,idCategorie) values ('Réchaud camping party Grill CAMPINGAZ','Multi-fonctions, le réchaud Party Grill offre de nombreuses possibilités.',44.99,21,null,2,4); /*réchaud camping*/
insert into article (libelle,description,prix,stock,idPromotion,idFournisseur,idCategorie) values ('Réchaud randonnée cartouche cv 470 + CAMPINGAZ','Cartouche à valve. Facile à clipser et déclipser.',6.45,100,null,1,4); /*cartouche à gaz*/
insert into article (libelle,description,prix,stock,idPromotion,idFournisseur,idCategorie) values ('Réchaud randonnée zip JETBOIL','Un concept léger, compact et résistant ',65.99,14,null,1,4); /*réchaud randonnée*/
insert into article (libelle,description,prix,stock,idPromotion,idFournisseur,idCategorie) values ('Hydratation randonnée bidon 0.75l plastique vert QUECHUA','Un bidon simple pour la randonnée. ',2.50,200,null,2,5); /*bidon 0,75L*/
insert into article (libelle,description,prix,stock,idPromotion,idFournisseur,idCategorie) values ('Hydratation randonnée kit tétine tube poche à eau QUECHUA','Remplacer le tube et la pipette de votre poche à eau Forclaz. ',4.99,54,null,2,5); /*kit tétine*/
insert into article (libelle,description,prix,stock,idPromotion,idFournisseur,idCategorie) values ('Hydratation randonnée poche à eau 2l forclaz QUECHUA','Poche à eau souple, pratique et à petit prix. ',9.99,75,null,1,5); /*poche à eau*/
insert into article (libelle,description,prix,stock,idPromotion,idFournisseur,idCategorie) values ('Accessoires randonnée moustiquaire 1personne QUECHUA','Moustiquaire pour 1 personne, non imprégnée. Protége des insectes',15.99,25,null,2,6); /*moustiquaire*/
insert into article (libelle,description,prix,stock,idPromotion,idFournisseur,idCategorie) values ('Mobilier camping cabine seconds vert QUECHUA','La cabine idéale pour augmenter le confort en camping ! Instantanéité et faible encombrement. ',44.99,12,null,1,6); /*cabine*/
insert into article (libelle,description,prix,stock,idPromotion,idFournisseur,idCategorie) values ('Abri 2 Seconds 0 QUECHUA bleu QUECHUA','Petit abri à installation instantanée. Nouveau tissu teint dans la masse pour réduire la consommation et la pollution d''eau. ',19.99,37,null,2,1); /*tente*/
insert into article (libelle,description,prix,stock,idPromotion,idFournisseur,idCategorie) values ('Tente de camping familiale air seconds 5.2 xl | 5 personnes 2 grandes chambres QUECHUA','Facilité et rapidité de montage pour cette tente 5 places bénéficiant d''un très large séjour protégée par un auvent avec 2 chambres de 3 et 2 personnes.',479.99,5,2,2,1); /*tente 5 places*/
insert into article (libelle,description,prix,stock,idPromotion,idFournisseur,idCategorie) values ('Pompe à main 5,2 Litres QUECHUA','Le top de gamme des pompes : Ultra-efficace pour tout gonfler rapidement en Camping ! ',15.99,8,null,2,3);/*pompe*/


create table traductionarticle
(
	idTraductionArticle int auto_increment primary key,
	description  varchar(300) not null,
    nom			 varchar(100) not null,
    idArticle    int references article(id),
    idLangage    int references langage(id)
);
/* traductions en français*/
insert into traductionarticle (description,nom,idArticle,idLangage) values('LA tente de base du camping façon QUECHUA. Spacieuse et confortable, elle convient parfaitement à tout campeur débutant ou confirmé','Tente QUECHUA 2p BLEU Montage 140" express',1,2);
insert into traductionarticle (description,nom,idArticle,idLangage) values('Pour vos randonnées familliales, rien de tel que la tente QUECHUA familliale 4p 6m². Confort et sécurité garantie, elle tient unie toute la famille!','Tente QUECHUA FAMILLE 6m²',2,2);
insert into traductionarticle (description,nom,idArticle,idLangage) values('Conçu pour dormir très confortablement en CAMPING. 200 x 80 cm. Le matelas à Gonflage/Dégonflage "Seconds" ultra-rapide ! ','Matelas gonflable 2 personnes QUECHUA 60sec',3,2);
insert into traductionarticle (description,nom,idArticle,idLangage) values('Léger et confortable. Accueille vos vêtements ou l''oreiller gonflable AIR BASIC et s''adapte a votre besoin de fermeté. ','Oreiller confort QUECHUA',4,2);
insert into traductionarticle (description,nom,idArticle,idLangage) values('Rigide, 26 Litres. Protège et garde au frais. ','Glacière CAMPINGAZ ICETIME 26L bleu',5,2);
insert into traductionarticle (description,nom,idArticle,idLangage) values('Eau sous pression, comme une vraie douche ! ','Douche portable avec eau sous pression QUECHUA',6,2);
insert into traductionarticle (description,nom,idArticle,idLangage) values('Multi-fonctions, le réchaud Party Grill offre de nombreuses possibilités.','Réchaud camping party Grill CAMPINGAZ',7,2);
insert into traductionarticle (description,nom,idArticle,idLangage) values('Cartouche à valve. Facile à clipser et déclipser.','Réchaud randonnée cartouche cv 470 + CAMPINGAZ',8,2);
insert into traductionarticle (description,nom,idArticle,idLangage) values('Un concept léger, compact et résistant ','Réchaud randonnée zip JETBOIL',9,2);
insert into traductionarticle (description,nom,idArticle,idLangage) values('Un bidon simple pour la randonnée. ','Hydratation randonnée bidon 0.75l plastique vert QUECHUA',10,2);
insert into traductionarticle (description,nom,idArticle,idLangage) values('Remplacer le tube et la pipette de votre poche à eau Forclaz. ','Hydratation randonnée kit tétine tube poche à eau QUECHUA',11,2);
insert into traductionarticle (description,nom,idArticle,idLangage) values('Poche à eau souple, pratique et à petit prix. ','Hydratation randonnée poche à eau 2l forclaz QUECHUA',12,2);
insert into traductionarticle (description,nom,idArticle,idLangage) values('Moustiquaire pour 1 personne, non imprégnée. Protége des insectes','Accessoires randonnée moustiquaire 1personne QUECHUA',13,2);
insert into traductionarticle (description,nom,idArticle,idLangage) values('La cabine idéale pour augmenter le confort en camping ! Instantanéité et faible encombrement. ','Mobilier camping cabine seconds vert QUECHUA',14,2);
insert into traductionarticle (description,nom,idArticle,idLangage) values('Petit abri à installation instantanée. Nouveau tissu teint dans la masse pour réduire la consommation et la pollution d''eau. ','Abri 2 Seconds 0 QUECHUA bleu QUECHUA',15,2);
insert into traductionarticle (description,nom,idArticle,idLangage) values('Facilité et rapidité de montage pour cette tente 5 places bénéficiant d''un très large séjour protégée par un auvent avec 2 chambres de 3 et 2 personnes.','Tente de camping familiale air seconds 5.2 xl | 5 personnes 2 grandes chambres QUECHUA',16,2);
insert into traductionarticle (description,nom,idArticle,idLangage) values('Le top de gamme des pompes : Ultra-efficace pour tout gonfler rapidement en Camping ! ','Pompe à main 5,2 Litres QUECHUA',17,2);
/* traductions en anglais
insert into TraductionArticle (description,nom,idArticle,idLangage) values('LA tente de base du camping façon QUECHUA. Spacieuse et confortable, elle convient parfaitement à tout campeur débutant ou confirmé','Tente QUECHUA 2p BLEU Montage 140" express',1,1);
insert into TraductionArticle (description,nom,idArticle,idLangage) values('Pour vos randonnées familliales, rien de tel que la tente QUECHUA familliale 4p 6m². Confort et sécurité garantie, elle tient unie toute la famille!','Tente QUECHUA FAMILLE 6m²',2,1);
insert into TraductionArticle (description,nom,idArticle,idLangage) values('Conçu pour dormir très confortablement en CAMPING. 200 x 80 cm. Le matelas à Gonflage/Dégonflage "Seconds" ultra-rapide ! ','Matelas gonflable 2 personnes QUECHUA 60sec',3,1);
insert into TraductionArticle (description,nom,idArticle,idLangage) values('Léger et confortable. Accueille vos vêtements ou l''oreiller gonflable AIR BASIC et s''adapte a votre besoin de fermeté. ','Oreiller confort QUECHUA',4,1);
insert into TraductionArticle (description,nom,idArticle,idLangage) values('Rigide, 26 Litres. Protège et garde au frais. ','Glacière CAMPINGAZ ICETIME 26L bleu',5,1);
insert into TraductionArticle (description,nom,idArticle,idLangage) values('Eau sous pression, comme une vraie douche ! ','Douche portable avec eau sous pression QUECHUA',6,1);
insert into TraductionArticle (description,nom,idArticle,idLangage) values('Multi-fonctions, le réchaud Party Grill offre de nombreuses possibilités.','Réchaud camping party Grill CAMPINGAZ',7,1);
insert into TraductionArticle (description,nom,idArticle,idLangage) values('Cartouche à valve. Facile à clipser et déclipser.','Réchaud randonnée cartouche cv 470 + CAMPINGAZ',8,1);
insert into TraductionArticle (description,nom,idArticle,idLangage) values('Un concept léger, compact et résistant ','Réchaud randonnée zip JETBOIL',9,1);
insert into TraductionArticle (description,nom,idArticle,idLangage) values('Un bidon simple pour la randonnée. ','Hydratation randonnée bidon 0.75l plastique vert QUECHUA',10,1);
insert into TraductionArticle (description,nom,idArticle,idLangage) values('Remplacer le tube et la pipette de votre poche à eau Forclaz. ','Hydratation randonnée kit tétine tube poche à eau QUECHUA',11,1);
insert into TraductionArticle (description,nom,idArticle,idLangage) values('Poche à eau souple, pratique et à petit prix. ','Hydratation randonnée poche à eau 2l forclaz QUECHUA',12,1);
insert into TraductionArticle (description,nom,idArticle,idLangage) values('Moustiquaire pour 1 personne, non imprégnée. Protége des insectes','Accessoires randonnée moustiquaire 1personne QUECHUA',13,1);
insert into TraductionArticle (description,nom,idArticle,idLangage) values('La cabine idéale pour augmenter le confort en camping ! Instantanéité et faible encombrement. ','Mobilier camping cabine seconds vert QUECHUA',14,1);
insert into TraductionArticle (description,nom,idArticle,idLangage) values('Petit abri à installation instantanée. Nouveau tissu teint dans la masse pour réduire la consommation et la pollution d''eau. ','Abri 2 Seconds 0 QUECHUA bleu QUECHUA',15,1);
insert into TraductionArticle (description,nom,idArticle,idLangage) values('Facilité et rapidité de montage pour cette tente 5 places bénéficiant d''un très large séjour protégée par un auvent avec 2 chambres de 3 et 2 personnes.','Tente de camping familiale air seconds 5.2 xl | 5 personnes 2 grandes chambres QUECHUA',16,1);
insert into TraductionArticle (description,nom,idArticle,idLangage) values('Le top de gamme des pompes : Ultra-efficace pour tout gonfler rapidement en Camping ! ','Pompe à main 5,2 Litres QUECHUA',17,1);*/


create table traductioncategorie
(
	idTraductionCategorie int auto_increment primary key,
    nom			 varchar(100) not null,
    idCategorie  int references categorie(id),
    idLangage    int references langage(id)
);
insert into traductioncategorie (nom,idCategorie,idLangage) values ("Tents",1,1);
insert into traductioncategorie (nom,idCategorie,idLangage) values ("Bedding",2,1);
insert into traductioncategorie (nom,idCategorie,idLangage) values ("Accessories",3,1);
insert into traductioncategorie (nom,idCategorie,idLangage) values ("Heating",4,1);
insert into traductioncategorie (nom,idCategorie,idLangage) values ("Gourds",5,1);
insert into traductioncategorie (nom,idCategorie,idLangage) values ("Hygiene",6,1);

insert into traductioncategorie (nom,idCategorie,idLangage) values ("Tentes",1,2);
insert into traductioncategorie (nom,idCategorie,idLangage) values ("Litterie",2,2);
insert into traductioncategorie (nom,idCategorie,idLangage) values ("Accessoires",3,2);
insert into traductioncategorie (nom,idCategorie,idLangage) values ("Réchauds",4,2);
insert into traductioncategorie (nom,idCategorie,idLangage) values ("Gourdes",5,2);
insert into traductioncategorie (nom,idCategorie,idLangage) values ("Hygiene",6,2);


/*create table typearticle
(
	idTypeArticle int auto_increment primary key,
	idArticle int references article(id),
    idCategorie int references categorie(id)
);
insert into typearticle (idArticle,idCategorie) values(1,1);
insert into typearticle (idArticle,idCategorie) values(2,1);
insert into typearticle (idArticle,idCategorie) values(3,2);
insert into typearticle (idArticle,idCategorie) values(4,2);
insert into typearticle (idArticle,idCategorie) values(5,3);
insert into typearticle (idArticle,idCategorie) values(6,3);
insert into typearticle (idArticle,idCategorie) values(7,4);
insert into typearticle (idArticle,idCategorie) values(8,4);
insert into typearticle (idArticle,idCategorie) values(9,4);
insert into typearticle (idArticle,idCategorie) values(10,5);
insert into typearticle (idArticle,idCategorie) values(11,5);
insert into typearticle (idArticle,idCategorie) values(12,5);
insert into typearticle (idArticle,idCategorie) values(13,6);
insert into typearticle (idArticle,idCategorie) values(14,6);
insert into typearticle (idArticle,idCategorie) values(15,1);
insert into typearticle (idArticle,idCategorie) values(16,1);
insert into typearticle (idArticle,idCategorie) values(17,3);*/
