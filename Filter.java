@FunctionalInterface
public interface Filter {
    /** Retorna true se a linha/consulta deve notificar o observador. */
    boolean accepts(String query);
}
