package cryptotoolsomsu;

public class Modulos {

    // a = b mod n
    int a;
    int b;
    int mod;

    public Modulos(){
        this.a = -1;
        this.b = -1;
        this.mod = -1;
    }

    public Modulos(int a, int b, int mod) {
        this.a = a;
        this.b = b;
        this.mod = mod;
    }


    public int getA() {
        return this.a;
    }

    public int getB() {
        return this.b;
    }

    public int getMod() {
        return this.mod;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void setMod(int mod) {
        this.mod = mod;
    }

    public void exponentiation(int x) {
        this.setB(((int)Math.pow(this.getA(),x)) % this.getMod());
    }

    public void printModulus(boolean primitive) {
        System.out.printf("%d = %d mod %d\n", this.a, this.b, this.mod);
    }


    public void printModulusAsIndex(int x, boolean primitiveOutput) {
        if (primitiveOutput) {
            System.out.printf("[ПЕРВООБРАЗНЫЙ] %d^%d = %d mod %d\n", this.a, x, this.b, this.mod);
        } else {
            System.out.printf("%d^%d = %d mod %d\n", this.a, x, this.b, this.mod);
        }
    }


}
