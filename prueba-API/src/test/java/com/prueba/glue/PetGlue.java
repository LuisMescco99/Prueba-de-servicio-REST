package com.prueba.glue;

import com.prueba.model.Pet;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class PetGlue {

    Pet mascota = new Pet();
    private RequestSpecification request;
    private Response response;

    //OBTENER MASCOTA
    @Dado("que tengo el siguente dato de la mascota {int}")
    public void queTengoElSiguenteDatoDeLaMascotaId(int id) {
        mascota.setId(id);
    }

    @Y("uso el encabezado de la mascota")
    public void usoElEncabezadoDeLaMascota() {
        request = given().header("Content-Type","application/json");
    }

    @Cuando("envio una solicitud de obtener mascota")
    public void envioUnaSolicitudDeObtenerMascota() {
        response = request.when()
                .get("https://petstore.swagger.io/v2/pet/" + mascota.getId());
    }

    @Entonces("deberia mostrar el resultado de respuesta {int}")
    public void deberiaMostrarElResultadoDeRespuesta(int code) {
        Assert.assertEquals(code,response.getStatusCode());
    }

    //AGREGAR MASCOTA TEST

    @Dado("que tengo datos para crear una mascota {int} y {string}")
    public void queTengoDatosParaCrearUnaMascotaY(int id, String nombre) {
        mascota.setId(id);
        mascota.setName(nombre);
    }

    @Cuando("envio una solicitud de agregar mascota")
    public void envioUnaSolicitudDeAgregarMascota() {
        response = request.when()
                .body(mascota)
                .post("https://petstore.swagger.io/v2/pet");
    }

    //MODIFICAR MASCOTA TEST

    @Dado("que tengo datos para actualizar una mascota {int} y {string}")
    public void queTengoDatosParaActualizarUnaMascotaY(int id, String nombre) {
        mascota.setId(id);
        mascota.setName(nombre);
    }

    @Cuando("envio una solicitud de actualizar mascota")
    public void envioUnaSolicitudDeActualizarMascota() {
        response = request.when()
                .body(mascota)
                .put("https://petstore.swagger.io/v2/pet");
    }
}
