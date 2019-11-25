import org.w3c.dom.ls.LSOutput;

class TickTock {

    String state; //przechowuje stan zegara

    synchronized void tick(boolean running) {
        if (!running) { //zatrzymuje zegar
            state = "ticked";
            notify(); //powiadamia oczekujący wątek
            return;
        }
        System.out.println("tik");
        state = "ticked";  //zmienia stan zegara

        notify(); //umożliwia wykonanie drugiej metody (tock) ---  metoda tick() powiadamia metode tock()
        try {
            while(!state.equals("tocked"))
                wait(); //oczekuje na zakończenie metody tock() -- metoda tick() czeka na zakończenie tock()
        }
        catch (InterruptedException exc) {
            System.out.println("Wątek został przerwany");
        }
    }
    synchronized void tock(boolean running) {
        if (!running) { //zatrzymuje zegar
            state = "tocked";
            notify(); //powiadamia oczekujący wątek
            return;
        }
        System.out.println("tak");
        state = "tocked";  //zmienia stan zegara

        notify(); //umożliwia wykonanie drugiej metody (tock) ---  metoda tick() powiadamia metode tock()
        try {
            while(!state.equals("ticked"))
                wait(); //oczekuje na zakończenie metody tock() -- metoda tick() czeka na zakończenie tock()
        }
        catch (InterruptedException exc) {
            System.out.println("Wątek został przerwany");
        }
    }













}