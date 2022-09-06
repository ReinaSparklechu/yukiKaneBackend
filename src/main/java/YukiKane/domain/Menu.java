package YukiKane.domain;

import com.google.cloud.firestore.annotation.DocumentId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cloud.gcp.data.firestore.Document;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collectionName = "Menus")
public class Menu {

    private Outlet outlet;
    private Set<Item> offerings;
    @DocumentId
    private String id;
}
