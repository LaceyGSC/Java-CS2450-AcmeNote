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
 *             2014.03.30 by Shaun Christensen. Added method stubs for graphical user interface.
 *
 ********************************************************/

package acmeNote;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * <tt>AcmeNote</tt> class contains an <tt>ArrayList</tt> of <tt>Course</tt> objects.
 * @author Matthew Harker
 */
public class AcmeNote extends JFrame implements ActionListener, ListSelectionListener, WindowListener
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
		arrayListDeserialize();
		arrayListCopy();
		graphicalUserInterfaceCreate();
		actionListenersAdd();
		listSelectionListenersAdd();
		windowListenersAdd();
	}

	// accessor methods

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

	// mutator methods

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

	// serialization methods

	/**
	 * Writes <tt>ArrayList</tt> of courses, sections, and notes to disk.
	 */
	@SuppressWarnings("unchecked")
	public void arrayListDeserialize()
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
	public void arrayListSerialize()
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

	// graphical user interface methods

	private void arrayListCopy()
	{
	}

	private void arrayListSearch()
	{
	}

	private void arrayListSort()
	{
	}

	private void graphicalUserInterfaceCreate()
	{
	}

	private JMenuBar menuCreate()
	{
		return new JMenuBar();
	}

	private JPanel cardsCreate()
	{
		return new JPanel();
	}

	// add methods for each panel

/*
	private JPanel panelNull()
	{
		return new JPanel();
	}

	private JPanel panelCourseAdd()
	{
		return new JPanel();
	}

	private JPanel panelCourseDelete()
	{
		return new JPanel();
	}

	private JPanel panelCourseEdit()
	{
		return new JPanel();
	}

	private JPanel panelSectionAdd()
	{
		return new JPanel();
	}

	private JPanel panelSectionDelete()
	{
		return new JPanel();
	}

	private JPanel panelSectionEdit()
	{
		return new JPanel();
	}

	private JPanel panelNoteAdd()
	{
		return new JPanel();
	}

	private JPanel panelNoteDelete()
	{
		return new JPanel();
	}

	private JPanel panelNoteEdit()
	{
		return new JPanel();
	}
*/

	private void listNotesSetListData()
	{
	}

	private void fieldsClear()
	{
	}

	private void fieldsCopy()
	{
	}

	private void fieldsValidate()
	{
	}

	// export javadoc method?

/*
	private URI javadocCreate() throws IOException, URISyntaxException
	{
		return new URI();
	}
*/

	// register event listeners

	private void actionListenersAdd()
	{
	}

	private void listSelectionListenersAdd()
	{
	}

	private void windowListenersAdd()
	{
	}

	// action event listeners

	@Override
	public void actionPerformed(ActionEvent e)
	{
	}

	// list selection listeners

	@Override
	public void valueChanged(ListSelectionEvent e)
	{
	}

	// window event listeners

	@Override
	public void windowActivated(WindowEvent e)
	{
	}

	@Override
	public void windowClosed(WindowEvent e)
	{
	}

	@Override
	public void windowClosing(WindowEvent e)
	{
		arrayListSerialize();
	}

	@Override
	public void windowDeactivated(WindowEvent e)
	{
	}

	@Override
	public void windowDeiconified(WindowEvent e)
	{
	}

	@Override
	public void windowIconified(WindowEvent e)
	{
	}

	@Override
	public void windowOpened(WindowEvent e)
	{
	}
}