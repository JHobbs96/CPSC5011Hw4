package registration;

import enums.SubjectCode;

import java.util.ArrayList;

/**
 * <p>The <strong>Course</strong> class holds information about a course.</p>
 * <ul>
 * <li><strong>subject code:</strong> subject code of the course (see SubjectCode enum)</li>
 * <li><strong>course number:</strong> course number</li>
 * <li><strong>course name:</strong> course name</li>
 * <li><strong>credit number:</strong> number of credits associated with the course</li>
 * <li><strong>prerequisites:</strong> courses that are prerequisites of this course; may
 *   have multiple or none</li>
 * </ul>
 * <p>For example, <strong>CPSC 5011: Object-Oriented Concepts</strong></p>
 * <ul>
 * <li><strong>subject code:</strong> CPSC</li>
 * <li><strong>course number:</strong> 5011</li>
 * <li><strong>course name:</strong> Object-Oriented Concepts</li>
 * <li><strong>credit number:</strong> 3</li>
 * <li><strong>prerequisite(s):</strong> CPSC 5003</li>
 * </ul>
 * 
 * @author 
 */
public class Course {

    private SubjectCode subjectCode;
    private int courseNumber;
    private String courseName;
    private int creditNumber;
    private ArrayList<Prerequisite> prerequisites;
    
    /**
     * 
     * @param code      The subject code of the course
     * @param courseNum The course number of the course
     * @param name      The course name
     * @param creditNum The number of the credits of the course
     */
    public Course(SubjectCode code, int courseNum, String name, 
                    int creditNum) {
        this.courseName = name;
        this.courseNumber = courseNum;
        this.subjectCode = code;
        this.creditNumber = creditNum;
        prerequisites = new ArrayList<Prerequisite>();
        // TODO: implement Course constructor
    }

    public SubjectCode getSubjectCode(){
        return subjectCode;
    }

    public void setSubjectCode(SubjectCode subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String printPrerequisites() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < prerequisites.size(); i++) {
            sb.append("Name= "+prerequisites.get(i).getSubjectCode() +" "+
                    prerequisites.get(i).getNumber()+" " +
                    prerequisites.get(i).getName() +" ");
        }
        return sb.toString();
    }

    public void addPrerequisites(Prerequisite prerequisite) {
        prerequisites.add(prerequisite);
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public int getCreditNumber() {
        return creditNumber;
    }

    public void setCreditNumber(int creditNumber) {
        this.creditNumber = creditNumber;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }


}

    // TODO: add Course fields
    // - subject code (see SubjectCode)
    // - course number
    // - course name
    // - credit number
    // - a collection of prerequisite course(s)


