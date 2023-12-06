import cargo.Antilunit;
import cargo.Lunit;
import enums.Gender;
import exceptions.NoClothesException;
import interfaces.Colorful;

public class Main {
    public static void main(String[] args) {
        Person znayka = new Person("Знайка", Gender.MALE, 30, 65, 60, "Скафандр");
        Person neznayka = new Person("Незнайка", Gender.MALE, 150, 90, 75, "");
        Person pilulkin = new Person("Доктор Пилюлькин", Gender.MALE, 400, 70, 96, "Скафандр");
        Person fucsia = new Person("Фуксия", Gender.FEMALE, 100, 25, 55, "Скафандр");
        Person seledochka = new Person("Селёдочка", Gender.FEMALE, 100, 32, 53, "Скафандр");
        Rocket rocket = new Rocket("Ярко-голубой");

        Colorful mountain = new Colorful() {
            public void describeColor() {
                System.out.println("Гора имеет цвет Красноватый");
            }

            public void setColor(String color) {

            }
        };
        mountain.describeColor();
        rocket.describeColor();

        neznayka.move(new Lunit());
        neznayka.move(new Antilunit());

        znayka.say("Доставить Незнайку в ракету");

        rocket.checkState();

        znayka.say("Грузить лунит и антилунит");
        rocket.load(new Lunit(), fucsia, seledochka);
        rocket.load(new Antilunit(), fucsia, seledochka);
        rocket.load(new Lunit(), fucsia, seledochka);

        znayka.changeColor(rocket, "Белый");

        pilulkin.move(neznayka, 500);
        if (!rocket.load(neznayka, pilulkin)) rocket.load(neznayka, pilulkin, fucsia, seledochka);

        try {
            pilulkin.undress(neznayka);
        } catch (NoClothesException e) {
            System.out.println(pilulkin + " не смог раздеть " + neznayka + ": нечего снимать");
        }

        rocket.tryToFlight();
    }
}
