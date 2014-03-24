package teamProject;

import java.io.Serializable;

public class Note implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String noteName;
	private String noteText;
	
	// No argument constructor
	public Note()
	{
		// Call parameterized constructor with two empty strings as arguments
		this( "", "" );
	}
	
	// Parameterized constructor with one String argument
	public Note( String noteName )
	{
		//call Parameterized constructor with noteName and an empty string as argument
		this( noteName, "" );
	}
	
	// Parameterized constructor with two String arguments
	public Note( String noteName, String noteText )
	{
		setNoteName( noteName );
		setNoteText( noteText );
	}
	
	public boolean setNoteName( String noteName )
	{
		this.noteName = noteName;
		return true;
	}
	
	public String getNoteName()
	{
		return noteName;
	}
	
	public boolean setNoteText( String noteText )
	{
		this.noteText = noteText;
		return true;
	}
	
	public String getNoteText()
	{
		return noteText;
	}
	
	public String toString()
	{
		return "Note: " + getNoteName();
	}
}
