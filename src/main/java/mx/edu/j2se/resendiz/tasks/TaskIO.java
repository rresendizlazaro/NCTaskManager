package mx.edu.j2se.resendiz.tasks;

import java.io.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
//import com.google.gson.Gson;

public class TaskIO {
    public static void write(AbstractTaskList tasks, OutputStream out) throws IOException {
        DataOutputStream output = new DataOutputStream(out);
        for(int i = 0; i < tasks.size(); i++){
            output.writeInt(tasks.size());
            output.writeInt(tasks.getTask(i).getTitle().length());
            output.writeUTF(tasks.getTask(i).getTitle());
            if(tasks.getTask(i).isRepeated()){
                output.writeInt(tasks.getTask(i).getStartTime().getSecond());
                output.writeInt(tasks.getTask(i).getEndTime().getSecond());
                output.writeInt(tasks.getTask(i).getRepeatInterval());
            }else{
                output.writeInt(tasks.getTask(i).getTime().getSecond());
            }
        }

    }

    public static void read(AbstractTaskList tasks, InputStream in) throws IOException {
        DataInputStream input = new DataInputStream(in);
        int readCounter = input.readInt();
        for (int i = 0; i < readCounter; i++){
            int tasksSize = input.readInt();
            int lengthName = input.readInt();
            String taskTitle = input.readUTF();
            if(tasks.getTask(i).isRepeated()){
                LocalDateTime taskStart = LocalDateTime.ofEpochSecond(input.readInt(), 0, ZoneOffset.UTC);
                LocalDateTime taskEnd = LocalDateTime.ofEpochSecond(input.readInt(), 0, ZoneOffset.UTC);
                int taskInterval = input.readInt();
            }else{
                LocalDateTime taskTime = LocalDateTime.ofEpochSecond(input.readInt(), 0, ZoneOffset.UTC);
            }
        }
    }

    public static void writeBinary(AbstractTaskList tasks, File file) throws IOException {

    }

    public static void readBinary(AbstractTaskList tasks, File file) throws FileNotFoundException {

    }


    public void write(AbstractTaskList tasks, Writer out){

    }

    public void  read(AbstractTaskList tasks, Reader in){

    }

    public void writeText(AbstractTaskList tasks, File file){

    }

    public void readText(AbstractTaskList tasks, File file){

    }
}
