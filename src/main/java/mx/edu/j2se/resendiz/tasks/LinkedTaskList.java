package mx.edu.j2se.resendiz.tasks;

public class LinkedTaskList {
    //Creating a class that represents the linkedList's nodes
    //#####################Node Class#####################
    class Node{
        Task task;
        Node next;

        public Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    //Representing the start and end of the LinkedList
    //Adding an integer variable to keep the count of every linkedList's node
    public Node start = null;
    public Node end = null;
    public int nodeCounter=0;

    //#####################End of Node Class#####################

    //Methods
    public void add(Task task){
        //Exception
        try{
            if(task == null) {
                throw new NullPointerException();
            }else {
                //Create a new node
                Node newNode = new Node(task);

                //Checks if the list is empty
                if (start == null) {
                    //If list is empty, start and end will be the new node
                    start = newNode;
                    end = newNode;
                    this.nodeCounter++;
                } else {
                    //newNode will be added after end such that end's next will point to newNode
                    end.next = newNode;
                    //newNode will become new end of the list
                    end = newNode;
                    this.nodeCounter++;
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public boolean remove(Task taskD){
        //Start node
        Node temporal = start;
        Node previous = null;

        //If start node has the task to be deleted
        if (temporal != null && temporal.task == taskD) {
            start = temporal.next; // Changed start
            return true;
        }

        //Searching the node
        while (temporal != null && temporal.task != taskD) {
            previous = temporal;
            temporal = temporal.next;
        }

        //If the task was not presented in the linked list
        if (temporal == null)
            return false;

        //Removing the node from the linked list
        previous.next = temporal.next;
        this.nodeCounter--;
        return true;
    }

    public int size(){
        return this.nodeCounter;
    }

    public Task getTask(Task taskD){
        //Similar to remove class
        //Start node
        Node temporal = start;

        //If start node has the task to be returned
        if (temporal != null && temporal.task == taskD) {
            return temporal.task;
        }

        //Searching the node
        while (temporal != null && temporal.task != taskD){
            temporal = temporal.next;
        }

        //Sending the task
        return temporal.task;
    }

    public ArrayTaskList incoming(int from, int to){
        return null;
    }
}
