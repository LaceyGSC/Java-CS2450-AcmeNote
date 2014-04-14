package testSection;

import acmeNote.Section;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestSectionSetSectionName
{
	@Test
	public void test()
	{
		Section section = new Section();

		assertTrue(section.setSectionName("Section Name"));
		assertEquals("Section Name", section.getSectionName());
	}
}