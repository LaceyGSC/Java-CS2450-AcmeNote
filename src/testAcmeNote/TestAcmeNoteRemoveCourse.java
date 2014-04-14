package testAcmeNote;

import acmeNote.AcmeNote;
import acmeNote.Course;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestAcmeNoteRemoveCourse
{
	@Test
	public void test()
	{
		AcmeNote acmeNote = new AcmeNote();

		acmeNote.getCourses().add(new Course());

		assertEquals(1, acmeNote.getCourses().size());
		assertTrue(acmeNote.removeCourse(0));
		assertEquals(0, acmeNote.getCourses().size());
	}
}