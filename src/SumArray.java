public class SumArray {
    private int sum;

    synchronized int sumArray(int nums[]) {
        sum = 0;  //zeruje sumę
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            System.out.println(Thread.currentThread().getName() + " wyliczył sumę częściową równą " + sum);
            try {
                Thread.sleep(10);  //umożliwia przełączanie wątków
            } catch (InterruptedException exc) {
                System.out.println("Wątek został przerwany.");
            }
        }
        return sum;
    }
}
