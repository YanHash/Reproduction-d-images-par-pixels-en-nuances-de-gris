# Reproduction d'images au format pgm en pixels de nuances de gris en fenêtre
	- Date : Decembre 2022
	
	
	
## Génération et consultation de la documentation:
	- Génération:
	Dans un terminal, se placer dans le répértoire du code source /image/src puis:
		javadoc image -d ../docs 
	ou
		javadoc -d ../docs -subpackages image
	
	- Consultation:
	Ouvrir depuis le dossier /image/docs/ dans un navigateur web les fichier portant le nom des classes suivis de l'extension .html
	Naviguer entre les classes dans un navigateur web
	
	
## Compilation:
	Dans un terminal, se placer dans le répértoire du code source /image/src puis: 
		javac image/ImageMain.java -d ../classes 
	ou  
		javac image/*.java -d ../classes
		
		
## Exécution:
	Dans un terminal, se placer dans le répértoire /image/classes puis: 
		java image.ImageMain
	suivi de : - le nom d'une image présente dans le dossier /image/classes/images: nomImage.pgm      
		   - un entier naturel inférieur ou égal à 255      
		   - un entier naturel puissance de 2 compris entre 2 et 128      
		   
	Exemples: java image.ImageMain chat.pgm 5 64      
		  java image.ImageMain body.pgm 20 128
		  

## Compilation et exécution des tests:
	- Compilation:
	Après avoir compilé les classes du paquetage image
	Dans un terminal, se placer à la racine du projet /image puis: 
		javac -classpath test4poo.jar test/TestImage.java 
		javac -classpath test4poo.jar test/TestPixel.java
		
	- Exécution:
	Dans le même répértoire: 
		java -jar test4poo.jar TestImage
		java -jar test4poo.jar TestPixel
		
		
## Création de fichier jar exécutables:
	- Création:
	Dans un terminal, se placer dans le répértoire contenant un manifeste, les classes compilés et le dossiers contenant les images
	/image/classes puis:
		jar cvfm ../image.jar manifest-image images image
		
	- Exécution:
	Dans un terminal, se placer dans le répértoire racine /image puis:
		java -jar image.jar
	suivi de : - le nom d'une image présente dans le dossier /image/classes/images: nomImage.pgm      
		   - un entier naturel inférieur ou égal à 255       
		   - un entier naturel puissance de 2 compris entre 2 et 128       
