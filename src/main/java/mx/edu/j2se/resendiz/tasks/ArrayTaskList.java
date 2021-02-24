package mx.edu.j2se.resendiz.tasks;

public class ArrayTaskList {
    //Attributes
    Task arrayTaskList[];

    //Methods
    public void add(Task task){

        this.arrayTaskList[0] = task;
    }

    public boolean remove(Task task){
        for (int i = 0; i <= this.arrayTaskList.length; i++){
            if (arrayTaskList.equals(task)){
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
}
