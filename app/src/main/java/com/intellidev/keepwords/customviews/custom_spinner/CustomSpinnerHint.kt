package com.intellidev.keepwords.customviews.custom_spinner

import android.content.Context
import android.support.v7.widget.AppCompatSpinner
import android.util.AttributeSet
import android.view.View
import android.widget.AdapterView

class CustomSpinnerHint @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = android.R.attr.spinnerStyle
) :
    AppCompatSpinner(context, attrs, defStyle) {
    private var hasHint = false

    init {
        isClickable = true
    }

    fun setAdapter(adapter: CustomeHintSpinnerAdapter<Any>) {
        super.setAdapter(adapter)
        hasHint = adapter.hasHint()
    }

    override fun setOnItemSelectedListener(listener: OnItemSelectedListener?) {
        super.setOnItemSelectedListener(object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (listener != null) {
                    if (!hasHint) {
                        listener.onItemSelected(parent, view, position, id)
                    } else if (position > 0) {
                        listener.onItemSelected(parent, view, position - 1, id)
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                listener?.onNothingSelected(parent)
            }
        })
    }
}
