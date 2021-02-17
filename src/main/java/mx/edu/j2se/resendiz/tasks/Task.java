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
        this.active = false;
        this.repeat = false;
    }

    //Inactive task => Time range
    public Task (String title, int start, int end, int interval){
        this.title = title;
        this.start = start;
        this.end = end;
        this.interval = interval;
        this.active = false;
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
        if (!repeat){
            return this.time;
        }else{
            return this.start;
        }
    }

    public void setTime(int time){
        if (!repeat){
            this.time = time;
        }else{
            this.repeat = false;
        }

    }

    //Reading and changing execution time for repetitive tasks
    public int getStartTime(){
        if(repeat){
            return this.start;
        }else{
            return  this.time;
        }
    }

    public int getSEndTime(){
        if(repeat){
            return this.end;
        }else{
            return this.time;
        }
    }

    public int getRepeatInterval(){
        if(repeat){
            return this.interval;
        }else{
            return 0;
        }
    }

    public void setTime(int start, int end, int interval){
        if(repeat){
            this.start = start;
            this.end = end;
            this.interval = interval;
        }else {
            this.repeat = true;
        }
    }

    //Check task for repeatability
    public boolean isRepeated(){
        return this.repeat;
    }

}
