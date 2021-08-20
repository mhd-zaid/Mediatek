# Mediatek

### En quoi consiste ce projet?


Le projet intitulé Mediatek consiste à la réalisation d'une application web de gestion et consultation de document dans une médiathèque.

Notre application réunit les fonctions suivantes :

  * Connexion à l'application permettant un accès à la basse de données de la médiathèque.
  
 * Ajout, suppression de documents ainsi qu'affichage des documents stocké dans la base de donnée.
  
Nous avons travailler avec la base de donné MySQL afin de gérer les différents utilisateurs ainsi que les documents de la médiathèque.

La table où sont stockée les documents se nomme documents, chaque éléments de cette table possède 4 attributs : iddocumets, typeDoc qui correspond au type de chaque document 1: Livre, 2: CD et 3: Image, titreDoc et emprunt qui est utilisé comme un booléen.

### Structure du code

Notre application Mediatek est découpée en 6 packages:

  * Utilisateur: Ce package s'occupe de la gestion des utilisateurs
  
  * Document: Ce package s'occupe de la gestion des documents
  
  * Init: Ce package s'occupe de l'injection de dépendance
  
  * Services: Ce package contient les servlets.
  
  * Médiatek2021: Ce package contient les classes, interface, etc... fournie au début du projet.

  * PersistantData: Ce package contient les classes permettant la communication avec la base de donnée.



