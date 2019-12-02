package com.intellidev.keepwords.features.words_list

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.util.Log
import com.intellidev.entities.*
import com.intellidev.keepwords.R
import kotlinx.android.synthetic.main.activity_words_list.*

class WordsListActivity : AppCompatActivity() {

    val translationsList: MutableList<WordTranslationsList> = ArrayList()
    var adapterTranslationsListViewPager: AdapterTranslationsListViewPager? = null
    val wordsList: MutableList<WordTranslation> = ArrayList()
    lateinit var adapter: AdapterWordsList

    companion object {
        fun instaniateIntent(context: Context, position: Int, translations: Translations): Intent
        {
            return Intent(context, WordsListActivity::class.java).apply {
                this.putExtra(KEY_POSITION, position)
                this.putExtra(KEY_TRANSLATIONS_DATA, translations)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_words_list)

        initTranslationsSlider((intent.getSerializableExtra(KEY_TRANSLATIONS_DATA) as Translations).translationsList)

        page_slider.currentItem = intent.getIntExtra(KEY_POSITION,0)

    }

    private fun initTranslationsSlider(translationsList: MutableList<WordTranslationsList>)
    {
        page_slider.clipToPadding = false;
        page_slider.offscreenPageLimit = translationsList.size
        adapterTranslationsListViewPager = AdapterTranslationsListViewPager(translationsList, this)
        page_slider.adapter = adapterTranslationsListViewPager

        page_slider.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(p0: Int) {

            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
            }

            override fun onPageSelected(p0: Int) {
                adapterTranslationsListViewPager!!.selectPage(p0)
            }

        })
    }

    fun makeAnotherTabsDeselected(selectedPosition: Int)
    {
        translationsList.forEachIndexed { index, wordTranslationsList ->
            if(index != selectedPosition)
                wordTranslationsList.selected = false
        }
    }
}
