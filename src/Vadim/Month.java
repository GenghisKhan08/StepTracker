package Vadim;

public class Month {
    private int month;
    Day[] days;

    public Month() {
        days =new Day[30];
        for (int i = 0; i <days.length; i++) {
            days[i] =new Day(0);
        }
    }
}
