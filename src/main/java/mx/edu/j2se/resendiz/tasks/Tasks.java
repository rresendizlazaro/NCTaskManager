package mx.edu.j2se.resendiz.tasks;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.StreamSupport;

public class Tasks {
    //First method
    public static Iterable<Task> incoming(Iterable<Task> tasks, LocalDateTime start, LocalDateTime end){
        return new Iterable<Task>() {
            @Override
            public Iterator<Task> iterator() {
                //Accessing to the task
                //Spliterator: interface to work with big sets of data, it is necessary for stream
                return StreamSupport.stream(tasks.spliterator(), false).filter(task -> task != null && task.nextTimeAfter(start) != null && end.isAfter(task.nextTimeAfter(start)) && task.isActive()).iterator();
            }
        };
    }

    //Second method to build a calendar of Tasks
    public static SortedMap<LocalDateTime, Set<Task>> calendar(Iterable<Task> tasks, LocalDateTime start, LocalDateTime end){
        //Declaring a map => treeMap collection to keep order
        SortedMap<LocalDateTime, Set<Task>> collection = new TreeMap<>();
        //Iterating the collection
        for( Task task1 : tasks ){
            //Taking only active ones
            if(task1.isActive()){
                //Asking if the task is going to be soon
                LocalDateTime actual = task1.nextTimeAfter(start);
                while(actual != null && !actual.isAfter(end)){
                    if(collection.containsKey(actual)){
                        collection.get(actual).add(task1);
                    }else{
                        Set<Task> set = new HashSet<>();
                        set.add(task1);
                        collection.put(actual, set);
                    }
                    actual = task1.nextTimeAfter(actual);
                }
            }
        }
        return collection;
    }
}
