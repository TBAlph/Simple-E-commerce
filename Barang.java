class Barang {
   private String nama;
   private long harga;

   public Barang(String nama, long harga) {
      this.nama = nama;
      this.harga = harga;
   }

   public String getNama() {
      return this.nama;
   }

   public long getHarga() {
      return this.harga;
   }
}
