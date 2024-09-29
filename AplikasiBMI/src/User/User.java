package user;

public class User {
    private String nama;
    private int umur;
    private String jenisKelamin;

    public User(String nama, int umur, String jenisKelamin) {
        this.nama = nama;
        this.umur = umur;
        this.jenisKelamin = jenisKelamin;
    }

    public void tampilkanInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("Umur: " + umur);
        System.out.println("Jenis Kelamin: " + jenisKelamin);
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
