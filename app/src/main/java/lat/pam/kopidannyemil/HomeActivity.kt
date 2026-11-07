package lat.pam.kopidannyemil

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {

    private lateinit var adapter: MenuAdapter
    private lateinit var menuList: List<MenuModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 1. Masukkan 14 Data Menu Kafe Otentik
        menuList = listOf(
            MenuModel("Kopi Susu Aren", "Espresso dengan susu segar dan gula aren", "Rp 20.000", 20000, R.drawable.kopi_aren, "Minuman"),
            MenuModel("Americano Dingin", "Espresso murni dengan air es", "Rp 15.000", 15000, R.drawable.americano, "Minuman"),
            MenuModel("Matcha Latte", "Bubuk matcha premium dengan susu segar", "Rp 25.000", 25000, R.drawable.matcha_latte, "Minuman"),
            MenuModel("Coklat Panas", "Seduhan coklat premium tebal yang hangat", "Rp 18.000", 18000, R.drawable.hot_chocolate, "Minuman"),
            MenuModel("Red Velvet Latte", "Paduan red velvet dan susu krim manis", "Rp 22.000", 22000, R.drawable.red_velvet, "Minuman"),
            MenuModel("Caramel Macchiato", "Espresso, vanilla, dan sirup karamel", "Rp 28.000", 28000, R.drawable.caramel_macchiato, "Minuman"),
            MenuModel("Lychee Tea", "Teh manis segar dengan buah leci asli", "Rp 18.000", 18000, R.drawable.lychee_tea, "Minuman"),
            MenuModel("Croissant Butter", "Roti pastry renyah dan gurih ala Perancis", "Rp 18.000", 18000, R.drawable.croissant, "Makanan"),
            MenuModel("Roti Bakar Coklat", "Roti tebal dengan selai coklat lumer", "Rp 15.000", 15000, R.drawable.toast_choco, "Makanan"),
            MenuModel("Tiramisu", "Kue dessert Italia dengan kopi dan mascarpone", "Rp 25.000", 25000, R.drawable.tiramisu, "Makanan"),
            MenuModel("NY Cheesecake", "Cheesecake padat dan lembut khas New York", "Rp 30.000", 30000, R.drawable.cheese_cake, "Makanan"),
            MenuModel("Cinnamon Roll", "Roti gulung kayu manis dengan cream cheese", "Rp 22.000", 22000, R.drawable.cinnamon_roll, "Makanan"),
            MenuModel("Blueberry Muffin", "Muffin panggang lembut dengan buah blueberry", "Rp 18.000", 18000, R.drawable.muffin, "Makanan"),
            MenuModel("Fudgy Brownies", "Brownies coklat pekat yang padat dan legit", "Rp 20.000", 20000, R.drawable.brownies, "Makanan")
        )

        // 2. Setup RecyclerView
        val rvMenu = findViewById<RecyclerView>(R.id.rvMenu)
        rvMenu.layoutManager = LinearLayoutManager(this)
        adapter = MenuAdapter(menuList)
        rvMenu.adapter = adapter

        // 3. Logika Filter Kategori
        val btnSemua = findViewById<Button>(R.id.btnFilterSemua)
        val btnMinuman = findViewById<Button>(R.id.btnFilterMinuman)
        val btnMakanan = findViewById<Button>(R.id.btnFilterMakanan)

        btnSemua.setOnClickListener {
            adapter.updateData(menuList)
        }

        btnMinuman.setOnClickListener {
            val filtered = menuList.filter { it.category.equals("Minuman", ignoreCase = true) }
            adapter.updateData(filtered)
        }

        btnMakanan.setOnClickListener {
            val filtered = menuList.filter { it.category.equals("Makanan", ignoreCase = true) }
            adapter.updateData(filtered)
        }

        // 4. Navigasi Bawah
        val btnNavCart = findViewById<LinearLayout>(R.id.btnNavCart)
        val btnNavProfile = findViewById<LinearLayout>(R.id.btnNavProfile)

        btnNavCart?.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
        }

        btnNavProfile?.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }
}