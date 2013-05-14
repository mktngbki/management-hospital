package com.hospital.managementhospital.views;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow.OnDismissListener;

import com.hospital.managementhospital.R;

public class PopupPatient extends MyPopupWindow implements OnDismissListener{
	 private View mRootView;
	    private LayoutInflater mInflater;
	    private Button mBtnLeft, mBtnRight;

	    private OnDismissListener mDismissListener;
	    private OnButtonLeftClick mBtnLeftClickListener;
	    private OnButtonRightClick mBtnRightClickListener;

	    private List<QuickActionItem> actionItems = new ArrayList<QuickActionItem>();

	    private boolean mDidAction;
	    private boolean reverseOrientationItem = false;

	    private int mChildPos;
	        private int mInsertPos;
	    private int mAnimStyle;
	    private int mOrientation;
	    private int rootWidth=0;


	        public static final int HORIZONTAL = 0;
	        public static final int VERTICAL = 1;

	        public static final int ANIM_GROW_FROM_LEFT = 1;

	    /**
	     * Constructor for default vertical layout
	     * 
	     * @param context  Context
	     */
	    public PopupPatient(Context context) {
	        this(context, VERTICAL);
	    }






	    /**
	     * Constructor allowing orientation override
	     * 
	     * @param context    Context
	     * @param orientation Layout orientation, can be vartical or horizontal
	     */
	    public PopupPatient(Context context, int orientation) {
	        super(context);

	        mOrientation = orientation;

	        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    
	        setRootViewId(R.layout.layout_popup_patient);
	        
	        mAnimStyle  = ANIM_GROW_FROM_LEFT;
	        mChildPos   = 0;
	    }

	    /**
	     * Set the background of the popup and the two arrows. Must be 9-patch.
	     * @param popup
	     * @param arrowUp
	     * @param arrowDown
	     */
	    public void setBackgroundResources(int popup, int arrowUp, int arrowDown){

	        if(popup!=0 && arrowUp!=0 && arrowDown!=0){
	        }
	    }


	    /**
	     * Get action item at an index
	     * 
	     * @param index  Index of item (position from callback)
	     * 
	     * @return  Action Item at the position
	     */
	    public QuickActionItem getActionItem(int index) {
	        return actionItems.get(index);
	    }

	    /**
	     * Set root view.
	     * 
	     * @param id Layout resource id
	     */
	    private void setRootViewId(int id) {
	        mRootView   = (ViewGroup) mInflater.inflate(id, null);
	        mRootView.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
	        mBtnLeft = (Button) mRootView.findViewById(R.id.btn_left_popup);
	        mBtnLeft.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					mBtnLeftClickListener.onLeftClick(mBtnLeft);
				}
			});
	        mBtnRight = (Button) mRootView.findViewById(R.id.btn_right_popup);
	        mBtnRight.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					mBtnRightClickListener.onRightClick(mBtnRight);
				}
			});
	        setContentView(mRootView);
	    }

	    /**
	     * Set animation style
	     * 
	     * @param mAnimStyle animation style, default is set to ANIM_AUTO
	     */
	    public void setAnimStyle(int mAnimStyle) {
	        this.mAnimStyle = mAnimStyle;
	    }

	    /**
	     * Set listener for action item clicked.
	     * 
	     * @param listener Listener
	     */

	    /**
	     * Add action item
	     * 
	     * @param action  {@link QuickActionItem}
	     */

	    /**
	     * Show quickaction popup. Popup is automatically positioned, on top or bottom of anchor                                
	     * 
	     */
	    public void show (View anchor) {
	        preShow();

	        int xPos, yPos;

	        mDidAction          = false;

	        int[] location      = new int[2];

	        anchor.getLocationOnScreen(location);

	        Rect anchorRect = new Rect(location[0], location[1], location[0] + anchor.getWidth(), location[1] + anchor.getHeight());

	        mRootView.measure(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

	        int rootHeight = mRootView.getMeasuredHeight();

	        if (rootWidth == 0) {

	            rootWidth   = mRootView.getMeasuredWidth();
	        }

	        int screenWidth     = mWindowManager.getDefaultDisplay().getWidth();
	        int screenHeight    = mWindowManager.getDefaultDisplay().getHeight();

	        if ((anchorRect.left + rootWidth) > screenWidth) {


	            xPos        = anchorRect.left - (rootWidth-anchor.getWidth());          
	            xPos        = (xPos < 0) ? 0 : xPos;


	        } else {
	            if (anchor.getWidth() > rootWidth) {
	                xPos = anchorRect.centerX() - (rootWidth/2);


	            } else {
	                xPos = anchorRect.left;
	            }

	        }

	        int dyTop           = anchorRect.top;
	        int dyBottom        = screenHeight - anchorRect.bottom;

	        boolean onTop       = (dyTop > dyBottom) ? true : false;

	        if (onTop) {
	            if (rootHeight > dyTop) {
	                yPos            = 15;
	            } else {
	                yPos = anchorRect.top - rootHeight;
	            }
	        } else {
	            yPos = anchorRect.bottom;

	        }


	        setAnimationStyle(screenWidth, anchorRect.centerX(), onTop);
	       
	            mWindow.showAtLocation(anchor, Gravity.NO_GRAVITY, (anchorRect.left + (anchor.getWidth()/2)) - (mRootView.getMeasuredWidth()/2), yPos);
	        Log.e("QuickActionPopup", "anchorLeft = "+ anchorRect.left + " anchorWidth = " + anchor.getWidth()/2 + " rootView width"+ mRootView.getMeasuredWidth());
	    }

	    /**
	     * Set animation style
	     * 
	     * @param screenWidth screen width
	     * @param requestedX distance from left edge
	* @param onTop flag to indicate where the popup should be displayed. Set TRUE if  *displayed on top of anchor view and vice versa
	     */

	    private void setAnimationStyle(int screenWidth, int requestedX, boolean onTop) {
	        switch (mAnimStyle) {
	        case ANIM_GROW_FROM_LEFT:
	            mWindow.setAnimationStyle((onTop) ? R.style.Animations_PopUpMenu_Left : R.style.Animations_PopDownMenu_Left);
	            break;

	        }
	    }

	    /**
	     * Listener for dismissing the window.
	     */

	    public void setOnDismissListener(OnDismissListener listener) {
	        setOnDismissListener(this);

	        mDismissListener = listener;
	    }

	    @Override
	    public void onDismiss() {
	        if (!mDidAction && mDismissListener != null) {
	            mDismissListener.onDismiss();
	        }
	    }

	    /**
	     * If we want to reverse the item orientation.
	     */

	    public boolean isReverseOrientationItem() {
	        return reverseOrientationItem;
	    }

	    public void setReverseOrientationItem(boolean reverseOrientationItem) {
	        this.reverseOrientationItem = reverseOrientationItem;
	    }

	    /**
	     * Listener for window dismiss
	     * 
	     */
	    public interface OnDismissListener {
	        public abstract void onDismiss();
	    }
	    
	    public interface OnButtonLeftClick {
	    	public abstract void onLeftClick(View v);
	    }
	    
	    public interface OnButtonRightClick {
	    	public abstract void onRightClick(View v);
	    }
	    
	    public void setOnButtonLeftClick(OnButtonLeftClick listener){
	    	mBtnLeftClickListener = listener;
	    }
	    
	    public void setOnButtonRightClick(OnButtonRightClick listener){
	    	mBtnRightClickListener = listener;
	    }
	}