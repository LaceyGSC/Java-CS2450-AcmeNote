package testNote;

import acmeNote.Note;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestNoteParameterizedConstructor
{
	@Test
	public void test()
	{
		Note note = new Note("Note Name", "Note Text");

		assertEquals("Note Name", note.getNoteName());
		assertEquals("Note Text", note.getNoteText());
	}
}