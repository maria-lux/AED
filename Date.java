public class Date {

    private int month;
    private int day;
    private int year;

    public Date(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public boolean before(Date other) {
        if (this.year() < other.year()) {
            return true;
        } else if (this.year() == other.year()) {
            if (this.month() < other.month()) {
                return true;
            } else if (this.month() == other.month()) {
                if (this.day() < other.day()) {
                    return true;
                }
            }
        }
        return false;
    }

    public int daysSinceBeginYear() {
        int m = month() - 1;
        int result = day();
        while (m > 0) {
            if (m == 2) {
                result += 29;
            } else if (m % 2 == 0) {
                result += 30;
            } else {
                result += 31;
            }
            m--;
        }
        return result;
    }

    public int daysUntilEndYear() {
        return 365 - daysSinceBeginYear();
    }

    public int daysBetween(Date other) {
        int daysBetween = 0;
        int years = 0;
        int months = 0;
        int days = 0;

        years = other.year() == this.year() ? 0 : 0;
        months = Math.abs(other.month() - this.month());
        days = Math.abs(other.day() - this.day());


        System.out.println(years);
        System.out.println(months);
        System.out.println(days);

        return daysBetween;
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
        return "" + month + "/" + day + "/" + year + "";
    }

    public static void main(String[] args) {
        Date date1 = new Date(2, 31, 2024);
        Date date2 = new Date(1, 1, 2025);
        //System.out.println(date1.before(date2));
        //System.out.println(date1.daysSinceBeginYear());
        //System.out.println(date1.daysUntilEndYear());

        System.out.println(date1.daysBetween(date2));

    }

}
