
import java.util.*;

public class Main {
    static Scanner angka = new Scanner(System.in);
    static Scanner huruf = new Scanner(System.in);
 
    public static void main(String[] args) {
        Pekerja pekerja = new Pekerja("admin", "123");
            boolean validasi = pekerja.cekAkun();
            if(validasi == true){
                pekerja.opsi();
            }
        }
    }