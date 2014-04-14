package testCourse;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	TestCourseDefaultConstructor.class,
	TestCourseParameterizedConstructor.class,
	TestCourseToString.class,
	TestCourseSetCourseName.class,
	TestCourseSetSections.class,
	TestCourseAddSection.class,
	TestCourseRemoveSection.class,
	TestCourseRemoveSectionFalse.class,
	TestCourseSetSection.class,
	TestCourseSetSectionFalse.class
})

public class TestSuite
{
}