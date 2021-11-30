import edu.isu.cs.cs2263.hw02.App;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.matcher.control.ListViewMatchers;

import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.assertions.api.Assertions.assertThat;

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

    /**
     * test if Display button is visible
     */
    @Test
    public void testDisplayVisible(){
        logger.debug("testDisplayVisible test running");
        verifyThat(lookup("Display (dept.)"), (Button b) -> b.isVisible());

        logger.debug(lookup("Display (dept.)"));

    }

    /**
     * test if New Course button is visible
     */
    @Test
    public void testNewCourseVisible(){
        logger.debug("testNewCourseVisible test running");

        verifyThat(lookup("New Course"), (Button b) -> b.isVisible());

        logger.debug(lookup("New Course"));
    }

    /**
     * test if Exit button is visible
     */
    @Test
    public void testExitVisible() {
        logger.debug("testExitVisible test running");

        verifyThat(lookup("Exit"), (Button b) -> b.isVisible());

        logger.debug(lookup("Exit"));
    }

    /**
     * test if Exit create an appropriate alert when clicked
     */
    @Test
    public void testExitCreatesNewWindow(){
        logger.debug("testExitCreatesNewWindow test running");

        r.clickOn("Exit");

        assertNotNull(lookup("OK"));

        assertNotNull(lookup("Cancel"));

        logger.debug(lookup("OK"));

        logger.debug(lookup("Cancel"));





    }


    /**
     * test to see if course view is visible
     */
    @Test
    public void testCourseViewInApp(){
        r.clickOn("Display (dept.)");

        assertNotNull(lookup("Courses"));

    }

    /**
     * test to see if course form view buttons are visible
     */
    @Test
    public void testCourseFormViewButtons(){
        r.clickOn("New Course");

        assertNotNull(lookup("Reset"));

        assertNotNull(lookup("Add Course"));


    }

    /**
     * test to see adding a course to the course list works
     */
    @Test
    public void testAddCourseThenCheckCourseList(){
        r.clickOn("New Course");

        r.clickOn("Enter a course name...");

        r.type(KeyCode.E);

        r.clickOn("Add Course");

        r.clickOn("Display (dept.)");


        assertThat(ListViewMatchers.hasItems(1));






    }

    /**
     *test if trying to add a course with no name fails
     */
    @Test
    public void testEmptyCourseName(){
        r.clickOn("New Course");

        r.clickOn("Enter a course name...");

        r.clickOn("Add Course");

        r.clickOn("Display (dept.)");

        assertThat(ListViewMatchers.hasItems(0));




    }

}
