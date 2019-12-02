package com.intellidev.keepwords.features.words_list

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v4.view.PagerAdapter
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.annotation.ColorRes
import com.intellidev.entities.WordTranslation
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
        val tv_translate_to = view.findViewById<CustomeFontTextView>(R.id.tv_translate_to)
        val rv_words = view.findViewById<RecyclerView>(R.id.rv_words)

        val item = translationsList[position]

        tv_translate_from.text = item.translateFrom
        tv_translate_to.text = item.translateTo

        var adapter: AdapterWordsList
        var wordsList: MutableList<WordTranslation> = ArrayList()
        adapter = AdapterWordsList(wordsList, context)

        //adapter.setCustomButtonListner(this)

        rv_words.adapter = adapter
        adapter.addAll(item.words)


        if (item.selected)
        {
            lout_translate_from.setBackgroundResource(R.drawable.shape_layout_half_top_radius_selected)
            tv_translate_from.setTextColor(ContextCompat.getColor(context, R.color.white))
            tv_translate_to.setTextColor(ContextCompat.getColor(context, R.color.white))
        }
        else
        {
            lout_translate_from.setBackgroundResource(R.drawable.shape_layout_half_top_radius_deselected)
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