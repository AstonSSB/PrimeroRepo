ASIGNATURA: Programación de aplicaciones móviles en Android
Unidad 1:   Introducción a Android
Actividad   Trabajo: Primera aplicación en Android
Profesor:   Cristian Correa Urrutia.
Alumno  : Jonathan Andres Vásquez Subiabre.

Datos importantes y explicación de las pantallas.


USUARIOS VENDEDOR INGRESADOS 

Login  clave
test   test
juan   juan 


****mantenedor cliente

Se realiza la carga de clientes en un Spinner el cual muestra el rut de los clientes 
ingresados, al presionar un rut este cargara la información en los campos de texto y de esa forma podremos
eliminar y actualizar.

****Registro de Pedidos

Lo primero que se debe realizar es ingresar un número de orden de compra( boleta o numero de compra 
Como resulte mas facil de entender) de esta manera podremos ingresar cuantos productos queramos 
para asociarlos a un cliente y a una orden(Boleta)

ejemplo:
numero boleta   producto     id_cliente  cantidad
1               coca cola        123456     5
1               vino             123456     2

****Registrar entrega de productos por boleta o orden de compra

En esta sección cargamos un spinner con los clientes que han sido atendidos por el vendedor logeado
al presionar el cliente cargamos el numero de boletas asociadas al client.
 luego mostrarnos en otra lista los productos que aun no se han entregado a los cuales al seleccionar algun elemento 
de la lista y presionar el boton entregar producto cambian de estado y quedan como producto entregado en la BD.


****RESUMEN

En la ultima sección lo que veremos es una lista de clientes asociados a ventas del "vendedor"
al seleccionar un usuario enviaremos esos datos a otro activity el cual nos mostrara la informacion de las 
ordenes de compra realizadas. Al seleccionar una orden nos mostrara en los demas campos la informacion general de 
esa venta 
numero de productos no entregados segun compras realizadas al vendedor logeado
numero de productos entregados  segun compras realizadas al vendedor logeado
total de compras realizadas por el usuario independiente de el numero de orden y del vendedor logeado.









