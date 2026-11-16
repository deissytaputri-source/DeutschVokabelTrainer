public class AddVocabularyPage extends AbstractPage {

    public AddVocabularyPage(InputReader input, VocabularyRepository repository) {
        super("Tambah Kosakata Baru", input, repository);
    }

    @Override
    protected void render() {
        String german = getInput().readLine("Kata Jerman (tanpa artikel): ");
        String article = getInput().readLine("Artikel (der/die/das, ketik - kalau tidak ada): ");
        String indonesian = getInput().readLine("Arti dalam bahasa Indonesia: ");

        if (german.isEmpty() || indonesian.isEmpty()) {
            System.out.println("\nKata dan arti tidak boleh kosong. Kosakata tidak disimpan.");
            return;
        }
        if (article.equals("-")) {
            article = "";
        } else if (!Vocabulary.isValidArticle(article)) {
            System.out.println("\nArtikel harus der, die, atau das. Kosakata tidak disimpan.");
            return;
        }
        if (getRepository().exists(german)) {
            System.out.println("\nKata \"" + german + "\" sudah ada di daftar.");
            return;
        }

        Vocabulary vocab = new Vocabulary(german, article.toLowerCase(), indonesian);
        getRepository().add(vocab);

        System.out.println("\n+--------------------------------+");
        System.out.println("  Jerman : " + vocab.getFullGerman());
        System.out.println("  Arti   : " + vocab.getIndonesian());
        System.out.println("+--------------------------------+");
        System.out.println("Kosakata berhasil disimpan ke daftar sesi ini.");
    }
}
