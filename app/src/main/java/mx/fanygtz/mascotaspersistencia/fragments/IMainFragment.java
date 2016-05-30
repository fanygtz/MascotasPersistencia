package mx.fanygtz.mascotaspersistencia.fragments;

import java.util.ArrayList;

import mx.fanygtz.mascotaspersistencia.adapter.RecyclerViewAdapter;
import mx.fanygtz.mascotaspersistencia.poyo.Mascotas;

/**
 * Created by FGutierrez on 2016/05/26.
 */
public interface IMainFragment {
    public void generarLinearLayoutVertical();
    public RecyclerViewAdapter crearAdaptador ( ArrayList<Mascotas> mascotaList);
    public void inicializarAdaptadorMF (RecyclerViewAdapter rAdapter);
}
