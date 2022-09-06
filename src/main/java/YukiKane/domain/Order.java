package YukiKane.domain;

import com.google.cloud.Timestamp;
import com.google.cloud.firestore.annotation.DocumentId;
import lombok.Data;
import org.springframework.cloud.gcp.data.firestore.Document;

import java.util.List;

@Data
@Document(collectionName = "Orders")
public class Order {
    @DocumentId
    private String id;
    private User placedBy;
    private List<Item> items;
    private Timestamp placedAt;
}
