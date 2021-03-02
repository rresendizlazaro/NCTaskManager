package mx.edu.j2se.resendiz.tasks;

public class ArrayTaskList {
    //Attribute
    public Task arrayTaskList[];
    private int taskCounter;

    //Constructor
    public ArrayTaskList(){

    }

    //Methods
    public void add(Task task){
        this.arrayTaskList[this.taskCounter++] = task;
    }

    public boolean remove(Task task){
        for (int i = 0; i <= this.taskCounter; i++){
            if (arrayTaskList[i].equals(task)){
                arrayTaskList[i] = null;
                break;
            }
        }
        return true;
    }

    public int size(){
        return this.taskCounter;
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
