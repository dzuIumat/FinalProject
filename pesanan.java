
class pesanan {
    static keranjangCustomer keranjang = new keranjangCustomer();
    int bayar;
    int kembalian;

    void cariKembalian(int total) {
        this.kembalian = bayar - total;
    }

    boolean opsiPesan() {
        Pekerja.gudangObat.tampilkanStok();
        System.out.println("\nTekan 0 untuk Hapus Dari Keranjang");
        System.out.print("No Urut Obat Yang di beli: ");
        int nourut = Main.angka.nextInt();
        if (nourut == 0) {
            keranjang.hapusDariKeranjang();
            keranjang.tampilkanLinked(0);
        } else {
            System.out.print("Masukan Kuantitasnya: ");
            int Kuantitasnya = Main.angka.nextInt();
            Obat yangDiBeli = Pekerja.gudangObat.menentukanUrutan(nourut);
            keranjang.tambahkanKeranjang(yangDiBeli, Kuantitasnya);
            keranjang.tampilkanLinked(0);
            System.out.println("Orderan Selesai? (y/n)");
            String selesaiorder = Main.huruf.nextLine();
            if (selesaiorder.equalsIgnoreCase("y")) {
                notaTotal();
                return false;
            }
        }
        return true;
    }

    void notaTotal() {
        keranjang.setTotal();
        keranjang.aturStok();
        System.out.println("List Pesanan Obat");
        System.out.println();
        keranjang.tampilkanLinked(1);
        System.out.println("\nTotal Keseluruhan: " + keranjang.total);
        System.out.print("Nominal Pembayaran: ");
        this.bayar = Main.angka.nextInt();
        cariKembalian(keranjang.total);
        System.out.println("\nJumlah Pembayaran: " + this.bayar);
        System.out.println("Kembalian: " + this.kembalian);
    }
}
