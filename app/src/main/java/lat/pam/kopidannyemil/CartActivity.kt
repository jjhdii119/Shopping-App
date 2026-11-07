package lat.pam.kopidannyemil

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cart)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 1. Ambil data pesanan dari CartManager
        val cartList = CartManager.cartList

        // 2. Tampilkan ke dalam RecyclerView
        val rvCart = findViewById<RecyclerView>(R.id.rvCart)
        rvCart.layoutManager = LinearLayoutManager(this)
        val adapter = CartAdapter(cartList)
        rvCart.adapter = adapter

        // 3. Hitung Total Harga
        val tvTotalPrice = findViewById<TextView>(R.id.tvTotalPrice)
        val totalPrice = CartManager.getTotalPrice()

        // Mengubah format angka menjadi format Rupiah (Contoh: 35000 -> Rp 35.000)
        val formattedPrice = String.format("%,d", totalPrice).replace(',', '.')
        tvTotalPrice.text = "Rp $formattedPrice"

        // 4. Logika Tombol Checkout
        val btnCheckout = findViewById<Button>(R.id.btnCheckout)
        btnCheckout.setOnClickListener {
            if (cartList.isEmpty()) {
                // Munculkan peringatan jika keranjang masih kosong
                Toast.makeText(this, "Pilih menu dulu ya, keranjangmu masih kosong!", Toast.LENGTH_SHORT).show()
            } else {
                // Lanjut ke form pengisian alamat yang sudah kita buat sebelumnya
                val intent = Intent(this, AddressActivity::class.java)
                startActivity(intent)
            }
        }
    }
}