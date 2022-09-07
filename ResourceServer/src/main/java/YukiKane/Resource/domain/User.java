package YukiKane.Resource.domain;

import com.google.cloud.firestore.annotation.DocumentId;
import lombok.*;
import org.springframework.cloud.gcp.data.firestore.Document;

@Data
@Document(collectionName = "UserDetails")
@RequiredArgsConstructor
@NoArgsConstructor
public class User {

    @DocumentId
    private String id;
    @NonNull
    private String name;
    @NonNull
    private int age;
    private String password;
    private String Role;



}
