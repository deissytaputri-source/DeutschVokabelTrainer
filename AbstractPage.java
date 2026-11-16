public abstract class AbstractPage implements Page {
    private final String title;
    private final InputReader input;
    private final VocabularyRepository repository;

    public AbstractPage(String title, InputReader input, VocabularyRepository repository) {
        this.title = title;
        this.input = input;
        this.repository = repository;
    }

    @Override
    public String getTitle() {
        return title;
    }

    protected InputReader getInput() {
        return input;
    }

    protected VocabularyRepository getRepository() {
        return repository;
    }

    @Override
    public void execute() {
        printHeader();
        render();
        input.readLine("\nTekan Enter untuk kembali ke menu...");
    }

    protected abstract void render();

    protected void printHeader() {
        System.out.println();
        System.out.println("========================================");
        System.out.println("  " + title);
        System.out.println("========================================");
    }
}