package testSection;

import acmeNote.Note;
import acmeNote.Section;
import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestSectionSetNotes
{
	@Test
	public void test()
	{
		Section section = new Section();

		assertEquals(0, section.getNotes().size());

		ArrayList<Note> notes = new ArrayList<Note>();

		notes.add(new Note());

		assertTrue(section.setNotes(notes));
		assertEquals(1, section.getNotes().size());
		assertEquals("Untitled Note", section.getNote(0).getNoteName());
		assertEquals("", section.getNote(0).getNoteText());
	}
}