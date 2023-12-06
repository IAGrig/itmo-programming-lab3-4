package time;

public class Timer {
    public static void takes(int hours, int minutes, int seconds) {
        StringBuilder stringBuilder = new StringBuilder();
        if (hours != 0) {
            stringBuilder.append(hours).append(" часов ");
        }
        if (minutes != 0) {
            stringBuilder.append(minutes).append(" минут ");
        }
        if (seconds != 0) {
            stringBuilder.append(seconds).append(" секунд");
        }
        if (stringBuilder.isEmpty()) {
            System.out.println("Это происходит мновенно");
        } else {
            System.out.println("Это занимает " + stringBuilder);
        }
    }

    public static void takes(int seconds) {
        int hours = Timer.pureHoursFromSeconds(seconds);
        int minutes = Timer.pureHinutesFromSeconds(seconds);
        seconds = seconds % 60;
        takes(hours, minutes, seconds);
    }

    public static int pureHoursFromSeconds(int seconds) {
        return seconds / (60 * 60);
    }

    public static int pureHinutesFromSeconds(int seconds) {
        return seconds % (60 * 60) / 60;
    }
}
