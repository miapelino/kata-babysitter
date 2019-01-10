public class Family {
    private static final int FIRST_CHILD_RATE = 10;
    private static final int SUBSEQUENT_CHILD_RATE = 5;
    private static final int DOG_RATE = 2;
    private static final int CAT_RATE = 1;
    private static final int BEDTIME_PET_RATE = 2;
    private static final int LATE_NIGHT_CHILD_RATE = 2;
    private static final int LATE_NIGHT_PET_RATE = 1;

    private int totalKids;
    private int totalDogs;
    private int totalCats;
    private boolean isHaunted;
    private int bedtimeStartHour;
    private int lateNightStartHour;

    public int getTotalKids() {return this.totalKids;}

    public void setTotalKids(int totalKids) {this.totalKids = totalKids;}

    public int getTotalDogs() {return this.totalDogs;}

    public void setTotalDogs(int totalDogs) {this.totalDogs = totalDogs;}

    public int getTotalCats() {return this.totalCats;}

    public void setTotalCats(int totalCats) {this.totalCats = totalCats;}

    public int getTotalNumberOfPets() {return this.totalDogs + this.totalCats;}

    public boolean getIsHaunted() {return this.isHaunted;}

    public void setIsHaunted(boolean isHaunted) {this.isHaunted = isHaunted;}

    public int getBedtimeStartHour() {return bedtimeStartHour;}

    public void setBedtimeStartHour(int bedtimeStartHour) {this.bedtimeStartHour = bedtimeStartHour;}

    public int getLateNightStartHour() {return lateNightStartHour;}

    public void setLateNightStartHour(int lateNightStartHour) {this.lateNightStartHour = lateNightStartHour;}

    public int getStandardHourlyRate() {
        int totalKids = this.getTotalKids();
        int childRate = totalKids > 1 ? FIRST_CHILD_RATE + ((totalKids - 1) * SUBSEQUENT_CHILD_RATE) : totalKids * FIRST_CHILD_RATE;
        int petRate = this.getTotalCats() * CAT_RATE + this.getTotalDogs() * DOG_RATE;
        return childRate + petRate;
    }

    public int getBedtimeHourlyRate() {
        return getStandardHourlyRate() - this.getTotalNumberOfPets() * BEDTIME_PET_RATE;
    }

    public int getLateNightHourlyRate() {
        return getStandardHourlyRate() + addBonusIfHaunted() +
                (this.getTotalKids() * LATE_NIGHT_CHILD_RATE) +
                (this.getTotalNumberOfPets() * LATE_NIGHT_PET_RATE);
    }

    public int hoursBetweenBedtimeAndLateNight() {
        return this.lateNightStartHour - this.bedtimeStartHour;
    }

    public int hoursBetweenStartHourAndBedtime(int startHour) {
        return this.bedtimeStartHour - startHour;
    }

    public int hoursBetweenStartHourAndLateNight(int startHour) {
        return this.lateNightStartHour - startHour;
    }

    private int addBonusIfHaunted() {
        return this.getIsHaunted() ? 1 : 0;
    }
}
