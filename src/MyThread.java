class MyThread extends Thread{
    //Tworzy nowy wątek
    MyThread (String name) {
        super(name); //nadanie nazwy
    }

    //Rozpoczyna wykonywanie nowego wątku
    public void run() {
        System.out.println(getName() + " rozpoczyna działanie.");
        try {
            for(int count = 0; count < 10; count ++) {
                Thread.sleep(400);
                System.out.println(getName() + " jest wykonywany, wartość licznika " + count);
            }
        }
        catch(InterruptedException exc) {
            System.out.println(getName() + " został przerwany.");
        }
        System.out.println(getName() + " kończy działanie.");
    }

}
