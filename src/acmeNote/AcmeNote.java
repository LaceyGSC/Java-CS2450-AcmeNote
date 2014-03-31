/********************************************************
 *
 *  Project :  AcmeNote
 *  File    :  AcmeNote.java
 *  Name    :  Matthew Harker
 *  Date    :  2014.03.24
 *
 *  Description : The AcmeNote class contains an array list of course objects. The class contains the graphical user interface and
 *  associated methods.
 *
 *  Changes :  2014.03.27 by Shaun Christensen. Updated serialization methods to display a pop-up message upon error rather than print
 *  to the console. Added javadoc comments, cleaned up formatting of source code, and added header comment.
 *
 ********************************************************/

package acmeNote;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * <tt>AcmeNote</tt> class contains an <tt>ArrayList</tt> of <tt>Course</tt> objects.
 * @author Matthew Harker
 */
public class AcmeNote
{
	// fields

	/**
	 * <tt>ArrayList</tt> object containing <tt>Course</tt> objects.
	 */
	private ArrayList<Course> courses;
	
	// constructors
	
	/**
	 * No argument default constructor.
	 */
	public AcmeNote()
	{
		deserialize();
	}

	// accessors

	/**
	 * Return courses.
	 * @return <tt>ArrayList</tt> object containing <tt>Course</tt> objects.
	 */
	public ArrayList<Course> getCourses()
	{
		return courses;
	}

	/**
	 * Return course object.
	 * @param index <tt>int</tt> value of <tt>Course</tt> object within the <tt>ArrayList</tt> of sections.  
	 * @return <tt>Course</tt> object.
	 */
	public Course getCourse(int index)
	{
		return getCourses().get(index);
	}

	// mutators

	/**
	 * Set <tt>ArrayList</tt> of <tt>Course</tt> objects.
	 * @param notes <tt>ArrayList</tt> of <tt>Course</tt> objects.
	 * @return <tt>boolean</tt> value of set operation.
	 */
	public boolean setCourses(ArrayList<Course> courses)
	{
		this.courses = courses;

		return true;
	}

	/**
	 * Add <tt>Course</tt> object to <tt>ArrayList</tt>.
	 * @param note <tt>Course</tt> object.
	 * @return <tt>boolean</tt> value of set operation.
	 */
	public boolean addCourse(Course course)
	{
		getCourses().add(course);

		return true;
	}

	/**
	 * Remove <tt>Course</tt> object from <tt>ArrayList</tt>.
	 * @param index <tt>int</tt> value of <tt>Course</tt> object in <tt>ArrayList</tt>.
	 * @return <tt>boolean</tt> value of set operation.
	 */
	public boolean removeCourse(int index)
	{
		try
		{
			getCourses().remove(index);
		}
		catch (IndexOutOfBoundsException e)
		{
			return false;
		}

		return true;
	}

	/**
	 * Set <tt>Course</tt> object in <tt>ArrayList</tt>.
	 * @param index <tt>int</tt> value of <tt>Course</tt> object in <tt>ArrayList</tt>.
	 * @param note <tt>Course</tt> object to set in <tt>ArrayList</tt>.
	 * @return <tt>boolean</tt> value of set operation.
	 */
	public boolean setCourse(int index, Course course)
	{
		try
		{
			getCourses().set(index, course);
		}
		catch (IndexOutOfBoundsException e)
		{
			return false;
		}

		return true;
	}

	// serialization

	/**
	 * Writes <tt>ArrayList</tt> of courses, sections, and notes to disk.
	 */
	@SuppressWarnings("unchecked")
	public void deserialize()
	{
		try
		{
			ObjectInputStream input = null;

			File file = new File("AcmeNote.ser");

			if (file.isFile() && file.canRead())
			{
				input = new ObjectInputStream(new FileInputStream("AcmeNote.ser"));
			}

			if (input != null)
			{
				courses = (ArrayList<Course>)input.readObject();

				input.close();
			}

			if (courses == null)
			{
				courses = new ArrayList<Course>();
			}
		}
		catch (ClassNotFoundException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage(), "Class Not Found Exception", JOptionPane.ERROR_MESSAGE);
		}
		catch (NotSerializableException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage(), "Not Serializable Exception", JOptionPane.ERROR_MESSAGE);
		}
		catch (IOException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage(), "Input/Output Exception", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Reads <tt>ArrayList</tt> of courses, sections, and notes from disk.
	 */
	public void serialize()
	{
		try
		{
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("AcmeNote.ser"));

			if (output != null)
			{
				output.writeObject(courses);
				output.flush();
				output.close();
			}
		}
		catch (NotSerializableException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage(), "Not Serializable Exception", JOptionPane.ERROR_MESSAGE);
		}
		catch (IOException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage(), "Input/Output Exception", JOptionPane.ERROR_MESSAGE);
		}
	}
}