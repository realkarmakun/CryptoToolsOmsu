package cryptotoolsomsu.commands;

import cryptotoolsomsu.tools.Exponents;
import cryptotoolsomsu.tools.Modulos;
import cryptotoolsomsu.Utils;
import picocli.CommandLine;

import java.util.ArrayList;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "residue-ring", aliases = "rr",
        description = "Находит первообразный корень в кольце вычетов.")
public class IndexInResidueRing implements Callable<Integer> {
    @CommandLine.Parameters(description = "Порядок кольца вычетов.")
    int p;

    @CommandLine.Option(names = {"-e", "--example"}, required = true,
            description = "Опция чтобы использовать известное число, которое дается в задаче 'Например'")
    int example;

    @Override
    public Integer call() throws Exception {

        // Проверка корректности значений
        if (p <= 0) {
            throw new Exception("ОШИБКА: Порядок кольца вычетов не может быть меньше или равен нулю!");
        }

        // Еще проверки корректности, но требующие знания простых множителей
        ArrayList<Long> testP = Utils.primeFactor(p);
        if (testP.size() != 1) {
            throw new Exception("ОШИБКА: Порядок вашего кольца вычетов не соот-ет теореме Гаусса!");
        }

        // Вычислим значение модуля меньшей степени
        int mod = (int)Math.pow(testP.get(0), example);

        System.out.printf("По теореме, вашими корнями могут быть: %d либо (%d+%d), по модулю %d\n",
                example, example, testP.get(0), mod);
        System.out.printf("Следовательно оно будет первообразным корнем по модулю %d (Согласно второй теореме)\n", p);

        // Вычислим значение функции Эйлера для модуля меньшей степени
        long phi =  Utils.eulerFunction(mod);

        System.out.printf("Вычислим значения фи(%d) = %d\n", mod, phi);

        // Поиск первообразного среди степеней
        System.out.println("Вычислим степени:");
        Modulos masterMod = new Modulos(this.example, mod);
        Exponents exponents = new Exponents(masterMod);
        exponents.printExponents();

        return 0;
    }



}
