package com.intellidev.keepwords.features.words_list

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import com.intellidev.entities.WordTranslation
import com.intellidev.keepwords.R
import com.intellidev.keepwords.customviews.CustomeFontTextView

class AdapterWordsList (
    private val wordsList: MutableList<WordTranslation>,
    private val context: Context? = null
):  RecyclerView.Adapter<RecyclerView.ViewHolder>()
{
    lateinit var customeListener: CustomeListener

    override fun getItemCount() = wordsList.size


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var viewHolder: RecyclerView.ViewHolder? = null
        val mInflater = LayoutInflater.from(viewGroup.context)


        return WordsListItemViewHolder(
            mInflater.inflate(R.layout.view_item_word, viewGroup, false)
        )

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item: WordTranslation = wordsList[position]
        val itemViewHolder = holder as WordsListItemViewHolder
        itemViewHolder.tv_word_translate_from.text = item.word
        itemViewHolder.tv_word_translate_to.text = item.translation
        itemViewHolder.btn_delete.setOnClickListener {
            customeListener.onClickDelete(position, item)
        }
        itemViewHolder.lout_container.setOnClickListener {
            customeListener.onClickItem(item)
        }

    }


    override fun getItemViewType(position: Int): Int {
        return position
    }


    fun remove(r: WordTranslation) {
        val position = wordsList.indexOf(r)
        if (position > -1) {
            wordsList.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    fun clear() {
        while (itemCount > 0) {
            remove(getItem(0))
        }
    }

    fun getItem(position: Int): WordTranslation {
        return wordsList[position]
    }

    fun isEmpty(): Boolean {
        return itemCount == 0
    }

    fun add(r: WordTranslation) {
        wordsList.add(r)
        notifyItemInserted(wordsList.size - 1)

    }

    fun addAll(opResults: MutableList<WordTranslation>) {
        for (result in opResults) {
            add(result)
        }
    }


    interface CustomeListener {
        fun onClickItem(wordTranslation: WordTranslation)
        fun onClickDelete(position: Int, wordTranslation: WordTranslation)
    }

    fun setCustomButtonListner(listener: CustomeListener) {
        customeListener = listener
    }

    class WordsListItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val tv_word_translate_from by lazy { view.findViewById<CustomeFontTextView>(R.id.tv_word_translate_from) }
        val tv_word_translate_to by lazy { view.findViewById<CustomeFontTextView>(R.id.tv_word_translate_to) }
        val btn_delete by lazy { view.findViewById<ImageView>(R.id.btn_delete) }
        val lout_container by lazy { view.findViewById<LinearLayout>(R.id.lout_container) }

    }

}