//sparametryzowana klasa kolejki

import java.util.Queue;

class GenQDemo {
    public static void main(String[] args) {
        //Tworzy kolejkę przechowującą wartości całkowite
        Integer iStore[] = new Integer[10];
        GenQueue<Integer> q = new GenQueue<>(iStore);

        Integer iVal;
        System.out.println("Demonstruję kolejkę elementów typu Integer.");

        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Wstawiam " + i + " do kolejki q.");
                q.put(i); //umieszcza wartość 'i' w kolejce 'q'
            }
        } catch (QueueFullException exc) {
            System.out.println(exc);
        }
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Pobieram następny element typu Integer z kolejki q: ");
                iVal = q.get();
                System.out.println(iVal);
            }
        } catch (QueueEmptyException exc) {
            System.out.println(exc);
        }
        System.out.println();

        //Tworzy kolejkę elementów typu Double

        Double dStore[] = new Double[10];
        GenQueue<Double> q2 = new GenQueue<>(dStore);

        Double dVal;
        System.out.println("Demonstruję kolejkę elementów typu Double.");

        try {
            for (double i = 0.1; i < 5.5; i++) {
                System.out.println("Wstawiam " + i + " do kolejki q2.");
                q2.put(i); //umieszcza wartość 'i' w kolejce 'q'
            }
        } catch (
                QueueFullException exc) {
            System.out.println(exc);
        }
        try {
            for (double i = 0.1; i < 5.5; i++) {
                System.out.println("Pobieram następny element typu Double z kolejki q2: ");
                dVal = q2.get();
                System.out.println(dVal);
            }
        } catch (QueueEmptyException exc) {
            System.out.println(exc);
        }
    }
}