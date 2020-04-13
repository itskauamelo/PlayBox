/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import Model.Compra;
import Model.Cliente;

/**
 *
 * @author alunocmc
 */

public class CompraDAO {

    private static List<Compra> todasCompras = new ArrayList<Compra>();

    public void cadastrar(Compra compra) {
        todasCompras.add(compra);
    }

    public List<Compra> listarComprasUsuario(Cliente cliente) {
        
        List<Compra> comprasUsuario = new ArrayList<>();
        
        for (Compra compra : todasCompras) {
            if (compra.getCliente().getId() == cliente.getId()) {
                comprasUsuario.add(compra);
            }
        }
        
        Collections.sort(comprasUsuario, Compra.ordenar_por_data_desc);
        return comprasUsuario;
    }
}
