import edu.isu.cs.cs2263.hw02.data.Course;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author David Hellwig
 */

public class CourseTest {


    /**
     * This is utterly stupid, BeforeAll and AfterAll will not work so I have to it the wrong way for now
     */
    @Test
    public void testGetCode(){
        Course course = new Course("test", "123", 1, 4);
        assertEquals("123", course.getCode());
    }

    @Test
    public void testGetCredits(){
        Course course = new Course("test", "123", 1, 4);
        assertEquals(4, course.getCredits());
    }

    @Test
    public void testGetNumber(){
        Course course = new Course("test", "123", 1, 4);
        assertEquals(1, course.getNumber());
    }

    @Test
    public void testSetNumber(){
        Course course = new Course("test", "123", 1, 4);
        course.setNumber(420);
        assertEquals(420, course.getNumber());
    }

    @Test
    public void testGetName(){
        Course course = new Course("test", "123", 1, 4);
        assertEquals("test", course.getName());
    }

    @Test
    public void testSetCredits(){
        Course course = new Course("test", "123", 1, 4);
        course.setCredits(20);
        assertEquals(20, course.getCredits());
    }

    @Test
    public void testSetCode(){
        Course course = new Course("test", "123", 1, 4);
        course.setCode("321");
        assertEquals("321", course.getCode());
    }

    @Test
    public void testToString(){
        Course course = new Course("test", "123", 1, 4);
        assertEquals("123 1 test (4)", course.toString());
    }

    @Test
    public void testSetName(){
        Course course = new Course("test", "123", 1, 4);
        course.setName("This is the wrong way to test");
        assertEquals("This is the wrong way to test", course.getName());
    }

    @Test
    public void testConstructor(){
        Course test = new Course();
        assertNotNull(test);
    }
    

}
