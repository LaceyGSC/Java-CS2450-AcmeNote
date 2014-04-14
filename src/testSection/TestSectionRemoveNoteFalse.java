package testSection;

import acmeNote.Section;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestSectionRemoveNoteFalse
{
	@Test
	public void test()
	{
		Section section = new Section();

		assertFalse(section.removeNote(0));
	}
}