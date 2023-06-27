package managerStudent.Service;
import managerStudent.Model.Point;

interface PointServiceInterface {
    Point addPoint(String subject,int pointx1,int pointx2,int pointx3);
}

public class PointService implements PointServiceInterface{
    @Override
    public Point addPoint(String subject, int pointx1, int pointx2, int pointx3) {
        // TODO Auto-generated method stub
        Point point=new Point();
        point.setSubject(subject);
        point.setPointx1(pointx1);
        point.setPointx2(pointx2);
        point.setPointx3(pointx3);

        return point;
    }
}
