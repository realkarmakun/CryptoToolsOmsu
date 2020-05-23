package cryptotoolsomsu;

import cryptotoolsomsu.commands.IndexOfANumber;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

public class Main {
    public static void main(String... args) {
        int exitCode = new CommandLine(new IndexOfANumber()).
                setExecutionExceptionHandler(new PrintExceptionMessageHandler()).execute(args);
        System.exit(exitCode);
    }
}
