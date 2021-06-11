# POO Projet, jeu de société

## Quel est le but de ce projet ?

Le principe de ce projet est de réaliser un jeu de Azul jouable sur un terminal
et avec une interface graphique. Dans "Azul", deux à quatre joueurs vont tour à 
tour récupérer des tuiles colorées depuis une réserve commune (Fabriques et 
Centre de la table), dans le but de remplir leur propre mur et ainsi marquer des
points. Le joueur ayant le plus de points lorsque le jeu s’arrête remporte la 
partie. La partie s’arrête lorsqu'un joueur finit une ligne de son mur. Les 
joueurs peuvent remporter des bonus en remplissant une ligne, une colonne ou 
toutes les cases d'une même couleur. Pour des règles plus détaillées : 
```
http://videoregles.net/videoregle/azul
```

## Différentes versions du jeu

Il existe trois différentes versions du jeu qui utilisent le même modèle et qui 
peuvent être utilisées en même temps :

1. Version normale : la version de base est une version avec 100 tuiles 
   colorées, soit 20 tuiles de chaque couleur (bleu, jaune, rouge, noir et 
   gris), plus une tuile premier joueur. Chaque joueur a un mur prédéfini qu'il 
   doit compléter avec les bonnes couleurs.

2. Version avec un mur vide : cette version est la même que la version normale 
   mais les joueurs n'ont pas de mur prédéfini, ce qui leur laisse plus de 
   possibilités mais il y a aussi un risque d’être bloqué dans une couleur et 
   donc de ne pas pouvoir finir une ligne. Ce projet prévient quand même le 
   joueur lorsqu'il risque d’être coincé mais le joueur peut décider de se 
   bloquer. Dans cette version le terminal de commande demande donc au joueur où 
   il veut mettre sa tuile contrairement à la version de base. Les bonus restent
   les mêmes.

3. Version avec des jokers : cette version peut être utilisée avec n'importe 
   laquelle des autres versions. Dans cette version, dans une partie à deux 
   joueurs, une tuile de chaque couleur est remplacée par une tuile joker ; à 
   trois ou quatre joueurs deux tuiles de chaque couleur sont remplacées par des
   tuiles joker. Lorsqu’un joueur récupère des tuiles d’une fabrique ou du 
   centre de la table, il peut choisir de prendre toutes les tuiles joker de ce 
   lieu, ou toutes les tuiles joker et toutes les tuiles d’une autre couleur. 
   Les tuiles joker n’ont pas de couleur et peuvent donc occuper la même ligne 
   motif que n’importe quelle autre tuile. Lors de la phase de décoration si une
   ligne motif complète ne contient que des tuiles joker, l’une d’entre elles 
   peut être placée sur n’importe quelle case libre de la ligne du mur 
   correspondante. Si une ligne motif complète contient des tuiles joker et des 
   tuiles de couleur, alors une tuile joker est placée sur la case de la couleur 
   en question (si version normale). En fin de partie, les tuiles joker ne 
   permettent pas de gagner 10 points pour avoir complété une couleur.

## Déroulement d'une partie

Le jeu fonctionne en plusieurs étapes. Une fois le programme lancé :

1. Le jeu commence, il vous demande combien de joueurs sont présents pour 
   initialiser le nombres de fabriques. Puis il vous demande si vous voulez des 
   extensions pour pouvoir initialiser le plateau-joueur et le sac. 
   
2. Les tours commencent, au premier tour le joueur le plus jeune commence, pour 
   les tours suivant c'est le joueur qui a récupéré la tuile indépendante qui
   commence.

3. La phase de préparation commence, le jeu mets en place la partie : le premier
   joueur, les fabriques, le centre de table et les plateaux des joueurs.

4. Puis il y a une phase de pioche, ou chaque joueur prend tour à tour des 
   tuiles dans les fabriques ou le centre de la table et les pose sur son plateau.

5. Lorsque le centre de la table et les fabriques sont vides le tour se finit, les 
   lignes des plateaux joueurs finies permettent de remplir le mur, enfin le 
   score de chaque joueur est calculé puis un nouveau tour commence.

Ainsi de suite jusqu'à ce qu'un joueur finisse une ligne sur son mur. Le joueur 
avec le meilleur score gagne.

## Différentes façons d'utiliser ce projet ? 

Il existe deux façons de jouer à Azul :
1. Sur un terminal de commande,où l'affichage est moins pratique.
2. Avec une interface graphique, beaucoup plus lisible, pratique et esthétique.

### Comment faire fonctionner le jeu

Pour compiler:
```
make
```
Pour installer maven si cela ne fonctionne pas: 
```
sudo apt-get install maven
```

Pour lancer le jeu en version texte, faites:
```
java -jar Azul-Terminal.jar 
```
Ou pour lancer le jeu avec l'interface graphique, faites:
```
java -jar Azul-IG.jar
```

Pour voir la JavaDoc, double cliquez sur:
```
Site
```