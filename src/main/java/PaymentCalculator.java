public class PaymentCalculator {

    private Rate rate = new Rate();
    private Job job;

    public int calculatePayment(Job job) {
        this.job = job;
        return calculateStandardPayment()
                + calculateBedtimeHourlyRate()
                + calculateLateNightHourlyRate();
    }

    private int calculateStandardPayment() {
        int standardHoursWorked = job.determineNumberOfStandardHours();
        job.setStandardHoursWorked(standardHoursWorked);
        job.setRemainingHours(job.getJobDuration() - standardHoursWorked);
        return rate.getStandardHourlyRate(job.getFamily()) * standardHoursWorked;
    }

    private int calculateBedtimeHourlyRate() {
        int bedtimeHoursWorked = job.determineNumberOfBedtimeHours(job.getRemainingHours());
        job.setBedtimeHoursWorked(bedtimeHoursWorked);
        job.setRemainingHours(job.getJobDuration() - job.getStandardHoursWorked() + bedtimeHoursWorked);
        return rate.getBedtimeHourlyRate(job.getFamily()) * bedtimeHoursWorked;
    }

    private int calculateLateNightHourlyRate() {
        int lateNightHoursWorked = job.getRemainingHours();
        return rate.getLateNightHourlyRate(job.getFamily()) * lateNightHoursWorked;
    }
}
