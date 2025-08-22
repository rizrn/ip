public class Woop {
    public static final String name = "Woop";
    public static void main(String[] args) {
        Echo echo = new Echo();
        String startMessage = "Hello! I'm "
                + name + "\n" +
                "What can I do for you?";
        String endMessage = "Bye. Hope to see you again soon!";
        System.out.println(startMessage);
        echo.echoMessage();
        System.out.println(endMessage);
    }
}
