package lat.pam.kopidannyemil

data class MenuModel(
    val name: String,
    val description: String,
    val price: String, // Untuk ditampilkan di layar (contoh: "Rp 15.000")
    val priceInt: Int, // Untuk dihitung komputernya (contoh: 15000)
    val imageResId: Int,
    val category: String
)