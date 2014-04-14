package testSection;

import acmeNote.Section;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestSectionDefaultConstructor
{
	@Test
	public void test()
	{
		Section section = new Section();

		assertEquals("Untitled Section", section.getSectionName());
	}
}