package acadadminsystem_phase3;


public abstract class Person implements Comparable<Person>
{
    // instance variables
    private String firstName;
    private String lastName;
        
    /**
     * This constructor initializes the fields to the passed values.
     * @param first Person's first name.
     * @param last Person's last name.
     */
    public Person(String first, String last)
    {
        firstName = first;
        lastName = last;
    }
    
    /**
     * This is a copy constructor. It initializes the fields of the object being created to the same
     * values as the fields in the object passed as an argument.
     * @param personObject The object being copied.
     */
    public Person(Person personObject)
    {
        if( personObject != null )
        {
            firstName = personObject.firstName;
            lastName = personObject.lastName;
        }
    }
    
    /**
     * The getFirstName method returns a Person object's first name.
     * @return The value in the firstName field.
     */
    public String getFirstName()
    {
        return firstName;
    }
    
    /**
     * The getLastName method returns a Person object's last name.
     * @return The value in the lastName field.
     */
    public String getLastName()
    {
        return lastName;
    }
    
    /**
     * The setFirstName method stores a value in the firstName field.
     * @param first the value to store in firstName.
     */
    public void setFirstName(String first)
    {
        firstName = first;
    }
    
    /**
     * The setLastName method stores a value in the lastName field.
     * @param last the value to store in lastName.
     */
    public void setLastName(String last)
    {
        lastName = last;
    }
    
    /**
     * The toString method returns a string representing the state of a Person object.
     * @return A string containing the person information: first name and last name.
     */    
    @Override
    public String toString()
    {
        return String.format("\n%-30s %s \n%-30s %s", "First Name:", firstName, 
                                                      "Last Name:", lastName);
    }
    
    /**
     * The equals method compares two Person objects. The result is true if the argument 
     * is not null and is a Person object with the same values for all fields as this object.
     * @param obj The object to compare this Person with.
     * @return true if the given object has the same value for all fields.
     */
    @Override
    public boolean equals(Object obj)
    {
        if( !(obj instanceof Person))
            return false;
        
        // we already know that obj is of type Person, so it's safe to cast
        Person personObject = (Person) obj;
        
        // return true or false depending on whether firstName and lastName have the same value
        return firstName.equals(personObject.firstName) 
               && lastName.equals(personObject.lastName);
    }
    
    /**
     * The compareTo method compares the Person object calling this method with the Person object
     * passed as an argument to see which one has a greater value.
     * @param person The Person object to compare with.
     * @return 0 if both objects have the same value for the firstName and lastName instance
     * variables. 
     * A positive number if the calling object has a greater last name or both objects have the 
     * same last name but the calling object has a greater first name.
     * A negative number if the calling object has a lesser last name or both objects have the
     * same last name but the calling object has a lesser first name.
     */
    @Override
    public int compareTo(Person person)
    {
        // compare the last names
        int result = this.lastName.compareTo(person.lastName);
        
        if( result == 0 )
        {
            // if the last names are the same, compare the first names
            result = this.firstName.compareTo(person.firstName);
        }
        
        return result;
        
        /* The following solution provided by a student would be another way of doing it. */
        /* 
        int result = lastName.compareTo(person.lastName);
        return result==0? firstName.compareTo(person.firstName):result;
        */
    }
}