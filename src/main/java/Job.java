public class Job {
    public static final int BABYSITTER_START_TIME = 17;
    public static final int BABYSITTER_END_TIME = 28;
    private Family family;
    private int startHour;
    private int jobDuration;
    private int standardHoursWorked;
    private int remainingHours;
    private int bedtimeHoursWorked;

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

    public void setBedtimeHoursWorked(int bedtimeHoursWorked) {
        this.bedtimeHoursWorked = bedtimeHoursWorked;
    }

    public int getBedtimeHoursWorked() {
        return this.bedtimeHoursWorked;
    }

    public int determineNumberOfStandardHours() {
        int standardHours;
        if(this.family.getBedtimeStartHour() != 0 &&
                !(this.jobDuration < (this.family.getBedtimeStartHour() - this.startHour))) {
            standardHours = this.family.getBedtimeStartHour() - this.startHour;
        } else if(this.family.getLateNightStartHour() != 0 &&
                !(this.jobDuration < (this.family.getLateNightStartHour() - this.startHour))){
            standardHours = this.family.getLateNightStartHour() - this.startHour;
        } else {
            standardHours = this.jobDuration;
        }
        return standardHours;
    }

    public int determineNumberOfBedtimeHours(int hoursRemaining) {
        if(this.family.getBedtimeStartHour() != 0) {
            int bedtimeHours;
            if(this.family.getLateNightStartHour() != 0) {
                if (hoursRemaining <= (this.family.getLateNightStartHour() - this.family.getBedtimeStartHour())) {
                    bedtimeHours = this.family.getLateNightStartHour() - this.family.getBedtimeStartHour();
                } else {
                    bedtimeHours = this.family.getLateNightStartHour() - this.family.getBedtimeStartHour();
                }
                return bedtimeHours;
            } else {
                return hoursRemaining;
            }
        }
        return this.family.getBedtimeStartHour();
    }
}
