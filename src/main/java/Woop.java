public class Woop {
    public static final String NAME = "Woop";
    public static void main(String[] args) {
        WoopLogic logic = new WoopLogic(Save.retrieveSave());
        String startMessage = "Upah! I'm "
                + NAME + "\nWhat can I do for you?";
        String endMessage = "Upah! Hope to see you again soon!";
        System.out.println(startMessage);
        logic.run();
        System.out.println(endMessage);
    }
}
