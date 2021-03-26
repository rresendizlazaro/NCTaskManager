package mx.edu.j2se.resendiz.tasks;

import java.util.stream.Stream;

public abstract class AbstractTaskList implements Iterable<Task>{
    public abstract void add(Task task);

    public abstract boolean remove(Task task);

    public abstract int size();

    public abstract Task getTask(int index);

    public final ArrayTaskList incoming(int from, int to){
        if (this.getClass().equals(LinkedTaskList.class)) {
            LinkedTaskList task1 = new LinkedTaskList();
            //return task1;
        } else if (this.getClass().equals(ArrayTaskList.class)) {
            ArrayTaskList task2 = new ArrayTaskList();
            return task2;
        }
        return null;
    }

    public abstract Stream<Task> getStreams();
}
