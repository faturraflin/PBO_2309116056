package main;

import user.user;
import user.pria;
import user.wanita;
import beratbadan.BeratBadan;
import java.util.ArrayList;
import java.util.Scanner;

public class Main implements CRUDInterface {
    private static ArrayList<BeratBadan> listData = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main app = new Main();
        app.run();
    }

    public void run() {
        int pilihan;
        do {
            System.out.println("=== Aplikasi BMI ===");
            System.out.println("1. Tambah Data");
            System.out.println("2. Lihat Data");
            System.out.println("3. Ubah Data");
            System.out.println("4. Hapus Data");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Konsumsi newline

            switch (pilihan) {
                case 1:
                    tambahData();
                    break;
                case 2:
                    lihatData();
                    break;
                case 3:
                    ubahData();
                    break;
                case 4:
                    hapusData();
                    break;
                case 5:
                    System.out.println("Keluar dari aplikasi...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 5);
    }

    @Override
    public void tambahData() {
        System.out.print("Masukkan nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan umur: ");
        int umur = scanner.nextInt();
        scanner.nextLine(); // Konsumsi newline
        System.out.print("Masukkan jenis kelamin (Pria/Wanita): ");
        String jenisKelamin = scanner.nextLine();
        System.out.print("Masukkan tinggi badan (m): ");
        double tinggiBadan = scanner.nextDouble();
        System.out.print("Masukkan berat badan (kg): ");
        double beratBadan = scanner.nextDouble();
        scanner.nextLine(); // Konsumsi newline

        user user;
        if (jenisKelamin.equalsIgnoreCase("Pria")) {
            user = new pria(nama, umur);
        } else {
            user = new wanita(nama, umur);
        }

        BeratBadan data = new BeratBadan(user, tinggiBadan, beratBadan);
        listData.add(data);
        System.out.println("Data berhasil ditambahkan.");
    }

    @Override
    public void lihatData() {
        if (listData.isEmpty()) {
            System.out.println("Belum ada data.");
        } else {
            for (BeratBadan data : listData) {
                data.tampilkanStatusBMI();
                System.out.println();
            }
        }
    }

    @Override
    public void ubahData() {
        System.out.print("Masukkan nama pengguna yang ingin diubah: ");
        String nama = scanner.nextLine();
        for (BeratBadan data : listData) {
            if (data.getUser().getNama().equalsIgnoreCase(nama)) {
                System.out.print("Masukkan berat badan baru (kg): ");
                double beratBaru = scanner.nextDouble();
                scanner.nextLine(); // Konsumsi newline
                data.setBeratBadan(beratBaru);
                System.out.println("Data berhasil diubah.");
                return;
            }
        }
        System.out.println("Pengguna tidak ditemukan.");
    }

    @Override
    public void hapusData() {
        System.out.print("Masukkan nama pengguna yang ingin dihapus: ");
        String nama = scanner.nextLine();
        for (int i = 0; i < listData.size(); i++) {
            if (listData.get(i).getUser().getNama().equalsIgnoreCase(nama)) {
                listData.remove(i);
                System.out.println("Data berhasil dihapus.");
                return;
            } else {
            }
        }
        System.out.println("Pengguna tidak ditemukan.");
    }
}
