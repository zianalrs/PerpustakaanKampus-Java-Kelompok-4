# Sistem Manajemen Perpustakaan Kampus

---

## Tugas Pemrograman Java
- **Mata Kuliah:** Pemrograman Berorientasi Objek
- **Dosen Pengampu:** M. Ibadurrahman Arrasyid Supriyanto M.Kom.
- **Program Studi:** Sistem Informasi
- **Angkatan:** 2025
- **Kelompok:** 4
  
## Anggota Kelompok 4
1. *Mukhammad Ismul Azam Atmoko* - 2509116034 - Kelas A
2. *Zian Alrais* - 2509116064  - Kelas B
3. *Ghaida Suci Nahiza* - 2509116077 - Kelas B
4.  *Muhammad Syawal Samir* - 2509116079 - Kelas B

# Deskripsi Singkat Program

Program Java berbasis konsol untuk membantu petugas perpustakaan kampus mengelola antrean mahasiswa, katalog buku, lokasi rak, rekap peminjaman, dan riwayat aktivitas. Program dijalankan lewat menu interaktif menggunakan `Scanner`.

## Fitur

1. **Antrean:** lihat antrean, tambah mahasiswa baru, dan panggil mahasiswa paling depan.
2. **Katalog Buku:** lihat daftar buku dan tambah buku baru.
3. **Lokasi Rak:** cek isi rak berdasarkan lantai dan nomor rak.
4. **Rekap Peminjaman:** tabel jumlah peminjaman per kategori dan per hari.
5. **Riwayat:** lihat aktivitas terbaru dan batalkan catatan paling atas.
6. **Keluar** dari program.

## Struktur Data yang Digunakan

| Struktur Data | Variabel | Kegunaan |
|---|---|---|
| Array 1D | `kategori`, `namaHari` | Menyimpan daftar kategori buku dan nama hari |
| Array 2D | `peminjamanHarian` | Jumlah peminjaman per kategori (baris) dan hari (kolom) |
| Array 3D | `lokasiRak` | Lokasi buku berdasarkan lantai, rak, dan slot |
| ArrayList | `katalogBuku` | Daftar buku yang bisa bertambah dan berkurang |
| Stack (LIFO) | `riwayatTransaksi` | Riwayat aktivitas, yang terbaru ada di paling atas |
| Queue (FIFO) | `antreanMahasiswa` | Antrean mahasiswa sesuai urutan datang |
