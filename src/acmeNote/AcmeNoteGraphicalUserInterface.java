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
 *           2014.04.08 by Lacey Taylor. Implemented section and note add, delete, edit methods.
 *           2014.04.11 by Shaun Christensen. Refactored graphical user interface and utility methods.
 *           2014.04.12 by Shaun Christensen. Added javadoc comments to class. Implemented Help About and Documentation methods.
 *           2014.04.13 by Shaun Christensen. Fixed bugs relating to selecting courses without sections when adding or editing notes.
 *           2014.04.14 by Shaun Christensen. Added JUnit test suites for AcmeNote, Course, Section, and Note classes.
 *
********************************************************/

package acmeNote;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
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
 * @author Shaun Christensen, Lacey Taylor, Curtis Nixon
 */
@SuppressWarnings("serial")
public final class AcmeNoteGraphicalUserInterface extends JFrame implements ActionListener, ListSelectionListener, MenuListener, WindowListener
{
	// components

	/**
	 * <tt>JButton</tt> object to cancel add <tt>Course</tt> object.
	 */
	private JButton buttonCourseAddCancel;

	/**
	 * <tt>JButton</tt> object to submit add <tt>Course</tt> object.
	 */
	private JButton buttonCourseAddSubmit;

	/**
	 * <tt>JButton</tt> object to cancel delete <tt>Course</tt> object.
	 */
	private JButton buttonCourseDeleteCancel;

	/**
	 * <tt>JButton</tt> object to submit delete <tt>Course</tt> object.
	 */
	private JButton buttonCourseDeleteSubmit;

	/**
	 * <tt>JButton</tt> object to cancel edit <tt>Course</tt> object.
	 */
	private JButton buttonCourseEditCancel;

	/**
	 * <tt>JButton</tt> object to submit edit <tt>Course</tt> object.
	 */
	private JButton buttonCourseEditSubmit;

	/**
	 * <tt>JButton</tt> object to cancel add <tt>Note</tt> object.
	 */
	private JButton buttonNoteAddCancel;

	/**
	 * <tt>JButton</tt> object to submit add <tt>Note</tt> object.
	 */
	private JButton buttonNoteAddSubmit;

	/**
	 * <tt>JButton</tt> object to cancel delete <tt>Note</tt> object.
	 */
	private JButton buttonNoteDeleteCancel;

	/**
	 * <tt>JButton</tt> object to submit delete <tt>Note</tt> object.
	 */
	private JButton buttonNoteDeleteSubmit;

	/**
	 * <tt>JButton</tt> object to cancel edit <tt>Note</tt> object.
	 */
	private JButton buttonNoteEditCancel;

	/**
	 * <tt>JButton</tt> object to submit edit <tt>Note</tt> object.
	 */
	private JButton buttonNoteEditSubmit;

	/**
	 * <tt>JButton</tt> object to add <tt>Note</tt> object.
	 */
	private JButton buttonNoteNullNoteAdd;

	/**
	 * <tt>JButton</tt> object to delete <tt>Note</tt> object.
	 */
	private JButton buttonNoteNullNoteDelete;

	/**
	 * <tt>JButton</tt> object to edit <tt>Note</tt> object.
	 */
	private JButton buttonNoteNullNoteEdit;

	/**
	 * <tt>JButton</tt> object to cancel <tt>Note</tt> objects search.
	 */
	private JButton buttonNotesSearchCancel;

	/**
	 * <tt>JButton</tt> object to submit <tt>Note</tt> objects search.
	 */
	private JButton buttonNotesSearchSearch;

	/**
	 * <tt>JButton</tt> object to add <tt>Note</tt> object.
	 */
	private JButton buttonNoteViewNoteAdd;

	/**
	 * <tt>JButton</tt> object to delete <tt>Note</tt> object.
	 */
	private JButton buttonNoteViewNoteDelete;

	/**
	 * <tt>JButton</tt> object to edit <tt>Note</tt> object.
	 */
	private JButton buttonNoteViewNoteEdit;

	/**
	 * <tt>JButton</tt> object to cancel add <tt>Section</tt> object.
	 */
	private JButton buttonSectionAddCancel;

	/**
	 * <tt>JButton</tt> object to submit add <tt>Section</tt> object.
	 */
	private JButton buttonSectionAddSubmit;

	/**
	 * <tt>JButton</tt> object to cancel delete <tt>Section</tt> object.
	 */
	private JButton buttonSectionDeleteCancel;

	/**
	 * <tt>JButton</tt> object to submit delete <tt>Section</tt> object.
	 */
	private JButton buttonSectionDeleteSubmit;

	/**
	 * <tt>JButton</tt> object to cancel edit <tt>Section</tt> object.
	 */
	private JButton buttonSectionEditCancel;

	/**
	 * <tt>JButton</tt> object to submit edit <tt>Section</tt> object.
	 */
	private JButton buttonSectionEditSubmit;

	/**
	 * <tt>CardLayout</tt> object switches views between multiple <tt>JPanel</tt> objects.
	 */
	private CardLayout cardLayout;

	/**
	 * <tt>JCheckBox</tt> object to confirm <tt>Course</tt> object deletion.
	 */
	private JCheckBox checkBoxCourseDelete;

	/**
	 * <tt>JCheckBox</tt> object to confirm <tt>Note</tt> object deletion.
	 */
	private JCheckBox checkBoxNoteDelete;

	/**
	 * <tt>JCheckBox</tt> object to confirm <tt>Section</tt> object deletion.
	 */
	private JCheckBox checkBoxSectionDelete;

	/**
	 * <tt>JComboBox</tt> object to select <tt>Course</tt> object to delete.
	 */
	private JComboBox<String> comboBoxCourseDeleteCourses;

	/**
	 * <tt>JComboBox</tt> object to select <tt>Course</tt> object to edit.
	 */
	private JComboBox<String> comboBoxCourseEditCourses;

	/**
	 * <tt>JComboBox</tt> object to select <tt>Course</tt> object to set for <tt>Note</tt> object to add.
	 */
	private JComboBox<String> comboBoxNoteAddCourses;

	/**
	 * <tt>JComboBox</tt> object to select <tt>Section</tt> object to set for <tt>Note</tt> object to add.
	 */
	private JComboBox<String> comboBoxNoteAddSections;

	/**
	 * <tt>JComboBox</tt> object to select <tt>Course</tt> object to set for <tt>Note</tt> object to edit.
	 */
	private JComboBox<String> comboBoxNoteEditCourses;

	/**
	 * <tt>JComboBox</tt> object to select <tt>Section</tt> object to set for <tt>Note</tt> object to edit.
	 */
	private JComboBox<String> comboBoxNoteEditSections;

	/**
	 * <tt>JComboBox</tt> object to select <tt>Course</tt> object to set for <tt>Note</tt> objects to search
	 */
	private JComboBox<String> comboBoxNotesSearchCourses;

	/**
	 * <tt>JComboBox</tt> object to select <tt>Section</tt> object to set for <tt>Note</tt> objects to search
	 */
	private JComboBox<String> comboBoxNotesSearchSections;

	/**
	 * <tt>JComboBox</tt> object to select <tt>Course</tt> object to set for <tt>Section</tt> object to add.
	 */
	private JComboBox<String> comboBoxSectionAddCourses;

	/**
	 * <tt>JComboBox</tt> object to select <tt>Course</tt> object to set for <tt>Section</tt> object to delete.
	 */
	private JComboBox<String> comboBoxSectionDeleteCourses;

	/**
	 * <tt>JComboBox</tt> object to select <tt>Section</tt> object to delete.
	 */
	private JComboBox<String> comboBoxSectionDeleteSections;

	/**
	 * <tt>JComboBox</tt> object to select <tt>Course</tt> object to set for <tt>Section</tt> object to edit.
	 */
	private JComboBox<String> comboBoxSectionEditCourses;

	/**
	 * <tt>JComboBox</tt> object to select <tt>Section</tt> object to edit.
	 */
	private JComboBox<String> comboBoxSectionEditSections;

	/**
	 * <tt>JList</tt> object to select <tt>Note</tt> object to view.
	 */
	private JList<String> listNotes;

	/**
	 * <tt>JMenu</tt> object to select <tt>JMenuItem</tt> objects to add, delete, or edit <tt>Course</tt> objects.
	 */
	private JMenu menuCourse;

	/**
	 * <tt>JMenu</tt> object to select <tt>JMenuItem</tt> objects to add, delete, or edit <tt>Section</tt> objects.
	 */
	private JMenu menuSection;

	/**
	 * <tt>JMenuItem</tt> object to add <tt>Course</tt> object.
	 */
	private JMenuItem menuItemCourseAdd;

	/**
	 * <tt>JMenuItem</tt> object to delete <tt>Course</tt> object.
	 */
	private JMenuItem menuItemCourseDelete;

	/**
	 * <tt>JMenuItem</tt> object to edit <tt>Course</tt> object.
	 */
	private JMenuItem menuItemCourseEdit;

	/**
	 * <tt>JMenuItem</tt> object to exit application.
	 */
	private JMenuItem menuItemFileQuit;

	/**
	 * <tt>JMenuItem</tt> object to view information about the AcmeNote application.
	 */
	private JMenuItem menuItemHelpAbout;

	/**
	 * <tt>JMenuItem</tt> object to view documentation about the AcmeNote application.
	 */
	private JMenuItem menuItemHelpDocumentation;

	/**
	 * <tt>JMenuItem</tt> object view shortcut keys for the AcmeNote application.
	 */
	private JMenuItem menuItemHelpShortcutKeys;

	/**
	 * <tt>JMenuItem</tt> object to add <tt>Section</tt> object.
	 */
	private JMenuItem menuItemSectionAdd;

	/**
	 * <tt>JMenuItem</tt> object to delete <tt>Section</tt> object.
	 */
	private JMenuItem menuItemSectionDelete;

	/**
	 * <tt>JMenuItem</tt> object to edit <tt>Section</tt> object.
	 */
	private JMenuItem menuItemSectionEdit;

	/**
	 * <tt>JPanel</tt> object to contain multiple <tt>JPanel</tt> objects.
	 */
	private JPanel panelCards;

	/**
	 * <tt>JTextArea</tt> object to set <tt>Note</tt> object's note text.
	 */
	private JTextArea textAreaNoteAddNoteText;

	/**
	 * <tt>JTextArea</tt> object to set <tt>Note</tt> object's note text.
	 */
	private JTextArea textAreaNoteEditNoteText;

	/**
	 * <tt>JTextArea</tt> object to view <tt>Note</tt> object's note text.
	 */
	private JTextArea textAreaNoteViewNoteText;

	/**
	 * <tt>JTextField</tt> object to set <tt>Course</tt> object's course name.
	 */
	private JTextField textFieldCourseAddCourseName;

	/**
	 * <tt>JTextField</tt> object to set <tt>Course</tt> object's course name.
	 */
	private JTextField textFieldCourseEditCourseName;

	/**
	 * <tt>JTextField</tt> object to set <tt>Note</tt> object's note name.
	 */
	private JTextField textFieldNoteAddNoteName;

	/**
	 * <tt>JTextField</tt> object to set <tt>Note</tt> object's note name.
	 */
	private JTextField textFieldNoteEditNoteName;

	/**
	 * <tt>JTextField</tt> object to search for <tt>Note</tt> objects' note names and note text.
	 */
	private JTextField textFieldNotesSearch;

	/**
	 * <tt>JTextField</tt> object to view <tt>Note</tt> object's course name.
	 */
	private JTextField textFieldNoteViewCourseName;

	/**
	 * <tt>JTextField</tt> object to view <tt>Note</tt> object's note name.
	 */
	private JTextField textFieldNoteViewNoteName;

	/**
	 * <tt>JTextField</tt> object to view <tt>Note</tt> object's section name.
	 */
	private JTextField textFieldNoteViewSectionName;

	/**
	 * <tt>JTextField</tt> object to set <tt>Section</tt> object's section name.
	 */
	private JTextField textFieldSectionAddSectionName;

	/**
	 * <tt>JTextField</tt> object to set <tt>Section</tt> object's section name.
	 */
	private JTextField textFieldSectionEditSectionName;

	/**
	 * <tt>URI</tt> object to link to AcmeNote documentation.
	 */
	private URI uniformResourceIdentifier;

	// fields

	/**
	 * <tt>AcmeNote</tt> object containing <tt>ArrayList</tt> of <tt>Course</tt> objects and associated <tt>Section</tt> and <tt>Note</tt> objects.
	 */
	private AcmeNote acmeNote;

	/**
	 * <tt>Integer</tt> index of <tt>Course</tt> object.
	 */
	private int intCourseIndex;

	/**
	 * <tt>Integer</tt> index of <tt>Note</tt> object.
	 */
	private int intNoteIndex;

	/**
	 * <tt>Integer</tt> index of <tt>Section</tt> object. 
	 */
	private int intSectionIndex;

	/**
	 * <tt>Integer</tt> <tt>Array</tt> of indices of <tt>Course</tt> objects.
	 */
	private int[] intCourses;

	/**
	 * <tt>Integer</tt> <tt>Array</tt> of indices of <tt>Note</tt> objects' associated <tt>Course</tt> objects.
	 */
	private int[] intNoteCourses;

	/**
	 * <tt>Integer</tt> <tt>Array</tt> of indices of <tt>Note</tt> objects.
	 */
	private int[] intNotes;

	/**
	 * <tt>Integer</tt> <tt>Array</tt> of indices of <tt>Note</tt> objects' associated <tt>Section</tt> objects.
	 */
	private int[] intNoteSections;

	/**
	 * <tt>Integer</tt> <tt>Array</tt> of indices of <tt>Section</tt> objects' associated <tt>Course</tt> objects.
	 */
	private int[] intSectionCourses;

	/**
	 * <tt>Integer</tt> <tt>Array</tt> of indices of <tt>Section</tt> objects.
	 */
	private int[] intSections;

	/**
	 * Temporary <tt>Integer</tt> <tt>Array</tt> of indices of <tt>Course</tt> objects.
	 */
	private int[] intTemporaryCourses;

	/**
	 * Temporary <tt>Integer</tt> <tt>Array</tt> of indices of <tt>Note</tt> objects' associated <tt>Course</tt> objects.
	 */
	private int[] intTemporaryNoteCourses;

	/**
	 * Temporary <tt>Integer</tt> <tt>Array</tt> of indices of <tt>Note</tt> objects.
	 */
	private int[] intTemporaryNotes;

	/**
	 * Temporary <tt>Integer</tt> <tt>Array</tt> of indices of <tt>Note</tt> objects' associated <tt>Section</tt> objects.
	 */
	private int[] intTemporaryNoteSections;

	/**
	 * Temporary <tt>Integer</tt> <tt>Array</tt> of indices of <tt>Section</tt> objects' associated <tt>Course</tt> objects.
	 */
	private int[] intTemporarySectionCourses;

	/**
	 * Temporary <tt>Integer</tt> <tt>Array</tt> of indices of <tt>Section</tt> objects.
	 */
	private int[] intTemporarySections;

	/**
	 * <tt>String</tt> <tt>Array</tt> of <tt>Course</tt> objects' course names.
	 */
	private String[] stringCourses;

	/**
	 * <tt>String</tt> <tt>Array</tt> of <tt>Note</tt> objects' note names.
	 */
	private String[] stringNotes;

	/**
	 * <tt>String</tt> <tt>Array</tt> of <tt>Section</tt> objects' section names.
	 */
	private String[] stringSections;

	/**
	 * Temporary <tt>String</tt> <tt>Array</tt> of <tt>Course</tt> objects' course names.
	 */
	private String[] stringTemporaryCourses;

	/**
	 * Temporary <tt>String</tt> <tt>Array</tt> of <tt>Note</tt> object's note names.
	 */
	private String[] stringTemporaryNotes;

	/**
	 * Temporary <tt>String</tt> <tt>Array</tt> of <tt>Section</tt> objects' section names.
	 */
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
		textFieldCourseAddCourseName.setBorder(BorderFactory.createLineBorder(Color.GRAY));
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

		comboBoxCourseDeleteCourses = new JComboBox<String>(new String[0]);
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

		comboBoxCourseEditCourses = new JComboBox<String>(new String[0]);
		comboBoxCourseEditCourses.setAlignmentX(LEFT_ALIGNMENT);
		comboBoxCourseEditCourses.setPreferredSize(new Dimension(200, comboBoxCourseEditCourses.getPreferredSize().height));

		textFieldCourseEditCourseName = new JTextField();
		textFieldCourseEditCourseName.setBorder(BorderFactory.createLineBorder(Color.GRAY));
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
	 * Creates add note panel.
	 *
	 * @return <tt>Box</tt> object.
	 */
	private Box boxNoteAdd()
	{
		// components

		JLabel labelNoteAdd = new JLabel("Add Note");
		labelNoteAdd.setFont(new Font("Serif", Font.BOLD, 25));

		comboBoxNoteAddCourses = new JComboBox<String>(new String[0]);
		comboBoxNoteAddCourses.setAlignmentX(LEFT_ALIGNMENT);
		comboBoxNoteAddCourses.setPreferredSize(new Dimension(200, comboBoxNoteAddCourses.getPreferredSize().height));

		comboBoxNoteAddSections = new JComboBox<String>(new String[0]);
		comboBoxNoteAddSections.setAlignmentX(LEFT_ALIGNMENT);
		comboBoxNoteAddSections.setPreferredSize(new Dimension(200, comboBoxNoteAddSections.getPreferredSize().height));

		textFieldNoteAddNoteName = new JTextField();
		textFieldNoteAddNoteName.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		textFieldNoteAddNoteName.setPreferredSize(new Dimension(558, textFieldNoteAddNoteName.getPreferredSize().height));

		textAreaNoteAddNoteText = new JTextArea();
		textAreaNoteAddNoteText.setLineWrap(true);
		textAreaNoteAddNoteText.setWrapStyleWord(true);

		JScrollPane scrollPaneNoteAddNoteText = new JScrollPane(textAreaNoteAddNoteText);
		scrollPaneNoteAddNoteText.setBorder(BorderFactory.createLineBorder(Color.GRAY));
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

		comboBoxNoteEditCourses = new JComboBox<>(new String[0]);
		comboBoxNoteEditCourses.setAlignmentX(LEFT_ALIGNMENT);
		comboBoxNoteEditCourses.setPreferredSize(new Dimension(200, comboBoxNoteEditCourses.getPreferredSize().height));

		comboBoxNoteEditSections = new JComboBox<>(new String[0]);
		comboBoxNoteEditSections.setAlignmentX(LEFT_ALIGNMENT);
		comboBoxNoteEditSections.setPreferredSize(new Dimension(200, comboBoxNoteEditSections.getPreferredSize().height));

		textFieldNoteEditNoteName = new JTextField();
		textFieldNoteEditNoteName.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		textFieldNoteEditNoteName.setPreferredSize(new Dimension(558, textFieldNoteEditNoteName.getPreferredSize().height));

		textAreaNoteEditNoteText = new JTextArea();
		textAreaNoteEditNoteText.setLineWrap(true);
		textAreaNoteEditNoteText.setWrapStyleWord(true);

		JScrollPane scrollPaneNoteEditNoteText = new JScrollPane(textAreaNoteEditNoteText);
		scrollPaneNoteEditNoteText.setBorder(BorderFactory.createLineBorder(Color.GRAY));
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
		textFieldNoteViewCourseName.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		textFieldNoteViewCourseName.setEditable(false);
		textFieldNoteViewCourseName.setPreferredSize(new Dimension(200, textFieldNoteViewCourseName.getPreferredSize().height));

		textFieldNoteViewSectionName = new JTextField();
		textFieldNoteViewSectionName.setAlignmentX(LEFT_ALIGNMENT);
		textFieldNoteViewSectionName.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		textFieldNoteViewSectionName.setEditable(false);
		textFieldNoteViewSectionName.setPreferredSize(new Dimension(200, textFieldNoteViewSectionName.getPreferredSize().height));

		textFieldNoteViewNoteName = new JTextField();
		textFieldNoteViewNoteName.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		textFieldNoteViewNoteName.setEditable(false);
		textFieldNoteViewNoteName.setPreferredSize(new Dimension(558, textFieldNoteViewNoteName.getPreferredSize().height));

		textAreaNoteViewNoteText = new JTextArea();
		textAreaNoteViewNoteText.setEditable(false);
		textAreaNoteViewNoteText.setLineWrap(true);
		textAreaNoteViewNoteText.setWrapStyleWord(true);

		JScrollPane scrollPaneNoteViewNoteText = new JScrollPane(textAreaNoteViewNoteText);
		scrollPaneNoteViewNoteText.setBorder(BorderFactory.createLineBorder(Color.GRAY));
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

		comboBoxSectionAddCourses = new JComboBox<String>(new String[0]);
		comboBoxSectionAddCourses.setAlignmentX(LEFT_ALIGNMENT);
		comboBoxSectionAddCourses.setPreferredSize(new Dimension(200, comboBoxSectionAddCourses.getPreferredSize().height));

		textFieldSectionAddSectionName = new JTextField();
		textFieldSectionAddSectionName.setBorder(BorderFactory.createLineBorder(Color.GRAY));
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

		comboBoxSectionDeleteCourses = new JComboBox<String>(new String[0]);
		comboBoxSectionDeleteCourses.setAlignmentX(LEFT_ALIGNMENT);
		comboBoxSectionDeleteCourses.setPreferredSize(new Dimension(200, comboBoxSectionDeleteCourses.getPreferredSize().height));

		comboBoxSectionDeleteSections = new JComboBox<String>(new String[0]);
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

		comboBoxSectionEditCourses = new JComboBox<String>(new String[0]);
		comboBoxSectionEditCourses.setAlignmentX(LEFT_ALIGNMENT);
		comboBoxSectionEditCourses.setPreferredSize(new Dimension(200, comboBoxSectionEditCourses.getPreferredSize().height));

		comboBoxSectionEditSections = new JComboBox<String>(new String[0]);
		comboBoxSectionEditSections.setAlignmentX(LEFT_ALIGNMENT);
		comboBoxSectionEditSections.setPreferredSize(new Dimension(200, comboBoxSectionEditSections.getPreferredSize().height));

		textFieldSectionEditSectionName = new JTextField();
		textFieldSectionEditSectionName.setBorder(BorderFactory.createLineBorder(Color.GRAY));
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
		setButtonNoteNullNoteAddEnabled();
		actionListenersAdd();
		listSelectionListenersAdd();
		menuListenersAdd();
		windowListenersAdd();
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
		menuItemCourseDelete = new JMenuItem("Delete", KeyEvent.VK_U);
		menuItemCourseEdit = new JMenuItem("Edit", KeyEvent.VK_R);
		menuItemSectionAdd = new JMenuItem("Add", KeyEvent.VK_T);
		menuItemSectionDelete = new JMenuItem("Delete", KeyEvent.VK_I);
		menuItemSectionEdit = new JMenuItem("Edit", KeyEvent.VK_E);
		menuItemHelpAbout = new JMenuItem("About", KeyEvent.VK_A);
		menuItemHelpDocumentation = new JMenuItem("Documentation", KeyEvent.VK_D);
		menuItemHelpShortcutKeys = new JMenuItem("Shortcut Keys", KeyEvent.VK_K);

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
		menu.add(menuItemHelpShortcutKeys);
		menu.setMnemonic(KeyEvent.VK_H);

		menuBar.add(menu);

		return menuBar;
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
		textFieldNotesSearch.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		textFieldNotesSearch.setDisabledTextColor(Color.GRAY);
		textFieldNotesSearch.setPreferredSize(new Dimension(200, textFieldNotesSearch.getPreferredSize().height));

		buttonNotesSearchCancel = new JButton("Cancel");
		buttonNotesSearchSearch = new JButton("Search");

		listNotes = new JList<String>(stringNotes);
		listNotes.setLayoutOrientation(JList.VERTICAL);
		listNotes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane scrollPaneNotes = new JScrollPane(listNotes);
		scrollPaneNotes.setBorder(BorderFactory.createLineBorder(Color.GRAY));
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

	// register event listeners

	/**
	 * Register action listeners.
	 */
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
		menuItemHelpShortcutKeys.addActionListener(this);
		menuItemSectionAdd.addActionListener(this);
		menuItemSectionDelete.addActionListener(this);
		menuItemSectionEdit.addActionListener(this);
	}

	/**
	 * Register list selection listeners.
	 */
	private void listSelectionListenersAdd()
	{
		listNotes.addListSelectionListener(this);
	}

	/**
	 * Register menu listeners.
	 */
	private void menuListenersAdd()
	{
		menuCourse.addMenuListener(this);
		menuSection.addMenuListener(this);
	}

	/**
	 * Register window listeners.
	 */
	private void windowListenersAdd()
	{
		addWindowListener(this);
	}

	// action event listener

	/**
	 * Fired by <ttJButton</tt>, <tt>JCheckBox</tt>, <tt>JComboBox</tt>, <tt>JMenu</tt>, <tt>JMenuItem</tt> selection events.
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == buttonCourseAddCancel || e.getSource() == buttonCourseDeleteCancel || e.getSource() == buttonCourseEditCancel || e.getSource() == buttonNoteAddCancel || e.getSource() == buttonNoteDeleteCancel || e.getSource() == buttonNoteEditCancel || e.getSource() == buttonSectionAddCancel || e.getSource() == buttonSectionDeleteCancel || e.getSource() == buttonSectionEditCancel)
		{
			for (ListSelectionListener l : listNotes.getListSelectionListeners())
			{
				l.valueChanged(new ListSelectionEvent(listNotes, intNoteIndex, intNoteIndex, false));
			}

			setEnabled(true);
		}
		else if (e.getSource() == buttonCourseAddSubmit)
		{
			if (acmeNote.addCourse(new Course(textFieldCourseAddCourseName.getText())))
			{
				setCoursesAll();
				setComboBoxSelectedIndex(comboBoxNotesSearchCourses, stringCourses, acmeNote.getCourses().size());
				setButtonNoteNullNoteAddEnabled();
				showCard("NoteNull");
				setEnabled(true);
			}
			else
			{
				showErrorMessage(this, "Unable to add course. Please try again.");
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
				setButtonNoteNullNoteAddEnabled();
				showCard("NoteNull");
				setEnabled(true);
			}
			else
			{
				showErrorMessage(this, "Unable to delete course. Please try again.");
			}
		}
		else if (e.getSource() == buttonCourseEditSubmit)
		{
			if (acmeNote.getCourse(intCourseIndex).setCourseName(textFieldCourseEditCourseName.getText()))
			{
				setCoursesAll();
				setComboBoxSelectedIndex(comboBoxNotesSearchCourses, stringCourses, intCourseIndex + 1);
				showCard("NoteNull");
				setEnabled(true);
			}
			else
			{
				showErrorMessage(this, "Unable to edit course. Please try again.");
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
				setButtonNoteNullNoteAddEnabled();
				showCard("NoteView");
				setEnabled(true);
			}
			else
			{
				showErrorMessage(this, "Unable to add note. Please try again.");
			}
		}
		else if (e.getSource() == buttonNoteDeleteSubmit)
		{
			if (acmeNote.getCourse(intCourseIndex).getSection(intSectionIndex).removeNote(intNoteIndex))
			{
				setNotesAll(intCourseIndex, intSectionIndex);
				setListSelectedIndex(listNotes, stringNotes, -1);
				setButtonNoteNullNoteAddEnabled();
				showCard("NoteNull");
				setEnabled(true);
			}
			else
			{
				showErrorMessage(this, "Unable to delete note. Please try again.");
			}
		}
		else if (e.getSource() == buttonNoteEditSubmit)
		{
			if (intNoteCourses[listNotes.getSelectedIndex()] == intCourseIndex && intNoteSections[listNotes.getSelectedIndex()] == intSectionIndex)
			{
				if (acmeNote.getCourse(intCourseIndex).getSection(intSectionIndex).getNote(intNoteIndex).setNoteName(textFieldNoteEditNoteName.getText()) && acmeNote.getCourse(intCourseIndex).getSection(intSectionIndex).getNote(intNoteIndex).setNoteText(textAreaNoteEditNoteText.getText()))
				{
					setNotesAll(intCourseIndex, intSectionIndex);
					setListSelectedIndex(listNotes, stringNotes, intNoteIndex);
				}
				else
				{
					showErrorMessage(this, "Unable to edit note. Please try again.");
				}
			}
			else
			{
				if (acmeNote.getCourse(intCourseIndex).getSection(intSectionIndex).addNote(new Note(textFieldNoteEditNoteName.getText(), textAreaNoteEditNoteText.getText())) && acmeNote.getCourse(intNoteCourses[listNotes.getSelectedIndex()]).getSection(intNoteSections[listNotes.getSelectedIndex()]).removeNote(intNotes[listNotes.getSelectedIndex()]))
				{
					int section = intSectionIndex + 1;
					int note = acmeNote.getCourse(intCourseIndex).getSection(intSectionIndex).getNotes().size() - 1;

					setComboBoxSelectedIndex(comboBoxNotesSearchCourses, stringCourses, intCourseIndex + 1);
					setComboBoxSelectedIndex(comboBoxNotesSearchSections, stringSections, section);
					setListSelectedIndex(listNotes, stringNotes, note);
				}
				else
				{
					showErrorMessage(this, "Unable to edit note. Please try again.");
				}
			}

			showCard("NoteView");
			setEnabled(true);
		}
		else if (e.getSource() == buttonNoteNullNoteAdd || e.getSource() == buttonNoteViewNoteAdd)
		{
			setEnabled(false);
			setCourseSectionIndex();

			int section = intSectionIndex;

			setCourses();
			setComboBoxSelectedIndex(comboBoxNoteAddCourses, stringTemporaryCourses, intCourseIndex);
			setSections(intCourseIndex);
			setComboBoxSelectedIndex(comboBoxNoteAddSections, stringTemporarySections, section);

			textFieldNoteAddNoteName.setText("");
			textAreaNoteAddNoteText.setText("");

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
			setEnabled(false);

			buttonNoteDeleteSubmit.setEnabled(false);
			checkBoxNoteDelete.setSelected(false);

			showCard("NoteDelete");

			checkBoxNoteDelete.requestFocus();
		}
		else if (e.getSource() == buttonNoteViewNoteEdit)
		{
			setEnabled(false);
			setCourseSectionIndex();

			int section = intSectionIndex;

			setCourses();
			setComboBoxSelectedIndex(comboBoxNoteEditCourses, stringTemporaryCourses, intCourseIndex);
			setSections(intCourseIndex);
			setComboBoxSelectedIndex(comboBoxNoteEditSections, stringTemporarySections, section);

			textFieldNoteEditNoteName.setText(acmeNote.getCourse(intCourseIndex).getSection(intSectionIndex).getNote(intNoteIndex).getNoteName());
			textAreaNoteEditNoteText.setText(acmeNote.getCourse(intCourseIndex).getSection(intSectionIndex).getNote(intNoteIndex).getNoteText());

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
				setButtonNoteNullNoteAddEnabled();
				showCard("NoteNull");
				setEnabled(true);
			}
			else
			{
				showErrorMessage(this, "Unable to add section. Please try again.");
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
				setButtonNoteNullNoteAddEnabled();
				showCard("NoteNull");
				setEnabled(true);
			}
			else
			{
				showErrorMessage(this, "Unable to delete section. Please try again.");
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
				setEnabled(true);
			}
			else
			{
				showErrorMessage(this, "Unable to edit section. Please try again.");
			}
		}
		else if (e.getSource() == checkBoxCourseDelete)
		{
			setCheckBoxIsSelected(checkBoxCourseDelete, buttonCourseDeleteSubmit);
		}
		else if (e.getSource() == checkBoxNoteDelete)
		{
			setCheckBoxIsSelected(checkBoxNoteDelete, buttonNoteDeleteSubmit);
		}
		else if (e.getSource() == checkBoxSectionDelete)
		{
			setCheckBoxIsSelected(checkBoxSectionDelete, buttonSectionDeleteSubmit);
		}
		else if (e.getSource() == comboBoxCourseDeleteCourses)
		{
			setIndex("course", intTemporaryCourses[comboBoxCourseDeleteCourses.getSelectedIndex()]);

			checkBoxCourseDelete.setSelected(false);
			buttonCourseDeleteSubmit.setEnabled(false);
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

			if (acmeNote.getCourse(intCourseIndex).getSections().size() > 0)
			{
				comboBoxNoteAddSections.setEnabled(true);
				textFieldNoteAddNoteName.setEditable(true);
				textAreaNoteAddNoteText.setEditable(true);
				buttonNoteAddSubmit.setEnabled(true);
			}
			else
			{
				comboBoxNoteAddSections.setEnabled(false);
				textFieldNoteAddNoteName.setEditable(false);
				textAreaNoteAddNoteText.setEditable(false);
				buttonNoteAddSubmit.setEnabled(false);
			}
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
			setComboBoxSelectedIndex(comboBoxNoteEditSections, stringTemporarySections, intSectionIndex);

			if (acmeNote.getCourse(intCourseIndex).getSections().size() > 0)
			{
				comboBoxNoteEditSections.setEnabled(true);
				textFieldNoteEditNoteName.setEditable(true);
				textAreaNoteEditNoteText.setEditable(true);
				buttonNoteEditSubmit.setEnabled(true);
			}
			else
			{
				comboBoxNoteEditSections.setEnabled(false);
				textFieldNoteEditNoteName.setEditable(false);
				textAreaNoteEditNoteText.setEditable(false);
				buttonNoteEditSubmit.setEnabled(false);
			}
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
			setButtonNoteNullNoteAddEnabled();
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
			setSectionDeleteEnabledSelected();
		}
		else if (e.getSource() == comboBoxSectionDeleteSections)
		{
			setIndex("section", intTemporarySections[comboBoxSectionDeleteSections.getSelectedIndex()]);

			checkBoxSectionDelete.setSelected(false);
			buttonSectionDeleteSubmit.setEnabled(false);
		}
		else if (e.getSource() == comboBoxSectionEditCourses)
		{
			setIndex("course", intTemporaryCourses[comboBoxSectionEditCourses.getSelectedIndex()]);
			setIndex("section", 0);
			setSections(intCourseIndex);
			setComboBoxSelectedIndex(comboBoxSectionEditSections, stringTemporarySections, intSectionIndex);
			setSectionEditEditableEnabledText();
		}
		else if (e.getSource() == comboBoxSectionEditSections)
		{
			setIndex("section", intTemporarySections[comboBoxSectionEditSections.getSelectedIndex()]);

			textFieldSectionEditSectionName.setText(comboBoxSectionEditSections.getSelectedItem().toString());
		}
		else if (e.getSource() == menuItemCourseAdd)
		{
			setEnabled(false);

			textFieldCourseAddCourseName.setText("");

			showCard("CourseAdd");

			textFieldCourseAddCourseName.requestFocus();
		}
		else if (e.getSource() == menuItemCourseDelete)
		{
			setEnabled(false);
			setCourseIndex();
			setCourses();
			setComboBoxSelectedIndex(comboBoxCourseDeleteCourses, stringTemporaryCourses, intCourseIndex);

			checkBoxCourseDelete.setSelected(false);
			buttonCourseDeleteSubmit.setEnabled(false);

			showCard("CourseDelete");

			comboBoxCourseDeleteCourses.requestFocus();
		}
		else if (e.getSource() == menuItemCourseEdit)
		{
			setEnabled(false);
			setCourseIndex();
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
			JOptionPane.showMessageDialog(this, "AcmeNote\nVersion: 1.3\nDate: 2014.04.14\n\nTeam Acme:\nCurtis Nixon\nJason Langevin\nLacey Taylor\nMatt Harker\nMax Marshall\nShaun Christensen", "About", JOptionPane.PLAIN_MESSAGE);
		}
		else if (e.getSource() == menuItemHelpDocumentation)
		{
			try
			{
				Desktop.getDesktop().browse(acmeNoteJavadoc());
			}
			catch (IOException exception)
			{
				JOptionPane.showMessageDialog(null, exception.getMessage(), "Input/Output Exception", JOptionPane.ERROR_MESSAGE);
			}
			catch (URISyntaxException exception)
			{
				JOptionPane.showMessageDialog(null, exception.getMessage(), "URI Syntax Exception", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if (e.getSource() == menuItemHelpShortcutKeys)
		{
			JOptionPane.showMessageDialog(this, "Menu: Alt\n\nFile: Alt + F\n     Quit: Alt + F, then Alt + Q\n\nCourse: Alt + C\n     Add: Alt + C, then Alt + O\n     Delete: Alt + C, then Alt + U\n     Edit: Alt + C, then Alt + R\n\nSection: Alt + S\n     Add: Alt + S, then Alt + T\n     Delete: Alt + S, then Alt + I\n     Edit: Alt + S, then Alt + E\n\nHelp: Alt + H\n     About: Alt + H, then Alt + A\n     Documentation: Alt + H, then Alt + D\n     Shortcut Keys: Alt + H, then Alt + K", "Shortcut Keys", JOptionPane.PLAIN_MESSAGE);
		}
		else if (e.getSource() == menuItemSectionAdd)
		{
			setEnabled(false);
			setCourseIndex();
			setCourses();
			setComboBoxSelectedIndex(comboBoxSectionAddCourses, stringTemporaryCourses, intCourseIndex);

			textFieldSectionAddSectionName.setText("");

			showCard("SectionAdd");

			comboBoxSectionAddCourses.requestFocus();
		}
		else if (e.getSource() == menuItemSectionDelete)
		{
			setEnabled(false);
			setCourseSectionIndex();

			int section = intSectionIndex;

			setCourses();
			setComboBoxSelectedIndex(comboBoxSectionDeleteCourses, stringTemporaryCourses, intCourseIndex);
			setSections(intCourseIndex);
			setComboBoxSelectedIndex(comboBoxSectionDeleteSections, stringTemporarySections, section);
			setSectionDeleteEnabledSelected();
			showCard("SectionDelete");

			comboBoxSectionDeleteCourses.requestFocus();
		}
		else if (e.getSource() == menuItemSectionEdit)
		{
			setEnabled(false);
			setCourseSectionIndex();

			int section = intSectionIndex;

			setCourses();
			setComboBoxSelectedIndex(comboBoxSectionEditCourses, stringTemporaryCourses, intCourseIndex);
			setSections(intCourseIndex);
			setComboBoxSelectedIndex(comboBoxSectionEditSections, stringTemporarySections, section);
			setSectionEditEditableEnabledText();
			showCard("SectionEdit");

			comboBoxSectionEditCourses.requestFocus();
		}
	}

	// list selection event listener


	/**
	 * Fired by <tt>JList</tt> selection events.
	 */
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

	// menu event listener

	/**
	 * Fired by <tt>JMenu</tt> canceled event.
	 */
	@Override
	public void menuCanceled(MenuEvent e)
	{
	}

	/**
	 * Fired by <tt>JMenu</tt> deselected event.
	 */
	@Override
	public void menuDeselected(MenuEvent e)
	{
	}


	/**
	 * Fired by <tt>JMenu</tt> selected event.
	 */
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
					if (getSectionCount() > 0)
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

	/**
	 * Fired by <tt>Window</tt> activated event.
	 */
	@Override
	public void windowActivated(WindowEvent e)
	{
	}

	/**
	 * Fired by <tt>Window</tt> closed event.
	 */
	@Override
	public void windowClosed(WindowEvent e)
	{
	}

	/**
	 * Fired by <tt>Window</tt> closing event.
	 */
	@Override
	public void windowClosing(WindowEvent e)
	{
		acmeNote.serialize();
	}

	/**
	 * Fired by <tt>Window</tt> deactivated event.
	 */
	@Override
	public void windowDeactivated(WindowEvent e)
	{
	}

	/**
	 * Fired by <tt>Window</tt> deiconified event.
	 */
	@Override
	public void windowDeiconified(WindowEvent e)
	{
	}

	/**
	 * Fired by <tt>Window</tt> iconified event.
	 */
	@Override
	public void windowIconified(WindowEvent e)
	{
	}

	/**
	 * Fired by <tt>Window</tt> opened event.
	 */
	@Override
	public void windowOpened(WindowEvent e)
	{
	}

	// utility methods

	/**
	 * Extracts <tt>AcmeNote</tt> object's Javadoc documentation.
	 * 
	 * @return <tt>URI</tt> index of documentation. 
	 * @throws <tt>IOException</tt> <tt>Exception</tt> if unable to read or write to disk.
	 * @throws <tt>URISyntaxException</tt> <tt>Exception</tt> if uniform resource identifier is poorly formatted.
	 */
	private URI acmeNoteJavadoc() throws IOException, URISyntaxException
	{
		if (uniformResourceIdentifier == null)
		{
			File source = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath());

			if (source.isFile())
			{
				Path path = Files.createTempDirectory("acmeNoteJavadoc");

				File destination = new File(path.toUri());
				destination.mkdir();
				destination.deleteOnExit();

				JarFile jarFile = new JarFile(source);

				Enumeration<JarEntry> e = jarFile.entries();

				while (e.hasMoreElements())
				{
					JarEntry jarEntry = e.nextElement();

					if (jarEntry.getName().startsWith("javadoc"))
					{
						String string = destination + File.separator + jarEntry.getName();

						File file = new File(string);
						file.getParentFile().mkdirs();
					}
				}

				e = jarFile.entries();

				while (e.hasMoreElements())
				{
					JarEntry jarEntry = e.nextElement();

					if (jarEntry.getName().endsWith(".css") || jarEntry.getName().endsWith(".gif") || jarEntry.getName().endsWith(".html") || jarEntry.getName().endsWith("package-list"))
					{
						String string = destination + File.separator + jarEntry.getName();

						File file = new File(string);

						BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file));
						BufferedInputStream bufferedInputStream = new BufferedInputStream(jarFile.getInputStream(jarEntry));

						byte[] buffer = new byte[1024];
						int bytes;

						while ((bytes = bufferedInputStream.read(buffer)) != -1)
						{
							outputStream.write(buffer, 0, bytes);
						}

						outputStream.close();
						bufferedInputStream.close();
					}
				}

				jarFile.close();

				uniformResourceIdentifier = new File(destination.getAbsoluteFile() + "/javadoc/index.html").toURI();
			}
			else
			{
				uniformResourceIdentifier = this.getClass().getResource("/javadoc/index.html").toURI();
			}
		}

		return uniformResourceIdentifier;
	}


	/**
	 * Sets objects' <tt>Boolean</tt> enabled property.
	 * 
	 * @param b <tt>Boolean</tt> enabled value.
	 */
	public void setEnabled(boolean b)
	{
		menuCourse.setEnabled(b);
		menuSection.setEnabled(b);
		comboBoxNotesSearchCourses.setEnabled(b);
		comboBoxNotesSearchSections.setEnabled(b);
		textFieldNotesSearch.setEditable(b);
		buttonNotesSearchCancel.setEnabled(b);
		buttonNotesSearchSearch.setEnabled(b);
		listNotes.setEnabled(b);
	}

	/**
	 * Gets <tt>Section</tt> objects count.
	 * 
	 * @return <tt>Integer</tt> count of sections.
	 */
	private int getSectionCount()
	{
		int count = 0;

		for (int i = 0; i < acmeNote.getCourses().size(); i++)
		{
			count += acmeNote.getCourse(i).getSections().size();
		}

		return count;
	}

	/**
	 * Regular expression search of <tt>Note</tt> objects' note names and note text fields. 
	 * 
	 * @param string <tt>String</tt> object containing the desired input value.
	 */
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

	/**
	 * Sets <tt>JButton</tt> object's <tt>Boolean</tt> enabled property.
	 */
	private void setButtonNoteNullNoteAddEnabled()
	{
		if (acmeNote.getCourses().size() > 0 && ((intCourseIndex >= 0 && acmeNote.getCourse(intCourseIndex).getSections().size() > 0) || (intCourseIndex == -1 && getSectionCount() > 0)))
		{
			buttonNoteNullNoteAdd.setEnabled(true);
		}
		else
		{
			buttonNoteNullNoteAdd.setEnabled(false);
		}
	}

	/**
	 * Sets <tt>JCheckBox</tt> object's <tt>Boolean</tt> selected property.
	 * 
	 * @param checkBox <tt>JCheckBox</tt> object to check if selected.
	 * @param button <tt>JButton</tt> object to set selected value.
	 */
	private void setCheckBoxIsSelected(JCheckBox checkBox, JButton button)
	{
		if (checkBox.isSelected() == true)
		{
			button.setEnabled(true);
		}
		else
		{
			button.setEnabled(false);
		}
	}

	/**
	 * Sets the selected index for a <tt>JComboBox</tt>.
	 * 
	 * @param comboBox <tt>JComboBox</tt> object to update.
	 * @param string <tt>String</tt> <tt>Array</tt> to insert into <tt>JComboBox</tt>.
	 * @param index <tt>Integer</tt> index to select.
	 */
	private void setComboBoxSelectedIndex(JComboBox<String> comboBox, String[] string, int index)
	{
		comboBox.setModel(new DefaultComboBoxModel<String>(string));

		if (index < 0)
		{
			index = 0;
		}

		if (string.length > 0)
		{
			comboBox.setSelectedIndex(index);
		}
	}

	/**
	 * Sets <tt>Course</tt> object index.
	 */
	private void setCourseIndex()
	{
		if (intCourseIndex < 0)
		{
			setIndex("course", 0);
		}
	}

	/**
	 * Sets temporary <tt>Integer</tt> <tt>Array</tt> of <tt>Course</tt> objects' indices and temporary <tt>String</tt> <tt>Array</tt> of <tt>Course</tt> objects' course names.
	 */
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

	/**
	 * Sets <tt>Integer</tt> <tt>Array</tt> of <tt>Course</tt> objects' indices and <tt>String</tt> <tt>Array</tt> of <tt>Course</tt> objects' course names.
	 */
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

	/**
	 * Sets <tt>Course</tt> object and <tt>Section</tt> object index.
	 */
	private void setCourseSectionIndex()
	{
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
	}

	/**
	 * Sets <tt>Course</tt>, <tt>Section</tt>, or <tt>Note</tt> object's index.
	 * 
	 * @param string <tt>String</tt> identifier of <tt>Course</tt>, <tt>Section</tt>, or <tt>Note</tt> object.
	 * @param index <tt>Integer</tt> index of object.
	 */
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
		else
		{
			showErrorMessage(this, "Unable to set '" + string + "' index. Please try again.");
		}
	}

	/**
	 * Sets the selected index for a <tt>JList</tt>.
	 * 
	 * @param list <tt>JList</tt> object to update.
	 * @param string <tt>String</tt> <tt>Array</tt> to insert into <tt>JList</tt>.
	 * @param index <tt>Integer</tt> index to select.
	 */
	private void setListSelectedIndex(JList<String> list, String[] string, int index)
	{
		list.setModel(new DefaultComboBoxModel<String>(string));
		list.setSelectedIndex(index);
	}

	/**
	 * Sets temporary <tt>Integer</tt> <tt>Array</tt> of <tt>Note</tt> objects' associated <tt>Course</tt> objects' indices, temporary <tt>Integer</tt> <tt>Array</tt> of <tt>Note</tt> objects' associated <tt>Section</tt> objects' indices, temporary <tt>Integer</tt> <tt>Array</tt> of <tt>Note</tt> objects' indices, and temporary <tt>String</tt> <tt>Array</tt> of <tt>Note</tt> objects' notes names and note text.
	 * 
	 * @param course <tt>Integer</tt> index of <tt>Course</tt> object.
	 * @param section <tt>Integer</tt> index of <tt>Section</tt> object.
	 */
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

	/**
	 * Sets <tt>Integer</tt> <tt>Array</tt> of <tt>Note</tt> objects' associated <tt>Course</tt> objects' indices, <tt>Integer</tt> <tt>Array</tt> of <tt>Note</tt> objects' associated <tt>Section</tt> objects' indices, <tt>Integer</tt> <tt>Array</tt> of <tt>Note</tt> objects' indices, and <tt>String</tt> <tt>Array</tt> of <tt>Note</tt> objects' notes names and note text.
	 * 
	 * @param course <tt>Integer</tt> index of <tt>Course</tt> object.
	 * @param section <tt>Integer</tt> index of <tt>Section</tt> object.
	 */
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

	/**
	 * Sets objects' <tt>Boolean</tt> enabled and selected properties.
	 */
	private void setSectionDeleteEnabledSelected()
	{
		if (acmeNote.getCourse(intCourseIndex).getSections().size() > 0)
		{
			comboBoxSectionDeleteSections.setEnabled(true);
			checkBoxSectionDelete.setEnabled(true);
		}
		else
		{
			comboBoxSectionDeleteSections.setEnabled(false);
			checkBoxSectionDelete.setEnabled(false);
		}

		checkBoxSectionDelete.setSelected(false);
		buttonSectionDeleteSubmit.setEnabled(false);
	}
	/**
	 * Sets objects' <tt>Boolean</tt> editable, enabled, and text properties. 
	 */
	private void setSectionEditEditableEnabledText()
	{
		if (acmeNote.getCourse(intCourseIndex).getSections().size() > 0)
		{
			comboBoxSectionEditSections.setEnabled(true);
			textFieldSectionEditSectionName.setEditable(true);
			textFieldSectionEditSectionName.setText(comboBoxSectionEditSections.getSelectedItem().toString());
			buttonSectionEditSubmit.setEnabled(true);
		}
		else
		{
			comboBoxSectionEditSections.setEnabled(false);
			textFieldSectionEditSectionName.setEditable(false);
			textFieldSectionEditSectionName.setText("");
			buttonSectionEditSubmit.setEnabled(false);
		}
	}

	/**
	 * Sets temporary <tt>Integer</tt> <tt>Array</tt> of <tt>Section</tt> objects' associated <tt>Course</tt> objects' indices, temporary <tt>Integer</tt> <tt>Array</tt> of <tt>Section</tt> objects' indices, and temporary <tt>String</tt> <tt>Array</tt> of <tt>Section</tt> objects' section names.
	 * 
	 * @param course <tt>Integer</tt> index of <tt>Course</tt> object.
	 */
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

	/**
	 * Sets <tt>Integer</tt> <tt>Array</tt> of <tt>Section</tt> objects' associated <tt>Course</tt> objects' indices, <tt>Integer</tt> <tt>Array</tt> of <tt>Section</tt> objects' indices, and <tt>String</tt> <tt>Array</tt> of <tt>Section</tt> objects' section names.
	 * 
	 * @param course <tt>Integer</tt> index of <tt>Course</tt> object.
	 */
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
			int i = getSectionCount();

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

	/**
	 * Sets <tt>CardLayout</tt> <tt>JPanel</tt> object to display.
	 * 
	 * @param string <tt>String</tt> <tt>JPanel</tt> identifier.
	 */
	private void showCard(String string)
	{
		if (string.equals("CourseAdd") || string.equals("CourseDelete") || string.equals("CourseEdit") || string.equals("NoteAdd") || string.equals("NoteDelete") || string.equals("NoteEdit") || string.equals("NoteNull") || string.equals("NoteView") || string.equals("SectionAdd") || string.equals("SectionDelete") || string.equals("SectionEdit"))
		{
			cardLayout.show(panelCards, string);
		}
		else
		{
			showErrorMessage(this, "Unable to show '" + string + "' panel. Please try again.");
		}
	}

	/**
	 * Displays error message.
	 * 
	 * @param string <tt>String</tt> object containing the error message.
	 */
	private void showErrorMessage(AcmeNoteGraphicalUserInterface frame, String string)
	{
		JOptionPane.showMessageDialog(frame, "Error", string, JOptionPane.ERROR_MESSAGE);
	}

	// main method

	/**
	 * Main method to launch graphical user interface.
	 * 
	 * @param args <tt>String</tt> <tt>Array</tt> object of user generated arguments.
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