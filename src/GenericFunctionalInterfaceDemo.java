class GenericFunctionalInterfaceDemo {
    public static void main(String[] args) {
        //to wyrażenie lambda sprawdza czy jedna liczba jest czynnikiem drugiej
        SomeTest<Integer> isFactor = (n, d) -> (n % d) == 0;
        if (isFactor.test(10, 2))
            System.out.println("Liczba 2 jest czynnikiem liczby 10");
        System.out.println();

        //to wyrażenie lambda sprawdza czy jedna liczba DOUBLE jest czynnikiem drugiej
        SomeTest<Double> isFactorD = (n, d) -> (n % d) == 0;
        if (isFactorD.test(10.2, 2.4))
            System.out.println("Liczba 2 jest czynnikiem liczby 10");
        System.out.println();

        //to wyrażenie lambda sprawdza czy jeden łańcuch znaków jest fragmentemm drugiego
        SomeTest<String> isIn = (a, b) -> a.indexOf(b) != -1;
          String str = "Sparametryzowany interfejs funkcyjny";
        System.out.println("Sprawdzamy łańcuch znakowy " + str);

        if(isIn.test(str, "fej"))
            System.out.println("Łańcuch 'fejs' został znaleziony");
        else
            System.out.println("Łańcuch 'fejs' nie został znaleziony");
    }
}
