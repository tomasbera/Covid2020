import java.time.LocalDate;

/**
 * @author id.111
 * Denne kalssen er en klasse for hcordan en covid registrering skal se ut
 * holder variabler for tid hvor ant syke og ant død av covid
 * inneholder også en ny klasse local date som holder localtiden
 */
public class Covid {
    private final LocalDate LOCALDATE;
    private final String COUNTRY;
    private final int NUMOFSICK;
    private final int NUMOFDEAD;

    /**
     * konstruktør som tar inn verdier for hvordan covid i et land er
     * bruker egensatt dato
     * @param localDate
     * @param COUNTRY
     * @param NUMOFSICK
     * @param NUMOFDEAD
     * @throws Exception hvis tallene ikke er postive kastes en Exception
     */
    public Covid(String localDate, String COUNTRY, int NUMOFSICK, int NUMOFDEAD) throws Exception {
        this.LOCALDATE = LocalDate.parse(localDate);
        this.COUNTRY = COUNTRY;
        if (NUMOFSICK < 0){
            throw new Exception("Tallet må være positivt");
        }
        this.NUMOFSICK = NUMOFSICK;

        if (NUMOFDEAD < 0){
            throw new Exception("Tallet må være positivt");
        }
        this.NUMOFDEAD = NUMOFDEAD;
    }

    /**
     * en konstruktør som da bruker tiden dagen dato som dato
     * @param COUNTRY
     * @param NUMOFSICK
     * @param NUMOFDEAD
     * @throws Exception hvis tallene ikke er postive kastes en Exception
     */
    public Covid(String COUNTRY, int NUMOFSICK, int NUMOFDEAD) throws Exception {
        this.LOCALDATE = LocalDate.now();
        this.COUNTRY = COUNTRY;
        if (NUMOFSICK < 0){
            throw new Exception("Tallet må være positivt");
        }
        this.NUMOFSICK = NUMOFSICK;

        if (NUMOFDEAD < 0){
            throw new Exception("Tallet må være positivt");
        }
        this.NUMOFDEAD = NUMOFDEAD;
    }

    /**
     * en getmetode som sender tilbake en string av localtiden
     * @return string localdate
     */
    public String getLOCALDATE() {
        return LOCALDATE.toString();
    }

    /**
     * en getmetode som sender tilbake landet hvor registerringen skjedde
     * @return string i form av hvilket lande det er
     */
    public String getCOUNTRY() {
        return COUNTRY;
    }

    /**
     * en getmetode for å hente ut antall syke
     * @return antall syke som int
     */
    public int getNUMOFSICK() {
        return NUMOFSICK;
    }

    /**
     * en getmetode for å hente ut antall døde
     * @return antall døde som int
     */
    public int getNUMOFDEAD() {
        return NUMOFDEAD;
    }

    /**
     * en toString metode som lager en string av Covid i et land
     * @return sender tilbake en string i form av land tid syke og døde av covid i et land
     */
    @Override
    public String toString() {
        return "\n" +LOCALDATE + "\t\t" +COUNTRY+ "\t\t\t" +NUMOFSICK+ "\t\t\t\t" +NUMOFDEAD+ "\n";
    }
}
