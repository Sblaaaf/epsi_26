package fr.epsi_26.epsi_26;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MaConnexionSQL {

    // Note le "throws SQLException" : C'est la patate chaude qu'on refile
    public static Connection getMaConnexion() throws SQLException {

        // 1. Récupération des infos depuis les variables d'environnement (Config IntelliJ)
        String dbUser = System.getenv("DB_USER");
        String dbPass = System.getenv("DB_PASSWORD");
        String dbUrl  = System.getenv("DB_URL");
        // Exemple d'URL type : jdbc:mariadb://localhost:3306/mabase

        // 2. Vérification rapide (optionnel mais propre)
        if (dbUser == null || dbPass == null || dbUrl == null) {
            // On lance une erreur manuelle si la config est vide
            throw new SQLException("Les variables d'environnement ne sont pas configurées !");
        }

        // 3. Demande de connexion au DriverManager
        // C'est cette ligne qui fait tout le travail magique
        return DriverManager.getConnection(dbUrl, dbUser, dbPass);
    }
}
