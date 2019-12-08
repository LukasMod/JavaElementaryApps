//demonstruje pola wyboru

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CBDemo implements ItemListener {


    JLabel jlabSelected, jlabChanged;
    JCheckBox jcbAlpha, jcbBeta, jcbGamma;

    CBDemo() {
        //Tworzy nowy kontener JFrame
        JFrame jfrm = new JFrame("Demonstruje pola wyboru e");

        //Wybiera FlowLayout jako menadżera układu
        jfrm.setLayout(new FlowLayout());

        //Nadaje oknu początkowe rozmiary
        jfrm.setSize(280, 120);

        //Aplikacja zakończy działanie na skutek zamknięcia okna
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Tworzy etykiety
        jlabSelected = new JLabel("");
        jlabChanged = new JLabel("");

        //Tworzy pole wyboru
        jcbAlpha = new JCheckBox("Alpha");
        jcbBeta = new JCheckBox("Beta");
        jcbGamma = new JCheckBox("Gamma");

        //Zdarzenia generowane przez pola wyboru
        //są obsługiwane wspólnie przez metodę itemStateChanged()
        //implementowaną przez klase CBDemo

        jcbAlpha.addItemListener(this);
        jcbBeta.addItemListener(this);
        jcbGamma.addItemListener(this);

        //Umieszcza komponenty w panelu zawartości
        jfrm.add(jcbAlpha);
        jfrm.add(jcbBeta);
        jfrm.add(jcbGamma);
        jfrm.add(jlabChanged);
        jfrm.add(jlabSelected);


        //Wyświetla okno
        jfrm.setVisible(true);
    }

    //Obsługa zdarzeń związanych z polami wyboru

    public void itemStateChanged(ItemEvent ie) {
        String str = "";

        //pobiera referencję pola wyboru
        //które wygenerowało zdarzenie

        JCheckBox cb = (JCheckBox) ie.getItem(); //pobiera referencję, aby sprawdzic, które pole wyboru zmieniło stan
        //Informuje, które z pol wyboru zmieniło stan
        if(cb.isSelected())   // sprawdza jakie zdarzenie miało miejsce
            jlabChanged.setText(cb.getText() + " zostało zaznaczone.");
        else
            jlabChanged.setText(cb.getText() + ": zaznaczenie zostąło usunięte.");

        //informuje, które pola są wybrane
        if(jcbAlpha.isSelected()) {
            str += "Alpha";
        }
        if(jcbBeta.isSelected()) {
            str += "Beta";
        }
        if(jcbGamma.isSelected()) {
            str += "Gamma";
        }
        jlabSelected.setText("Te pola są wybrane: " + str);
    }


    public static void main(String[] args) {
        //Tworzy okno w wątku rozdziału zdarzeń
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CBDemo();
            }
        });
    }

}