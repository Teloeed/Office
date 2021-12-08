package com.office.db;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionManager {
    private volatile static ConnectionManager instance;
    private Connection connection;

    private ConnectionManager() {
        try {
            InitialContext cxt = new InitialContext();
            DataSource ds = (DataSource) cxt.lookup("java:/comp/env/jdbc/office");
            if(ds == null) {
                throw new IllegalAccessException("DateSource not found");
            } else {
                connection = ds.getConnection();
            }
        } catch (NamingException | SQLException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    public static ConnectionManager getInstance() {
        ConnectionManager localInstance = instance;
        if (localInstance == null) {
            synchronized (ConnectionManager.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new ConnectionManager();
                }
            }
        }
        return localInstance;
    }
    public Connection getConnection() {
        return connection;
    }
}
