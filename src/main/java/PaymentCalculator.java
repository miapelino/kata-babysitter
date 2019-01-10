public class PaymentCalculator {

    private Rate rate = new Rate();
    private int[] payment = new int[3];

    public int calculatePayment(Job job) {
        payment[0] = calculateStandardPayment(job);
        return payment[0];
    }

    public int calculateStandardPayment(Job job) {
        return rate.getStandardHourlyRate(job.getFamily()) * getNumberOfStandardHours(job);
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

    public int[] getPayment() {
        return this.payment;
    }
}
