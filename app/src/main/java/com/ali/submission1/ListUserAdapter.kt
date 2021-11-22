package com.ali.submission1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListUserAdapter(private val listUser:ArrayList<userdata>):RecyclerView.Adapter<ListUserAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }


    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgavatar:ImageView = itemView.findViewById(R.id.imgavatar)
        var txtname:TextView = itemView.findViewById(R.id.txtname)
        var txtcompany:TextView = itemView.findViewById(R.id.txtcompany)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view:View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_user,viewGroup,false)
        return  ListViewHolder(view)
    }

    override fun getItemCount(): Int = listUser.size


    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (Username,Name,Avatar,Company,Location,Repository,Follower,Following) = listUser[position]
        holder.imgavatar.setImageResource(Avatar)
        Glide.with(holder.imgavatar.context).load(Avatar).circleCrop().into(holder.imgavatar)
        holder.txtname.text = Name
        holder.txtcompany.text=Company

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listUser[holder.adapterPosition])
        }

    }

    interface OnItemClickCallback {
        fun onItemClicked(data: userdata)
    }
}