package testAcmeNote;

import acmeNote.AcmeNote;
import java.io.File;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestAcmeNoteDefaultConstructor
{
	@Test
	public void test()
	{
		AcmeNote acmeNote = new AcmeNote();

		assertEquals(0, acmeNote.getCourses().size());

		File file = new File("AcmeNote.ser");
		file.delete();
	}
}