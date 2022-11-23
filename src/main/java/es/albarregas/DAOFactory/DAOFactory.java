package es.albarregas.DAOFactory;

import es.albarregas.DAO.IAvistamientosDAO;


public abstract class DAOFactory {

    public static final int MYSQL = 1;
    public static final int DERBY = 2;
    
    public abstract IAvistamientosDAO getAvistamientosDAO();
        
    public static DAOFactory getDAOFactory(int tipo){
        DAOFactory daof = null;
        
        switch(tipo){
            case 1:
                daof = new MySQLDAOFactory();
                break;
            case 2:
                daof = new DerbyDAOFactory();
                break;
        }
        
        return daof;
    }
    
}
