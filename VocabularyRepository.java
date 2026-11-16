import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VocabularyRepository {
    private final List<Vocabulary> vocabularies = new ArrayList<>();

    public VocabularyRepository() {
        loadDefaultData();
    }

    private void loadDefaultData() {
        vocabularies.add(new Vocabulary("Hallo", "", "halo"));
        vocabularies.add(new Vocabulary("Danke", "", "terima kasih"));
        vocabularies.add(new Vocabulary("Tschüss", "", "dadah"));
        vocabularies.add(new Vocabulary("Guten Morgen", "", "selamat pagi"));
        vocabularies.add(new Vocabulary("Ich heiße", "", "nama saya"));
        vocabularies.add(new Vocabulary("Kaffee", "der", "kopi"));
        vocabularies.add(new Vocabulary("Wasser", "das", "air"));
        vocabularies.add(new Vocabulary("Brot", "das", "roti"));
        vocabularies.add(new Vocabulary("Milch", "die", "susu"));
        vocabularies.add(new Vocabulary("Apfel", "der", "apel"));
        vocabularies.add(new Vocabulary("Katze", "die", "kucing"));
    }

    public void add(Vocabulary vocabulary) {
        vocabularies.add(vocabulary);
    }

    public boolean exists(String german) {
        for (Vocabulary v : vocabularies) {
            if (v.getGerman().equalsIgnoreCase(german)) {
                return true;
            }
        }
        return false;
    }

    public Vocabulary get(int index) {
        return vocabularies.get(index);
    }

    public int size() {
        return vocabularies.size();
    }

    public List<Vocabulary> getAll() {
        return Collections.unmodifiableList(vocabularies);
    }
}
