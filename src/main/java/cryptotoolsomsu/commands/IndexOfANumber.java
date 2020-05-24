package cryptotoolsomsu.commands;

import cryptotoolsomsu.Modulos;
import cryptotoolsomsu.Utils;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "index-of-a-number", aliases = "idan", description = "Эта команда считает индекс числа a.")
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

        Modulos modulos = new Modulos();
        modulos.setA(this.a);
        modulos.setMod(this.modulos);

        // phi - будущая функция Эйлера
        // В этом цикле переберем все числа от 1 до phi(mod)
        for(int i = 1; i < Utils.eulerFunction(modulos.getMod()); i++) {
            //Посчитаем а в степени и выведем на экран
            modulos.Exponentiation(i);
            modulos.printModulusAsIndex(i, this.primitive && modulos.getB() == 1);
        }
        return 0;
    }
}
