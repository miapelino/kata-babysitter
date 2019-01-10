public class PaymentCalculator {

    private Rate rate = new Rate();

    public int calculatePayment(Job job) {
        int hourlyRate = rate.getStandardHourlyRate(job.getFamily());
        return (job.getEndHour() - job.getStartHour()) * hourlyRate;
    }

    public int getNumberOfStandardHours(Job job) {
        return 6;
    }
}
