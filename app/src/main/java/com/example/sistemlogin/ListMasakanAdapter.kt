package com.example.sistemlogin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListMasakanAdapter(private val listMasakan: ArrayList<Masakan>): RecyclerView.Adapter<ListMasakanAdapter.ListViewHolder>()  {
    private lateinit var onItemClickCallback: OnItemClickCallback
//    private lateinit var btnMoveDetailActivity: KateringActivity

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var tvNama: TextView = itemView.findViewById(R.id.tv_nama_masakan)
        var tvDesk : TextView = itemView.findViewById(R.id.tv_item_deskripsi)
        var imgPhoto : ImageView = itemView.findViewById(R.id.tv_img_photo_masakan)
        //var tvHarga : TextView = itemView.findViewById(R.id.tv_item_harga)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Masakan)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_masakan, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val masakan = listMasakan[position]

//        Glide.with(holder.itemView.context)
//            .load(masakan.photo)
//            .apply(RequestOptions().override(150, 170))
//            .into(holder.imgPhoto)

//        holder.tvNama.text = masakan.nama
//        holder.tvDesk.text = masakan.deskripsi
        holder.tvNama.text = masakan.getNama()
        holder.tvNama.text = masakan.getDeskripsi()

        //holder.tvHarga.text = masakan.harga

        holder.itemView.setOnClickListener{ onItemClickCallback.onItemClicked(listMasakan[holder.adapterPosition])}
    }

    override fun getItemCount(): Int {
        return listMasakan.size
    }
}