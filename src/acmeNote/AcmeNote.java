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
 *             to the console. Added javadoc comments, cleaned up formatting of source code, and added header comment.
 *             2014.03.30 by Shaun Christensen. Added method stubs for graphical user interface.
 *             2014.03.31 by Shaun Christensen. Implemented graphical user interface methods to create and launch application. Added
 *             temporary image to default null panel, then added search panel and default null panel to frame.
 *
 ********************************************************/

package acmeNote;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
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

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * <tt>AcmeNote</tt> class contains an <tt>ArrayList</tt> of <tt>Course</tt> objects.
 * @author Matthew Harker
 */
public class AcmeNote extends JFrame implements ActionListener, ListSelectionListener, WindowListener
{
	// components

	private JButton buttonCourseAddCancel;
	private JButton buttonCourseAddSubmit;
	private JButton buttonSearchCancel;
	private JButton buttonSearchSearch;
	private CardLayout cardLayout;
	private JComboBox<String> comboBoxCourses;
	private JComboBox<String> comboBoxSections;
	private JMenuItem menuItemCourseAdd;
	private JMenuItem menuItemCourseDelete;
	private JMenuItem menuItemCourseEdit;
	private JMenuItem menuItemFileQuit;
	private JMenuItem menuItemHelpAbout;
	private JMenuItem menuItemHelpDocumentation;
	private JMenuItem menuItemSectionAdd;
	private JMenuItem menuItemSectionDelete;
	private JMenuItem menuItemSectionEdit;
	private JPanel panelCards;
	private JTextField textFieldCourseAddCourseName;
	private JTextField textFieldSearch;
	private JList<String> listNotes;
	private JScrollPane scrollPaneCourseAdd;

	// fields

/*
	private String[] stringCourses;
	private String[] stringNotes;
	private String[] stringSections;
*/

	// delete me
	private String[] stringCourses = {"All Courses", "Course 1", "Course 2", "Course 3"};
	private String[] stringSections = {"All Sections", "Section 1", "Section 2", "Section 3"};
	private String[] stringNotes = {"Note 1", "Note 2", "Note 3", "Note 4", "Note 5"};

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
		graphicalUserInterfaceCreate();
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
	 * Reads <tt>ArrayList</tt> of courses, sections, and notes from disk.
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
	 * Writes <tt>ArrayList</tt> of courses, sections, and notes to disk.
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

	// graphical user interface methods

	private void graphicalUserInterfaceCreate()
	{
		coursesCopy();

		add(panelCreate());

		actionListenersAdd();
		listSelectionListenersAdd();
		windowListenersAdd();
	}

	private JPanel panelCreate()
	{
		JPanel panelMenu = new JPanel(new BorderLayout());
		panelMenu.add(menuCreate(), BorderLayout.NORTH);

		JPanel panelContent = new JPanel(new BorderLayout());
		panelContent.add((panelSearch()), BorderLayout.WEST);
		panelContent.add(boxSeparator(), BorderLayout.CENTER);
		panelContent.add(panelCards(), BorderLayout.EAST);
		panelContent.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		JPanel panel = new JPanel(new BorderLayout());
		panel.add(panelMenu, BorderLayout.NORTH);
		panel.add(panelContent, BorderLayout.CENTER);

		return panel;
	}

	private JMenuBar menuCreate()
	{
		JMenuBar menuBar = new JMenuBar();
		JMenu menu;

		menuItemFileQuit = new JMenuItem("Quit", KeyEvent.VK_Q);
		menuItemCourseAdd = new JMenuItem("Add", KeyEvent.VK_O);
		menuItemCourseDelete = new JMenuItem("Delete", KeyEvent.VK_L);
		menuItemCourseEdit = new JMenuItem("Edit", KeyEvent.VK_E);
		menuItemSectionAdd = new JMenuItem("Add", KeyEvent.VK_T);
		menuItemSectionDelete = new JMenuItem("Delete", KeyEvent.VK_I);
		menuItemSectionEdit = new JMenuItem("Edit", KeyEvent.VK_N);
		menuItemHelpAbout = new JMenuItem("About", KeyEvent.VK_A);
		menuItemHelpDocumentation = new JMenuItem("Documentation", KeyEvent.VK_D);

		menu = new JMenu("File");
		menu.add(menuItemFileQuit);
		menu.setMnemonic(KeyEvent.VK_F);

		menuBar.add(menu);

		menu = new JMenu("Course");
		menu.add(menuItemCourseAdd);
		menu.add(menuItemCourseDelete);
		menu.add(menuItemCourseEdit);
		menu.setMnemonic(KeyEvent.VK_C);

		menuBar.add(menu);

		menu = new JMenu("Section");
		menu.add(menuItemSectionAdd);
		menu.add(menuItemSectionDelete);
		menu.add(menuItemSectionEdit);
		menu.setMnemonic(KeyEvent.VK_S);

		menuBar.add(menu);

		menu = new JMenu("Help");
		menu.add(menuItemHelpAbout);
		menu.add(menuItemHelpDocumentation);
		menu.setMnemonic(KeyEvent.VK_H);

		menuBar.add(menu);

		return menuBar;
	}

	private JPanel panelSearch()
	{
		JLabel labelCourses = new JLabel("Courses", JLabel.LEFT);
		labelCourses.setFont(new Font("SansSerif", Font.BOLD, 11));

		comboBoxCourses = new JComboBox<String>(new DefaultComboBoxModel<String>(stringCourses));
		comboBoxCourses.setAlignmentX(LEFT_ALIGNMENT);
		comboBoxCourses.setPreferredSize(new Dimension(200, comboBoxCourses.getPreferredSize().height));

		JLabel labelSections = new JLabel("Sections", JLabel.LEFT);
		labelSections.setFont(new Font("SansSerif", Font.BOLD, 11));

		comboBoxSections = new JComboBox<String>(new DefaultComboBoxModel<String>(stringSections));
		comboBoxSections.setAlignmentX(LEFT_ALIGNMENT);
		comboBoxSections.setPreferredSize(new Dimension(200, comboBoxSections.getPreferredSize().height));

		JLabel labelSearch = new JLabel("Search");
		labelSearch.setFont(new Font("SansSerif", Font.BOLD, 11));

		textFieldSearch = new JTextField();
		textFieldSearch.setAlignmentX(LEFT_ALIGNMENT);
		textFieldSearch.setPreferredSize(new Dimension(200, textFieldSearch.getPreferredSize().height));

		buttonSearchCancel = new JButton("Cancel");
		buttonSearchSearch = new JButton("Search");

		Box boxSearchButtons = Box.createHorizontalBox();
		boxSearchButtons.add(Box.createHorizontalGlue());
		boxSearchButtons.add(buttonSearchCancel);
		boxSearchButtons.add(Box.createHorizontalStrut(10));
		boxSearchButtons.add(buttonSearchSearch);
		boxSearchButtons.setAlignmentX(LEFT_ALIGNMENT);

		Box boxSearch = Box.createVerticalBox();
		boxSearch.add(labelCourses);
		boxSearch.add(comboBoxCourses);
		boxSearch.add(Box.createVerticalStrut(10));
		boxSearch.add(labelSections);
		boxSearch.add(comboBoxSections);
		boxSearch.add(Box.createVerticalStrut(10));
		boxSearch.add(labelSearch);
		boxSearch.add(textFieldSearch);
		boxSearch.add(Box.createVerticalStrut(10));
		boxSearch.add(boxSearchButtons);
		boxSearch.add(Box.createVerticalStrut(10));

		listNotes = new JList<String>(stringNotes);
		listNotes.setLayoutOrientation(JList.VERTICAL);
		listNotes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		listNotes.setVisibleRowCount();

		JScrollPane scrollPaneNotes = new JScrollPane(listNotes);
		scrollPaneNotes.setPreferredSize(new Dimension(200, scrollPaneNotes.getPreferredSize().height));

		JPanel panelSearch = new JPanel(new BorderLayout());
		panelSearch.add(boxSearch, BorderLayout.NORTH);
		panelSearch.add(scrollPaneNotes, BorderLayout.CENTER);

		return panelSearch;
	}

	private Box boxSeparator()
	{
		Box boxSeparator = Box.createHorizontalBox();
		boxSeparator.add(Box.createHorizontalStrut(10));
		boxSeparator.add(new JSeparator(JSeparator.VERTICAL));
		boxSeparator.add(Box.createHorizontalStrut(10));

		return boxSeparator;
	}

	private JPanel panelCards()
	{
		panelCards = new JPanel(new CardLayout());
		panelCards.add(panelNull(), "Null");
		panelCards.add(panelCourseAdd(), "CourseAdd");
		panelCards.add(panelCourseDelete(), "CourseDelete");
		panelCards.add(panelCourseEdit(), "CourseEdit");
		panelCards.add(panelSectionAdd(), "SectionAdd");
		panelCards.add(panelSectionDelete(), "SectionDelete");
		panelCards.add(panelSectionEdit(), "SectionEdit");
		panelCards.add(panelNoteAdd(), "NoteAdd");
		panelCards.add(panelNoteDelete(), "NoteDelete");
		panelCards.add(panelNoteEdit(), "NoteEdit");
		panelCards.add(panelNoteView(), "NoteView");
		panelCards.setPreferredSize(new Dimension(567, 457));

		cardLayout = (CardLayout)(panelCards.getLayout());

		return panelCards;
	}

	private JPanel panelNull()
	{
		ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/images/AcmeNote.png"));

		JLabel labelImageIcon = new JLabel(imageIcon);
		labelImageIcon.setAlignmentX(RIGHT_ALIGNMENT);

		JPanel panelNull = new JPanel(new BorderLayout());
		panelNull.add(labelImageIcon, BorderLayout.CENTER);

		return panelNull;
	}

	private JPanel panelCourseAdd()
	{
		JLabel labelCourseAdd = new JLabel("Add Course", JLabel.RIGHT);
		labelCourseAdd.setFont(new Font("Serif", Font.BOLD, 25));

		Box boxCourseAddLabel = Box.createHorizontalBox();
		boxCourseAddLabel.add(Box.createHorizontalGlue());
		boxCourseAddLabel.add(labelCourseAdd);
		boxCourseAddLabel.setPreferredSize(new Dimension(567, boxCourseAddLabel.getPreferredSize().height));

		JSeparator separator = new JSeparator();
		separator.setPreferredSize(new Dimension(567, separator.getPreferredSize().height));

		Box boxCourseAddHeader = Box.createVerticalBox();
		boxCourseAddHeader.add(boxCourseAddLabel);
		boxCourseAddHeader.add(Box.createVerticalStrut(10));
		boxCourseAddHeader.add(separator);

		JLabel labelCourseAddCourseName = new JLabel("Course Name", JLabel.LEFT);
		labelCourseAddCourseName.setFont(new Font("SansSerif", Font.BOLD, 11));
		labelCourseAddCourseName.setPreferredSize(new Dimension(567, labelCourseAddCourseName.getPreferredSize().height));

		textFieldCourseAddCourseName = new JTextField();
		textFieldCourseAddCourseName.setPreferredSize(new Dimension(567, textFieldCourseAddCourseName.getPreferredSize().height));

/*
		boxCourseAddCourseName.add(labelCourseAddCourseName);
		boxCourseAddCourseName.add(Box.createHorizontalStrut(10));
		boxCourseAddCourseName.add(textFieldCourseAddCourseName);
*/

		buttonCourseAddCancel = new JButton("Cancel");
		buttonCourseAddSubmit = new JButton("Submit");

		Box boxCourseAddButtons = Box.createHorizontalBox();
		boxCourseAddButtons.add(Box.createHorizontalGlue());
		boxCourseAddButtons.add(buttonCourseAddCancel);
		boxCourseAddButtons.add(Box.createHorizontalStrut(10));
		boxCourseAddButtons.add(buttonCourseAddSubmit);
		boxCourseAddButtons.setPreferredSize(new Dimension(567, boxCourseAddButtons.getPreferredSize().height));

		Box boxCourseAddBody = Box.createVerticalBox();
		boxCourseAddBody.add(labelCourseAddCourseName);
		boxCourseAddBody.add(Box.createVerticalStrut(10));
		boxCourseAddBody.add(textFieldCourseAddCourseName);
		boxCourseAddBody.add(Box.createVerticalStrut(10));
		boxCourseAddBody.add(boxCourseAddButtons);

		if (boxCourseAddHeader.getPreferredSize().height + boxCourseAddBody.getPreferredSize().height < 457)
		{
			boxCourseAddBody.add(Box.createVerticalStrut(457 - boxCourseAddHeader.getPreferredSize().height - boxCourseAddBody.getPreferredSize().height));
		}

		boxCourseAddBody.setPreferredSize(new Dimension(567, boxCourseAddBody.getPreferredSize().height));

		// containers

		scrollPaneCourseAdd = new JScrollPane(boxCourseAddBody, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneCourseAdd.setBorder(null);

		if (boxCourseAddHeader.getPreferredSize().height + boxCourseAddBody.getPreferredSize().height > 457)
		{
			boxCourseAddBody.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, scrollPaneCourseAdd.getVerticalScrollBar().getPreferredSize().width + 10));
		}
		else
		{
			scrollPaneCourseAdd.getVerticalScrollBar().setPreferredSize(new Dimension(0, scrollPaneCourseAdd.getPreferredSize().height));
		}

		Box boxCourseAdd = Box.createVerticalBox();
		boxCourseAdd.add(boxCourseAddHeader);
		boxCourseAdd.add(Box.createVerticalStrut(10));
		boxCourseAdd.add(scrollPaneCourseAdd);
		boxCourseAdd.setPreferredSize(new Dimension(567, boxCourseAdd.getPreferredSize().height));

		JPanel panelCourseAdd = new JPanel(new BorderLayout());
		panelCourseAdd.add(boxCourseAdd, BorderLayout.EAST);

		return panelCourseAdd;
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

	private JPanel panelNoteView()
	{
		return new JPanel();
	}

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
		serialize();
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

	// utility methods

	private void coursesCopy()
	{
	}

	private void coursesSort()
	{
	}

	private void notesSearch()
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

	private void setListData()
	{
	}

	// main method

	public static void main(String[] args)
	{
		AcmeNote frame = new AcmeNote();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setTitle("AcmeNote");
		frame.pack();
		frame.setVisible(true);
	}
}