
public class GudangObat {
    Obat[] stokObat = new Obat[1];

    boolean lengthOut(){
        return stokObat.length == 0;
    }

    void tampilkanStok(){
        int i = 0;
        if (lengthOut()){
                stokObat = new Obat[1];
        }
        if(stokObat[0] != null){
            while (i < stokObat.length){
                if (stokObat[i].kategori == 1){
                    ObatSirup castSirup = (ObatSirup) stokObat[i];
                    System.out.println();
                    System.out.println(i + 1 + ". Nama Obat: "+castSirup.nama);
                    System.out.println("  Harga: "+castSirup.harga);
                    System.out.println("  Jenis: "+castSirup.jenis);
                    System.out.println("  Jumlah Stok: "+castSirup.stok);

                }
                if (stokObat[i].kategori == 2){
                    ObatTablet castTablet = (ObatTablet) stokObat[i];
                    System.out.println();
                    System.out.println(i+1+". Nama Obat: "+castTablet.nama);
                    System.out.println("  Harga: "+castTablet.harga);
                    System.out.println("  Jenis: "+castTablet.jenis);
                    System.out.println("  Jumlah Stok: "+castTablet.stok);

                }
                i++;
            }    
        } else {
            System.out.println("\nList Obat Kosong");
        }    
    }
    
    void tambahObat(){
        System.out.print("\nMasukkan nama obat: ");
        String inpNamaObat = Main.huruf.nextLine();
        System.out.print("Masukkan harga obat: ");
        int inpHargaObat = Main.angka.nextInt();
        System.out.print("Masukkan Jumlah Stok yang ingin ditambahkan: ");
        int inpStokObat = Main.angka.nextInt();
        System.out.println("Pilih jenis obat");
        System.out.println("1. Sirup");
        System.out.println("2. Tablet");
        int inpJenisObat = Main.angka.nextInt();
        switch (inpJenisObat) {
            case 1:
                Obat obatBaruSirup = new ObatSirup(inpNamaObat, inpHargaObat, inpStokObat);
                if (stokObat[0] == null){
                    stokObat[0] = obatBaruSirup;
                } else {
                    Obat[] obatSementara = stokObat;
                    stokObat = new Obat[stokObat.length +1];
                    int i = 0;
                    while(i < obatSementara.length){
                        stokObat[i] = obatSementara[i];
                        i++;
                    }
                    stokObat[obatSementara.length] = obatBaruSirup;
                }
                return;

            case 2:
                 Obat obatBaruTablet = new ObatTablet(inpNamaObat, inpHargaObat, inpStokObat);
                 if (stokObat[0] == null){
                    stokObat[0] = obatBaruTablet;
                } else {
                    Obat[] obatSementara = stokObat;
                    stokObat = new Obat[stokObat.length +1];
                    int i = 0;
                    while(i < obatSementara.length){
                        stokObat[i] = obatSementara[i];
                        i++;
                    }
                    stokObat[obatSementara.length] = obatBaruTablet;
                }
                return;

        
            default:
            System.out.println("Pilihan Salah");
                break;
        }
    }

    void hapusObat(){
        System.out.println("Masukan Urutan Obat Ke:");
        int urutanHapusObat = Main.angka.nextInt();

        int i = 0;
        int j = 0;
        if(lengthOut()){
            stokObat = new Obat[1];
        }
        if (stokObat[i].nama != null){
            Obat[] obatSementara = stokObat;
            obatSementara[urutanHapusObat -1] = null;
            stokObat = new Obat[stokObat.length -1];
            while(j< stokObat.length){
                if (obatSementara[i] == null){
                    i++;
                } else {
                    stokObat[j] = obatSementara[i];
                    i++;
                    j++;
                }
            }
        } else {
            System.out.println("Masih Kosong");
        }
    }

    void cariStock(){
        System.out.print("Masukan Obat Yang di Cari: ");
        String kataCari = Main.huruf.nextLine();
        int ketemu = 0;
        int i =0;
        while(i < stokObat.length){
            if (stokObat[i].nama.equalsIgnoreCase(kataCari)){
                System.out.println("Nama Obat: "+stokObat[i].nama);
                System.out.println("Harga Obat: "+stokObat[i].harga);
                System.out.println("Stok: "+stokObat[i].stok);
                ketemu++;
            }
            i++;
        }
        if (ketemu == 0){
            System.out.println("Pencarian Tidak Di Temukan");
        }
    }

    Obat menentukanUrutan(int urutan){
        return stokObat[urutan-1];
    }
}
