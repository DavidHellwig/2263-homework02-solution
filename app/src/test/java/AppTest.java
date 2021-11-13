import edu.isu.cs.cs2263.hw02.App;
import edu.isu.cs.cs2263.hw02.data.Course;
import lombok.ToString;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.testfx.framework.junit5.ApplicationTest;

/**
 * @author David Hellwig
 */

public class AppTest extends ApplicationTest{

    App Apple;



    @BeforeAll
    public void setup(){
        Apple = new App();
    }




}
