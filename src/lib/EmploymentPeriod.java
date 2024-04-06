package lib;

public class EmploymentPeriod {

    private int yearJoined;
    private int monthJoined;
    private int dayJoined;
    private int monthWorkingInYear;

    public EmploymentPeriod(int yearJoined, int monthJoined, int dayJoined, int monthWorkingInYear) {
        this.yearJoined = yearJoined;
        this.monthJoined = monthJoined;
        this.dayJoined = dayJoined;
        this.monthWorkingInYear = monthWorkingInYear;
    }

    public int getYearJoined() {
        return yearJoined;
    }

    public void setYearJoined(int yearJoined) {
        this.yearJoined = yearJoined;
    }

    public int getMonthJoined() {
        return monthJoined;
    }

    public void setMonthJoined(int monthJoined) {
        this.monthJoined = monthJoined;
    }

    public int getDayJoined() {
        return dayJoined;
    }

    public void setDayJoined(int dayJoined) {
        this.dayJoined = dayJoined;
    }

    public int getMonthWorkingInYear() {
        return monthWorkingInYear;
    }

    public void setMonthWorkingInYear(int monthWorkingInYear) {
        this.monthWorkingInYear = monthWorkingInYear;
    }
}

