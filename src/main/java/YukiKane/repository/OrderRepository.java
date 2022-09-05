package YukiKane.repository;

import YukiKane.domain.Order;
import YukiKane.domain.User;
import org.springframework.cloud.gcp.data.firestore.FirestoreReactiveRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface OrderRepository extends FirestoreReactiveRepository<Order> {
    Flux<Order> findOrdersByPlacedBy(User user);
}
