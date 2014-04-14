package testCourse;

import acmeNote.Course;
import acmeNote.Section;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestCourseSetSection
{
	@Test
	public void test()
	{
		Course course = new Course();

		course.getSections().add(new Section());

		assertTrue(course.setSection(0, new Section("Section Name")));
		assertEquals("Section Name", course.getSection(0).getSectionName());
	}
}