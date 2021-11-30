import edu.isu.cs.cs2263.hw02.App;
import edu.isu.cs.cs2263.hw02.data.Course;
import org.junit.jupiter.api.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author David Hellwig
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CourseTest {
    private static final Logger logger = LogManager.getLogger(CourseTest.class);

    private Course course;

    @BeforeAll
    public void setup(){
        course = new Course("test", "123", 1, 4);
    }

    @AfterEach
    public void reset(){
        course.setName("test");
        course.setCode("123");
        course.setCredits(4);
        course.setNumber(1);
    }

    /**
     * Test for getCode method
     */
    @Test
    public void testGetCode(){
        logger.debug("testGetCode test running");

        assertEquals("123", course.getCode());

        logger.debug("expected '123' but got " + course.getCode());
    }

    /**
     * Test for getCredits method
     */
    @Test
    public void testGetCredits(){
        logger.debug("testGetCredits test running");

        assertEquals(4, course.getCredits());

        logger.debug("expected '4' but got " + course.getCredits());
    }

    /**
     * Test for getNumber method
     */
    @Test
    public void testGetNumber(){
        logger.debug("testGetNumber test running");

        assertEquals(1, course.getNumber());

        logger.debug("expected '1' but got " + course.getNumber());
    }

    /**
     * Test for setNumber method
     */
    @Test
    public void testSetNumber(){
        logger.debug("testSetNumber test running");

        int i = 420;

        course.setNumber(i);

        assertEquals(i, course.getNumber());

        logger.debug("expected " + i + "but got " + course.getNumber());
    }

    /**
     * Test for getName method
     */
    @Test
    public void testGetName(){
        logger.debug("testGetName test running");


        assertEquals("test", course.getName());

        logger.debug("exprected String 'test' but got " + course.getName());
    }

    /**
     * Test for setCredits method
     */
    @Test
    public void testSetCredits(){
        logger.debug("testSetCredits test running");

        course.setCredits(20);

        assertEquals(20, course.getCredits());
    }

    /**
     * Test for setCode method
     */
    @Test
    public void testSetCode(){
        logger.debug("testSetCode test running");

        String code = "321";

        course.setCode(code);

        assertEquals(code, course.getCode());

        logger.debug("expected " + code + "but got " + course.getCode());
    }

    /**
     * Test for toString method
     */
    @Test
    public void testToString(){
        logger.debug("testToString test running");


        String string = "123 1 test (4)";

        assertEquals(string, course.toString());

        logger.debug("expected " + string + "but got " + course.toString());
    }

    /**
     * Test for setName method
     */
    @Test
    public void testSetName(){
        logger.debug("testSetName test running");

        String string = "blert";

        course.setName(string);

        assertEquals(string, course.getName());

        logger.debug("expected " + string + "but got " + course.getName());
    }

    /**
     * Test to make sure constructor actually makes an object
     */
    @Test
    public void testConstructor(){
        logger.debug("testConstructor test running");

        Course test = new Course();

        assertNotNull(test);

        if (test == null){
            logger.warn("Constructor failed");
        }
    }




}
