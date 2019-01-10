import java.util.stream.IntStream;

public class PaymentCalculator {

    private Rate rate = new Rate();
    private Job job;
    private int payment;

    public int calculatePayment(Job job) {
        this.job = job;
        payment = calculateStandardPayment();
        payment += calculateBedtimeHourlyRate();
        payment += calculateLateNightHourlyRate();
        return payment;
    }

    private int calculateStandardPayment() {
        return rate.getStandardHourlyRate(job.getFamily()) * job.getNumberOfStandardHours();
    }

    private int calculateBedtimeHourlyRate() {
        return rate.getBedtimeHourlyRate(job.getFamily()) * job.getNumberOfBedtimeHours(job.getRemainingHours());
    }

    private int calculateLateNightHourlyRate() {
        return rate.getLateNightHourlyRate(job.getFamily()) * job.getRemainingHours();
    }
}
