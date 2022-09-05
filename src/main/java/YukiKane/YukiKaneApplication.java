package YukiKane;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gcp.data.firestore.repository.config.EnableReactiveFirestoreRepositories;

@SpringBootApplication
@EnableReactiveFirestoreRepositories("YukiKane.repository")
public class YukiKaneApplication {

	public static void main(String[] args) {
		SpringApplication.run(YukiKaneApplication.class, args);
	}

}
