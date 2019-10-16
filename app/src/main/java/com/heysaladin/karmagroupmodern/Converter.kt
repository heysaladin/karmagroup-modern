package com.heysaladin.karmagroupmodern

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView


object Converter {

    fun convertLayoutToImage(mContext: Context, count: Int, drawableId: Int): Drawable {
        val inflater = LayoutInflater.from(mContext)
        val view = inflater.inflate(R.layout.badge_icon_layout, null)
        (view.findViewById(R.id.icon_badge) as ImageView).setImageResource(drawableId)
//        val counterTextPanel = view.findViewById(R.id.counterValuePanel)
        if (count == 0) {

//            counterTextPanel.setVisibility(View.GONE)
        } else {
            val textView = view.findViewById(R.id.count) as TextView
            textView.text = "" + count
        }

        view.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED))
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight())

        view.setDrawingCacheEnabled(true)
        view.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH)
        val bitmap = Bitmap.createBitmap(view.getDrawingCache())
        view.setDrawingCacheEnabled(false)

        return BitmapDrawable(mContext.resources, bitmap)
    }
}
