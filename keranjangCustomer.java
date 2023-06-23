
class keranjangCustomer {
    node head;
    node tail;
    int length;
    int total;


    class node {
        Obat dataObat;
        int kuantitas;
        node next;

        node(Obat dataObat, int kuantitas){
            this.dataObat = dataObat;
            this.kuantitas = kuantitas;
        }
    }

    boolean lengthRendah(){
        return length == 1;
    }

    boolean lengthEmpty(){
        return length == 0;
    }

    void tambahkanKeranjang(Obat dataObat, int kuantitas){
        node keranjang = new node(dataObat, kuantitas);
        if (lengthEmpty()){
            head = keranjang;
        } else {
            tail.next = keranjang;
        }
        tail = keranjang;
        length++;
    }

    void hapusDariKeranjang(){
        tampilkanLinked(0);
        System.out.print("\nMasukan No urut Yang Ingin Di Hapus: ");
        int pilihhapus = Main.angka.nextInt();
        node penunjuk= head;
        node temp = head;
        int i = 1;
        if (lengthRendah()){
            penunjuk = null;
            length--;
        } else{
        while(i <= pilihhapus-1){
            temp = penunjuk;
            penunjuk = penunjuk.next;
            i++;
        }
        temp.next = penunjuk.next;
        penunjuk = null;
        System.out.println("\nBerhasil Terhapus");
        length--;
    }
}

    void tampilkanLinked(int penotalan){
        node penunjuk = head;
        int nomor = 1;
        int i = 1;
        if (lengthEmpty()){
            System.out.println("\nKeranjang Kosong");
        } else {
        while(i <= length){
            if (penunjuk.dataObat.kategori == 1){
                ObatSirup castSirup = (ObatSirup) penunjuk.dataObat;
                System.out.println();
                System.out.println(nomor+". Nama Obat: "+castSirup.nama);
                System.out.println("   Harga: "+castSirup.harga);
                System.out.println("   Jenis: "+castSirup.jenis);
                System.out.println("   Kuantias Pembelian: " + penunjuk.kuantitas);
                if (penotalan == 1){
                System.out.println("   Sisa Stok: " + penunjuk.dataObat.stok);
                }
                nomor++;
            }
            if (penunjuk.dataObat.kategori == 2){
                ObatTablet castTablet = (ObatTablet) penunjuk.dataObat;
                System.out.println();
                System.out.println(nomor +". Nama Obat: "+castTablet.nama);
                System.out.println("   Harga: "+castTablet.harga);
                System.out.println("   Jenis: "+castTablet.jenis);
                System.out.println("   Kuantias Pembelian: " + penunjuk.kuantitas);
                if (penotalan == 1){
                System.out.println("   Sisa Stok: " + penunjuk.dataObat.stok);
                }
                nomor++;
            }
            i++;
            penunjuk = penunjuk.next;
        }
    }
}

    void setTotal(){
        node penunjuk = head;
        int i = 1;
        while(i <= length){
            this.total += penunjuk.dataObat.harga * penunjuk.kuantitas;
            penunjuk = penunjuk.next;
            i++;
        }
    }

    void aturStok(){
        node penunjuk = head;
        int i = 1;
        while (i <= length){
            penunjuk.dataObat.setStock(penunjuk.kuantitas);
            penunjuk = penunjuk.next;
            i++;
        }
    }
}
