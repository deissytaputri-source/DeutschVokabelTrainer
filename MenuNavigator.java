import java.util.ArrayList;
import java.util.List;

public class MenuNavigator {
    private final List<Page> pages = new ArrayList<>();
    private final InputReader input;

    public MenuNavigator(InputReader input) {
        this.input = input;
    }

    public void addPage(Page page) {
        pages.add(page);
    }

    public void start() {
        boolean running = true;
        while (running) {
            showMenu();
            int exitNumber = pages.size() + 1;
            int choice = input.readInt("Pilih menu (1-" + exitNumber + "): ");

            if (choice >= 1 && choice <= pages.size()) {
                pages.get(choice - 1).execute();
            } else if (choice == exitNumber) {
                System.out.println("\nAuf Wiedersehen! Bis bald!");
                running = false;
            } else {
                System.out.println("Pilihan tidak ada, coba lagi ya.");
            }
        }
    }

    private void showMenu() {
        System.out.println();
        System.out.println("========================================");
        System.out.println("   DEUTSCH VOKABEL-TRAINER");
        System.out.println("========================================");
        for (int i = 0; i < pages.size(); i++) {
            System.out.println((i + 1) + ". " + pages.get(i).getTitle());
        }
        System.out.println((pages.size() + 1) + ". Keluar");
        System.out.println("----------------------------------------");
    }
}
