package data_access;

import model.Employee;
import model.Task;

import java.io.*;
import java.util.List;
import java.util.Map;

public class Database {

    public void saveToDatabase(Map<Employee, List<Task>> map) throws IOException {
        FileOutputStream fileOutputStream = new
                FileOutputStream("database.txt");

        ObjectOutputStream objectOutputStream = new
                ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(map);

        objectOutputStream.flush();
        objectOutputStream.close();
    }

    public Map<Employee, List<Task>> getFromDatabase() throws IOException, ClassNotFoundException {

        FileInputStream fileInputStream = new
                FileInputStream("database.txt");
        ObjectInputStream objectInputStream = new
                ObjectInputStream(fileInputStream);

        Map<Employee, List<Task>> restoredDatabase = (Map<Employee, List<Task>>) objectInputStream.readObject();

        objectInputStream.close();
        System.out.println(restoredDatabase.toString());
        return restoredDatabase;
    }

}
