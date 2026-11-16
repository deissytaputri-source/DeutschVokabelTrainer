public class CliApplication {
    private final MenuNavigator navigator;

    public CliApplication() {
        InputReader input = new InputReader();
        VocabularyRepository repository = new VocabularyRepository();

        navigator = new MenuNavigator(input);
        navigator.addPage(new VocabularyListPage(input, repository));
        navigator.addPage(new AddVocabularyPage(input, repository));
        navigator.addPage(new QuizPage(input, repository));
    }

    public void run() {
        navigator.start();
    }
}
