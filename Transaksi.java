public class Transaksi {
   private Barang[] keranjangBarang;
   private int[] jumlahBeli;
   private int totalItemKeranjang;
   private boolean KartuLangganan;

   public Transaksi(int bahan, boolean ada) {
      this.keranjangBarang = new Barang[bahan];
      this.jumlahBeli = new int[bahan];
      this.totalItemKeranjang = 0;
      this.KartuLangganan = ada;
   }

   public void tambahKeKeranjang(Barang keranjang, int alat) {
      if (this.totalItemKeranjang < this.keranjangBarang.length) {
         this.keranjangBarang[this.totalItemKeranjang] = keranjang;
         this.jumlahBeli[this.totalItemKeranjang] = alat;
         ++this.totalItemKeranjang;
         System.out.println(alat + "x " + keranjang.getNama() + " masuk ke keranjang.");
      } else {
         System.out.println("Keranjang belanja sudah penuh!");
      }

   }

   public long hitungSubtotal() {
      long total = 0L;

      for(int hitung = 0; hitung < this.totalItemKeranjang; ++hitung) {
         total += this.keranjangBarang[hitung].getHarga() * (long)this.jumlahBeli[hitung];
      }

      return total;
   }

   public long hitungDiskon(long harga) {
      double diskon = (double)0.0F;
      if (harga >= 5000000L) {
         diskon += 0.1;
      }

      if (this.KartuLangganan) {
         diskon += 0.05;
      }

      return (long)((double)harga * diskon);
   }

   public void cetakStruk(String nama) {
      long subTotal = this.hitungSubtotal();
      long diskon = this.hitungDiskon(subTotal);
      long total = subTotal - diskon;
      System.out.println("\n==================================================");
      System.out.println("           STRUK PEMBAYARAN " + nama.toUpperCase());
      System.out.println("==================================================");

      for(int item = 0; item < this.totalItemKeranjang; ++item) {
         long banyakItem = this.keranjangBarang[item].getHarga() * (long)this.jumlahBeli[item];
         System.out.printf("%-20s (%dx) : Rp%,d\n", this.keranjangBarang[item].getNama(), this.jumlahBeli[item], banyakItem);
      }

      System.out.println("--------------------------------------------------");
      System.out.printf("Subtotal                  : Rp%,d\n", subTotal);
      System.out.printf("Status Kartu Langganan    : %s\n", this.KartuLangganan ? "Aktif (Ekstra 5%)" : "Tidak Ada");
      System.out.printf("Total Diskon              : -Rp%,d\n", diskon);
      System.out.println("--------------------------------------------------");
      System.out.printf("TOTAL BAYAR               : Rp%,d\n", total);
      System.out.println("==================================================");
      System.out.println("   Terima kasih telah berbelanja di " + nama + "!");
      System.out.println("==================================================\n");
   }
}
