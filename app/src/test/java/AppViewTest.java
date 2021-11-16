import edu.isu.cs.cs2263.hw02.App;
import edu.isu.cs.cs2263.hw02.views.AppView;
import javafx.scene.Node;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import static org.mockito.Mockito.*;

import org.testfx.api.FxAssert;
import org.testfx.assertions.api.*;
import static org.junit.jupiter.api.Assertions.*;


/**
 * @author David Hellwig
 */

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AppViewTest {

    private App app;

    private AppView appView;


    @BeforeAll
    public void setUp(){

        appView = new AppView(app) {
           @Override
           public void initView() {

           }

           @Override
           public void updateData() {

           }
       };

    }

    /**
     * Test to see if appview even exists
     */
    @Test
    public void testConstructor(){
        assertNotNull(appView);


    }

    @Test
    public void testGetView(){
        AppView mockedView = mock(AppView.class);
        Node node = mockedView.getView();
        assertNull(node);

    }

}

