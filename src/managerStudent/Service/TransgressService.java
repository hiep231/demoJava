package managerStudent.Service;

import managerStudent.Model.Transgress;

interface TransgressServiceInterface {
    Transgress addTransgress(String fault, String transgressDay, String transgressSubject);
}

public class TransgressService implements TransgressServiceInterface {

    @Override
    public Transgress addTransgress(String fault, String transgressDay, String transgressSubject) {
        // TODO Auto-generated method stub
        Transgress transgress = new Transgress();
        transgress.setFault(fault);
        transgress.setTransgressDay(transgressDay);
        transgress.setTransgressSubject(transgressSubject);

        return transgress;
    }
}
