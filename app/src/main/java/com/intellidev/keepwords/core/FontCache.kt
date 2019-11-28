package com.intellidev.keepwords.core

import android.content.Context
import android.graphics.Typeface
import java.util.HashMap

class FontCache (val assetPath: String, val context: Context) {

    private val sCachedFonts = HashMap<String, Typeface>()

    val typeface: Typeface? get() {
        if (!sCachedFonts.containsKey(assetPath)) {
            val tf = Typeface.createFromAsset(context.assets, assetPath)
            sCachedFonts[assetPath] = tf
        }

        return sCachedFonts[assetPath]
    }


}