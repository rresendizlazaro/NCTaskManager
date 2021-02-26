package mx.edu.j2se.resendiz.tasks;

public class ArrayTaskList {
    //Attributes
    private int taskNumber;
    public static int taskCounter;
    Task[] arrayTaskList;

    //Constructor
    public ArrayTaskList(){
        this.taskNumber = ++ArrayTaskList.taskCounter;
        this.arrayTaskList = new Task[taskNumber];
    }

    //Methods
    public void add(Task task){
        this.arrayTaskList[this.taskNumber-1] = task;
    }

    public boolean remove(Task task){
        for (int i = 0; i <= this.arrayTaskList.length; i++){
            if (arrayTaskList[i].equals(task)){
                arrayTaskList[i] = null;
                break;
            }
        }
        return true;
    }

    public int size(){
        return this.arrayTaskList.length;
    }

    public Task getTask(int index){
        return this.arrayTaskList[index];
    }

    public ArrayTaskList incoming(int from, int to){
        for (int i = 0; i <= this.arrayTaskList.length; i++){

        }
        return null;
    }
}
