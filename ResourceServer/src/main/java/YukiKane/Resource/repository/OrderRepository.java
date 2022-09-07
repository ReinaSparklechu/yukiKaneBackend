package YukiKane.Resource.repository;

import YukiKane.Resource.domain.Order;
import YukiKane.Resource.domain.User;
import org.springframework.cloud.gcp.data.firestore.FirestoreReactiveRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface OrderRepository extends FirestoreReactiveRepository<Order> {
    Flux<Order> findOrdersByPlacedBy(User user);
}
