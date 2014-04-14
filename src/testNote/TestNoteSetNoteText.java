package testNote;

import acmeNote.Note;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestNoteSetNoteText
{
	@Test
	public void test()
	{
		Note note = new Note();

		assertTrue(note.setNoteText("Note Text"));
		assertEquals("Note Text", note.getNoteText());
	}
}