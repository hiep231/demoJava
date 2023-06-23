package managerStudent.Model;

public class Transgress {
    private String fault;
    private String transgressDay;
    private String transgressSubject;
    public String getFault() {
        return fault;
    }
    public void setFault(String fault) {
        this.fault = fault;
    }
    public String getTransgressDay() {
        return transgressDay;
    }
    public void setTransgressDay(String transgressDay) {
        this.transgressDay = transgressDay;
    }
    public String getTransgressSubject() {
        return transgressSubject;
    }
    public void setTransgressSubject(String transgressSubject) {
        this.transgressSubject = transgressSubject;
    }
    public Transgress() {
        super();
    }
    @Override
    public String toString() {
        return "Transgress [fault=" + fault + ", transgressDay=" + transgressDay + ", transgressSubject="
                + transgressSubject + "]";
    }
}
