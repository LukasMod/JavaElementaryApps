
//prosty program wykorzystujący Swing

import javax.swing.*;

public class SwingDemo {

    SwingDemo() {
        //Tworzy nowy kontener Frame
        JFrame jfrm = new JFrame("Prosta aplikacja Swing");

        //Nadaje ramce początkowe rozmiary
        jfrm.setSize(275, 100);

        //Kończy działanie programu, gdy użytkownik zamknie aplikację
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Tworzy etykietę tekstową
        JLabel jlab = new JLabel("Programowanie z użyciem biblioteki Swing.");

        //Umieszcza etykietę w panelu zawartości
        jfrm.add(jlab);

        //Wyświetla okno
        jfrm.setVisible(true);

    }

    public static void main(String[] args) {

        //Tworzy ramkę w wątku rozdziału zdarzeń
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SwingDemo();  //Obiekt SwingDemo musi zostać utworzony w wątku rozdziału zdarzeń
            }
        });


    }
}
