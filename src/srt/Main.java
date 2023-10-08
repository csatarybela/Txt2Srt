package srt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<IdozitettFelirat> feliratok = new ArrayList<>();

    public static void main(String[] args) {
        try {
            beolvas();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("5. feladat: Feliratok száma: " + feliratok.size());
        System.out.println("7. feladat: Legtöbb szóból álló felirat:");
        System.out.println(legtobbSzobolAlloFelirat());
        try {
            keszitSrtFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void keszitSrtFile() throws IOException {
        FileWriter fw = new FileWriter("felirat.srt");
        for (int i = 0; i < feliratok.size(); i++) {
            fw.write((i + 1) + "\n");
            fw.write(feliratok.get(i).srtIdozites() + "\n");
            fw.write(feliratok.get(i).getFelirat() + "\n\n");
        }
        fw.close();
    }

    private static String legtobbSzobolAlloFelirat() {
        String lh = "";
        int maxSzo = 0;
        for (IdozitettFelirat id : feliratok) {
            if (id.szavakSzama() > maxSzo) {
                lh = id.getFelirat();
                maxSzo = id.szavakSzama();
            }
        }
        return lh;
    }

    private static void beolvas() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("feliratok.txt"));
        String sor;
        while ((sor = br.readLine()) != null) {
            String sor2 = br.readLine();
            IdozitettFelirat tmp = new IdozitettFelirat(sor, sor2);
            feliratok.add(tmp);
        }
        br.close();
    }
}
