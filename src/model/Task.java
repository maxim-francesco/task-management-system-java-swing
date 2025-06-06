package model;

import java.io.Serializable;

public abstract class Task implements Serializable {
    public int id;
    public String status;
    public String nameOfTask;

    public Task(int id, String status, String nameOfTask) {
        this.id = id;
        this.status = status;
        this.nameOfTask = nameOfTask;
    }

    public abstract int estimateDuration();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
