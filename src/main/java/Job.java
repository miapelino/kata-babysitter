public class Job {
    private static final int BABYSITTER_START_TIME = 17;
    private static final int BABYSITTER_END_TIME = 28;
    private Family family;
    private int startHour;
    private int endHour;

    public Family getFamily() {return this.family;}

    public void setFamily(Family family) {
        this.family = family;
    }

    public int getStartHour() {
        return this.startHour;
    }

    public void setStartHour(int startHour) throws Exception {
        if(startHour>=BABYSITTER_START_TIME) {
            this.startHour = startHour;
        } else throw new Exception(String.format("Babysitter cannot start work before %d:00 pm",
                BABYSITTER_START_TIME - 12));
    }

    public int getEndHour() {return this.endHour;}

    public void setEndHour(int endHour) throws Exception {
        if(endHour<=BABYSITTER_END_TIME) {
            this.endHour = endHour;
        } else throw new Exception(String.format("Babysitter cannot end work after %d:00 am",
                BABYSITTER_END_TIME - 24));
    }
}
