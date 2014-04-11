/********************************************************
 *
 *  Project :  AcmeNote
 *  File    :  Course.java
 *  Name    :  Matthew Harker
 *  Date    :  2014.03.24
 *
 *  Description : The Course class contains a string for the course and an array list of section objects. Includes accessor and mutator methods and an overridden toString method.
 *
 *  Changes :  2014.03.27 by Shaun Christensen. Added check for empty string for courseName in setCourseName. Sets default course name if the string is empty. Added javadoc comments, cleaned up formatting of source code, and added header comment.
 *
 ********************************************************/

package acmeNote;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * <tt>Course</tt> class contains a <tt>String</tt> object for section name and an <tt>ArrayList</tt> of <tt>Section</tt> objects.
 * 
 * @author Matthew Harker
 */
public final class Course implements Serializable
{
	// fields

	/**
	 * Serial version ID for serialization of <tt>Course</tt> object.
	 */
	private static final long serialVersionUID = 8126590303550641483L;

	/**
	 * <tt>String</tt> object containing course name.
	 */
	private String courseName;

	/**
	 * <tt>ArrayList</tt> object containing <tt>Section</tt> objects.
	 */
	private ArrayList<Section> sections;

	// constructors
	
	/**
	 * No argument default constructor.
	 */
	public Course()
	{
		this("");
	}

	/**
	 * Parameterized constructor with courseName argument.
	 * @param courseName <tt>String</tt> object containing course name.
	 */
	public Course(String courseName)
	{
		setCourseName(courseName);

		sections = new ArrayList<Section>();
	}

	// accessors

	/**
	 * Return course name.
	 * 
	 * @return <tt>String</tt> object containing course name. 
	 */
	public String getCourseName()
	{
		return courseName;
	}

	/**
	 * Return sections.
	 * 
	 * @return <tt>ArrayList</tt> object containing <tt>Section</tt> objects.
	 */
	public ArrayList<Section> getSections()
	{
		return sections;
	}

	/**
	 * Return section object.
	 * 
	 * @param index <tt>int</tt> value of <tt>Section</tt> object within the <tt>ArrayList</tt> of sections.  
	 * @return <tt>Section</tt> object.
	 */
	public Section getSection(int index)
	{
		return sections.get(index);
	}

	/**
	 * Overridden toString method returns <tt>String</tt> object containing course name.
	 */
	@Override
	public String toString()
	{
		return getCourseName();
	}

	// mutators

	/**
	 * Set course name.
	 * 
	 * @param sectionName <tt>String</tt> object containing course name.
	 * @return <tt>boolean</tt> value of set operation.
	 */
	public boolean setCourseName(String courseName)
	{
		if (courseName.equals(""))
		{
			this.courseName = "Untitled Course";
		}
		else
		{
			this.courseName = courseName;
		}

		return true;
	}

	/**
	 * Set <tt>ArrayList</tt> of <tt>Section</tt> objects.
	 * 
	 * @param notes <tt>ArrayList</tt> of <tt>Section</tt> objects.
	 * @return <tt>boolean</tt> value of set operation.
	 */
	public boolean setSections(ArrayList<Section> sections)
	{
		this.sections = sections;

		return true;
	}
	
	/**
	 * Add <tt>Section</tt> object to <tt>ArrayList</tt>.
	 * 
	 * @param note <tt>Section</tt> object.
	 * @return <tt>boolean</tt> value of set operation.
	 */
	public boolean addSection(Section section)
	{
		getSections().add(section);

		return true;
	}
	
	/**
	 * Remove <tt>Section</tt> object from <tt>ArrayList</tt>.
	 * 
	 * @param index <tt>int</tt> value of <tt>Section</tt> object in <tt>ArrayList</tt>.
	 * @return <tt>boolean</tt> value of set operation.
	 */
	public boolean removeSection(int index)
	{
		try
		{
			getSections().remove(index);
		}
		catch (IndexOutOfBoundsException e)
		{
			return false;
		}

		return true;
	}
	
	/**
	 * Set <tt>Section</tt> object in <tt>ArrayList</tt>.
	 * 
	 * @param index <tt>int</tt> value of <tt>Section</tt> object in <tt>ArrayList</tt>.
	 * @param note <tt>Section</tt> object to set in <tt>ArrayList</tt>.
	 * @return <tt>boolean</tt> value of set operation.
	 */
	public boolean setSection(int index, Section section)
	{
		try
		{
			getSections().set(index, section);
		}
		catch (IndexOutOfBoundsException e)
		{
			return false;
		}

		return true;
	}
}