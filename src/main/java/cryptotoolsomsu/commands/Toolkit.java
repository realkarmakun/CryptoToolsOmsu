package cryptotoolsomsu.commands;

import picocli.CommandLine;


@CommandLine.Command(name = "toolkit", subcommands = {
        IndexOfANumber.class
})
public class Toolkit {
    // Это пустой класс который отвечает за родительскую команду toolkit. Сам по себе ничего не делает.
}
