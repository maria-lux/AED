public class Date {

    private int month;
    private int day;
    private int year;

    public Date(int month, int day, int year) {

        if (!isValid(month, day, year)) {
            throw new IllegalArgumentException("Data inválida");
        }

        this.month = month;
        this.day = day;
        this.year = year;
    }

    private boolean isValid(int month, int day, int year) {
        if (month < 1 || month > 12) {
            return false;
        }
        if (year < 0) {
            return false;
        }
        if (day < 1 || day > daysInMonth(month, year)) {
            return false;
        }
        return true;
    }

    private int daysInMonth(int month, int year) {
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        }
        if (month == 2) {
            if (isLeapYear(year)) {
                return 29;
            }
            return 28;
        }
        return 31;
    }

    private boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0;
    }

    public boolean before(Date other) {
        if (this.year() < other.year()) {
            return true;
        }
        if (this.year() == other.year()) {
            if (this.month() < other.month()) {
                return true;
            }
            if (this.month() == other.month()) {
                if (this.day() < other.day()) {
                    return true;
                }
            }
        }
        return false;
    }

    public int daysSinceBeginYear() {
        int m = month();
        int result = day();
        if (month == 1) {
            return day();
        }
        while (m > 1) {
            result += daysInMonth(m, year);
            m--;
        }
        return result;
    }

    public int daysUntilEndYear() {
        if (this.isLeapYear(year)) {
            return 366 - this.daysSinceBeginYear();
        }
        return 365 - this.daysSinceBeginYear();
    }

    public int daysBetween(Date other) {
        int thisDateTotalDays = (this.year - 1) * 365 + numberOfLeapDays(this) + this.daysSinceBeginYear();
        int otherDateTotalDays = (other.year - 1) * 365 + numberOfLeapDays(other) + other.daysSinceBeginYear();
        return Math.abs(thisDateTotalDays - otherDateTotalDays);
    }


    public int numberOfLeapDays(Date date) {
        int result = (date.year - 1) / 4;
        if (date.month > 2 && isLeapYear(date.year)) {
            result++;
        }
        return result;
    }

    public int day() {
        return day;
    }

    public int month() {
        return month;
    }

    public int year() {
        return year;
    }

    @Override
    public String toString() {
        return month + "/" + day + "/" + year;
    }

    public static void main(String[] args) {
        Date date1 = new Date(1, 1, 2025);
        Date date2 = new Date(1, 1, 2024);
        System.out.println(date1.daysBetween(date2));
        System.out.println(date2.isLeapYear(2024));
    }

}
