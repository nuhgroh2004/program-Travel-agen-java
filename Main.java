import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        TravelAgent TravelAgent = new TravelAgent();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nTravel Agent Menu:");
            System.out.println("1. Tambah Trip");
            System.out.println("2. Lihat Trip");
            System.out.println("3. Pesan Trip");
            System.out.println("4. Pembatalan Trip");
            System.out.println("5. Lihat pemesanan dari Email");
            System.out.println("6. Lihat ketersedian Trip dari tanggal");
            System.out.println("7. Lihat ketersedian Trip dari jenis");
            System.out.println("8. Exit");
            System.out.print("pilihan menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();
            switch (pilihan) {
                case 1:
                    System.out.print("Kota asal                           : ");
                    String asal = scanner.nextLine();
                    System.out.print("Kota tujuan                         : ");
                    String tujuan = scanner.nextLine();
                    System.out.print("Harga                               : ");
                    double harga = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Jadwal (00.00 | MM-DD)              : ");
                    String tanggal = scanner.nextLine();
                    System.out.print("Ketersedian                         : ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Jenis trip (FLIGHT, HOTEL, PACKAGE) : ");
                    String jenisInput = scanner.nextLine().toUpperCase();
                    Pemesanan.JenisTrip jenis = Pemesanan.JenisTrip.valueOf(jenisInput);
                    TravelAgent.tambahTrip(asal, tujuan, harga, tanggal, quantity, jenis);
                    break;
                case 2:
                    TravelAgent.lihatTrip();
                    break;
                case 3:
                    TravelAgent.lihatTrip();
                    System.out.print("Masukkan nama   : ");
                    String customerNama = scanner.nextLine();
                    System.out.print("Masukkan email  : ");
                    String customerEmail = scanner.nextLine();
                    Customer customer = new Customer(customerNama, customerEmail);
                    System.out.print("Masukkan tujuan : ");
                    String tujuanTrip = scanner.nextLine();
                    TravelAgent.pesanTrip(customer, tujuanTrip);
                    break;
                case 4:
                    System.out.print("Masukkan customer email : ");
                    String pembatalanCustomerEmail = scanner.nextLine();
                    System.out.print("Masukkan tujuan         : ");
                    String pembatalanTujuan = scanner.nextLine();
                    TravelAgent.pembatalanTrip(pembatalanCustomerEmail, pembatalanTujuan);
                    break;
                case 5:
                    System.out.print("Masukkan customer email : ");
                    String mecariEmail = scanner.nextLine();
                    TravelAgent.cariPesananCustomerDariEmail(mecariEmail);;
                    break;
                case 6:
                    System.out.print("Jadwal (00.00 | MM-DD) : ");
                    String cariJadwal = scanner.nextLine();
                    TravelAgent.cariTripDariTanggal(cariJadwal);
                    break;
                case 7:
                    System.out.print("Pilih jenis trip (FLIGHT, HOTEL, PACKAGE) : ");
                    Pemesanan.JenisTrip cariJenisTrip = Pemesanan.JenisTrip.valueOf(scanner.nextLine().toUpperCase());
                    TravelAgent.caraiTripDariJenis(cariJenisTrip);
                    break;
                case 8:
                    running = false;
                    break;
                default:
                    System.out.println("input tidak valid");
            }
        }
        scanner.close();
    }
}
