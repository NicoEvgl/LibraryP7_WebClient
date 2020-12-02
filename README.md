# LibraryP7_WebClient

Contexte
Ce projet a été développé dans le cadre du cursus "Développeur d'application Java" d'OpenClassrooms et correspond à la partie WEB du projet 7. Le site web permet aux usagers de suivre les prêts de leurs ouvrages. 

Ils pourront :

-Rechercher des ouvrages et voir le nombre d’exemplaires disponibles.

-Consulter leurs prêts en cours. Les prêts sont pour une période de 4 semaines.

-Prolonger un prêt en cours. Le prêt d’un ouvrage n’est prolongeable qu’une seule fois. La prolongation ajoute une nouvelle période de prêt (4 semaines) à la période initiale.

# Architecture

Version de java : 11 (jdk utilisé : jdk13) 
Maven 3.6 

[ API ] : API Rest Web service https://github.com/NicoEvgl/LibraryP7_API.git      'LibraryP7_Api'

[ batch ] : Système d’envoi d’e-mails récurent https://github.com/NicoEvgl/LibraryP7_Batch.git      'LibraryP7_Batch'

[ WebClient ] : Application web https://github.com/NicoEvgl/LibraryP7_WebClient.git      'LibraryP7_WebClient'

# Frameworks

Spring Framework 5.0.6

Spring Security 5.0.5

Spring Batch 4.0.1

Spring Data 2.0.7

Hibernate 5.2.17

Apache Log4J 2.11.0

Javax Mail 1.6.1

Bootstrap 3.3.7

# Persistence

PostgreSQL 10.4

# Installation et déploiement

1.Configuration

Pour le fonctionnement complet du site, il est nécessaire que l' API (LibraryP7_API) soit actif. L'application est livrée pour se connecter à l'api en localhost sur le port 9090 

A modifier si l'API est déployée sur un autre endpoint.

2.Déploiement

Application standalone intégrant un conteneur web (grace à SpringBoot)

Ouvrir le terminal de commande, se placer dans le dossier du projet cloné puis taper les commandes :
mvn clean spring-boot:run

3.Accès

L'application est accessible par http://localhost:8080/ l'application via le JDD fourni contient un compte démo (Nicoe, mot de passe : pass123)
