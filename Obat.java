

public class Obat {
    String nama;
    int harga;
    int stok;
    int kategori;

    Obat(String nama, int harga, int stok, int kategori){
        this.nama = nama;
        this. harga = harga;
        this.stok = stok;
        this.kategori = kategori;
    }

    void setStock(int pengeluaranStok){
        this.stok = this.stok - pengeluaranStok;
    }
}
