import edu.isu.cs.cs2263.hw02.data.Course;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author David Hellwig
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CourseTest {

    private Course course;
    /**
     * This is utterly stupid, BeforeAll and AfterAll will not work so I have to it the wrong way for now
     */

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

    @Test
    public void testGetCode(){

        assertEquals("123", course.getCode());
    }

    @Test
    public void testGetCredits(){
        assertEquals(4, course.getCredits());
    }

    @Test
    public void testGetNumber(){
        assertEquals(1, course.getNumber());
    }

    @Test
    public void testSetNumber(){
        course.setNumber(420);
        assertEquals(420, course.getNumber());
    }

    @Test
    public void testGetName(){
        assertEquals("test", course.getName());
    }

    @Test
    public void testSetCredits(){
        course.setCredits(20);
        assertEquals(20, course.getCredits());
    }

    @Test
    public void testSetCode(){
        course.setCode("321");
        assertEquals("321", course.getCode());
    }

    @Test
    public void testToString(){
        assertEquals("123 1 test (4)", course.toString());
    }

    @Test
    public void testSetName(){
        course.setName("This is the wrong way to test");
        assertEquals("This is the wrong way to test", course.getName());
    }

    @Test
    public void testConstructor(){
        Course test = new Course();
        assertNotNull(test);
    }


}
