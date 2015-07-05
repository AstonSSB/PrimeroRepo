package cl.inacap.tarea.u1.entregapedido;

import java.util.ArrayList;
import java.util.List;

import cl.inacap.tarea.u1.R;
import cl.inacap.tarea.u1.basededatos.DBmanager;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class VistaActivity extends Activity implements OnItemSelectedListener, OnClickListener{
	
	Spinner lista_boleta,lista_cliente,ls_producto;
	private List<String> lista,lista_b,lista_producto;
	Button btn_buscar;
	String num_boletas,rut_cliente,login_enviar;
	String producto_seleccionado;
	String estado_p="PRODUCTO ENTREGADO";
	Button btn_entregar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vista);
		
		
		login_enviar = getIntent().getStringExtra("login"); // obtenemos nombre de usuario de vendedor
		
		
		
		lista_cliente =  (Spinner)findViewById(R.id.ls_clientes);
		lista_cliente.setOnItemSelectedListener(this);
		lista = new ArrayList<String>();
		DBmanager managerspin = new DBmanager(this);
		lista = managerspin.cargar_cliente(login_enviar);
		ArrayAdapter<String> adaptador =new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lista);
	    adaptador.setDropDownViewResource(android.R.layout.simple_spinner_item);
	    lista_cliente.setAdapter(adaptador);
	    lista_cliente.setOnItemSelectedListener(this);

	    lista_boleta =  (Spinner)findViewById(R.id.ls_cargar_boletas);
		lista_boleta.setOnItemSelectedListener(this);
		
		ls_producto =  (Spinner)findViewById(R.id.ls_carga_productos);
		ls_producto.setOnItemSelectedListener(this);
			
		
		btn_entregar= (Button)findViewById(R.id.btn_entregar);
		btn_entregar.setOnClickListener(this);
		
	
	    
	}

	
	@Override
	public void onClick(View v) {
	


	 
			  try{
				  	
				  DBmanager manager2 = new DBmanager(this);
					
					
					manager2.entregar_producto(login_enviar,rut_cliente,num_boletas,producto_seleccionado,estado_p);
					
					Toast.makeText(getBaseContext(), "Producto entregado ", Toast.LENGTH_LONG).show();

				   
					
			  }
			  catch(Exception e)
			  {
					Toast.makeText(getBaseContext(), "error1"+e+" ", Toast.LENGTH_LONG).show();

			  }
	
	}

	@Override
	
		public void onItemSelected(AdapterView<?> parent, View arg1, int arg2,
				long arg3) {
		 int id1 = parent.getId();
		    
	        
		 switch (id1) 
	        {
		 
	        case R.id.ls_clientes:
			    rut_cliente=lista_cliente.getItemAtPosition(arg2).toString();	
				
			    lista_b = new ArrayList<String>();
				DBmanager manager_b = new DBmanager(this);
				lista_b = manager_b.obtener_boleta(rut_cliente,login_enviar);
				ArrayAdapter<String> adaptador_b =new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lista_b);
			    adaptador_b.setDropDownViewResource(android.R.layout.simple_spinner_item);
			    lista_boleta.setAdapter(adaptador_b);
			    lista_boleta.setOnItemSelectedListener(this);
			    
			   break;
			   
			   
	        	case R.id.ls_cargar_boletas:
	        		
	                 num_boletas= lista_boleta.getItemAtPosition(arg2).toString();
				
	                 	lista_producto = new ArrayList<String>();
		         		DBmanager manager_p = new DBmanager(this);
		         		lista_producto = manager_p.mostrar_productos_no_entregados(login_enviar,rut_cliente,num_boletas);
		         		ArrayAdapter<String>adaptador_p = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lista_producto);
		         	    adaptador_p.setDropDownViewResource(android.R.layout.simple_spinner_item);
		         	    ls_producto.setAdapter(adaptador_p);
		         	    ls_producto.setOnItemSelectedListener(this);
		         	    
		         	    
	             break;
	      
					 
					
				 
				   
				  
		        	case R.id.ls_carga_productos:
		        		
		                 producto_seleccionado= ls_producto.getItemAtPosition(arg2).toString();
		               
		         		
					break;
		          
		        
	          
	        }
		
		
	}
	
	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.vista, menu);
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

