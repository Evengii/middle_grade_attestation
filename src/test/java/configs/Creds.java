package configs;




public class Creds {
    private final static String FIRST_NAME = "1";
    private final static String LAST_NAME = "2";
    private final static String EMAIL = "asd111@asd.asd";
    private final static String PASSWORD = "123123";
    private final static String CITY = "Cleveland";
    private final static String ADDRESS = "Avenue St.";
    private final static String ZIP = "135135";
    private final static String PHONE_NUMBER = "98427418421";

    public static String getFirstName(){
        return FIRST_NAME;
    }

    public static String getLastName(){
        return LAST_NAME;
    }

    public static String getLOGIN() {
        return EMAIL;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public static String getEmail(){ return EMAIL; }

    public static String getCity() {
        return CITY;
    }

    public static String getAddress() {
        return ADDRESS;
    }

    public static String getZip() {
        return ZIP;
    }

    public static String getPhoneNumber() {
        return PHONE_NUMBER;
    }
}
