class ThreadCom {

    public static void main(String[] args) {
        TickTock tt = new TickTock();
        MyThread3 mt1 = MyThread3.createAndStart("tik",tt);
        MyThread3 mt2 = MyThread3.createAndStart("tak",tt);

                try {
                    mt1.thrd.join();
                    mt2.thrd.join();
                }
                catch (InterruptedException exc){
                    System.out.println("Wątek główny został przerwany");
                }

    }
}
