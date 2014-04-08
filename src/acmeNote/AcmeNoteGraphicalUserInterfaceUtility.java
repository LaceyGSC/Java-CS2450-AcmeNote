/********************************************************
 *
 *  Project :  AcmeNote
 *  File    :  AcmeNoteGraphicalUserInterfaceUtility.java
 *  Name    :  Shaun Christensen
 *  Date    :  2014.04.07
 *
 *  Description : The AcmeNoteGraphicalUserInterfaceUtility class manages data processing for events triggered by the AcmeNoteGraphicalUserInterface class. Upon completion the methods will return the necessary resources back to the AcmeNoteGraphicalUserInterface class.
 *
 *  Changes :  
 *
 ********************************************************/

package acmeNote;

/**
 * <tt>AcmeNoteGraphicalUserInterfaceUtility</tt> class processes data for events triggered by the <tt>AcmeNoteGraphicalUserInterface</tt> class and returns the necessary resources to the graphical user interface.
 * @author Shaun Christensen
 */
public class AcmeNoteGraphicalUserInterfaceUtility
{
	// fields

	// add javadoc comments when complete
	private AcmeNote acmeNote;
	private String[] stringCourses;
	private String[] stringNotes;
	private String[] stringSections;

	// constructors

	/**
	 * No argument default constructor.
	 */
	public AcmeNoteGraphicalUserInterfaceUtility()
	{
		acmeNote = new AcmeNote();
	}

	/**
	 * Parameterized constructor with AcmeNote argument.
	 * @param acmeNote <tt>AcmeNote</tt> object.
	 */
	public AcmeNoteGraphicalUserInterfaceUtility(AcmeNote acmeNote)
	{
		this.acmeNote = acmeNote;
	}

	// accessors

	public String[] getStringCourses()
	{
		return stringCourses;
	}

	public String[] getStringCoursesAll()
	{
		String[] string = new String[stringCourses.length + 1];

		string[0] = "All Courses";

		System.arraycopy(stringCourses, 0, string, 1, stringCourses.length);

		return string;
	}

	public String[] getStringNotes()
	{
		return stringNotes;
	}

	public String[] getStringSections()
	{
		return stringSections;
	}

	public String[] getStringSectionsAll()
	{
		String[] string = new String[stringSections.length + 1];

		string[0] = "All Sections";

		System.arraycopy(stringSections, 0, string, 1, stringSections.length);

		return string;
	}

	// mutators

	public void setStringCourses(AcmeNote acmeNote)
	{
		stringCourses = new String[acmeNote.getCourses().size()];

		for (int i = 0; i < acmeNote.getCourses().size(); i++)
		{
			stringCourses[i] = acmeNote.getCourse(i).toString();
		}
	}

	public void setStringNotes(int courseIndex, int sectionIndex)
	{
		stringNotes = new String[0];
	}

	public void setStringSections(int courseIndex)
	{
		if (courseIndex >= 0)
		{
			stringSections = new String[acmeNote.getCourse(courseIndex).getSections().size()];

			for (int j = 0; j < acmeNote.getCourse(courseIndex).getSections().size(); j++)
			{
				stringSections[courseIndex] = acmeNote.getCourse(courseIndex).getSection(j).toString();
			}
		}
		else
		{
			stringSections = new String[0];
		}
	}
	
	
	
	

	
	public void coursesSort()
	{
	}

	public void notesSearch()
	{
	}

	public void fieldsClear()
	{
	}

	public void fieldsCopy()
	{
	}

	public void fieldsValidate()
	{
	}

	public void setListData()
	{
	}
}