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

    }

}
