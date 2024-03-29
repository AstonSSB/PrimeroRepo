package cl.inacap.tarea.u1.contenedor;


import cl.inacap.tarea.u1.R;
import cl.inacap.tarea.u1.entregapedido.VistaActivity;
import cl.inacap.tarea.u1.mantenedorcliente.ClienteActivity;
import cl.inacap.tarea.u1.registropedidos.RelacionActivity;
import cl.inacap.tarea.u1.resumen.ResumenActivity;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class ContenedorActivity extends TabActivity {
	TabHost mTabhost;
	String login_enviar;
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contenedor);

		
		login_enviar = getIntent().getStringExtra("login"); // obtenemos nombre de usuario de vendedor
		
		mTabhost=getTabHost();
		
		TabSpec Spec = mTabhost.newTabSpec("Mantenedor");
		Spec.setIndicator("Mantenedor",null);
		Intent firstIntent = new Intent(ContenedorActivity.this,ClienteActivity.class);
		firstIntent.putExtra("login",login_enviar); // obtenemos login del usuario y lo utilizaremos en el activity cliente
		Spec.setContent(firstIntent);
		
		
		TabSpec Spec2 = mTabhost.newTabSpec("Registro");
		Spec2.setIndicator("Registro",null);
		Intent Intent2 = new Intent(ContenedorActivity.this,RelacionActivity.class);
		Intent2.putExtra("login",login_enviar); // obtenemos login del usuario y lo utilizaremos en el activity cliente
		Spec2.setContent(Intent2);
		
		
		TabSpec Spec3 = mTabhost.newTabSpec("Entrega");
		Spec3.setIndicator("Entrega",null);
		Intent Intent3 = new Intent(ContenedorActivity.this,VistaActivity.class);
		Intent3.putExtra("login",login_enviar); // obtenemos login del usuario y lo utilizaremos en el activity cliente
		Spec3.setContent(Intent3);
		
		
		TabSpec Spec4 = mTabhost.newTabSpec("Resumen");
		Spec4.setIndicator("Resumen",null);
		Intent Intent4 = new Intent(ContenedorActivity.this,ResumenActivity.class);
		Intent4.putExtra("login",login_enviar); // obtenemos login del usuario y lo utilizaremos en el activity cliente
		Spec4.setContent(Intent4);
		
	
		
		mTabhost.addTab(Spec);
		mTabhost.addTab(Spec2);
		mTabhost.addTab(Spec3);
		mTabhost.addTab(Spec4);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.contenedor, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
