package testCourse;

import acmeNote.Course;
import acmeNote.Section;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestCourseRemoveSection
{
	@Test
	public void test()
	{
		Course course = new Course();

		course.getSections().add(new Section());

		assertEquals(1, course.getSections().size());
		assertTrue(course.removeSection(0));
		assertEquals(0, course.getSections().size());
	}
}