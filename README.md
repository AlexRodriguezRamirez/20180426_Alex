# 20180426_Alex

Commit 29/04/2018: Añadido el proyecto CRUD. En dicho proyecto se pueden añadir distintas aves en una base de datos, pudiendo también actualizarse, eliminarse o consultarse datos sobre la misma. Desde el index se accede a un controlador, que en función de la opción elegida nos redirige a una parte distinta del proyecto. Cada una de estas partes tiene sus porpios controladores y vistas, mientras que el bean es común para todas ellas, así como el modelo de acceso al pool de conexiones. 

La parte de Lectura de datos solamente tiene dos vistas y un controlador, en la primera vista se introduce la anilla del ave que se quiere consultar, el controlador comprueba que no haya errores y redirige el flujo hacia la otra vista, donde se mostrarán los datos correspondientes a la anilla introducida o los errores que se hayan producido.

Las otras tres partes son muy similares entre sí: Constan de 3 vistas y 2 controladores cada una, que funcionan de manera similar a la parte de lectura, añadiendo una vista más entre la entrada y la salida de información para solicitar la confirmación al cliente, evitando así que se puedan borrar o modificar datos por error.

Queda pendiente modificar la parte de eliminación de registros para implementar que se puedan eliminar varios a la vez mediante checkboxes en vez de radio buttons.


Commit 29/04/2018: Añadida la llamada al método doLog() en todos los bloques try-catch de los controladores.