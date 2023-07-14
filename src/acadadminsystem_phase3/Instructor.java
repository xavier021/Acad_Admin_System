package acadadminsystem_phase3;

public class Instructor extends Person
{
    // instance variables
    private String officeHours;
    
    /**
     * This constructor initializes the fields to the passed values.
     * @param first Instructor's first name.
     * @param last Instructor's last name.
     * @param officeHrs Instructor's office hours.
     */
    public Instructor(String first, String last, String officeHrs)
    {
        super(first, last);
        
        officeHours = officeHrs;
    }
    
    /**
     * This is a copy constructor. It initializes the fields of the object being created to the same
     * values as the fields in the object passed as an argument.
     * @param instructorObject The object being copied.
     */
    public Instructor(Instructor instructorObject)
    {
        super(instructorObject);
        if( instructorObject != null )
            officeHours = instructorObject.officeHours;
    }
    
    /**
     * The getOfficeHours method returns an Instructor's office hours.
     * @return The value in the officeHours field.
     */
    public String getOfficeHours()
    {
        return officeHours;
    }
    
    /**
     * The setOfficeHours method stores a value in the officeHours field.
     * @param officeHrs the value to store in officeHours.
     */
    public void setOfficeHours(String officeHrs)
    {
        officeHours = officeHrs;
    }
    
    /**
     * The toString method returns a string representing the state of an Instructor object.
     * @return A string containing the instructor's information: first name, last name, and
     * office hours.
     */  
    @Override
    public String toString()
    {
        return super.toString() + String.format("\n%-30s %s", "Office Hours:", officeHours);
    }
    
    /**
     * The equals method compares two Instructor objects. The result is true if the argument 
     * is not null and is an Instructor object with the same values for all fields as the calling
     * object.
     * @param obj The object to compare this Instructor with.
     * @return true if the given object has the same value for all fields except the id.
     */
    @Override
    public boolean equals(Object obj)
    {
        if( !(obj instanceof Instructor))
            return false;
        
        // we already know that obj is of type Instructor, so it's safe to cast
        Instructor instructorObject = (Instructor) obj;
        
        // return true or false depending on whether firstName, lastName, and office hours have the 
        // same value.
        return super.equals(instructorObject) && officeHours.equals(instructorObject.officeHours);
    }
   
}
