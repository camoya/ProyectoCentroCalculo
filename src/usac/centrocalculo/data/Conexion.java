/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usac.centrocalculo.data;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.postgresql.copy.CopyManager;
import org.postgresql.core.BaseConnection;

/**
 *
 * @author Cristhofer Moya
 */
public class Conexion {

    private Connection conn;
    private String host;
    private String dbName;
    private String user;
    private String pass;

    //we don't like this constructor
    protected Conexion() {
    }

    public Conexion(String host, String dbName, String user, String pass) {
        this.host = host;
        this.dbName = dbName;
        this.user = user;
        this.pass = pass;
    }
    public boolean connect() throws SQLException, ClassNotFoundException {
		if (host.isEmpty() || dbName.isEmpty() || user.isEmpty() || pass.isEmpty()) {
			throw new SQLException("Database credentials missing");
		}
		
		Class.forName("org.postgresql.Driver");
		this.conn = DriverManager.getConnection(
				this.host + this.dbName,
				this.user, this.pass);
		return true;
    }
    public ResultSet execQuery(String query) throws SQLException {
		return this.conn.createStatement().executeQuery(query);
    }
	 
	public int insert(String table, Map<String,Object> values) throws SQLException {
		
		StringBuilder columns = new StringBuilder();
		StringBuilder vals = new StringBuilder();
		
		for (String col : values.keySet()) {
			columns.append(col).append(",");
			
			if (values.get(col) instanceof String) {
				vals.append("'").append(values.get(col)).append("', ");
			}
			else vals.append(values.get(col)).append(",");
		}
		
		columns.setLength(columns.length()-1);
		vals.setLength(vals.length()-1);

		String query = String.format("INSERT INTO %s (%s) VALUES (%s)", table,
				columns.toString(), vals.toString());
		
		return this.conn.createStatement().executeUpdate(query);
	}
    public long execCopy(String ruta){
    CopyManager copyManager;
        try {
            copyManager = new CopyManager((BaseConnection) this.conn);
            FileReader fileReader = new FileReader(ruta);
           return copyManager.copyIn("COPY urystemp FROM STDIN WITH (FORMAT csv, HEADER, DELIMITER ',', QUOTE '\"')", fileReader );
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return 0;

    }
        
}
