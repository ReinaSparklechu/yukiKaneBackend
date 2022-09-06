package OAuth2.Yukikane.AuthServer.Service;

import OAuth2.Yukikane.AuthServer.Data.UserRepository;
import OAuth2.Yukikane.AuthServer.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.logging.Logger;

@Service
@Transactional
public class YukiUserDetailService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = userRepository.findByName(username).block();
        Logger.getGlobal().info(u.toString());
        if(u==null) {
            throw new UsernameNotFoundException("User not found");
        }
        return u;
    }

}
