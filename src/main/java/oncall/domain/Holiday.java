package oncall.domain;

public enum Holiday {

    NEWYEAR(1, 1),
    THREEONE(3, 1),
    CHILDRENSDAY(5,5),
    HYEONCHUNG(6, 6),
    GWANGBOK(8, 15),
    GAECHEON(10,3),
    HANGEUL(10,9),
    CHIRSTMAS(12,25);

    int month;
    int date;

    Holiday(int month, int date) {
        this.month = month;
        this.date = date;
    }
}
