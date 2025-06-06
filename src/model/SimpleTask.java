package model;

import java.io.Serializable;

public class SimpleTask extends Task implements Serializable {

    private int startHour;
    private int endHour;

    public SimpleTask(int idTask,
                      String statusTask,
                      String nameOfTask,
                      int startHour,
                      int endHour) {
        super(idTask, statusTask, nameOfTask);
        this.startHour = startHour;
        this.endHour = endHour;
    }

    @Override
    public int estimateDuration() {
        return endHour - startHour;
    }

    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public int getEndHour() {
        return endHour;
    }

    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }

    @Override
    public String toString() {
        return "SimpleTask{" +
                "startHour=" + startHour +
                ", endHour=" + endHour +
                ", id=" + id +
                ", nameOfTask='" + nameOfTask + '\'' +
                ", status='" + status + '\'' +
                "}";
    }
}
