class MyThread2 implements Runnable {
    Thread thrd; //zmienna thrd przechowuje referencję wątku
    static SumArray sa = new SumArray();
    int a[];
    int answer;

    //tworzy nowy wątek dzięki implementacji Runnable
    MyThread2(String name, int nums[]) {
        thrd = new Thread(this, name); //w momencie tworzenia wątek otrzymuje nazwę
        a = nums;
    }

    //metoda wytwórcza, która tworzy i uruchamia wątek
    public static MyThread2 createAndStart(String name, int nums[]) {
        MyThread2 myThrd = new MyThread2(name, nums);
        myThrd.thrd.start(); // uruchamia wątek
        return myThrd;
    }

    //Rozpoczyna wykonywanie nowego wątku
    public void run() {
        int sum;
        System.out.println(thrd.getName() + " rozpoczyna działanie.");
        answer = sa.sumArray(a);
        System.out.println(thrd.getName() + " wyliczył sumę równą " + answer);
        System.out.println(thrd.getName() + " kończy działanie.");
    }


}
