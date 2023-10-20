package Sem_3.task_1.repository;
import java.util.ArrayList;
import java.util.List;
import Sem_3.task_1.classes.Task;

abstract public class FreeTaskRepository {
    
    static private List<Task> freeTasksList;

    static public List<Task> getfreeTasksList(){
        return freeTasksList;
    }

    static public List<Task> addFreeTasks(Task task) {
        if (freeTasksList == null) freeTasksList = new ArrayList<>();
        freeTasksList.add(task);
        return freeTasksList;
    }
}
