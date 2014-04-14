package testCourse;

import acmeNote.Course;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestCourseToString
{
	@Test
	public void test()
	{
		Course course = new Course();

		assertEquals("Untitled Course", course.toString());
	}
}