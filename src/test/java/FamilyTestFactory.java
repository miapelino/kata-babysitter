public class FamilyTestFactory {

    public Job getFamilyAJob(int startHour, int jobDuration) throws Exception {
        Job job = new Job();
        job.setStartHour(startHour);
        job.setJobDuration(jobDuration);
        Family familyA = new Family();
        familyA.setLateNightStartHour(23);
        job.setFamily(familyA);
        return job;
    }

    public Job getFamilyBJob(int startHour, int jobDuration) throws Exception {
        Job job = new Job();
        job.setStartHour(startHour);
        job.setJobDuration(jobDuration);
        Family familyB = new Family();
        familyB.setBedtimeStartHour(22);
        familyB.setLateNightStartHour(24);
        job.setFamily(familyB);
        return job;
    }

    public Job getFamilyCJob(int startHour, int jobDuration) throws Exception {
        Job job = new Job();
        job.setStartHour(startHour);
        job.setJobDuration(jobDuration);
        Family familyC = new Family();
        familyC.setBedtimeStartHour(21);
        job.setFamily(familyC);
        return job;
    }
}
