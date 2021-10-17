package registration;

import enums.Building;
import enums.Quarter;
import enums.SubjectCode;
import person.Faculty;

/**
 * <p>The <strong>Section</strong> class holds information about a course section.</p>
 * <ul>
 * <li><strong>course:</strong> course associated with the section</li>
 * <li><strong>section:</strong> section number for the course</li>
 * <li><strong>instructor:</strong> instructor for the section (assume single instructor)</li>
 * <li><strong>term:</strong> quarter and year when the section is offered (see Quarter enum)</li>
 * <li><strong>capacity:</strong> capacity for the section</li>
 * <li><strong>location:</strong> building and room where the section is held (see Building enum)</li>
 * </ul>
 * <p>For example, <strong>CPSC 5011-02: Object-Oriented Concepts</strong>
 * <ul>
 * <li><strong>course:</strong> CPSC 5011</li>
 * <li><strong>section:</strong> 02</li>
 * <li><strong>instructor:</strong> Sheila Oh</li>
 * <li><strong>term (quarter/year):</strong> FQ18</li>
 * <li><strong>capacity:</strong> 30</li>
 * <li><strong>location (building/room):</strong> LEML 122</li>
 * </ul>
 * 
 * @author 
 */
public class Section {

    // TODO: add Section fields including:
    // - course
    // - section
    // - instructor
    // - term (see Quarter)
    // - capacity
    // - location (see Building)
    private SubjectCode subjectCode;
    private Course course;
    private int section;
    private Faculty person;
    private Quarter quarter;
    private int year;
    private int cap;
    private Building building;
    private int roomNumber;


    
    /**
     * 
     * @param course     The course associated with the section
     * @param section    The section number for the course
     * @param instructor The faculty instructor teaching the course
     * @param quarter    The quarter that the course section is held 
     * @param year       The year that the course section is held
     * @param cap        The capacity of the course section
     * @param bldg       The building that the course section is held
     * @param room       The room that the course section is held
     */
    public Section(Course course, int section, Faculty instructor,
                   Quarter quarter, int year, int cap, Building bldg,
                   int room) {
        this.course = course;
        this.section = section;
        this.person = instructor;
        this.quarter = quarter;
        this.year = year;
        this.cap = cap;
        this.building = bldg;
        this.roomNumber = room;
        // TODO: implement Section constructor
    }

    public void setQuarter(Quarter quarter) {
        this.quarter = quarter;
    }

    public Quarter getQuarter() {
        return quarter;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Building getBuilding() {
        return building;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }

    public int getCap() {
        return cap;
    }

    public void setPerson(Faculty person) {
        this.person = person;
    }

    public Faculty getPerson() {
        return person;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public int getSection() {
        return section;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public SubjectCode getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(SubjectCode subjectCode) {
        this.subjectCode = subjectCode;
    }
}
