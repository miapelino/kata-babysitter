public class Rate {
    private static final int FIRST_CHILD_RATE = 10;
    private static final int SUBSEQUENT_CHILD_RATE = 5;
    private static final int DOG_RATE = 2;
    private static final int CAT_RATE = 1;
    private static final int BEDTIME_PET_VALUE = 2;
    private static final int LATE_NIGHT_CHILD_VALUE = 2;
    private static final int LATE_NIGHT_PET_VALUE = 1;


    public int getStandardHourlyRate(Family family) {
        int totalKids = family.getTotalKids();
        int childRate = totalKids > 1 ? FIRST_CHILD_RATE + ((totalKids - 1) * SUBSEQUENT_CHILD_RATE) : totalKids * FIRST_CHILD_RATE;
        int petRate = family.getTotalCats() * CAT_RATE + family.getTotalDogs() * DOG_RATE;
        return childRate + petRate;
    }

    public int getBedtimeHourlyRate(Family family) {
        return getStandardHourlyRate(family) - family.getTotalNumberOfPets() * BEDTIME_PET_VALUE;
    }

    public int getLateNightHourlyRate(Family family) {
        return getStandardHourlyRate(family) + addBonusIfHaunted(family) +
                (family.getTotalKids() * LATE_NIGHT_CHILD_VALUE) +
                (family.getTotalNumberOfPets() * LATE_NIGHT_PET_VALUE);
    }

    private int addBonusIfHaunted(Family family) {
        return family.getIsHaunted() ? 1 : 0;
    }
}
