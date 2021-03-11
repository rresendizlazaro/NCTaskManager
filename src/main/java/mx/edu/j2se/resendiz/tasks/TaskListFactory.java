package mx.edu.j2se.resendiz.tasks;

public class TaskListFactory{
    public static AbstractTaskList createTaskList(ListTypes.types type){
        //Returning
        if (type.equals(ListTypes.types.ARRAY)) {
            return new ArrayTaskList();
        }else if (type.equals(ListTypes.types.LINKED)){
            return new LinkedTaskList();
        }else {
            return null;
        }
    }
}
