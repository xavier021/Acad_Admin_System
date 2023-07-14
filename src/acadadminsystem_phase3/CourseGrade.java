package acadadminsystem_phase3;


public class CourseGrade implements Comparable<CourseGrade>
{
    // instance variables
    private Course courseTaken;
    private String letterGrade;
    
    /**
     * This constructor initializes the fields to the passed values.
     * @param course Course number.
     * @param grade Grade received.
     * @exception IllegalArgumentException When the grade is not A, B, C, D, or F.
     */
    public CourseGrade(Course course, String grade)
    {
        courseTaken = new Course(course);
        
        if( isValidGrade(grade) )
            letterGrade = grade.toUpperCase();
        else
            throw new IllegalArgumentException("Invalid value for the letter grade.");
    }
    
    /**
     * This is a copy constructor. It initializes the fields of the object being created to the same
     * values as the fields in the object passed as an argument.
     * @param courseGradeObj The object being copied.
     */
    public CourseGrade(CourseGrade courseGradeObj)
    {
        if( courseGradeObj != null )
        {
            courseTaken = new Course(courseGradeObj.courseTaken);
            letterGrade = courseGradeObj.letterGrade;
        }
    }
    
    /**
     * The getCourseTaken method returns the course that the student has taken.
     * @return A copy of the course object.
     */
    public Course getCourseTaken()
    {
        return new Course(courseTaken);
    }
    
    /**
     * The getLetterGrade method returns the grade received for a course.
     * @return The value in the letterGrade field.
     */
    public String getLetterGrade()
    {
        return letterGrade;
    }
    
    /**
     * The setCourseTaken method stores a value in the courseTaken field.
     * @param course the new Course object to store in courseTaken.
     */ 
    public void setCourseTaken(Course course)
    {
        courseTaken = new Course(course);
    }
    
    /**
     * The setLetterGrade method stores a value in the letterGrade field.
     * @param grade the value to store in letterGrade.
     * @exception IllegalArgumentException When the grade is not A, B, C, D, or F.
     */
    public void setLetterGrade(String grade)
    {
        if( isValidGrade(grade) )
            letterGrade = grade.toUpperCase();
        else
            throw new IllegalArgumentException("Invalid value for the letter grade.");
    }
     
    /**
     * The toString method returns a string representing the state of a CourseGrade object.
     * @return A string containing the information for the course that has been taken: course info, 
     * and grade received.
     */  
    @Override
    public String toString()
    {
        return String.format("%s \n%-30s %s", 
                             courseTaken,
                             "Grade Received:", letterGrade);
    }
    
    /**
     * The equals method compares two CourseGrade objects. The result is true if the argument 
     * is not null and is a CourseGrade object with the same course and grade as the calling 
     * object.
     * @param obj The object to compare this CourseGrade with.
     * @return true if the given object has the same value for the courseTaken and letterGrade 
     * fields.
     */
    @Override
    public boolean equals(Object obj) 
    {
        // check that the type of the parameter is CourseGrade
        if( !(obj instanceof CourseGrade) )
            return false;
        
        // we already know that obj is of type CourseGrade, so it's safe to cast
        CourseGrade courseGradeObj = (CourseGrade) obj;
        
        // return true or false depending on whether courseTaken and letterGrade have the same value
        return courseGradeObj.courseTaken.equals(this.courseTaken) 
               && courseGradeObj.letterGrade.equals(this.letterGrade);     
    }
 
    private boolean isValidGrade(String grade)
    {
        // return true if grade is A, B, C, D, or F.
        switch( grade.toUpperCase() )
        {
            case "A":
            case "B":
            case "C":
            case "D":
            case "F":
                return true;
            default:
                return false;
        }
        
        /* The following solution provided by a student would be another way of doing it. */
        /* return ("ABCDF".contains(grade.toUpperCase())); */
    }
    
    /**
     * The compareTo method compares the CourseGrade object calling this method with the
     * CourseGrade object passed as an argument to see which one has a greater value.
     * @param courseGrade The CourseGrade object to compare with.
     * @return 0 if both objects have the same value for the courseTaken instance variable. 
     * A positive number if the calling object has a greater value.
     * A negative number if the calling object has a smaller value.
     */
    @Override
    public int compareTo(CourseGrade courseGrade)
    {
        return courseTaken.compareTo(courseGrade.courseTaken);      
    }
}
