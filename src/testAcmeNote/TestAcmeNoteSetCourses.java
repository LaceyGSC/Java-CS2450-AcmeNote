package testAcmeNote;

import acmeNote.AcmeNote;
import acmeNote.Course;
import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestAcmeNoteSetCourses
{
	@Test
	public void test()
	{
		AcmeNote acmeNote = new AcmeNote();

		assertEquals(0, acmeNote.getCourses().size());

		ArrayList<Course> courses = new ArrayList<Course>();

		courses.add(new Course());

		assertTrue(acmeNote.setCourses(courses));
		assertEquals(1, acmeNote.getCourses().size());
		assertEquals("Untitled Course", acmeNote.getCourse(0).getCourseName());
	}
}