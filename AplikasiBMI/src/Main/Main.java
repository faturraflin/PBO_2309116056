package main;

import user.User;
import beratbadan.BeratBadan;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // Static keyword untuk menyimpan list user dan berat badan
    private static ArrayList<BeratBadan> listData = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
            scanner.nextLine(); // Untuk konsumsi newline

            switch (pilihan) {
                case 1:
                    tambahData(scanner);
                    break;
                case 2:
                    lihatData();
                    break;
                case 3:
                    ubahData(scanner);
                    break;
                case 4:
                    hapusData(scanner);
                    break;
                case 5:
                    System.out.println("Keluar dari aplikasi...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 5);
    }

    // Method untuk menambah data
    public static void tambahData(Scanner scanner) {
        System.out.print("Masukkan nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan umur: ");
        int umur = scanner.nextInt();
        scanner.nextLine(); // Konsumsi newline
        System.out.print("Masukkan jenis kelamin: ");
        String jenisKelamin = scanner.nextLine();
        System.out.print("Masukkan tinggi badan (m): ");
        double tinggiBadan = scanner.nextDouble();
        System.out.print("Masukkan berat badan (kg): ");
        double beratBadan = scanner.nextDouble();
        scanner.nextLine(); // Konsumsi newline

        // Membuat objek User dan BeratBadan
        User user = new User(nama, umur, jenisKelamin);
        BeratBadan data = new BeratBadan(user, tinggiBadan, beratBadan);
        listData.add(data);

        System.out.println("Data berhasil ditambahkan.");
    }

    // Method untuk melihat data
    public static void lihatData() {
        if (listData.isEmpty()) {
            System.out.println("Belum ada data.");
        } else {
            for (BeratBadan data : listData) {
                data.tampilkanStatusBMI();
                System.out.println();
            }
        }
    }

    // Method untuk mengubah data
    public static void ubahData(Scanner scanner) {
        System.out.print("Masukkan nama pengguna yang ingin diubah: ");
        String nama = scanner.nextLine();
        for (BeratBadan data : listData) {
            if (data.user.getNama().equalsIgnoreCase(nama)) {
                System.out.print("Masukkan berat badan baru (kg): ");
                double beratBaru = scanner.nextDouble();
                scanner.nextLine(); // Konsumsi newline
                data.beratBadan = beratBaru; // Mengubah berat badan
                System.out.println("Data berhasil diubah.");
                return;
            }
        }
        System.out.println("Pengguna tidak ditemukan.");
    }

    // Method untuk menghapus data
    public static void hapusData(Scanner scanner) {
        System.out.print("Masukkan nama pengguna yang ingin dihapus: ");
        String nama = scanner.nextLine();
        for (int i = 0; i < listData.size(); i++) {
            if (listData.get(i).user.getNama().equalsIgnoreCase(nama)) {
                listData.remove(i);
                System.out.println("Data berhasil dihapus.");
                return;
            }
        }
        System.out.println("Pengguna tidak ditemukan.");
    }
}
