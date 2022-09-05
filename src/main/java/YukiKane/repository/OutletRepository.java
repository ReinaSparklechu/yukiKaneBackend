package YukiKane.repository;

import YukiKane.domain.Outlet;
import org.springframework.cloud.gcp.data.firestore.FirestoreReactiveRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutletRepository extends FirestoreReactiveRepository<Outlet> {
}
