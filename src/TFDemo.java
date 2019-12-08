//używa pola tekstowego

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TFDemo implements ActionListener {
    JTextField jtf;
    JButton jbtnRev;
    JLabel jlabPromt, jlabContents;

    TFDemo() {
        //Tworzy nowy kontener JFrame
        JFrame jfrm = new JFrame("Pole tekstowe");

        //Wybiera FlowLayout jako menadżera układu
        jfrm.setLayout(new FlowLayout());

        //Nadaje oknu początkowe rozmiary
        jfrm.setSize(240, 120);

        //Aplikacja zakończy działanie na skutek zamknięcia okna
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Tworzy pole tekstowe
        jtf = new JTextField(10);   //szerokość 10 kolumn (znaków)

        //Konfiguruje tekst związany z polem tekstowym
        jtf.setActionCommand("myTF");  //wiąże tekst z polem tekstowym

        //Tworzy przycisk Odwróć
        jbtnRev = new JButton("Odwróć");

        //Dodaje obiekty nasłuchujące zdarzeń
        jtf.addActionListener(this);
        jbtnRev.addActionListener(this);

        //Tworzy etykiety
        jlabPromt = new JLabel("Wprowadź tekst: ");
        jlabContents = new JLabel("");

        //Umieszcza komponenty w panelu zawartości
        jfrm.add(jlabPromt);
        jfrm.add(jtf);
        jfrm.add(jbtnRev);
        jfrm.add(jlabContents);

        //Wyświetla okno
        jfrm.setVisible(true);
    }

    //Obsługa zdarzeń ActionEvent
    @Override
    public void actionPerformed(ActionEvent ae) {   //ta metoda obsługuje zdarzenia związane z przyciskiem i polem tekstowym
        if (ae.getActionCommand().equals("Odwróć")) {   // wykorzystanie tekstu związanego z komponentem pozwala ustalić źródło zdarzenia
            //Przycisk "Odwróć" został naciśnięty
            String orgStr = jtf.getText();
            String resStr = "";
            //Odwaraca zawartość pola tekstowego
            for (int i = orgStr.length() - 1; i >= 0; i--)
                resStr += orgStr.charAt(i);
            //Umieszcza odwrócony łańcuch w polu tekstowym
            jtf.setText(resStr);

        } else
            //Użytkownik nacisnął 'Enter' podczas wprowadzania
            //tekstu w polu tekstowym
            jlabContents.setText("Nacisnąłeś Enter. Teskt: " + jtf.getText());
    }

    public static void main(String[] args) {
        //Tworzy okno w wątku rozdziału zdarzeń
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TFDemo();
            }
        });
    }

}