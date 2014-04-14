package testCourse;

import acmeNote.Course;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestCourseRemoveSectionFalse
{
	@Test
	public void test()
	{
		Course course = new Course();

		assertFalse(course.removeSection(0));
	}
}