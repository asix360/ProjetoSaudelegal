package com.example.info.ndexemple

import android.Manifest
import android.app.ActivityManager
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.ActivityCompat
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.example.info.ndexemple.Adapters.MyAdapter
import com.example.info.ndexemple.Model.UnidadeModel
import kotlinx.android.synthetic.main.content_nddraw.*

class NddrawActivity:AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

protected override fun onCreate(savedInstanceState:Bundle?) {
super.onCreate(savedInstanceState)
setContentView(R.layout.activity_nddraw)
val toolbar = findViewById(R.id.toolbar) as Toolbar
setSupportActionBar(toolbar)


val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
val toggle = ActionBarDrawerToggle(
this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
drawer.setDrawerListener(toggle)
toggle.syncState()

val navigationView = findViewById(R.id.nav_view) as NavigationView
navigationView.setNavigationItemSelectedListener(this)


    rvUnidade.setHasFixedSize(true)
    rvUnidade.layoutManager = LinearLayoutManager(this)

    val unidades:ArrayList<UnidadeModel> = ArrayList<UnidadeModel>()


        unidades.add(UnidadeModel("USF BANCÁRIOS ",40,"Local"))
        unidades.add(UnidadeModel("USF TIMBO I ",21,"Local"))
        unidades.add(UnidadeModel("USF TIMBO II ",43,"Local"))
        unidades.add(UnidadeModel("USF MANGABEIRA INTREGRADA",58,"Local"))
        unidades.add(UnidadeModel("USF VALENTINA INTEGRADA ",46,"Local"))
        unidades.add(UnidadeModel("USF SAÚDE E VIDA ",56,"Local"))



    val madapter:RecyclerView.Adapter<*> = MyAdapter(this@NddrawActivity,unidades){
        Toast.makeText(this@NddrawActivity, it.toString(), Toast.LENGTH_SHORT).show()


    }
        rvUnidade.adapter = madapter








}

public override fun onBackPressed() {
val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
if (drawer.isDrawerOpen(GravityCompat.START))
{
drawer.closeDrawer(GravityCompat.START)
}
else
{
super.onBackPressed()
}
}

public override fun onCreateOptionsMenu(menu:Menu):Boolean {
 // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nddraw, menu)
return true
}

public override fun onOptionsItemSelected(item:MenuItem):Boolean {
 // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.getItemId()



        if (id == R.id.action_settings)

{

return true
}

return super.onOptionsItemSelected(item)
}

public override fun onNavigationItemSelected(item:MenuItem):Boolean {
 // Handle navigation view item clicks here.
        val id = item.getItemId()

if (id == R.id.nav_camera)
    openfer(rvUnidade)
{

        }
else if (id == R.id.nav_gallery)
    openfer(rvUnidade)
{

}
else if (id == R.id.nav_slideshow)
    openEmergencia(rvUnidade)
{

}
else if (id == R.id.nav_manage)
        openfer(rvUnidade)
{

}


val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
drawer.closeDrawer(GravityCompat.START)
return true
}




    fun openfer(v: View, function: () -> Unit){
        startActivity(Intent(this@NddrawActivity,FerramentasNavActivity::class.java))
    }



    fun openEmergencia(v: View, function: () -> Unit){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if (checkSelfPermission(Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(this@NddrawActivity, arrayOf(Manifest.permission.CALL_PHONE),0)

            }else{startActivity(Intent(Intent.ACTION_CALL, Uri.parse("tel:192")))}
        }else{startActivity(Intent(Intent.ACTION_CALL, Uri.parse("tel:192")))   }


    }

 }
