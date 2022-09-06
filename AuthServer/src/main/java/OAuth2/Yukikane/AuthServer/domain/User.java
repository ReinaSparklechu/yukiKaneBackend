package OAuth2.Yukikane.AuthServer.domain;

import com.google.cloud.firestore.annotation.DocumentId;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gcp.data.firestore.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.Transient;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

@Data
@Document(collectionName = "UserDetails")
@RequiredArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {

    @DocumentId
    private String id;
    @NonNull
    private String name;
    @NonNull
    private int age;
    @NonNull
    private String password;
    @NonNull
    private String Role;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority(this.Role));
    }

    @Override
    public String getUsername() {
        return this.name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", Role='" + Role + '\'' +
                '}';
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
