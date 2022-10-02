package YukiKane.Resource.domain;


import com.google.cloud.firestore.annotation.DocumentId;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cloud.gcp.data.firestore.Document;

@Data
@Document(collectionName = "MenuItems")
@NoArgsConstructor
public class Item {

    @DocumentId
    private String id;
    private String name;
    private String desc;
    private Type type;

    public enum Type{
        DRINK,DESSERT
    }

    public Item(String name) {
        this.name=name;
    }

    public Item(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
}
