package es.albarregas.DAOFactory;

import es.albarregas.DAO.DerbyAvistamientosDAO;
import es.albarregas.DAO.IAvistamientosDAO;


public class DerbyDAOFactory extends DAOFactory{

    @Override
    public IAvistamientosDAO getAvistamientosDAO() {
        return new DerbyAvistamientosDAO();
    }

    
    
}
