enum Transport {
    AUTO(150), TIR(100), SAMOLOT(800), KOLEJ(120), STATEK(30); // deklaracja wyliczenia
    private int speed; //typowa prędkość - dodaje zmienną instancji

    //Konstruktor
    Transport(int s) {
        speed = s;
    }

    //metoda
    int getSpeed() {
        return speed;

    }
}
