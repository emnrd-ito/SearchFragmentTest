package testdemo.com.searchfragmenttest.decoration;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import testdemo.com.searchfragmenttest.R;

/**
 * ItemDecoration implementation that applies and inset margin
 * around each child of the RecyclerView. It also draws item dividers
 * that are expected from a vertical list implementation, such as
 * ListView.
 */
public class DividerDecoration extends RecyclerView.ItemDecoration {

    private static final int[] ATTRS = { android.R.attr.listDivider };

    private Drawable mDivider;
    private int mInsets;

    public DividerDecoration(Context context) {
        TypedArray a = context.obtainStyledAttributes(ATTRS);
        mDivider = a.getDrawable(0);
        a.recycle();

        mInsets = context.getResources().getDimensionPixelSize(R.dimen.card_insets);
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        drawVertical(c, parent);
    }

    /** Draw dividers underneath each child view */
    public void drawVertical(Canvas c, RecyclerView parent) {
        final int left = parent.getPaddingLeft();
        final int right = parent.getWidth() - parent.getPaddingRight();

        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                    .getLayoutParams();
            final int top = child.getBottom() + params.bottomMargin + mInsets;
            final int bottom = top + mDivider.getIntrinsicHeight();
            //ColorFilter filter = new LightingColorFilter( Color.WHITE, Color.GRAY);
            //mDivider.setColorFilter( filter );
            mDivider.setColorFilter(new PorterDuffColorFilter(Color.GRAY, PorterDuff.Mode.SRC_ATOP));
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        //We can supply forced insets for each item view here in the Rect
        outRect.set(mInsets, mInsets, mInsets, mInsets);
    }
}
