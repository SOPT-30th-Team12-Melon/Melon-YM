package org.sopt.jointseminar.melon.presentation.main.home

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class TrendyItemDecoration : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val position = parent.getChildAdapterPosition(view)
        val count = state.itemCount
        val spanCount = 2

        if (position % spanCount == 0) {
            outRect.bottom = 7
        }
        if (position <= 1) {
            outRect.left = 20
        }

        if (position >= count - 2)
            outRect.right = 20
        else
            outRect.right = 10
    }
}