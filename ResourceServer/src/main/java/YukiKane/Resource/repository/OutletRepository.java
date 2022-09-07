package YukiKane.Resource.repository;

import YukiKane.Resource.domain.Outlet;

import org.springframework.cloud.gcp.data.firestore.FirestoreReactiveRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface OutletRepository extends FirestoreReactiveRepository<Outlet> {

    Mono<Outlet> findByAddress(String s);

}
