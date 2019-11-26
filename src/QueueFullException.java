class QueueFullException extends Exception{
    int size;
    QueueFullException(int s) {
        size = s;
    }
    public String toString() {
        return "\nKolejka pełna. Maksymalny rozmiar kolejki wynosi " + size;
    }
}
