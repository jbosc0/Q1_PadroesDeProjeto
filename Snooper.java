import java.io.File;

public class Snooper {
    public static void main(String[] args) {
        // Se passar caminho por argumento usa arquivo externo; senão, usa Hamlet.txt da pasta do projeto
        File source = (args.length > 0) ? new File(args[0]) : new File("Hamlet.txt");

        WebSearchModel model = new WebSearchModel(source);

        // 1) contém "friend" (case-insensitive, sem acento) -> "Oh Yes! ..."
        model.addQueryObserver(
            q -> System.out.println("Oh Yes! " + q),
            new FiltrarPalavra("friend")
        );

        // 2) mais de 60 caracteres -> "So long ..."
        model.addQueryObserver(
            q -> System.out.println("So long " + q),
            new FiltrarTamanho(60)
        );

        model.pretendToSearch();
    }
}
