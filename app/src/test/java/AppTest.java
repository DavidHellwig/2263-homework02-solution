import edu.isu.cs.cs2263.hw02.App;
import edu.isu.cs.cs2263.hw02.data.Course;
import javafx.application.Platform;
import javafx.scene.Node;
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
import org.testfx.matcher.control.LabeledMatchers;
import org.testfx.util.WaitForAsyncUtils;

/**
 * @author David Hellwig
 */


public class AppTest extends ApplicationTest{

    @BeforeEach
    public void runAppToTests() throws Exception {
        FxToolkit.registerPrimaryStage();
        FxToolkit.setupApplication(App::new);
        FxToolkit.showStage();
        WaitForAsyncUtils.waitForFxEvents(100);
    }

    @AfterEach
    public void stopApp() throws TimeoutException {
        FxToolkit.cleanupStages();
    }

    @Test
    public void fuck(FxRobot r){
        FxAssert.verifyThat(".display", LabeledMatchers.hasText("Display (dept.)"));
    }







}
