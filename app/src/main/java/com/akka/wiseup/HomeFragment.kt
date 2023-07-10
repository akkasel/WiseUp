package com.akka.wiseup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.akka.wiseup.adapter.KelasPopulerBulanIniAdapter
import com.akka.wiseup.adapter.KelasRekomendasiAdapter
import com.akka.wiseup.data.KategoriRekomendasi
import com.akka.wiseup.data.KelasTerpopuler


class HomeFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: KelasRekomendasiAdapter

    private lateinit var recyclerViewKelasTerpopulerDiBulanIni: RecyclerView
    private lateinit var adapterKelasTerpopulerDiBulanIni: KelasPopulerBulanIniAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // untuk recycler view horizontal bagian "Kategori Rekomendasi"
        recyclerView = view.findViewById(R.id.recyclerView)
        adapter = KelasRekomendasiAdapter(getItemList())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        // untuk recycler view horizontal bagian "Terpopuler di Bulan Ini"
        recyclerViewKelasTerpopulerDiBulanIni = view.findViewById(R.id.recyclerViewTerpopulerDiBulanIni)
        adapterKelasTerpopulerDiBulanIni = KelasPopulerBulanIniAdapter(getItemListKelasTerpopulerBulanIni())
        recyclerViewKelasTerpopulerDiBulanIni.adapter = adapterKelasTerpopulerDiBulanIni
        recyclerViewKelasTerpopulerDiBulanIni.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        return view
    }

    // Replace this with your own method to provide the item list
    // Untuk kelas yang ditampilkan pada Home->Kategori Rekomendasi
    private fun getItemList(): List<KategoriRekomendasi> {
        return listOf(
            KategoriRekomendasi(R.drawable.koran_gradasi, "Literasi Digital") {
                // Handle click for this item
            },
            KategoriRekomendasi(R.drawable.bali_gradasi, "Wawasan Budaya") {
                // Handle click for this item
            },
            KategoriRekomendasi(R.drawable.edukasi_seks, "Edukasi Seks") {
                // Handle click for this item
            },
            KategoriRekomendasi(R.drawable.bahasa_daerah, "Bahasa Daerah") {
                // Handle click for this item
            },
            KategoriRekomendasi(R.drawable.perpajakan, "Perpajakan") {
                // Handle click for this item
            },
            // Add more items as needed
        )
    }

    // Replace this with your own method to provide the item list
    // Untuk kelas yang ditampilkan pada Home->Kelas Terpopuler Bulan Ini
    private fun getItemListKelasTerpopulerBulanIni(): List<KelasTerpopuler> {
        return listOf(
            KelasTerpopuler(R.drawable.antihoax, "Belajar Cegah Hoax", "Tim WiseUp", this::navigateToCourseOverview1),
            KelasTerpopuler(R.drawable.adatsunda, "Belajar Bahasa Sunda", "Tim WiseUp") {
                // Handle click for this item
            },
            KelasTerpopuler(R.drawable.indonesia, "Warisan Budaya Betawi","Tim WiseUp") {
                // Handle click for this item
            },
            KelasTerpopuler(R.drawable.perpajakan2, "Belajar Bayar Pajak","Tim WiseUp") {
                // Handle click for this item
            },
            KelasTerpopuler(R.drawable.deepfake, "Mengenal Deepfake", "Tim WiseUp") {
                // Handle click for this item
            },
            KelasTerpopuler(R.drawable.taripiring, "Belajar Tari Piring", "Tim WiseUp") {
                // Handle click for this item
            }
            // Add more items as needed
        )
    }


    // pindah ke courseoverviewfragment setelah card "mengidentifikasi hoax" di-klik
    private fun navigateToCourseOverview1() {
        findNavController().navigate(R.id.action_destination_home_to_courseOverviewFragment)
    }



}