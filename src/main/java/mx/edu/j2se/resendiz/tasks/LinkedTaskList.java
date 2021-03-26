package mx.edu.j2se.resendiz.tasks;

import java.util.Iterator;
import java.util.Objects;
import  java.util.stream.Stream;

public class LinkedTaskList extends AbstractTaskList implements Iterable<Task>, Cloneable{
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

    public Task getTask(int index){
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        if (index <= size()) {
            Node current = start;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.task;
        }
        return end.task;
    }

    @Override
    public Iterator<Task> iterator() {
        Iterator<Task> it = new Iterator<Task>() {
            //Node to walk the LTL
            Node currentNode = start;
            //Nodes to keep previous nodes
            Node node1 = null;
            Node node2 = null;

            //Asking for a next node
            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            //Jumping to the next space after the node
            @Override
            public Task next() {
                //Assigning the current task to task1
                Task task1 = currentNode.task;
                //Carry nodes
                node2 = node1;
                node1 = currentNode;
                currentNode = currentNode.next;
                return task1;
            }

            @Override
            public void remove() {
                if (node2 == null) {
                    start = currentNode;
                } else {
                    node2 = currentNode;
                }
                nodeCounter--;
            }
        };
        return it;
    }

    //Overriding Methods equals, hashCode and toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedTaskList tasks = (LinkedTaskList) o;
        return nodeCounter == tasks.nodeCounter && Objects.equals(start, tasks.start) && Objects.equals(end, tasks.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end, nodeCounter);
    }

    @Override
    public String toString() {
        return "LinkedTaskList{" +
                "start=" + start +
                ", end=" + end +
                ", nodeCounter=" + nodeCounter +
                '}';
    }

    //Clone method
    public LinkedTaskList clone() throws CloneNotSupportedException {
            LinkedTaskList link = (LinkedTaskList) super.clone();
            link.nodeCounter = 0;
            for (int i = 0; i < nodeCounter; i++) {
                link.add(getTask(i));
            }
            return link;
    }

    //Overriding stream method
    @Override
    public Stream<Task> getStreams() {
        ArrayTaskList list = new ArrayTaskList();
        for (int i = 0; i < size(); i++) {
            list.add(getTask(i));
        }
        return list.getStreams();
    }
}
