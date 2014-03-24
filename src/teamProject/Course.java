package teamProject;

import java.io.Serializable;
import java.util.ArrayList;

public class Course implements Serializable
{
	private String courseName;
	private ArrayList<Section> sections;
	
	// No argument constructor
	public Course()
	{
		// Call parameterized constructor with empty string as argument
		this( "" );
	}
	
	// Parameterized constructor
	public Course( String courseName )
	{
		sections = new ArrayList<Section>();
		setCourseName( courseName );
	}
	
	public boolean setCourseName( String courseName )
	{
		this.courseName = courseName;
		return true;
	}
	
	public String getCourseName()
	{
		return courseName;
	}
	
	/*
	 I am not sure what this method is supposed to do.
	 The class diagram does not specify any arguments.
	 The class diagram specifies that it return a boolean,
	 so I made it return true. However, this method should
	 be fixed to do something or else it should be removed.
	 */
	public boolean setSection()
	{
		return true;
	}
	
	public ArrayList<Section> getSections()
	{
		return sections;
	}
	
	public boolean addSection( Section section )
	{
		getSections().add( section );
		return true;
	}
	
	public boolean removeSection( int index )
	{
		getSections().remove( index );
		return true;
	}
	
	public boolean setSection( int index, Section section )
	{
		getSections().set( index, section );
		return true;
	}
	
	public Section getSection( int index )
	{
		return getSection( index );
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append( "Course named: " + getCourseName() + ", with the following Sections" );
		for( Section item : getSections() )
		{
			sb.append( "\n\t" + item.toString() );
		}
		return sb.toString();
	}
}
