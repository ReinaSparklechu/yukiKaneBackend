package YukiKane.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.gcp.data.firestore.repository.config.EnableReactiveFirestoreRepositories;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableReactiveFirestoreRepositories
public class MainConfig {
}
