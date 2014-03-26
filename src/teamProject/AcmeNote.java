package teamProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class AcmeNote
{
	private File filePath = new File( "src/teamProject/AcmeNote.ser" );
	private ArrayList<Course> courses;
	
	// No argument constructor
	public AcmeNote()
	{
		try
		{
			deserialize();
		} catch ( IOException | ClassNotFoundException ex )
		{
			System.out.println( "Resseting AcmeNote's library to new library" );
			courses = new ArrayList<Course>();
		}
	}
	
	public boolean setCourses( ArrayList<Course> courses )
	{
		this.courses = courses;
		return true;
	}
	
	public ArrayList<Course> getCourses()
	{
		return courses;
	}
	
	public boolean addCourse( Course course )
	{
		getCourses().add( course );
		return true;
	}
	
	public boolean removeCourse( int index )
	{
		getCourses().remove( index );
		return true;
	}
	
	public boolean setCourse( int index, Course course )
	{
		getCourses().set( index, course );
		return true;
	}
	
	public Course getCourse( int index )
	{
		return getCourses().get( index );
	}
	
	public void deserialize() throws IOException, ClassNotFoundException
	{
		try ( ObjectInputStream in = new ObjectInputStream( new FileInputStream( filePath ) ) )
		{
			setCourses( ( ArrayList<Course> ) in.readObject() );
		} catch ( IOException | ClassNotFoundException ex )
		{
			System.out.println( "A problem occurred during deserialization" );
			System.out.println(  ex.getMessage() );
			throw ex;
		}
	}
	
	public void serialize()
	{
		try ( ObjectOutputStream out = new ObjectOutputStream( new FileOutputStream( filePath ) ) )
		{
			out.writeObject( courses );
		} catch ( IOException ex )
		{
			System.out.println( "A problem occurred during serialization" );
			System.out.println(  ex.getMessage() );
		}
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append( "AcmeNote consists of the following:" );
		for( Course item : getCourses() )
		{
			sb.append( "\n\t" + item.toString() );
		}
		return sb.toString();
	}
}
