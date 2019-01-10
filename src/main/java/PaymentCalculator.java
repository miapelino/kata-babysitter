public class PaymentCalculator {

    public int calculatePayment(int startHour, int endHour) {
        int hourlyRate = 9;
        return (endHour - startHour)*hourlyRate;
    }
}
