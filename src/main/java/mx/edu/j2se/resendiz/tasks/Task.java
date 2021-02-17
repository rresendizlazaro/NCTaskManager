package mx.edu.j2se.resendiz.tasks;

public class Task {
    //Attributes
    private String title;
    private int time;
    private int start;
    private int end;
    private int interval;
    private boolean active;
    private  boolean repeat;

    //Constructors
    //Inactive task => No repeating
    public Task (String title, int time){
        this.title = title;
        this.time = time;
        this.repeat = false;
    }

    //Inactive task => Time range
    public Task (String title, int start, int end, int interval){
        this.title = title;
        this.start = start;
        this.end = end;
        this.interval = interval;
        this.repeat = true;
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
    public int getTime(){
        return this.time;
    }

    public void setTime(int time){
        this.time = time;
    }

    //Reading and changing execution time for repetitive tasks
    public int getStartTime(){
        return this.start;
    }

    public int getSEndTime(){
        return this.end;
    }

    public int getRepeatInterval(){
        return this.interval;
    }

    public void setTime(int start, int end, int interval){
        this.start = start;
        this.end = end;
        this.interval = interval;
    }

    //Check task for repeatability
    public boolean isRepeated(){
        return this.repeat;
    }

}
