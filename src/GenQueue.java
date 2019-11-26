//sparametryzowana klasa kolejki o stałym rozmiarze

class GenQueue<T> implements IGenQ<T> {
    private T q[];  //tablica przechowująca elementy kolejki
    private int putloc, getloc; //indeksy operacji put i get

    //Tworzy kolejkę wykorzystującą tablicę aRef
    public GenQueue(T[] aRef) {
        q = aRef;
        putloc = getloc = 0;
    }

    //Umieszcza element w kolejce
    public void put (T obj) throws QueueFullException {
        if (putloc == q.length)
            throw new QueueFullException(q.length);
        q[putloc++] = obj;
    }

    //Pobiera element z kolejki
    public T get() throws QueueEmptyException {
if (getloc == putloc)
throw new QueueEmptyException();
return q[getloc++];
    }
}
