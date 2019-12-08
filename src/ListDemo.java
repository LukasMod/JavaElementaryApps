
//demonstruje prostą listę JList

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class ListDemo implements ListSelectionListener {

    JList<String> jlst;
    JLabel jlab;
    JScrollPane jscrlp;

    String names[] = {"Ewa", "Janina", "Robert", "Ewa2", "Janina2",
            "Robert2", "Ewa3", "Janina3", "Robert3",};

    ListDemo() {
        //Tworzy nowy kontener JFrame
        JFrame jfrm = new JFrame("Lista JList");

        //Wybiera FlowLayout jako menadżera układu
        jfrm.setLayout(new FlowLayout());

        //Nadaje oknu początkowe rozmiary
        jfrm.setSize(240, 160);

        //Aplikacja zakończy działanie na skutek zamknięcia okna
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Tworzy liste JList
        jlst = new JList<String>(names);

        //Określa tryb wyboru
        jlst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //tryb wyboru pojedynczy

        //Opakowuje listę kontenerem JScrollPane
        jscrlp = new JScrollPane(jlst);

        //Określe preferowany rozmiar kontenera przewijającego
        jscrlp.setPreferredSize(new Dimension(200, 90));

        //Tworzy etykietę
        jlab = new JLabel("Wybierz imię");

        //Dodaje obiekt nasłuchujący zdarzeń listy

        jlst.addListSelectionListener(this);

        //Umieszcza komponenty w panelu zawartości

        jfrm.add(jscrlp);
        jfrm.add(jlab);

        //Wyświetla okno
        jfrm.setVisible(true);
    }

    //Obsługa zdarzeń związanych z polami wyboru

    public void valueChanged (ListSelectionEvent le) {
       //pobiera indeks elementu
        int idx = jlst.getSelectedIndex();
        //Wyświetla imię, jeśli indeks został wybrany
        if (idx != -1)
            jlab.setText("Aktualny wybór: " + names[idx]);
        else
            jlab.setText("Wybierz imię");

    }


    public static void main(String[] args) {
        //Tworzy okno w wątku rozdziału zdarzeń
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ListDemo();
            }
        });
    }

}