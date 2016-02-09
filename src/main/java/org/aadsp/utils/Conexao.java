
package org.aadsp.utils;

import java.sql.*;

public class Conexao
{
    private static final String driverBanco = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String url  = "jdbc:sqlserver://localhost:1433;databaseName=AADSP";
    private static final String loginBanco = "sa";
    private static final String senhaBanco = "12345";
    private static Connection con;
    
    public Connection connectionOpen() throws ClassNotFoundException, SQLException{
        Class.forName(this.driverBanco);
        this.con = DriverManager.getConnection(this.url,this.loginBanco,this.senhaBanco);
        return this.con;
    }
    
    public void connectionClose() throws SQLException{
        this.con.close();
    }
    
}
