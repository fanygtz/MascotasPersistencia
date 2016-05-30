package mx.fanygtz.mascotaspersistencia.Presentador;

import android.content.Context;

import java.util.ArrayList;

import mx.fanygtz.mascotaspersistencia.R;
import mx.fanygtz.mascotaspersistencia.db.ConstructorMascotas;
import mx.fanygtz.mascotaspersistencia.db.ConstructorPerfil;
import mx.fanygtz.mascotaspersistencia.fragments.IPerfilFragment;
import mx.fanygtz.mascotaspersistencia.poyo.Mascotas;

/**
 * Created by FGutierrez on 2016/05/28.
 */
public class PerfilFragmentePresenter implements  IPerfilFragmentPresenter {
    private IPerfilFragment iPerfilFragment;
    private Context context;
    private ConstructorPerfil constructorPerfil;
    private ArrayList<Mascotas> listMascotas;
    private Mascotas mascotaActual;
    public PerfilFragmentePresenter(IPerfilFragment iPerfilFragment, Context context) {
        this.iPerfilFragment = iPerfilFragment;
        this.context = context;
        mascotaActual = new Mascotas();  //dato dommy
        mascotaActual.setName("Barry");
        mascotaActual.setId(5);
        mascotaActual.setIdFoto(R.drawable.tigre2);
        obtenerMascotasBD();
    }

    @Override
    public void obtenerMascotasBD() {
        constructorPerfil = new ConstructorPerfil(context);
        listMascotas = constructorPerfil.obtenerDatos(mascotaActual);
        mostrarMascotasRV();

    }

    @Override
    public void mostrarMascotasRV() {
        iPerfilFragment.inicializarAdaptadorPF(iPerfilFragment.crearAdaptador(listMascotas));
        iPerfilFragment.generarLinearLayoutGrid();
    }
}
