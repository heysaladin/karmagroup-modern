package com.heysaladin.karmagroupmodern.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.heysaladin.karmagroupmodern.R
//import com.heysaladin.karmamodern.R
import com.heysaladin.karmagroupmodern.adapter.BeachAdapter.MyViewHolder
import com.heysaladin.karmagroupmodern.model.Beach
//import com.heysaladin.karmagroupmodern.model.Offers

class BeachAdapter(private val mContext: Context?, private var list: List<Beach>?) :
    RecyclerView.Adapter<MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView
        var published_at: TextView
        var date: TextView
        var day: TextView
        var mon: TextView
        var content: TextView
        var author: TextView
        var thumbnail: ImageView
        var panel: LinearLayout

        init {
            title = view.findViewById<View>(R.id.title_news) as TextView
            content = view.findViewById<View>(R.id.content) as TextView
            published_at = view.findViewById<View>(R.id.published_at) as TextView
            date = view.findViewById<View>(R.id.date) as TextView
            day = view.findViewById<View>(R.id.day) as TextView
            mon = view.findViewById<View>(R.id.mon) as TextView
            thumbnail = view.findViewById<View>(R.id.thumbnail) as ImageView
            author = view.findViewById<View>(R.id.author) as TextView
            panel = view.findViewById(R.id.panel)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_beach, parent, false)

        return MyViewHolder(itemView)
    }

//    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        val item = list!![position]
//        holder.title.text = item.title
//        holder.published_at.text = item.publishedAt
//        holder.content.text = item.description + "..."
//        holder.author.text = "#" + item.author
//        // loading album cover using Glide library
//        Glide.with(mContext).load(item.urlToImage).into(holder.thumbnail)
//        holder.panel.setOnClickListener {
//            /*Goto Detail Offers*/
//            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("" + item.url))
//            if (mContext != null) {
//                mContext.startActivity(browserIntent)
//            }
//        }
//    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = list!![position]
        if(item.title!!.length > 40) {
            holder.title.text = item.title.toString().substring(0, 40) + "..."
        } else {
            holder.title.text = item.title
        }
        holder.published_at.text = item.day
        holder.date.text = item.dt
        holder.day.text = item.day
        holder.mon.text = item.mo
        holder.content.text = item.modal_title // + "..."
        holder.author.text = "#" + item.time_s
        // loading album cover using Glide library
        Glide.with(mContext).load("https://karmagroup.com/karma-beach/images/events/" + item.bg).into(holder.thumbnail)
        holder.title.setOnClickListener {
            /*Goto Detail Offers*/
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://karmagroup.com/karma-beach/images/events/" + item.bg))
            if (mContext != null) {
                mContext.startActivity(browserIntent)
            }
        }
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    fun setData(_data: List<Beach>) {
        this.list = _data
    }
}
