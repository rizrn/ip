import java.util.Scanner;
public class Echo {
    private Scanner sc;

    public Echo() {
        this.sc = new Scanner(System.in);
    }

    public void echoMessage() {
        String userInput = this.sc.nextLine();
        System.out.println(userInput);
        while (!checkExit(userInput)) {
            userInput = this.sc.nextLine();
            System.out.println(userInput);
        }
    }

    private boolean checkExit(String text) {
        String exit = "bye";
        return text.equals(exit);
    }


}
