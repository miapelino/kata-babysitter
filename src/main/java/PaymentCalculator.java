public class PaymentCalculator {

    private Job job;

    public int calculatePayment(Job job) {
        this.job = job;
        int payment = calculateStandardPayment();
        payment += calculateBedtimeHourlyRate();
        payment += calculateLateNightHourlyRate();
        return payment;
    }

    private int calculateStandardPayment() {
        int standardHoursWorked = job.determineNumberOfStandardHours();
        job.setStandardHoursWorked(standardHoursWorked);
        job.setRemainingHours(job.getJobDuration() - standardHoursWorked);
        return job.getFamily().getStandardHourlyRate() * standardHoursWorked;
    }

    private int calculateBedtimeHourlyRate() {
        int bedtimeHourlyRate = 0;
        if(job.getRemainingHours() != 0) {
            int bedtimeHoursWorked = job.determineNumberOfBedtimeHours(job.getRemainingHours());
            job.setBedtimeHoursWorked(bedtimeHoursWorked);
            job.setRemainingHours(job.getJobDuration() - job.getStandardHoursWorked() + bedtimeHoursWorked);
            return job.getFamily().getBedtimeHourlyRate() * bedtimeHoursWorked;
        }
        return bedtimeHourlyRate;
    }

    private int calculateLateNightHourlyRate() {
        int lateNightHoursWorked = 0;
        if(job.getRemainingHours() != 0) {
            lateNightHoursWorked = job.getRemainingHours();
            return job.getFamily().getLateNightHourlyRate() * lateNightHoursWorked;
        }
        return lateNightHoursWorked;
    }
}
