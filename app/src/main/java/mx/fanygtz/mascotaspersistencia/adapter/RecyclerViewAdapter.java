package mx.fanygtz.mascotaspersistencia.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import mx.fanygtz.mascotaspersistencia.MainActivity;
import mx.fanygtz.mascotaspersistencia.db.ConstructorMascotas;
import mx.fanygtz.mascotaspersistencia.poyo.LikeMascota;
import mx.fanygtz.mascotaspersistencia.poyo.Mascotas;
import mx.fanygtz.mascotaspersistencia.R;
import mx.fanygtz.mascotaspersistencia.poyo.MiAplicacion;

/**
 * Created by FGutierrez on 2016/05/09.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MascotaViewHolder> {
    private ArrayList<Mascotas> Mascota;
    private Activity activity;
    public RecyclerViewAdapter(ArrayList<Mascotas> Mascota, Activity activity){
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
        holder.btnContador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*MascotaViewHolder h = holder;
                registro.setContador(registro.getContador() + 1);
                h.rating.setText(String.valueOf(Mascota.get(position).getContador()));*/
                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darLikeMascota(registro);
                Toast.makeText(activity, "Diste Like a : " + registro.getName(), Toast.LENGTH_SHORT).show();
                holder.rating.setText(String.valueOf(constructorMascotas.obtenerLikesMascota(registro)));
                //MiAplicacion.mascotaActual.setMascota(registro); //pasa el valor del ultimo like

            }
        });

    }

    @Override
    public int getItemCount() {
        return Mascota.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        TextView nombre;
        TextView rating;
        ImageView idFoto;
        ImageButton btnContador;
        MascotaViewHolder(View itemView){
            super(itemView);
            nombre = (TextView)itemView.findViewById(R.id.tvNombre);
            idFoto = (ImageView)itemView.findViewById(R.id.ivFoto);
            rating = (TextView)itemView.findViewById(R.id.tvRating);
            btnContador=(ImageButton)itemView.findViewById(R.id.btnContador);


        }
    }


}
