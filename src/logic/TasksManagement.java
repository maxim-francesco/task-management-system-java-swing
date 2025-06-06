package logic;

import model.Employee;
import model.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TasksManagement {
    private Map<Employee, List<Task>> map;

    public TasksManagement() {
        map = new HashMap<>();
    }

    public void setMap(Map<Employee, List<Task>> map) {
        this.map = map;
    }

    public Map<Employee, List<Task>> getMap() {
        return map;
    }

    public void addEmployee(Employee employee) {
        List<Task> tasks = new ArrayList<>();
        map.put(employee, tasks);
    }

    public void assignTaskToEmployee(int idEmployee, Task task) {
        for(Map.Entry<Employee, List<Task>> entry : map.entrySet()) {
            if(entry.getKey().getIdEmployee() == idEmployee) {
                entry.getValue().add(task);
                break;
            }
        }
    }

    public int calculateEmployeeWorkDuration(int idEmployee){
        for(Map.Entry<Employee, List<Task>> entry : map.entrySet()) {
            if(entry.getKey().getIdEmployee() == idEmployee) {
                int totalWorkDuration = 0;
                for(Task task : entry.getValue()) {
                    totalWorkDuration += task.estimateDuration();
                }
                return totalWorkDuration;
            }
        }
        return 0;
    }

    public void modifyTaskStatus(int idEmployee, int idTask){
        for(Map.Entry<Employee, List<Task>> entry : map.entrySet()) {
            if (entry.getKey().getIdEmployee() == idEmployee) {
                for(Task task : entry.getValue()) {
                    if(task.getId() == idTask) {
                        task.setStatus("COMPLETED");
                    }
                }
            }
        }
    }

}
