package testSection;

import acmeNote.Note;
import acmeNote.Section;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestSectionSetNoteFalse
{
	@Test
	public void test()
	{
		Section section = new Section();

		assertFalse(section.setNote(0, new Note()));
	}
}