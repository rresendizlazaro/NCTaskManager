package mx.edu.j2se.resendiz.tasks;

public class Task {
    //Attributes
    private String title;
    private int time;
    private int start;
    private int end;
    private int interval;
    private boolean active;
    private boolean repeat;

    //Constructors
    //Inactive task => No repeating
    public Task (String title, int time){
        try{
            if (time < 0) {
                throw new IllegalArgumentException("Time can't be negative");
            }else{
                this.title = title;
                this.time = time;
                this.active = false;
                this.repeat = false;
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

    //Inactive task => Time range
    public Task (String title, int start, int end, int interval){
        try{
            if (start < 0 || end < 0 || interval < 0) {
                throw new IllegalArgumentException("Start, end and interval can't be negative or equal");
            }else {
                this.title = title;
                this.start = start;
                this.end = end;
                this.interval = interval;
                this.active = false;
                this.repeat = true;
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
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
    public int getTime(){
        if (!this.repeat){
            return this.time;
        }else{
            return this.start;
        }
    }

    public void setTime(int time){
        if (!this.repeat){
            this.time = time;
        }else{
            this.repeat = false;
            this.time = time;
            this.start = 0;
            this.end = 0;
            this.interval = 0;
        }

    }

    //Reading and changing execution time for repetitive tasks
    public int getStartTime(){
        if(this.repeat){
            return this.start;
        }else{
            return  this.time;
        }
    }

    public int getEndTime(){
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

    public void setTime(int start, int end, int interval){
        if(this.repeat){
            this.start = start;
            this.end = end;
            this.interval = interval;
        }else {
            this.start = start;
            this.end = end;
            this.interval = interval;
            this.time = 0;
            this.repeat = true;
        }
    }

    //Check task for repeatability
    public boolean isRepeated(){
        return this.repeat;
    }

    //Checking the next task execution
    public int nextTimeAfter(int current){
        if(this.repeat){
            if(current >= this.start && interval == 0){
                return -1;
            }else{
                return this.start;
            }
        }else{
            if(current >= this.time){
                return -1;
            }else{
                return this.time;
            }
        }
    }
}
