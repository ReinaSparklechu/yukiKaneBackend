package OAuth2.Yukikane.AuthServer;

import OAuth2.Yukikane.AuthServer.Data.UserRepository;
import OAuth2.Yukikane.AuthServer.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gcp.data.firestore.repository.config.EnableReactiveFirestoreRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.logging.Logger;

@SpringBootApplication
@EnableReactiveFirestoreRepositories
@CrossOrigin(origins = "http://localhost:9090")
public class AuthServerApplication {

	public static void main(String[] args) {

		SpringApplication.run(AuthServerApplication.class, args);
	}


}
