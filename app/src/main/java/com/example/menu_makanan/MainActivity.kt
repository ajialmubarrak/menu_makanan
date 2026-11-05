package com.example.menu_makanan

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.menu_makanan.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var foodAdapter: FoodAdapter


    private val fullDataList = ArrayList<Food>()

    private val displayList = ArrayList<Food>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initData()
        setupRecyclerView()
        setupFilterButtons()
    }

    private fun initData() {
        fullDataList.clear()


        fullDataList.add(Food(1, "Nasi Goreng Special", "Rp 25.000", "Nasi goreng dengan telur, ayam suwir, dan kerupuk.",
            R.drawable.nasi_goreng, "makanan"))
        fullDataList.add(Food(2, "Mie Ayam Bakso", "Rp 18.000", "Mie ayam dengan tambahan 2 bakso sapi dan pangsit.",
            R.drawable.mie_ayam, "makanan"))
        fullDataList.add(Food(3, "Ayam Bakar Madu", "Rp 28.000", "Ayam bakar bumbu madu disajikan dengan sambal terasi.",
            R.drawable.ayam_bakar, "makanan"))


        fullDataList.add(Food(4, "Es Teh Manis", "Rp 5.000", "Es teh manis segar ukuran jumbo.",
            R.drawable.es_teh, "minuman"))
        fullDataList.add(Food(5, "Jus Alpukat", "Rp 12.000", "Jus alpukat asli dengan topping kental manis cokelat.",
            R.drawable.jus_alpukat, "minuman"))
        fullDataList.add(Food(6, "Es Jeruk Segar", "Rp 7.000", "Perasan jeruk peras alami dengan es batu segar.",
            R.drawable.es_jeruk, "minuman"))
        fullDataList.add(Food(7, "Kopi Susu Gula Aren", "Rp 15.000", "Espresso dengan susu segar dan sirup gula aren asli.",
            R.drawable.kopi_susu, "minuman"))
        fullDataList.add(Food(8, "Matcha Latte", "Rp 18.000", "Minuman teh hijau jepang dipadu dengan susu murni.",
            R.drawable.matcha_latte, "minuman"))


        displayList.addAll(fullDataList)
    }

    private fun setupRecyclerView() {
        foodAdapter = FoodAdapter(displayList)
        binding.rvMakanan.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = foodAdapter
        }
    }
    private fun setupFilterButtons() {
        binding.btnAll.setOnClickListener {
            filterData("all")
        }

        binding.btnMakanan.setOnClickListener {
            filterData("makanan")
        }
        binding.btnMinuman.setOnClickListener {
            filterData("minuman")
        }
    }
    private fun filterData(category: String) {
        displayList.clear()
        if (category == "all") {
            displayList.addAll(fullDataList)
        } else {
            val filtered = fullDataList.filter { it.kategori.equals(category, ignoreCase = true) }
            displayList.addAll(filtered)
        }
        foodAdapter.notifyDataSetChanged()
    }
}