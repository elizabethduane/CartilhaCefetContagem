package infocefetcontagem.cartilhacefetcontagem.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import infocefetcontagem.cartilhacefetcontagem.R;
import infocefetcontagem.cartilhacefetcontagem.CDEActivity;
import infocefetcontagem.cartilhacefetcontagem.models.Sector;

import java.util.List;

import static android.content.ContentValues.TAG;
import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class SectorRecyclerViewAdapter extends RecyclerView.Adapter<SectorRecyclerViewAdapter.ViewHolder>
        implements View.OnClickListener{

    private final List<Sector> mValues;
    OnSectorItemListener mOnItemListener;
    Context mContext;

    public SectorRecyclerViewAdapter(List<Sector> items, OnSectorItemListener mOnItemListener) {
        mValues = items;
        this.mOnItemListener = mOnItemListener;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_sector, parent, false);

        this.mContext = parent.getContext();

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

        String [] contacts = holder.mItem.getNameContacts();

        Log.d(TAG, "onBindViewHolder: " + contacts);

        holder.contact1.setText(contacts[0]);

        holder.contact2.setVisibility(GONE);
        holder.contact3.setVisibility(GONE);

        if(contacts.length > 1){
            holder.contact2.setText(contacts[1]);
            holder.contact2.setVisibility(VISIBLE);
        }

        if(contacts.length > 2){
            holder.contact3.setText(contacts[2]);
            holder.contact3.setVisibility(VISIBLE);
        }

        if(holder.mItem.getDescription() != null){
            holder.moreDetails.setVisibility(VISIBLE);
        }else{
            holder.moreDetails.setVisibility(GONE);
        }

        holder.email.setText(holder.mItem.getEmail());

        if(holder.mItem.getSocial() != null){
            holder.social.setText(holder.mItem.getSocial());
            holder.social.setVisibility(VISIBLE);
            holder.socialIcon.setVisibility(VISIBLE);
        }else {
            holder.social.setVisibility(GONE);
            holder.socialIcon.setVisibility(GONE);
        }

        if(holder.mItem.getPhone() != null){
            holder.phone.setText(holder.mItem.getPhone()[0]);
            holder.phoneGroup.setVisibility(VISIBLE);
        }else{
            holder.phoneGroup.setVisibility(GONE);
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
        public Sector mItem;

        public final TextView title;
        public final TextView contact1, contact2, contact3;
        public final TextView email;
        public final TextView social;
        public final ImageView socialIcon;
        public final TextView moreDetails;
        public final TextView phone;
        public final LinearLayout phoneGroup;
        public final LinearLayout socialGroup;

        OnSectorItemListener onItemListener;

        public ViewHolder(View view, OnSectorItemListener onItemListener) {
            super(view);
            mView = view;
            title = (TextView) view.findViewById(R.id.textView_sector_title);
            contact1 = (TextView) view.findViewById(R.id.textView_sector_contact1);
            contact2 = (TextView) view.findViewById(R.id.textView_sector_contact2);
            contact3 = (TextView) view.findViewById(R.id.textView_sector_contact3);
            email = (TextView) view.findViewById(R.id.textView_sector_email);
            moreDetails = (TextView) view.findViewById(R.id.more_details);
            social = (TextView) view.findViewById(R.id.textView_sector_social);
            socialIcon = (ImageView) view.findViewById(R.id.icon_social);
            phone = (TextView) view.findViewById(R.id.textView_sector_phone);
            phoneGroup = (LinearLayout) view.findViewById(R.id.group_phone);
            socialGroup = (LinearLayout) view.findViewById(R.id.layout_social_group);

            email.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickEmail(v);
                }

            });

            moreDetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickDetails(v);
                }

            });

           socialIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClickSocial(view);
                }
            });

            social.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClickSocial(view);
                }
            });
            //this.onItemListener = onItemListener;
            //itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            onItemListener.onItemClick(getAdapterPosition());

        }

        public void onClickEmail(View view){
            Log.d(TAG, "onClickEmail: "+ this.email.getText());
        }

        public void onClickDetails(View view){

            Intent intent = new Intent(mContext, CDEActivity.class);

            mContext.startActivity(intent);

        }

        public void onClickSocial(View view){
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(mItem.getUrlSocial()));
            mContext.startActivity(intent);
        }
    }

    public interface OnSectorItemListener{
        void onItemClick(int position);

    }
}