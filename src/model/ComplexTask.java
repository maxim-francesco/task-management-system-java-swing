package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ComplexTask extends Task implements Serializable {

    List<Task> tasks;

    public ComplexTask(int id, String status, String nameOfTask) {
        super(id, status, nameOfTask);
        tasks = new ArrayList<Task>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void deleteTask(Task task) {
        tasks.remove(task);
    }

    @Override
    public int estimateDuration() {
        int duration = 0;
        for(Task task : tasks) {
            duration += task.estimateDuration();
        }
        return duration;
    }
}
