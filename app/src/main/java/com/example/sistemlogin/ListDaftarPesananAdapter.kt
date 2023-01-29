package com.example.sistemlogin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ListDaftarPesananAdapter(var listPesanan: ArrayList<Pesanan>) : RecyclerView.Adapter<ListDaftarPesananAdapter.ListViewHolder>()  {

    private lateinit var onItemClickCallback: ListMasakanAdapter.OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: ListMasakanAdapter.OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Pesanan)
    }

    init {
        listPesanan.add(Pesanan(Masakan("kari", "gurih", 12000, "nopal"), 12, "", emailPembeli = "nanda", emailMitra = "nopal", metodePembayaran = "mobile bank bni"))
        listPesanan.add(Pesanan(Masakan("soto makassar", "enak", 15000, "nopal"), 5, "", emailPembeli = "nanda", emailMitra = "nopal", metodePembayaran = "mobile bank bni"))
        listPesanan.add(Pesanan(Masakan("mie goreng", "pedas", 10000, "nopal"), 15, "", emailPembeli = "nanda", emailMitra = "nopal", metodePembayaran = "mobile bank bni"))
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var tvNama: TextView = itemView.findViewById(R.id.tv_item_nama_pesanan)
        var tvPorsi: TextView = itemView.findViewById(R.id.tv_item_porsi_pesanan)
        var tvMasakan: TextView = itemView.findViewById(R.id.tv_item_nama_masakan_pesanan)
        var buttonKonfirmasi: Button = itemView.findViewById(R.id.button_konfirmasi_pesanan)
        var context = itemView.context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_daftar_pesanan, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val pesanan = listPesanan[position]

        holder.tvNama.text = pesanan.getEmailPembeli()
        holder.tvPorsi.text = pesanan.getPorsi().toString()
        holder.tvMasakan.text = pesanan.getMasakan()?.getNama()
        holder.buttonKonfirmasi.setOnClickListener {
            Notifikasi(holder.context).show("Pesanan dikonfirmasi")
        }
    }

    override fun getItemCount(): Int {
        return listPesanan.size
    }
}