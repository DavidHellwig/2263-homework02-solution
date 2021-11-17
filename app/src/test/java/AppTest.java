import edu.isu.cs.cs2263.hw02.App;
import edu.isu.cs.cs2263.hw02.data.Course;
import edu.isu.cs.cs2263.hw02.views.DisplayListView;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
import org.testfx.matcher.base.NodeMatchers;
import org.testfx.matcher.base.WindowMatchers;
import org.testfx.matcher.control.LabeledMatchers.*;
import org.testfx.matcher.control.ListViewMatchers;
import org.testfx.util.WaitForAsyncUtils;

import javax.swing.text.html.ListView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import static org.testfx.api.FxAssert.verifyThat;

/**
 * @author David Hellwig
 */


public class AppTest extends ApplicationTest{
    private static Logger logger = null;

    private FxRobot r;

    @BeforeEach
    public void setUp() throws Exception {
        System.setProperty("log4j.configurationFile","log4j2-testConfig.xml");
        logger = LogManager.getLogger();
        ApplicationTest.launch(App.class);
        r = new FxRobot();
    }

    @Override
    public void start(Stage stage) throws Exception {
        new App().start(stage);

    }

    @AfterEach
    public void reset() throws TimeoutException{
        FxToolkit.hideStage();
        release(new KeyCode[]{});
        release(new MouseButton[]{});
    }

    @Test
    public void testDisplayVisible(){
        logger.debug("Testing for visibility of Display button ");
        verifyThat(lookup("Display (dept.)"), (Button b) -> b.isVisible());
        logger.debug("Display Should be visible");
        logger.error("Display not visible");
    }

    @Test
    public void testNewCourseVisible(){
        logger.debug("Testing for visibility of New Course button ");
        verifyThat(lookup("New Course"), (Button b) -> b.isVisible());
        logger.debug("New Course Should be visible");
        logger.error("New Course not visible");
    }

    @Test
    public void testExitVisible() {
        logger.debug("Testing for visibility of Exit button ");
        verifyThat(lookup("Exit"), (Button b) -> b.isVisible());
        logger.debug("Exit Should be visible");
        logger.error("Exit not visible");
    }

    @Test
    public void testExitCreatesNewWindow(){

        r.clickOn("Exit");
        assertNotNull(lookup("OK"));
        assertNotNull(lookup("Cancel"));


    }

}
