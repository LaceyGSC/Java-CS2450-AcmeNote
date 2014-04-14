package testSection;

import acmeNote.Section;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestSectionParameterizedConstructor
{
	@Test
	public void test()
	{
		Section section = new Section("Section Name");

		assertEquals("Section Name", section.getSectionName());
	}
}