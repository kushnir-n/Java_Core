package Sem_3.task_1.classes;
import java.time.LocalDate;
import Sem_3.task_1.enums.Priority;
import Sem_3.task_1.enums.Skill;

public class Task {
    private String name;
    private int rank;
    private LocalDate createDate;
    //private LocalDate beginDate;
    //private LocalDate factDate;
    private LocalDate dueDate;
    private Skill skill;
    private Priority priority;
    private int length;
    private final int id;
    private static int count = 0;

    public Task(String name, int rank, LocalDate creatDate, LocalDate dueDate, Skill skill, Priority priority, int length, int id) {
        this.name = name;
        this.rank = rank;
        this.createDate = creatDate;
        this.dueDate = dueDate;
        this.skill = skill;
        this.priority = priority;
        this.length = length;
        this.id = id;
    }

    public Task(String name, int rank, LocalDate dueDate, Skill skill, Priority priority, int length) {
        this.name = name;
        this.rank = rank;
        this.createDate = LocalDate.now();
        this.dueDate = dueDate;
        this.skill = skill;
        this.priority = priority;
        this.length = length;
        this.id = count++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    // //public LocalDate getBeginDate() {
    //     return beginDate;
    // }

    // public void setBeginDate(LocalDate beginDate) {
    //     this.beginDate = beginDate;
    // }

    // public LocalDate getFactDate() {
    //     return factDate;
    // }

    // public void setFactDate(LocalDate factDate) {
    //     this.factDate = factDate;
    // //}

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }
  
    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id = " + id +
                ", name='" + name + '\'' +
                ", createDate=" + createDate +
                ", dueDate=" + dueDate +
                ", priority=" + priority +
                ", skill=" + skill +
                '}';
    }
}



    

