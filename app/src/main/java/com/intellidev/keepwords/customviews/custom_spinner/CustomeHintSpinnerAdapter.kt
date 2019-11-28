package com.intellidev.keepwords.customviews.custom_spinner

import android.content.Context
import android.support.annotation.CallSuper
import android.support.annotation.StringRes
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.intellidev.keepwords.R
import java.util.*

open class CustomeHintSpinnerAdapter<T> : ArrayAdapter<T> {
    private val objects: MutableList<T>
    private var hint: String? = null
    private var acontext: Context? = null

    private constructor() : super(null!!, 0) {}

    constructor(context: Context, objects: Array<T>) : this(context, Arrays.asList<T>(*objects)) {}

    constructor(context: Context, objects: Array<T>, @StringRes hint: Int) : this(
        context,
        Arrays.asList<T>(*objects),
        hint
    ) {
    }

    constructor(context: Context, objects: Array<T>, hint: String) : this(context, Arrays.asList<T>(*objects), hint) {}

    constructor(context: Context, objects: MutableList<T>, @StringRes hint: Int) : this(
        context,
        objects,
        context.resources.getString(hint)
    ) {
    }

    @JvmOverloads
    constructor(context: Context, objects: MutableList<T>, hint: String? = null) : super(
        context,
        android.R.layout.simple_list_item_1,
        objects
    ) {
        this.acontext = context
        this.objects = objects
        this.hint = hint
    }



    fun hasHint(): Boolean {
        return hint != null
    }

    @CallSuper
    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val textView: TextView?
        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                .inflate(android.R.layout.simple_list_item_1, parent, false)
        }
        textView = convertView as TextView?

        if (hint != null && position == 0) {
            textView!!.text = hint
            textView.setTextColor(ContextCompat.getColor(context, R.color.gray))
        } else {
            textView!!.text = getLabelFor(objects[position - 1])
            textView.setTextColor(ContextCompat.getColor(context, android.R.color.primary_text_light))
        }
        return convertView!!
    }

    @CallSuper
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val textView: TextView?
        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                .inflate(android.R.layout.simple_list_item_1, parent, false)
            textView = convertView as TextView?
            textView!!.setCompoundDrawables(
                null, null,
                ContextCompat.getDrawable(context, android.R.drawable.spinner_background), null
            )
        } else {
            textView = convertView as TextView?
        }

        if (hint != null && position == 0) {
            textView!!.text = hint
            textView.setTextColor(ContextCompat.getColor(context, R.color.white))
        } else {
            textView!!.text = getLabelFor(objects[position - 1])
            textView.setTextColor(ContextCompat.getColor(context, R.color.white))
        }

        return convertView!!
    }

    override fun isEnabled(position: Int): Boolean {
        return if (hint != null) position != 0 && super.isEnabled(position) else super.isEnabled(position)

    }

    open fun getLabelFor(`object`: T): String {
        return `object`.toString()
    }

    override fun getCount(): Int {
        return if (hint != null) {
            super.getCount() + 1
        } else {
            super.getCount()
        }
    }

    fun setHint(hint: String) {
        this.hint = hint
    }


    override fun add(r: T?) {
        objects.add(r!!)
        //notifyItemInserted(arrayList.size()-1 );
        notifyDataSetChanged()
    }

    fun addAll(opResults: List<T>) {
        for (result in opResults) {
            add(result)
        }
    }

    companion object {
        //private val TAG = CustomeHintSpinnerAdapter<*>::class.java.simpleName
    }

}