public class VocabularyListPage extends AbstractPage {

    public VocabularyListPage(InputReader input, VocabularyRepository repository) {
        super("Daftar Kosakata Dasar", input, repository);
    }

    @Override
    protected void render() {
        System.out.printf("%-4s %-18s %s%n", "No", "Jerman", "Arti");
        System.out.println("----------------------------------------");
        int no = 1;
        for (Vocabulary v : getRepository().getAll()) {
            System.out.printf("%-4d %-18s %s%n", no, v.getFullGerman(), v.getIndonesian());
            no++;
        }
        System.out.println("\nTotal: " + getRepository().size() + " kosakata");
    }
}
