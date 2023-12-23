package Logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Model.Customer;
import Model.ProdukGas;
import Model.Transaksi;


// Kelas utama untuk menguji implementasi
public class Logic {
    // Data login sederhana (username dan password)
    private static final String USERNAME = "jajang";
    private static final String PASSWORD = "uasdaspro";

    // Deklarasi BufferedReader
    protected static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    // Function login    
    protected static boolean login() {
        try {
            System.out.println("=== Login ===");
            System.out.print("Masukkan username: ");
            String enteredUsername = reader.readLine();

            System.out.print("Masukkan password: ");
            String enteredPassword = reader.readLine();

            // Periksa apakah username dan password sesuai dengan yang diharapkan
            return enteredUsername.equals(USERNAME) && enteredPassword.equals(PASSWORD);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Method program utama 
    protected static void runGasApp() {
        // Membuat array objek ProdukGas
        ProdukGas[] produkGas = {
            new ProdukGas("Gas LPG 3kg", 13000),
            new ProdukGas("Gas LPG 5kg", 100000),
            new ProdukGas("Gas LPG 12kg", 200000)
        };

        // Menampilkan detail objek-objek ProdukGas
        System.out.println("Detail ProdukGas:");
        System.out.println("1. " + produkGas[0].getNama() + " - Harga: Rp." + produkGas[0].getHarga());
        System.out.println("2. " + produkGas[1].getNama() + " - Harga: Rp." + produkGas[1].getHarga());
        System.out.println("3. " + produkGas[2].getNama() + " - Harga: Rp." + produkGas[2].getHarga());

        try {
            System.out.print("Masukkan nama pelanggan: ");
            String customerName = reader.readLine();

            // Membuat objek pelanggan
            Customer customer = new Customer(customerName);

            // Membaca input nomor produk yang dibeli
            System.out.print("Masukkan nomor produk yang dibeli (1, 2, atau 3): ");
            int nomorProduk = Integer.parseInt(reader.readLine());

            ProdukGas pilihProduk;
            switch (nomorProduk) {
                case 1:
                    pilihProduk = produkGas[0];
                    break;
                case 2:
                    pilihProduk = produkGas[1];
                    break;
                case 3:
                    pilihProduk = produkGas[2];
                    break;
                default:
                    System.out.println("Pilih sesuai nomor yaa :)");
                    runGasApp();
                    return;
            }
            // Membaca input jumlah produk yang dibeli
            System.out.print("Masukkan jumlah produk yang dibeli: ");
            int quantity = Integer.parseInt(reader.readLine());
            Transaksi transaksi = new Transaksi(pilihProduk, customer, quantity);
            // Menampilkan detail transaksi
            System.out.println("\nDetail Transaksi:" + "\n===============");
            System.out.println(transaksi.getTransaksi());
            System.out.println("===============\n");
            System.out.println("Lanjutkan beli gas? (y/n)");
            boolean tampilUlang = true;
            do {
                String lanjut = reader.readLine();
                switch (lanjut) {
                    case "y":
                        runGasApp();
                        break;
                    case "n":
                        System.out.println("\n==============="
                        +"\nTerimakasih sudah beli gas, datang lagi ya!" 
                        + "\n===============");
                         tampilUlang = false;                      
                        break;
                    default:
                        System.out.println("Pilih sesuai pilihannya yaa :) \nMaaf anda harus login ulang");
                        tampilUlang = false;
                        break;
            }
            }while (tampilUlang);
            
                
            } catch (IOException e) {
             e.printStackTrace();
        }
    
    }
}

