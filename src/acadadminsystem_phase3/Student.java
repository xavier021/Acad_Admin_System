package acadadminsystem_phase3;

import java.util.*;


public class Student extends Person
{
    // instance variables
    private int studentID;
    private String dateOfAdmission;
    private String major;
    private ArrayList<CourseGrade> coursesTaken = new ArrayList<>();
    
    /**
     * This constructor initializes the fields to the passed values.
     * @param first Student's first name.
     * @param last Student's last name.
     * @param id Student's ID.
     * @param admDate Student's admission date.
     * @param stdntMajor Student's major.
     * @param courses Student's list of courses taken.
     */
    public Student(String first, String last, int id, String admDate, String stdntMajor, ArrayList<CourseGrade> courses)
    {
        super(first, last);
        studentID = id;
        dateOfAdmission = admDate;
        major = stdntMajor;
        
        // before trying to iterate through the courses array list, make sure it isn't null
        if(courses != null)
        {
            // create a copy of each CourseGrade element and add it to the coursesTaken instance variable
            for( CourseGrade courseElem : courses )
            {
                if( courseElem != null )
                    coursesTaken.add( new CourseGrade(courseElem) );
                else
                    coursesTaken.add(null);
            }
        }
    }
    
    /**
     * This is a copy constructor. It initializes the fields of the object being created to the same
     * values as the fields in the object passed as an argument.
     * @param studentObject The object being copied.
     */
    public Student(Student studentObject)
    {
        super(studentObject);
        if( studentObject != null )
        {
            studentID = studentObject.studentID;
            dateOfAdmission = studentObject.dateOfAdmission;
            major = studentObject.major;
            
            // create a copy of each CourseGrade element and add it to the coursesTaken instance variable
            for( CourseGrade courseElem : studentObject.coursesTaken )
            {
                if( courseElem != null )
                    coursesTaken.add( new CourseGrade(courseElem) );
                else
                    coursesTaken.add(null);
            }
        }
    }
    
    /**
     * The getStudentID method returns a Student's id.
     * @return The value in the studentID field.
     */
    public int getStudentID()
    {
        return studentID;
    }
    
    /**
     * The getDateOfAdmission method returns a Student's date of admission.
     * @return The value in the dateOfAdmission field.
     */
    public String getDateOfAdmission()
    {
        return dateOfAdmission;
    }
    
    /**
     * The getMajor method returns a Student's major.
     * @return The value in the major field.
     */
    public String getMajor()
    {
        return major;
    }
    
    /**
     * The getCoursesTaken method returns a Student's list of courses taken.
     * @return A reference to a copy of this student's ArrayList of courses taken.
     */
    public ArrayList<CourseGrade> getCoursesTaken()
    {
        ArrayList<CourseGrade> newList = new ArrayList<>();
        for( CourseGrade courseElem : coursesTaken )
        {
            if( courseElem != null )
                newList.add(new CourseGrade(courseElem));
            else
                newList.add(null);
        }
        
        return newList;
    }
    
    /**
     * The setStudentID method stores a value in the studentID field.
     * @param id the value to store in studentID.
     */
    public void setStudentID(int id)
    {
        studentID = id;
    }
    
    /**
     * The setDateOfAdmission method stores a value in the dateOfAdmission field.
     * @param admDate the value to store in dateOfAdmission.
     */
    public void setDateOfAdmission(String admDate)
    {
        dateOfAdmission = admDate;
    }
    
    /**
     * The setMajor method stores a value in the major field.
     * @param stdntMajor the value to store in major.
     */
    public void setMajor(String stdntMajor)
    {
        major = stdntMajor;
    }
    
    /**
     * The setCoursesTaken method stores a value in the coursesTaken field.
     * @param courses the list of courses to store in the coursesTaken field.
     */
    public void setCoursesTaken(ArrayList<CourseGrade> courses)
    {
        coursesTaken.clear();
        if( courses != null )
        {
            for( CourseGrade courseElem : courses )
            {
                if( courseElem != null )
                    coursesTaken.add( new CourseGrade( courseElem) ); 
                else
                    coursesTaken.add(null);
            }
        }
    }
    
    /**
     * The toString method returns a string representing the state of a Student object.
     * @return A string containing the student's information: first name, last name, id, 
     * date of admission, major, and list of courses taken.
     */  
    @Override
    public String toString()
    {
        String coursesInfo = "";
        
        if( coursesTaken == null || coursesTaken.isEmpty() )
            coursesInfo += "No courses taken.";
        else
        {
            AcadAdminUtility.sortArrayList(coursesTaken);
            coursesInfo = coursesTaken.get(0).getCourseTaken().getCourseNumber() + 
                                                  " " + coursesTaken.get(0).getLetterGrade();
            for( int i=1; i<coursesTaken.size(); i++ )
                coursesInfo += String.format("\n%-30s %s", "", coursesTaken.get(i).getCourseTaken().getCourseNumber() + 
                                                  " " + coursesTaken.get(i).getLetterGrade());
        }
        
        String output = super.toString() + String.format("\n%-30s %s \n%-30s %s \n%-30s %s \n%-30s %s", 
                                           "Student ID:", studentID,
                                           "Major:", major,
                                           "Admission Date:", dateOfAdmission,
                                           "Courses Taken:", coursesInfo);
        
        
        
        return output;
    }

    /**
     * The equals method compares two Student objects. The result is true if the argument 
     * is not null and is a Student object with the same values for the first name, last name, and
     * dateOfAdmission fields as the calling object.
     * @param obj The object to compare this Student with.
     * @return true if the given object has the same value for the first name, last name, and
     * dateOfAdmission fields.
     */
    @Override
    public boolean equals(Object obj) 
    {
        // check that the type of the parameter is Student
        if( !(obj instanceof Student) )
            return false;
        
        // we already know that obj is of type Student, so it's safe to cast
        Student stdntObj = (Student) obj;
        
        // return true or false depending on whether firstName, lastName and dateOfAdmission have the same value
        return super.equals(stdntObj) && stdntObj.dateOfAdmission.equals(this.dateOfAdmission);     
    }
    
}
