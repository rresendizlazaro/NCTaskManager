package mx.edu.j2se.resendiz.tasks;

public class LinkedTaskList {
    //Attribute
    public Task arrayTaskList[];
    private int taskCounter;

    //Constructor
    public LinkedTaskList(){
        this.arrayTaskList = new Task[100];
    }

    //Methods
    public void add(Task task){
        if(task == null)
            throw new NullPointerException();
        if(arrayTaskList[arrayTaskList.length-1]!=null)  {
            this.arrayTaskList[this.taskCounter++] = task;
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
        if(index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
        return this.arrayTaskList[index];
    }

    public ArrayTaskList incoming(int from, int to){
        for (int i = 0; i <= this.taskCounter; i++){

        }
        return null;
    }
}
