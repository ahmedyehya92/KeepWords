package com.intellidev.keepwords.features.translations_list

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import com.intellidev.entities.WordTranslationsList
import com.intellidev.keepwords.R
import com.intellidev.keepwords.customviews.CustomeFontTextView

class AdapterTranslationsList (
    private val translationsList: MutableList<WordTranslationsList>,
    private val context: Context? = null
):  RecyclerView.Adapter<RecyclerView.ViewHolder>()
{
    lateinit var customeListener: CustomeListener

    override fun getItemCount() = translationsList.size

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var viewHolder: RecyclerView.ViewHolder? = null
        val mInflater = LayoutInflater.from(viewGroup.context)


        return TranslationsListItemViewHolder(
            mInflater.inflate(R.layout.view_item_language_translate_main, viewGroup, false)
        )

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item: WordTranslationsList = translationsList[position]
        val itemViewHolder = holder as TranslationsListItemViewHolder
        itemViewHolder.tv_translate_from.text = item.translateFrom
        itemViewHolder.tv_translate_to.text = item.translateTo
        itemViewHolder.btn_delete.setOnClickListener {
            customeListener.onClickDelete(position, item)
        }
        itemViewHolder.lout_container.setOnClickListener {
            customeListener.onClickItem(position, item)
        }

    }

    override fun getItemViewType(position: Int): Int {
        return position
    }


    fun remove(r: WordTranslationsList) {
        val position = translationsList.indexOf(r)
        if (position > -1) {
            translationsList.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    fun clear() {
        while (itemCount > 0) {
            remove(getItem(0))
        }
    }

    fun getItem(position: Int): WordTranslationsList {
        return translationsList[position]
    }

    fun isEmpty(): Boolean {
        return itemCount == 0
    }

    fun add(r: WordTranslationsList) {
        translationsList.add(r)
        notifyItemInserted(translationsList.size - 1)

    }

    fun addAll(opResults: MutableList<WordTranslationsList>) {
        for (result in opResults) {
            add(result)
        }
    }


    interface CustomeListener {
        fun onClickItem(position: Int, translation: WordTranslationsList)
        fun onClickDelete(position: Int, translation: WordTranslationsList)
    }

    fun setCustomButtonListner(listener: CustomeListener) {
        customeListener = listener
    }


    class TranslationsListItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val tv_translate_from by lazy { view.findViewById<CustomeFontTextView>(R.id.tv_translate_from) }
        val tv_translate_to by lazy { view.findViewById<CustomeFontTextView>(R.id.tv_translate_to) }
        val btn_delete by lazy { view.findViewById<ImageView>(R.id.btn_delete) }
        val lout_container by lazy { view.findViewById<LinearLayout>(R.id.lout_container) }
    }

}