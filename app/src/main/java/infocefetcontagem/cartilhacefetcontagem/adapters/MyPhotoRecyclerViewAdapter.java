package infocefetcontagem.cartilhacefetcontagem.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import infocefetcontagem.cartilhacefetcontagem.R;
import infocefetcontagem.cartilhacefetcontagem.dummy.DummyContent.DummyItem;
import infocefetcontagem.cartilhacefetcontagem.models.Photo;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyPhotoRecyclerViewAdapter extends RecyclerView.Adapter<MyPhotoRecyclerViewAdapter.ViewHolder>
implements View.OnClickListener{

    private final List<Photo> mValues;
    OnItemListener mOnItemListener;

    public MyPhotoRecyclerViewAdapter(List<Photo> items, OnItemListener mOnItemListener) {
        mValues = items;
        this.mOnItemListener = mOnItemListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_gallery_item, parent, false);
        return new ViewHolder(view, mOnItemListener);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mContentView.setImageResource(mValues.get(position).getPhotoId());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    @Override
    public void onClick(View view) {
        Log.d("onClick", "ONCLICK");
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final View mView;
       // public final TextView mDescriptionView;
        public final ImageView mContentView;
        public Photo mItem;

        OnItemListener onItemListener;

        public ViewHolder(View view, OnItemListener onItemListener) {
            super(view);
            mView = view;
          //  mDescriptionView = (TextView) view.findViewById(R.id.);
            mContentView = (ImageView) view.findViewById(R.id.place_photo);
            this.onItemListener = onItemListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            onItemListener.onItemClick(getAdapterPosition());

        }

        /*@Override
       /* public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }*/
    }

    public interface OnItemListener{
        void onItemClick(int position);

    }
}