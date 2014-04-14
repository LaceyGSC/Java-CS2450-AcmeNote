package testCourse;

import acmeNote.Course;
import acmeNote.Section;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestCourseAddSection
{
	@Test
	public void test()
	{
		Course course = new Course();

		assertEquals(0, course.getSections().size());
		assertTrue(course.getSections().add(new Section()));
		assertEquals(1, course.getSections().size());
		assertEquals("Untitled Section", course.getSection(0).getSectionName());
	}
}