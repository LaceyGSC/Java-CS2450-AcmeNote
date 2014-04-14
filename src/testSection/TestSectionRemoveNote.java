package testSection;

import acmeNote.Note;
import acmeNote.Section;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestSectionRemoveNote
{
	@Test
	public void test()
	{
		Section section = new Section();

		section.getNotes().add(new Note());

		assertEquals(1, section.getNotes().size());
		assertTrue(section.removeNote(0));
		assertEquals(0, section.getNotes().size());
	}
}