import java.util.concurrent.atomic.AtomicInteger;

public class  Pemesanan{
    private static final AtomicInteger idGenerator = new AtomicInteger(1 );
    private final int IdPemesanan;
    private Customer customer;
    private Trip trip;

    public Pemesanan(Customer customer, Trip trip) {
        this.IdPemesanan = idGenerator.getAndIncrement();
        this.customer = customer;
        this.trip = trip;
    }

    public int getIdPemesanan() {
        return IdPemesanan;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Trip getTrip() {
        return trip;
    }

    @Override
    public String toString() {
        String IDpemesanan = trip.getJadwal() + "-" + trip.getTujuan() + "-" + IdPemesanan;
        return "Pemesanan |" +
                " IdPemesanan = " + IDpemesanan + 
                "| Customer = " + customer.getNama() + " (" + customer.getEmail() + ")" +
                "| Trip = " + trip +
                '|';
    }

    public enum JenisTrip {
        FLIGHT,
        HOTEL,
        PACKAGE
    }
}