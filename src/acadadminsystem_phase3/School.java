package acadadminsystem_phase3;

import java.util.*;


public class School
{
    // instance variables
    private String schoolName;
    private ArrayList<Student> listOfStudents = new ArrayList<>();
    private InstructorLinkedList listOfInstructors = new InstructorLinkedList();
    private ArrayList<Course> listOfCourses = new ArrayList<>();
    
    /**
     * This constructor initializes the fields to the passed values.
     * @param name The school name.
     * @param students The list of students attending the school.
     * @param instructors The list of instructors teaching at the school.
     * @param courses The list of courses taught at the school.
     */
    public School(String name, ArrayList<Student> students, InstructorLinkedList instructors, ArrayList<Course> courses)
    {
        schoolName = name;

        // before trying to iterate through the students array list, make sure it isn't null
        if(students != null)
        {
            // create a copy of each Student element and add it to the listOfStudents instance variable
            for( Student studentElement : students )
            {
                if( studentElement != null )
                {
                    if( studentElement instanceof DualEnrolledStudent )
                        listOfStudents.add(new DualEnrolledStudent((DualEnrolledStudent)studentElement));
                    else if( studentElement instanceof TransientStudent )
                        listOfStudents.add(new TransientStudent((TransientStudent)studentElement));
                    else
                        listOfStudents.add(new Student(studentElement));
                }
                else
                    listOfStudents.add(null);
            }
        }
        
        // before trying to copy the instructors linked list, make sure it isn't null
        if(instructors != null)
            listOfInstructors = instructors.copy();
        
        // before trying to iterate through the courses array list, make sure it isn't null
        if(courses != null)
        {
            // create a copy of each Course element and add it to the listOfCourses instance variable
            for( Course courseElement : courses )
            {
                if( courseElement != null )
                    listOfCourses.add(new Course(courseElement));
                else
                    listOfCourses.add(null);
            }
        }
    }
    
    /**
     * The getSchoolName method returns the school name.
     * @return School name.
     */
    public String getSchoolName()
    {
        return schoolName;
    }
    
    /**
     * The getListOfStudents method returns the list of students attending the school.
     * @return list of students attending the school.
     */
    public ArrayList<Student> getListOfStudents()
    {
        ArrayList<Student> newList = new ArrayList<>();
        for( Student studentElement : listOfStudents )
        {
            if( studentElement != null )
            {
                if( studentElement instanceof DualEnrolledStudent )
                    listOfStudents.add(new DualEnrolledStudent((DualEnrolledStudent)studentElement));
                else if( studentElement instanceof TransientStudent )
                    listOfStudents.add(new TransientStudent((TransientStudent)studentElement));
                else
                    listOfStudents.add(new Student(studentElement));
            }
            else
                listOfStudents.add(null);
        }
        
        return newList;
    }
    
    /**
     * The getListOfInstructors method returns the list of instructors teaching at the school.
     * @return list of instructors teaching at the school.
     */
    public InstructorLinkedList getListOfInstructors()
    {
        if(listOfInstructors != null)
            return listOfInstructors.copy();
        else
            return null;
    }
    
    /**
     * The getListOfCourses method returns the list of courses taught at the school.
     * @return list of courses taught at the school.
     */
    public ArrayList<Course> getListOfCourses()
    {
        ArrayList<Course> newList = new ArrayList<>();
        for( Course courseElement : listOfCourses )
        {
            if( courseElement != null )
                newList.add(new Course(courseElement));
            else
                newList.add(null);
        }
        
        return newList;
    }
    
    /**
     * The setSchoolName method stores a value in the name field.
     * @param name the new school name.
     */
    public void setSchoolName(String name)
    {
        schoolName = name;
    }
    
    /**
     * The setListOfStudents method stores a value in the listOfStudents field.
     * @param students the list of students to store in the listOfStudents field.
     */
    public void setListOfStudents(ArrayList<Student> students)
    {
        if(students != null)
        {
            // create a copy of each Student element and add it to the listOfStudents instance variable
            for( Student studentElement : students )
            {
                if( studentElement != null )
                {
                    if( studentElement instanceof DualEnrolledStudent )
                        listOfStudents.add(new DualEnrolledStudent((DualEnrolledStudent)studentElement));
                    else if( studentElement instanceof TransientStudent )
                        listOfStudents.add(new TransientStudent((TransientStudent)studentElement));
                    else
                        listOfStudents.add(new Student(studentElement));
                }
                else
                    listOfStudents.add(null);
            }
        }
    }
    
    /**
     * The setListOfInstructors method stores a value in the listOfInstructors field.
     * @param instructors the list of instructors to store in the listOfInstructors field.
     */
    public void setListOfInstructors(InstructorLinkedList instructors)
    {
        if( instructors != null )
            listOfInstructors = instructors.copy(); 
    }
    
    /**
     * The setListOfCourses method stores a value in the listOfCourses field.
     * @param courses the list of courses to store in the listOfCourses field.
     */
    public void setListOfCourses(ArrayList<Course> courses)
    {
        listOfCourses.clear();
        
        if( courses != null )
        {
            for( Course courseElement : courses )
            {
                if( courseElement != null )
                    listOfCourses.add( new Course(courseElement) ); 
                else
                    listOfCourses.add(null);
            }
        }
    }
    
    /**
     * The toString method returns a string representing the state of a School object.
     * @return A string containing the school's information: school name, list of students, list of 
     * instructors, and list of courses.
     */ 
    @Override
    public String toString()
    {
        String output = String.format("\n%-30s %s", 
                             "School Name:", schoolName);
        
        output  += "\n\n***********************************************************\n"
                +  "*                      List of Students                   *\n"
                +  "***********************************************************\n";
        
        if( listOfStudents == null || listOfStudents.isEmpty() )
            output += "There are no students.";
        else
        {
            AcadAdminUtility.sortArrayList(listOfStudents);
            for( Student studentElement : listOfStudents)
                output  += studentElement
                        + "\n========================================================\n";
        }
        
        output  += "\n\n***********************************************************\n"
                +  "*                    List of Instructors                  *\n"
                +  "***********************************************************\n";
          
        if( listOfInstructors == null || listOfInstructors.isEmpty() )
            output += "There are no instructors.";
        else
            output += "\n" + listOfInstructors.toString();
        
        output  += "\n\n***********************************************************\n"
                +  "*                      List of Courses                    *\n"
                +  "***********************************************************\n";
          
        if( listOfCourses == null || listOfCourses.isEmpty() )
            output += "There are no courses.";
        else
        {
            AcadAdminUtility.sortArrayList(listOfCourses);
            for( Course courseElement : listOfCourses )
                output += "\n" + courseElement;
        }
        
        return output;
    }
    
    
    /**
     * The addStudent method adds to the listOfStudents instance variable a copy of the Student object 
     * passed as an argument.
     * @param studentObj the object to be copied and added to the listOfStudents instance variable.
     */
    public void addStudent(Student studentObj)
    {
        if( studentObj != null )
        {
            if( studentObj instanceof DualEnrolledStudent )
                listOfStudents.add(new DualEnrolledStudent((DualEnrolledStudent)studentObj));
            else if( studentObj instanceof TransientStudent )
                listOfStudents.add(new TransientStudent((TransientStudent)studentObj));
            else
                listOfStudents.add(new Student(studentObj));
        }
        else
            listOfStudents.add(null);
    }
    
    
    /**
     * The findStudentByID method iterates through the listOfStudents instance variable
     * looking for the Student that has the same ID as the argument passed to the method.
     * @param id ID of the Student to look for.
     * @return Student found to have the given id, null otherwise.
     */
    public Student findStudentByID(int id)
    {
        if( listOfStudents != null )
        {
            for( Student stdnt : listOfStudents )
            {
                if( stdnt.getStudentID() == id )
                {
                    if( stdnt instanceof DualEnrolledStudent )
                        return new DualEnrolledStudent((DualEnrolledStudent)stdnt);
                    else if( stdnt instanceof TransientStudent )
                        return new TransientStudent((TransientStudent)stdnt);
                    else
                        return new Student(stdnt);
                }
            }
        }
        return null;
    }
    
    
    /**
     * The addInstructor method adds to the listOfInstructors instance variable a copy of the Instructor  
     * object passed as an argument.
     * @param instrObj the object to be copied and added to the listOfInstructors instance variable.
     */
    public void addInstructor(Instructor instrObj)
    {
        
            listOfInstructors.add(new Instructor(instrObj));
    }
    
    
    private Instructor findInstructor(String instrFirst, String instrLast)
    {
         if( listOfInstructors != null )
             return listOfInstructors.find(instrFirst, instrLast);
         else
             return null;     
    }
    
    
    /**
     * The addCourse method creates a new Course object and adds it to the 
     * listOfCourses instance variable.
     * @param crseNumber the course number of the Course to be created.
     * @param credits the number of credits of the Course to be created.
     * @param instrFirst first name of the Instructor teaching the course.
     * @param instrLast last name of the Instructor teaching the course.
     */
    public void addCourse(String crseNumber, int credits, String instrFirst, String instrLast)
    {
       Instructor instr = findInstructor(instrFirst,instrLast);
        Course newCourse = new Course(crseNumber,credits,instr);
        listOfCourses.add(newCourse);
    }
    
    
    public Course findCourse(String crseNumber)
    {
        if( listOfCourses != null)
        {
            for( Course courses : listOfCourses)
            {
                if(courses.getCourseNumber().equals(crseNumber))
                {
                    return new Course(courses);
                }
            }
        }
        return null;
    }
}
