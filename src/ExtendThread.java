public class ExtendThread {
    public static void main(String args[]) {
        System.out.println("Główny wątek rozpoczyna działania");
        MyThread mt = new MyThread("Wątek potomny nr 1");

        mt.start();

        for (int i = 0; i < 50; i++) {
            System.out.print(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException exc) {
                System.out.println("Wątek główny został przerwany.");
            }
        }
            System.out.println("Wątek główny kończy działanie.");


    }

}
