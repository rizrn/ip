package WoopAI;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;

public class Storage {
    private static final Path PATH = Paths.get("data/data.txt");
    private static final Path DIR = Paths.get("data/");

    public static void checkDirectory() {
        try {
            if (!Files.exists(DIR)) {
                Files.createDirectory(DIR);
            }
        } catch (IOException e) {
            Ui.showIoError();
        }
    }

    public static void saveTasks(TaskList list) {
        try {
            Files.writeString(PATH, list.getTasksSaveFormat());
        } catch (IOException e) {
            Ui.showIoError();
        }
    }

    public static TaskList retrieveSave() {
        if (!Files.exists(PATH) || !Files.isRegularFile(PATH)) {
            return new TaskList();
        }

        TaskList list = new TaskList();
        try {
            List<String> l = Files.readAllLines(PATH);
            for (int i = 0; i < l.size(); i++) {
                String[] tmp = l.get(i).split(" \\| ");
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
        } catch (IOException e) {
           Ui.showIoError();
        }

        return list;
    }
}
