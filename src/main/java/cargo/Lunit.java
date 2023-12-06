package cargo;

public class Lunit extends Cargo {

    public Lunit() {
        super("Зелёный");
    }

    public Lunit(String color) {
        super(color);
    }

    public String toString() {
        return "Кусок лунита весом " + this.getWeight() + "кг";
    }
}
