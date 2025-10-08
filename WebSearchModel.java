import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebSearchModel {

    private final File sourceFile;

    @FunctionalInterface
    public interface QueryObserver {
        void onQuery(String query);
    }

    // Nova estrutura: inscreve observer + filter
    private static record Subscription(QueryObserver observer, Filter filter) {}

    private final List<Subscription> subs = new ArrayList<>();

    public WebSearchModel(File sourceFile) {
        this.sourceFile = sourceFile;
    }

    // ✅ Compatibilidade: se alguém chamar a versão antiga, notifica sempre
    public void addQueryObserver(QueryObserver queryObserver) {
        addQueryObserver(queryObserver, q -> true);
    }

    // ✅ Novo overload: registra com filtro (Strategy)
    public void addQueryObserver(QueryObserver queryObserver, Filter filter) {
        subs.add(new Subscription(queryObserver, filter));
    }

    public void pretendToSearch() {
        try (BufferedReader br = new BufferedReader(new FileReader(sourceFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                processLine(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // enxuto: ignora vazias e comentários; aplica filtro e notifica
    private void processLine(String line) {
        if (line == null) return;
        String q = line.trim();
        if (q.isEmpty() || q.startsWith("#")) return;
        for (Subscription s : subs) {
            if (s.filter().accepts(q)) {
                s.observer().onQuery(q);
            }
        }
    }
}
