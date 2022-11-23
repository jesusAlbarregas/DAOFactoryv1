/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.DAO;

import es.albarregas.beans.Avistamiento;

import java.util.List;

/**
 *
 * @author Jesus
 */
public interface IAvistamientosDAO {

    public List<Avistamiento> getById(String anilla);
    public List<Avistamiento> getAll();
    public void closeConnection();
    
}
