class Sync {
    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5, 10, 100,8,5,6,5,8,5,6,8,5,6};
        MyThread2 mt1 = MyThread2.createAndStart("Wątek potomny nr 1", a);  //wątki uruchamiane w momencie tworzenia.
        // Można też oddzielić proces tworzenia od uruchamiania - tworzymy wtedy obiekt MyThread i wywołujemy metodą start()
        MyThread2 mt2 = MyThread2.createAndStart("Wątek potomny nr 2", a);
        try {
            mt1.thrd.join();
            mt1.thrd.setPriority(Thread.NORM_PRIORITY+5);
            mt2.thrd.join();
            mt1.thrd.setPriority(Thread.NORM_PRIORITY-4);

        } catch (InterruptedException exc) {
            System.out.println("Wątek główny został przerwany.");
        }

    }
}
