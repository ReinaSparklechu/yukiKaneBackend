package YukiKane.repository;

import YukiKane.domain.Item;
import org.springframework.cloud.gcp.data.firestore.FirestoreReactiveRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ItemRepository extends FirestoreReactiveRepository<Item> {
    public Flux<Item> findItemByNameContaining(String s);
    public Flux<Item> findItemByName(String s);
}
