package com.example.sistema.mascotas;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.sistema.mascotas.adapter.MascotaAdaptador;
import com.example.sistema.mascotas.adapter.PageAdapter;
import com.example.sistema.mascotas.fragment.ListaFragment;
import com.example.sistema.mascotas.fragment.PerfilFragment;
import com.example.sistema.mascotas.pojo.Mascota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Communicator {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar miActionBar;

    ArrayList<Fragment> fragments;
    ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miActionBar= (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setIcon(R.drawable.ic_dog_footprint_48_1);

        tabLayout   = (TabLayout) findViewById(R.id.tabLayout);
        viewPager   = (ViewPager) findViewById(R.id.viewPager);
        agregarFragment();
        setUpViewPager();

    }

    private ArrayList<Fragment> agregarFragment() {
        fragments = new ArrayList<>();
        fragments.add(new ListaFragment());
        fragments.add(new PerfilFragment());
        return fragments;

    }

    public void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragment()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_lista);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_perfil);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.mFavoritos: // favorito
                Intent intent = new Intent(this, FavoritoMascotas.class);
                startActivity(intent);
                break;
            case R.id.mContacto: // favorito
                Intent iContacto = new Intent(this, ContactoActivity.class);
                startActivity(iContacto);
                break;
            case R.id.mAcercaDe: // favorito
                Intent iAcerdaDe = new Intent(this, BioActivity.class);
                startActivity(iAcerdaDe);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void repons(Mascota mascota) {
        FragmentManager manager = this.getFragmentManager();
        PerfilFragment fA = (PerfilFragment) fragments.get(1);
        fA.onChangeData(mascota);
        viewPager.setCurrentItem(1);

    }
}
