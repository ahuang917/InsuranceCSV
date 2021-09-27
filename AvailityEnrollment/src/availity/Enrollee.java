package availity;
/**
 *  Enrollee class.
 *  
 *  @author Alan
 *  @version Sep 26, 2021
 */
public class Enrollee
{
    String userID;
    String lastName;
    String firstName;
    int version;
    String insurance;
    
    public Enrollee () {}

    /**
     * Create a new Enrollee object.
     * @param userID
     * @param lastName
     * @param firstName
     * @param version
     * @param insurance
     */
    public Enrollee(String userID, String firstName, String lastName, int version, String insurance)
    {
        super();
        this.userID = userID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.version = version;
        this.insurance = insurance;
    }

    /**
     * Get the current value of userID.
     * @return The value of userID for this object.
     */
    public String getUserID()
    {
        return userID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString()
    {
        return userID + "," + lastName + "," + firstName + "," + version + "," + insurance + "\n";
    }

    /**
     * Set the value of userID for this object.
     * @param userID The new value for userID.
     */
    public void setUserID(String userID)
    {
        this.userID = userID;
    }

    /**
     * Get the current value of lastName.
     * @return The value of lastName for this object.
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Set the value of lastName for this object.
     * @param lastName The new value for lastName.
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * Get the current value of firstName.
     * @return The value of firstName for this object.
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Set the value of firstName for this object.
     * @param firstName The new value for firstName.
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * Get the current value of version.
     * @return The value of version for this object.
     */
    public int getVersion()
    {
        return version;
    }

    /**
     * Set the value of version for this object.
     * @param version The new value for version.
     */
    public void setVersion(int version)
    {
        this.version = version;
    }

    /**
     * Get the current value of insurance.
     * @return The value of insurance for this object.
     */
    public String getInsurance()
    {
        return insurance;
    }

    /**
     * Set the value of insurance for this object.
     * @param insurance The new value for insurance.
     */
    public void setInsurance(String insurance)
    {
        this.insurance = insurance;
    };
    
    
}
