import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author id.123
 * Denne klassen er covidregisteret som innehlder flere metoder
 * for å finne, lete osv av coronatilfeler og spesifikk ting fra oppgavesettet
 */
public class CovidRegister {

    /**
     * Konstruktør som inneholder en newArraylist av coronatilfeller
     */
    public CovidRegister() {
        counts = new ArrayList<>();
    }

    /**
     * en metdeo som registrerr et nytt corona tilfellet
     * @param newDate selvvalgdt dato i konstruktøren
     * @param newContry
     * @param newNumSick
     * @param newNumDeath
     * @return en liste med alle registrerte tilfeller
     */
    public ArrayList<Covid> registerNewOwnDate(String newDate, String newContry, int newNumSick, int newNumDeath) throws Exception {
        counts.add(new Covid(newDate, newContry, newNumSick, newNumDeath));
        return deepCopyMethod(counts);
    }

    /**
     * en metode for å registrere et nytt tilfellet som bruker dagens dato
     * @param newContry
     * @param newNumSick
     * @param newNumDeath
     * @return en liste med alle registrerte tilfeller
     */
    public ArrayList<Covid> registerNewDateNow(String newContry, int newNumSick, int newNumDeath) throws Exception {
        counts.add(new Covid(newContry, newNumSick, newNumDeath));
        return deepCopyMethod(counts);
    }

    /**
     * en metode som leeter etter en spesifikk dato
     * @param findDate
     * @return
     * @throws Exception hvis den ikke finner noe på den datoen vil den kaste en Exception
     */
    public ArrayList<Covid> searchDate (String findDate) throws Exception {
        ArrayList<Covid> dateArr = new ArrayList<>();
        for (Covid c : counts){
            if (c.getLOCALDATE().equals(findDate)){
                dateArr.add(c);
            }
        }
        if (dateArr.size() == 0){
            throw new Exception("Denne datoen ble ikke funnet");
        }
        return deepCopyMethod(dateArr);
    }

    /**
     * en metode som leter etter covid saker som er registrert på local dato
     * @return en liste mad alle covid tilfeller funnet
     * @throws Exception hvis det ikke er registrert noe med dagen dato vil den kaset en exception
     */
    public ArrayList<Covid> searchThisDate() throws Exception {
        ArrayList<Covid> dateArr = new ArrayList<>();
        for (Covid c : counts){
            if (c.getLOCALDATE().equals(LocalDate.now().toString())){
                dateArr.add(c);
            }
        }
        if (dateArr.size() == 0){
            throw new Exception("Det er enda ikke registrert noe i dag");
        }
        return deepCopyMethod(dateArr);
    }

    /**
     * en metode som itererer gjennom en liste og returner itereringen
     * @return iterert liste;
     */
    public Iterator<Covid> iteratorMethod(){
        return counts.iterator();
    }

    /**
     * en metode som finner antall regisrtreringer
     * @return antall registreringer av covid i counts
     */
    public int numOfregisters(){
        int numOfRegisters = 0;
        for (int i = 0; i < counts.size(); i++) {
            numOfRegisters = i+1;
        }
        return numOfRegisters;
    }

    /**
     * metode som finner antall døde i et land
     * @param findCountry
     * @return antall døde i et spesifick land
     */
    public int numOfDeadSpecifick(String findCountry){
        int numOfDeath = 0;
        for (Covid c : counts){
            if (c.getCOUNTRY().equals(findCountry)){
                numOfDeath += c.getNUMOFDEAD();
            }
        }
        return numOfDeath;
    }

    /**
     * denne metoden finner total antall døde av Covid
     * @return totalt antall døde registrert
     */
    public int totalNumDead(){
        int totalDeath = 0;
        for (Covid c : counts){
            totalDeath += c.getNUMOFDEAD();
        }
        return totalDeath;
    }

    /**
     * en metode som printer ut alle Covid-Caser som er registrert
     * @return alle caser i registeret
     */
    public ArrayList<Covid> soutAllCars() throws Exception {
        ArrayList<Covid> allCars;
        allCars = deepCopyMethod(counts);
        return allCars;
    }

    /**
     * en deepcopy metode som dypcopierer en arrayliste av typen Covid
     * @param copyMe listen du skal kopiere
     * @return copi av listen du sender inn
     */
    public ArrayList<Covid> deepCopyMethod(ArrayList<Covid> copyMe) throws Exception {
        ArrayList<Covid> theCopy = new ArrayList<>();
        for (Covid c : copyMe){
            theCopy.add(new Covid(c.getLOCALDATE(), c.getCOUNTRY(), c.getNUMOFSICK(), c.getNUMOFDEAD()));
        }
        return theCopy;
    }

    /**
     * en to string metode som sender en stringbuiler til to string i Covid
     * @return returener en string definsert etter string builder i covid
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Covid c : counts) {
            sb.append(c.toString()).append("\n");
        }
        return sb.toString();
    }
}
