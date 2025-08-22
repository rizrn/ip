import java.util.Scanner;
public class Echo {
    private Scanner sc;
    private String userInput;

    public Echo() {
        this.sc = new Scanner(System.in);
        this.userInput = "";
    }

    public void echoMessage() {
        this.userInput = this.sc.nextLine();
        while (!checkExit()) {
            System.out.println(this);
            this.userInput = this.sc.nextLine();
        }
    }

    private boolean checkExit() {
        String exit = "bye";
        return this.userInput.equals(exit);
    }

    @Override
    public String toString() {
        return this.userInput;
    }
}
