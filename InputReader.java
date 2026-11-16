import java.util.Scanner;

public class InputReader {
    private final Scanner scanner;

    public InputReader() {
        this.scanner = new Scanner(System.in);
    }

    public String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    public int readInt(String prompt) {
        while (true) {
            String text = readLine(prompt);
            try {
                return Integer.parseInt(text);
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka, coba lagi ya.");
            }
        }
    }
}
