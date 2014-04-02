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
import javax.swing.JCheckBox;
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
import javax.swing.JTextArea;
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
	private JButton buttonCourseDeleteCancel;
	private JButton buttonCourseDeleteSubmit;
	private JButton buttonCourseEditCancel;
	private JButton buttonCourseEditSubmit;
	private JButton buttonNoteAddCancel;
	private JButton buttonNoteAddSubmit;
	private JButton buttonNoteDeleteCancel;
	private JButton buttonNoteDeleteSubmit;
	private JButton buttonNoteEditCancel;
	private JButton buttonNoteEditSubmit;
	private JButton buttonNoteNullNoteAdd;
	private JButton buttonNoteNullNoteDelete;
	private JButton buttonNoteNullNoteEdit;
	private JButton buttonNotesSearchCancel;
	private JButton buttonNotesSearchSearch;
	private JButton buttonNoteViewNoteAdd;
	private JButton buttonNoteViewNoteDelete;
	private JButton buttonNoteViewNoteEdit;
	private JButton buttonSectionAddCancel;
	private JButton buttonSectionDeleteSubmit;
	private JButton buttonSectionDeleteCancel;
	private JButton buttonSectionAddSubmit;
	private JButton buttonSectionEditCancel;
	private JButton buttonSectionEditSubmit;
	private CardLayout cardLayout;
	private JCheckBox checkBoxCourseDelete;
	private JCheckBox checkBoxNoteDelete;
	private JCheckBox checkBoxSectionDelete;
	private JComboBox<String> comboBoxNoteAddCourses;
	private JComboBox<String> comboBoxNoteAddSections;
	private JComboBox<String> comboBoxNoteEditCourses;
	private JComboBox<String> comboBoxNoteEditSections;
	private JComboBox<String> comboBoxNotesSearchCourses;
	private JComboBox<String> comboBoxNotesSearchSections;
	private JComboBox<String> comboBoxSectionAddCourses;
	private JComboBox<String> comboBoxSectionEditCourses;
	private JList<String> listNotes;
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
	private JTextArea textAreaNoteAddNoteText;
	private JTextArea textAreaNoteEditNoteText;
	private JTextArea textAreaNoteViewNoteText;
	private JTextField textFieldCourseAddCourseName;
	private JTextField textFieldCourseEditCourseName;
	private JTextField textFieldNoteAddNoteName;
	private JTextField textFieldNoteEditNoteName;
	private JTextField textFieldNotesSearch;
	private JTextField textFieldNoteViewCourseName;
	private JTextField textFieldNoteViewNoteName;
	private JTextField textFieldNoteViewSectionName;
	private JTextField textFieldSectionAddSectionName;
	private JTextField textFieldSectionEditSectionName;

	// fields

/*
	private String[] stringCourses;
	private String[] stringNotes;
	private String[] stringSections;
*/

	// delete me after utility methods are implemented

	private String[] stringCourses = {"Course 1", "Course 2", "Course 3"};
	private String[] stringSections = {"Section 1", "Section 2", "Section 3"};
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

	/**
	 * Calls associated methods to create graphical user interface.
	 */
	private void graphicalUserInterfaceCreate()
	{
		coursesCopy();

		add(panelCreate());

		actionListenersAdd();
		listSelectionListenersAdd();
		windowListenersAdd();
	}

	/**
	 * Calls associated methods to create menu and content cards.
	 * @return <tt>JPanel</tt> object.
	 */
	private JPanel panelCreate()
	{
		JPanel panelMenu = new JPanel(new BorderLayout());
		panelMenu.add(menuCreate(), BorderLayout.NORTH);

		Box boxContent = Box.createHorizontalBox();
		boxContent.add((panelNotesSearch()));
		boxContent.add(Box.createHorizontalStrut(10));
		boxContent.add(new JSeparator(JSeparator.VERTICAL));
		boxContent.add(Box.createHorizontalStrut(10));
		boxContent.add(panelCards());
		boxContent.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		JPanel panel = new JPanel(new BorderLayout());
		panel.add(panelMenu, BorderLayout.NORTH);
		panel.add(boxContent, BorderLayout.WEST);

		return panel;
	}

	/**
	 * Creates menu.
	 * @return <tt>JMenuBar</tt> object.
	 */
	private JMenuBar menuCreate()
	{
		// components

		menuItemFileQuit = new JMenuItem("Quit", KeyEvent.VK_Q);
		menuItemCourseAdd = new JMenuItem("Add", KeyEvent.VK_O);
		menuItemCourseDelete = new JMenuItem("Delete", KeyEvent.VK_L);
		menuItemCourseEdit = new JMenuItem("Edit", KeyEvent.VK_E);
		menuItemSectionAdd = new JMenuItem("Add", KeyEvent.VK_T);
		menuItemSectionDelete = new JMenuItem("Delete", KeyEvent.VK_I);
		menuItemSectionEdit = new JMenuItem("Edit", KeyEvent.VK_N);
		menuItemHelpAbout = new JMenuItem("About", KeyEvent.VK_A);
		menuItemHelpDocumentation = new JMenuItem("Documentation", KeyEvent.VK_D);

		// containers

		JMenuBar menuBar = new JMenuBar();

		JMenu menu = new JMenu("File");
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

	/**
	 * Creates notes search panel.
	 * @return <tt>JPanel</tt> object.
	 */
	private JPanel panelNotesSearch()
	{
		// components

		comboBoxNotesSearchCourses = new JComboBox<String>(new DefaultComboBoxModel<String>(stringCourses));
		comboBoxNotesSearchCourses.insertItemAt("All Courses", 0);
		comboBoxNotesSearchCourses.setAlignmentX(LEFT_ALIGNMENT);
		comboBoxNotesSearchCourses.setPreferredSize(new Dimension(200, comboBoxNotesSearchCourses.getPreferredSize().height));
		comboBoxNotesSearchCourses.setSelectedIndex(0);

		comboBoxNotesSearchSections = new JComboBox<String>(new DefaultComboBoxModel<String>(stringSections));
		comboBoxNotesSearchSections.insertItemAt("All Sections", 0);
		comboBoxNotesSearchSections.setAlignmentX(LEFT_ALIGNMENT);
		comboBoxNotesSearchSections.setPreferredSize(new Dimension(200, comboBoxNotesSearchSections.getPreferredSize().height));
		comboBoxNotesSearchSections.setSelectedIndex(0);

		textFieldNotesSearch = new JTextField();
		textFieldNotesSearch.setAlignmentX(LEFT_ALIGNMENT);
		textFieldNotesSearch.setPreferredSize(new Dimension(200, textFieldNotesSearch.getPreferredSize().height));

		buttonNotesSearchCancel = new JButton("Cancel");
		buttonNotesSearchSearch = new JButton("Search");

		listNotes = new JList<String>(stringNotes);
		listNotes.setLayoutOrientation(JList.VERTICAL);
		listNotes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane scrollPaneNotes = new JScrollPane(listNotes);
		scrollPaneNotes.setPreferredSize(new Dimension(200, scrollPaneNotes.getPreferredSize().height));

		// containers
		
		Box boxNotesSearchButtons = Box.createHorizontalBox();
		boxNotesSearchButtons.add(Box.createHorizontalGlue());
		boxNotesSearchButtons.add(buttonNotesSearchCancel);
		boxNotesSearchButtons.add(Box.createHorizontalStrut(10));
		boxNotesSearchButtons.add(buttonNotesSearchSearch);
		boxNotesSearchButtons.setAlignmentX(LEFT_ALIGNMENT);

		Box boxNotesSearch = Box.createVerticalBox();
		boxNotesSearch.add(new JLabel("Select Course"));
		boxNotesSearch.add(comboBoxNotesSearchCourses);
		boxNotesSearch.add(Box.createVerticalStrut(10));
		boxNotesSearch.add(new JLabel("Select Section"));
		boxNotesSearch.add(comboBoxNotesSearchSections);
		boxNotesSearch.add(Box.createVerticalStrut(10));
		boxNotesSearch.add(new JLabel("Search"));
		boxNotesSearch.add(textFieldNotesSearch);
		boxNotesSearch.add(Box.createVerticalStrut(10));
		boxNotesSearch.add(boxNotesSearchButtons);
		boxNotesSearch.add(Box.createVerticalStrut(10));

		JPanel panelNotesSearch = new JPanel(new BorderLayout());
		panelNotesSearch.add(boxNotesSearch, BorderLayout.NORTH);
		panelNotesSearch.add(scrollPaneNotes, BorderLayout.CENTER);

		return panelNotesSearch;
	}

	/**
	 * Creates card layout containing the associated panels for each task.
	 * @return <tt>JPanel</tt> object.
	 */
	private JPanel panelCards()
	{
		panelCards = new JPanel(new CardLayout());
		panelCards.add(panelNoteNull(), "NoteNull");
		panelCards.add(boxCourseAdd(), "CourseAdd");
		panelCards.add(boxCourseDelete(), "CourseDelete");
		panelCards.add(boxCourseEdit(), "CourseEdit");
		panelCards.add(boxSectionAdd(), "SectionAdd");
		panelCards.add(boxSectionDelete(), "SectionDelete");
		panelCards.add(boxSectionEdit(), "SectionEdit");
		panelCards.add(boxNoteAdd(), "NoteAdd");
		panelCards.add(boxNoteDelete(), "NoteDelete");
		panelCards.add(boxNoteEdit(), "NoteEdit");
		panelCards.add(boxNoteView(), "NoteView");

		cardLayout = (CardLayout)(panelCards.getLayout());

		JPanel panel = new JPanel(new BorderLayout());
		panel.add(panelCards, BorderLayout.NORTH);

		return panel;
	}

	/**
	 * Creates default panel.
	 * @return <tt>JPanel</tt> object.
	 */
	private JPanel panelNoteNull()
	{
		// components

		JLabel labelImageIcon = new JLabel(new ImageIcon(this.getClass().getResource("/images/AcmeNote.png")));
		labelImageIcon.setPreferredSize(new Dimension(labelImageIcon.getPreferredSize().width, 419));

		buttonNoteNullNoteAdd = new JButton("Add Note");

		buttonNoteNullNoteDelete = new JButton("Delete Note");
		buttonNoteNullNoteDelete.setEnabled(false);

		buttonNoteNullNoteEdit = new JButton("Edit Note");
		buttonNoteNullNoteEdit.setEnabled(false);

		// containers

		Box boxNoteNullHeader = Box.createHorizontalBox();
		boxNoteNullHeader.add(buttonNoteNullNoteAdd);
		boxNoteNullHeader.add(Box.createHorizontalGlue());
		boxNoteNullHeader.add(buttonNoteNullNoteDelete);
		boxNoteNullHeader.add(Box.createHorizontalStrut(10));
		boxNoteNullHeader.add(buttonNoteNullNoteEdit);

		Box boxNoteNull = Box.createVerticalBox();
		boxNoteNull.add(boxNoteNullHeader);
		boxNoteNull.add(Box.createVerticalStrut(10));
		boxNoteNull.add(new JSeparator(JSeparator.HORIZONTAL));

		JPanel panelNoteNull = new JPanel(new BorderLayout());
		panelNoteNull.add(boxNoteNull, BorderLayout.NORTH);
		panelNoteNull.add(labelImageIcon, BorderLayout.CENTER);

		return panelNoteNull;
	}

	/**
	 * Creates add course panel.
	 * @return <tt>Box</tt> object.
	 */
	private Box boxCourseAdd()
	{
		// components

		JLabel labelCourseAdd = new JLabel("Add Course");
		labelCourseAdd.setFont(new Font("Serif", Font.BOLD, 25));

		textFieldCourseAddCourseName = new JTextField();
		textFieldCourseAddCourseName.setPreferredSize(new Dimension(200, textFieldCourseAddCourseName.getPreferredSize().height));

		buttonCourseAddCancel = new JButton("Cancel");
		buttonCourseAddSubmit = new JButton("Submit");

		// containers

		Box boxCourseAddHeader = Box.createHorizontalBox();
		boxCourseAddHeader.add(Box.createHorizontalGlue());
		boxCourseAddHeader.add(labelCourseAdd);

		Box boxCourseAddCourseNameLabel = Box.createHorizontalBox();
		boxCourseAddCourseNameLabel.add(Box.createHorizontalGlue());
		boxCourseAddCourseNameLabel.add(new JLabel("Course Name"));

		Box boxCourseAddCourseNameTextField = Box.createHorizontalBox();
		boxCourseAddCourseNameTextField.add(Box.createHorizontalStrut(358));
		boxCourseAddCourseNameTextField.add(textFieldCourseAddCourseName);

		Box boxCourseAddButtons = Box.createHorizontalBox();
		boxCourseAddButtons.add(Box.createHorizontalGlue());
		boxCourseAddButtons.add(buttonCourseAddCancel);
		boxCourseAddButtons.add(Box.createHorizontalStrut(10));
		boxCourseAddButtons.add(buttonCourseAddSubmit);

		Box boxCourseAdd = Box.createVerticalBox();
		boxCourseAdd.add(boxCourseAddHeader);
		boxCourseAdd.add(Box.createVerticalStrut(10));
		boxCourseAdd.add(new JSeparator(JSeparator.HORIZONTAL));
		boxCourseAdd.add(Box.createVerticalStrut(10));
		boxCourseAdd.add(boxCourseAddCourseNameLabel);
		boxCourseAdd.add(boxCourseAddCourseNameTextField);
		boxCourseAdd.add(Box.createVerticalStrut(10));
		boxCourseAdd.add(boxCourseAddButtons);
		boxCourseAdd.add(Box.createVerticalStrut(330));

		return boxCourseAdd;
	}

	/**
	 * Creates delete course panel.
	 * @return <tt>Box</tt> object.
	 */
	private Box boxCourseDelete()
	{
		// components

		JLabel labelCourseDelete = new JLabel("Delete Course");
		labelCourseDelete.setFont(new Font("Serif", Font.BOLD, 25));

		checkBoxCourseDelete = new JCheckBox("Please check here to confirm deletion of the course.");

		buttonCourseDeleteCancel = new JButton("Cancel");
		buttonCourseDeleteSubmit = new JButton("Submit");

		// containers

		Box boxCourseDeleteHeader = Box.createHorizontalBox();
		boxCourseDeleteHeader.add(Box.createHorizontalGlue());
		boxCourseDeleteHeader.add(labelCourseDelete);

		Box boxCourseDeleteWarningAssociatedLabel = Box.createHorizontalBox();
		boxCourseDeleteWarningAssociatedLabel.add(Box.createHorizontalGlue());
		boxCourseDeleteWarningAssociatedLabel.add(new JLabel("Warning: Deleting the course will also delete all associated sections and notes."));

		Box boxCourseDeleteWarningPermanentLabel = Box.createHorizontalBox();
		boxCourseDeleteWarningPermanentLabel.add(Box.createHorizontalGlue());
		boxCourseDeleteWarningPermanentLabel.add(new JLabel("Deleting the course cannot be undone."));

		Box boxCourseDeleteCheckBox = Box.createHorizontalBox();
		boxCourseDeleteCheckBox.add(Box.createHorizontalGlue());
		boxCourseDeleteCheckBox.add(checkBoxCourseDelete);

		Box boxCourseDeleteButtons = Box.createHorizontalBox();
		boxCourseDeleteButtons.add(Box.createHorizontalGlue());
		boxCourseDeleteButtons.add(buttonCourseDeleteCancel);
		boxCourseDeleteButtons.add(Box.createHorizontalStrut(10));
		boxCourseDeleteButtons.add(buttonCourseDeleteSubmit);

		Box boxCourseDelete = Box.createVerticalBox();
		boxCourseDelete.add(boxCourseDeleteHeader);
		boxCourseDelete.add(Box.createVerticalStrut(10));
		boxCourseDelete.add(new JSeparator(JSeparator.HORIZONTAL));
		boxCourseDelete.add(Box.createVerticalStrut(10));
		boxCourseDelete.add(boxCourseDeleteWarningAssociatedLabel);
		boxCourseDelete.add(Box.createVerticalStrut(10));
		boxCourseDelete.add(boxCourseDeleteWarningPermanentLabel);
		boxCourseDelete.add(Box.createVerticalStrut(10));
		boxCourseDelete.add(boxCourseDeleteCheckBox);
		boxCourseDelete.add(Box.createVerticalStrut(10));
		boxCourseDelete.add(boxCourseDeleteButtons);
		boxCourseDelete.add(Box.createVerticalStrut(290));

		return boxCourseDelete;
	}

	/**
	 * Creates edit course panel.
	 * @return <tt>Box</tt> object.
	 */
	private Box boxCourseEdit()
	{
		// components

		JLabel labelCourseEdit = new JLabel("Edit Course");
		labelCourseEdit.setFont(new Font("Serif", Font.BOLD, 25));

		textFieldCourseEditCourseName = new JTextField();
		textFieldCourseEditCourseName.setPreferredSize(new Dimension(200, textFieldCourseEditCourseName.getPreferredSize().height));

		buttonCourseEditCancel = new JButton("Cancel");
		buttonCourseEditSubmit = new JButton("Submit");

		// containers

		Box boxCourseEditHeader = Box.createHorizontalBox();
		boxCourseEditHeader.add(Box.createHorizontalGlue());
		boxCourseEditHeader.add(labelCourseEdit);

		Box boxCourseEditCourseNameLabel = Box.createHorizontalBox();
		boxCourseEditCourseNameLabel.add(Box.createHorizontalGlue());
		boxCourseEditCourseNameLabel.add(new JLabel("Course Name"));

		Box boxCourseEditCourseNameTextField = Box.createHorizontalBox();
		boxCourseEditCourseNameTextField.add(Box.createHorizontalStrut(358));
		boxCourseEditCourseNameTextField.add(textFieldCourseEditCourseName);

		Box boxCourseEditButtons = Box.createHorizontalBox();
		boxCourseEditButtons.add(Box.createHorizontalGlue());
		boxCourseEditButtons.add(buttonCourseEditCancel);
		boxCourseEditButtons.add(Box.createHorizontalStrut(10));
		boxCourseEditButtons.add(buttonCourseEditSubmit);

		Box boxCourseEdit = Box.createVerticalBox();
		boxCourseEdit.add(boxCourseEditHeader);
		boxCourseEdit.add(Box.createVerticalStrut(10));
		boxCourseEdit.add(new JSeparator(JSeparator.HORIZONTAL));
		boxCourseEdit.add(Box.createVerticalStrut(10));
		boxCourseEdit.add(boxCourseEditCourseNameLabel);
		boxCourseEdit.add(boxCourseEditCourseNameTextField);
		boxCourseEdit.add(Box.createVerticalStrut(10));
		boxCourseEdit.add(boxCourseEditButtons);
		boxCourseEdit.add(Box.createVerticalStrut(330));

		return boxCourseEdit;
	}

	/**
	 * Creates add section panel.
	 * @return <tt>Box</tt> object.
	 */
	private Box boxSectionAdd()
	{
		// components

		JLabel labelSectionAdd = new JLabel("Add Section");
		labelSectionAdd.setFont(new Font("Serif", Font.BOLD, 25));

		comboBoxSectionAddCourses = new JComboBox<String>(new DefaultComboBoxModel<String>(stringCourses));
		comboBoxSectionAddCourses.setAlignmentX(LEFT_ALIGNMENT);
		comboBoxSectionAddCourses.setPreferredSize(new Dimension(200, comboBoxSectionAddCourses.getPreferredSize().height));

		textFieldSectionAddSectionName = new JTextField();
		textFieldSectionAddSectionName.setPreferredSize(new Dimension(200, textFieldSectionAddSectionName.getPreferredSize().height));

		buttonSectionAddCancel = new JButton("Cancel");
		buttonSectionAddSubmit = new JButton("Submit");

		// containers

		Box boxSectionAddHeader = Box.createHorizontalBox();
		boxSectionAddHeader.add(Box.createHorizontalGlue());
		boxSectionAddHeader.add(labelSectionAdd);

		Box boxSectionAddCourseLabel = Box.createHorizontalBox();
		boxSectionAddCourseLabel.add(Box.createHorizontalGlue());
		boxSectionAddCourseLabel.add(new JLabel("Select Course"));

		Box boxSectionAddCourseComboBox = Box.createHorizontalBox();
		boxSectionAddCourseComboBox.add(Box.createHorizontalStrut(358));
		boxSectionAddCourseComboBox.add(comboBoxSectionAddCourses);

		Box boxSectionAddSectionNameLabel = Box.createHorizontalBox();
		boxSectionAddSectionNameLabel.add(Box.createHorizontalGlue());
		boxSectionAddSectionNameLabel.add(new JLabel("Section Name"));

		Box boxSectionAddCourseNameTextField = Box.createHorizontalBox();
		boxSectionAddCourseNameTextField.add(Box.createHorizontalStrut(358));
		boxSectionAddCourseNameTextField.add(textFieldSectionAddSectionName);

		Box boxSectionAddButtons = Box.createHorizontalBox();
		boxSectionAddButtons.add(Box.createHorizontalGlue());
		boxSectionAddButtons.add(buttonSectionAddCancel);
		boxSectionAddButtons.add(Box.createHorizontalStrut(10));
		boxSectionAddButtons.add(buttonSectionAddSubmit);

		Box boxSectionAdd = Box.createVerticalBox();
		boxSectionAdd.add(boxSectionAddHeader);
		boxSectionAdd.add(Box.createVerticalStrut(10));
		boxSectionAdd.add(new JSeparator(JSeparator.HORIZONTAL));
		boxSectionAdd.add(Box.createVerticalStrut(10));
		boxSectionAdd.add(boxSectionAddCourseLabel);
		boxSectionAdd.add(boxSectionAddCourseComboBox);
		boxSectionAdd.add(Box.createVerticalStrut(10));
		boxSectionAdd.add(boxSectionAddSectionNameLabel);
		boxSectionAdd.add(boxSectionAddCourseNameTextField);
		boxSectionAdd.add(Box.createVerticalStrut(10));
		boxSectionAdd.add(boxSectionAddButtons);
		boxSectionAdd.add(Box.createVerticalStrut(279));

		return boxSectionAdd;
	}

	/**
	 * Creates delete section panel.
	 * @return <tt>Box</tt> object.
	 */
	private Box boxSectionDelete()
	{
		// components

		JLabel labelSectionDelete = new JLabel("Delete Section");
		labelSectionDelete.setFont(new Font("Serif", Font.BOLD, 25));

		checkBoxSectionDelete = new JCheckBox("Please check here to confirm deletion of the section.");

		buttonSectionDeleteCancel = new JButton("Cancel");
		buttonSectionDeleteSubmit = new JButton("Submit");

		// containers

		Box boxSectionDeleteHeader = Box.createHorizontalBox();
		boxSectionDeleteHeader.add(Box.createHorizontalGlue());
		boxSectionDeleteHeader.add(labelSectionDelete);

		Box boxSectionDeleteWarningAssociatedLabel = Box.createHorizontalBox();
		boxSectionDeleteWarningAssociatedLabel.add(Box.createHorizontalGlue());
		boxSectionDeleteWarningAssociatedLabel.add(new JLabel("Warning: Deleting the section will also delete all associated notes."));

		Box boxSectionDeleteWarningPermanentLabel = Box.createHorizontalBox();
		boxSectionDeleteWarningPermanentLabel.add(Box.createHorizontalGlue());
		boxSectionDeleteWarningPermanentLabel.add(new JLabel("Deleting the section cannot be undone."));

		Box boxSectionDeleteCheckBox = Box.createHorizontalBox();
		boxSectionDeleteCheckBox.add(Box.createHorizontalGlue());
		boxSectionDeleteCheckBox.add(checkBoxSectionDelete);

		Box boxSectionDeleteButtons = Box.createHorizontalBox();
		boxSectionDeleteButtons.add(Box.createHorizontalGlue());
		boxSectionDeleteButtons.add(buttonSectionDeleteCancel);
		boxSectionDeleteButtons.add(Box.createHorizontalStrut(10));
		boxSectionDeleteButtons.add(buttonSectionDeleteSubmit);

		Box boxSectionDelete = Box.createVerticalBox();
		boxSectionDelete.add(boxSectionDeleteHeader);
		boxSectionDelete.add(Box.createVerticalStrut(10));
		boxSectionDelete.add(new JSeparator(JSeparator.HORIZONTAL));
		boxSectionDelete.add(Box.createVerticalStrut(10));
		boxSectionDelete.add(boxSectionDeleteWarningAssociatedLabel);
		boxSectionDelete.add(Box.createVerticalStrut(10));
		boxSectionDelete.add(boxSectionDeleteWarningPermanentLabel);
		boxSectionDelete.add(Box.createVerticalStrut(10));
		boxSectionDelete.add(boxSectionDeleteCheckBox);
		boxSectionDelete.add(Box.createVerticalStrut(10));
		boxSectionDelete.add(boxSectionDeleteButtons);
		boxSectionDelete.add(Box.createVerticalStrut(290));

		return boxSectionDelete;
	}

	/**
	 * Creates edit section panel.
	 * @return <tt>Box</tt> object.
	 */
	private Box boxSectionEdit()
	{
		// components

		JLabel labelSectionEdit = new JLabel("Edit Section");
		labelSectionEdit.setFont(new Font("Serif", Font.BOLD, 25));

		comboBoxSectionEditCourses = new JComboBox<String>(new DefaultComboBoxModel<String>(stringCourses));
		comboBoxSectionEditCourses.setAlignmentX(LEFT_ALIGNMENT);
		comboBoxSectionEditCourses.setPreferredSize(new Dimension(200, comboBoxSectionEditCourses.getPreferredSize().height));

		textFieldSectionEditSectionName = new JTextField();
		textFieldSectionEditSectionName.setPreferredSize(new Dimension(200, textFieldSectionEditSectionName.getPreferredSize().height));

		buttonSectionEditCancel = new JButton("Cancel");
		buttonSectionEditSubmit = new JButton("Submit");

		// containers

		Box boxSectionEditHeader = Box.createHorizontalBox();
		boxSectionEditHeader.add(Box.createHorizontalGlue());
		boxSectionEditHeader.add(labelSectionEdit);

		Box boxSectionEditCourseLabel = Box.createHorizontalBox();
		boxSectionEditCourseLabel.add(Box.createHorizontalGlue());
		boxSectionEditCourseLabel.add(new JLabel("Select Course"));

		Box boxSectionEditCourseComboBox = Box.createHorizontalBox();
		boxSectionEditCourseComboBox.add(Box.createHorizontalStrut(358));
		boxSectionEditCourseComboBox.add(comboBoxSectionEditCourses);

		Box boxSectionEditSectionNameLabel = Box.createHorizontalBox();
		boxSectionEditSectionNameLabel.add(Box.createHorizontalGlue());
		boxSectionEditSectionNameLabel.add(new JLabel("Section Name"));

		Box boxSectionEditCourseNameTextField = Box.createHorizontalBox();
		boxSectionEditCourseNameTextField.add(Box.createHorizontalStrut(358));
		boxSectionEditCourseNameTextField.add(textFieldSectionEditSectionName);

		Box boxSectionEditButtons = Box.createHorizontalBox();
		boxSectionEditButtons.add(Box.createHorizontalGlue());
		boxSectionEditButtons.add(buttonSectionEditCancel);
		boxSectionEditButtons.add(Box.createHorizontalStrut(10));
		boxSectionEditButtons.add(buttonSectionEditSubmit);

		Box boxSectionEdit = Box.createVerticalBox();
		boxSectionEdit.add(boxSectionEditHeader);
		boxSectionEdit.add(Box.createVerticalStrut(10));
		boxSectionEdit.add(new JSeparator(JSeparator.HORIZONTAL));
		boxSectionEdit.add(Box.createVerticalStrut(10));
		boxSectionEdit.add(boxSectionEditCourseLabel);
		boxSectionEdit.add(boxSectionEditCourseComboBox);
		boxSectionEdit.add(Box.createVerticalStrut(10));
		boxSectionEdit.add(boxSectionEditSectionNameLabel);
		boxSectionEdit.add(boxSectionEditCourseNameTextField);
		boxSectionEdit.add(Box.createVerticalStrut(10));
		boxSectionEdit.add(boxSectionEditButtons);
		boxSectionEdit.add(Box.createVerticalStrut(279));

		return boxSectionEdit;
	}

	/**
	 * Creates add note panel.
	 * @return <tt>Box</tt> object.
	 */
	private Box boxNoteAdd()
	{
		// components

		JLabel labelNoteAdd = new JLabel("Add Note");
		labelNoteAdd.setFont(new Font("Serif", Font.BOLD, 25));

		comboBoxNoteAddCourses = new JComboBox<String>(new DefaultComboBoxModel<String>(stringCourses));
		comboBoxNoteAddCourses.setAlignmentX(LEFT_ALIGNMENT);
		comboBoxNoteAddCourses.setPreferredSize(new Dimension(200, comboBoxNoteAddCourses.getPreferredSize().height));

		comboBoxNoteAddSections = new JComboBox<String>(new DefaultComboBoxModel<String>(stringSections));
		comboBoxNoteAddSections.setAlignmentX(LEFT_ALIGNMENT);
		comboBoxNoteAddSections.setPreferredSize(new Dimension(200, comboBoxNoteAddSections.getPreferredSize().height));

		textFieldNoteAddNoteName = new JTextField();
		textFieldNoteAddNoteName.setPreferredSize(new Dimension(558, textFieldNoteAddNoteName.getPreferredSize().height));

		textAreaNoteAddNoteText = new JTextArea();
		textAreaNoteAddNoteText.setLineWrap(true);
		textAreaNoteAddNoteText.setWrapStyleWord(true);

		JScrollPane scrollPaneNoteAddNoteText = new JScrollPane(textAreaNoteAddNoteText);
		scrollPaneNoteAddNoteText.setPreferredSize(new Dimension(558, 202));

		buttonNoteAddCancel = new JButton("Cancel");
		buttonNoteAddSubmit = new JButton("Submit");

		// containers

		Box boxNoteAddHeader = Box.createHorizontalBox();
		boxNoteAddHeader.add(Box.createHorizontalGlue());
		boxNoteAddHeader.add(labelNoteAdd);

		Box boxNoteAddCourseLabel = Box.createHorizontalBox();
		boxNoteAddCourseLabel.add(Box.createHorizontalGlue());
		boxNoteAddCourseLabel.add(new JLabel("Select Course"));

		Box boxNoteAddCourseComboBox = Box.createHorizontalBox();
		boxNoteAddCourseComboBox.add(Box.createHorizontalStrut(358));
		boxNoteAddCourseComboBox.add(comboBoxNoteAddCourses);

		Box boxNoteAddSectionLabel = Box.createHorizontalBox();
		boxNoteAddSectionLabel.add(Box.createHorizontalGlue());
		boxNoteAddSectionLabel.add(new JLabel("Select Section"));

		Box boxNoteAddSectionComboBox = Box.createHorizontalBox();
		boxNoteAddSectionComboBox.add(Box.createHorizontalStrut(358));
		boxNoteAddSectionComboBox.add(comboBoxNoteAddSections);

		Box boxNoteAddNoteNameLabel = Box.createHorizontalBox();
		boxNoteAddNoteNameLabel.add(Box.createHorizontalGlue());
		boxNoteAddNoteNameLabel.add(new JLabel("Note Name"));

		Box boxNoteAddNoteTextLabel = Box.createHorizontalBox();
		boxNoteAddNoteTextLabel.add(Box.createHorizontalGlue());
		boxNoteAddNoteTextLabel.add(new JLabel("Note Text"));

		Box boxNoteAddButtons = Box.createHorizontalBox();
		boxNoteAddButtons.add(Box.createHorizontalGlue());
		boxNoteAddButtons.add(buttonNoteAddCancel);
		boxNoteAddButtons.add(Box.createHorizontalStrut(10));
		boxNoteAddButtons.add(buttonNoteAddSubmit);

		Box boxNoteAdd = Box.createVerticalBox();
		boxNoteAdd.add(boxNoteAddHeader);
		boxNoteAdd.add(Box.createVerticalStrut(10));
		boxNoteAdd.add(new JSeparator(JSeparator.HORIZONTAL));
		boxNoteAdd.add(Box.createVerticalStrut(10));
		boxNoteAdd.add(boxNoteAddCourseLabel);
		boxNoteAdd.add(boxNoteAddCourseComboBox);
		boxNoteAdd.add(Box.createVerticalStrut(10));
		boxNoteAdd.add(boxNoteAddSectionLabel);
		boxNoteAdd.add(boxNoteAddSectionComboBox);
		boxNoteAdd.add(Box.createVerticalStrut(10));
		boxNoteAdd.add(boxNoteAddNoteNameLabel);
		boxNoteAdd.add(textFieldNoteAddNoteName);
		boxNoteAdd.add(Box.createVerticalStrut(10));
		boxNoteAdd.add(boxNoteAddNoteTextLabel);
		boxNoteAdd.add(scrollPaneNoteAddNoteText);
		boxNoteAdd.add(Box.createVerticalStrut(10));
		boxNoteAdd.add(boxNoteAddButtons);

		return boxNoteAdd;
	}

	/**
	 * Creates delete note panel.
	 * @return <tt>Box</tt> object.
	 */
	private Box boxNoteDelete()
	{
		// components

		JLabel labelNoteDelete = new JLabel("Delete Note");
		labelNoteDelete.setFont(new Font("Serif", Font.BOLD, 25));

		checkBoxNoteDelete = new JCheckBox("Please check here to confirm deletion of the section.");

		buttonNoteDeleteCancel = new JButton("Cancel");
		buttonNoteDeleteSubmit = new JButton("Submit");

		// containers

		Box boxNoteDeleteHeader = Box.createHorizontalBox();
		boxNoteDeleteHeader.add(Box.createHorizontalGlue());
		boxNoteDeleteHeader.add(labelNoteDelete);

		Box boxNoteDeleteWarningPermanentLabel = Box.createHorizontalBox();
		boxNoteDeleteWarningPermanentLabel.add(Box.createHorizontalGlue());
		boxNoteDeleteWarningPermanentLabel.add(new JLabel("Warning: Deleting the note cannot be undone."));

		Box boxNoteDeleteCheckBox = Box.createHorizontalBox();
		boxNoteDeleteCheckBox.add(Box.createHorizontalGlue());
		boxNoteDeleteCheckBox.add(checkBoxNoteDelete);

		Box boxNoteDeleteButtons = Box.createHorizontalBox();
		boxNoteDeleteButtons.add(Box.createHorizontalGlue());
		boxNoteDeleteButtons.add(buttonNoteDeleteCancel);
		boxNoteDeleteButtons.add(Box.createHorizontalStrut(10));
		boxNoteDeleteButtons.add(buttonNoteDeleteSubmit);

		Box boxNoteDelete = Box.createVerticalBox();
		boxNoteDelete.add(boxNoteDeleteHeader);
		boxNoteDelete.add(Box.createVerticalStrut(10));
		boxNoteDelete.add(new JSeparator(JSeparator.HORIZONTAL));
		boxNoteDelete.add(Box.createVerticalStrut(10));
		boxNoteDelete.add(boxNoteDeleteWarningPermanentLabel);
		boxNoteDelete.add(Box.createVerticalStrut(10));
		boxNoteDelete.add(boxNoteDeleteCheckBox);
		boxNoteDelete.add(Box.createVerticalStrut(10));
		boxNoteDelete.add(boxNoteDeleteButtons);
		boxNoteDelete.add(Box.createVerticalStrut(316));

		return boxNoteDelete;
	}

	/**
	 * Creates edit note panel.
	 * @return <tt>Box</tt> object.
	 */
	private Box boxNoteEdit()
	{
		// components

		JLabel labelNoteEdit = new JLabel("Edit Note");
		labelNoteEdit.setFont(new Font("Serif", Font.BOLD, 25));

		comboBoxNoteEditCourses = new JComboBox<String>(new DefaultComboBoxModel<String>(stringCourses));
		comboBoxNoteEditCourses.setAlignmentX(LEFT_ALIGNMENT);
		comboBoxNoteEditCourses.setPreferredSize(new Dimension(200, comboBoxNoteEditCourses.getPreferredSize().height));

		comboBoxNoteEditSections = new JComboBox<String>(new DefaultComboBoxModel<String>(stringSections));
		comboBoxNoteEditSections.setAlignmentX(LEFT_ALIGNMENT);
		comboBoxNoteEditSections.setPreferredSize(new Dimension(200, comboBoxNoteEditSections.getPreferredSize().height));

		textFieldNoteEditNoteName = new JTextField();
		textFieldNoteEditNoteName.setPreferredSize(new Dimension(558, textFieldNoteEditNoteName.getPreferredSize().height));

		textAreaNoteEditNoteText = new JTextArea();
		textAreaNoteEditNoteText.setLineWrap(true);
		textAreaNoteEditNoteText.setWrapStyleWord(true);

		JScrollPane scrollPaneNoteEditNoteText = new JScrollPane(textAreaNoteEditNoteText);
		scrollPaneNoteEditNoteText.setPreferredSize(new Dimension(558, 202));

		buttonNoteEditCancel = new JButton("Cancel");
		buttonNoteEditSubmit = new JButton("Submit");

		// containers

		Box boxNoteEditHeader = Box.createHorizontalBox();
		boxNoteEditHeader.add(Box.createHorizontalGlue());
		boxNoteEditHeader.add(labelNoteEdit);

		Box boxNoteEditCourseLabel = Box.createHorizontalBox();
		boxNoteEditCourseLabel.add(Box.createHorizontalGlue());
		boxNoteEditCourseLabel.add(new JLabel("Select Course"));

		Box boxNoteEditCourseComboBox = Box.createHorizontalBox();
		boxNoteEditCourseComboBox.add(Box.createHorizontalStrut(358));
		boxNoteEditCourseComboBox.add(comboBoxNoteEditCourses);

		Box boxNoteEditSectionLabel = Box.createHorizontalBox();
		boxNoteEditSectionLabel.add(Box.createHorizontalGlue());
		boxNoteEditSectionLabel.add(new JLabel("Select Section"));

		Box boxNoteEditSectionComboBox = Box.createHorizontalBox();
		boxNoteEditSectionComboBox.add(Box.createHorizontalStrut(358));
		boxNoteEditSectionComboBox.add(comboBoxNoteEditSections);

		Box boxNoteEditNoteNameLabel = Box.createHorizontalBox();
		boxNoteEditNoteNameLabel.add(Box.createHorizontalGlue());
		boxNoteEditNoteNameLabel.add(new JLabel("Note Name"));

		Box boxNoteEditNoteTextLabel = Box.createHorizontalBox();
		boxNoteEditNoteTextLabel.add(Box.createHorizontalGlue());
		boxNoteEditNoteTextLabel.add(new JLabel("Note Text"));

		Box boxNoteEditButtons = Box.createHorizontalBox();
		boxNoteEditButtons.add(Box.createHorizontalGlue());
		boxNoteEditButtons.add(buttonNoteEditCancel);
		boxNoteEditButtons.add(Box.createHorizontalStrut(10));
		boxNoteEditButtons.add(buttonNoteEditSubmit);

		Box boxNoteEdit = Box.createVerticalBox();
		boxNoteEdit.add(boxNoteEditHeader);
		boxNoteEdit.add(Box.createVerticalStrut(10));
		boxNoteEdit.add(new JSeparator(JSeparator.HORIZONTAL));
		boxNoteEdit.add(Box.createVerticalStrut(10));
		boxNoteEdit.add(boxNoteEditCourseLabel);
		boxNoteEdit.add(boxNoteEditCourseComboBox);
		boxNoteEdit.add(Box.createVerticalStrut(10));
		boxNoteEdit.add(boxNoteEditSectionLabel);
		boxNoteEdit.add(boxNoteEditSectionComboBox);
		boxNoteEdit.add(Box.createVerticalStrut(10));
		boxNoteEdit.add(boxNoteEditNoteNameLabel);
		boxNoteEdit.add(textFieldNoteEditNoteName);
		boxNoteEdit.add(Box.createVerticalStrut(10));
		boxNoteEdit.add(boxNoteEditNoteTextLabel);
		boxNoteEdit.add(scrollPaneNoteEditNoteText);
		boxNoteEdit.add(Box.createVerticalStrut(10));
		boxNoteEdit.add(boxNoteEditButtons);

		return boxNoteEdit;
	}

	/**
	 * Creates view note panel.
	 * @return <tt>Box</tt> object.
	 */
	private Box boxNoteView()
	{
		// components

		buttonNoteViewNoteAdd = new JButton("Add Note");
		buttonNoteViewNoteDelete = new JButton("Delete Note");
		buttonNoteViewNoteEdit = new JButton("Edit Note");

		textFieldNoteViewCourseName = new JTextField();
		textFieldNoteViewCourseName.setAlignmentX(LEFT_ALIGNMENT);
		textFieldNoteViewCourseName.setEnabled(false);
		textFieldNoteViewCourseName.setPreferredSize(new Dimension(200, textFieldNoteViewCourseName.getPreferredSize().height));

		textFieldNoteViewSectionName = new JTextField();
		textFieldNoteViewSectionName.setAlignmentX(LEFT_ALIGNMENT);
		textFieldNoteViewSectionName.setEnabled(false);
		textFieldNoteViewSectionName.setPreferredSize(new Dimension(200, textFieldNoteViewSectionName.getPreferredSize().height));

		textFieldNoteViewNoteName = new JTextField();
		textFieldNoteViewNoteName.setEnabled(false);
		textFieldNoteViewNoteName.setPreferredSize(new Dimension(558, textFieldNoteViewNoteName.getPreferredSize().height));

		textAreaNoteViewNoteText = new JTextArea();
		textAreaNoteViewNoteText.setEnabled(false);
		textAreaNoteViewNoteText.setLineWrap(true);
		textAreaNoteViewNoteText.setWrapStyleWord(true);

		JScrollPane scrollPaneNoteViewNoteText = new JScrollPane(textAreaNoteViewNoteText);
		scrollPaneNoteViewNoteText.setPreferredSize(new Dimension(558, 255));

		// containers

		Box boxNoteViewHeader = Box.createHorizontalBox();
		boxNoteViewHeader.add(buttonNoteViewNoteAdd);
		boxNoteViewHeader.add(Box.createHorizontalGlue());
		boxNoteViewHeader.add(buttonNoteViewNoteDelete);
		boxNoteViewHeader.add(Box.createHorizontalStrut(10));
		boxNoteViewHeader.add(buttonNoteViewNoteEdit);

		Box boxNoteViewCourseNameLabel = Box.createHorizontalBox();
		boxNoteViewCourseNameLabel.add(Box.createHorizontalGlue());
		boxNoteViewCourseNameLabel.add(new JLabel("Course"));

		Box boxNoteViewCourseNameTextField = Box.createHorizontalBox();
		boxNoteViewCourseNameTextField.add(Box.createHorizontalStrut(358));
		boxNoteViewCourseNameTextField.add(textFieldNoteViewCourseName);

		Box boxNoteViewSectionNameLabel = Box.createHorizontalBox();
		boxNoteViewSectionNameLabel.add(Box.createHorizontalGlue());
		boxNoteViewSectionNameLabel.add(new JLabel("Section"));

		Box boxNoteViewSectionNameTextField = Box.createHorizontalBox();
		boxNoteViewSectionNameTextField.add(Box.createHorizontalStrut(358));
		boxNoteViewSectionNameTextField.add(textFieldNoteViewSectionName);

		Box boxNoteViewNoteNameLabel = Box.createHorizontalBox();
		boxNoteViewNoteNameLabel.add(Box.createHorizontalGlue());
		boxNoteViewNoteNameLabel.add(new JLabel("Note Name"));

		Box boxNoteViewNoteTextLabel = Box.createHorizontalBox();
		boxNoteViewNoteTextLabel.add(Box.createHorizontalGlue());
		boxNoteViewNoteTextLabel.add(new JLabel("Note Text"));

		Box boxNoteView = Box.createVerticalBox();
		boxNoteView.add(boxNoteViewHeader);
		boxNoteView.add(Box.createVerticalStrut(10));
		boxNoteView.add(new JSeparator(JSeparator.HORIZONTAL));
		boxNoteView.add(Box.createVerticalStrut(10));
		boxNoteView.add(boxNoteViewCourseNameLabel);
		boxNoteView.add(boxNoteViewCourseNameTextField);
		boxNoteView.add(Box.createVerticalStrut(10));
		boxNoteView.add(boxNoteViewSectionNameLabel);
		boxNoteView.add(boxNoteViewSectionNameTextField);
		boxNoteView.add(Box.createVerticalStrut(10));
		boxNoteView.add(boxNoteViewNoteNameLabel);
		boxNoteView.add(textFieldNoteViewNoteName);
		boxNoteView.add(Box.createVerticalStrut(10));
		boxNoteView.add(boxNoteViewNoteTextLabel);
		boxNoteView.add(scrollPaneNoteViewNoteText);

		return boxNoteView;
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