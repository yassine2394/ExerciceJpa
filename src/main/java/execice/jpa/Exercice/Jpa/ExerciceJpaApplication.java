package execice.jpa.Exercice.Jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExerciceJpaApplication {
	public static void main(String[] args) {
		SpringApplication.run(ExerciceJpaApplication.class, args);


	}

}
/*
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ExerciceJpaApplication {
	public static void main(String[] args) {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=EXERCICE_JPA";
		String user = "bOrMOLIGELIn";
		String password = "Of1KL9'6G@d8)Z";

		try (Connection connection = DriverManager.getConnection(url, user, password)) {
			if (connection != null) {
				System.out.println("Connexion réussie !");
			} else {
				System.out.println("Échec de la connexion.");
			}
		} catch (SQLException e) {
			System.err.println("Erreur lors de la connexion : " + e.getMessage());
		}
	}
}*/
