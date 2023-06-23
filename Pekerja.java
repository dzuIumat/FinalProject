

public class Pekerja {
    pesanan pesanan = new pesanan();
    static GudangObat gudangObat = new GudangObat();
    String username;
    String password;

    Pekerja(String user, String pass){
        this.username = user;
        this.password = pass;
    }

    boolean cekAkun(){
        System.out.println("Masukkan username :");
        String user = Main.huruf.nextLine();
        System.out.println("Masukkan Password :");
        String pass = Main.huruf.nextLine();
        if (user.equals(this.username) && pass.equals(this.password)) {
            System.out.println("\nBerhasil LOGIN");
            return true;
        }
        else {
            System.out.println("\nAkun tidak ada");
            return false;
        }
    }

    void opsi(){
        boolean loopingawal = true;
        while(loopingawal == true){
            System.out.println("\nMasukan Opsional");
            System.out.println("1. Tambah Obat");
            System.out.println("2. Hapus Obat");
            System.out.println("3. Cari Obat");
            System.out.println("4. Buat Pesanan");
            System.out.println("5. Cek List Obat");
            System.out.println("6. Keluar");
            int pilih = Main.angka.nextInt();
            switch (pilih) {
                case 1:
                    gudangObat.tampilkanStok();
                    gudangObat.tambahObat();
                    gudangObat.tampilkanStok();
                break;
                
                case 2:                
                    gudangObat.tampilkanStok();
                    gudangObat.hapusObat();
                    gudangObat.tampilkanStok();
                    break;

                case 3:
                    gudangObat.cariStock();
                    break;

                case 4:
                    loopingawal = pesanan.opsiPesan();                
                    break;

                case 5:
                    gudangObat.tampilkanStok();
                    break;

                case 6:
                    return;
                    
                default:
                    System.out.println("Pilihan Tidak Tepat");
                    break;
                }
            }
        }
    }
