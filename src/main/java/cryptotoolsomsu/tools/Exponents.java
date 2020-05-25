package cryptotoolsomsu.tools;

import cryptotoolsomsu.Utils;

import java.util.ArrayList;

// Класс отвечающий за подсчет и вывод степеней a^x = b mod n
public class Exponents {
    // Поле которое имеет динамический массив сравнений (см. класс Modulos)
    // Мастер модуль является неининициализированным модулем (имеет в значение b -1)
    // На его основе будет построен массив с возведенными в exponent модулями (b будет подсчитано)
    // exponent - степень в которую будем возводить
    // primitive - перевообразный который получим согласно алгоритму
    public Modulos masterModulos;
    public long exponent;
    public int primitive = 0;
    public ArrayList<Modulos> modulosArray = new ArrayList<>();

    public Exponents(Modulos mod) {
        this.masterModulos = mod;
        this.exponent = Utils.eulerFunction(masterModulos.getMod());
        fillModulosArray();
    }

    private Modulos getModulos(int index) {
        return this.modulosArray.get(index);
    }

    private void setModulosByIndex(int index, Modulos mod) {
        this.modulosArray.add(index, mod);
    }

    private void addModulos(Modulos mod) {
        this.modulosArray.add(mod);
    }

    private Modulos getMaster() {
        return  this.masterModulos;
    }

    private void fillModulosArray() {
        Modulos master = this.getMaster();
        for(int i = 1; i < this.exponent + 1; i++) {
            //Посчитаем а в степени и выведем на экран
            this.addModulos(master.exponentiation(i));
            if (master.exponentiation(i).getB() == 1 && primitive == 0) {
                this.primitive = i;
            }
        }
    }

    public void printExponents() {
        for(int i = 0; i < modulosArray.size(); i++) {
            this.modulosArray.get(i).printModulusAsIndex(i+1);
        }
    }

    public void printPrimitive() {
        System.out.println("Первообразный: " );
        masterModulos.exponentiation(primitive).printModulusAsIndex(primitive);
    }

}
