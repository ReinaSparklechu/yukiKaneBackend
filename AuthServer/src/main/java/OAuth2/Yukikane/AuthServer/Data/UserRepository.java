package OAuth2.Yukikane.AuthServer.Data;

import OAuth2.Yukikane.AuthServer.domain.User;

import org.springframework.cloud.gcp.data.firestore.FirestoreReactiveRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends FirestoreReactiveRepository<User> {

    Mono<User> findByName(String name);
}
