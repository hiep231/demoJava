package managerStudent.Service;

import managerStudent.Model.Student;

interface StudentServiceInterface {
    String addStudent(String name, String inclass, String conduct, int rank, int point, int serial,String subject, int pointx1, int pointx2, int pointx3,String fault, String transgressDay,String transgressSubject);
    String removeStudent(int serial);
}

public class StudentService implements StudentServiceInterface {

    @Override
    public String addStudent(String name, String inclass, String conduct, int rank, int point, int serial, String subject, int pointx1, int pointx2, int pointx3, String fault, String transgressDay, String transgressSubject) {
        // TODO Auto-generated method stub

        PointService pointService = new PointService();
        TransgressService transgressService = new TransgressService();

        Student student = new Student();
        student.setName(name);
        student.setInclass(inclass);
        student.setConduct(conduct);
        student.setRank(rank);
        student.setSerial(serial);

        student.setPoint(pointService.addPoint(subject, pointx1, pointx2, pointx3));
        student.setTransgress(transgressService.addTransgress(fault, transgressDay, transgressSubject));
        System.out.println(student);
        return "succesful";
    }

    @Override
    public String removeStudent(int serial) {
        // TODO Auto-generated method stub
        return null;
    }
}