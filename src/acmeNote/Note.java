/********************************************************
 *
 *  Project :  AcmeNote
 *  File    :  Note.java
 *  Name    :  Matthew Harker
 *  Date    :  2014.03.24
 *
 *  Description : The Note class contains a string for the name and text of the note. Includes accessor and mutator methods and an overridden toString method.
 *
 *  Changes :  2014.03.27 by Shaun Christensen. Added check for empty string for noteName in setNoteName. Sets default note name if the string is empty. Added javadoc comments, cleaned up source code to SLCC coding standards, and added header comment.
 *
 ********************************************************/

package acmeNote;

import java.io.Serializable;

/**
 * <tt>Note</tt> class contains <tt>String</tt> objects for note name and note text.
 * @author Matthew Harker
 */
public class Note implements Serializable
{
	// fields

	/**
	 * Serial version ID for serialization of <tt>Note</tt> object.
	 */
	private static final long serialVersionUID = -6279758459232355828L;

	/**
	 * <tt>String</tt> object containing note name.
	 */
	private String noteName;

	/**
	 * <tt>String</tt> object containing note text.
	 */
	private String noteText;

	// constructors
	
	/**
	 * No argument default constructor.
	 */
	public Note()
	{
		this("", "");
	}

	/**
	 * Parameterized constructor with noteName and noteText arguments.
	 * @param noteName <tt>String</tt> object containing note name.
	 * @param noteText <tt>String</tt> object containing note text.
	 */
	public Note(String noteName, String noteText)
	{
		setNoteName(noteName);
		setNoteText(noteText);
	}

	// accessors

	/**
	 * Return note name.
	 * @return <tt>String</tt> object containing note name. 
	 */
	public String getNoteName()
	{
		return noteName;
	}

	/**
	 * Return note text.
	 * @return <tt>String</tt> object containing note text.
	 */
	public String getNoteText()
	{
		return noteText;
	}

	/**
	 * Overridden toString method returns <tt>String</tt> object containing note name.
	 */
	@Override
	public String toString()
	{
		return getNoteName();
	}

	// mutators

	/**
	 * Set note name.
	 * @param noteName <tt>String</tt> object containing note name.
	 * @return <tt>boolean</tt> value of set operation.
	 */
	public boolean setNoteName(String noteName)
	{
		if (noteName.equals(""))
		{
			this.noteName = "Untitled Note";
		}
		else
		{
			this.noteName = noteName;
		}

		return true;
	}

	/**
	 * Set note text.
	 * @param noteText <tt>String</tt> object containing note text.
	 * @return <tt>boolean</tt> value of set operation.
	 */
	public boolean setNoteText(String noteText)
	{
		this.noteText = noteText;

		return true;
	}
}