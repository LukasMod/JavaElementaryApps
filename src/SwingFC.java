
//program porównujący pliki z interfejsem
//użytkownika wtkorzystującym Swing


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;

public class SwingFC implements ActionListener {
    JTextField jtfFirst;  //przechowuje nazwę pierwszego pliku
    JTextField jtfSecond;

    JButton jbtnComp; //przycisk porównania plików

    JLabel jlabFirst; //zachęta nr1
    JLabel jlabSecond; //zachęta nr2
    JLabel jlabResult; //wyświetla wynik i komunikat o błędach


    //konstruktor klasy Swing
    SwingFC() {
        //Tworzy nowy kontener JFrame
        JFrame jfrm = new JFrame("Porównywanie plików");

        //Wybiera FlowLayout jako menadżera układu
        jfrm.setLayout(new FlowLayout());

        //Nadaje oknu początkowe rozmiary
        jfrm.setSize(200, 190);

        //Aplikacja zakończy działanie na skutek zamknięcia okna
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Tworzy pola tekstowe do wprowadzania nazw plików
        jtfFirst = new JTextField(14);   //szerokość 14 kolumn (znaków)
        jtfSecond = new JTextField(14);

        //Konfiguruje tekst z tymi polami
        jtfFirst.setActionCommand("fileA");
        jtfSecond.setActionCommand("fileB");

        //Tworzy przycisk
        jbtnComp = new JButton("Porównaj");

        //Dodaje obiekty nasłuchujące - obligatoryjnie z uwagi na implementację interfejsu ActionListener
        jbtnComp.addActionListener(this);

        //Tworzy etykiety
        jlabFirst = new JLabel("Pierwszy plik: ");
        jlabSecond = new JLabel("Drugi plik: ");
        jlabResult = new JLabel("");

        //Umieszcza komponenty w panelu zawartości
        jfrm.add(jlabFirst);
        jfrm.add(jtfFirst);
        jfrm.add(jlabSecond);
        jfrm.add(jtfSecond);
        jfrm.add(jbtnComp);
        jfrm.add(jlabResult);

        //Wyświetla okno
        jfrm.setVisible(true);

    }

    //Porównuje pliki, gdy użytkownik naciśnie przycisk 'Porównaj'


    @Override
    public void actionPerformed(ActionEvent ae) {
        int i = 0, j = 0;
        //Najpierw sprawdza czy wprowadzone zostały nazwy obu plików
        if (jtfFirst.getText().equals("")) {
            jlabResult.setText("Brak nazwy pierwszego pliku");
            return;
        }
        if (jtfSecond.getText().equals("")) {
            jlabResult.setText("Brak nazwy drugiego pliku");
            return;
        }
        try (FileInputStream f1 = new FileInputStream(jtfFirst.getText());
             FileInputStream f2 = new FileInputStream(jtfSecond.getText())) {
            //Sprawdza zawartość każdego pliku
            do {
                i = f1.read();
                j = f2.read();
                if (i != j) break;
            } while (i != -1 && j != -1);
            if (i != j)

                jlabResult.setText("Pliki są różne");
            else
                jlabResult.setText("Pliki sa takie same");

        } catch (IOException exc) {
            jlabResult.setText("Błąd wejścia - wyjścia" + exc);
        }

    }

    public static void main(String[] args) {
        //Pliki do porównania należy umieścić w poniższym katalogu:
        System.out.println(System.getProperty("user.dir"));

        //Tworzy okno w wątku rozdziału zdarzeń
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SwingFC();
            }
        });

    }
}
