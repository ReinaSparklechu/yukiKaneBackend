package YukiKane.Resource.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.cloud.firestore.annotation.DocumentId;
import lombok.Data;
import org.springframework.cloud.gcp.data.firestore.Document;

import java.sql.Timestamp;
import java.util.List;

@Data
@Document(collectionName = "Orders")
public class Order {
    @DocumentId
    private String id;
    private User placedBy;
    private List<Item> items;

    private Timestamp placedAt;
    private Outlet outlet;
}
