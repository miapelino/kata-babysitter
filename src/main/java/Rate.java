public class Rate {
    static final int FIRST_CHILD_RATE = 10;
    static final int SUBSEQUENT_CHILD_RATE = 5;
    static final int DOG_RATE = 2;
    static final int CAT_RATE = 1;


    public int getStandardHourlyRate(Family family) {
        int totalKids = family.getTotalKids();
        int childRate = totalKids > 1 ? FIRST_CHILD_RATE + ((totalKids - 1) * SUBSEQUENT_CHILD_RATE) : totalKids * FIRST_CHILD_RATE;
        int petRate = family.getTotalCats() * CAT_RATE + family.getTotalDogs() * DOG_RATE;
        return childRate + petRate;
    }

    public int getBedtimeHourlyRate(Family family) {
        return 8;
    }
}
