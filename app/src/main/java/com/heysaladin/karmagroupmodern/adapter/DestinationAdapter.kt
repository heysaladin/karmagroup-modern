package com.heysaladin.karmagroupmodern.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.heysaladin.karmagroupmodern.R
import com.heysaladin.karmagroupmodern.adapter.DestinationAdapter.MyViewHolder
import com.heysaladin.karmagroupmodern.model.CategoryGroup

class DestinationAdapter(private val mContext: Context?, private var list: List<CategoryGroup>?) :
    RecyclerView.Adapter<MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView
        var published_at: TextView
        var content: TextView
        var author: TextView
        var thumbnail: ImageView
        var panel: LinearLayout

        init {
            title = view.findViewById<View>(R.id.title_news) as TextView
            content = view.findViewById<View>(R.id.content) as TextView
            published_at = view.findViewById<View>(R.id.published_at) as TextView
            thumbnail = view.findViewById<View>(R.id.thumbnail) as ImageView
            author = view.findViewById<View>(R.id.author) as TextView
            panel = view.findViewById(R.id.panel)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_destination, parent, false)

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
//            /*Goto Detail News*/
//            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("" + item.url))
//            if (mContext != null) {
//                mContext.startActivity(browserIntent)
//            }
//        }
//    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = list!![position]
        holder.title.text = item.menuName
        holder.published_at.text = item.menuName
        if(item.subGroupNames?.size!! < 2) {
            holder.content.text = item.subGroupNames?.size.toString() + " Product"
        }else {
            holder.content.text = item.subGroupNames?.size.toString() + " Products"//item.menuName + "..."
        }
        holder.author.text = "#" + item.menuName
        // Log.e("NAME:", ">>>>>>>>>>>>>>>>>>>>>> " + item.menuName)
        if(item.menuName.equals("Karma Resorts")) {
            Glide.with(mContext).load("https://storage.googleapis.com/karmagroup-d66ca.appspot.com/karmagroupcdn/2018/08/d9b1af60-karma-group-og-image.jpg").into(holder.thumbnail)
        } else if(item.menuName.equals("Karma Retreats")) {
            Glide.with(mContext).load("https://storage.googleapis.com/karmagroup-d66ca.appspot.com/karmagroupcdn/2016/10/Karma-Mayura-Header-D.jpg").into(holder.thumbnail)
        }  else if(item.menuName.equals("Karma Royal")) {
            Glide.with(mContext).load("https://karmagroup.com/wp-content/uploads/2016/10/5.__Karma-Royal-Palms-Karma_Royal_Palms__Pool_Area.jpg").into(holder.thumbnail)
        }  else if(item.menuName.equals("Karma Royal Residences")) {
            Glide.with(mContext).load("https://storage.googleapis.com/karmagroup-d66ca.appspot.com/karmagroupcdn/Destinations/Karma-Royal-Residences/Karma-Palacio-Elefante/Gallery/Karma-Palacio-Elefante-India-Gallery-12.jpg").into(holder.thumbnail)
        }  else if(item.menuName.equals("Karma Estate")) {
            Glide.with(mContext).load("https://storage.googleapis.com/karmagroup-d66ca.appspot.com/karmagroupblogcdn/2017/04/le-preverger-st-tropez-karma-group-940x627.jpg").into(holder.thumbnail)
        }  else if(item.menuName.equals("Karma Sanctum")) {
            Glide.with(mContext).load("https://hirespace.imgix.net/spaces/163421/r4a42nyzvoq.jpg").into(holder.thumbnail)
        }  else if(item.menuName.equals("Karma Beach")) {
            Glide.with(mContext).load("https://cdn.water-sports-bali.com/wp-content/uploads/2019/04/Karma-Beach-Ungasan-Bali-Feature-Image.jpg").into(holder.thumbnail)
        }  else if(item.menuName.equals("Karma Restaurants")) {
            Glide.with(mContext).load("https://www.threesixtyguides.com/wp-content/uploads/2015/12/dimare-0.jpg").into(holder.thumbnail)
        }  else if(item.menuName.equals("Karma Spa")) {
            Glide.with(mContext).load("https://media.travelingyuk.com/wp-content/uploads/2019/02/karma.kandara.bali_15_2_2019_16_39_6_173-1024x683.jpg").into(holder.thumbnail)
        } else {
            // loading album cover using Glide library
            Glide.with(mContext).load(item.banner).into(holder.thumbnail)
        }
        holder.title.setOnClickListener {
            /*Goto Detail News*/
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("" + item.banner))
            if (mContext != null) {
                mContext.startActivity(browserIntent)
            }
        }
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    fun setData(_data: List<CategoryGroup>) {
        this.list = _data
    }
}
