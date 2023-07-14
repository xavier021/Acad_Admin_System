package acadadminsystem_phase3;


public class Course implements Comparable<Course>
{
    // instance variables
    private String courseNumber;
    private int numberOfCredits;
    private Instructor instructor;
    
    /**
     * This constructor initializes the fields to the passed values.
     * @param crsNumber The course number.
     * @param credits The number of credits for the course.
     * @param instr Instructor teaching the course.
     * @exception IllegalArgumentException When the number of credits is negative.
     */
    public Course(String crsNumber, int credits, Instructor instr)
    {
        courseNumber = crsNumber;
        
        if( credits >= 0 )
            numberOfCredits = credits;
        else
            throw new IllegalArgumentException("The number of credits for a course cannot be negative.");       
  
        instructor = new Instructor(instr);
    }
    
    /**
     * This is a copy constructor. It initializes the fields of the object being created to the same
     * values as the fields in the object passed as an argument.
     * @param courseObject The object being copied.
     */
    public Course(Course courseObject)
    {
        if( courseObject != null )
        {
            courseNumber = courseObject.courseNumber;
            numberOfCredits = courseObject.numberOfCredits;
            instructor = new Instructor(courseObject.instructor);
        }
    }
    
    /**
     * The getCourseNumber method returns a Course's number.
     * @return The value in the courseNumber field.
     */
    public String getCourseNumber()
    {
        return courseNumber;
    }
    
    /**
     * The getNumberOfCredits method returns a Course's number of credits.
     * @return The value in the numberOfCredits field.
     */
    public int getNumberOfCredits()
    {
        return numberOfCredits;
    }
    
    /**
     * The getInstructor method returns a Course's instructor.
     * @return The value in the instructor field.
     */
    public Instructor getInstructor()
    {
        return new Instructor(instructor);
    }
    
    /**
     * The setCourseNumber method stores a value in the courseNumber field.
     * @param crsNumber the value to store in courseNumber.
     */
    public void setCourseNumber(String crsNumber)
    {
        courseNumber = crsNumber;
    }
    
    /**
     * The setNumberOfCredits method stores a value in the numberOfCredits field.
     * @param credits the value to store in numberOfCredits.
     * @exception IllegalArgumentException When the number of credits is negative.
     */
    public void setNumberOfCredits(int credits)
    {
        if( credits >= 0 )
            numberOfCredits = credits;
        else
            throw new IllegalArgumentException("The number of credits for a course cannot be negative.");               
    }
    
    /**
     * The setInstructor method stores a value in the instructor field.
     * @param instr the value to store in instructor.
     */ 
    public void setInstructor(Instructor instr)
    {
        instructor = new Instructor(instr);
    }
    
    
    /**
     * The toString method returns a string representing the state of a Course object.
     * @return A string containing the course information: course number, number of credits, and
     * instructor teaching the course.
     */  
    @Override
    public String toString()
    {               
        String instructorInfo = instructor.getFirstName() + " " +
                                instructor.getLastName() + " (" +
                                instructor.getOfficeHours() + ")";
        return String.format("\n%-30s %s \n%-30s %s \n%-30s %s", 
                             "Course Number:", courseNumber,
                             "Number of Credits:", numberOfCredits,
                             "Taught by:", instructorInfo);
    }
    
    /**
     * The equals method compares two Course objects. The result is true if the argument 
     * is not null and is a Course object with the same courseNumber as the calling object.
     * @param obj The object to compare this Course with.
     * @return true if the given object has the same value for the courseNumber field.
     */
    @Override
    public boolean equals(Object obj) 
    {
        // check that the type of the parameter is Course
        if( !(obj instanceof Course) )
            return false;
        
        // we already know that obj is of type Course, so it's safe to cast
        Course courseObject = (Course) obj;
        
        // return true or false depending on whether courseNumber has the same value
        return this.courseNumber.equals(courseObject.courseNumber);     
    }
    
    /**
     * The compareTo method compares the Course object calling this method with the
     * Course object passed as an argument to see which one has a greater value.
     * @param course The Course object to compare with.
     * @return 0 if both objects have the same value for the courseNumber instance variable. 
     * A positive number if the calling object has a greater courseNumber.
     * A negative number if the calling object has a smaller courseNumber.
     */
    @Override
    public int compareTo(Course course)
    {
        return this.courseNumber.compareTo(course.courseNumber);
    }
}
