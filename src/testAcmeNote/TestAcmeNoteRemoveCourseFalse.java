package testAcmeNote;

import acmeNote.AcmeNote;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestAcmeNoteRemoveCourseFalse
{
	@Test
	public void test()
	{
		AcmeNote acmeNote = new AcmeNote();

		assertFalse(acmeNote.removeCourse(0));
	}
}