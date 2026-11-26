public class Transaksi {
   private Barang[] keranjangBarang;
   private int[] jumlahBeli;
   private int totalItemKeranjang;
   private boolean KartuLangganan;

   public Transaksi(int var1, boolean var2) {
      this.keranjangBarang = new Barang[var1];
      this.jumlahBeli = new int[var1];
      this.totalItemKeranjang = 0;
      this.KartuLangganan = var2;
   }

   public void tambahKeKeranjang(Barang var1, int var2) {
      if (this.totalItemKeranjang < this.keranjangBarang.length) {
         this.keranjangBarang[this.totalItemKeranjang] = var1;
         this.jumlahBeli[this.totalItemKeranjang] = var2;
         ++this.totalItemKeranjang;
         System.out.println(var2 + "x " + var1.getNama() + " masuk ke keranjang.");
      } else {
         System.out.println("Keranjang belanja sudah penuh!");
      }

   }

   public long hitungSubtotal() {
      long var1 = 0L;

      for(int var3 = 0; var3 < this.totalItemKeranjang; ++var3) {
         var1 += this.keranjangBarang[var3].getHarga() * (long)this.jumlahBeli[var3];
      }

      return var1;
   }

   public long hitungDiskon(long var1) {
      double var3 = (double)0.0F;
      if (var1 >= 5000000L) {
         var3 += 0.1;
      }

      if (this.KartuLangganan) {
         var3 += 0.05;
      }

      return (long)((double)var1 * var3);
   }

   public void cetakStruk(String var1) {
      long var2 = this.hitungSubtotal();
      long var4 = this.hitungDiskon(var2);
      long var6 = var2 - var4;
      System.out.println("\n==================================================");
      System.out.println("           STRUK PEMBAYARAN " + var1.toUpperCase());
      System.out.println("==================================================");

      for(int var8 = 0; var8 < this.totalItemKeranjang; ++var8) {
         long var9 = this.keranjangBarang[var8].getHarga() * (long)this.jumlahBeli[var8];
         System.out.printf("%-20s (%dx) : Rp%,d\n", this.keranjangBarang[var8].getNama(), this.jumlahBeli[var8], var9);
      }

      System.out.println("--------------------------------------------------");
      System.out.printf("Subtotal                  : Rp%,d\n", var2);
      System.out.printf("Status Kartu Langganan    : %s\n", this.KartuLangganan ? "Aktif (Ekstra 5%)" : "Tidak Ada");
      System.out.printf("Total Diskon              : -Rp%,d\n", var4);
      System.out.println("--------------------------------------------------");
      System.out.printf("TOTAL BAYAR               : Rp%,d\n", var6);
      System.out.println("==================================================");
      System.out.println("   Terima kasih telah berbelanja di " + var1 + "!");
      System.out.println("==================================================\n");
   }
}
