/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mueblesdelosalpes.servicios;

import co.edu.uniandes.csw.mueblesdelosalpes.dto.Mueble;
import co.edu.uniandes.csw.mueblesdelosalpes.dto.Usuario;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioCarritoMockLocal;
import java.util.ArrayList;
import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author nicoc
 */
@Stateless
@Path("/carrito")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@PermitAll
public class CarritoService {
    
    @EJB
    private IServicioCarritoMockLocal carritoMock;
    
    @GET
    @Path("/inventario")
    public ArrayList<Mueble> getInventario(){
        return carritoMock.getInventario();
    }
    
    @PUT
    @Path("/setInventario")
    public void setInventario(ArrayList<Mueble> inventario){
        carritoMock.setInventario(inventario);
    }
    
    @GET
    @Path("/getPrecioTotalInv")
    public double getPrecioTotalInventario(){
        return carritoMock.getPrecioTotalInventario();
    }
    
    @GET
    @Path("/getTotalUnd")
    public int getTotalUnidades(){
        return carritoMock.getTotalUnidades();
    }
    
    @POST
    @Path("/comprar")
    public void comprar(Usuario usuario){
        carritoMock.comprar(usuario);
    }
    
    @POST
    @Path("/addItem")
    
    public void agregarItem(Mueble mueble){
        carritoMock.agregarItem(mueble);
    }
    
    @DELETE
    @Path("/removeitem/{ref}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void removerItem(@PathParam("ref") int ref, @QueryParam("removerCero")boolean removerCero){
        Mueble m = new Mueble();
        m.setReferencia(ref);
        carritoMock.removerItem(m, removerCero);
    }
    
    @PUT
    @Path("/recalc")
    public void recalcularInventarioTotal(){
        carritoMock.recalcularInventarioTotal();
    }
    
    @DELETE
    @Path("/clean")
    public void limpiarLista(){
        carritoMock.limpiarLista();
    }
}
