package mx.edu.j2se.resendiz.tasks;

import java.util.stream.Stream;

public abstract class AbstractTaskList implements Iterable<Task>{
    public abstract void add(Task task);

    public abstract boolean remove(Task task);

    public abstract int size();

    public abstract Task getTask(int index);

    public final ArrayTaskList incoming(int from, int to){
        if (this.getClass().equals(LinkedTaskList.class)) {
            LinkedTaskList taskL = new LinkedTaskList();
            //return taskL;
        } else if (this.getClass().equals(ArrayTaskList.class)) {
            ArrayTaskList taskA = new ArrayTaskList();
            return taskA;
        }
        return null;
    }

    public abstract Stream<Task> getStreams();
}
