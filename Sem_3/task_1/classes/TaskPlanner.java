package Sem_3.task_1.classes;
import java.util.List;

import Sem_3.task_1.repository.AssigmentRepository;
import Sem_3.task_1.repository.FreeTaskRepository;

abstract public class TaskPlanner {

    static private List<Employee> employees;

    public static void setEmployees(List<Employee> employees) {
        TaskPlanner.employees = employees;
    }
    
    public static Assigment planTask(Task task) {
        List<Employee> sortEmployees = employees.stream().filter(x -> x.getSkill() == task.getSkill()).filter(x -> !x.getIsWorking()).toList();
        Assigment assigment = null;
        if (!sortEmployees.isEmpty()){
            assigment = new Assigment(sortEmployees.get(0), task);
            AssigmentRepository.addAssigment(assigment);
        }
        else {
            FreeTaskRepository.addFreeTasks(task);
        }
        return assigment;       
    }

    // public static Assigment planTaskByPriority(Task task, List<Assigment> listAssigments){
    //      List<Employee> sortEmployees = employees.stream().filter(x -> x.getSkill() == task.getSkill()).filter(x -> !x.getIsWorking()).toList();
    //      Assigment assigment = null;
    //      if (!sortEmployees.isEmpty()){
    //          assigment = new Assigment(sortEmployees.get(0), task);
    //          AssigmentRepository.addAssigment(assigment);
        
    //      }
    //      return assigment; 
    // }
}
