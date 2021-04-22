package infocefetcontagem.cartilhacefetcontagem.adapters;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.CardView;
import android.widget.TextView;


import java.util.List;

import infocefetcontagem.cartilhacefetcontagem.R;
import infocefetcontagem.cartilhacefetcontagem.models.PlaceHeader;

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.PersonViewHolder> {

    List<PlaceHeader> headers;
    OnCardListener mOnCardListener;

    public CardViewAdapter(List<PlaceHeader> items, OnCardListener mOnCardListener){
        this.headers = items;
        this.mOnCardListener = mOnCardListener;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_place,parent,false);
        PersonViewHolder personViewHolder = new PersonViewHolder(view, mOnCardListener);
        return personViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {

        holder.placeDescription.setText(headers.get(position).getDescription());
        holder.placePhoto.setImageResource(headers.get(position).getPhotoId());

    }

    @Override
    public int getItemCount() {
        return headers.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        CardView cardView;
        TextView placeDescription;
        ImageView placePhoto;

        OnCardListener onCardListener;

        PersonViewHolder(View itemView, OnCardListener onCardListener){
            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.card_view);
            placeDescription = (TextView) itemView.findViewById(R.id.place_description);
            placePhoto = (ImageView) itemView.findViewById(R.id.place_photo);

            this.onCardListener = onCardListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onCardListener.onCardClick(getAdapterPosition());
        }
    }

    public interface OnCardListener{
        void onCardClick(int position);

    }

}
