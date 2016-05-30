package mx.fanygtz.mascotaspersistencia.Presentador;

import android.content.Context;

import java.util.ArrayList;

import mx.fanygtz.mascotaspersistencia.db.ConstructorMascotas;
import mx.fanygtz.mascotaspersistencia.fragments.IMainFragment;
import mx.fanygtz.mascotaspersistencia.poyo.Mascotas;

/**
 * Created by FGutierrez on 2016/05/28.
 */
public class MainFragmentPresenter implements IMainFragmentPresenter {
    private IMainFragment imainfragment;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascotas> listMascotas;
    public MainFragmentPresenter(IMainFragment imainFragment, Context context) {
        this.context = context;
        this.imainfragment = imainFragment;
        obtenerMascotasBD();
    }

    @Override
    public void obtenerMascotasBD() {
        constructorMascotas = new ConstructorMascotas(context);
        listMascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();

    }

    @Override
    public void mostrarMascotasRV() {
       imainfragment.inicializarAdaptadorMF(imainfragment.crearAdaptador(listMascotas));
        imainfragment.generarLinearLayoutVertical();

    }
}
