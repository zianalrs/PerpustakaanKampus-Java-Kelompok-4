/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import perpustakaan.LayananPerpustakaan;
import java.util.Scanner;

/**
 *
 * @author gedascc
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static LayananPerpustakaan layanan = new LayananPerpustakaan();

    public static void main(String[] args) {
        int pilihan = 0;
        do {
            System.out.println("\n==========================================");
            System.out.println("   SISTEM MANAJEMEN PERPUSTAKAAN KAMPUS   ");
            System.out.println("==========================================");
            System.out.println("1. Lihat Antrean & Panggil Mahasiswa");
            System.out.println("2. Lihat Katalog Buku & Tambah Buku");
            System.out.println("3. Cek Lokasi Rak Buku");
            System.out.println("4. Lihat Tabel Rekap Peminjaman");
            System.out.println("5. Lihat Riwayat & Undo Aktivitas");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu (1-6): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Peringatan: Masukkan angka 1 sampai 6!");
                scanner.nextLine();
                continue;
            }

            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    jalankanMenuAntrean();
                    break;
                case 2:
                    jalankanMenuKatalog();
                    break;
                case 3:
                    jalankanMenuRak();
                    break;
                case 4:
                    jalankanMenuTabel();
                    break;
                case 5:
                    jalankanMenuRiwayat();
                    break;
                case 6:
                    System.out.println("\nTerima kasih telah menggunakan program ini:)");
                    break;
                default:
                    System.out.println("Menu tidak tersedia, pilih 1 sampai 6.");
            }
        } while (pilihan != 6);
    }

    private static void jalankanMenuAntrean() {
        System.out.println("\n--- [1. ANTREAN PELAYANAN MAHASISWA] ---");
        layanan.tampilkanAntrean();
        
        System.out.println("\nPilihan Aksi:");
        System.out.println("a. Layani/Panggil antrean paling depan");
        System.out.println("b. Tambah antrean baru");
        System.out.println("c. Kembali ke menu utama");
        System.out.print("Ketik pilihan (a/b/c): ");
        String aksi = scanner.nextLine().trim().toLowerCase();

        if (aksi.equals("a")) {
            String dilayani = layanan.layaniAntrean();
            if (dilayani != null) {
                System.out.println(">> Berhasil memanggil: " + dilayani);
            } else {
                System.out.println(">> Antrean sedang kosong.");
            }
        } else if (aksi.equals("b")) {
            System.out.print("Masukkan Nama Mahasiswa : ");
            String nama = scanner.nextLine();
            
            System.out.print("Masukkan NIM Mahasiswa  : ");
            String nim = scanner.nextLine();
            
            String dataMahasiswa = nama + " (" + nim + ")";
            layanan.masukAntrean(dataMahasiswa);
            System.out.println(">> " + dataMahasiswa + " berhasil masuk ke barisan antrean.");
        }
    }

    private static void jalankanMenuKatalog() {
        System.out.println("\n--- [2. KOLEKSI BUKU] ---");
        layanan.tampilkanKatalog();

        System.out.println("\nPilihan Aksi:");
        System.out.println("a. Tambah buku baru ke koleksi");
        System.out.println("b. Kembali ke menu utama");
        System.out.print("Ketik pilihan (a/b): ");
        String aksi = scanner.nextLine().trim().toLowerCase();

        if (aksi.equals("a")) {
            System.out.print("Masukkan judul buku yang ingin ditambah: ");
            String judul = scanner.nextLine();
            layanan.tambahBuku(judul);
            System.out.println(">> Buku \"" + judul + "\" berhasil masuk ke daftar koleksi!");
        }
    }

    private static void jalankanMenuRak() {
        System.out.println("\n--- [3. PENGECEKAN RAK PENYIMPANAN] ---");
        System.out.println("Perpustakaan punya: Lantai 1-2, Rak 1-3, Tiap rak punya 4 slot.");
        
        System.out.print("Mau cek Lantai berapa? (1 atau 2): ");
        int lt = scanner.nextInt() - 1;
        System.out.print("Mau cek Rak nomor berapa? (1 sampai 3): ");
        int rk = scanner.nextInt() - 1;
        scanner.nextLine();

        System.out.println("\nHasil Pengecekan Rak:");
        layanan.cekIsiRak(lt, rk);
    }

    private static void jalankanMenuTabel() {
        System.out.println("\n--- [4. REKAPITULASI PEMINJAMAN MINGGUAN] ---");
        layanan.tampilkanTabelPeminjaman();
    }

    private static void jalankanMenuRiwayat() {
        System.out.println("\n--- [5. LOG TRANSAKSI & PEMBATALAN] ---");
        layanan.tampilkanRiwayat();

        System.out.println("\nPilihan Aksi:");
        System.out.println("a. Batalkan/Undo aktivitas yang paling atas");
        System.out.println("b. Kembali ke menu utama");
        System.out.print("Ketik pilihan (a/b): ");
        String aksi = scanner.nextLine().trim().toLowerCase();

        if (aksi.equals("a")) {
            String dibatalkan = layanan.batalkanTransaksi();
            if (dibatalkan != null) {
                System.out.println(">> Berhasil membatalkan aktivitas: \"" + dibatalkan + "\"");
            } else {
                System.out.println(">> Tidak ada riwayat transaksi yang bisa dibatalkan.");
            }
        }
    }
}
