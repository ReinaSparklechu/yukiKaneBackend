package YukiKane.Resource.configuration;

import org.springframework.cloud.gcp.data.firestore.repository.config.EnableReactiveFirestoreRepositories;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableReactiveFirestoreRepositories
public class MainConfig {
}
