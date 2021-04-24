package mx.edu.j2se.resendiz.tasks;

import java.util.Objects;
import java.time.*;

public class Task implements Cloneable{
    //Attributes
    private String title;
    //Instead an integer
    //private int time;
    private LocalDateTime time;
    //Change to a date format
    //private int start;
    //private int end;
    private LocalDateTime start;
    private LocalDateTime end;
    private int interval;
    private boolean active;
    private boolean repeat;

    //Constructors
    //Inactive task => No repeating
    public Task (String title, LocalDateTime time){
        if (time == null) {
            throw new IllegalArgumentException("Time can't be negative");
        }else{
            this.title = title;
            this.time = time;
            this.active = false;
            this.repeat = false;
        }
    }

    //Inactive task => Time range
    public Task (String title, LocalDateTime start, LocalDateTime end, int interval){
        if (start == null || end == null || interval < 0) {
            throw new IllegalArgumentException("Start, end and interval can't be negative or equal");
        }else {
            this.title = title;
            this.start = start;
            this.end = end;
            this.interval = interval;
            this.active = false;
            this.repeat = true;
        }
    }

    //Methods
    //Reading and setting task name
    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    //Reading and task status
    public boolean isActive(){
        return this.active;
    }

    public void setActive(boolean active){
        this.active = active;
    }

    //Reading and changing execution time for NO REPETITIVE TASKS
    public LocalDateTime getTime(){
        if (!this.repeat){
            return this.time;
        }else{
            return this.start;
        }
    }

    public void setTime(LocalDateTime time){
        if (!this.repeat){
            this.time = time;
        }else{
            this.repeat = false;
            this.time = time;
            this.start = null;
            this.end = null;
            this.interval = 0;
        }

    }

    //Reading and changing execution time for repetitive tasks
    public LocalDateTime getStartTime(){
        if(this.repeat){
            return this.start;
        }else{
            return  this.time;
        }
    }

    public LocalDateTime getEndTime(){
        if(this.repeat){
            return this.end;
        }else{
            return this.time;
        }
    }

    public int getRepeatInterval(){
        if(this.repeat){
            return this.interval;
        }else{
            return 0;
        }
    }

    public void setTime(LocalDateTime start, LocalDateTime end, int interval){
        if(this.repeat){
            this.start = start;
            this.end = end;
            this.interval = interval;
        }else {
            this.start = start;
            this.end = end;
            this.interval = interval;
            this.time = null;
            this.repeat = true;
        }
    }

    //Check task for repeatability
    public boolean isRepeated(){
        return this.repeat;
    }

    //Checking the next task execution
    public LocalDateTime nextTimeAfter(LocalDateTime current){
        if(this.repeat){
            if(current.isAfter(this.start) && interval == 0){
                return null;
            }else{
                return this.start;
            }
        }else{
            if(current.isAfter(this.time)){
                return null;
            }else{
                return this.time;
            }
        }
    }

    //Overriding Methods equals, hashCode and toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return time == task.time && start == task.start && end == task.end && interval == task.interval && active == task.active && repeat == task.repeat && Objects.equals(title, task.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, time, start, end, interval, active, repeat);
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", time=" + time +
                ", start=" + start +
                ", end=" + end +
                ", interval=" + interval +
                ", active=" + active +
                ", repeat=" + repeat +
                '}';
    }

    //Clone method
    @Override
    public Task clone() throws CloneNotSupportedException {
        //Returns an object Task
        return (Task) super.clone();
    }
}
