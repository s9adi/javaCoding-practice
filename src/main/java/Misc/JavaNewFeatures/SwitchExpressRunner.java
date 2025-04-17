package Misc.JavaNewFeatures;

public class SwitchExpressRunner {

    public static void main(String[] args) {

    }

    static String dayOfWeek(int day) {
        String dayOftheweek = "";
        switch (day) {
            case 0:
                dayOftheweek = "Sunday";
                break;
            case 1:
                dayOftheweek = "Monday";
                break;
            case 2:
                dayOftheweek = "Tuesday";
                break;
            default:
                throw new IllegalArgumentException("Invalid Option " + day);
        }
        return dayOftheweek;
    }

    static String dayOftheWeekModified(int day) {
        String dayofweek = switch (day) {
            case 0 -> {
                System.out.println("Do Some Complex Logic here");
                yield "Sunday";
            }
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            default -> throw new IllegalArgumentException("Invalid Option" + day);
        };

        return dayofweek;
    }
}
