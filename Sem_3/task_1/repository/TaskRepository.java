package Sem_3.task_1.repository;
import java.util.ArrayList;
import java.util.List;
import Sem_3.task_1.classes.Task;

public class TaskRepository {

    static private List<Task> TasksList;

    static public List<Task> getTasksList(){
        return TasksList;
    }

    static public List<Task> addTasks(Task task) {
        if (TasksList == null) TasksList = new ArrayList<>();
        TasksList.add(task);
        return TasksList;
}
}