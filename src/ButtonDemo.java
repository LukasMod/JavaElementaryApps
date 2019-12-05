import javax.swing.*; //pojawia się przy deklaracji zmiennej jlab typu JLabel
import java.awt.*; //pojawia się przy wyborze menadzera
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;   //pojawia się przy okazji implementacji interfejsu

public class ButtonDemo implements ActionListener {
    JLabel jlab;

    ButtonDemo() {
        //Tworzy kontener frame
        JFrame jfrm = new JFrame("Przykład przycisku");

        //Wybiera menadżera układu: FlowLayout
        jfrm.setLayout(new FlowLayout());

        //Nadaje oknu początkowe rozmiary
        jfrm.setSize(300, 100);

        //Aplikacja zakończy działanie na skutek zamknięcia okna
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Tworzy trzy przyciski
        JButton jbtnUp = new JButton("Góra");
        JButton jbtnDown = new JButton("Dół");
        JButton jbtnSpec = new JButton("Specjalny");

        //Dodaje obiekty nasłuchujące - obligatoryjnie z uwagi na implementację interfejsu ActionListener
        jbtnUp.addActionListener(this);
        jbtnDown.addActionListener(this);
        jbtnSpec.addActionListener(this);

        //Umieszcza przyciski w panelu zawartości
        jfrm.add(jbtnUp);
        jfrm.add(jbtnDown);
        jfrm.add(jbtnSpec);

        //Tworzy etykietę
        jlab = new JLabel("Naciśnij przycisk");

        //Dodaje etykietę do kontenera
        jfrm.add(jlab);

        //Wyświetla okbo
        jfrm.setVisible(true);
    }

    //Obsługa zdarzenia przycisków


    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Góra"))
            jlab.setText("Nacisnąłeś przycisk góra");
        if (ae.getActionCommand().equals("Dół"))
            jlab.setText("Nacisnąłeś przycisk dół");
        if (ae.getActionCommand().equals("Specjalny"))
            jlab.setText("Specjalne nic");

    }


    public static void main(String[] args) {
        //Tworzy okno w wątku rozdziału zdarzeń
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ButtonDemo();
            }
        });
    }
}
