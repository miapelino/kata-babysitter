public class Job {
    public static final int BABYSITTER_START_TIME = 17;
    public static final int BABYSITTER_END_TIME = 28;
    private Family family;
    private int startHour;
    private int jobDuration;
    private int standardHoursWorked;
    private int remainingHours;

    public Job(Family family, int startHour, int jobDuration) throws Exception {
        validateWithinAllowableHours(startHour, jobDuration);
        this.startHour = startHour;
        this.jobDuration = jobDuration;
        this.family = family;
    }
    public Family getFamily() {return this.family;}

    public int getStartHour() {return this.startHour;}

    public int getJobDuration() {return this.jobDuration;}

    public void validateWithinAllowableHours(int startHour, int jobDuration) throws Exception {
        if(startHour < BABYSITTER_START_TIME || startHour + jobDuration > BABYSITTER_END_TIME) {
            throw new Exception(String.format("Work hours must be between %d:00 pm and %d:00 am", BABYSITTER_START_TIME - 12, BABYSITTER_END_TIME - 12));
        }
    }

    public void setRemainingHours(int remainingHours) {
        this.remainingHours = remainingHours;
    }

    public int getRemainingHours() {
        return this.remainingHours;
    }

    public void setStandardHoursWorked(int standardHoursWorked) {
        this.standardHoursWorked = standardHoursWorked;
    }

    public int getStandardHoursWorked() {
        return this.standardHoursWorked;
    }

    public int determineNumberOfStandardHours() {
        int standardHours;
        if(family.getBedtimeStartHour() != 0 &&
                !(jobDuration < family.hoursBetweenStartHourAndBedtime(startHour))) {
            standardHours = family.hoursBetweenStartHourAndBedtime(startHour);
        } else if(family.getLateNightStartHour() != 0 &&
                !(jobDuration < family.hoursBetweenStartHourAndLateNight(startHour))){
            standardHours = family.hoursBetweenStartHourAndLateNight(startHour);
        } else {
            standardHours = jobDuration;
        }
        return standardHours;
    }

    public int determineNumberOfBedtimeHours(int hoursRemaining) {
        if(family.getBedtimeStartHour() != 0) {
            int bedtimeHours;
            if(family.getLateNightStartHour() != 0) {
                if (hoursRemaining <= (family.hoursBetweenBedtimeAndLateNight())) {
                    bedtimeHours = family.hoursBetweenBedtimeAndLateNight();
                } else {
                    bedtimeHours = family.hoursBetweenBedtimeAndLateNight();
                }
                return bedtimeHours;
            } else {
                return hoursRemaining;
            }
        }
        return family.getBedtimeStartHour();
    }
}
