package logic;

import model.Employee;
import model.Task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utility {
    private Map<Employee, List<Task>> map;
    private TasksManagement tasksManagement;

    public Utility(TasksManagement tasksManagement) {
        this.tasksManagement = tasksManagement;
        this.map = tasksManagement.getMap();
    }

    public Map<Employee, List<Task>> employeesWhoWorksMoreThan40Hours() {
        Map<Employee, List<Task>> newMap = new HashMap<>();

        for(Map.Entry<Employee, List<Task>> entry : map.entrySet()) {
            int hourWorked = tasksManagement.calculateEmployeeWorkDuration(entry.getKey().getIdEmployee());
            if(hourWorked > 40) {
                newMap.put(entry.getKey(), entry.getValue());
            }
        }

        return newMap;
    }

    public Map<String, Integer> findEmployeeFinishedTasks() {
        Map<String, Integer> newMap = new HashMap<>();

        for(Map.Entry<Employee, List<Task>> entry : map.entrySet()) {

            List<Task> tasks = entry.getValue();
            int counter = 0;

            for(Task task : tasks) {
                if(task.getStatus().equals("COMPLETED")) {
                    counter++;
                }
            }

            newMap.put(entry.getKey().getName(), counter);

        }

        return newMap;
    }

    public Map<String, Integer> findEmployeeUnfinishedTasks() {
        Map<String, Integer> newMap = new HashMap<>();

        for(Map.Entry<Employee, List<Task>> entry : map.entrySet()) {

            List<Task> tasks = entry.getValue();
            int counter = 0;

            for(Task task : tasks) {
                if(task.getStatus().equals("UNCOMPLETED")) {
                    counter++;
                }
            }

            newMap.put(entry.getKey().getName(), counter);

        }

        return newMap;
    }

}
