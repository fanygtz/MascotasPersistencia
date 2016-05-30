package mx.fanygtz.mascotaspersistencia.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import mx.fanygtz.mascotaspersistencia.R;
import mx.fanygtz.mascotaspersistencia.poyo.Mascotas;

/**
 * Created by FGutierrez on 2016/05/20.
 */
public class PerfilAdapter extends RecyclerView.Adapter<PerfilAdapter.MascotaViewHolder>  {
    private ArrayList<Mascotas> Mascota;
    private Activity activity;
    public PerfilAdapter(ArrayList<Mascotas> Mascota, Activity activity){
        this.Mascota = Mascota;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);

        return new MascotaViewHolder(v);
    }


    @Override
    public void onBindViewHolder(final MascotaViewHolder holder, final int position) {
        final Mascotas registro = Mascota.get(position);
        holder.nombre.setText(registro.getName());
        holder.rating.setText(String.valueOf(registro.getContador()));
        holder.idFoto.setImageResource(registro.getIdFoto());
        holder.btnContador.setVisibility(View.INVISIBLE);
        holder.nombre.setVisibility(View.INVISIBLE);
        holder.gridLayout.removeAllViews();
        holder.gridLayout.setColumnCount(3);
        holder.gridLayout.setRowCount(2);
        GridLayout.LayoutParams param = new GridLayout.LayoutParams();
        param.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        param.width = ViewGroup.LayoutParams.WRAP_CONTENT;
        param.columnSpec = GridLayout.spec(0);
        param.rowSpec = GridLayout.spec(0);
        holder.rating.setLayoutParams(param);
        holder.gridLayout.addView(holder.rating);
        param.columnSpec = GridLayout.spec(2);
        param.rowSpec = GridLayout.spec(0);
        holder.idIco.setLayoutParams(param);
        holder.gridLayout.addView(holder.idIco);
    }

    @Override
    public int getItemCount() {
        return Mascota.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        TextView nombre;
        TextView rating;
        ImageView idFoto;
        ImageView idIco;
        ImageButton btnContador;
        GridLayout gridLayout;
        MascotaViewHolder(View itemView){
            super(itemView);
            nombre = (TextView)itemView.findViewById(R.id.tvNombre);
            idFoto = (ImageView)itemView.findViewById(R.id.ivFoto);
            rating = (TextView)itemView.findViewById(R.id.tvRating);
            btnContador=(ImageButton)itemView.findViewById(R.id.btnContador);
            idIco = (ImageView)itemView.findViewById(R.id.ivHuesito);
            gridLayout=(GridLayout)itemView.findViewById(R.id.gridCard);

        }
    }
}
