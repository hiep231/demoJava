package managerStudent.Model;

public class Student {
    private String name;
    private String inclass;
    private int rank;
    private String conduct;
    private Point point;
    private Transgress transgress ;
    private int serial;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getInclass() {
        return inclass;
    }
    public void setInclass(String inclass) {
        this.inclass = inclass;
    }
    public int getRank() {
        return rank;
    }
    public void setRank(int rank) {
        this.rank = rank;
    }
    public String getConduct() {
        return conduct;
    }
    public void setConduct(String conduct) {
        this.conduct = conduct;
    }
    public Point getPoint() {
        return point;
    }
    public void setPoint(Point point) {
        this.point = point;
    }
    public Transgress getTransgress() {
        return transgress;
    }
    public void setTransgress(Transgress transgress) {
        this.transgress = transgress;
    }
    public int getSerial() {
        return serial;
    }
    public void setSerial(int serial) {
        this.serial = serial;
    }
    @Override
    public String toString() {
        return "Student [name=" + name + ", inclass=" + inclass + ", rank=" + rank + ", conduct=" + conduct + ", point="
                + point + ", transgress=" + transgress + ", serial=" + serial + "]";
    }
    public Student() {
        super();
    }
}
