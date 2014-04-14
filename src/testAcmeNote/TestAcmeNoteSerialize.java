package testAcmeNote;

import acmeNote.AcmeNote;
import acmeNote.Course;
import java.io.File;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestAcmeNoteSerialize
{
	@Test
	public void test()
	{
		AcmeNote acmeNote = new AcmeNote();

		acmeNote.addCourse(new Course());

		assertEquals(1, acmeNote.getCourses().size());

		acmeNote.serialize();

		assertTrue(acmeNote.setCourses(null));
		assertEquals(null, acmeNote.getCourses());

		acmeNote.deserialize();

		assertNotEquals(null, acmeNote.getCourses());
		assertEquals(1, acmeNote.getCourses().size());

		File file = new File("AcmeNote.ser");
		file.delete();
	}
}