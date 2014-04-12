/********************************************************
 *
 * Project : AcmeNote
 * File : AcmeNoteGraphicalUserInterface.java
 * Name : Shaun Christensen
 * Date : 2014.04.02
 *
 * Description : The AcmeNoteGrphicalUserInterface class contains methods to create the graphical user interface and process user input.
 *
 * Changes : 2014.04.07 by Shaun Christensen. Registered action, list, menu, and window event listeners. Extracted utility methods into AcmeNoteGraphicalUserInterfaceUtility class. Renamed class to AcmeNoteGraphicalUserInterface for consistency.
 *           2014.04.10 by Shaun Christensen. Refactored graphical user interface and utility methods.
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
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

/**
 * <tt>AcmeNoteGraphicalUserInterface</tt> class contains the graphical user interface; and action, list, menu, and window event listeners.
 *
 * @author Shaun Christensen
 */
@SuppressWarnings("serial")
public final class AcmeNoteGraphicalUserInterface extends JFrame implements ActionListener, ListSelectionListener, MenuListener, WindowListener
{
	// components

	// add javadoc comments when complete

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
	private JButton buttonSectionAddSubmit;
	private JButton buttonSectionDeleteSubmit;
	private JButton buttonSectionDeleteCancel;
	private JButton buttonSectionEditCancel;
	private JButton buttonSectionEditSubmit;
	private CardLayout cardLayout;
	private JCheckBox checkBoxCourseDelete;
	private JCheckBox checkBoxNoteDelete;
	private JCheckBox checkBoxSectionDelete;
	private JComboBox<String> comboBoxCourseDeleteCourses;
	private JComboBox<String> comboBoxCourseEditCourses;
	private JComboBox<String> comboBoxNoteAddCourses;
	private JComboBox<String> comboBoxNoteAddSections;
	private JComboBox<String> comboBoxNoteEditCourses;
	private JComboBox<String> comboBoxNoteEditSections;
	private JComboBox<String> comboBoxNotesSearchCourses;
	private JComboBox<String> comboBoxNotesSearchSections;
	private JComboBox<String> comboBoxSectionAddCourses;
	private JComboBox<String> comboBoxSectionDeleteCourses;
	private JComboBox<String> comboBoxSectionDeleteSections;
	private JComboBox<String> comboBoxSectionEditCourses;
	private JComboBox<String> comboBoxSectionEditSections;
	private JList<String> listNotes;
	private JMenu menuCourse;
	private JMenu menuSection;
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

	/**
	 * <tt>AcmeNote</tt> object containing the <tt>ArrayList</tt> of courses and
	 * serialization methods.
	 */
	private AcmeNote acmeNote;

	// add javadoc when complete

	private int intCourseIndex;
	private int intNoteIndex;
	private int intSectionIndex;

	// add javadoc when complete

	private int[] intCourses;
	private int[] intNoteCourses;
	private int[] intNotes;
	private int[] intNoteSections;
	private int[] intSectionCourses;
	private int[] intSections;
	private int[] intTemporaryCourses;
	private int[] intTemporaryNoteCourses;
	private int[] intTemporaryNotes;
	private int[] intTemporaryNoteSections;
	private int[] intTemporarySectionCourses;
	private int[] intTemporarySections;

	// add javadoc when complete

	private String[] stringCourses;
	private String[] stringNotes;
	private String[] stringSections;
	private String[] stringTemporaryCourses;
	private String[] stringTemporaryNotes;
	private String[] stringTemporarySections;

	// constructors

	/**
	 * No argument default constructor.
	 */
	public AcmeNoteGraphicalUserInterface()
	{
		acmeNote = new AcmeNote();

		graphicalUserInterfaceCreate();
	}

	// graphical user interface methods

	/**
	 * Calls associated methods to create graphical user interface.
	 */
	private void graphicalUserInterfaceCreate()
	{
		setIndex("course", -1);
		setIndex("section", -1);
		setIndex("note", -1);
		setCoursesAll();
		setSectionsAll(intCourseIndex);
		setNotesAll(intCourseIndex, intSectionIndex);
		add(panelCreate());
		actionListenersAdd();
		listSelectionListenersAdd();
		menuListenersAdd();
		windowListenersAdd();
	}

	/**
	 * Calls associated methods to create menu and content cards.
	 *
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
	 *
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

		menuCourse = new JMenu("Course");
		menuCourse.add(menuItemCourseAdd);
		menuCourse.add(menuItemCourseDelete);
		menuCourse.add(menuItemCourseEdit);
		menuCourse.setMnemonic(KeyEvent.VK_C);

		menuSection = new JMenu("Section");
		menuSection.add(menuItemSectionAdd);
		menuSection.add(menuItemSectionDelete);
		menuSection.add(menuItemSectionEdit);
		menuSection.setMnemonic(KeyEvent.VK_S);

		// containers

		JMenuBar menuBar = new JMenuBar();

		JMenu menu = new JMenu("File");
		menu.add(menuItemFileQuit);
		menu.setMnemonic(KeyEvent.VK_F);

		menuBar.add(menu);

		menuBar.add(menuCourse);
		menuBar.add(menuSection);

		menu = new JMenu("Help");
		menu.add(menuItemHelpAbout);
		menu.add(menuItemHelpDocumentation);
		menu.setMnemonic(KeyEvent.VK_H);

		menuBar.add(menu);

		return menuBar;
	}

	/**
	 * Creates notes search panel.
	 *
	 * @return <tt>JPanel</tt> object.
	 */
	private JPanel panelNotesSearch()
	{
		// components

		comboBoxNotesSearchCourses = new JComboBox<String>(stringCourses);
		comboBoxNotesSearchCourses.setAlignmentX(LEFT_ALIGNMENT);
		comboBoxNotesSearchCourses.setPreferredSize(new Dimension(200, comboBoxNotesSearchCourses.getPreferredSize().height));

		comboBoxNotesSearchSections = new JComboBox<String>(stringSections);
		comboBoxNotesSearchSections.setAlignmentX(LEFT_ALIGNMENT);
		comboBoxNotesSearchSections.setPreferredSize(new Dimension(200, comboBoxNotesSearchSections.getPreferredSize().height));

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
	 *
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
	
		cardLayout = (CardLayout) (panelCards.getLayout());
	
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(panelCards, BorderLayout.NORTH);
	
		return panel;
	}

	/**
	 * Creates default panel.
	 *
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
	 *
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
	 *
	 * @return <tt>Box</tt> object.
	 */
	private Box boxCourseDelete()
	{
		// components
	
		JLabel labelCourseDelete = new JLabel("Delete Course");
		labelCourseDelete.setFont(new Font("Serif", Font.BOLD, 25));
	
		comboBoxCourseDeleteCourses = new JComboBox<String>(stringTemporaryCourses);
		comboBoxCourseDeleteCourses.setAlignmentX(LEFT_ALIGNMENT);
		comboBoxCourseDeleteCourses.setPreferredSize(new Dimension(200, comboBoxCourseDeleteCourses.getPreferredSize().height));
	
		checkBoxCourseDelete = new JCheckBox("Please check here to confirm deletion of the course.");
	
		buttonCourseDeleteCancel = new JButton("Cancel");
		buttonCourseDeleteSubmit = new JButton("Submit");
	
		// containers
	
		Box boxCourseDeleteHeader = Box.createHorizontalBox();
		boxCourseDeleteHeader.add(Box.createHorizontalGlue());
		boxCourseDeleteHeader.add(labelCourseDelete);
	
		Box boxCourseDeleteCourseLabel = Box.createHorizontalBox();
		boxCourseDeleteCourseLabel.add(Box.createHorizontalGlue());
		boxCourseDeleteCourseLabel.add(new JLabel("Select Course"));
	
		Box boxCourseDeleteCourseComboBox = Box.createHorizontalBox();
		boxCourseDeleteCourseComboBox.add(Box.createHorizontalStrut(358));
		boxCourseDeleteCourseComboBox.add(comboBoxCourseDeleteCourses);
		
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
		boxCourseDelete.add(boxCourseDeleteCourseLabel);
		boxCourseDelete.add(boxCourseDeleteCourseComboBox);
		boxCourseDelete.add(Box.createVerticalStrut(10));
		boxCourseDelete.add(boxCourseDeleteWarningAssociatedLabel);
		boxCourseDelete.add(Box.createVerticalStrut(10));
		boxCourseDelete.add(boxCourseDeleteWarningPermanentLabel);
		boxCourseDelete.add(Box.createVerticalStrut(10));
		boxCourseDelete.add(boxCourseDeleteCheckBox);
		boxCourseDelete.add(Box.createVerticalStrut(10));
		boxCourseDelete.add(boxCourseDeleteButtons);
		boxCourseDelete.add(Box.createVerticalStrut(239));
		
		return boxCourseDelete;
	}
	
	/**
	 * Creates edit course panel.
	 *
	 * @return <tt>Box</tt> object.
	 */
	private Box boxCourseEdit()
	{
		// components
	
		JLabel labelCourseEdit = new JLabel("Edit Course");
		labelCourseEdit.setFont(new Font("Serif", Font.BOLD, 25));
		
		comboBoxCourseEditCourses = new JComboBox<String>(stringTemporaryCourses);
		comboBoxCourseEditCourses.setAlignmentX(LEFT_ALIGNMENT);
		comboBoxCourseEditCourses.setPreferredSize(new Dimension(200, comboBoxCourseEditCourses.getPreferredSize().height));
		
		textFieldCourseEditCourseName = new JTextField();
		textFieldCourseEditCourseName.setPreferredSize(new Dimension(200, textFieldCourseEditCourseName.getPreferredSize().height));
		
		buttonCourseEditCancel = new JButton("Cancel");
		buttonCourseEditSubmit = new JButton("Submit");
		
				// containers
		
		Box boxCourseEditHeader = Box.createHorizontalBox();
		boxCourseEditHeader.add(Box.createHorizontalGlue());
		boxCourseEditHeader.add(labelCourseEdit);
		
		Box boxCourseEditCourseLabel = Box.createHorizontalBox();
		boxCourseEditCourseLabel.add(Box.createHorizontalGlue());
		boxCourseEditCourseLabel.add(new JLabel("Select Course"));
		
		Box boxCourseEditCourseComboBox = Box.createHorizontalBox();
		boxCourseEditCourseComboBox.add(Box.createHorizontalStrut(358));
		boxCourseEditCourseComboBox.add(comboBoxCourseEditCourses);
		
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
		boxCourseEdit.add(boxCourseEditCourseLabel);
		boxCourseEdit.add(boxCourseEditCourseComboBox);
		boxCourseEdit.add(Box.createVerticalStrut(10));
		boxCourseEdit.add(boxCourseEditCourseNameLabel);
		boxCourseEdit.add(boxCourseEditCourseNameTextField);
		boxCourseEdit.add(Box.createVerticalStrut(10));
		boxCourseEdit.add(boxCourseEditButtons);
		boxCourseEdit.add(Box.createVerticalStrut(279));
		
		return boxCourseEdit;
	}
	
	/**
	 * Creates add section panel.
	 *
	 * @return <tt>Box</tt> object.
	 */
	private Box boxSectionAdd()
	{
		// components
		
		JLabel labelSectionAdd = new JLabel("Add Section");
		labelSectionAdd.setFont(new Font("Serif", Font.BOLD, 25));
		
		comboBoxSectionAddCourses = new JComboBox<String>(stringTemporaryCourses);
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
	 *
	 * @return <tt>Box</tt> object.
	 */
	private Box boxSectionDelete()
	{
		// components
		
		JLabel labelSectionDelete = new JLabel("Delete Section");
		labelSectionDelete.setFont(new Font("Serif", Font.BOLD, 25));
		
		comboBoxSectionDeleteCourses = new JComboBox<String>(stringTemporaryCourses);
		comboBoxSectionDeleteCourses.setAlignmentX(LEFT_ALIGNMENT);
		comboBoxSectionDeleteCourses.setPreferredSize(new Dimension(200, comboBoxSectionDeleteCourses.getPreferredSize().height));
		
		comboBoxSectionDeleteSections = new JComboBox<String>(stringTemporarySections);
		comboBoxSectionDeleteSections.setAlignmentX(LEFT_ALIGNMENT);
		comboBoxSectionDeleteSections.setPreferredSize(new Dimension(200, comboBoxSectionDeleteSections.getPreferredSize().height));
		
		checkBoxSectionDelete = new JCheckBox("Please check here to confirm deletion of the section.");
		
		buttonSectionDeleteCancel = new JButton("Cancel");
		buttonSectionDeleteSubmit = new JButton("Submit");
		
				// containers
		
		Box boxSectionDeleteHeader = Box.createHorizontalBox();
		boxSectionDeleteHeader.add(Box.createHorizontalGlue());
		boxSectionDeleteHeader.add(labelSectionDelete);
		
		Box boxSectionDeleteCourseLabel = Box.createHorizontalBox();
		boxSectionDeleteCourseLabel.add(Box.createHorizontalGlue());
		boxSectionDeleteCourseLabel.add(new JLabel("Select Course"));
		
		Box boxSectionDeleteCourseComboBox = Box.createHorizontalBox();
		boxSectionDeleteCourseComboBox.add(Box.createHorizontalStrut(358));
		boxSectionDeleteCourseComboBox.add(comboBoxSectionDeleteCourses);
		
		Box boxSectionDeleteSectionLabel = Box.createHorizontalBox();
		boxSectionDeleteSectionLabel.add(Box.createHorizontalGlue());
		boxSectionDeleteSectionLabel.add(new JLabel("Select Section"));
		
		Box boxSectionDeleteSectionComboBox = Box.createHorizontalBox();
		boxSectionDeleteSectionComboBox.add(Box.createHorizontalStrut(358));
		boxSectionDeleteSectionComboBox.add(comboBoxSectionDeleteSections);
		
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
		boxSectionDelete.add(boxSectionDeleteCourseLabel);
		boxSectionDelete.add(boxSectionDeleteCourseComboBox);
		boxSectionDelete.add(Box.createVerticalStrut(10));
		boxSectionDelete.add(boxSectionDeleteSectionLabel);
		boxSectionDelete.add(boxSectionDeleteSectionComboBox);
		boxSectionDelete.add(Box.createVerticalStrut(10));
		boxSectionDelete.add(boxSectionDeleteWarningAssociatedLabel);
		boxSectionDelete.add(Box.createVerticalStrut(10));
		boxSectionDelete.add(boxSectionDeleteWarningPermanentLabel);
		boxSectionDelete.add(Box.createVerticalStrut(10));
		boxSectionDelete.add(boxSectionDeleteCheckBox);
		boxSectionDelete.add(Box.createVerticalStrut(10));
		boxSectionDelete.add(boxSectionDeleteButtons);
		boxSectionDelete.add(Box.createVerticalStrut(188));
		
		return boxSectionDelete;
	}
	
	/**
	 * Creates edit section panel.
	 *
	 * @return <tt>Box</tt> object.
	 */
	private Box boxSectionEdit()
	{
		// components
		
		JLabel labelSectionEdit = new JLabel("Edit Section");
		labelSectionEdit.setFont(new Font("Serif", Font.BOLD, 25));
		
		comboBoxSectionEditCourses = new JComboBox<String>(stringTemporaryCourses);
		comboBoxSectionEditCourses.setAlignmentX(LEFT_ALIGNMENT);
		comboBoxSectionEditCourses.setPreferredSize(new Dimension(200, comboBoxSectionEditCourses.getPreferredSize().height));
		
		comboBoxSectionEditSections = new JComboBox<String>(stringTemporarySections);
		comboBoxSectionEditSections.setAlignmentX(LEFT_ALIGNMENT);
		comboBoxSectionEditSections.setPreferredSize(new Dimension(200, comboBoxSectionEditSections.getPreferredSize().height));
		
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
		
		Box boxSectionEditSectionLabel = Box.createHorizontalBox();
		boxSectionEditSectionLabel.add(Box.createHorizontalGlue());
		boxSectionEditSectionLabel.add(new JLabel("Select Section"));
		
		Box boxSectionEditSectionComboBox = Box.createHorizontalBox();
		boxSectionEditSectionComboBox.add(Box.createHorizontalStrut(358));
		boxSectionEditSectionComboBox.add(comboBoxSectionEditSections);
		
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
		boxSectionEdit.add(boxSectionEditSectionLabel);
		boxSectionEdit.add(boxSectionEditSectionComboBox);
		boxSectionEdit.add(Box.createVerticalStrut(10));
		boxSectionEdit.add(boxSectionEditSectionNameLabel);
		boxSectionEdit.add(boxSectionEditCourseNameTextField);
		boxSectionEdit.add(Box.createVerticalStrut(10));
		boxSectionEdit.add(boxSectionEditButtons);
		boxSectionEdit.add(Box.createVerticalStrut(228));
		
		return boxSectionEdit;
	}
	
	/**
	 * Creates add note panel.
	 *
	 * @return <tt>Box</tt> object.
	 */
	private Box boxNoteAdd()
	{
		// components
		
		JLabel labelNoteAdd = new JLabel("Add Note");
		labelNoteAdd.setFont(new Font("Serif", Font.BOLD, 25));
		
		comboBoxNoteAddCourses = new JComboBox<String>(stringTemporaryCourses);
		comboBoxNoteAddCourses.setAlignmentX(LEFT_ALIGNMENT);
		comboBoxNoteAddCourses.setPreferredSize(new Dimension(200, comboBoxNoteAddCourses.getPreferredSize().height));
		
		comboBoxNoteAddSections = new JComboBox<String>(stringTemporarySections);
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
	 *
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
	 *
	 * @return <tt>Box</tt> object.
	 */
	private Box boxNoteEdit()
	{
		// components
		
		JLabel labelNoteEdit = new JLabel("Edit Note");
		labelNoteEdit.setFont(new Font("Serif", Font.BOLD, 25));
		
		comboBoxNoteEditCourses = new JComboBox<>(stringTemporaryCourses);
		comboBoxNoteEditCourses.setAlignmentX(LEFT_ALIGNMENT);
		comboBoxNoteEditCourses.setPreferredSize(new Dimension(200, comboBoxNoteEditCourses.getPreferredSize().height));
		
		comboBoxNoteEditSections = new JComboBox<>(stringTemporarySections);
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
	 *
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
		textFieldNoteViewCourseName.setEditable(false);
		textFieldNoteViewCourseName.setPreferredSize(new Dimension(200, textFieldNoteViewCourseName.getPreferredSize().height));
		
		textFieldNoteViewSectionName = new JTextField();
		textFieldNoteViewSectionName.setAlignmentX(LEFT_ALIGNMENT);
		textFieldNoteViewSectionName.setEditable(false);
		textFieldNoteViewSectionName.setPreferredSize(new Dimension(200, textFieldNoteViewSectionName.getPreferredSize().height));
		
		textFieldNoteViewNoteName = new JTextField();
		textFieldNoteViewNoteName.setEditable(false);
		textFieldNoteViewNoteName.setPreferredSize(new Dimension(558, textFieldNoteViewNoteName.getPreferredSize().height));
		
		textAreaNoteViewNoteText = new JTextArea();
		textAreaNoteViewNoteText.setEditable(false);
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
		buttonCourseAddCancel.addActionListener(this);
		buttonCourseAddSubmit.addActionListener(this);
		buttonCourseDeleteCancel.addActionListener(this);
		buttonCourseDeleteSubmit.addActionListener(this);
		buttonCourseEditCancel.addActionListener(this);
		buttonCourseEditSubmit.addActionListener(this);
		buttonNoteAddCancel.addActionListener(this);
		buttonNoteAddSubmit.addActionListener(this);
		buttonNoteDeleteCancel.addActionListener(this);
		buttonNoteDeleteSubmit.addActionListener(this);
		buttonNoteEditCancel.addActionListener(this);
		buttonNoteEditSubmit.addActionListener(this);
		buttonNoteNullNoteAdd.addActionListener(this);
		buttonNoteNullNoteDelete.addActionListener(this);
		buttonNoteNullNoteEdit.addActionListener(this);
		buttonNotesSearchCancel.addActionListener(this);
		buttonNotesSearchSearch.addActionListener(this);
		buttonNoteViewNoteAdd.addActionListener(this);
		buttonNoteViewNoteDelete.addActionListener(this);
		buttonNoteViewNoteEdit.addActionListener(this);
		buttonSectionAddCancel.addActionListener(this);
		buttonSectionAddSubmit.addActionListener(this);
		buttonSectionDeleteSubmit.addActionListener(this);
		buttonSectionDeleteCancel.addActionListener(this);
		buttonSectionEditCancel.addActionListener(this);
		buttonSectionEditSubmit.addActionListener(this);
		checkBoxCourseDelete.addActionListener(this);
		checkBoxNoteDelete.addActionListener(this);
		checkBoxSectionDelete.addActionListener(this);
		comboBoxCourseDeleteCourses.addActionListener(this);
		comboBoxCourseEditCourses.addActionListener(this);
		comboBoxNoteAddCourses.addActionListener(this);
		comboBoxNoteAddSections.addActionListener(this);
		comboBoxNoteEditCourses.addActionListener(this);
		comboBoxNoteEditSections.addActionListener(this);
		comboBoxNotesSearchCourses.addActionListener(this);
		comboBoxNotesSearchSections.addActionListener(this);
		comboBoxSectionAddCourses.addActionListener(this);
		comboBoxSectionDeleteCourses.addActionListener(this);
		comboBoxSectionDeleteSections.addActionListener(this);
		comboBoxSectionEditCourses.addActionListener(this);
		comboBoxSectionEditSections.addActionListener(this);
		menuCourse.addActionListener(this);
		menuSection.addActionListener(this);
		menuItemCourseAdd.addActionListener(this);
		menuItemCourseDelete.addActionListener(this);
		menuItemCourseEdit.addActionListener(this);
		menuItemFileQuit.addActionListener(this);
		menuItemHelpAbout.addActionListener(this);
		menuItemHelpDocumentation.addActionListener(this);
		menuItemSectionAdd.addActionListener(this);
		menuItemSectionDelete.addActionListener(this);
		menuItemSectionEdit.addActionListener(this);
	}
	
	private void listSelectionListenersAdd()
	{
		listNotes.addListSelectionListener(this);
	}
	
	private void menuListenersAdd()
	{
		menuCourse.addMenuListener(this);
		menuSection.addMenuListener(this);
	}
	
	private void windowListenersAdd()
	{
		addWindowListener(this);
	}
	
	// action event listeners
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == buttonCourseAddCancel || e.getSource() == buttonCourseDeleteCancel || e.getSource() == buttonCourseEditCancel || e.getSource() == buttonNoteAddCancel || e.getSource() == buttonNoteDeleteCancel || e.getSource() == buttonNoteEditCancel || e.getSource() == buttonSectionAddCancel || e.getSource() == buttonSectionDeleteCancel || e.getSource() == buttonSectionEditCancel)
		{
			for (ListSelectionListener l : listNotes.getListSelectionListeners())
			{
				l.valueChanged(new ListSelectionEvent(listNotes, intNoteIndex, intNoteIndex, false));
			}

			enableComponents();
		}
		else if (e.getSource() == buttonCourseAddSubmit)
		{
			if (acmeNote.addCourse(new Course(textFieldCourseAddCourseName.getText())))
			{
				setCoursesAll();
				setComboBoxSelectedIndex(comboBoxNotesSearchCourses, stringCourses, acmeNote.getCourses().size());
				showCard("NoteNull");
				enableComponents();
			}
			else
			{
				showErrorMessage("Unable to add course. Please try again.");
			}
		}
		else if (e.getSource() == buttonCourseDeleteSubmit)
		{
			if (acmeNote.removeCourse(intCourseIndex))
			{
				if (intCourses[comboBoxNotesSearchCourses.getSelectedIndex()] > intCourseIndex)
				{
					comboBoxNotesSearchCourses.setSelectedIndex(comboBoxNotesSearchCourses.getSelectedIndex() - 1);
				}
				else if (intCourses[comboBoxNotesSearchCourses.getSelectedIndex()] == intCourseIndex)
				{
					comboBoxNotesSearchCourses.setSelectedIndex(0);
				}

				setCoursesAll();
				setComboBoxSelectedIndex(comboBoxNotesSearchCourses, stringCourses, comboBoxNotesSearchCourses.getSelectedIndex());
				showCard("NoteNull");		
				enableComponents();
			}
			else
			{
				showErrorMessage("Unable to delete course. Please try again.");
			}
		}
		else if (e.getSource() == buttonCourseEditSubmit)
		{
			if (acmeNote.getCourse(intCourseIndex).setCourseName(textFieldCourseEditCourseName.getText()))
			{
				setCoursesAll();
				setComboBoxSelectedIndex(comboBoxNotesSearchCourses, stringCourses, intCourseIndex + 1);
				showCard("NoteNull");
				enableComponents();
			}
			else
			{
				showErrorMessage("Unable to edit course. Please try again.");
			}
		}
		else if (e.getSource() == buttonNoteAddSubmit)
		{
			if (acmeNote.getCourse(intCourseIndex).getSection(intSectionIndex).addNote(new Note(textFieldNoteAddNoteName.getText(), textAreaNoteAddNoteText.getText())))
			{
				int section = intSectionIndex + 1;
				int note = acmeNote.getCourse(intCourseIndex).getSection(intSectionIndex).getNotes().size() - 1;

				setComboBoxSelectedIndex(comboBoxNotesSearchCourses, stringCourses, intCourseIndex + 1);
				setComboBoxSelectedIndex(comboBoxNotesSearchSections, stringSections, section);
				setListSelectedIndex(listNotes, stringNotes, note);
				showCard("NoteView");
				enableComponents();
			}
			else
			{
				showErrorMessage("Unable to add note. Please try again.");
			}
		}
		else if (e.getSource() == buttonNoteDeleteSubmit)
		{
			if (acmeNote.getCourse(intCourseIndex).getSection(intSectionIndex).removeNote(intNoteIndex))
			{
				setNotesAll(intCourseIndex, intSectionIndex);
				setListSelectedIndex(listNotes, stringNotes, -1);
				showCard("NoteNull");
				enableComponents();
			}
			else
			{
				showErrorMessage("Unable to delete note. Please try again.");
			}
		}
		else if (e.getSource() == buttonNoteEditSubmit)
		{
			if (intNoteCourses[listNotes.getSelectedIndex()] == intCourseIndex && intNoteSections[listNotes.getSelectedIndex()] == intSectionIndex)
			{
				if (acmeNote.getCourse(intCourseIndex).getSection(intSectionIndex).getNote(intNoteIndex).setNoteName(textFieldNoteEditNoteName.getText()) && acmeNote.getCourse(intCourseIndex).getSection(intSectionIndex).getNote(intNoteIndex).setNoteName(textAreaNoteEditNoteText.getText()))
				{
					setNotesAll(intCourseIndex, intSectionIndex);
					setListSelectedIndex(listNotes, stringNotes, intNoteIndex);
				}
				else
				{
					showErrorMessage("Unable to edit note. Please try again.");
				}
			}
			else
			{
				if (acmeNote.getCourse(intCourseIndex).getSection(intSectionIndex).addNote(new Note(textFieldNoteEditNoteName.getText(), textAreaNoteEditNoteText.getText())))
				{
					if (acmeNote.getCourse(intNoteCourses[listNotes.getSelectedIndex()]).getSection(intNoteSections[listNotes.getSelectedIndex()]).removeNote(intNotes[listNotes.getSelectedIndex()]))
					{
						int section = intSectionIndex + 1;
						int note = acmeNote.getCourse(intCourseIndex).getSection(intSectionIndex).getNotes().size() - 1;

						setComboBoxSelectedIndex(comboBoxNotesSearchCourses, stringCourses, intCourseIndex + 1);
						setComboBoxSelectedIndex(comboBoxNotesSearchSections, stringSections, section);
						setListSelectedIndex(listNotes, stringNotes, note);
					}
					else
					{
						showErrorMessage("Unable to edit note. Please try again.");
					}
				}
				else
				{
					showErrorMessage("Unable to edit note. Please try again.");
				}
			}

			showCard("NoteView");
			enableComponents();
		}
		else if (e.getSource() == buttonNoteNullNoteAdd || e.getSource() == buttonNoteViewNoteAdd)
		{
			disableComponents();

			if (intCourseIndex < 0 && intSectionIndex < 0)
			{
				setIndex("course", 0);
				setIndex("section", 0);
			}
			else if (intCourseIndex < 0)
			{
				setIndex("course", intSectionCourses[comboBoxNotesSearchSections.getSelectedIndex()]);
			}
			else if (intSectionIndex < 0)
			{
				setIndex("section", 0);
			}

			int section = intSectionIndex;

			setCourses();
			setComboBoxSelectedIndex(comboBoxNoteAddCourses, stringTemporaryCourses, intCourseIndex);
			setSections(intCourseIndex);
			setComboBoxSelectedIndex(comboBoxNoteAddSections, stringTemporarySections, section);
			showCard("NoteAdd");

			comboBoxNoteAddCourses.requestFocus();
		}
		else if (e.getSource() == buttonNotesSearchCancel)
		{
			textFieldNotesSearch.setText("");

			setIndex("course", intCourses[comboBoxNotesSearchCourses.getSelectedIndex()]);
			setIndex("section", intSections[comboBoxNotesSearchSections.getSelectedIndex()]);
			setIndex("note", -1);
			setNotesAll(intCourseIndex, intSectionIndex);
			setListSelectedIndex(listNotes, stringNotes, intNoteIndex);
		}
		else if (e.getSource() == buttonNotesSearchSearch)
		{
			setIndex("course", intCourses[comboBoxNotesSearchCourses.getSelectedIndex()]);
			setIndex("section", intSections[comboBoxNotesSearchSections.getSelectedIndex()]);
			setIndex("note", -1);
			setNotesAll(intCourseIndex, intSectionIndex);
			searchNotes(textFieldNotesSearch.getText());
			setListSelectedIndex(listNotes, stringNotes, intNoteIndex);
		}
		else if (e.getSource() == buttonNoteViewNoteDelete)
		{
			disableComponents();

			buttonNoteDeleteSubmit.setEnabled(false);
			checkBoxNoteDelete.setSelected(false);

			showCard("NoteDelete");

			checkBoxNoteDelete.requestFocus();
		}
		else if (e.getSource() == buttonNoteViewNoteEdit)
		{
			disableComponents();

			if (intCourseIndex < 0 && intSectionIndex < 0)
			{
				setIndex("course", 0);
				setIndex("section", 0);
			}
			else if (intCourseIndex < 0)
			{
				setIndex("course", intSectionCourses[comboBoxNotesSearchSections.getSelectedIndex()]);
			}
			else if (intSectionIndex < 0)
			{
				setIndex("section", 0);
			}

			int section = intSectionIndex;

			setCourses();
			setComboBoxSelectedIndex(comboBoxNoteEditCourses, stringTemporaryCourses, intCourseIndex);
			setSections(intCourseIndex);
			setComboBoxSelectedIndex(comboBoxNoteEditSections, stringTemporarySections, section);
			showCard("NoteEdit");

			comboBoxNoteEditCourses.requestFocus();
		}
		else if (e.getSource() == buttonSectionAddSubmit)
		{
			if (acmeNote.getCourse(intCourseIndex).addSection(new Section(textFieldSectionAddSectionName.getText())))
			{
				int section = acmeNote.getCourse(intCourseIndex).getSections().size();

				setComboBoxSelectedIndex(comboBoxNotesSearchCourses, stringCourses, intCourseIndex + 1);
				setComboBoxSelectedIndex(comboBoxNotesSearchSections, stringSections, section);
				showCard("NoteNull");
				enableComponents();
			}
			else
			{
				showErrorMessage("Unable to add section. Please try again.");
			}
		}
		else if (e.getSource() == buttonSectionDeleteSubmit)
		{
			if (acmeNote.getCourse(intCourseIndex).removeSection(intSectionIndex))
			{
				if (intCourses[comboBoxNotesSearchCourses.getSelectedIndex()] != intCourseIndex)
				{
					setIndex("course", intCourses[comboBoxNotesSearchCourses.getSelectedIndex()]);
					setIndex("section", intSections[comboBoxNotesSearchSections.getSelectedIndex()]);
				}
				else if (intSections[comboBoxNotesSearchSections.getSelectedIndex()] > intSectionIndex)
				{
					comboBoxNotesSearchSections.setSelectedIndex(comboBoxNotesSearchSections.getSelectedIndex() - 1);
				}
				else if (intSections[comboBoxNotesSearchSections.getSelectedIndex()] == intSectionIndex)
				{
					comboBoxNotesSearchSections.setSelectedIndex(0);
				}

				setSectionsAll(intCourseIndex);
				setComboBoxSelectedIndex(comboBoxNotesSearchSections, stringSections, comboBoxNotesSearchSections.getSelectedIndex());
				showCard("NoteNull");
				enableComponents();
			}
			else
			{
				showErrorMessage("Unable to delete section. Please try again.");
			}
		}
		else if (e.getSource() == buttonSectionEditSubmit)
		{
			if (acmeNote.getCourse(intCourseIndex).getSection(intSectionIndex).setSectionName(textFieldSectionEditSectionName.getText()))
			{
				if (intCourses[comboBoxNotesSearchCourses.getSelectedIndex()] != intCourseIndex)
				{
					setIndex("course", intCourses[comboBoxNotesSearchCourses.getSelectedIndex()]);
					setIndex("section", intSections[comboBoxNotesSearchSections.getSelectedIndex()]);
				}

				setSectionsAll(intCourseIndex);
				setComboBoxSelectedIndex(comboBoxNotesSearchSections, stringSections, comboBoxNotesSearchSections.getSelectedIndex());
				showCard("NoteNull");
				enableComponents();
			}
			else
			{
				showErrorMessage("Unable to edit section. Please try again.");
			}
		}
		else if (e.getSource() == checkBoxCourseDelete)
		{
			if (checkBoxCourseDelete.isSelected() == true)
			{
				buttonCourseDeleteSubmit.setEnabled(true);
			}
			else
			{
				buttonCourseDeleteSubmit.setEnabled(false);
			}
		}
		else if (e.getSource() == checkBoxNoteDelete)
		{
			if (checkBoxNoteDelete.isSelected() == true)
			{
				buttonNoteDeleteSubmit.setEnabled(true);
			}
			else
			{
				buttonNoteDeleteSubmit.setEnabled(false);
			}
		}
		else if (e.getSource() == checkBoxSectionDelete)
		{
			if (checkBoxSectionDelete.isSelected() == true)
			{
				buttonSectionDeleteSubmit.setEnabled(true);
			}
			else
			{
				buttonSectionDeleteSubmit.setEnabled(false);
			}
		}
		else if (e.getSource() == comboBoxCourseDeleteCourses)
		{
			setIndex("course", intTemporaryCourses[comboBoxCourseDeleteCourses.getSelectedIndex()]);

			buttonCourseDeleteSubmit.setEnabled(false);
			checkBoxCourseDelete.setSelected(false);
		}
		else if (e.getSource() == comboBoxCourseEditCourses)
		{
			setIndex("course", intTemporaryCourses[comboBoxCourseEditCourses.getSelectedIndex()]);
			
			textFieldCourseEditCourseName.setText(comboBoxCourseEditCourses.getSelectedItem().toString());
		}
		else if (e.getSource() == comboBoxNoteAddCourses)
		{
			setIndex("course", intTemporaryCourses[comboBoxNoteAddCourses.getSelectedIndex()]);
			setIndex("section", 0);
			setSections(intCourseIndex);
			setComboBoxSelectedIndex(comboBoxNoteAddSections, stringTemporarySections, intSectionIndex);
		}
		else if (e.getSource() == comboBoxNoteAddSections)
		{
			setIndex("section", intTemporaryCourses[comboBoxNoteAddSections.getSelectedIndex()]);
		}
		else if (e.getSource() == comboBoxNoteEditCourses)
		{
			setIndex("course", intTemporaryCourses[comboBoxNoteEditCourses.getSelectedIndex()]);
			setIndex("section", 0);
			setSections(intCourseIndex);
			setComboBoxSelectedIndex(comboBoxNoteAddSections, stringTemporarySections, intSectionIndex);
		}
		else if (e.getSource() == comboBoxNoteEditSections)
		{
			setIndex("section", intTemporaryCourses[comboBoxNoteEditSections.getSelectedIndex()]);
		}
		else if (e.getSource() == comboBoxNotesSearchCourses)
		{
			setIndex("course", intCourses[comboBoxNotesSearchCourses.getSelectedIndex()]);
			setIndex("section", -1);
			setIndex("note", -1);
			setSectionsAll(intCourseIndex);
			setComboBoxSelectedIndex(comboBoxNotesSearchSections, stringSections, intSectionIndex);
			setNotesAll(intCourseIndex, intSectionIndex);
			setListSelectedIndex(listNotes, stringNotes, intNoteIndex);
		}
		else if (e.getSource() == comboBoxNotesSearchSections)
		{
			setIndex("section", intSections[comboBoxNotesSearchSections.getSelectedIndex()]);
			setIndex("note", -1);
			setNotesAll(intCourseIndex, intSectionIndex);
			setListSelectedIndex(listNotes, stringNotes, intNoteIndex);
		}
		else if (e.getSource() == comboBoxSectionAddCourses)
		{
			setIndex("course", intTemporaryCourses[comboBoxSectionAddCourses.getSelectedIndex()]);
		}
		else if (e.getSource() == comboBoxSectionDeleteCourses)
		{
			setIndex("course", intTemporaryCourses[comboBoxSectionDeleteCourses.getSelectedIndex()]);
			setIndex("section", 0);
			setSections(intCourseIndex);
			setComboBoxSelectedIndex(comboBoxSectionDeleteSections, stringTemporarySections, intSectionIndex);

			if (acmeNote.getCourse(intCourseIndex).getSections().size() > 0)
			{
				checkBoxSectionDelete.setEnabled(true);
				comboBoxSectionDeleteSections.setEnabled(true);
			}
			else
			{
				checkBoxSectionDelete.setEnabled(false);
				comboBoxSectionDeleteSections.setEnabled(false);
			}

			buttonSectionDeleteSubmit.setEnabled(false);
			checkBoxSectionDelete.setSelected(false);
		}
		else if (e.getSource() == comboBoxSectionDeleteSections)
		{
			setIndex("section", intTemporarySections[comboBoxSectionDeleteSections.getSelectedIndex()]);

			buttonSectionDeleteSubmit.setEnabled(false);
			checkBoxSectionDelete.setSelected(false);
		}
		else if (e.getSource() == comboBoxSectionEditCourses)
		{
			setIndex("course", intTemporaryCourses[comboBoxSectionEditCourses.getSelectedIndex()]);
			setIndex("section", 0);
			setSections(intCourseIndex);
			setComboBoxSelectedIndex(comboBoxSectionEditSections, stringTemporarySections, intSectionIndex);

			if (acmeNote.getCourse(intCourseIndex).getSections().size() > 0)
			{
				buttonSectionEditSubmit.setEnabled(true);
				comboBoxSectionEditSections.setEnabled(true);
				textFieldSectionEditSectionName.setEnabled(true);
				textFieldSectionEditSectionName.setText(comboBoxSectionEditSections.getSelectedItem().toString());
			}
			else
			{
				buttonSectionEditSubmit.setEnabled(false);
				comboBoxSectionEditSections.setEnabled(false);
				textFieldSectionEditSectionName.setEnabled(false);
				textFieldSectionEditSectionName.setText("");
			}
		}
		else if (e.getSource() == comboBoxSectionEditSections)
		{
			setIndex("section", intTemporarySections[comboBoxSectionEditSections.getSelectedIndex()]);

			textFieldSectionEditSectionName.setText(comboBoxSectionEditSections.getSelectedItem().toString());
		}
		else if (e.getSource() == menuItemCourseAdd)
		{
			disableComponents();
		
			textFieldCourseAddCourseName.setText("");

			showCard("CourseAdd");

			textFieldCourseAddCourseName.requestFocus();
		}
		else if (e.getSource() == menuItemCourseDelete)
		{
			disableComponents();

			if (intCourseIndex < 0)
			{
				setIndex("course", 0);
			}

			setCourses();
			setComboBoxSelectedIndex(comboBoxCourseDeleteCourses, stringTemporaryCourses, intCourseIndex);

			buttonCourseDeleteSubmit.setEnabled(false);
			checkBoxCourseDelete.setSelected(false);

			showCard("CourseDelete");

			comboBoxCourseDeleteCourses.requestFocus();
		}
		else if (e.getSource() == menuItemCourseEdit)
		{
			disableComponents();

			if (intCourseIndex < 0)
			{
				setIndex("course", 0);
			}

			setCourses();
			setComboBoxSelectedIndex(comboBoxCourseEditCourses, stringTemporaryCourses, intCourseIndex);

			textFieldCourseEditCourseName.setText(comboBoxCourseEditCourses.getSelectedItem().toString());
			
			showCard("CourseEdit");

			comboBoxCourseEditCourses.requestFocus();
		}
		else if (e.getSource() == menuItemFileQuit)
		{
			acmeNote.serialize();
		
			System.exit(0);
		}
		else if (e.getSource() == menuItemHelpAbout)
		{
		// implement
		}
		else if (e.getSource() == menuItemHelpDocumentation)
		{
		// implement
		}
		else if (e.getSource() == menuItemSectionAdd)
		{
			disableComponents();

			if (intCourseIndex < 0)
			{
				setIndex("course", 0);
			}

			setCourses();
			setComboBoxSelectedIndex(comboBoxSectionAddCourses, stringTemporaryCourses, intCourseIndex);
			
			textFieldSectionAddSectionName.setText("");

			showCard("SectionAdd");
			
			comboBoxSectionAddCourses.requestFocus();
		}
		else if (e.getSource() == menuItemSectionDelete)
		{
			disableComponents();

			if (intCourseIndex < 0 && intSectionIndex < 0)
			{
				setIndex("course", 0);
				setIndex("section", 0);
			}
			else if (intCourseIndex < 0)
			{
				setIndex("course", intSectionCourses[comboBoxNotesSearchSections.getSelectedIndex()]);
			}
			else if (intSectionIndex < 0)
			{
				setIndex("section", 0);
			}

			int section = intSectionIndex;

			setCourses();
			setComboBoxSelectedIndex(comboBoxSectionDeleteCourses, stringTemporaryCourses, intCourseIndex);
			setSections(intCourseIndex);
			setComboBoxSelectedIndex(comboBoxSectionDeleteSections, stringTemporarySections, section);

			if (acmeNote.getCourse(intCourseIndex).getSections().size() > 0)
			{
				checkBoxSectionDelete.setEnabled(true);
				comboBoxSectionDeleteSections.setEnabled(true);
			}
			else
			{
				checkBoxSectionDelete.setEnabled(false);
				comboBoxSectionDeleteSections.setEnabled(false);
			}

			buttonSectionDeleteSubmit.setEnabled(false);
			checkBoxSectionDelete.setSelected(false);

			showCard("SectionDelete");
			
			comboBoxSectionDeleteCourses.requestFocus();
		}
		else if (e.getSource() == menuItemSectionEdit)
		{
			disableComponents();

			if (intCourseIndex < 0 && intSectionIndex < 0)
			{
				setIndex("course", 0);
				setIndex("section", 0);
			}
			else if (intCourseIndex < 0)
			{
				setIndex("course", intSectionCourses[comboBoxNotesSearchSections.getSelectedIndex()]);
			}
			else if (intSectionIndex < 0)
			{
				setIndex("section", 0);
			}

			int section = intSectionIndex;

			setCourses();
			setComboBoxSelectedIndex(comboBoxSectionEditCourses, stringTemporaryCourses, intCourseIndex);
			setSections(intCourseIndex);
			setComboBoxSelectedIndex(comboBoxSectionEditSections, stringTemporarySections, section);

			if (acmeNote.getCourse(intCourseIndex).getSections().size() > 0)
			{
				buttonSectionEditSubmit.setEnabled(true);
				comboBoxSectionEditSections.setEnabled(true);
				textFieldSectionEditSectionName.setEnabled(true);
				textFieldSectionEditSectionName.setText(comboBoxSectionEditSections.getSelectedItem().toString());
			}
			else
			{
				buttonSectionEditSubmit.setEnabled(false);
				comboBoxSectionEditSections.setEnabled(false);
				textFieldSectionEditSectionName.setEnabled(false);
				textFieldSectionEditSectionName.setText("");
			}

			showCard("SectionEdit");
			
			comboBoxSectionEditCourses.requestFocus();
		}
	}
	
	// list selection event listeners
	
	@Override
	public void valueChanged(ListSelectionEvent e)
	{
		if (e.getSource() == listNotes)
		{
			if (listNotes.getSelectedIndex() >= 0)
			{
				setIndex("course", intNoteCourses[listNotes.getSelectedIndex()]);
				setIndex("section", intNoteSections[listNotes.getSelectedIndex()]);
				setIndex("note", intNotes[listNotes.getSelectedIndex()]);
				
				textFieldNoteViewCourseName.setText(acmeNote.getCourse(intCourseIndex).getCourseName());
				textFieldNoteViewSectionName.setText(acmeNote.getCourse(intCourseIndex).getSection(intSectionIndex).getSectionName());
				textFieldNoteViewNoteName.setText(acmeNote.getCourse(intCourseIndex).getSection(intSectionIndex).getNote(intNoteIndex).getNoteName());
				textAreaNoteViewNoteText.setText(acmeNote.getCourse(intCourseIndex).getSection(intSectionIndex).getNote(intNoteIndex).getNoteText());

				showCard("NoteView");
			}
			else
			{
				setIndex("course", intCourses[comboBoxNotesSearchCourses.getSelectedIndex()]);
				setIndex("section", intSections[comboBoxNotesSearchSections.getSelectedIndex()]);
				setIndex("note", -1);
				showCard("NoteNull");
			}
		}
	}
	
	// menu event listeners
	
	@Override
	public void menuCanceled(MenuEvent e)
	{
	}
	
	@Override
	public void menuDeselected(MenuEvent e)
	{
	}
	
	@Override
	public void menuSelected(MenuEvent e)
	{
		if (e.getSource() == menuCourse)
		{
			if (acmeNote.getCourses().size() > 0)
			{
				menuItemCourseDelete.setEnabled(true);
				menuItemCourseEdit.setEnabled(true);
			}
			else
			{
				menuItemCourseDelete.setEnabled(false);
				menuItemCourseEdit.setEnabled(false);
			}
		}
		else if (e.getSource() == menuSection)
		{
			if (acmeNote.getCourses().size() > 0)
			{
				menuItemSectionAdd.setEnabled(true);
				
				if (intCourseIndex >= 0)
				{
					if (acmeNote.getCourse(intCourseIndex).getSections().size() > 0)
					{
						menuItemSectionDelete.setEnabled(true);
						menuItemSectionEdit.setEnabled(true);
					}
					else
					{
						menuItemSectionDelete.setEnabled(false);
						menuItemSectionEdit.setEnabled(false);
					}
				}
				else
				{
					int i = 0;

					for (int j = 0; j < acmeNote.getCourses().size(); j++)
					{
						i += acmeNote.getCourse(j).getSections().size();
					}

					if (i > 0)
					{
						menuItemSectionDelete.setEnabled(true);
						menuItemSectionEdit.setEnabled(true);
					}
					else
					{
						menuItemSectionDelete.setEnabled(false);
						menuItemSectionEdit.setEnabled(false);
					}
				}
			}
			else
			{
				menuItemSectionAdd.setEnabled(false);
				menuItemSectionDelete.setEnabled(false);
				menuItemSectionEdit.setEnabled(false);
			}
		}
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
		acmeNote.serialize();
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

	private void disableComponents()
	{
		buttonNotesSearchCancel.setEnabled(false);
		buttonNotesSearchSearch.setEnabled(false);
		comboBoxNotesSearchCourses.setEnabled(false);
		comboBoxNotesSearchSections.setEnabled(false);
		menuCourse.setEnabled(false);
		menuSection.setEnabled(false);
		listNotes.setEnabled(false);
		textFieldNotesSearch.setEnabled(false);
	}

	private void enableComponents()
	{
		buttonNotesSearchCancel.setEnabled(true);
		buttonNotesSearchSearch.setEnabled(true);
		comboBoxNotesSearchCourses.setEnabled(true);
		comboBoxNotesSearchSections.setEnabled(true);
		menuCourse.setEnabled(true);
		menuSection.setEnabled(true);
		listNotes.setEnabled(true);
		textFieldNotesSearch.setEnabled(true);
	}

	private void searchNotes(String string)
	{
		if (!string.equals(""))
		{
			int i = 0;

			ArrayList<Integer> arrayListIntegerNoteCourses = new ArrayList<Integer>();
			ArrayList<Integer> arrayListIntegerNoteSections = new ArrayList<Integer>();
			ArrayList<Integer> arrayListIntegerNotes = new ArrayList<Integer>();
			ArrayList<String> arrayListStringNotes = new ArrayList<String>();

			for (int j = 0; j < stringNotes.length; j++)
			{
				if (acmeNote.getCourse(intNoteCourses[j]).getSection(intNoteSections[j]).getNote(intNotes[j]).getNoteName().matches(".*" + string + ".*") || acmeNote.getCourse(intNoteCourses[j]).getSection(intNoteSections[j]).getNote(intNotes[j]).getNoteText().matches(".*" + string + ".*"))
				{
					arrayListIntegerNoteCourses.add(intNoteCourses[j]);
					arrayListIntegerNoteSections.add(intNoteSections[j]);
					arrayListIntegerNotes.add(intNotes[j]);
					arrayListStringNotes.add(stringNotes[j]);

					i++;
				}
			}

			intNoteCourses = new int[i];
			intNoteSections = new int[i];
			intNotes = new int[i];
			stringNotes = new String[i];

			for (int j = 0; j < i; j++)
			{
				intNoteCourses[j] = arrayListIntegerNoteCourses.get(j);
				intNoteSections[j] = arrayListIntegerNoteSections.get(j);
				intNotes[j] = arrayListIntegerNotes.get(j);
				stringNotes[j] = arrayListStringNotes.get(j);
			}
		}
	}

	private void setComboBoxSelectedIndex(JComboBox<String> comboBox, String[] string, int index)
	{
		if (index < 0)
		{
			index = 0;
		}

		comboBox.setModel(new DefaultComboBoxModel<String>(string));

		if (string.length > 0)
		{
			comboBox.setSelectedIndex(index);
		}
	}

	private void setCourses()
	{
		intTemporaryCourses = new int[acmeNote.getCourses().size()];
		stringTemporaryCourses = new String[acmeNote.getCourses().size()];
	
		for (int i = 0; i < acmeNote.getCourses().size(); i++)
		{
			intTemporaryCourses[i] = i;
			stringTemporaryCourses[i] = acmeNote.getCourse(i).getCourseName();
		}
	}
	
	private void setCoursesAll()
	{
		intCourses = new int[acmeNote.getCourses().size() + 1];
		intCourses[0] = -1;
	
		stringCourses = new String[acmeNote.getCourses().size() + 1];
		stringCourses[0] = "All Courses";
	
		setCourses();
	
		System.arraycopy(intTemporaryCourses, 0, intCourses, 1, acmeNote.getCourses().size());
		System.arraycopy(stringTemporaryCourses, 0, stringCourses, 1, acmeNote.getCourses().size());
	}

	private void setIndex(String string, int index)
	{
		if (string.equals("course"))
		{
			intCourseIndex = index;
		}
		else if (string.equals("note"))
		{
			intNoteIndex = index;
		}
		else if (string.equals("section"))
		{
			intSectionIndex = index;
		}
	}

	private void setListSelectedIndex(JList<String> list, String[] string, int index)
	{
		list.setModel(new DefaultComboBoxModel<String>(string));
		list.setSelectedIndex(index);
	}

	private void setNotes(int course, int section)
	{
		intTemporaryNoteCourses = new int[acmeNote.getCourse(course).getSection(section).getNotes().size()];
		intTemporaryNoteSections = new int[acmeNote.getCourse(course).getSection(section).getNotes().size()];
		intTemporaryNotes = new int[acmeNote.getCourse(course).getSection(section).getNotes().size()];
		stringTemporaryNotes = new String[acmeNote.getCourse(course).getSection(section).getNotes().size()];
	
		for (int i = 0; i < acmeNote.getCourse(course).getSection(section).getNotes().size(); i++)
		{
			intTemporaryNoteCourses[i] = course;
			intTemporaryNoteSections[i] = section;
			intTemporaryNotes[i] = i;
			stringTemporaryNotes[i] = acmeNote.getCourse(course).getSection(section).getNote(i).getNoteName();
		}
	}
	
	private void setNotesAll(int course, int section)
	{
		if (course >= 0 && section >= 0)
		{
			intNoteCourses = new int[acmeNote.getCourse(course).getSection(section).getNotes().size()];
			intNoteSections = new int[acmeNote.getCourse(course).getSection(section).getNotes().size()];
			intNotes = new int[acmeNote.getCourse(course).getSection(section).getNotes().size()];
			stringNotes = new String[acmeNote.getCourse(course).getSection(section).getNotes().size()];
				
			setNotes(course, section);
			
			System.arraycopy(intTemporaryNoteCourses, 0, intNoteCourses, 0, acmeNote.getCourse(course).getSection(section).getNotes().size());
			System.arraycopy(intTemporaryNoteSections, 0, intNoteSections, 0, acmeNote.getCourse(course).getSection(section).getNotes().size());
			System.arraycopy(intTemporaryNotes, 0, intNotes, 0, acmeNote.getCourse(course).getSection(section).getNotes().size());
			System.arraycopy(stringTemporaryNotes, 0, stringNotes, 0, acmeNote.getCourse(course).getSection(section).getNotes().size());
		}
		else if (course >= 0)
		{
			int i = 0;
	
			for (int j = 0; j < acmeNote.getCourse(course).getSections().size(); j++)
			{
				i += acmeNote.getCourse(course).getSection(j).getNotes().size();
			}
	
			intNoteCourses = new int[i];
			intNoteSections = new int[i];
			intNotes = new int[i];
			stringNotes = new String[i];
	
			i = 0;
	
			for (int j = 0; j < acmeNote.getCourse(course).getSections().size(); j++)
			{
				setNotes(course, j);
	
				System.arraycopy(intTemporaryNoteCourses, 0, intNoteCourses, i, acmeNote.getCourse(course).getSection(j).getNotes().size());
				System.arraycopy(intTemporaryNoteSections, 0, intNoteSections, i, acmeNote.getCourse(course).getSection(j).getNotes().size());
				System.arraycopy(intTemporaryNotes, 0, intNotes, i, acmeNote.getCourse(course).getSection(j).getNotes().size());
				System.arraycopy(stringTemporaryNotes, 0, stringNotes, i, acmeNote.getCourse(course).getSection(j).getNotes().size());

				i += acmeNote.getCourse(course).getSection(j).getNotes().size();
			}
		}
		else if (section >= 0)
		{
			intNoteCourses = new int[acmeNote.getCourse(intSectionCourses[comboBoxNotesSearchSections.getSelectedIndex()]).getSection(section).getNotes().size()];
			intNoteSections = new int[acmeNote.getCourse(intSectionCourses[comboBoxNotesSearchSections.getSelectedIndex()]).getSection(section).getNotes().size()];
			intNotes = new int[acmeNote.getCourse(intSectionCourses[comboBoxNotesSearchSections.getSelectedIndex()]).getSection(section).getNotes().size()];
			stringNotes = new String[acmeNote.getCourse(intSectionCourses[comboBoxNotesSearchSections.getSelectedIndex()]).getSection(section).getNotes().size()];
	
			setNotes(intSectionCourses[comboBoxNotesSearchSections.getSelectedIndex()], section);
	
			System.arraycopy(intTemporaryNoteCourses, 0, intNoteCourses, 0, acmeNote.getCourse(intSectionCourses[comboBoxNotesSearchSections.getSelectedIndex()]).getSection(section).getNotes().size());
			System.arraycopy(intTemporaryNoteSections, 0, intNoteSections, 0, acmeNote.getCourse(intSectionCourses[comboBoxNotesSearchSections.getSelectedIndex()]).getSection(section).getNotes().size());
			System.arraycopy(intTemporaryNotes, 0, intNotes, 0, acmeNote.getCourse(intSectionCourses[comboBoxNotesSearchSections.getSelectedIndex()]).getSection(section).getNotes().size());
			System.arraycopy(stringTemporaryNotes, 0, stringNotes, 0, acmeNote.getCourse(intSectionCourses[comboBoxNotesSearchSections.getSelectedIndex()]).getSection(section).getNotes().size());
		}
		else
		{
			int i = 0;
	
			for (int j = 0; j < acmeNote.getCourses().size(); j++)
			{
				for (int k = 0; k < acmeNote.getCourse(j).getSections().size(); k++)
				{
					i += acmeNote.getCourse(j).getSection(k).getNotes().size();
				}
			}
	
			intNoteCourses = new int[i];
			intNoteSections = new int[i];
			intNotes = new int[i];
			stringNotes = new String[i];
	
			i = 0;
	
			for (int j = 0; j < acmeNote.getCourses().size(); j++)
			{
				for (int k = 0; k < acmeNote.getCourse(j).getSections().size(); k++)
				{
					setNotes(j, k);
	
					System.arraycopy(intTemporaryNoteCourses, 0, intNoteCourses, i, acmeNote.getCourse(j).getSection(k).getNotes().size());
					System.arraycopy(intTemporaryNoteSections, 0, intNoteSections, i, acmeNote.getCourse(j).getSection(k).getNotes().size());
					System.arraycopy(intTemporaryNotes, 0, intNotes, i, acmeNote.getCourse(j).getSection(k).getNotes().size());
					System.arraycopy(stringTemporaryNotes, 0, stringNotes, i, acmeNote.getCourse(j).getSection(k).getNotes().size());
	
					i += acmeNote.getCourse(j).getSection(k).getNotes().size();
				}
			}
		}
	}

	private void setSections(int course)
	{
		intTemporarySectionCourses = new int[acmeNote.getCourse(course).getSections().size()];
		intTemporarySections = new int[acmeNote.getCourse(course).getSections().size()];
		stringTemporarySections = new String[acmeNote.getCourse(course).getSections().size()];
	
		for (int i = 0; i < acmeNote.getCourse(course).getSections().size(); i++)
		{
			intTemporarySectionCourses[i] = course;
			intTemporarySections[i] = i;
			stringTemporarySections[i] = acmeNote.getCourse(course).getSection(i).getSectionName();
		}
	}
	
		private void setSectionsAll(int course)
		{
			if (course >= 0)
			{
				intSectionCourses = new int[acmeNote.getCourse(course).getSections().size() + 1];
				intSectionCourses[0] = -1;
	
				intSections = new int[acmeNote.getCourse(course).getSections().size() + 1];
				intSections[0] = -1;
	
				stringSections = new String[acmeNote.getCourse(course).getSections().size() + 1];
				stringSections[0] = "All Sections";
	
				setSections(course);
	
				System.arraycopy(intTemporarySectionCourses, 0, intSectionCourses, 1, acmeNote.getCourse(course).getSections().size());
				System.arraycopy(intTemporarySections, 0, intSections, 1, acmeNote.getCourse(course).getSections().size());
				System.arraycopy(stringTemporarySections, 0, stringSections, 1, acmeNote.getCourse(course).getSections().size());
			}
			else
			{
				int i = 0;
	
				for (int j = 0; j < acmeNote.getCourses().size(); j++)
				{
					i += acmeNote.getCourse(j).getSections().size();
				}
	
				intSectionCourses = new int[i + 1];
				intSectionCourses[0] = -1;
	
				intSections = new int[i + 1];
				intSections[0] = -1;
	
				stringSections = new String[i + 1];
				stringSections[0] = "All Sections";
	
				i = 1;
	
				for (int j = 0; j < acmeNote.getCourses().size(); j++)
				{
					setSections(j);
	
					System.arraycopy(intTemporarySectionCourses, 0, intSectionCourses, i, acmeNote.getCourse(j).getSections().size());
					System.arraycopy(intTemporarySections, 0, intSections, i, acmeNote.getCourse(j).getSections().size());
					System.arraycopy(stringTemporarySections, 0, stringSections, i, acmeNote.getCourse(j).getSections().size());
	
					i += acmeNote.getCourse(j).getSections().size();
				}
			}
	}

	private void showCard(String string)
	{
		cardLayout.show(panelCards, string);
	}

	private void showErrorMessage(String string)
	{
		JOptionPane.showMessageDialog(null, "Error", string, JOptionPane.ERROR_MESSAGE);
	}

	// main method
	
	/**
	 * Main method to launch graphical user interface.
	 * 
	 * @param args <tt>String</tt> <tt>Array</tt> of arguments.
	 */
	public static void main(String[] args)
	{
		AcmeNoteGraphicalUserInterface frame = new AcmeNoteGraphicalUserInterface();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setTitle("AcmeNote");
		frame.pack();
		frame.setVisible(true);
	}
}