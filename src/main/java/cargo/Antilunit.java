package cargo;

public class Antilunit extends Cargo {
    public Antilunit() {
        super("Красный");
    }

    public Antilunit(String color) {
        super(color);
    }

    public String toString() {
        return "Кусок антилунита весом " + this.getWeight() + "кг";
    }
}
