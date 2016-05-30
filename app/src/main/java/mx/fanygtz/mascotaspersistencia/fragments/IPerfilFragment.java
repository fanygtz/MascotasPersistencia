package mx.fanygtz.mascotaspersistencia.fragments;

import java.util.ArrayList;

import mx.fanygtz.mascotaspersistencia.adapter.PerfilAdapter;
import mx.fanygtz.mascotaspersistencia.poyo.Mascotas;

/**
 * Created by FGutierrez on 2016/05/28.
 */
public interface IPerfilFragment {
    public void generarLinearLayoutGrid();
    public PerfilAdapter crearAdaptador ( ArrayList<Mascotas> mascotaList);
    public void inicializarAdaptadorPF (PerfilAdapter rAdapter);
}
