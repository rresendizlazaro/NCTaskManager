package mx.edu.j2se.resendiz.tasks;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.stream.Stream;
import java.io.*;

public abstract class AbstractTaskList implements Iterable<Task>, Serializable{
    public abstract void add(Task task);

    public abstract boolean remove(Task task);

    public abstract int size();

    public abstract Task getTask(int index);

    //The ultimate incoming method
    public final AbstractTaskList incoming(LocalDateTime from, LocalDateTime to){
        //Returning LTL
        if (this.getClass().equals(LinkedTaskList.class)) {
            //Creating a new LTL to return
            LinkedTaskList linkedTaskList = new LinkedTaskList();
            //Checking the time
            this.getStreams().filter(Objects::nonNull).forEach(linkedTaskList::add);
            return linkedTaskList;
        }
        //Returning ATL
        else if (this.getClass().equals(ArrayTaskList.class)) {
            //Creating a new ATL to return
            ArrayTaskList arrayTaskList = new ArrayTaskList();
            //Checking the time
            this.getStreams().filter(Objects::nonNull).forEach(arrayTaskList::add);
            return arrayTaskList;
        }
        return null;
    }

    //Adding Stream
    public abstract Stream<Task> getStreams();
}
