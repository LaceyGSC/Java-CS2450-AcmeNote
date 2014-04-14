package testSection;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	TestSectionDefaultConstructor.class,
	TestSectionParameterizedConstructor.class,
	TestSectionToString.class,
	TestSectionSetSectionName.class,
	TestSectionSetNotes.class,
	TestSectionAddNote.class,
	TestSectionRemoveNote.class,
	TestSectionRemoveNoteFalse.class,
	TestSectionSetNote.class,
	TestSectionSetNoteFalse.class
})

public class TestSuite
{
}