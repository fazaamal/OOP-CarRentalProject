public class Booking {
    private String name, icNo, address, bookingID, carID, phoneNo, cardNo;
    private int daysBooked, expiryMonth, expiryYear;
    private double amountPaid;

    public Booking(String bookingID, String carID, int daysBooked, String name, String icNo, String address, String phoneNo, String cardNo, int expiryMonth, int expiryYear, double amountPaid) {
        this.bookingID = bookingID;
        this.carID = carID;
        this.daysBooked = daysBooked;
        this.name = name;
        this.icNo = icNo;
        this.address = address;
        this.phoneNo = phoneNo;
        this.cardNo = cardNo;
        this.expiryMonth = expiryMonth;
        this.expiryYear = expiryYear;
        this.amountPaid = amountPaid;
    }

    public int getDaysBooked() {
        return daysBooked;
    }

    public void setDaysBooked(int daysBooked) {
        this.daysBooked = daysBooked;
    }

    public String getCarID() {
        return carID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcNo() {
        return icNo;
    }

    public void setIcNo(String icNo) {
        this.icNo = icNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public int getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(int expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public int getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(int expiryYear) {
        this.expiryYear = expiryYear;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }
}
