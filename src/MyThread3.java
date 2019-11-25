class MyThread3 implements Runnable {

    Thread thrd;
    TickTock ttOb;

    //Tworzy nowy wątek
    MyThread3(String name, TickTock tt) {
        thrd = new Thread(this, name);
        ttOb = tt;
    }

    //Metoda wytwórcza, która tworzy i uruchamia wątek
    public static MyThread3 createAndStart(String name, TickTock tt) {
        MyThread3 myThrd = new MyThread3(name, tt);
        myThrd.thrd.start(); //uruchamia nowy wątek
        return myThrd;
    }
    //Rozpoczyna wykonywanie nowego wątku

    public void run() {
        if (thrd.getName().compareTo("tik") == 0) {
            for (int i = 0; i < 5; i++) ttOb.tick(true);
            ttOb.tick(false);
        } else {
            for (int i = 0; i < 5; i++) ttOb.tock(true);
            ttOb.tock(false);

        }
    }

}
