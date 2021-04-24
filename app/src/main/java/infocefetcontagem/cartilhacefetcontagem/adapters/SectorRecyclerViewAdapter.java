package infocefetcontagem.cartilhacefetcontagem.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import infocefetcontagem.cartilhacefetcontagem.R;
import infocefetcontagem.cartilhacefetcontagem.dummy.DummyContent.DummyItem;
import infocefetcontagem.cartilhacefetcontagem.models.Sector;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class SectorRecyclerViewAdapter extends RecyclerView.Adapter<SectorRecyclerViewAdapter.ViewHolder>
        implements View.OnClickListener{

    private final List<Sector> mValues;
    OnSectorItemListener mOnItemListener;

    public SectorRecyclerViewAdapter(List<Sector> items, OnSectorItemListener mOnItemListener) {
        mValues = items;
        this.mOnItemListener = mOnItemListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_sector, parent, false);
        return new ViewHolder(view, mOnItemListener);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);

        String title = holder.mItem.getTitle();

        if(holder.mItem.getCod() != null){
            title += " (" + holder.mItem.getCod() + ")";
        }

        holder.title.setText(title);
        holder.email.setText(holder.mItem.getEmail());

        if(holder.mItem.getDescription() != null) {
            holder.description.setText(holder.mItem.getDescription());
        }else{
            holder.description.setVisibility(View.GONE);
        }

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
        public final TextView title;
        public final TextView description;
        public final TextView email;
        public Sector mItem;

        OnSectorItemListener onItemListener;

        public ViewHolder(View view, OnSectorItemListener onItemListener) {
            super(view);
            mView = view;
            title = (TextView) view.findViewById(R.id.textView_sector_title);
            description = (TextView) view.findViewById(R.id.textView_sector_description);
            email = (TextView) view.findViewById(R.id.textView_sector_email);

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

    public interface OnSectorItemListener{
        void onItemClick(int position);

    }
}