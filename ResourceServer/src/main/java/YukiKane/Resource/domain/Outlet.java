package YukiKane.Resource.domain;

import com.google.cloud.firestore.annotation.DocumentId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cloud.gcp.data.firestore.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collectionName = "Outlets")
public class Outlet {
    private String address;
    @DocumentId
    private String id;
    private int maxOrders;
    private List<Order> queuedOrders;

    @Override
    public String toString() {
        return "Outlet{" +
                "address='" + address + '\'' +
                ", id='" + id + '\'' +
                ", maxOrders=" + maxOrders +
                ", queuedOrders=" + queuedOrders +
                ", menu=" + menu +
                '}';
    }

    private Menu menu;

    public int currentOrders() {
        return this.queuedOrders.size();
    }
    public void addOrders(Order o) {
        this.queuedOrders.add(o);
    }
    public void completeOrder(Order o) {
        this.queuedOrders.remove(o);
    }
}
