package testAcmeNote;

import acmeNote.AcmeNote;
import acmeNote.Course;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestAcmeNoteSetCourseFalse
{
	@Test
	public void test()
	{
		AcmeNote acmeNote = new AcmeNote();

		assertFalse(acmeNote.setCourse(0, new Course()));
	}
}