package person;

import enums.*;

/**
 * <p>The <strong>Student</strong> class holds information about a student.</p>
 * <ul>
 * <li><strong>first name:</strong> first name of the student</li>
 * <li><strong>last name:</strong> last name of the student</li>
 * <li><strong>suid:</strong> Seattle U identification number</li>
 * <li><strong>status:</strong> the status of the student (see PersonStatus enum)</li>
 * <li><strong>student type:</strong> a student can only be assigned a single student type
 *   (see StudentType enum)</li>
 * <li><strong>student program:</strong> a student can only be assigned to a single program at 
 *   a point of time, but can switch from one program to another (i.e. when 
 *   they've graduated from a program (see StudentProgram enum)</li>
 * <li><strong>student year:</strong> only relevant for undergraduates (see StudentYear enum)</li>
 * <li><strong>start term:</strong> associated with the quarter and year a student starts a
 *   particular program; for example, a single student may start the CERT in 
 *   RQ17 and then continue the MSCS in FQ18 (see Quarter enum)</li>
 * <li><strong>faculty advisor:</strong> students are assigned a faculty advisor, but may switch 
 *   advisors (i.e. faculty leaves or on sabbatical); may not be assigned an
 *   advisor for a period of time when first enrolled as a student</li>
 * <li><strong>email:</strong> the school (i.e. SU) email address</li>
 * </ul>
 * <p>For example, student <strong>Ada Lovelace</strong></p>
 * <ul>
 * <li><strong>first name:</strong> Ada</li>
 * <li><strong>last name:</strong> Lovelace</li>
 * <li><strong>suid:</strong> 100027</li>
 * <li><strong>status:</strong> ACTIVE</li>
 * <li><strong>student type:</strong> GRAD</li>
 * <li><strong>student program:</strong> CERT</li>
 * <li><strong>student year:</strong> </li>
 * <li><strong>start term:</strong> FQ 2018</li>
 * <li><strong>faculty advisor:</strong> Lin Li</li>
 * <li><strong>email:</strong> adalovelace@seattleu.edu</li>
 * </ul>
 * <p>And student <strong>Buster Bluth</strong></p>
 * <ul>
 * <li><strong>first name:</strong> Buster</li>
 * <li><strong>last name:</strong> Bluth</li>
 * <li><strong>suid:</strong> 100020</li>
 * <li><strong>status:</strong> ACTIVE</li>
 * <li><strong>student type:</strong> UNDERGRAD</li>
 * <li><strong>student program:</strong> BSCS</li>
 * <li><strong>student year:</strong> SOPHOMORE</li>
 * <li><strong>start term:</strong> WQ 2018</li>
 * <li><strong>faculty advisor:</strong> Roshanak Roshandel</li>
 * <li><strong>email:</strong> busterbluth@seattleu.edu</li>
 * </ul>
 * 
 * @author 
 */
public class Student {

    private String firstName;
    private String lastName;
    private int SUID;
    private PersonStatus personStatus;
    private StudentType studentType;
    private StudentProgram studentProgram;
    private StudentYear studentYear;
    private int startTerm;
    private Quarter quarter;
    private Faculty facultyAdvisor;
    private String email;



    /**
     * 
     * @param firstName   The first name of the student
     * @param lastName    The last name of the student
     */
    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = this.createEmail(this);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSUID() {
        return SUID;
    }

    public void setSUID(int SUID) {
        this.SUID = SUID;
    }

    public Faculty getFacultyAdvisor() {
        return facultyAdvisor;
    }

    public void setFacultyAdvisor(Faculty facultyAdvisor) {
        this.facultyAdvisor = facultyAdvisor;
    }

    public PersonStatus getPersonStatus() {
        return personStatus;
    }

    public void setPersonStatus(PersonStatus personStatus) {
        this.personStatus = personStatus;
    }

    public Quarter getQuarter() {
        return quarter;
    }

    public void setQuarter(Quarter quarter) {
        this.quarter = quarter;
    }

    public StudentProgram getStudentProgram() {
        return studentProgram;
    }

    public void setStudentProgram(StudentProgram studentProgram) {
        this.studentProgram = studentProgram;
    }

    public StudentType getStudentType() {
        return studentType;
    }

    public void setStudentType(StudentType studentType) {
        this.studentType = studentType;
    }

    public StudentYear getStudentYear() {
        return studentYear;
    }

    public void setStudentYear(StudentYear studentYear) {
        this.studentYear = studentYear;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStartTerm() {
        return startTerm;
    }

    public void setStartTerm(int startTerm) {
        this.startTerm = startTerm;
    }

    private String createEmail(Student student){
        StringBuilder sb = new StringBuilder();
        sb.append(student.firstName);
        sb.append(student.lastName);
        sb.append("@seattleu.edu");
        sb.toString().toLowerCase();
        return sb.toString();
    }

    // TODO: add Student fields
    // - first name
    // - last name
    // - SUID
    // - status (see PersonStatus)
    // - student type (see StudentType)
    // - student program (see StudentProgram)
    // - student year (see StudentYear; only if undergrad––default to freshman)
    // - start term (see Quarter)
    // - faculty advisor
    // - email

}
