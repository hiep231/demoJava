package demo_oop_01;

public   class Student {
    private String studentCode;
    private String studentName;

    public Student() {
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentCode='" + studentCode + '\'' +
                ", studentName='" + studentName + '\'' +
                '}';
    }
}
