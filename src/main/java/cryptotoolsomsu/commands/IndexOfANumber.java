package cryptotoolsomsu.commands;

import cryptotoolsomsu.tools.Exponents;
import cryptotoolsomsu.tools.Modulos;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "index-number", aliases = "idn", description = "Эта команда считает индекс числа a.")
public class IndexOfANumber implements Callable<Integer> {

    @CommandLine.Parameters(description = "Число, чьи показатели нужно посчитать.")
    int a;

    @CommandLine.Option(names = {"-m", "--mod"}, description = "Модуль необходимый задаче.", required = true)
    int modulos;

    @CommandLine.Option(names = {"-p", "--primitive"}, description = "Опция включающая поиск первообразного.")
    boolean primitive;

    @Override
    public Integer call() throws Exception {

        if (this.modulos <=0) {
            throw new Exception("ОШИБКА: Убедитесь что модуль больше нуля!");
        }

        Modulos masterMod = new Modulos(this.a, this.modulos);
        Exponents exponents = new Exponents(masterMod);
        exponents.printExponents();
        if (this.primitive) {
            exponents.printPrimitive();
        }

        return 0;
    }
}
