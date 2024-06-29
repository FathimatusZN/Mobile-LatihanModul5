package com.example.latihanmodul5

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ListHandphoneAdapter(private val listHandphone:
                           ArrayList<Handphone>) :
    RecyclerView.Adapter<ListHandphoneAdapter.ListViewHolder>() {
    inner class ListViewHolder(private val binding:
                               ItemRowHandphoneBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(handphone: Handphone) {
            binding.apply {
                imgItemPhoto.setImageResource(handphone.photo)
                tvItemName.text = handphone.name
                tvItemDescription.text = handphone.description
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType:
    Int): ListViewHolder {
        val binding =
            ItemRowHandphoneBinding.inflate(LayoutInflater.from(parent.context)
                , parent, false)
        return ListViewHolder(binding)
    }
    override fun getItemCount(): Int = listHandphone.size
    override fun onBindViewHolder(holder: ListViewHolder, position:
    Int) {
        holder.bind(listHandphone[position])
    }
}
