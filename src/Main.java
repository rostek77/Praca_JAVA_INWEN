import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {


    public static void main(String[] args) {
        System.out.println("Program do zarządzania inwentarzem");

        String csvFile = "src/inwentarz.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";


        try {
            long countOfLines = Files.lines(Paths.get(new File(csvFile).getPath())).count();

            Inwentarz inwentarz = new Inwentarz ((int) countOfLines - 1);

            br = new BufferedReader(new FileReader(csvFile));

            boolean pominPierwszaLinie = true;
            int sklepLinia = 0;
            while ((line = br.readLine()) != null) {
                if (pominPierwszaLinie) {
                    pominPierwszaLinie = false;
                    continue;
                }

                String[] slowo = line.split(cvsSplitBy);

                Towar towar = new Towar (
                        slowo[0].trim(),
                        slowo[1].trim(),
                        slowo[2].trim(),
                        slowo[4].trim(),
                        Integer.parseInt(slowo[3].trim()),
                        Integer.parseInt(slowo[5].trim())
                );

                inwentarz.dodajTowar(towar, sklepLinia);
                sklepLinia++;


            }

            inwentarz.wyswietlInwentarz();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}
