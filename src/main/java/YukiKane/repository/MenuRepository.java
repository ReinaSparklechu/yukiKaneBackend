package YukiKane.repository;


import YukiKane.domain.Menu;
import org.springframework.cloud.gcp.data.firestore.FirestoreReactiveRepository;
import org.springframework.cloud.gcp.data.firestore.repository.support.ReactiveFirestoreRepositoryFactory;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends FirestoreReactiveRepository<Menu> {
}
