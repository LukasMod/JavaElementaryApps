//wyjątek opróżniania kolejki

public class QueueEmptyException extends Exception {
    public String toString() {
        return "\nKolejka jest pusta.";
    }
}
