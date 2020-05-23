package cryptotoolsomsu;

import java.util.ArrayList;

public class Utils {
    // Класс для общих алгоритмов
    // TO-DO по порядку:
    // 1. Prime Factor
    // 2. НОД
    // 3. Функция Эйлера

    // Алгоритм найдет все простые множители n. Необходим для вычисления функции Эйлера по формуле.
    public ArrayList<Integer> primeFactor(int n) {

        // Создадим массив для результатов.
        ArrayList<Integer> result = new ArrayList<>();

        //Этот цикл разделит n на два до тех пор пока не сможем.
        while (n % 2 == 0) {
            result.add(2);
            n = n / 2;
        }

        // Этот цикл удостоверяется что i не будет скакать до самого n
        // (тот факт что он не превышает корня из n доказуем)
        for (int i = 3; i <= Math.sqrt(n); i += 2) {

            // Делим на i пока не сможем
            while (n % i == 0) {
                result.add(i);
                n = n / i;
            }
        }

        return result;
    }



}
