public class PaymentCalculator {

    private Rate rate = new Rate();

    public int calculatePayment(int startHour, int endHour) {
        int hourlyRate = rate.getRate();
        return (endHour - startHour)*hourlyRate;
    }
}
