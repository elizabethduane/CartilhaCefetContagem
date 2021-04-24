package infocefetcontagem.cartilhacefetcontagem.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import infocefetcontagem.cartilhacefetcontagem.R;
import infocefetcontagem.cartilhacefetcontagem.models.Transporte;

public class TransportArrayAdapter extends ArrayAdapter<Transporte> {

    public TransportArrayAdapter(Context context, ArrayList<Transporte> transportList){
        super(context,0,transportList);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Verifica se já existe uma view criada e que pode ser reutilizada
        View view = convertView;

        // Cria a nova view, associando ao layout do item criado - parent é o layout pai em que o item está inserido
        if(view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.item_transport, parent, false);
        }

        Transporte transporte = getItem(position);

        TextView linha = (TextView)view.findViewById(R.id.text_view_linha);
        TextView descricao = (TextView)view.findViewById(R.id.text_view_descricao);
        TextView tarifa = (TextView)view.findViewById(R.id.text_view_tarifa);

        linha.setText(transporte.getLinha());
        descricao.setText(transporte.getDescricao());
        tarifa.setText(transporte.getTarifa());

        return view;
    }

}
