package cryptotoolsomsu;

import picocli.CommandLine;

import java.util.ArrayList;

public class Utils {

    // Алгоритм найдет все простые множители n. Необходим для вычисления функции Эйлера по формуле.
    public static ArrayList<Integer> primeFactor(int n) {

        // Создадим массив для результатов.
        ArrayList<Integer> result = new ArrayList<>();

        //Этот цикл разделит n на два до тех пор пока не сможем.
        while (n % 2 == 0) {
            if (!(result.contains(2))) {
                result.add(2);
            }
            n = n / 2;
        }

        // Этот цикл удостоверяется что i не будет скакать до самого n
        // (тот факт что он не превышает корня из n доказуем)
        for (int i = 3; i <= Math.sqrt(n); i += 2) {

            // Делим на i пока не сможем
            while (n % i == 0) {
                if (!(result.contains(i))) {
                    result.add(i);
                }
                n = n / i;
            }
        }

        //Заберем оставшееся простое число
        if (n > 2) {
            result.add(n);
        }

        return result;
    }

    // Алгоритм для нахождения функции Эйлера
    public static int eulerFunction(int n) {

        // Берем все простые множители n
        ArrayList<Integer> arrayOfPrimitives = primeFactor(n);
        float eulerFunction = n;

        // Пробегаемся по формуле phi(n) = n * (1 - 1/p_1) * (1 - 1/p_2) * ..., где p_i - простой множитель числа n
        for (Integer arrayOfPrimitive : arrayOfPrimitives) {
            eulerFunction *= (1.0 - (1.0 / (float)arrayOfPrimitive));
        }

        return (int)eulerFunction;
    }

}
