import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created on 27/11/2017.
 *
 * @author AtlanMod team.
 */
public class Main {

    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(MyClassConfiguration.class);
        MyClass mine = ctx.getBean(MyClass.class);

        mine.getTags().add("spring");
        System.out.println(mine);
    }

}
