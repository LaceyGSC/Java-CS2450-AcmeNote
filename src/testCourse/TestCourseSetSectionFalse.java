package testCourse;

import acmeNote.Course;
import acmeNote.Section;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestCourseSetSectionFalse
{
	@Test
	public void test()
	{
		Course course = new Course();

		assertFalse(course.setSection(0, new Section()));
	}
}