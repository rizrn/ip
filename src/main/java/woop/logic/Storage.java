package woop.logic;

import woop.ui.Ui;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;

/**
 * Class that handles save states
 */
public class Storage {
    private static final Path PATH = Paths.get("data/data.txt");
    private static final Path DIR = Paths.get("data/");

    /**
     * Checks if data directory exists.
     * If not exists, create directory.
     */
    public static void checkDirectory() {
        try {
            if (!Files.exists(DIR)) {
                Files.createDirectory(DIR);
            }
        } catch (IOException e) {
            Ui.showIoError();
        }
    }

    /**
     * Saves tasks from the given TaskList object to data file
     * If I/O error occurs, prints an error message.
     *
     * @param list Current TaskList to store.
     */
    public static void saveTasks(TaskList list) {
        try {
            Files.writeString(PATH, list.getTasksSaveFormat());
        } catch (IOException e) {
            Ui.showIoError();
        }
    }

    /**
     * Retrieves save state from data file.
     * Then, interpret the save state and convert into a TaskList.
     * If it does not exist, return empty TaskList.
     *
     * @return TaskList of tasks in the save state.
     */
    public static TaskList retrieveSave() {
        boolean doesFileExist = !Files.exists(PATH) || !Files.isRegularFile(PATH);
        if (doesFileExist) {
            return new TaskList();
        }

        TaskList tasks = new TaskList();
        try {
            List<String> l = Files.readAllLines(PATH);
            for (String s : l) {
                extractTask(s, tasks);
            }
        } catch (IOException e) {
           Ui.showIoError();
        }

        return tasks;
    }

    private static void extractTask(String line, TaskList tasks) {
        String[] lineSplit = line.split(" \\| ");
        String name = lineSplit[2];
        boolean isFinished = lineSplit[1].equals("1");
        String taskType = lineSplit[0];
        switch (taskType) {
        case "D":
            String dueDate = lineSplit[3];
            tasks.addTask(new DeadlineTask(
                    name, isFinished, dueDate));
            break;
        case "E":
            String startTime = lineSplit[3];
            String endTime = lineSplit[4];
            tasks.addTask(new EventTask(name,
                    isFinished, startTime, endTime));
            break;
        case "T":
            tasks.addTask(new TodoTask(name, isFinished));
            break;
        }
    }
}
