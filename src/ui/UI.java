package ui;

import data_access.Database;
import logic.TasksManagement;
import logic.Utility;
import model.Employee;
import model.SimpleTask;
import model.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class UI implements ActionListener {
    JFrame frame;

    //employee

    JLabel employeeTitle = new JLabel("Employee");

    JLabel employeeIdTitle = new JLabel("Employee ID:");
    JLabel employeeNameTitle = new JLabel("Employee Name:");

    JTextField employeeId = new JTextField();
    JTextField employeeName = new JTextField();

    JButton addEmployee = new JButton("Add Employee");

    //task

    JLabel taskTitle = new JLabel("Assign Task");

    JLabel taskIdTitle = new JLabel("Task ID:");
    JLabel taskNameTitle = new JLabel("Task Name:");
    JLabel taskStartTimeTitle = new JLabel("Task Start Time:");
    JLabel taskEndTimeTitle = new JLabel("Task End Time:");

    JTextField taskId = new JTextField();
    JTextField taskName = new JTextField();
    JTextField taskStartTime = new JTextField();
    JTextField taskEndTime = new JTextField();

    JButton addTask = new JButton("Assign Task");
    JLabel taskEmployeeIdTitle = new JLabel("Employee ID:");
    JTextField taskEmployeeId = new JTextField();

    //taskmanagement

    TasksManagement tasksManagement;

    JLabel managementTitle = new JLabel("Management");
    JLabel data = new JLabel("EmployeeId with the tasks : [.....]");

    JLabel calculateHoursTitle = new JLabel("Calculate Hours");
    JLabel calculateHoursIdTitle = new JLabel("ID Employee:");
    JTextField calculateHoursId = new JTextField();
    JLabel calculateHours = new JLabel("Hours:");
    JButton calculateHoursButton = new JButton("|");

    JButton modifyStatusButton = new JButton("Modify Status");

    JButton filterButton = new JButton("Filter");
    JButton completeButton = new JButton("See Completed Tasks");
    JButton seeWorkers = new JButton("See Workers");

    Utility utility;
    Database database;

    public UI() throws IOException, ClassNotFoundException {
        frame = new JFrame();
        frame.setSize(1000, 700);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setTitle("Project TP");

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    onClose();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        //employee

        employeeTitle.setBounds(0,0,150,50);
        employeeIdTitle.setBounds(30,50,150,50);
        employeeId.setBounds(165, 62, 150, 30);

        employeeNameTitle.setBounds(340, 50,200,50);
        employeeName.setBounds(510, 62, 150, 30);
        addEmployee.setBounds(700, 62, 200, 30);
        addEmployee.addActionListener(this);

        //tasks

        taskTitle.setBounds(0,100,150,50);

        taskIdTitle.setBounds(30,140,150,50);
        taskId.setBounds(110, 152, 50, 30);

        taskNameTitle.setBounds(30,180,150,50);
        taskName.setBounds(150, 192, 150, 30);

        taskStartTimeTitle.setBounds(30,220,150,50);
        taskStartTime.setBounds(180, 232, 50, 30);

        taskEndTimeTitle.setBounds(30,260,150,50);
        taskEndTime.setBounds(180, 272, 50, 30);

        taskEmployeeIdTitle.setBounds(30,300,150,50);
        taskEmployeeId.setBounds(155   , 312, 50, 30);

        addTask.setBounds(30, 352, 170, 30);
        addTask.addActionListener(this);
        modifyStatusButton.setBounds(200, 352, 170, 30);
        modifyStatusButton.addActionListener(this);

        calculateHoursTitle.setBounds(0,380,300,50);
        calculateHoursIdTitle.setBounds(30,420,150,50);
        calculateHoursId.setBounds(155, 432, 150, 30);
        calculateHours.setBounds(50, 470, 150, 30);
        calculateHoursButton.setBounds(310, 432, 30, 30);
        calculateHoursButton.addActionListener(this);

        filterButton.setBounds(30, 510, 200, 30);
        filterButton.addActionListener(this);

        completeButton.setBounds(30, 550, 200, 30);
        completeButton.addActionListener(this);

        seeWorkers.setBounds(30, 590, 200, 30);
        seeWorkers.addActionListener(this);

        //management
        tasksManagement = new TasksManagement();
        database = new Database();

        Map<Employee, List<Task>> result;

        try {
            result = database.getFromDatabase();
            tasksManagement.setMap(result);
        }catch (Exception e){
            //->
        }


        utility = new Utility(tasksManagement);

        managementTitle.setBounds(500,130,300,50);
        data.setText("<html>" +  tasksManagement.getMap().toString() + "</html>");
        data.setBounds(400, 100, 600, 700);

        setProprieties();
        addComponents();
    }

    private void setProprieties(){
        //employee
        employeeTitle.setFont(new Font("Serif", Font.PLAIN, 30));
        employeeIdTitle.setFont(new Font("Serif", Font.PLAIN, 22));
        employeeNameTitle.setFont(new Font("Serif", Font.PLAIN, 22));

        //task
        taskTitle.setFont(new Font("Serif", Font.PLAIN, 30));
        taskIdTitle.setFont(new Font("Serif", Font.PLAIN, 22));
        taskNameTitle.setFont(new Font("Serif", Font.PLAIN, 22));
        taskStartTimeTitle.setFont(new Font("Serif", Font.PLAIN, 22));
        taskEndTimeTitle.setFont(new Font("Serif", Font.PLAIN, 22));
        taskEmployeeIdTitle.setFont(new Font("Serif", Font.PLAIN, 22));
        taskEmployeeId.setFont(new Font("Serif", Font.PLAIN, 22));

        //taskmanagement
        managementTitle.setFont(new Font("Serif", Font.PLAIN, 30));
        calculateHoursTitle.setFont(new Font("Serif", Font.PLAIN, 30));
        calculateHoursIdTitle.setFont(new Font("Serif", Font.PLAIN, 22));
        calculateHours.setFont(new Font("Serif", Font.PLAIN, 22));
    }

    private void addComponents(){
        //employee
        frame.add(employeeTitle);
        frame.add(employeeIdTitle);
        frame.add(employeeId);
        frame.add(employeeNameTitle);
        frame.add(employeeName);
        frame.add(addEmployee);
        //tasks
        frame.add(taskTitle);
        frame.add(taskIdTitle);
        frame.add(taskNameTitle);
        frame.add(taskStartTimeTitle);
        frame.add(taskEndTimeTitle);

        frame.add(taskId);
        frame.add(taskName);
        frame.add(taskStartTime);
        frame.add(taskEndTime);

        frame.add(taskEmployeeIdTitle);
        frame.add(taskEmployeeId);

        frame.add(addTask);

        //task management
        frame.add(managementTitle);
        frame.add(data);

        frame.add(calculateHoursTitle);
        frame.add(calculateHoursIdTitle);
        frame.add(calculateHoursId);
        frame.add(calculateHours);
        frame.add(calculateHoursButton);

        frame.add(modifyStatusButton);
        frame.add(filterButton);
        frame.add(completeButton);
        frame.add(seeWorkers);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addTask){
            System.out.println("am apasat add task");
            String idTask = taskId.getText();
            String name = taskName.getText();
            String startTime = taskStartTime.getText();
            String endTime = taskEndTime.getText();
            String idEmployee = taskEmployeeId.getText();

            Task task = new SimpleTask(Integer.parseInt(idTask), "UNCOMPLETED", name, Integer.parseInt(startTime), Integer.parseInt(endTime));
            System.out.println(task);
            tasksManagement.assignTaskToEmployee(Integer.parseInt(idEmployee), task);
            data.setText("<html>" +  tasksManagement.getMap().toString() + "</html>");
        }else{
            if(e.getSource() == addEmployee){
                System.out.println("am apasat add employee");

                String id = employeeId.getText();
                String name = employeeName.getText();

                Employee employee = new Employee(Integer.parseInt(id), name);
                System.out.println(employee);

                tasksManagement.addEmployee(employee);
                data.setText("<html>" +  tasksManagement.getMap().toString() + "</html>");
            }else{
                if(e.getSource() == calculateHoursButton){
                    String id = calculateHoursId.getText();
                    String s = "" + tasksManagement.calculateEmployeeWorkDuration(Integer.parseInt(id));
                    calculateHours.setText("Hours: " + s);
                }else{
                    if(e.getSource() == modifyStatusButton){
                        String idTask = taskId.getText();
                        String idEmployee = taskEmployeeId.getText();

                        tasksManagement.modifyTaskStatus(Integer.parseInt(idEmployee), Integer.parseInt(idTask));
                        data.setText("<html>" +  tasksManagement.getMap().toString() + "</html>");
                    }else{
                        if(e.getSource() == filterButton){
                            Map<Employee, List<Task>> result = utility.employeesWhoWorksMoreThan40Hours();
                            data.setText("<html>" +  result.toString() + "</html>");
                        }else{
                            if(e.getSource() == completeButton){
                                Map<String, Integer> result1 = utility.findEmployeeFinishedTasks();
                                Map<String, Integer> result2 = utility.findEmployeeUnfinishedTasks();
                                data.setText("<html>Tasks Completed by Employees:<br>" +  result1.toString() + "<br><br>Tasks UnCompleted by Employees<br> " + result2.toString() + "</html>");
                            }else{
                                if(e.getSource() == seeWorkers){
                                    data.setText("<html>" +  tasksManagement.getMap().toString() + "</html>");
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void onClose() throws IOException {
            database.saveToDatabase(tasksManagement.getMap());
    }
}
