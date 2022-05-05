package university.enitity;

public enum Titles {
    DOCTOR("Doctor"),
    CONFERENTIAR("Conferentiar"),
    LECTOR("Lector"),
    PREOT("Preot"),
    PROFESOR("Profesor"),
    UNIVERSITAR("Universitar");


    private final String displayEnum;

    Titles(String displayEnum) {
        this.displayEnum = displayEnum;
    }

    public String getDisplayEnum() {
        return displayEnum;
    }
}