/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.DAO;

import es.albarregas.beans.Avistamiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jesus
 */
public class MySQLAvistamientosDAO implements IAvistamientosDAO {

    @Override
    public List<Avistamiento> getById(String anilla) {
               
        ResultSet resultado = null;
        Avistamiento avistamiento = null;
        ArrayList<Avistamiento> listado = null;
        

        String sql = "select * from avistamientos where anilla = ?";
        try {
            Connection conexion = ConnectionFactory.getConnectionMySQL();
            PreparedStatement preparada = conexion.prepareStatement(sql);

            preparada.setString(1, anilla);

            resultado = preparada.executeQuery();
            
            listado = new ArrayList<>();

            while (resultado.next()) {

                avistamiento = new Avistamiento();
                avistamiento.setAnilla(resultado.getString("anilla"));
                avistamiento.setEspecie(resultado.getString("especie"));
                avistamiento.setLugar(resultado.getString("lugar"));
                avistamiento.setFecha(resultado.getString("fecha"));
                listado.add(avistamiento);
            }
//            conexion = null;
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            this.closeConnection();
        }
        return listado;
    }

    @Override
    public List<Avistamiento> getAll() {
        ResultSet resultado = null;
        Avistamiento avistamiento = null;
        List<Avistamiento> listado = null;
        

        String sql = "select * from avistamientos";
        try {
            Connection conexion = ConnectionFactory.getConnectionMySQL();
            Statement sentencia = conexion.createStatement();
            

            

            resultado = sentencia.executeQuery(sql);
            
            listado = new ArrayList<>();

            while (resultado.next()) {

                avistamiento = new Avistamiento();
                avistamiento.setAnilla(resultado.getString("anilla"));
                avistamiento.setEspecie(resultado.getString("especie"));
                avistamiento.setLugar(resultado.getString("lugar"));
                avistamiento.setFecha(resultado.getString("fecha"));
                listado.add(avistamiento);
            }
//            conexion = null;
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            this.closeConnection();
        }
        return listado;
    }

    @Override
    public void closeConnection() {
        ConnectionFactory.closeConnection();
    }

}
