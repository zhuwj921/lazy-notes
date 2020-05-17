import com.zhuwj.auth.Application;
import com.zhuwj.auth.model.dto.UserDTO;
import com.zhuwj.auth.security.TokenProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TokenProviderTest {

    @Autowired
    private TokenProvider tokenProvider;


    @Test
    public void createToken() {
        String jwt = tokenProvider.createToken(new UsernamePasswordAuthenticationToken(new UserDTO(), new UserDTO()));
        System.out.println(jwt);
    }

    @Test
    public void decodeToken() {
        String jwt = tokenProvider.createToken(new UsernamePasswordAuthenticationToken(new UserDTO(), new UserDTO()));
        System.out.println(tokenProvider.decodeToken(jwt));
    }

    @Test
    public void verifyToken() {
    }
}