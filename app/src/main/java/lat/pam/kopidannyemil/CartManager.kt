package lat.pam.kopidannyemil

object CartManager {
    val cartList = mutableListOf<MenuModel>()

    // Fungsi untuk menambah menu ke keranjang
    fun addItem(item: MenuModel) {
        cartList.add(item)
    }

    // Fungsi untuk mengosongkan keranjang (setelah sukses bayar)
    fun clearCart() {
        cartList.clear()
    }

    // Fungsi untuk menghitung total belanjaan
    fun getTotalPrice(): Int {
        var total = 0
        for (item in cartList) {
            total += item.priceInt
        }
        return total
    }
}