package com.linder.mbr_app;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        // Setear Toolbar como action bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Set DrawerLayout
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        // Set drawer toggle icon
        //        final ActionBar ab = getSupportActionBar();
//        if (ab != null) {
//            ab.setHomeAsUpIndicator(R.drawable.ic_menu);
//            ab.setDisplayHomeAsUpEnabled(true);
//        }
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, android.R.string.ok, android.R.string.cancel);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        // Set NavigationItemSelectedListener
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                // Do action by menu item id
                switch (menuItem.getItemId()){
                    case R.id.nav_profile:
                        Toast.makeText(HomeActivity.this, "Perfil...", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_nuevo_ticket:
                        Toast.makeText(HomeActivity.this, "Registrar ticket nuevo...", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_estado_tickets:
                        Toast.makeText(HomeActivity.this, "Consulta estado de tickets...", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_todos_tickets:
                        Toast.makeText(HomeActivity.this, "Consultar todos los tickets...", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_asignar_tickets:
                        Toast.makeText(HomeActivity.this, "Asignar ticket a tecnico...", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_reporte_tickets:
                        Toast.makeText(HomeActivity.this, "Reporte de tickets...", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_tickets_asignados:
                        Toast.makeText(HomeActivity.this, "Consultar tickets asignados...", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_atender_tickets:
                        Toast.makeText(HomeActivity.this, "Atender tickets asignados...", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_settings:
                        Toast.makeText(HomeActivity.this, "Go settings...", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_logout:
                        Intent intent = new Intent(HomeActivity.this,LoginActivity.class);
                        startActivity(intent);
                        finish();
                        Toast.makeText(HomeActivity.this, "chau...", Toast.LENGTH_SHORT).show();
                        break;
                }

                // Close drawer
                drawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }
        });

        String nameus = getIntent().getExtras().getString("nombre");
        String namus = getIntent().getExtras().getString("email");

        // Change navigation header information
        ImageView photoImage = (ImageView) navigationView.getHeaderView(0).findViewById(R.id.menu_photo);
        photoImage.setBackgroundResource(R.drawable.ic_profile);

        TextView fullnameText = (TextView) navigationView.getHeaderView(0).findViewById(R.id.menu_fullname);
        fullnameText.setText(nameus);

        TextView emailText = (TextView) navigationView.getHeaderView(0).findViewById(R.id.menu_email);
        emailText.setText(namus);


        int rol = getIntent().getExtras().getInt("rol");
        if(rol == 1 ){
            navigationView.getMenu().findItem(R.id.nav_asignar_tickets).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_reporte_tickets).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_tickets_asignados).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_atender_tickets).setVisible(false);
        }
        else if (rol == 2){
            navigationView.getMenu().findItem(R.id.nav_nuevo_ticket).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_estado_tickets).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_tickets_asignados).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_atender_tickets).setVisible(false);
        }
        else if (rol == 3){
            navigationView.getMenu().findItem(R.id.nav_nuevo_ticket).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_estado_tickets).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_todos_tickets).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_asignar_tickets).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_reporte_tickets).setVisible(false);
        }


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: // Option open drawer
                if(!drawerLayout.isDrawerOpen(GravityCompat.START))
                    drawerLayout.openDrawer(GravityCompat.START);   // Open drawer
                else
                    drawerLayout.closeDrawer(GravityCompat.START);    // Close drawer
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
