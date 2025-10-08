import java.text.Normalizer;
import java.util.Locale;

/** Strategy concreta: aceita se a linha tiver a palavra (case-insensitive, sem acento). */
public class FiltrarPalavra implements Filter {
    private final String needleNorm;

    public FiltrarPalavra(String needle) {
        this.needleNorm = normalize(needle).toLowerCase(Locale.ROOT);
    }

    @Override
    public boolean accepts(String query) {
        if (query == null) return false;
        String s = normalize(query.trim()).toLowerCase(Locale.ROOT); // trim evita falsos negativos
        return s.contains(needleNorm);
    }

    private static String normalize(String s) {
        if (s == null) return null;
        String norm = Normalizer.normalize(s, Normalizer.Form.NFD);
        return norm.replaceAll("\\p{M}", "");
    }
}
