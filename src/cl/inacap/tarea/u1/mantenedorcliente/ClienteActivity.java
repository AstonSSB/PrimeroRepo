package cl.inacap.tarea.u1.mantenedorcliente;



import java.util.ArrayList;
import java.util.List;




import cl.inacap.tarea.u1.R;
import cl.inacap.tarea.u1.basededatos.DBmanager;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class ClienteActivity extends Activity implements OnItemSelectedListener, OnClickListener{
  
	/*
	  DECLARAMOS LAS VARIABLES NECESARIAS PARA R
	  CARGAR LISTA, MODIFICAR ELIMINAR E INSERTAR 
	 */
	Button  btn_insertar,btn_modificar,btn_eliminar;
	EditText  id_cliente,nombre,direccion,telefono;
	Spinner spin;
	private List<String> lista;
	String b;
	 ArrayAdapter<String> adaptador;
	 
	 /*
	  * FIN DECLARACION DE VARIABLES
	  * 
	  * */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cliente);
		
		// SE DECLARAN LOS BOTONES Y SE AGREGA METODO ONCLICK
		btn_insertar = (Button)findViewById(R.id.btn_insertar);
		btn_insertar.setOnClickListener(this);
		
		btn_modificar = (Button)findViewById(R.id.btn_modificar);
		btn_modificar.setOnClickListener(this);
		
		btn_eliminar = (Button)findViewById(R.id.btn_eliminar);
		btn_eliminar.setOnClickListener(this);
		
		//FIN DECLARAR BOTONES
		
		// DECLARAMOS CAMPOS DE TEXTO
		 id_cliente =(EditText)findViewById(R.id.txt_id);
		 nombre =(EditText)findViewById(R.id.txt_nombre);
		 
		 direccion =(EditText)findViewById(R.id.txt_direccion);
		 telefono =(EditText)findViewById(R.id.txt_telefono);
		 
		 //FIN CAMPOS DE TEXTO
		 
		 
		 // SE DECLARA SPINNER Y SE REALIZA LA CARGA DE LOS ID_VENDEDOR INGRESADOS
		 // A TRAVES DE LA FUNCION CARGAR_CLIENTE_RUT()
				  spin =  (Spinner)findViewById(R.id.ls_buscar);
				  spin.setOnItemSelectedListener(this);
				  
				  lista = new ArrayList<String>();
				  DBmanager managerspin = new DBmanager(this);
				  
				  lista = managerspin.cargar_cliente_rut();
				  adaptador=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lista);
			      adaptador.setDropDownViewResource(android.R.layout.simple_spinner_item);
			      
			      spin.setAdapter(adaptador);
			      adaptador.notifyDataSetChanged();
			      
	      // FIN CARGA DE LISTA
	}// CIERRA ONCREATE


	

	
		
	// FUNCION CLICK DE LOS BOTONES DEL ACTIVITY
	@Override
	public void onClick(View v) {
		
		switch(v.getId()){
		  case R.id.btn_insertar:
			  
			  try{
				  

					DBmanager manager = new DBmanager(this); // INSTANCIA DE LA BD
					// ASIGNAMOS EL VALOR DE LOS CAPOS DE TEXTO A NUESTRAS VARIABLES 
					String id_cliente1 = id_cliente.getText().toString();
					String nombre1 = nombre.getText().toString();
					String direccion1 = direccion.getText().toString();
					String telefono1 = telefono.getText().toString();
					//
					
					//VALIDAMOS QUE NO EXISTAN CAMPOS VACIOS
					if(id_cliente1.equals("") || nombre1.equals("") || direccion1.equals("") || telefono1.equals("") )
					{
						Toast.makeText(getBaseContext(), "no deje campos vacios", Toast.LENGTH_LONG).show();

					}else
					{
						// SE ENVIA LA INFORMACION A LA FUNCION INSERTAR_CLIENTE
						 manager.insertar_cliente(id_cliente1, nombre1, direccion1, telefono1);
						 Toast.makeText(getBaseContext(), "Insertando usuario", Toast.LENGTH_LONG).show();
						
						 // se recarga nuevamente la lista
						  
						  lista = manager.cargar_cliente_rut();
						  adaptador=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lista);
					      adaptador.setDropDownViewResource(android.R.layout.simple_spinner_item);
					      spin.setAdapter(adaptador);
					      adaptador.notifyDataSetChanged();
					}
						  
			  }
			  catch(Exception e)
			  {
					Toast.makeText(getBaseContext(), "error1"+e+" ", Toast.LENGTH_LONG).show();

			  }
	
			  	break;
			  	
			  case R.id.btn_modificar:
				  
				  try{
					  

					  DBmanager manager = new DBmanager(this);
						
						String id_cliente2 = id_cliente.getText().toString();
						String nombre2 = nombre.getText().toString();
						String direccion2 = direccion.getText().toString();
						String telefono2 = telefono.getText().toString();
						
						if(id_cliente2.equals("") || nombre2.equals("") || direccion2.equals("") || telefono2.equals("") )
						{
							
							Toast.makeText(getBaseContext(), "No deje campos vacios ", Toast.LENGTH_LONG).show();

						}else
						{
							
							manager.modificar_cliente(id_cliente2, nombre2, direccion2, telefono2);
							Toast.makeText(getBaseContext(), "modificando usuario ", Toast.LENGTH_LONG).show();
						}
					    
					  
					  
				  }
				  catch(Exception e)
				  {
						Toast.makeText(getBaseContext(), "error "+e+"", Toast.LENGTH_LONG).show();

				  }
				  
					break;
				  	
			  case R.id.btn_eliminar:
				  
				  try{
					  
					  	// se crea instancia de la bd
					  	DBmanager manager1 = new DBmanager(this);
						// obtienen valores del txt_rut
					  	
						String id_cliente3 = id_cliente.getText().toString();
						
						//validacion de txt_id_cliente no vacio para eliminar
						if(id_cliente3.equals(""))
						{
							Toast.makeText(getBaseContext(), "no dejar el campo rut vacio para eliminar ", Toast.LENGTH_LONG).show();

						}
						else
							{
									 // se envia dato a funcion eliminar
									 manager1.eliminar_cliente(id_cliente3);
									 Toast.makeText(getBaseContext(), "Usuario Eliminado ", Toast.LENGTH_LONG).show();
									// se recarga nuevamente la lista
		
							
							}// fin else
						
						 
						  
				  }
				  catch(Exception e)
				  {
						Toast.makeText(getBaseContext(), "error eliminar"+e+"", Toast.LENGTH_LONG).show();

				  }
				  
	break;
				  	
			
		}// fin switch
	} // fin funcion
	
	
	public void onItemSelected(AdapterView<?> parent, View arg1, int arg2,
			long arg3) {
		
			 int id = parent.getId();
			 
			 switch (id) 
		        {
			 			// se presiona un item del spinner y obtenemos su valor en el campo b
		                case R.id.ls_buscar:
		                	 b=spin.getItemAtPosition(arg2).toString();	
		                
		        }
						
			 			// al presionar y obtener el valor recargamos los datos del cliente
						id_cliente.setText(b);
						DBmanager manager = new DBmanager(this);
					
						String nombre1= manager.obtener_cliente(b);
						String direccion1= manager.obtener_direccion(b);
						String telefono1 = manager.obtener_telefono(b);
			
						
						nombre.setText(nombre1);
						direccion.setText(direccion1);
						telefono.setText(telefono1);
		}
	
	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// en caso de que la lista este vacia no muestra nada
		
	}
		
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cliente, menu);
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