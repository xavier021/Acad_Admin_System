package acadadminsystem_phase3;

import java.io.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Xavier Santana
 * Completed
 */
public class AcadAdminSystem_Phase3 
{

    private static School mySchool;
    private static JFileChooser fileChooser = new JFileChooser(".");
    
    public static void main(String[] args)
    {
        // Initialize the School object
        mySchool = new School("Technical Institute of Miami", null, null, null);
        
               
        // Ask the user what they want to do.
        String options = "\t [1] to load a new data file\n"
                        + "\t [2] to add a new instructor\n"
                        + "\t [3] to add a new course\n"
                        + "\t [4] to add a new student\n"
                        + "\t [5] to add a new dual enrolled student\n"
                        + "\t [6] to add a new transient student\n"
                        + "\t [7] to search for a student\n"
                        + "\t [8] to display school information\n"
                        + "\t [q] to quit the application";
        

        String menuMessage = "Please enter one of the following options:\n" + options;
        String userInput = JOptionPane.showInputDialog(null, menuMessage, "Academic System", JOptionPane.QUESTION_MESSAGE);
        
        while (userInput != null && !userInput.equalsIgnoreCase("q")) 
        {
            switch (userInput) 
            {
                case "1":
                    importDataFile();
                    break;
                    
                case "2":
                    promptUserForData("I");
                    break;
                    
                case "3":
                    promptUserForData("C");
                    break;
                    
                case "4":
                    promptUserForData("S");
                    break;
                    
                case "5":
                    promptUserForData("D");                   
                    break;
                    
                case "6":
                    promptUserForData("T");
                    break;
                    
                case "7":
                    String message = "Enter ID of student to search for";
                    String stdntID = JOptionPane.showInputDialog(null, message, "Student Last Name", JOptionPane.INFORMATION_MESSAGE);
                    Student foundStudent = mySchool.findStudentByID(Integer.parseInt(stdntID));
                    
                    if( foundStudent == null )
                        System.out.println("\n\nNo student found with that ID.");
                    else
                        System.out.println("\n\nStudent Found: " + foundStudent);
                    break;
                    
                case "8":
                    System.out.println(mySchool);  
                    break;
                    
                default:
                    JOptionPane.showMessageDialog(null, "Invalid entry. Please try again.", 
                            "Invalid entry", JOptionPane.INFORMATION_MESSAGE);
                    break;
            }
            userInput = JOptionPane.showInputDialog(menuMessage);
        }    
        
        JOptionPane.showMessageDialog(null, "Quitting application.");
        
        System.exit(0);  
             
    }

    private static void importDataFile()
    {
        System.out.println("Loading new data file");

        // Prompt the user to select an input data file
        File selectedFile;

        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
        {
            selectedFile = fileChooser.getSelectedFile();

            // try with resources. The inputFile Scanner object will be closed automatically.
            try (Scanner inputFile = new Scanner(selectedFile))
            {
                // read all lines of data from the file and process them
                String line;
                int lineNumber = 1;
                while (inputFile.hasNext())
                {
                    line = inputFile.nextLine();
                    try
                    {
                        processLineOfData(line);
                    } 
                    catch (Exception ex)
                    {
                        String message  = "The following error occurred while processing line number "
                                        + lineNumber + ": " + ex.toString()
                                        + "\nLine of data skipped: " + line;
                       
                        System.out.println(message);
                    }
                    lineNumber++;
                }
            } 
            catch (FileNotFoundException e)
            {
                System.out.println(e.toString());
            } 
        
            System.out.println("Done loading data.");
        }
    }
    
    
    private static void processLineOfData(String line) throws Exception
    {
       String[] elems = line.split(",");
       String message = "Bad record";
       
       
       
       try{
           
           

               switch (elems[0]) {
                   case "I":
                       Instructor instrObj = new Instructor(elems[1],elems[2],
                               elems[3]);
                       mySchool.addInstructor(instrObj);
                       break;
                   case "C":
                       mySchool.addCourse(elems[1],Integer.parseInt(elems[2]),elems[3],elems[4]);
                       break;
                   case "S":
                       Student stuObj = new Student(elems[1],elems[2],
                               Integer.parseInt(elems[3]),elems[4],elems[5],
                               parseStudentCourseGrades(elems[6]));
                       mySchool.addStudent(stuObj);
                       break;
                   case "D":
                       DualEnrolledStudent dualEnr = new DualEnrolledStudent(elems[1],
                               elems[2],Integer.parseInt(elems[3]),elems[4],elems[5],parseStudentCourseGrades(elems[6]),
                               elems[7],Integer.parseInt(elems[8]));
                       mySchool.addStudent(dualEnr);
                       break;
                   case "T":
                       TransientStudent traStu = new TransientStudent(elems[1],
                               elems[2],Integer.parseInt(elems[3]),elems[4],elems[5],
                               parseStudentCourseGrades(elems[6]),elems[7]);
                       mySchool.addStudent(traStu);
                       break;
                   

            }           
        }catch(Exception e)
                {
                    System.out.println(message);
                    throw e;
                }
          
    }
    
    
    private static ArrayList<CourseGrade> parseStudentCourseGrades(String courseList) 
    {
        ArrayList<CourseGrade> courses = new ArrayList<>();
        
        String[] courseArray = courseList.split("#");
        for( String courseInfo : courseArray)
        {
            String[] courseParts = courseInfo.split(":");
            Course courseObj = mySchool.findCourse(courseParts[0]);
            CourseGrade courseGradeObj = new CourseGrade(courseObj, courseParts[1]);
            courses.add(courseGradeObj);
        }
        return courses;
    }
    
    
    private static void promptUserForData(String dataType)
    {
        String dialogMessage = "", dialogTitle = "";
        
        switch( dataType )
        {
            case "I":
                dialogMessage = "\"Enter instructor information in this format: first name,last name,office number\"";
                dialogTitle = "Instructor Information";
                break;
                
            case "C":
                dialogMessage = "Enter course information in this format: course number,number of credits,instructor first name,instructor last name, office hours";
                dialogTitle = "Course Information";
                break;
                
            case "S":
                dialogMessage = "Enter student information in this format: first,last,id,admission date,major,list of courses";
                dialogTitle = "Student Information";
                break;
                
            case "D":
                dialogMessage = "Enter dual enrolled student information in this format: first,last,id,admission date,major,list of courses,HS name,HS grade";
                dialogTitle = "Dual Enrolled Student Information";
                break;
                
            case "T":
                dialogMessage = "Enter transient student information in this format: first,last,id,admission date,major,list of courses,Col name";
                dialogTitle = "Transient Student Information";
                break;
        }
      
        String userInput = JOptionPane.showInputDialog(null, dialogMessage, dialogTitle, JOptionPane.INFORMATION_MESSAGE);
        try
        {
            processLineOfData(dataType + "," + userInput);
        } 
        catch (Exception ex)
        {
            String errorMessage = "The following error occurred while processing the " + dialogTitle.toLowerCase() + " you entered: ";
            System.out.println(errorMessage + ex.toString());
        }
    }
    
}
