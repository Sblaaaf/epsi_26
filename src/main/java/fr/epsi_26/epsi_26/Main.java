package fr.epsi_26.epsi_26;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        System.out.println("Tentative de connexion...");

        // Ici on est OBLIGÉ de mettre un try-catch car la méthode getMaConnexion()
        // a prévenu qu'elle pouvait "throw" (lancer) une exception.
        try {

            Connection maConnexion = MaConnexionSQL.getMaConnexion();

            // Si on arrive ici, c'est que pas d'erreur n'a été lancée
            System.out.println("Succès ! Connecté à la base de données.");
            System.out.println("Validité de la connexion : " + maConnexion.isValid(2));

            // ... Ici on ferait nos requêtes SQL ...

            // Toujours fermer la porte en partant
            maConnexion.close();

        } catch (Exception e) {
            // C'est ici qu'on atterrit si le "throws" s'est déclenché
            System.err.println("ÉCHEC : Impossible de se connecter.");
            System.err.println("Raison : " + e.getMessage());
        }
    }
}
