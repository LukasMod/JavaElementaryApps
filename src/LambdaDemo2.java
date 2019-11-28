class LambdaDemo2 {

    public static void main(String[] args) {
        //to wyrażenie lambda sprawdza czy jedna liczba jest czynnikiem drugiej
        NumericTest isFactor = (n, d) -> (n % d) == 0;
        if (isFactor.test(10, 2))
            System.out.println("Liczba 2 jest czynnikiem liczby 10");
        if (!isFactor.test(10, 3))
            System.out.println("Liczba 3 nie jest czynniekiem liczby 10");
        System.out.println();

        //to wyrażenie lambda zwraca true, jeśli pierwszy argument jest mniejszy od drugiego
        NumericTest lessThan = (n, m) -> (n < m);
        if (lessThan.test(2, 10))
            System.out.println("Liczba 2 jest mniejsza od liczby 10");
        if (!lessThan.test(10, 2))
            System.out.println("Liczba 10 nie jest mniejsza od liczby 2");
        System.out.println();

        //to wyraniżenie lambda zwraca true, jeśli wartości bezwzględne argumentów są sobie równe
        NumericTest absEqual = (n, m) -> (n < 0 ? -n : n) == (m < 0 ? -m : m);
        // '?' oznacza wyrażnie ? wart. jesli prawda : wart. jesli fałsz
        if (absEqual.test(-4, 4))
            System.out.println("Wartości bezwględne 4 i -4 są równe");
        if (!absEqual.test(4, -5))
            System.out.println("wartości bezględne 4 i -5 nie są równe");

        System.out.println();


        //Blokowe wyrażenie lambda znajdujące najmniejszy dodatni czynnik wartości typu int

        NumericTest2 smallestF = (n) -> {
            int result = 1;
            //określa wartość bezwględną n
            n = n < 0 ? -n : n;
            for (int i = 2; i <= n / i; i++)
                if ((n % i) == 0) {
                    result =  i;
                    break;
                }
            return result;
        };    //ważny dwukropek
        System.out.println("Najmniejszym czynnikiem liczby 12 jest " + smallestF.func(12));
        System.out.println("Najmniejszym czynnikiem liczby 9 jest " + smallestF.func(9));

    }

}
