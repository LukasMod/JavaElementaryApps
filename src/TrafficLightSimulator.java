class TrafficLightSimulator implements Runnable {
    //skomputeryzowana sygnalizacja świetlna
    private TrafficLightColor tlc; //przechowuje bieżący kolor światła
    boolean stop = false; //wartość true zatrzymuje symulację
    boolean changed = false; //ma wartość true gdy światło się zmieniło

    TrafficLightSimulator(TrafficLightColor init) {   //konstruktor określa początkowy kolor światła
        tlc = init;
    }

    TrafficLightSimulator() {   //konstruktor określa domyślny kolor  światła
        tlc = TrafficLightColor.CZERWONE;
    }

    //rozpoczęcie symulacji
    public void run() {
        while (!stop) {
            try {
                switch (tlc) {
                    case ZIELONE:
                        Thread.sleep(1000);
                        break;
                    case ZOLTE:
                        Thread.sleep(200);
                        break;
                    case CZERWONE:
                        Thread.sleep(1200);
                        break;
                }
            } catch (InterruptedException exc) {
                System.out.println(exc);
            }
            changeColor();
        }
    }

    //zmienianie kolorów
    synchronized void changeColor() {
        switch (tlc) {
            case CZERWONE:
                tlc = TrafficLightColor.ZIELONE;
                break;
            case ZOLTE:
                tlc = TrafficLightColor.CZERWONE;
                break;
            case ZIELONE:
                tlc = TrafficLightColor.ZOLTE;
                break;
        }


        changed = true;

        notify(); //sygnalizuje że światło się zmieniło
    }
//czeka na zmianę światła
    synchronized void waitForChange() {
        try {
            while (!changed)
                wait(); //czeka na zmianę światła
            changed = false;
        }
        catch (InterruptedException exc) {
            System.out.println(exc);
        }
    }
    //zwraca biężący kolor światła
    synchronized TrafficLightColor getColor() {
        return tlc;
    }

    //zatrzymuje sygnalizację
    synchronized void cancel () {
        stop = true;
    }
}
