import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TravelAgent {
    private List<Trip> trips = new ArrayList<>();
    private final Map<String, List<Pemesanan>> pemesanans = new HashMap<>();

    public void tambahTrip(String asal, String tujuan, double harga, String jadwal, int ketersedian, Pemesanan.JenisTrip jenis) {
        Trip trip = new Trip(asal, tujuan, harga, jadwal, ketersedian, jenis);
        trips.add(trip);
        System.out.println("Trip berhasil ditambahkan");
    }

    public void lihatTrip() {
        if (trips.isEmpty()) {
            System.out.println("Tidak ada trip");
        }
        else{
            System.out.println("Trips yang tersedia");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            for (Trip trip : trips){
                System.out.println(trip);
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            }
        }
    }

    public void pesanTrip(Customer customer,String tujuan) {
        Trip tripKePesanan = null;
        for (Trip trip : trips) {
            if (trip.getTujuan().equals(tujuan) && trip.getKetersedian() > 0){
                tripKePesanan = trip;
                break;
            }
        }

        if (tripKePesanan == null) {
            System.out.println("Maaf trip sudah full");
            return;
        }

        String customerEmail = customer.getEmail();
        List<Pemesanan> customerPemesanans = pemesanans.get(customerEmail);
        Trip finalPemesanaTrip = tripKePesanan;
        if (customerPemesanans != null && customerPemesanans.stream().anyMatch(pemesanan -> pemesanan.getTrip().equals(finalPemesanaTrip))) {
            System.out.println("kamu sudah memesan perjalanan ini dengan email yang sama");
            return;
        }

        Pemesanan pemesanan = new Pemesanan(customer, tripKePesanan);
        tripKePesanan.pengurangantKetersedian();

        if (customerPemesanans == null) {
            customerPemesanans = new ArrayList<>();
            pemesanans.put(customerEmail, customerPemesanans);
        }

        customerPemesanans.add(pemesanan);
        String idPemesan = tripKePesanan.getJadwal()+tripKePesanan.getTujuan()+pemesanan.getIdPemesanan();
        System.out.println("Pemesanan berhasil. ID pemesanan: " + idPemesan);
    }   

    public void pembatalanTrip(String customerEmail, String tujuan) {
        List<Pemesanan> customerPemesanans = pemesanans.get(customerEmail);

        if (customerPemesanans ==  null) {
            System.out.println("Pesanan trip tidak ditemukan");
            return;
        } 

        Pemesanan pemesananKeBatal = null;
        for (Pemesanan pemesanan : customerPemesanans) {
            if (pemesanan.getTrip().getTujuan().equalsIgnoreCase(tujuan)) {
                pemesananKeBatal = pemesanan;
                break;
            }
        }

        if (pemesananKeBatal == null) {
            System.out.println("Tidak ada pemesanan yang ditemukan untuk tujuan ini.");
            return;
        }

        Trip trip = pemesananKeBatal.getTrip();
        trip.pengurangantKetersedian();
        customerPemesanans.remove(pemesananKeBatal);
        System.out.println("Trip behasil dibatalkan");
    }

    public void cariPesananCustomerDariEmail(String email) {
        List<Pemesanan> customerpPemesanans = pemesanans.get(email);

        if (customerpPemesanans == null || customerpPemesanans.isEmpty()) {
            System.out.println("Tidak ada pemesanan yang ditemukan untuk customer ini.");
            return;
        }
        
        System.out.println("Pemesanan menggunakan " + email + ":");

        for (Pemesanan pemesanan : customerpPemesanans) {
            Trip tripKePesanan = pemesanan.getTrip();
            String IDpemesanan = tripKePesanan.getJadwal() + "-" + tripKePesanan.getTujuan() + "-" + pemesanan.getIdPemesanan();
            System.out.println("ID pemesanan: " + IDpemesanan);
            System.out.println(pemesanan); 
        }
    }

    public void cariTripDariTanggal(String jadwal) {
        List<Trip> tripsKeJadwal = new ArrayList<>();
        for (Trip trip : trips) {
            if (trip.getJadwal().equals(jadwal)) {
                tripsKeJadwal.add(trip);
        }
    }

        if (tripsKeJadwal.isEmpty()) {
            System.out.println("tidak ada trip " + jadwal);
        } else {
            System.out.println("ada trip pada " + jadwal + ":");
            for (Trip trip : tripsKeJadwal) {
                System.out.println(trip);
            }
        }
    }

    public void caraiTripDariJenis(Pemesanan.JenisTrip jenis) {
        List<Trip> tripsKeJenis = new ArrayList<>();
        for (Trip trip : trips) {
            if (trip.getJenis() == jenis) {
                tripsKeJenis.add(trip);
            }
        }

        if (tripsKeJenis.isEmpty()) {
            System.out.println("jenis Trip ini tidak ada " + jenis);
        } else {
            System.out.println("jenis Trip ini ada " + jenis + ":");
            for (Trip trip : tripsKeJenis) {
                System.out.println(trip);
            }
        }
    }
}