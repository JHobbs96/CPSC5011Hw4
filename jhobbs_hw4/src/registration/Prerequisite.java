package registration;

import enums.SubjectCode;

public class Prerequisite {

    private SubjectCode subjectCode;
    private String name;
    private int number;
    private SubjectCode prerequisiteCode;
    private int prerequisiteNumber;

    public Prerequisite(SubjectCode code, int num, SubjectCode prereqCode,
                        int prereqNumber){
        this.subjectCode = code;
        this.number = num;
        this.prerequisiteCode = prereqCode;
        this.prerequisiteNumber = prereqNumber;
    }

    public void setSubjectCode(SubjectCode subjectCode) {
        this.subjectCode = subjectCode;
    }

    public SubjectCode getSubjectCode() {
        return subjectCode;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setPrerequisiteCode(SubjectCode prerequisiteCode) {
        this.prerequisiteCode = prerequisiteCode;
    }

    public SubjectCode getPrerequisiteCode() {
        return prerequisiteCode;
    }

    public void setPrerequisiteNumber(int prerequisiteNumber) {
        this.prerequisiteNumber = prerequisiteNumber;
    }

    public int getPrerequisiteNumber() {
        return prerequisiteNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
