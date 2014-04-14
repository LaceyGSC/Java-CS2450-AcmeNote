package testNote;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	TestNoteDefaultConstructor.class,
	TestNoteParameterizedConstructor.class,
	TestNoteToString.class,
	TestNoteSetNoteName.class,
	TestNoteSetNoteText.class
})

public class TestSuite
{
}