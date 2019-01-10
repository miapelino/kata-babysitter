public class PaymentCalculator {

    private Rate rate = new Rate();
    private int[] payment = new int[3];

    public int calculatePayment(Job job) {
        payment[0] = calculateStandardPayment(job);
        return payment[0];
    }

    private int calculateStandardPayment(Job job) {
        return rate.getStandardHourlyRate(job.getFamily()) * job.getNumberOfStandardHours();
    }

    public int[] getPayment() {
        return this.payment;
    }
}
