package YukiKane.Resource.repository;

import YukiKane.Resource.domain.Item;
import org.springframework.cloud.gcp.data.firestore.FirestoreReactiveRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ItemRepository extends FirestoreReactiveRepository<Item> {

    Flux<Item> findItemByNameContaining(String s);
    Flux<Item> findItemByName(String s);
}
