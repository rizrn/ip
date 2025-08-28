public class Woop {
    public static final Ui ui = new Ui();

    public static void main(String[] args) {
        WoopLogic logic = new WoopLogic(Storage.retrieveSave());
        Ui.showIntro();
        logic.run();
        Ui.showGoodbye();
    }
}