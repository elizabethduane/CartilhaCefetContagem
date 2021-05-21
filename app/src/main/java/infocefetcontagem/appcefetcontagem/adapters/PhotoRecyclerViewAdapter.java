package infocefetcontagem.appcefetcontagem.adapters;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import infocefetcontagem.appcefetcontagem.R;
import infocefetcontagem.appcefetcontagem.models.Photo;

import java.util.List;

/**
 * TODO: Replace the implementation with code for your data type.
 */
public class PhotoRecyclerViewAdapter extends RecyclerView.Adapter<PhotoRecyclerViewAdapter.ViewHolder>
implements View.OnClickListener{

    private final List<Photo> mValues;
    OnItemListener mOnItemListener;

    public PhotoRecyclerViewAdapter(List<Photo> items, OnItemListener mOnItemListener) {
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

    }

    public interface OnItemListener{
        void onItemClick(int position);

    }
}