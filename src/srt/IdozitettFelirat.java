package srt;

public class IdozitettFelirat {
    private String idozites;
    private String felirat;

    public IdozitettFelirat(String idozites, String felirat) {
        this.idozites = idozites;
        this.felirat = felirat;
    }

    public String getIdozites() {
        return idozites;
    }

    public String getFelirat() {
        return felirat;
    }

    public int szavakSzama() {
        int darab = 0;
        for (int i = 0; i < felirat.length(); i++) {
            if (felirat.charAt(i) == ' ') {
                darab++;
            }
        }
        return darab + 1;
    }

    private String srt(String ido) {
        int perc = Integer.parseInt(ido.substring(0, 2));
        String percString = "";
        if (perc > 59) {
            perc -= 60;
            if (perc >= 10) {
                percString = String.valueOf(perc);
            } else {
                percString = "0" + String.valueOf(perc);
            }
            return "01:" + percString + ":" + ido.substring(3);
        } else {
            return "00:" + ido;
        }
    }

    public String srtIdozites() {
        String tol = idozites.substring(0, 5);
        String ig = idozites.substring(8);

        String srtTol = srt(tol);
        String srtIg = srt(ig);
        return srtTol + " --> " + srtIg;
    }
}
