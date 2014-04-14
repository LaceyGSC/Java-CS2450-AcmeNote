package testSection;

import acmeNote.Note;
import acmeNote.Section;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestSectionSetNote
{
	@Test
	public void test()
	{
		Section section = new Section();

		section.getNotes().add(new Note());

		assertTrue(section.setNote(0, new Note("Note Name", "Note Text")));
		assertEquals("Note Name", section.getNote(0).getNoteName());
		assertEquals("Note Text", section.getNote(0).getNoteText());
	}
}