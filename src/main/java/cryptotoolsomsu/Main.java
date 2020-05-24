package cryptotoolsomsu;

import cryptotoolsomsu.commands.Toolkit;
import picocli.CommandLine;

public class Main {
    public static void main(String... args) {
        int exitCode = new CommandLine(new Toolkit()).
                setExecutionExceptionHandler(new PrintExceptionMessageHandler()).execute(args);
        System.exit(exitCode);
    }
}
