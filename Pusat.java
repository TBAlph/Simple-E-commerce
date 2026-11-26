import java.util.Scanner;
public class Pusat {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Toko toko = new Toko ("KONTER JOSJIS", 20);

        toko.tambahBarang("Laptop Gaming", 12000000);
        toko.tambahBarang("Mouse Wireless", 250000);
        toko.tambahBarang("Keyboard Mechanical", 750000);

        boolean berjalan = true;

        while (berjalan) {
            System.out.println("=== SELAMAT DATANG DI " + toko.getNamaToko().toUpperCase() + " ===");
            System.out.println("1. Penjual (Tambah Barang ke Menu)");
            System.out.println("2. Pembeli (Lihat Menu & Belanja)");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu (1-3): ");
            int pilihan = in.nextInt();
            in.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.println("--- TAMBAH BARANG BARU ---");
                    System.out.print("Masukkan jumlah jenis barang yang ingin ditambah: ");
                    int jmlTambah = in.nextInt();
                    in.nextLine();

                    for (int i = 0; i < jmlTambah; i++) {
                        System.out.println("Barang ke-" + (i + 1) + ":");
                        System.out.print("Nama Barang  : ");
                        String namaBarang = in.nextLine();
                        System.out.print("Harga Barang : ");
                        long hargaBarang = in.nextLong();
                        in.nextLine();

                        toko.tambahBarang(namaBarang, hargaBarang);
                    }
                    break;

                case 2:
                    toko.tampilkanMenu();

                    System.out.print("Apakah Anda memiliki Kartu Berlangganan Toko Josjis? (y/n): ");
                    String jawabKartu = in.next();
                    boolean punyaKartu = jawabKartu.equalsIgnoreCase("y");

                    Transaksi transaksi = new Transaksi(10, punyaKartu);

                    boolean lanjutBelanja = true;
                    while (lanjutBelanja) {
                        System.out.print("\nPilih nomor barang yang ingin dibeli (0 untuk selesai): ");
                        int nomorMenu = in.nextInt();

                        if (nomorMenu == 0) {
                            lanjutBelanja = false;
                        } else {
                            Barang barangDipilih = toko.getBarang(nomorMenu);
                            if (barangDipilih != null) {
                                System.out.print("Masukkan jumlah beli: ");
                                int qty = in.nextInt();
                                transaksi.tambahKeKeranjang(barangDipilih, qty);
                            } else {
                                System.out.println("Nomor barang tidak valid!");
                            }
                        }
                    }

                    transaksi.cetakStruk(toko.getNamaToko());
                    break;

                case 3:
                    berjalan = false;
                    System.out.println("Program selesai. Sampai jumpa!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
}
