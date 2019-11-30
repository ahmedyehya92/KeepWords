package com.intellidev.keepwords.features.words_list

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.annotation.ColorRes
import com.intellidev.entities.WordTranslationsList
import com.intellidev.keepwords.R
import com.intellidev.keepwords.customviews.CustomeFontTextView
import java.util.ArrayList

class AdapterTranslationsListViewPager (
    private val translationsList: MutableList<WordTranslationsList>,
    private val context: Context
) : PagerAdapter() {
    private var layoutInflater: LayoutInflater? = null


    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val view = layoutInflater!!.inflate(R.layout.view_item_translate_tap, container, false)

        val lout_translate_from = view.findViewById<LinearLayout>(R.id.lout_translate_from)
        val tv_translate_from = view.findViewById<CustomeFontTextView>(R.id.tv_translate_from)
        val lout_translate_to = view.findViewById<LinearLayout>(R.id.lout_translate_to)
        val tv_translate_to = view.findViewById<CustomeFontTextView>(R.id.tv_translate_to)

        val item = translationsList[position]

        tv_translate_from.text = item.translateFrom
        tv_translate_to.text = item.translateTo

        if (item.selected)
        {
            lout_translate_from.setBackgroundResource(R.drawable.shape_layout_half_top_radius_selected)
            lout_translate_to.setBackgroundResource(R.drawable.shape_layout_half_bottom_radius_selected)
            tv_translate_from.setTextColor(ContextCompat.getColor(context, R.color.white))
            tv_translate_to.setTextColor(ContextCompat.getColor(context, R.color.white))
        }
        else
        {
            lout_translate_from.setBackgroundResource(R.drawable.shape_layout_half_top_radius_deselected)
            lout_translate_to.setBackgroundResource(R.drawable.shape_layout_half_bottom_radius_deselected)
            tv_translate_from.setTextColor(ContextCompat.getColor(context, R.color.more_blue))
            tv_translate_to.setTextColor(ContextCompat.getColor(context, R.color.more_blue))
        }

        container.addView(view)

        return view
    }

    override fun getCount(): Int {
        return translationsList.size
    }


    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view === obj
    }


    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val view = `object` as View
        container.removeView(view)
    }

}