import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedList;
import java.util.List;

/**
 * Created on 27/11/2017.
 *
 * @author AtlanMod team.
 */

@Configuration
public class MyClassConfiguration {

    @Bean
    public MyClass myClass() {
        return new MyClass();
    }

    @Bean
    public List<String> getTags() {
        return new LinkedList<String>();
    }
}
