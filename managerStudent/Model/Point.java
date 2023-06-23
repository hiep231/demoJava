package managerStudent.Model;

public class Point {
    private String subject;
    private int pointx2;
    private int pointx3;
    private int pointx1;

    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public float getPointx2() {
        return pointx2;
    }
    public void setPointx2(int pointx2) {
        this.pointx2 = pointx2;
    }
    public float getPointx3() {
        return pointx3;
    }
    public void setPointx3(int pointx3) {
        this.pointx3 = pointx3;
    }
    public float getPointx1() {
        return pointx1;
    }
    public void setPointx1(int pointx1) {
        this.pointx1 = pointx1;
    }
    @Override
    public String toString() {
        return "Point [subject=" + subject + ", pointx2=" + pointx2 + ", pointx3=" + pointx3 + ", pointx1=" + pointx1
                + "]";
    }

    public Point() {
    }
}
