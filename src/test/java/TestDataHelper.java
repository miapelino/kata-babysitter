public class TestDataHelper {

    public Job getFamilyAJob(int startHour, int jobDuration) throws Exception {
        Family familyA = new Family();
        familyA.setLateNightStartHour(23);
        Job job = new Job(familyA, startHour, jobDuration);
        return job;
    }

    public Job getFamilyBJob(int startHour, int jobDuration) throws Exception {
        Family familyB = new Family();
        familyB.setBedtimeStartHour(22);
        familyB.setLateNightStartHour(24);
        Job job = new Job(familyB, startHour, jobDuration);
        return job;
    }

    public Job getFamilyCJob(int startHour, int jobDuration) throws Exception {
        Family familyC = new Family();
        familyC.setBedtimeStartHour(21);
        Job job = new Job(familyC, startHour, jobDuration);
        return job;
    }
}
