/** Strategy concreta: aceita se a linha tiver mais que N caracteres. */
public class FiltrarTamanho implements Filter {
    private final int minLengthExclusive;

    public FiltrarTamanho(int minLengthExclusive) {
        this.minLengthExclusive = minLengthExclusive;
    }

    @Override
    public boolean accepts(String query) {
        return query != null && query.length() > minLengthExclusive;
    }
}
