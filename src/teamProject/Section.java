package teamProject;

import java.io.Serializable;
import java.util.ArrayList;

public class Section implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String sectionName;
	private ArrayList<Note> notes;
	
	// No argument constructor
	public Section()
	{
		// Call parameterized constructor with empty String as argument
		this( "" );
	}
	
	// Parameterized constructor with String argument
	public Section( String sectionName )
	{
		notes = new ArrayList<Note>();
		setSectionName( sectionName );		
	}
	
	public boolean setSectionName( String sectionName )
	{
		this.sectionName = sectionName;
		return true;
	}
	
	public String getSectionName()
	{
		return sectionName;
	}
	
	public ArrayList<Note> getNotes()
	{
		return notes;
	}
	
	/*
	 I am not sure that I implemented this method as intended.
	 The class diagram does not specify an argument.
	 But I put one in that I thought made sense.
	 However, this may not have been what was intended.
	 */
	public boolean setNotes( ArrayList<Note> notes )
	{
		this.notes = notes;
		return true;
	}

	public boolean addNote( Note note )
	{
		getNotes().add( note );
		return true;
	}
	
	public boolean removeNote( int index )
	{
		getNotes().remove( index );
		return true;
	}
	
	public boolean setNote( int index, Note note )
	{
		getNotes().set( index, note );
		return true;
	}
	
	public Note getNote( int index )
	{
		return getNotes().get( index );
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append( "Section: " + getSectionName() );
		for (Note item : getNotes() )
		{
			sb.append( "\n\t\t\t" + item.toString() );
		}
		return  sb.toString();
	}
}