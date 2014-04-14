package testNote;

import acmeNote.Note;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestNoteToString
{
	@Test
	public void test()
	{
		Note note = new Note();

		assertEquals("Untitled Note", note.toString());
	}
}