import edu.isu.cs.cs2263.hw02.App;
import edu.isu.cs.cs2263.hw02.data.Course;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import lombok.ToString;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.testfx.api.FxAssert;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.framework.junit5.Start;
import org.testfx.api.FxAssert.*;
import java.util.concurrent.TimeoutException;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.api.FxRobot;
import org.testfx.assertions.api.Assertions;
import org.testfx.matcher.control.LabeledMatchers.*;
import org.testfx.matcher.control.ListViewMatchers;
import org.testfx.util.WaitForAsyncUtils;
import static org.testfx.api.FxAssert.verifyThat;

/**
 * @author David Hellwig
 */


public class AppTest extends ApplicationTest{

    @BeforeEach
    public void setUp() throws Exception {
        ApplicationTest.launch(App.class);
    }

    @Override
    public void start(Stage stage){
        stage.show();
    }

    @AfterEach
    public void reset() throws TimeoutException{
        FxToolkit.hideStage();
        release(new KeyCode[]{});
        release(new MouseButton[]{});
    }

    @Test
    public void testPaneVisible(){
        verifyThat("#display", Node::isVisible);
    }







}
