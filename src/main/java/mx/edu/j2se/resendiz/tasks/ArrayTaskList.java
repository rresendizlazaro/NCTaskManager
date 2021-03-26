package mx.edu.j2se.resendiz.tasks;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayTaskList extends AbstractTaskList implements Iterable<Task>, Cloneable{
    //Attribute
    private Task arrayTaskList[];
    private int taskCounter;

    //Constructor
    public ArrayTaskList(){
        this.arrayTaskList = new Task[100];
    }

    //Methods
    public void add(Task task){
        if (task == null) {
            throw new NullPointerException();
        }else {
            if (arrayTaskList[arrayTaskList.length - 1] != null) {
                this.arrayTaskList[this.taskCounter++] = task;
            }
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
            if (index < 0 || index >= size()) {
                throw new IndexOutOfBoundsException();
            }else {
                return this.arrayTaskList[index];
            }
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

    //Overriding Methods equals, hashCode and toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayTaskList tasks = (ArrayTaskList) o;
        return Arrays.equals(arrayTaskList, tasks.arrayTaskList);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(arrayTaskList);
    }

    @Override
    public String toString() {
        return "ArrayTaskList{" +
                "arrayTaskList=" + Arrays.toString(arrayTaskList) +
                '}';
    }

    //Iterator
    @Override
    public Iterator<Task> iterator() {
        //Like the for cycle but in this case you can read the array and modify it's content
        Iterator<Task> iterate = new Iterator<Task>() {
            //Counter
            private int counter = 0;
            //Overriding methods of the iterator
            //this asks if exists a next task in the array
            @Override
            public boolean hasNext() {
                //Compares the actual item to the size of the array
                return counter < size();
            }

            //It jumps to the next space before the task
            @Override
            public Task next() {
                return getTask(counter++);
            }
        };
        return iterate;
    }

    //Clone method
    public ArrayTaskList clone() throws CloneNotSupportedException{
            return (ArrayTaskList) super.clone();
    }
}
