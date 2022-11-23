package es.albarregas.DAOFactory;

import es.albarregas.DAO.IAvistamientosDAO;
import es.albarregas.DAO.MySQLAvistamientosDAO;


public class MySQLDAOFactory extends DAOFactory {

    @Override
    public IAvistamientosDAO getAvistamientosDAO() {
        return new MySQLAvistamientosDAO();
    }

      
}
