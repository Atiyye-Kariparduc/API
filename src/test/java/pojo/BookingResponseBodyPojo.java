package pojo;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class BookingResponseBodyPojo {
    private Integer bookingid;
    private BookingPojo booking;

    public BookingResponseBodyPojo(Integer bookingid, BookingPojo booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }

    public BookingResponseBodyPojo() {
    }

    public Integer getBookingId() {
        return bookingid;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingid = bookingId;
    }

    public BookingPojo getBooking() {
        return booking;
    }

    public void setBooking(BookingPojo booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "BookingResponseBodyPojo{" +
                "bookingId=" + bookingid +
                ", booking=" + booking +
                '}';
    }
}
