public class Inwentarz {

    private Towar[] spisTowar;

    Inwentarz(int liczba) {
        spisTowar = new Towar[liczba];
    }

    void dodajTowar(Towar towar, int index) {
        spisTowar[index] = towar;
    }

    public void wyswietlInwentarz() {
        for (int i = 0; i < spisTowar.length; i++) {
            spisTowar[i].wyswietlTowar();
            System.out.println();
        }
    }

    public boolean czySprzedane(String nazwa) {
        for (int i = 0; i < spisTowar.length; i++) {
            if (spisTowar[i].sprawdzNazwa(nazwa)) {
                return true;
            }
        }
        return false;
    }

    public int czySprzedaneID(String nazwa) {
        for (int i = 0; i < spisTowar.length; i++) {
            if (spisTowar[i].sprawdzNazwa(nazwa)) {
                return i;
            }
        }
        return -1;
    }

    public void sprzedajTowar(String nazwa) {
        int index = czySprzedaneID(nazwa);
        if (index != -1) {
            if (spisTowar[index].czySprzedane()) {
                System.out.println("Towar sprzedany.");
            } else {
                spisTowar[index].sprzedaj();
                spisTowar[index].wyswietlTowar();
            }
        } else {
            System.out.println("Nie mamy takiego towaru!");
        }
    }

    public void oddajTowar(String nazwa) {
        int index = czySprzedaneID(nazwa);
        if (index != -1) {
            spisTowar[index].oddaj();
        } else {
            System.out.println("Takiego towaru u nas nie ma");
        }
    }

}
