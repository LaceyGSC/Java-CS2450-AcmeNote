package testNote;

import acmeNote.Note;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestNoteSetNoteName
{
	@Test
	public void test()
	{
		Note note = new Note();

		assertTrue(note.setNoteName("Note Name"));
		assertEquals("Note Name", note.getNoteName());
	}
}