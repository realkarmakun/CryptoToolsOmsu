package cryptotoolsomsu.tools;

public class Modulos {

    // a = b mod n
    long a;
    long b;
    long mod;

    public Modulos(long a, long mod){
        this.a = a;
        this.b = -1;
        this.mod = mod;
    }

    public Modulos(long a, long b, long mod) {
        this.a = a;
        this.b = b;
        this.mod = mod;
    }


    public long getA() {
        return this.a;
    }

    public long getB() {
        return this.b;
    }

    public long getMod() {
        return this.mod;
    }

    public void setA(long a) {
        this.a = a;
    }

    public void setB(long b) {
        this.b = b;
    }

    public void setMod(int mod) {
        this.mod = mod;
    }

    public Modulos exponentiation(int x) {
        Modulos result = new Modulos(this.a, this.b, this.mod);
        result.setB((long) ((Math.pow(result.getA(), x)) % result.getMod()));
        return result;
    }

    public void printModulus() {
        System.out.printf("%d = %d mod %d\n", this.a, this.b, this.mod);
    }


    public void printModulusAsIndex(int x) {
        System.out.printf("%d^%d = %d mod %d\n", this.a, x, this.b, this.mod);
    }


}
