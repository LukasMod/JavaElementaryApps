class LambdaArgumentDemo {
    //W tej metodzie typem pierwszym parametru jest interfejs
    //funkcyjny. Oznacza to, że można do niego przekazać dowolną
    //referencję instacji tego typ, w tym także instacji
    //utworzonej przy użyciu wyrażenia lambda. Drugi parametr
    //określa łańcuch znakowy, na którym nalezy operować.

    static String changeStr(StringFunc sf, String s) {
        return sf.func(s);
    }

    public static void main(String[] args) {
        String inStr = "Wyrażenia lambda rozszerzają możliwości Javy";
        String outStr;
        System.out.println("Łańcuch  wejściowy: " + inStr);

        //definiuje wyrażenie lambda, ktore odwraca kolejność
        //znaków w łańcuchu i zapisuje je w zmiennej referencyjnej
        //typu StringFunc

        StringFunc reverse = (str) -> {
            String result = "";
            for (int i = str.length() - 1; i >= 0; i--)
                result += str.charAt(i);
            return result;
        };

        //przekazuje wartość zmiennej reverse jako pierwszy argument
        //wywołania metody changeStr()
        //Drugim argumentem jest wejściowy łańcuch znaków

        outStr = changeStr(reverse, inStr);
        System.out.println("Odwrócony łańcuch znakowy: " + outStr);

        //to wyrażenie lambda zmienia znaki odstępu na minusy
        // Podano je bezpośrednio w wywoływaniu metody changeStr()

        outStr = changeStr((str) -> str.replace(' ', '-'), inStr);
        System.out.println("Łańcuch z zamienionymi odstępami: " + outStr);

        //to blokowe wyrażenie lambda zmienia małe litery na wielkie
        //i wielkie na małe. Także ono zostało bezpośrednio podane
        //w wywołaniu metody changeStr

        outStr = changeStr((str) -> {
            String result = "";
            char ch;
            for (int i = 0; i < str.length(); i++) {
                ch = str.charAt(i);
                if (Character.isUpperCase(ch))
                    result += Character.toLowerCase(ch);
                else
                    result += Character.toUpperCase(ch);
            }
            return result;
        }, outStr);
        System.out.println("Łańcuch ze zmienioną wielkością liter: " + outStr);
    }
}
