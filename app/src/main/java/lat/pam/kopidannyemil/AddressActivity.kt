package lat.pam.kopidannyemil

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AddressActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_address)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etAlamat = findViewById<EditText>(R.id.etAlamat)
        val btnLanjut = findViewById<Button>(R.id.btnLanjut)

        btnLanjut.setOnClickListener {
            // Validasi supaya alamat tidak boleh kosong
            if (etAlamat.text.isEmpty()) {
                Toast.makeText(this, "Alamat tidak boleh kosong!", Toast.LENGTH_SHORT).show()
            } else {
                // Pindah ke halaman konfirmasi pesanan
                val intent = Intent(this, OrderSuccessActivity::class.java)
                startActivity(intent)
                finish() // Tutup halaman alamat supaya tidak bisa di-back ke form kosong
            }
        }
    }
}