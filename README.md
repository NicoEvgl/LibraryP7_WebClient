# Library_WebClient

Contexte
Ce projet a été développé dans le cadre du cursus "Développeur d'application Java" d'OpenClassrooms et correspond à la partie WEB du projet 7 et 10. Le site web permet aux usagers de suivre les prêts de leurs ouvrages ainsi que de réserver un ouvrage ( voir Issues ). 

Ils pourront :

-Rechercher des ouvrages et voir le nombre d’exemplaires disponibles.

-Consulter leurs prêts en cours. Les prêts sont pour une période de 4 semaines.

-Prolonger un prêt en cours. Le prêt d’un ouvrage n’est prolongeable qu’une seule fois. La prolongation ajoute une nouvelle période de prêt (4 semaines) à la période initiale.

-Réserver un ouvrage.

# Architecture

Version de java : 11 (jdk utilisé : jdk13) 
Maven 3.6 

[ API ] : API Rest Web service https://github.com/NicoEvgl/Library_API.git      'Library_Api'

[ batch ] : Système d’envoi d’e-mails récurent https://github.com/NicoEvgl/Library_Batch.git      'Library_Batch'

[ WebClient ] : Application web https://github.com/NicoEvgl/Library_WebClient.git      'Library_WebClient'

# Frameworks

Maven

Spring boot MVC

Apache Log4J 2.11.0

Bootstrap 3.3.7

# Persistence

PostgreSQL 10.4

# Installation et déploiement

1.Configuration

Pour le fonctionnement complet du site, il est nécessaire que l' API (Library_API) soit actif. L'application est livrée pour se connecter à l'api en localhost sur le port 9090 

A modifier si l'API est déployée sur un autre endpoint.

2.Déploiement

Application standalone intégrant un conteneur web (grace à SpringBoot)

Ouvrir le terminal de commande, se placer dans le dossier du projet cloné puis taper les commandes :

mvn clean spring-boot:run

3.Accès

L'application est accessible par http://localhost:8080/ l'application via le JDD fourni contient un compte démo (Nicoe, mot de passe : Pass123)
