package testCourse;

import acmeNote.Course;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestCourseSetCourseName
{
	@Test
	public void test()
	{
		Course course = new Course();

		assertTrue(course.setCourseName("Course Name"));
		assertEquals("Course Name", course.getCourseName());
	}
}