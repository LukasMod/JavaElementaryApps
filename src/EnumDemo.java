class EnumDemo {
    public static void main(String[] args) {
        Transport tp, tp1, tp2;  //deklaracja referencji typu Transport;
        tp = Transport.SAMOLOT; //przypisanie zmiennej tp stałej typu Tranpsort
        tp1 = Transport.KOLEJ;
        tp2 = Transport.TIR;


        System.out.println("Wartość zmiennej tp: " + tp);

        //porównuje wartości typu wyliczeniowego
        if (tp != Transport.KOLEJ)  //portównuje dwa obiekty typu transport
            System.out.println("tp nie ma wartość TRAIN.\n");
// używa zmiennej typu wyliczeniowego do sterowania instrukcją switch

        switch (tp) {
            case AUTO:
                System.out.println("auto");
                break;
            case TIR:
                System.out.println("tir");
                break;
            case SAMOLOT:
                System.out.println("samolot");
                break;
            case KOLEJ:
                System.out.println("kolej");
                break;
            case STATEK:
                System.out.println("statek");
                break;
        }

        System.out.println("Wszystkie stałe typu transport: ");

        //używa metody values()
        Transport allTransports[] = Transport.values();
        for (Transport t : allTransports) //rozszerzona pętla for (lub inaczej zwana foreach) - sprawdza całą tablicę
            System.out.println(t);

        System.out.println();

        //używa metody valueOf()
        tp = Transport.valueOf("AUTO"); //pobiera wartość stałej wyliczeniwoej
        System.out.println("tp ma wartość " + tp);

        //użycie konstruktora i gettera prędkości
        System.out.println("Prędkość samolotu to: " + Transport.SAMOLOT.getSpeed() + " km/h");

//wszystkie środki tranpsortu i ich prędkości
        for (Transport t : Transport.values())
            System.out.println(t + " " + t.getSpeed() + " km/h");
//pobiera wartości porządkowe za pomocą metody ordinal ();
        System.out.println("Oto stałe wyliczeniowe typu Tranpsort i ich wartości porządkowe: ");
        for (Transport t : Transport.values())
            System.out.println(t + " " + t.ordinal());
        System.out.println("tp: " + tp + "\ntp1: " + tp1 + "\ntp2: " + tp2);

        //metoda compareTo()
        if(tp.compareTo(tp2) <0)
            System.out.println(tp + " poprzedza " + tp2);
    }
}

