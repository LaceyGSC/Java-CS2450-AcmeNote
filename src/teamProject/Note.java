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
		// Call parameterized constructor with empty string as argument
		this( "" );
	}
	
	// Parameterized constructor 
	public Note( String noteName )
	{
		//call setNoteName method with noteName argument
		setNoteName( noteName );
		//call setNoteText method with empty string as argument
		setNoteText( "" );
	}
	
	public void setNoteName( String noteName )
	{
		//set noteName
		this.noteName = noteName;
	}
	
	public String getNoteName()
	{
		return noteName;
	}
	
	public void setNoteText( String noteText )
	{
		this.noteText = noteText;
	}
	
	public String toString()
	{
		return "Note: " + getNoteName();
	}
}
