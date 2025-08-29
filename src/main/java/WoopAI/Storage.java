package WoopAI;

import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Scanner;

public class Storage {
    private static final String PATH = "ip/data/data.txt";
    public static void saveTasks(TaskList list) {
        try {
            FileWriter fw = new FileWriter(PATH);
            fw.write(list.getTasksSaveFormat());
            fw.close();
        } catch (FileNotFoundException e) {
            File f = new File(PATH);
        } catch (IOException e) {
            System.out.println("Upah! I cannot access your saved tasks");
        }
    }

    public static TaskList retrieveSave() {
        TaskList list = new TaskList();
        try {
            File f = new File(PATH);
            Scanner sc = new Scanner(f);
            while (sc.hasNext()) {
                String[] tmp = sc.nextLine().split(" \\| ");
                String name = tmp[2];
                boolean isFinished = tmp[1].equals("1");
                switch (tmp[0]) {
                case "D":
                    String dueDate = tmp[3];
                    list.addTask(new DeadlineTask(
                            name, isFinished, dueDate));
                    break;
                case "E":
                    String startTime = tmp[3];
                    String endTime = tmp[4];
                    list.addTask(new EventTask(name,
                            isFinished, startTime, endTime));
                    break;
                case "T":
                    list.addTask(new TodoTask(name, isFinished));
                    break;
                }

            }
        } catch (FileNotFoundException e) {
           return list;
        }

        return list;
    }
}
