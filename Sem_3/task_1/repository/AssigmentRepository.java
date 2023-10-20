package Sem_3.task_1.repository;
import java.util.ArrayList;
import java.util.List;

import Sem_3.task_1.classes.Assigment;

abstract public class AssigmentRepository {

    static private List<Assigment> assigmentList;

    static public List<Assigment> getAssigmentList() {
        return assigmentList;
    }

    static public List<Assigment> addAssigment(Assigment assigment) {
        if (assigmentList == null) assigmentList = new ArrayList<>();
        assigmentList.add(assigment);
        return assigmentList;
    }

    static public boolean checkAssignment(Assigment assigment){
        boolean result = false;
        if (assigment != null){
            result = true;
        }
        return result;
    }

}
