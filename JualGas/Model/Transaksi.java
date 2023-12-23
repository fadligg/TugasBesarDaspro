package Model;

public class Transaksi {
   
        private ProdukGas produk;
        private Customer customer;
        private int quantity;
     
        public Transaksi(ProdukGas produk, Customer customer, int quantity) {
           this.produk = produk;
           this.customer = customer;
           this.quantity = quantity;
        }
       
     
        public int calculateTotal() {
           return this.produk.getHarga() * this.quantity;
        }
     
        public String getTransaksi() {
           String nama = this.customer.getNama();
           return "Customer: " + nama 
                  + "\nProduct: " + this.produk.getNama() 
                  + "\nQuantity: " + this.quantity 
                  + "\nTotal: Rp" + this.calculateTotal();
        }
        
        
}
