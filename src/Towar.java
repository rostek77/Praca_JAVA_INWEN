public class Towar {
    private String producent;
    private String nazwa;
    private String rodzajTowaru;
    private String IDtowaru;
    private int cena;
    private int ilosc;

    Towar(String producent, String nazwa, String rodzajTowaru, String IDtowaru, int cena, int ilosc)
    {
        this.producent = producent;
        this.nazwa = nazwa;
        this.rodzajTowaru = rodzajTowaru;
        this.IDtowaru = IDtowaru;
        this.cena = cena;
        this.ilosc = ilosc;
        this.jestSprzedane = false;
    }

    private boolean jestSprzedane;

    public boolean czySprzedane() {
        return jestSprzedane;
    }

    public void sprzedaj() {
        jestSprzedane = true;
    }

    public void oddaj() {
        jestSprzedane = false;
    }

    public void wyswietlTowar() {
        System.out.println("Producent: " + producent);
        System.out.println("Nazwa: " + nazwa);
        System.out.println("ID Towaru: " + IDtowaru);
        System.out.println("Cena: " + cena);
        System.out.println("Rodzaj towaru: " + rodzajTowaru);
        System.out.println("Ilość towaru: " + ilosc);
    }

    public boolean sprawdzNazwa(String nazwa) {
        return this.nazwa == nazwa;
    }

}
