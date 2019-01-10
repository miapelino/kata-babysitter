public class Job {
    public static final int BABYSITTER_START_TIME = 17;
    public static final int BABYSITTER_END_TIME = 28;
    private Family family;
    private int startHour;
    private int jobDuration;
    private int remainingHours;

    public Family getFamily() {return this.family;}

    public void setFamily(Family family) {
        this.family = family;
    }

    public int getStartHour() {
        return this.startHour;
    }

    public void setStartHour(int startHour) throws Exception {
        if(startHour >= BABYSITTER_START_TIME && startHour + getJobDuration() < BABYSITTER_END_TIME) {
            this.startHour = startHour;
        } else throw new Exception(String.format("Babysitter cannot start work before %d:00 pm",
                BABYSITTER_START_TIME - 12));
    }

    public int getJobDuration() {return this.jobDuration;}

    public void setJobDuration(int jobDuration) throws Exception {
        if(jobDuration + BABYSITTER_START_TIME <= BABYSITTER_END_TIME && jobDuration + getStartHour() <= BABYSITTER_END_TIME) {
            this.jobDuration = jobDuration;
        } else throw new Exception(String.format("Job duration cannot go beyond %d:00 am",
                BABYSITTER_END_TIME - 24));
    }

    public int getJobEndHour() {
        return startHour + jobDuration;
    }

    private void setRemainingHours(int remainingHours) {
        this.remainingHours = remainingHours;
    }

    public int getRemainingHours() {
        return this.remainingHours;
    }

    public int getNumberOfStandardHours() {
        int standardHours = 0;
        if(this.family.getBedtimeStartHour() != 0 &&
                !(this.jobDuration < (this.family.getBedtimeStartHour() - this.startHour))) {
            standardHours = this.family.getBedtimeStartHour() - this.startHour;
        } else if(this.family.getLateNightStartHour() != 0 &&
                !(this.jobDuration < (this.family.getLateNightStartHour() - this.startHour))){
            standardHours = this.family.getLateNightStartHour() - this.startHour;
        } else {
            standardHours = this.jobDuration;
        }
        setRemainingHours(this.jobDuration - standardHours);
        return standardHours;
    }

}
