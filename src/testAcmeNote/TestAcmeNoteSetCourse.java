package testAcmeNote;

import acmeNote.AcmeNote;
import acmeNote.Course;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestAcmeNoteSetCourse
{
	@Test
	public void test()
	{
		AcmeNote acmeNote = new AcmeNote();

		acmeNote.getCourses().add(new Course());

		assertTrue(acmeNote.setCourse(0, new Course("Course Name")));
		assertEquals("Course Name", acmeNote.getCourse(0).getCourseName());
	}
}