public class PaymentCalculator {

    private Rate rate = new Rate();

    public int calculatePayment(Job job) {
        int hourlyRate = rate.getRate(job.getFamily());
        return (job.getEndHour() - job.getStartHour()) * hourlyRate;
    }
}
