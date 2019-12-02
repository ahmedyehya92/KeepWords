package com.intellidev.keepwords.features.translations_list

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.intellidev.entities.Translations
import com.intellidev.entities.WordTranslation
import com.intellidev.entities.WordTranslationsList
import com.intellidev.keepwords.R
import com.intellidev.keepwords.features.words_list.WordsListActivity
import kotlinx.android.synthetic.main.activity_translations_list.*

class TranslationsListActivity : AppCompatActivity(), AdapterTranslationsList.CustomeListener {


    val translationsList: MutableList<WordTranslationsList> = ArrayList()
    val wordsList: MutableList<WordTranslation> = ArrayList()
    lateinit var adapter: AdapterTranslationsList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_translations_list)

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

        var adapter: AdapterTranslationsList
        adapter = AdapterTranslationsList(translationsList, this)

        adapter.setCustomButtonListner(this)

        rv_translations.adapter = adapter
        //adapter.addAll(translationsList)
    }

    override fun onClickItem(position: Int, translation: WordTranslationsList) {
        WordsListActivity.instaniateIntent(this,position, Translations(translationsList)).apply {
            startActivity(this)
        }
    }

    override fun onClickDelete(position: Int, translation: WordTranslationsList) {
    }
}
