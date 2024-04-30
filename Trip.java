public class Trip {
    private static int idGenerator = 1;
    private final int id;
    private String asal;
    private String tujuan;
    private double harga;
    private String jadwal;
    private int ketersedian;
    private Pemesanan.JenisTrip jenis;

    public Trip(String asal, String tujuan, double harga, String jadwal, int ketersedian, Pemesanan.JenisTrip jenis) {
        this.id = idGenerator++;
        this.asal = asal;
        this.tujuan = tujuan;
        this.harga = harga;
        this.jadwal = jadwal;
        this.ketersedian = ketersedian;
        this.jenis = jenis;
    }

    public int getId() {
        return id;
    }

    public String getAsal() {
        return asal;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }

    public String getTujuan() {
        return tujuan;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public String getJadwal() {
        return jadwal;
    }

    public void setJadwal(String jadwal) {
        this.jadwal = jadwal;
    }

    public int getKetersedian() {
        return ketersedian;
    }

    public void setKetersedian(int ketersedian) {
        this.ketersedian = ketersedian;
    }

    public Pemesanan.JenisTrip getJenis() {
        return jenis;
    }

    public void setType(Pemesanan.JenisTrip jenis) {
        this.jenis = jenis;
    }

    public void pengurangantKetersedian() {
        ketersedian--;
    }

    public void penambahanKetersedian() {
        ketersedian++;
    }

    @Override
    public String toString() {
        return 
                "Id =  " + id +
                "| Asal = '" + asal + '\'' +
                "| Tujuan = '" + tujuan + '\'' +
                "| Harga Rp" +harga +
                "| Jadwal = '" + jadwal + '\'' +
                "| Ketersedian = " + ketersedian +
                "| Jenis = " + jenis +
                '|';
    }
}