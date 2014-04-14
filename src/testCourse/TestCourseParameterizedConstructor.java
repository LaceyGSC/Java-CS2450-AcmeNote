package testCourse;

import acmeNote.Course;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestCourseParameterizedConstructor
{
	@Test
	public void test()
	{
		Course course = new Course("Course Name");

		assertEquals("Course Name", course.getCourseName());
	}
}