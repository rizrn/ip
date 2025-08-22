public class Woop {
    public static final String name = "Woop";
    public static void main(String[] args) {
        WoopLogic logic = new WoopLogic();
        String startMessage = "Upah! I'm "
                + name + "\n" +
                "What can I do for you?";
        String endMessage = "Upah! Hope to see you again soon!";
        System.out.println(startMessage);
        logic.run();
        System.out.println(endMessage);
    }
}
