package managerStudent;

import managerStudent.Service.StudentService;

public class Run {

    public static void main(String[] args) {
        StudentService studentService=new StudentService();
        studentService.addStudent("NamHung", "11a11", "tot",10, 7, 1, "Toan", 7,5,4, "Di hoc tre", "khong mang giay","ngu trong lop");

    }
}