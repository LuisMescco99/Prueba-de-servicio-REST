#language: es
@RunTest
Característica: Probar el API-REST Mascota

  @ObtenerMascotasXId
  Escenario: Obtener mascotas en la API por id y validar resultado
    Dado que tengo el siguente dato de la mascota 1
    Y uso el encabezado de la mascota
    Cuando envio una solicitud de obtener mascota
    Entonces deberia mostrar el resultado de respuesta 200

  @AgregarMascotas
  Esquema del escenario: Agregar nuevas mascostas en la API y validar el resultado
    Dado que tengo datos para crear una mascota 1 y "<nombre>"
    Y uso el encabezado de la mascota
    Cuando envio una solicitud de agregar mascota
    Entonces deberia mostrar el resultado de respuesta 200
    Ejemplos:
      | nombre |
      | Body   |

  @ModificarMascota
  Esquema del escenario: Modificar mascota en la API y validar resultado
    Dado que tengo datos para actualizar una mascota 1 y "<nombre>"
    Y uso el encabezado de la mascota
    Cuando envio una solicitud de actualizar mascota
    Entonces deberia mostrar el resultado de respuesta 200
    Ejemplos:
      | nombre |
      | Thor   |