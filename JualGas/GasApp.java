import java.io.IOException;

import Logic.Logic;

class GasApp extends Logic {
    public static void main(String[] args) {
        // Meminta pengguna untuk login
        if (login()) {
            // Jika login berhasil, lanjutkan ke program utama
            runGasApp();
        } else {
            System.out.println("Login gagal. Program berakhir.");
        }

        // Menutup BufferedReader setelah selesai digunakan
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
}
