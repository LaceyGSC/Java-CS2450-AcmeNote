package testNote;

import acmeNote.Note;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestNoteDefaultConstructor
{
	@Test
	public void test()
	{
		Note note = new Note();

		assertEquals("Untitled Note", note.getNoteName());
		assertEquals("", note.getNoteText());
	}
}