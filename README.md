# Spring - Projet Troue
Projet Final pour la cybersécurité, j'ai repis unb projet existant qui repose sur une api en spring boot (voir description en anglais ci-dessous) 

This is a REST spring-boot project for an assesment on a social-network theme. 

In this project you can :
* You can sign-up on the `/users/sign-up` endpoint.
* Login on the `/login` endpoint that will give you in the header a token that you will need to access the other endpoints.
* There is also two endpoints `/posts/**`, `/users/**` where you can find all the datas.
* You can also see your friend requests, accept them and send friend reuests to other people (more details on these endpoints in the  `methods.json` file)

-> A list of pre-filled endpoints are available in the `methods.json`file that you can import in postman/insomnia... to try the endpoints easily

# Objectif sécurité

## Confidentialité
2/5 Les mots de passe sont chiffré lors de le l'inscription via `/users/sign-up` mais les users existants sont en dure et on ne peut pas se connecter à eux sans avoir le hash de leurs mdp.  Les requête sont à permission, il faut un token de login pour les utiliser, cependant celui ci peut être intercepté dans le header et un user authentifié peut accepter / rejeter des demandes d'amis pour un autre utilisateurs

## Intégrité
2/5 les requêtes permetytent de modifier une données/ajouter/supprimer cependant l'architecture de la bdd fait qu'elle se reload à chaque début de projet donc un utilisateur qui se sign-in doit se re sign-in quand le projet se ferme. Il faut hebergé l'api sur un serveur qui tourne 24h/24.

## Disponibilité
4/5 Les requêtes sont explicites et les parametres sont clair. La visibilité des posts est gérée ce qui fait que un utilisateurs ne verra des posts que si ce post le concerne (post privé/public avec gestion d'amis).

## Traçabilité
0/5 Il n'y a pas de log afin de voir qui exécute les requêtes.

# Run the project with maven 

* mvn clean install
* docker build -t projet-troue-docker .
* docker run -d -p 8080:8080 projet-troue-docker

# Mermaidjs
[![](https://mermaid.ink/img/eyJjb2RlIjoiZ3JhcGggVERcbiAgQVtEb2NrZXJdIC0tPkJcbiAgQltDb250YWluZXJdIC0tPiBDXG4gIENbQVBJXSAtLT4gUFtEQVRBQkFTRV1cbiAgUC0tPiBKXG4gIEpbQXV0aF0gLS0-RFxuICBKIC0tPktcbiAgRFtQb3N0XSAtLT5FXG4gIEQtLT5GXG4gIEQgLS0-SFxuICBEIC0tPklcbiAgRVtHRVRdIC0tPkUxW1wiL3Bvc3RzL3Nob3dcIl1cbiAgRVtHRVRdIC0tPiBFMltcIi9wb3N0c1wiXVxuICBFW0dFVF0gLS0-IEUzW1wiL3Bvc3RzL2lkXCJdXG4gIEZbUE9TVF0gLS0-IEYxW1wiL3Bvc3RzXCJdXG4gIEhbUFVUXSAtLT4gSDFbXCIvcG9zdHMvaWRcIl1cbiAgSVtERUxFVEVdIC0tPiBJMVtcIi9wb3N0cy9pZFwiXVxuXG4gIEtbVXNlcl0gLS0-IExbR0VUXVxuICBLIC0tPiBOW1BPU1RdXG4gIEsgLS0-IE1bUFVUXVxuICBLIC0tPiBPW0RFTEVURV1cbiAgTCAtLT4gTDFbXCIvdXNlcnNcIl1cbiAgTCAtLT4gTDJbXCIvdXNlcnMvaWRcIl1cbiAgTCAtLT4gTDNbXCIvdXNlcnMvbXlJZC9hY2NlcHQvaWRUb0FjY2VwdFwiXVxuICBMIC0tPiBMNFtcIi91c2Vycy9teUlkL2RlbnkvaWRUb0RlbnlcIl1cbiAgTiAtLT4gTjFbXCIvdXNlcnNcIl1cbiAgTiAtLT4gTjJbXCIvdXNlcnMvaWQvcmVxdWVzdEZyaWVuZFwiXVxuICBNIC0tPiBNMVtcIi91c2Vycy9pZFwiXVxuICBPIC0tPiBPMVtcIi91c2Vycy9pZFwiXVxuXG4gXG4gICIsIm1lcm1haWQiOnsidGhlbWUiOiJkZWZhdWx0In0sInVwZGF0ZUVkaXRvciI6ZmFsc2V9)](https://mermaid-js.github.io/mermaid-live-editor/#/edit/eyJjb2RlIjoiZ3JhcGggVERcbiAgQVtEb2NrZXJdIC0tPkJcbiAgQltDb250YWluZXJdIC0tPiBDXG4gIENbQVBJXSAtLT4gUFtEQVRBQkFTRV1cbiAgUC0tPiBKXG4gIEpbQXV0aF0gLS0-RFxuICBKIC0tPktcbiAgRFtQb3N0XSAtLT5FXG4gIEQtLT5GXG4gIEQgLS0-SFxuICBEIC0tPklcbiAgRVtHRVRdIC0tPkUxW1wiL3Bvc3RzL3Nob3dcIl1cbiAgRVtHRVRdIC0tPiBFMltcIi9wb3N0c1wiXVxuICBFW0dFVF0gLS0-IEUzW1wiL3Bvc3RzL2lkXCJdXG4gIEZbUE9TVF0gLS0-IEYxW1wiL3Bvc3RzXCJdXG4gIEhbUFVUXSAtLT4gSDFbXCIvcG9zdHMvaWRcIl1cbiAgSVtERUxFVEVdIC0tPiBJMVtcIi9wb3N0cy9pZFwiXVxuXG4gIEtbVXNlcl0gLS0-IExbR0VUXVxuICBLIC0tPiBOW1BPU1RdXG4gIEsgLS0-IE1bUFVUXVxuICBLIC0tPiBPW0RFTEVURV1cbiAgTCAtLT4gTDFbXCIvdXNlcnNcIl1cbiAgTCAtLT4gTDJbXCIvdXNlcnMvaWRcIl1cbiAgTCAtLT4gTDNbXCIvdXNlcnMvbXlJZC9hY2NlcHQvaWRUb0FjY2VwdFwiXVxuICBMIC0tPiBMNFtcIi91c2Vycy9teUlkL2RlbnkvaWRUb0RlbnlcIl1cbiAgTiAtLT4gTjFbXCIvdXNlcnNcIl1cbiAgTiAtLT4gTjJbXCIvdXNlcnMvaWQvcmVxdWVzdEZyaWVuZFwiXVxuICBNIC0tPiBNMVtcIi91c2Vycy9pZFwiXVxuICBPIC0tPiBPMVtcIi91c2Vycy9pZFwiXVxuXG4gXG4gICIsIm1lcm1haWQiOnsidGhlbWUiOiJkZWZhdWx0In0sInVwZGF0ZUVkaXRvciI6ZmFsc2V9)

# Authors
* @Skiadram - Neel Coffin
