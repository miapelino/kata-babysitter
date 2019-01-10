public class PaymentCalculator {

    private Rate rate = new Rate();

    public int calculatePayment(Job job) {
        int hourlyRate = rate.getStandardHourlyRate(job.getFamily());
        return (job.getEndHour() - job.getStartHour()) * hourlyRate;
    }

    public int getNumberOfStandardHours(Job job) {
        int bedtimeHour = job.getFamily().getBedtimeStartHour();
        if(bedtimeHour != 0) {
            return bedtimeHour - job.getStartHour();
        }
        int lateNightHour = job.getFamily().getLateNightStartHour();
        if(lateNightHour != 0){
            return lateNightHour - job.getStartHour();
        }
        return 0;
    }
}
