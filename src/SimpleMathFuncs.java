//kilka prostych funkcji matematycznych

class SimpleMathFuncs {
    //określa, czy a jest dzielnikiem b
    public static boolean isFactor(int a, int b) {
        if ((b % a) == 0) return true;
        return false;
    }

    //Zwraca namjmniejszy wspólny dzielnik
    public static int lcf(int a, int b) {
        //operujemy na liczbach dodatnich
        a = Math.abs(a);
        b = Math.abs(b);
        int min = a < b ? a : b;
        for (int i = 2; i <= min / 2; i++) {
            if (isFactor(i, a) && isFactor(i, b))
                return i;
        }
        return 1;
    }


    //Zwraca namjmniejszy wspólny dzielnik
    public static int gcf(int a, int b) {
        //operujemy na liczbach dodatnich
        a = Math.abs(a);
        b = Math.abs(b);
        int min = a < b ? a : b;
        for (int i = min / 2; i >= 2; i--) {
            if (isFactor(i, a) && isFactor(i, b))
                return i;
        }
        return 1;


    }
}
