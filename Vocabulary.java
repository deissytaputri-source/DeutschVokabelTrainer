public class Vocabulary {
    private final String german;      //kata Jerman tanpa artikel, contoh: Kaffee
    private final String article;     // der/ die/ das, kosong kalau bukan kata benda
    private final String indonesian;  // arti dalam bahasa Indonesiany

    public Vocabulary(String german, String article, String indonesian) {
        this.german = german;
        this.article = article;
        this.indonesian = indonesian;
    }

    public String getGerman() {
        return german;
    }

    public String getArticle() {
        return article;
    }

    public String getIndonesian() {
        return indonesian;
    }

    public boolean hasArticle() {
        return !article.isEmpty();
    }

    public String getFullGerman() {
        if (hasArticle()) {
            return article + " " + german;
        }
        return german;
    }

    public static boolean isValidArticle(String article) {
        return article.equalsIgnoreCase("der")
                || article.equalsIgnoreCase("die")
                || article.equalsIgnoreCase("das");
    }
}
