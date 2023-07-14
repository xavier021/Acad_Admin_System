package acadadminsystem_phase3;

import java.util.*;

public class TransientStudent extends Student
{
    // instance variables
    private String homeInstitution;
    
    /**
     * This constructor initializes the fields to the passed values.
     * @param first Student's first name.
     * @param last Student's last name.
     * @param id Student's ID.
     * @param admDate Student's admission date.
     * @param studentMajor Student's major.
     * @param courses Student's list of courses taken.
     * @param homeInst The name of the student's home institution.
     */
    public TransientStudent(String first, String last, int id, String admDate, String studentMajor, 
                            ArrayList<CourseGrade> courses, String homeInst)
    {
        super(first, last, id, admDate, studentMajor, courses);
        homeInstitution = homeInst;
    }
    
    /**
     * This is a copy constructor. It initializes the fields of the object being created to the same
     * values as the fields in the object passed as an argument.
     * @param transientStdntObj The object being copied.
     */
    public TransientStudent(TransientStudent transientStdntObj)
    {
        super(transientStdntObj);
        if( transientStdntObj != null )
            homeInstitution = transientStdntObj.homeInstitution;
    }
    
    /**
     * The getHomeInstitution method returns a Transient Student's home institution name.
     * @return The value in the homeInstitution field.
     */
    public String getHomeInstitution()
    {
        return homeInstitution;
    }
    
    /**
     * The setHomeInstitution method stores a value in the homeInstitution field.
     * @param schoolName the value to store in homeInstitution.
     */
    public void setHomeInstitution(String schoolName)
    {
        homeInstitution = schoolName;
    }
    
    /**
     * The toString method returns a string representing the state of a Transient Student object.
     * @return A string containing the student's information: first name, last name, id,  
     * date of admission, major, list of courses taken, and home institution name.
     */  
    @Override
    public String toString()
    {
        return super.toString() + String.format("\n%-30s %s", 
                                  "Home Institution:", homeInstitution);

    }
    
}
