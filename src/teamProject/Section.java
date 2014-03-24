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
	
	public boolean setNotes()
	{
		return true;
	}

	public boolean addNote( Note note )
	{
		notes.add( note );
		return true;
	}
	
	public boolean removeNote( int index )
	{
		getNotes().remove( index );
		return true;
	}
	
	public boolean setNote( int index, Note note )
	{
		getNotes().add( index, note );
		return true;
	}
	
	public Note getNote( int index )
	{
		return getNotes().get( index );
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append( "Section named: " + getSectionName() + ", with the following notes");
		for (Note item : getNotes() )
		{
			sb.append( "\n\t" + item.toString() );
		}
		return  sb.toString();
	}
}