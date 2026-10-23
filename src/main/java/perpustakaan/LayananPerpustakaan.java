/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perpustakaan;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author gedascc
 */
public class LayananPerpustakaan {
    private String[] kategori = {
        "Pemrograman", 
        "Matematika", 
        "Jaringan Komputer", 
        "Basis Data"
    };

    private int[][] peminjamanHarian = new int[4][7];
    private String[] namaHari = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu", "Minggu"};

    private Buku[][][] lokasiRak = new Buku[2][3][4];

    private ArrayList<Buku> katalogBuku = new ArrayList<>();

    private Stack<String> riwayatTransaksi = new Stack<>();

    private Queue<String> antreanMahasiswa = new LinkedList<>();

    public LayananPerpustakaan() {

        katalogBuku.add(new Buku("Struktur Data Java"));
        katalogBuku.add(new Buku("Algoritma Pemrograman"));
        katalogBuku.add(new Buku("Kalkulus Differensial"));
        katalogBuku.add(new Buku("Arsitektur Jaringan Komputer"));
        katalogBuku.add(new Buku("Sistem Basis Data Relasional"));

        antreanMahasiswa.offer("Ahmad Ghazali (2509116010)");
        antreanMahasiswa.offer("Siti Rahma (2509116025)");
        antreanMahasiswa.offer("Dimas Sanjaya (2509116040)");

        lokasiRak[0][0][0] = new Buku("Struktur Data Java");
        lokasiRak[0][0][1] = new Buku("Algoritma Pemrograman");

        lokasiRak[0][1][0] = new Buku("Kalkulus Differensial");

        lokasiRak[1][2][0] = new Buku("Arsitektur Jaringan Komputer");
        lokasiRak[1][2][1] = new Buku("Sistem Basis Data Relasional");

        peminjamanHarian[0][0] = 3;
        peminjamanHarian[0][2] = 5;
        peminjamanHarian[0][4] = 2;

        peminjamanHarian[1][1] = 4;
        peminjamanHarian[1][3] = 1;

        peminjamanHarian[2][0] = 2;
        peminjamanHarian[2][5] = 6;

        peminjamanHarian[3][2] = 4;
        peminjamanHarian[3][6] = 3;

        riwayatTransaksi.push("Sistem: Inisialisasi katalog buku bawaan");
        riwayatTransaksi.push("Sistem: Penempatan koleksi ke rak lantai 1 & 2");
        riwayatTransaksi.push("Sistem: Sinkronisasi data peminjaman mingguan");
    }

    public void masukAntrean(String nama) {
        antreanMahasiswa.offer(nama);
    }

    public String layaniAntrean() {
        if (antreanMahasiswa.isEmpty()) return null;
        String mhs = antreanMahasiswa.poll();
        riwayatTransaksi.push("Melayani antrean: " + mhs);
        return mhs;
    }

    public void tampilkanAntrean() {
        System.out.println("Daftar Antrean: " + (antreanMahasiswa.isEmpty() ? "[Kosong]" : antreanMahasiswa));
    }

    public void tambahBuku(String judul) {
        katalogBuku.add(new Buku(judul));
        riwayatTransaksi.push("Menambah koleksi: " + judul);
    }

    public boolean hapusBuku(int index) {
        if (index >= 0 && index < katalogBuku.size()) {
            Buku dihapus = katalogBuku.remove(index);
            riwayatTransaksi.push("Menghapus koleksi: " + dihapus.getJudul());
            return true;
        }
        return false;
    }

    public void tampilkanKatalog() {
        if (katalogBuku.isEmpty()) {
            System.out.println("Katalog kosong.");
            return;
        }
        for (int i = 0; i < katalogBuku.size(); i++) {
            System.out.println((i + 1) + ". " + katalogBuku.get(i).getJudul());
        }
    }

    public boolean isKatalogKosong() {
        return katalogBuku.isEmpty();
    }

    public boolean simpanKeRak(int lantai, int rak, int slot, String judul) {
        if (lantai >= 0 && lantai < 2 && rak >= 0 && rak < 3 && slot >= 0 && slot < 4) {
            lokasiRak[lantai][rak][slot] = new Buku(judul);
            riwayatTransaksi.push("Menaruh '" + judul + "' di L" + (lantai + 1) + "-R" + (rak + 1) + "-S" + (slot + 1));
            return true;
        }
        return false;
    }

    public void cekIsiRak(int lantai, int rak) {
        if (lantai >= 0 && lantai < 2 && rak >= 0 && rak < 3) {
            System.out.println("Slot di Lantai " + (lantai + 1) + ", Rak " + (rak + 1) + ":");
            for (int s = 0; s < 4; s++) {
                Buku b = lokasiRak[lantai][rak][s];
                System.out.println(" Slot " + (s + 1) + ": " + (b == null ? "[Kosong]" : b.getJudul()));
            }
        } else {
            System.out.println("Lokasi rak tidak ditemukan.");
        }
    }

    public void tampilkanKategori() {
        for (int i = 0; i < kategori.length; i++) {
            System.out.println((i + 1) + ". " + kategori[i]);
        }
    }

    public void tampilkanHari() {
        for (int i = 0; i < namaHari.length; i++) {
            System.out.println((i + 1) + ". " + namaHari[i]);
        }
    }

    public boolean catatPeminjaman(int katIdx, int hariIdx, int jumlah) {
        if (katIdx >= 0 && katIdx < 4 && hariIdx >= 0 && hariIdx < 7) {
            peminjamanHarian[katIdx][hariIdx] += jumlah;
            riwayatTransaksi.push("Pinjam " + jumlah + " buku " + kategori[katIdx] + " pd hari " + namaHari[hariIdx]);
            return true;
        }
        return false;
    }

    public void tampilkanTabelPeminjaman() {
        System.out.printf("\n%-20s", "Kategori");
        for (String h : namaHari) {
            System.out.printf("%-10s", h);
        }
        System.out.println();
        System.out.println("-".repeat(90));

        for (int i = 0; i < kategori.length; i++) {
            System.out.printf("%-20s", kategori[i]);
            for (int j = 0; j < namaHari.length; j++) {
                System.out.printf("%-10d", peminjamanHarian[i][j]);
            }
            System.out.println();
        }
    }

    public void tampilkanRiwayat() {
        if (riwayatTransaksi.isEmpty()) {
            System.out.println("Belum ada riwayat transaksi.");
            return;
        }
        System.out.println("Aktivitas Terakhir (Urutan Terbaru di Atas):");
        for (int i = riwayatTransaksi.size() - 1; i >= 0; i--) {
            System.out.println("- " + riwayatTransaksi.get(i));
        }
    }

    public String batalkanTransaksi() {
        if (riwayatTransaksi.isEmpty()) return null;
        return riwayatTransaksi.pop();
    }
}
