package mx.edu.j2se.resendiz.tasks;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

public class ArrayTaskList extends AbstractTaskList implements Iterable<Task>, Cloneable{
    //Attribute
    private Task[] arrayTaskList = new Task[0];

    //Constructor
    public ArrayTaskList(){}

    //Methods
    public void add(Task task){
        if (task == null) {
            throw new NullPointerException();
        }else {
            //Creating a new array to change the index of the actual array
            //But this array is a copy of the prev
            this.arrayTaskList = Arrays.copyOf(this.arrayTaskList, this.arrayTaskList.length+1);
            for (int i = 0; i < this.arrayTaskList.length; i++){
                if(this.arrayTaskList[i] == null){
                    this.arrayTaskList[i] = task;
                }
            }
        }
    }

    public boolean remove(Task task){
        for (int i = 0; i < this.arrayTaskList.length; i++){
            //Iterating till the task desired
            if (task.hashCode() == this.arrayTaskList[i].hashCode()){
                //Copy of an array taking a new one from an specific index
                System.arraycopy(this.arrayTaskList, i++, this.arrayTaskList, i, this.arrayTaskList.length -1 -i);
                //Creating a new array with the correct length
                this.arrayTaskList = Arrays.copyOf(this.arrayTaskList, this.arrayTaskList.length - 1);
            }
        }
        return true;
    }

    public int size(){
        return this.arrayTaskList.length;
    }

    public Task getTask(int index){
            if (index < 0 || index >= size()) {
                throw new IndexOutOfBoundsException();
            }else {
                return this.arrayTaskList[index];
            }
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

    //Overriding stream method
    @Override
    public Stream<Task> getStreams() {
        return Stream.of(this.arrayTaskList);
    }
}
