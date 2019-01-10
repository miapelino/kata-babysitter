public class PaymentCalculator {

    private Rate rate = new Rate();
    private int[] payment = new int[3];

    public int calculatePayment(Job job) {
        payment[0] = calculateStandardPayment(job);
        payment[1] = calculateBedtimeHourlyRate(job);
        return payment[0] + payment[1];
    }

    private int calculateStandardPayment(Job job) {
        return rate.getStandardHourlyRate(job.getFamily()) * job.getNumberOfStandardHours();
    }

    private int calculateBedtimeHourlyRate(Job job) {
        return rate.getBedtimeHourlyRate(job.getFamily()) * job.getNumberOfBedtimeHours(job.getRemainingHours());
    }

    public int[] getPayment() {
        return this.payment;
    }
}
