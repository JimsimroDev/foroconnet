# Foroconect

## Descripción
Esta API consiste en la creacion de tipicos tambien tienes la opcion de editar actualizar topicos, tambien puedes crear o registrar un usuario y hacer el login con ese usuario para que pudas gestionar los tipicos

# Rutas que tiene la api
 > [!IMPORTANT] Rutas que tiene la api
http://localhost:8080/login
http://localhost:8080/topicos.
http://localhost:8080/topicos.?size=20
http://localhost:8080/topicos.
http://localhost:8080/topicos./24
http://localhost:8080/respuestas
http://localhost:8080/usuarios.
http://localhost:8080/topicos./1

# La respuesta de cada edpoint es en json
Este es un ejemplo real de la respuesta que arroja el edpoint
>[!example]
respuesta de edpoint
http://localhost:8080/topicos./1
```
{
"id": 1,
	"titulo": "titulo de prueba 01",
	"mensaje": "como hace el delecte?",
	"fehcaCreacion": "2024-07-25T17:33:37",
	"estado": "pendiente",
	"curso": {
		"id": 1,
		"nombre": "curso java",
		"categoria": "programacion"
	},
	"autor": {
		"id": 1,
		"nombre": "jimmis.simanca"
	},
	"respuestas": [
		{
			"id": 1,
			"mensaje": "Este es un mensaje de ejemplo",
			"solucion": "Esta es una solución de ejemplo",
			"fechaCreacion": "2024-07-25T10:00:00"
		},
		{
			"id": 2,
			"mensaje": "Usar expresiones regulare",
			"solucion": "debese usar algo as {/7cd//sd}",
			"fechaCreacion": "2024-07-25T18:01:29.341038"
		}
	]
}
```

# Tecnologia usadas
<i class="material-icons">Java</i>
