package testAcmeNote;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	TestAcmeNoteDefaultConstructor.class,
	TestAcmeNoteSetCourses.class,
	TestAcmeNoteAddCourse.class,
	TestAcmeNoteRemoveCourse.class,
	TestAcmeNoteRemoveCourseFalse.class,
	TestAcmeNoteSetCourse.class,
	TestAcmeNoteSetCourseFalse.class,
	TestAcmeNoteSerialize.class
})

public class TestSuite
{
}