package teamProject;

import java.io.Serializable;
import java.util.ArrayList;

public class Course implements Serializable
{
	private static final long	serialVersionUID	= 1L;
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
	 I am not sure that I implemented this method as intended.
	 The class diagram does not specify an argument.
	 But I put one in that I thought made sense.
	 However, this may not have been what was intended.
	 */
	public boolean setSections( ArrayList<Section> sections )
	{
		this.sections = sections;
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
		return sections.get( index );
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append( "Course: " + getCourseName() );
		for( Section item : getSections() )
		{
			sb.append( "\n\t\t" + item.toString() );
		}
		return sb.toString();
	}
}
