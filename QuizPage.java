import java.util.Random;

public class QuizPage extends AbstractPage implements Scorable {
    private static final int TOTAL_QUESTIONS = 5;

    private final Random random = new Random();
    private int score;

    public QuizPage(InputReader input, VocabularyRepository repository) {
        super("Kuis Kosakata Jerman", input, repository);
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public int getTotal() {
        return TOTAL_QUESTIONS;
    }

    @Override
    protected void render() {
        score = 0; // reset tiap kuis baru

        if (getRepository().size() == 0) {
            System.out.println("Belum ada kosakata untuk dikuis. Tambah dulu ya.");
            return;
        }

        System.out.println("Jawab " + TOTAL_QUESTIONS + " soal berikut ya!\n");

        for (int i = 1; i <= TOTAL_QUESTIONS; i++) {
            Vocabulary vocab = getRepository().get(random.nextInt(getRepository().size()));

            boolean askArticle = vocab.hasArticle() && random.nextBoolean();

            if (askArticle) {
                askQuestion(i, "Apa artikel dari \"" + vocab.getGerman() + "\"? (der/die/das)", vocab.getArticle());
            } else {
                askQuestion(i, "Apa arti dari \"" + vocab.getFullGerman() + "\"?", vocab.getIndonesian());
            }
        }

        showResult();
    }

    private void askQuestion(int number, String question, String correctAnswer) {
        String answer = getInput().readLine("Soal " + number + ": " + question + "\n> ");
        if (answer.equalsIgnoreCase(correctAnswer)) {
            score++;
            System.out.println("Benar! \n");
        } else {
            System.out.println("Salah. Jawaban yang benar: " + correctAnswer + "\n");
        }
    }

    private void showResult() {
        int percent = score * 100 / getTotal();
        System.out.println("----------------------------------------");
        System.out.println("Skor kamu: " + score + "/" + getTotal() + " (" + percent + "%)");
        if (percent == 100) {
            System.out.println("Sehr gut! Sempurna!");
        } else if (percent >= 60) {
            System.out.println("Gut! Terus latihan ya.");
        } else {
            System.out.println("Ayo latihan lagi, pasti bisa!");
        }
    }
}
