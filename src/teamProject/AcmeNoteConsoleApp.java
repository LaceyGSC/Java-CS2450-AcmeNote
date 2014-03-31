package teamProject;

import java.util.Scanner;

import acmeNote.AcmeNote;
import acmeNote.Course;
import acmeNote.Note;
import acmeNote.Section;

public class AcmeNoteConsoleApp
{
	private static Course	currentCourse;
	private static Section	currentSection;
	private static Note 	currentNote;
	
	private static AcmeNote myAcmeNote;

	/**
	 * @param args
	 */
	public static void main( String[] args )
	{
		myAcmeNote = new AcmeNote();
		
		Scanner input = new Scanner( System.in );
		
		int selection;
		
		do
		{
			System.out.println();
			displayTopRow();
			displayCurrentNote();
			displayMenu();
			selection = input.nextInt();
			switch ( selection )
			{
				case 1:  selectCourse(); break;
				case 2:  selectSection(); break;
				case 3:  selectNote(); break;
				case 4:  renameCourse(); break;
				case 5:  renameSection(); break;
				case 6:  renameNote(); break;
				case 7:  deleteCourse(); break;
				case 8:  deleteSection(); break;
				case 9:  deleteNote(); break;
				case 10: addCourse(); break;
				case 11: addSection(); break;
				case 12: addNote(); break;
				case 13: System.out.println( "Goodbye"); break;
				case 14: System.out.println( "\n" + myAcmeNote.toString() );
				case 15: editNote(); break;
			}
		}while ( selection != 13 );

		myAcmeNote.serialize();
	}

	private static void selectCourse()
	{
		if ( myAcmeNote.getCourses().isEmpty() )
		{
			System.out.println( "\nAcmeNote does not currently contain any Courses!\nTry: Add Course." );
		} else
		{
			for ( int index = 0; index < myAcmeNote.getCourses().size(); index++ )
			{
				System.out.printf( "%d. %s\n", index, myAcmeNote.getCourses().get( index ).getCourseName() );
			}
			
			System.out.print( "Enter the number of the Course you want to select: " );
			Scanner input = new Scanner( System.in );
			currentNote = null;
			currentSection = null;
			currentCourse = myAcmeNote.getCourses().get( input.nextInt() );
		}
	}

	private static void selectSection()
	{
		if ( currentCourse != null )
		{
			if ( currentCourse.getSections().isEmpty() )
			{
				System.out.println( "\n" + currentCourse.getCourseName() + " does not currently have any Sections!\n Try: Add Section" );
			}else
			{
				for ( int index = 0; index < currentCourse.getSections().size(); index++ )
				{
					System.out.printf( "%d. %s\n", index, currentCourse.getSections().get( index ).getSectionName() );
				}
				
				System.out.print( "Enter the number of the Section you want to select: " );
				Scanner input = new Scanner( System.in );
				currentNote = null;
				currentSection = currentCourse.getSections().get( input.nextInt() );
			}
		} else
		{
			System.out.println( "\nYou must select a Course first." );
		}
	}

	private static void selectNote()
	{
		if ( currentSection != null )
		{
			if ( currentSection.getNotes().isEmpty() )
			{
				System.out.println( "\n" + currentSection.getSectionName() + " does not currently have any Notes!\n Try: Add Note" );
			}else
			{	
				for ( int index = 0; index < currentSection.getNotes().size(); index++ )
				{
					System.out.printf( "%d. %s\n", index, currentSection.getNotes().get( index ).getNoteName() );
				}
				
				System.out.print( "Enter the number of the Note you want to select: " );
				Scanner input = new Scanner( System.in );
				currentNote = currentSection.getNotes().get( input.nextInt() );
			}
		} else
		{
			System.out.println( "\nYou must select a Section first." );
		}
	}

	private static void renameCourse()
	{
		if ( currentCourse != null )
		{
			System.out.print( "\nEnter new name for the current Course: " );
			Scanner input = new Scanner( System.in );
			currentCourse.setCourseName( input.nextLine() );
		} else
		{
			System.out.println( "\nPlease select a course first." );
		}
	//		System.out.println();
	//		for ( int index = 0; index < myAcmeNote.getCourses().size(); index++ )
	//		{
	//			System.out.println( index + ". " + myAcmeNote.getCourse( index ).getCourseName() );
	//		}
	}

	private static void renameSection()
	{
		if ( currentSection != null )
		{
			System.out.print( "\nEnter new name for the current Section: " );
			Scanner input = new Scanner( System.in );
			currentSection.setSectionName( input.nextLine() );
		} else
		{
			System.out.println( "\nPlease select a Section first." );
		}
	}

	private static void renameNote()
	{
		if ( currentNote != null )
		{
			System.out.print( "\nEnter new name for the current Note: " );
			Scanner input = new Scanner( System.in );
			currentNote.setNoteName( input.nextLine() );
		} else
		{
			System.out.println( "\nPlease select a Note first." );
		}
	}

	private static void deleteCourse()
	{
		if ( currentCourse != null )
		{
			System.out.println( currentCourse.toString() );
			System.out.print( "Are you sure you want to delete " + currentCourse.getCourseName() + " (y/n)? " );
			Scanner input = new Scanner( System.in );
			if ( input.nextLine().toString().toLowerCase().startsWith( "y" ) )
			{
				myAcmeNote.removeCourse( myAcmeNote.getCourses().indexOf( currentCourse ) );
				currentNote = null;
				currentSection = null;
				currentCourse = null;
			}
		}else
		{
			System.out.println( "\nPlease select a Course first." );
		}	
	}

	private static void deleteSection()
	{
		if ( currentSection != null )
		{
			System.out.println( currentSection.toString() );
			System.out.print( "Are you sure you want to delete " + currentSection.getSectionName() + " (y/n)? " );
			Scanner input = new Scanner( System.in );
			if ( input.nextLine().toString().toLowerCase().startsWith( "y" ) )
			{
				currentCourse.removeSection( currentCourse.getSections().indexOf( currentSection ) );
				currentNote = null;
				currentSection = null;
			}
		}else
		{
			System.out.println( "\nPlease select a Section first." );
		}
	}

	private static void deleteNote()
	{
		if ( currentNote != null )
		{
			System.out.println( currentNote.toString() );
			System.out.print( "Are you sure you want to delete " + currentNote.getNoteName() + " (y/n)? " );
			Scanner input = new Scanner( System.in );
			if ( input.nextLine().toString().toLowerCase().startsWith( "y" ) )
			{
				currentSection.removeNote( currentSection.getNotes().indexOf( currentNote ) );
				currentNote = null;
			}
		}else
		{
			System.out.println( "\nPlease select a Note first." );
		}
	}

	private static void addCourse()
	{
		System.out.print( "\nEnter name of Course to add: " );
		Scanner input = new Scanner( System.in );
		myAcmeNote.addCourse( new Course( input.nextLine() ) );	
	}

	private static void addSection()
	{
		if ( currentCourse == null )
		{
			selectCourse();
		}
		if ( currentCourse != null )
		{
			System.out.print( "\nEnter name of Section to add: " );
			Scanner input = new Scanner( System.in );
			currentCourse.addSection( new Section( input.nextLine() ) );
		}
	}

	private static void addNote()
	{
		if ( currentSection == null )
		{
			selectSection();
		}
		if ( currentSection != null )
		{
			System.out.print( "\nEnter name of Note to add: " );
			Scanner input = new Scanner( System.in );
			String noteName = input.nextLine();
			System.out.println( "Enter the body of the note: " );
			String noteText = input.nextLine();
			currentSection.addNote( new Note( noteName, noteText ) );
		}
	}

	private static void editNote()
	{
		// TODO Auto-generated method stub
		
	}

	private static void displayTopRow()
	{
		System.out.println( "AcmeNote    Course: " + ( currentCourse == null ? "null" : currentCourse.getCourseName() )
				+ "   Section: " + ( currentSection == null ? "null" : currentSection.getSectionName() ) );
		System.out.println();
		
	}

	private static void displayCurrentNote()
	{
		System.out.println( "Note: " + ( currentNote == null ? "null" : currentNote.getNoteName() ) + "\n" );
		System.out.println( ( currentNote == null ? "null" : currentNote.getNoteText() ) );
		System.out.println();
		
	}

	private static void displayMenu()
	{
		System.out.println( "1.  Select.Course    2.  Select.Section    3.  Select.Note" );
		System.out.println( "4.  Rename.Course    5.  Rename.Section    6.  Rename.Note" );
		System.out.println( "7.  Delete.Course    8.  Delete.Section    9.  Delete.Note" );
		System.out.println( "10. Add....Course    11. Add....Section    12. Add....Note" );
		System.out.println( "13. Exit             14. Display AcmeNote  15. Edit...Note" );
		System.out.print( "Make your selection: " );
	}
}
