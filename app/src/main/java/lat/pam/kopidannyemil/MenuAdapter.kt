package lat.pam.kopidannyemil

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class MenuAdapter(private var menuList: List<MenuModel>) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgMenu: ImageView = itemView.findViewById(R.id.imgMenu)
        val tvCategory: TextView = itemView.findViewById(R.id.tvCategory)
        val tvMenuName: TextView = itemView.findViewById(R.id.tvMenuName)
        val tvMenuDesc: TextView = itemView.findViewById(R.id.tvMenuDesc)
        val tvMenuPrice: TextView = itemView.findViewById(R.id.tvMenuPrice)
        val btnAdd: CardView = itemView.findViewById(R.id.btnAdd)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_menu, parent, false)
        return MenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val menu = menuList[position]
        holder.tvMenuName.text = menu.name
        holder.tvMenuDesc.text = menu.description
        holder.tvMenuPrice.text = menu.price
        holder.tvCategory.text = menu.category.uppercase()
        holder.imgMenu.setImageResource(menu.imageResId)

        // Aksi ketika tombol "+" diklik
        holder.btnAdd.setOnClickListener {
            // 1. Masukkan menu ke keranjang (Singleton Object)
            CartManager.addItem(menu)
            // 2. Munculkan notifikasi pop-up (Toast)
            Toast.makeText(holder.itemView.context, "${menu.name} masuk keranjang!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return menuList.size
    }

    fun updateData(newList: List<MenuModel>) {
        menuList = newList
        notifyDataSetChanged()
    }
}