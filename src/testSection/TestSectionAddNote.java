package testSection;

import acmeNote.Note;
import acmeNote.Section;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestSectionAddNote
{
	@Test
	public void test()
	{
		Section section = new Section();

		assertEquals(0, section.getNotes().size());
		assertTrue(section.getNotes().add(new Note()));
		assertEquals(1, section.getNotes().size());
		assertEquals("Untitled Note", section.getNote(0).getNoteName());
		assertEquals("", section.getNote(0).getNoteText());
	}
}