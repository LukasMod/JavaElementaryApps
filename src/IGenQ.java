//sparametryzowany interfejs kolejki

public interface IGenQ<T> {
    //umieszcza elementy w kolejce
    void put (T ch) throws QueueFullException; //umieszcza element w kolejce
    //pobiera elemnt kolejki
    T get() throws QueueEmptyException;
}
