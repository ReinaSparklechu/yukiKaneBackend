package YukiKane.repository;

import YukiKane.domain.User;
import org.springframework.cloud.gcp.data.firestore.FirestoreReactiveRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface UserRepository extends FirestoreReactiveRepository<User> {

    Flux<User> findByName(String name);
}
