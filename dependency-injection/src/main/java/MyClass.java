import javax.inject.Inject;
import java.util.List;

/**
 * Created on 27/11/2017.
 *
 * @author AtlanMod team.
 */
public class MyClass {

    @Inject
    public List<String> tags;

    public List getTags() {
        return tags;
    }

    @Override
    public String toString() {
        return "MyClass{ListClass:" + tags.getClass().getName() +
                "- tags=" + tags +
                '}';
    }
}
