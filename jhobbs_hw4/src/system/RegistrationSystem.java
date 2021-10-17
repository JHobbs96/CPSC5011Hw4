package system;

import enums.*;
import exception.CourseNotFoundException;
import exception.DuplicateCourseException;
import exception.DuplicatePersonException;
import exception.DuplicateSubjectException;
import exception.PersonNotFoundException;
import exception.DuplicateSectionException;
import person.Faculty;
import person.Student;
import registration.Course;
import registration.Prerequisite;
import registration.Section;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;

/**
 * <p>The <strong>RegistrationSystem</strong> class stores information about the school, 
 * including the ability to add students, add faculty, add courses, and add prerequisite(s).</p>
 * 
 * @author ohsh
 */
public class RegistrationSystem {
    private int SUID = 10000;
    // TODO: add RegistrationSystem collections
    // - student list
    private ArrayList<Student> students;
    // - faculty list
    private ArrayList<Faculty> faculties;
    // - subject list
    private HashMap<SubjectCode,String> subject;
    // = course list
    private ArrayList<Course> courses;
    // - section list
    private ArrayList<Section> sections;
    //
    // Note -- there is no list for prerequisites - these should be included
    // as part of the course list

    /**
     * 
     */
    public RegistrationSystem() { 
        students = new ArrayList<Student>();
        faculties = new ArrayList<Faculty>();
        subject = new HashMap<SubjectCode, String>();
        courses = new ArrayList<Course>();
        sections = new ArrayList<Section>();
        // TODO: implement RegistrationSystem constructor
    
    }
    
    /**
     * Add a student to the student list collection.
     * 
     * @param firstName  The first name of the student
     * @param lastName   The last name of the student
     * @param type       The student type
     * @param program    The student program    
     * @param quarter    The start quarter of the student
     * @param year       The start year of the student
     * @throws DuplicatePersonException The person is already in the system
     */
    public void addStudent(String firstName, String lastName, 
                            StudentType type, StudentProgram program,
                            Quarter quarter, int year) 
                            throws DuplicatePersonException {
        Student newStudent = new Student(firstName, lastName);
        newStudent.setStudentType(type);
        newStudent.setStudentProgram(program);
        newStudent.setQuarter(quarter);
        newStudent.setStartTerm(year);
        newStudent.setSUID(SUID);
        newStudent.setPersonStatus(PersonStatus.ACTIVE);
        newStudent.setFacultyAdvisor(pickRandomAdvisor());
        if (newStudent.getStudentType().equals(StudentType.UNDERGRAD)){
            newStudent.setStudentYear(getCurrentYear(newStudent));
        }
        if (checkDuplicateStudent(newStudent)) {
            students.add(newStudent);
            SUID += 1;
        }
    }

    
    /**
     * Add a faculty to the faculty list collection.
     * 
     * @param firstName   The first name of the faculty
     * @param lastName    The last name of the faculty
     * @param type        The faculty type
     * @param bldg        The building of the faculty office
     * @param room        The (building) room of the faculty office
     * @param email       The email of the faculty
     * @throws DuplicatePersonException The person is already in the system
     */
    public void addFaculty(String firstName, String lastName,
                            FacultyType type, Building bldg, int room, String email) 
                            throws DuplicatePersonException {
        Faculty faculty = new Faculty(firstName, lastName);
        faculty.setFacultyType(type);
        faculty.setBuilding(bldg);
        faculty.setRoomNumber(room);
        faculty.setEmail(email);
        faculty.setSUID(SUID);
        faculty.setPersonStatus(PersonStatus.ACTIVE);
        if(checkDuplicateFaculty(faculty)){
            faculties.add(faculty);
            SUID += 1;
        }
        
        // TODO: implement addFaculty method
    
    }
    
    /**
     * Adds a subject to the subject list collection.
     * (hint: use a Map instead of creating a class)
     * 
     * @param code    The subject code
     * @param desc    The subject description
     * 
     * @throws DuplicateSubjectException The subject is already in the system
     */
    public void addSubject(SubjectCode code, String desc) 
                            throws DuplicateSubjectException {
        for(var item : subject.entrySet()){
            if(item.equals(desc)){
                throw new DuplicateSubjectException("The subject is already" +
                        "in the system.");
            }
        }
        subject.put(code,desc);
        // TODO: implement addSubject method
    
    }
    
    /**
     * Adds a course to the course list collection.
     * 
     * @param code       The subject code of the course
     * @param num        The course number of the course
     * @param name       The course name
     * @param creditNum  The number of the credits of the course
     * @throws DuplicateCourseException    The course is already in the system 
     */
    public void addCourse(SubjectCode code, int num, String name, 
                            int creditNum) throws DuplicateCourseException{
        Course course = new Course(code, num, name, creditNum);
        if(checkDuplicateCourse(course)){
            courses.add(course);
        }
        
        // TODO: implement addCourse method
    
    }
    
    /**
     * Adds a prerequisite to an existing course in the course
     * list collection.
     * 
     * @param code          The subject code of the course
     * @param num           The course number of the course
     * @param prereqCode    The subject code of the prerequisite
     *                      to add to the course
     * @param prereqNum     The course number of the prerequisite
     *                      to add to the course
     * @throws CourseNotFoundException The course was not found in the system
     */
    public void addPrerequisite(SubjectCode code, int num, 
                            SubjectCode prereqCode, int prereqNum) 
                            throws CourseNotFoundException {
        for(int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseNumber() == num) {
                Prerequisite prerequisite = new Prerequisite(code, prereqNum,
                        prereqCode, num);
                prerequisite.setName(getCourseName(prereqNum));
                courses.get(i).addPrerequisites(prerequisite);
                return;
            }
        }
        throw new CourseNotFoundException("The course was not found in the " +
                "system.");
        // TODO: implement addPrerequisite method
    
    }
    
    /**
     * Adds a section to the section list collection.
     * 
     * @param code       The subject code of the course
     * @param courseNum  The course number of the course
     * @param sectionNum The section number for the course
     * @param firstName  The first name for the faculty teaching the course
     * @param lastName   The last name for the faculty teaching the course
     * @param quarter    The quarter that the course section is held 
     * @param year       The year that the course section is held
     * @param cap        The capacity of the course section
     * @param bldg       The building that the course section is held
     * @param room       The room that the course section is held
     * @throws CourseNotFoundException   The course was not found in the system
     * @throws PersonNotFoundException   The person was not found in the system
     * @throws DuplicateSectionException The section is already in the system
     */
    public void addSection(SubjectCode code, int courseNum, int sectionNum,
                            String firstName, String lastName, Quarter quarter, int year, 
                            int cap, Building bldg, int room) 
                            throws CourseNotFoundException, PersonNotFoundException, DuplicateSectionException {
        Course course = new Course(code,courseNum,getCourseName(courseNum),
                getCourse(courseNum).getCreditNumber());
        if(course.equals(null)){
            throw new CourseNotFoundException("The course was not found" +
                    "in the system");
        }
        Faculty faculty = getFaculty(firstName, lastName);
        if(faculty == null){
            throw new PersonNotFoundException("The person was not found in" +
                    "the system");
        }
        Section section = new Section(course,courseNum,
                faculty,quarter,year,cap,bldg,room);
        section.setSection(sectionNum);
        section.setSubjectCode(code);
        if(checkDuplicateSection(section)){
            sections.add(section);
        }
        // TODO: implement addSection method
    
    }

    private boolean checkDuplicateStudent(Student student)
            throws DuplicatePersonException {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getFirstName().
                    equals(student.getFirstName()) &&
                    students.get(i).getStudentType().
                            equals(student.getStudentType()) &&
                    students.get(i).getStudentProgram().
                            equals(student.getStudentProgram()) &&
                    students.get(i).getQuarter().
                            equals(student.getQuarter()) &&
                    students.get(i).getStudentYear()
                            == student.getStudentYear()) {
                throw new DuplicatePersonException("This person exists already" +
                        "in the system.");
            }
        }
            return true;
    }

    private boolean checkDuplicateFaculty(Faculty faculty)
            throws DuplicatePersonException {
        for (int i = 0; i < faculties.size(); i++) {
            if (faculties.get(i).getFirstName().
                    equals(faculty.getFirstName()) &&
                    faculties.get(i).getFacultyType().
                            equals(faculty.getFacultyType()) &&
                    faculties.get(i).getBuilding().
                            equals(faculty.getBuilding()) &&
                    faculties.get(i).getEmail().
                            equals(faculty.getEmail()) &&
                    faculties.get(i).getSUID()
                            == faculty.getSUID()) {
                throw new DuplicatePersonException("This person exists already" +
                        "in the system.");
            }
        }
        return true;
    }

    private boolean checkDuplicateCourse(Course course)
            throws DuplicateCourseException {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseName().
                    equals(course.getCourseName()) &&
                    courses.get(i).getCourseNumber() ==
                            course.getCourseNumber() &&
                    courses.get(i).getCreditNumber() ==
                            course.getCreditNumber() &&
                    courses.get(i).getSubjectCode().
                            equals(course.getSubjectCode())) {
                throw new DuplicateCourseException("This course exists already"+
                        "in the system.");
            }
        }
            return true;
    }

    private boolean checkDuplicateSection(Section section) throws DuplicateSectionException {
        for(int i = 0; i < sections.size(); i++){
            if(sections.get(i).getCourse().
                    equals(section.getCourse()) &&
                    sections.get(i).getSection() == section.getSection() &&
                    sections.get(i).getCap() == section.getCap() &&
                    sections.get(i).getPerson().equals(section.getPerson()) &&
                    sections.get(i).getSubjectCode()
                            .equals(section.getSubjectCode()) &&
                    sections.get(i).getBuilding()
                            .equals(section.getBuilding()) &&
                    sections.get(i).getYear() == section.getYear()){
                throw new DuplicateSectionException("The section is already" +
                        "in the system");
            }
        }
        return true;
    }

    private StudentYear getCurrentYear(Student student) {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int value = year - student.getStartTerm();
        if (value == 4){
            return  StudentYear.SENIOR;
        }
        else if(value == 3){
            return  StudentYear.JUNIOR;
        }
        else if(value == 2){
            return  StudentYear.SOPHOMORE;
        }
        else{
            return StudentYear.FRESHMAN;
        }
    }

    private String getCourseName(int num){
        for(int i = 0; i < courses.size(); i++){
            if(courses.get(i).getCourseNumber() == num){
                return courses.get(i).getCourseName();
            }
        }
        return null;
    }

    private Course getCourse(int num){
        for(int i = 0; i < courses.size(); i++){
            if(courses.get(i).getCourseNumber() == num){
                return courses.get(i);
            }
        }
        return null;
    }

    private Faculty getFaculty(String firstName, String lastName){
        for(int i = 0; i < faculties.size(); i++){
            if(faculties.get(i).getFirstName().equals(firstName) &&
                    faculties.get(i).getLastName().equals(lastName)){
                return faculties.get(i);
            }
        }
        return null;
    }

    private Faculty pickRandomAdvisor(){
        Random rand = new Random();
        int j = rand.nextInt(faculties.size());
        Faculty advisor = faculties.get(j);
        return advisor;
    }


    public void printFaculty(){
        for(int i = 0; i < faculties.size(); i++){
            System.out.println("Faculty: Name=" +
                    faculties.get(i).getFirstName() +" "+
                    faculties.get(i).getLastName()+
                    ", SUID=" + faculties.get(i).getSUID() +", Email= " +
                    faculties.get(i).getEmail() +", STATUS= " +
                    faculties.get(i).getPersonStatus() +", Type= " +
                    faculties.get(i).getFacultyType() +
                    ", Office: " + faculties.get(i).getBuilding() + " " +
                    faculties.get(i).getRoomNumber());
        }
    }

    public void printStudents() {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentType()
                    .equals(StudentType.UNDERGRAD)) {
                System.out.println("Student: Name= " +
                        students.get(i).getFirstName() + " " +
                        students.get(i).getLastName() + ", SUID =" +
                        students.get(i).getSUID() + ", Email=" +
                        students.get(i).getEmail().toLowerCase() +
                        ", Status= " +
                        students.get(i).getPersonStatus() +", Program="+
                        students.get(i).getStudentProgram()+ ", Type=" +
                        students.get(i).getStudentType() + ", Term= " +
                        students.get(i).getQuarter() +" "+
                        students.get(i).getStartTerm()+ ", Advisor= " +
                        students.get(i).getFacultyAdvisor().getFirstName() +" "+
                        students.get(i).getFacultyAdvisor().getLastName() + " "+
                        students.get(i).getStartTerm() + ", Year= " +
                        students.get(i).getStudentYear());
            } else {
                System.out.println("Student: Name= " +
                        students.get(i).getFirstName() + " " +
                        students.get(i).getLastName() + ", SUID =" +
                        students.get(i).getSUID() + ", Email=" +
                        students.get(i).getEmail().toLowerCase() +
                        ", Status= " +
                        students.get(i).getPersonStatus() + ", Type=" +
                        students.get(i).getPersonStatus() +", Program="+
                        students.get(i).getStudentType() + ", Term= " +
                        students.get(i).getQuarter() +" "+
                        students.get(i).getStartTerm() + ", Advisor= " +
                        students.get(i).getFacultyAdvisor().getFirstName() +" "+
                        students.get(i).getFacultyAdvisor().getLastName() + " "+
                        students.get(i).getQuarter() + " " +
                        students.get(i).getStartTerm());
            }
        }
    }

    public void printSubjects(){
        for(var item: subject.entrySet()){
            System.out.println("Subject: "+item.getKey()+ ", "+
                    item.getValue());
        }
    }

    public void printCourses() {
        for(int i = 0; i < courses.size(); i++) {
            System.out.println("Course: " + courses.get(i).getSubjectCode()+
                    "-"+courses.get(i).getCourseNumber()+ " "+
                    ": "+courses.get(i).getCourseName()+
                    " Credits =" + courses.get(i).getCreditNumber()+
                    " (Prerequisites: "+
                    courses.get(i).printPrerequisites()+")");
        }
    }

    public void printSections(){
        for(int i = 0; i < sections.size(); i++){
            System.out.println("Section: Name= " +
                    sections.get(i).getSubjectCode() + "-"+
                    sections.get(i).getCourse().getCourseNumber()+"-"+
                    sections.get(i).getSection()+": "+
                    sections.get(i).getCourse().getCourseName() +", Faculty="+
                    sections.get(i).getPerson().getFirstName() +" "+
                    sections.get(i).getPerson().getLastName() +", Term= "+
                    sections.get(i).getQuarter()+" "+
                    sections.get(i).getYear() +", Capacity="+
                    sections.get(i).getCap()+", Room="+
                    sections.get(i).getBuilding() + " "+
                    sections.get(i).getRoomNumber());
        }
    }

}
