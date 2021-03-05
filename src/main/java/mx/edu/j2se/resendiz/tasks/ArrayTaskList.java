package mx.edu.j2se.resendiz.tasks;

public class ArrayTaskList {
    //Attribute
    public Task arrayTaskList[];
    private int taskCounter;

    //Constructor
    public ArrayTaskList(){
        this.arrayTaskList = new Task[100];
    }

    //Methods
    public void add(Task task){
        try {
            if (task == null) {
                throw new NullPointerException();
            }else {
                if (arrayTaskList[arrayTaskList.length - 1] != null) {
                    this.arrayTaskList[this.taskCounter++] = task;
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public boolean remove(Task task){
        for (int i = 0; i <= this.taskCounter; i++){
            if (this.arrayTaskList[i].equals(task)){
                this.arrayTaskList[i] = null;
                break;
            }
        }
        return true;
    }

    public int size(){
        return this.taskCounter;
    }

    public Task getTask(int index){
        Task returnedTask = new Task("ok", 0);
        try {
            if (index < 0 || index >= size()) {
                throw new IndexOutOfBoundsException();
            }else {
                returnedTask = this.arrayTaskList[index];
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return returnedTask;
    }

    public ArrayTaskList incoming(int from, int to){
        ArrayTaskList inc = new ArrayTaskList();
        Task temporal;
        for (int i = 0; i <= this.taskCounter; i++){
            temporal = getTask(i);
            if(temporal.getStartTime() >= from && temporal.getEndTime() <= to && temporal.isActive()){
                inc.add(temporal);
            }
        }
        return inc;
    }
}
