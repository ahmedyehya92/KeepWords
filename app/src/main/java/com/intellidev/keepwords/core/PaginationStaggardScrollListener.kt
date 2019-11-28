package com.intellidev.keepwords.core

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager

abstract class PaginationStaggardScrollListener(internal var layoutManager: StaggeredGridLayoutManager) :
    RecyclerView.OnScrollListener() {
    private var pastVisibleItems: Int = 0
    private var visibleItemCount: Int = 0
    private var totalItemCount: Int = 0

    abstract val totalPageCount: Int

    abstract val isLastPage: Boolean

    abstract val isLoading: Boolean

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        visibleItemCount = layoutManager.childCount
        totalItemCount = layoutManager.itemCount
        var firstVisibleItems: IntArray? = null
        firstVisibleItems = layoutManager.findFirstVisibleItemPositions(firstVisibleItems)
        if (firstVisibleItems != null && firstVisibleItems.size > 0) {
            pastVisibleItems = firstVisibleItems[0]
        }


        if (!isLoading && !isLastPage) {
            if (visibleItemCount + pastVisibleItems >= totalItemCount) {

                loadMoreItems()
            }
        }
    }



    protected abstract fun loadMoreItems()
}

