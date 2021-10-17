package person;

import enums.Building;
import enums.FacultyType;
import enums.PersonStatus;

/**
 * <p>The <strong>Faculty</strong> class holds information about a faculty member.</p>
 * <ul>
 * <li><strong>first name:</strong> first name of the faculty</li>
 * <li><strong>last name:</strong> last name of the faculty</li>
 * <li><strong>suid:</strong> SeattleU identification number</li>
 * <li><strong>status:</strong> the status of the faculty (see PersonStatus enum)</li>
 * <li><strong>faculty type:</strong> the type of faculty (see FacultyType enum)</li>
 * <li><strong>office:</strong> includes building (i.e. ENGR) and room number (i.e 504)</li>
 * <li><strong>email:</strong> the school (i.e. SU) email address</li>
 * </ul>
 * <p>For example, faculty <strong>Sheila Oh</strong></p>
 * <ul>
 * <li><strong>first name:</strong> Sheila</li>
 * <li><strong>last name:</strong> Oh</li>
 * <li><strong>suid:</strong> 100013</li>
 * <li><strong>status:</strong> ACTIVE</li>
 * <li><strong>faculty type:</strong> SEN_INSTRUCT</li>
 * <li><strong>office (building/room):</strong> ENGR 504</li>
 * <li><strong>email:</strong> ohsh@seattleu.edu</li>
 * </ul>
 * 
 * @author 
 */
public class Faculty {


    // TODO: add Faculty fields
    private String firstName;
    private String lastName;
    private int SUID;
    private PersonStatus personStatus;
    private FacultyType facultyType;
    private Building building;
    private String email;
    private int roomNumber;
    // - first name
    // - last name
    // - SUID
    // - status (see PersonStatus)
    // - faculty type (see FacultyType)
    // - office (see Building)
    // - email

    /**
     * 
     * @param firstName   The first name of the faculty
     * @param lastName    The last name of the faculty
     */
    public Faculty(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        // TODO: implement Faculty constructor
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Building getBuilding() {
        return building;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPersonStatus(PersonStatus personStatus) {
        this.personStatus = personStatus;
    }

    public PersonStatus getPersonStatus() {
        return personStatus;
    }

    public void setSUID(int SUID) {
        this.SUID = SUID;
    }

    public int getSUID() {
        return SUID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public FacultyType getFacultyType() {
        return facultyType;
    }

    public void setFacultyType(FacultyType facultyType) {
        this.facultyType = facultyType;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
}
