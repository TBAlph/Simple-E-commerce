class Toko {
    private String namaToko;
    private Barang[] daftarBarang;
    private int jumlahBarang;

    public Toko(String namaToko, int kapasitasMaksimal) {
        this.namaToko = namaToko;
        this.daftarBarang = new Barang[kapasitasMaksimal];
        this.jumlahBarang = 0;
    }

    public String getNamaToko() {
        return namaToko;
    }

    public int getJumlahBarang() {
        return jumlahBarang;
    }

    public void tambahBarang(String nama, long harga) {
        if (jumlahBarang < daftarBarang.length) {
            daftarBarang[jumlahBarang] = new Barang(nama, harga);
            jumlahBarang++;
            System.out.println("Berhasil menambahkan '" + nama + "' ke daftar menu!");
        } else {
            System.out.println("Kapasitas katalog toko sudah penuh!");
        }
    }

    public Barang getBarang(int nomorMenu) {
        if (nomorMenu >= 1 && nomorMenu <= jumlahBarang) {
            return daftarBarang[nomorMenu - 1];
        }
        return null;
    }

    public void tampilkanMenu() {
        System.out.println("\n==================================================");
        System.out.println("          DAFTAR MENU - " + namaToko.toUpperCase());
        System.out.println("==================================================");
        System.out.printf("%-4s | %-25s | %-15s\n", "No", "Nama Barang", "Harga");
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < jumlahBarang; i++) {
            System.out.printf("%-4d | %-25s | Rp%,d\n",
                    (i + 1),
                    daftarBarang[i].getNama(),
                    daftarBarang[i].getHarga());
        }
        System.out.println("==================================================");
        System.out.println("INFO DISKON:");
        System.out.println("- Belanja minimal Rp5.000.000 : Diskon 10%");
        System.out.println("- Pemilik Kartu Berlangganan  : Ekstra Diskon 5%");
        System.out.println("==================================================");
    }
}