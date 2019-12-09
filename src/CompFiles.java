//Porównuje oba pliki
//Uruchamiając, podaj w wierszu poleceń nazwy
//porównywanych plików

//java CompFile FIRST.TXT SECOND.TXT


import java.io.FileInputStream;
import java.io.IOException;

class CompFiles {
    public static void main(String[] args) {
        int i = 0, j = 0;

        //Upewnij się, że podano nazwy obu plików
        if (args.length != 2) {
            System.out.println("Sposób użycia: CompFiles plik1 plik2");
            return;
        }
        //Porówuje pliki
        try (FileInputStream f1 = new FileInputStream(args[0]);
             FileInputStream f2 = new FileInputStream(args[1])) {
            //Sprawdza zawartość każdego pliku
            do {
                i = f1.read();
                j = f2.read();
                if (i != j) break;
            } while (i != -1 && j != -1);
            if (i != j)
                System.out.println("Pliki różnią się");
                else
                System.out.println("Pliki sa takie same");

            }
        catch(IOException exc) {
            System.out.println("Błąd wejścia - wyjścia" + exc);
        }


    }
}
