import java.util.Scanner;
public class Echo {
    private Scanner sc;

    public Echo() {
        this.sc = new Scanner(System.in);
    }

    public void echoMessage() {
        String userInput = this.sc.nextLine();
        while (!checkExit(userInput)) {
            System.out.println(userInput);
            userInput = this.sc.nextLine();
        }
    }

    private boolean checkExit(String text) {
        String exit = "bye";
        return text.equals(exit);
    }


}
