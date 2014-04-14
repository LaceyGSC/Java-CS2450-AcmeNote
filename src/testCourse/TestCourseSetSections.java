package testCourse;

import acmeNote.Course;
import acmeNote.Section;
import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestCourseSetSections
{
	@Test
	public void test()
	{
		Course course = new Course();

		assertEquals(0, course.getSections().size());

		ArrayList<Section> sections = new ArrayList<Section>();

		sections.add(new Section());

		assertTrue(course.setSections(sections));
		assertEquals(1, course.getSections().size());
		assertEquals("Untitled Section", course.getSection(0).getSectionName());
	}
}