package YukiKane.repository;


import YukiKane.domain.Menu;
import YukiKane.domain.Outlet;
import org.springframework.cloud.gcp.data.firestore.FirestoreReactiveRepository;
import org.springframework.cloud.gcp.data.firestore.repository.support.ReactiveFirestoreRepositoryFactory;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface MenuRepository extends FirestoreReactiveRepository<Menu> {
    Mono<Menu> findMenuById(String id);
}
