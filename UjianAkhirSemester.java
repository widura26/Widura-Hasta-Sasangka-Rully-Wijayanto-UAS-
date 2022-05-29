import java.util.LinkedList;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.*;

public class UjianAkhirSemester  {

    private static LinkedList<String> penyimpanan = new LinkedList<String>();
    private static Scanner scan(){
        return new Scanner(System.in);
    }

    static String data, nomor;

    private static void hapusData(){
        while(true){
            System.out.println("---------------------------------------");
            System.out.println("---- 1. Hapus Data Barang awal --------");
            System.out.println("---- 2. Hapus Data Barang akhir -------");
            System.out.println("---- 3. Hapus data Barang -------------");
            System.out.println("---- 4. Back --------------------------");
            System.out.print("----------------------------- Pilih : ");
            int pilih = scan().nextInt();

            switch(pilih){
                case 1:
                    penyimpanan.removeFirst();
                    System.out.println("--------------- terhapus --------------"); break;
                case 2:
                    penyimpanan.removeLast();
                    System.out.println("--------------- terhapus --------------"); break;
                case 3:
                    int indexData = 0;
                    System.out.print("Pilih index Data barang yang ingin dihapus: [0-" + (penyimpanan.size() - 1) + "]: "); 
                    indexData = scan().nextInt();
                    penyimpanan.remove(indexData);
                    System.out.println("--------------- terhapus --------------");
                    break;
                case 4:
                    menu(); break;
            }
        }
    }

    private static void tambahData(){
        while(true){
            Scanner input = new Scanner(System.in);
            System.out.println("---------------------------------------");
            System.out.println("---- 1. Tambah Data Barang ------------");
            System.out.println("---- 2. Sisipkan Data Barang Awal -----");
            System.out.println("---- 3. Sisipkan Data Barang Akhir ----");
            System.out.println("---- 4. Sisipkan Data -----------------");
            System.out.println("---- 5. Kembali -----------------------");
            System.out.print("----------------------------- Pilih : ");
            int pilih = input.nextInt();

            if(pilih == 1){
                    System.out.print("Nama Produk : ");
                    data = scan().nextLine();
                    System.out.print("Tipe        : ");
                    nomor = scan().nextLine();
                    penyimpanan.add("(" + data + " / " + nomor + ")");
                    System.out.println("---------- data dimasukkan ------------");
            }else if(pilih == 2){
                    System.out.print("Nama Produk : ");
                    data = scan().nextLine();
                    System.out.print("Tipe        : ");
                    nomor = scan().nextLine();
                    penyimpanan.addFirst("(" + data + " / " + nomor + ")");
                    System.out.println("---------- data dimasukkan ------------");
            }else if(pilih == 3){
                    System.out.print("Nama Produk : ");
                    data = scan().nextLine();
                    System.out.print("Tipe        : ");
                    nomor = scan().nextLine();
                    penyimpanan.addLast("(" + data + " / " + nomor + ")");
                    System.out.println("---------- data dimasukkan ------------");
            }else if(pilih == 4){
                    int indexData = 0;
                    System.out.print("Sisipkan barang di data ke - " + "(0- " + (penyimpanan.size() - 1) +") : ");
                    indexData = scan().nextInt();
                    System.out.print("Nama Produk " + indexData + " : ");
                    String data = scan().nextLine();
                    System.out.print("Tipe          : ");
                    nomor = scan().nextLine();
                    penyimpanan.add(indexData, "(" + data + " / " + nomor + ")");
                    System.out.println("---------- data dimasukkan ------------");
            }else if(pilih == 5){
                menu();
            }    
        }
    }

    private static void keluar(){
        System.exit(10);
    }

    private static void storage(){
        if(penyimpanan.size() == 0){
            System.out.println("------------- data kosong -------------");
            System.out.println("---------------------------------------");
        }else if( penyimpanan.size() != 0){
            System.out.println("Produk : " + penyimpanan);
            System.out.println("total : " + penyimpanan.size());
            System.out.println(" ");
        }
        
    }

    private static void masuk(){
        int pilih = 0;
        boolean masuk = true;
        while(masuk){
            try{
                masuk = false;
                System.out.print("----------------------------- Pilih :");
                System.out.print(" ");
                pilih = scan().nextInt();
            }catch(InputMismatchException e){
                System.out.println("-------- Masukkan harus Angka ---------");
                masuk = true;
            }
        }
        switch(pilih){
            case 1: tambahData(); break;
            case 2: hapusData(); break;
            case 3: storage(); break;
            case 4: keluar(); break;
        }
        menu();
    }

    private static void menu(){
        System.out.println("---------------------------------------");
        System.out.println("---- 1. Input Data Barang -------------");
        System.out.println("---- 2. Hapus Data Barang -------------");
        System.out.println("---- 3. Penyimpanan -------------------");
        System.out.println("---- 4. Keluar ------------------------");
        masuk();
    }

    public static void main(String[] args){
        menu();
    }
}
    