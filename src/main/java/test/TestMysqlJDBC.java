package test;

import java.sql.*;

public class TestMysqlJDBC {

    public static void main(String[] args) {

        var url = "jdbc:mysql://localhost:3306/test";

        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url,"root","admin");
            Statement instruccion = conexion.createStatement();
            var sql = "SELECT idpersona,nombre,apellido,email,telefono From  persona";
            ResultSet resultado = instruccion.executeQuery(sql);
            
            while (resultado.next()){
              
                 System.out.print(" Idpersona:" + resultado.getInt("idpersona"));
                 System.out.print(" Nombre:" + resultado.getString("nombre"));
                 System.out.print(" Apellido: " + resultado.getString("Apellido"));
                 System.out.print(" Email: " + resultado.getString("email"));
                 System.out.print(" Telefono: " + resultado.getString("telefono"));
                 System.out.print("");
            }
            
            resultado.close();
            instruccion.close();
            conexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

    }

}
