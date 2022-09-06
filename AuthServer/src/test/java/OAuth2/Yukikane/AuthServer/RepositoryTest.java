package OAuth2.Yukikane.AuthServer;

import OAuth2.Yukikane.AuthServer.Data.UserRepository;
import com.google.cloud.Timestamp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@SpringBootTest
@EnableAutoConfiguration
@ContextConfiguration(classes = {UserRepository.class})
public class RepositoryTest {
    @Autowired
    UserRepository userRepository;


    @Test
    @org.junit.jupiter.api.Order(1)
    public void find() {
        Logger.getGlobal().info(userRepository.findByName("James").block().toString());

    }


}
