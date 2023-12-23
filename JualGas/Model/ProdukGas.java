package Model;
public class ProdukGas {   
    private String nama;
    private int harga;
    
    public ProdukGas(String nama, int harga) {
        this.nama = nama;
        this.harga = harga;
    }
    
    public String getNama() {
        return nama;
    }
    
    public int getHarga() {
        return harga;
    }

}
