package mx.fanygtz.mascotaspersistencia.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mx.fanygtz.mascotaspersistencia.MainActivity;
import mx.fanygtz.mascotaspersistencia.Presentador.IPerfilFragmentPresenter;
import mx.fanygtz.mascotaspersistencia.Presentador.PerfilFragmentePresenter;
import mx.fanygtz.mascotaspersistencia.R;
import mx.fanygtz.mascotaspersistencia.adapter.PerfilAdapter;
import mx.fanygtz.mascotaspersistencia.poyo.LikeMascota;
import mx.fanygtz.mascotaspersistencia.poyo.Mascotas;
import mx.fanygtz.mascotaspersistencia.poyo.MiAplicacion;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment implements IPerfilFragment{
    ArrayList<Mascotas> mascotaList;// Información.
    RecyclerView rv;
    RecyclerView.LayoutManager lmanager;
    private IPerfilFragmentPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        rv = (RecyclerView) v.findViewById(R.id.rvPerfil);
        presenter = new PerfilFragmentePresenter(this,getContext());
        //presenter = new PerfilFragmentePresenter(this,getContext(), MiAplicacion.mascotaActual.getMascota());
        return v;
    }



    @Override
    public void generarLinearLayoutGrid() {
        lmanager = new GridLayoutManager(getActivity(),3);
        rv.setLayoutManager(lmanager);
    }

    @Override
    public PerfilAdapter crearAdaptador(ArrayList<Mascotas> mascotaList) {
        PerfilAdapter rAdapter = new PerfilAdapter(mascotaList,getActivity());
        return rAdapter;
    }

    @Override
    public void inicializarAdaptadorPF(PerfilAdapter rAdapter) {
        rv.setAdapter(rAdapter);
    }
}
