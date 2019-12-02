package com.intellidev.keepwords.features.words_list

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import com.intellidev.entities.WordTranslation
import com.intellidev.entities.WordTranslationsList
import com.intellidev.keepwords.R
import kotlinx.android.synthetic.main.activity_words_list.*

class WordsListActivity : AppCompatActivity() {

    val translationsList: MutableList<WordTranslationsList> = ArrayList()
    var adapterTranslationsListViewPager: AdapterTranslationsListViewPager? = null
    val wordsList: MutableList<WordTranslation> = ArrayList()
    lateinit var adapter: AdapterWordsList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_words_list)

        wordsList.add(WordTranslation(1L,"book", "en", "book"))
        wordsList.add(WordTranslation(1L,"book", "en", "book"))
        wordsList.add(WordTranslation(1L,"book", "en", "book"))
        wordsList.add(WordTranslation(1L,"book", "en", "book"))
        wordsList.add(WordTranslation(1L,"book", "en", "book"))
        wordsList.add(WordTranslation(1L,"book", "en", "book"))
        wordsList.add(WordTranslation(1L,"book", "en", "book"))
        wordsList.add(WordTranslation(1L,"book", "en", "book"))
        wordsList.add(WordTranslation(1L,"book", "en", "book"))
        wordsList.add(WordTranslation(1L,"book", "en", "book"))
        wordsList.add(WordTranslation(1L,"book", "en", "book"))
        wordsList.add(WordTranslation(1L,"book", "en", "book"))
        wordsList.add(WordTranslation(1L,"book", "en", "book"))
        wordsList.add(WordTranslation(1L,"book", "en", "book"))
        wordsList.add(WordTranslation(1L,"book", "en", "book"))
        wordsList.add(WordTranslation(1L,"book", "en", "book"))
        wordsList.add(WordTranslation(1L,"book", "en", "book"))
        wordsList.add(WordTranslation(1L,"book", "en", "book"))
        wordsList.add(WordTranslation(1L,"book", "en", "book"))
        wordsList.add(WordTranslation(1L,"book", "en", "book"))
        wordsList.add(WordTranslation(1L,"book", "en", "book"))

        translationsList.add(WordTranslationsList(1L,"German", "English", "en",wordsList))
        translationsList.add(WordTranslationsList(1L,"German", "English", "en",wordsList))
        translationsList.add(WordTranslationsList(1L,"German", "English", "en",wordsList))
        translationsList.add(WordTranslationsList(1L,"German", "English", "en",wordsList))
        translationsList.add(WordTranslationsList(1L,"German", "English", "en",wordsList))
        translationsList.add(WordTranslationsList(1L,"German", "English", "en",wordsList))
        translationsList.add(WordTranslationsList(1L,"German", "English", "en",wordsList))
        translationsList.add(WordTranslationsList(1L,"German", "English", "en",wordsList))
        translationsList.add(WordTranslationsList(1L,"German", "English", "en",wordsList))
        translationsList.add(WordTranslationsList(1L,"German", "English", "en",wordsList))
        translationsList.add(WordTranslationsList(1L,"German", "English", "en",wordsList))
        translationsList.add(WordTranslationsList(1L,"German", "English", "en",wordsList))
        translationsList.add(WordTranslationsList(1L,"German", "English", "en",wordsList))
        translationsList.add(WordTranslationsList(1L,"German", "English", "en",wordsList))
        translationsList.add(WordTranslationsList(1L,"German", "English", "en",wordsList))
        translationsList.add(WordTranslationsList(1L,"German", "English", "en",wordsList))
        translationsList.add(WordTranslationsList(1L,"German", "English", "en",wordsList))
        translationsList.add(WordTranslationsList(1L,"German", "English", "en",wordsList))
        translationsList.add(WordTranslationsList(1L,"German", "English", "en",wordsList))
        translationsList.add(WordTranslationsList(1L,"German", "English", "en",wordsList))

        initTranslationsSlider(translationsList)

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
                translationsList[p0].selected = true
                makeAnotherTabsDeselected(p0)
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
