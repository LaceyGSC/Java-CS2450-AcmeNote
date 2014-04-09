/********************************************************
 *
 *  Project :  AcmeNote
 *  File    :  Section.java
 *  Name    :  Matthew Harker
 *  Date    :  2014.03.24
 *
 *  Description : The Section class contains a string for the name and an array list of note objects. Includes accessor and mutator methods and an overridden toString method.
 *
 *  Changes :  2014.03.27 by Shaun Christensen. Added check for empty string for sectionName in setSectionName. Sets default section name if the string is empty. Added javadoc comments, cleaned up formatting of source code, and added header comment.
 *
 ********************************************************/

package acmeNote;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * <tt>Section</tt> class contains a <tt>String</tt> object for section name and an <tt>ArrayList</tt> of <tt>Note</tt> objects.
 * @author Matthew Harker
 */
public class Section implements Serializable
{
	// fields

	/**
	 * Serial version ID for serialization of <tt>Section</tt> object.
	 */
	private static final long serialVersionUID = 2373572479357103323L;

	/**
	 * <tt>String</tt> object containing section name.
	 */
	private String sectionName;

	/**
	 * <tt>ArrayList</tt> object containing <tt>Note</tt> objects.
	 */
	private ArrayList<Note> notes;

	// constructors

	/**
	 * No argument default constructor.
	 */
	public Section()
	{
		this("");
	}

	/**
	 * Parameterized constructor with sectionName argument.
	 * @param noteName <tt>String</tt> object containing section name.
	 */
	public Section(String sectionName)
	{
		setSectionName(sectionName);

		notes = new ArrayList<Note>();
	}

	// accessors

	/**
	 * Return section name.
	 * @return <tt>String</tt> object containing section name. 
	 */
	public String getSectionName()
	{
		return sectionName;
	}

	/**
	 * Return notes.
	 * @return <tt>ArrayList</tt> object containing <tt>Note</tt> objects.
	 */
	public ArrayList<Note> getNotes()
	{
		return notes;
	}

	/**
	 * Return note object.
	 * @param index <tt>int</tt> value of <tt>Note</tt> object within the <tt>ArrayList</tt> of notes.  
	 * @return <tt>Note</tt> object.
	 */
	public Note getNote(int index)
	{
		return getNotes().get(index);
	}

	/**
	 * Overridden toString method returns <tt>String</tt> object containing section name.
	 */
	@Override
	public String toString()
	{
		return getSectionName();
	}

	// mutators

	/**
	 * Set section name.
	 * @param sectionName <tt>String</tt> object containing section name.
	 * @return <tt>boolean</tt> value of set operation.
	 */
	public boolean setSectionName(String sectionName)
	{
		if (sectionName.equals(""))
		{
			this.sectionName = "Untitled Section";
		}
		else
		{
			this.sectionName = sectionName;
		}

		return true;
	}

	/**
	 * Set <tt>ArrayList</tt> of <tt>Note</tt> objects.
	 * @param notes <tt>ArrayList</tt> of <tt>Note</tt> objects.
	 * @return <tt>boolean</tt> value of set operation.
	 */
	public boolean setNotes(ArrayList<Note> notes)
	{
		this.notes = notes;

		return true;
	}

	/**
	 * Add <tt>Note</tt> object to <tt>ArrayList</tt>.
	 * @param note <tt>Note</tt> object.
	 * @return <tt>boolean</tt> value of set operation.
	 */
	public boolean addNote(Note note)
	{
		getNotes().add(note);

		return true;
	}

	/**
	 * Remove <tt>Note</tt> object from <tt>ArrayList</tt>.
	 * @param index <tt>int</tt> value of <tt>Note</tt> object in <tt>ArrayList</tt>.
	 * @return <tt>boolean</tt> value of set operation.
	 */
	public boolean removeNote(int index)
	{
		try
		{
			getNotes().remove(index);
		}
		catch (IndexOutOfBoundsException e)
		{
			return false;
		}

		return true;
	}

	/**
	 * Set <tt>Note</tt> object in <tt>ArrayList</tt>.
	 * @param index <tt>int</tt> value of <tt>Note</tt> object in <tt>ArrayList</tt>.
	 * @param note <tt>Note</tt> object to set in <tt>ArrayList</tt>.
	 * @return <tt>boolean</tt> value of set operation.
	 */
	public boolean setNote(int index, Note note)
	{
		try
		{
			getNotes().set(index, note);
		}
		catch (IndexOutOfBoundsException e)
		{
			return false;
		}

		return true;
	}
}