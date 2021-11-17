import edu.isu.cs.cs2263.hw02.App;
import edu.isu.cs.cs2263.hw02.data.Course;
import edu.isu.cs.cs2263.hw02.views.DisplayListView;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

/**
 * @author David Hellwig
 */

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DisplayListViewTest {
    private DisplayListView ds;

    @BeforeAll
    public void setUp(){
        App mockApp = mock(App.class);
        ds = new DisplayListView(mockApp);
    }

}
