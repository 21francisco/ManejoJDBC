package datos;

import static datos.Conexion.*;
import domain.Persona;
import java.sql.*;
import java.util.*;

public class PersonaDAO {

    private static final String SQL_SELECT = "SELECT idpersona, nombre, apellido,email, telefono From persona";

    public List<Persona> seleccionar() {

       Connection conn = null;

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;

        List<Persona> personas = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareCall(SQL_SELECT);

            rs = stmt.executeQuery();
            while (rs.next()) {

                int idpersona = rs.getByte("idpersona");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                persona = new Persona(idpersona, nombre, apellido, email, telefono);

                persona.add(persona);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {

                conn.close();
                stmt.close();
                rs.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return personas;
    }
}
