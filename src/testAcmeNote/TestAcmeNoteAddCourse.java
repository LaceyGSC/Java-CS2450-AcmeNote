package testAcmeNote;

import acmeNote.AcmeNote;
import acmeNote.Course;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TestAcmeNoteAddCourse
{
	@Test
	public void test()
	{
		AcmeNote acmeNote = new AcmeNote();

		assertEquals(0, acmeNote.getCourses().size());
		assertTrue(acmeNote.getCourses().add(new Course()));
		assertEquals(1, acmeNote.getCourses().size());
		assertEquals("Untitled Course", acmeNote.getCourse(0).getCourseName());
	}
}