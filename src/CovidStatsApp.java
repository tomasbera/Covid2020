import static javax.swing.JOptionPane.*;
/**
 * @author id.123
 * Dette er klientprogramet der brukeren kan velge mellom flere metoder
 * registrer nytt tilfelet, søke etter tifelet, endre på variabeler osv
 */
public class CovidStatsApp {
    private static final String VERSION = "v1.0-SNAPSHOT";
    private static boolean quit = true;
    private static final CovidRegister covReg = new CovidRegister();


    public static void main(String[] args) {
        start();
    }

    /**
     * Starts the application by showing the menu and retrieving input from the
     * user.
     * Continues until the user decides to exit the application.
     */
    static void start() {
        while (quit) {
            try {
                String[] menuItems =
                        {
                                "Register new Covid-19 case",
                                "List all COVID-19 entries",
                                "Find COVID-19 entry by date",
                                "Find all entries after date",
                                "Find death count",
                                "End App"
                        };

                final int REGISTER_NEW_CASE = 0;
                final int LIST_ALL_COVID_ENTRIES = 1;
                final int FIND_COVID_ENTRY_BY_DATE = 2;
                final int CALCULATE_TOTAL_DEATHS = 3;
                final int EXIT = 4;

                int menuSelection = showOptionDialog(null, "**** COVID-19 Stats Tool****" + "\nVelg funksjon",
                        "Eksamen vår 2021", YES_NO_OPTION, INFORMATION_MESSAGE, null, menuItems, menuItems[0]);


                switch (menuSelection) {
                    case REGISTER_NEW_CASE -> REGISTER_NEW_CASE();
                    case LIST_ALL_COVID_ENTRIES -> LIST_ALL_COVID_ENTRIES();
                    case FIND_COVID_ENTRY_BY_DATE -> FIND_COVID_ENTRY_BY_DATE();
                    case CALCULATE_TOTAL_DEATHS -> CALCULATE_TOTAL_DEATHS();
                    case EXIT -> {
                        System.out.println("\nThank you for using the COVID-19 stats Application "
                                + VERSION + ". Bye!\n");
                        quit = false;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void REGISTER_NEW_CASE() throws Exception {
        String RegChoice = showInputDialog("""
                1 Register by specific date
                2 Regiseter by todays date
                """);
        int regchoice = Integer.parseInt(RegChoice);
        if (regchoice < 1 || regchoice > 2){
            throw new Exception("Write 1 or 2");
        }
        switch (regchoice) {
            case 1 -> {
                String newDate = showInputDialog("""
                        Writ inn a date by the format
                        AAAA-MM-DD
                        """);
                String newCountry = showInputDialog("Witch country do you want to register");
                String newNumOfSickRead = showInputDialog("How many were sick that day");
                int newNumOfSick = Integer.parseInt(newNumOfSickRead);
                String newNumOfDeadRead = showInputDialog("How many died that day");
                int newNumOfDead = Integer.parseInt(newNumOfDeadRead);
                System.out.println("\nDate" + "          Country    " + "Number of Sick    " + "Num of Dead");
                System.out.println(covReg.registerNewOwnDate(newDate, newCountry, newNumOfSick, newNumOfDead).toString());
            }
            case 2 -> {
                String newCountry = showInputDialog("Wich country do you want to register");
                String newNumOfSickRead = showInputDialog("How many were sick today day");
                int newNumOfSick = Integer.parseInt(newNumOfSickRead);
                String newNumOfDeadRead = showInputDialog("How many died today day");
                int newNumOfDead = Integer.parseInt(newNumOfDeadRead);
                System.out.println("Date" + "          Country    " + "Number of Sick    " + "Num of Dead");
                System.out.println(covReg.registerNewDateNow(newCountry, newNumOfSick, newNumOfDead).toString());
            }
        }
    }

    private static void LIST_ALL_COVID_ENTRIES() throws Exception {
        System.out.println("\nDate" + "          Country    " + "Number of Sick    " + "Num of Dead");
        System.out.println(covReg.soutAllCars().toString());
        System.out.println("\nNumber of entries is:");
        System.out.println(covReg.numOfregisters());
    }

    private static void FIND_COVID_ENTRY_BY_DATE() throws Exception {
        String RegChoice = showInputDialog("""
                1 Find by specific date
                2 Find todays date
                """);
        int regChoice = Integer.parseInt(RegChoice);
        if (regChoice < 1 || regChoice > 2){
            throw new Exception("Write 1 or 2");
        }

        switch (regChoice) {
            case 1 -> {
                String findDate = showInputDialog("""
                        Writ inn a date by the format
                        AAAA-MM-DD
                        """);
                System.out.println("\nDate" + "          Country    " + "Number of Sick    " + "Num of Dead");
                System.out.println(covReg.searchDate(findDate).toString());
            }

            case 2 -> {
                System.out.println("\nDate" + "          Country    " + "Number of Sick    " + "Num of Dead");
                System.out.println(covReg.searchThisDate().toString());
            }
        }
    }

    private static void CALCULATE_TOTAL_DEATHS() throws Exception {
        String RegChoice = showInputDialog("""
                1 Find total dead in a country
                2 Find total dead by covid
                """);
        int regChoice = Integer.parseInt(RegChoice);
        if (regChoice < 1 || regChoice > 2) {
            throw new Exception("Write 1 or 2");
        }
        switch (regChoice) {
            case 1 -> {
                String findCountry = showInputDialog("Write the country you want to look at");
                System.out.println("\nNumber of deaths in " + findCountry + " is:");
                System.out.println(covReg.numOfDeadSpecifick(findCountry));
            }

            case 2 -> {
                System.out.println("\nThe total amout dead by Covid-19 is:");
                System.out.println(covReg.totalNumDead());
            }
        }
    }
}