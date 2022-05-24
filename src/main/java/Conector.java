import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

    public class Conector {

        String url = "D:\\test.db";
        Connection connect;

        public void connect() {
            try {
                connect = DriverManager.getConnection("jdbc:sqlite:" + url);
                if (connect != null) {
                    System.out.println("Conectado");
                }
            } catch (SQLException ex) {
                System.err.println("No se ha podido conectar a la base de datos\n" + ex.getMessage());
            }
        }

        public void close() {
            try {
                connect.close();
            } catch (SQLException ex) {
                Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        public void insertAlumno(Alumno alumno) {
            try {
                PreparedStatement st = connect.prepareStatement("insert into alumnos (nombre, apellidos) values (?,?)");
                st.setString(1, alumno.getNombre());
                st.setString(2, alumno.getApellidos());
                st.execute();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }

        }

        public void consultaAlumno() {
            ResultSet result = null;
            try {
                PreparedStatement st = connect.prepareStatement("select * from alumnos");
                result = st.executeQuery();
                while (result.next()) {
                    System.out.print("ID: ");
                    System.out.println(result.getInt("id"));

                    System.out.print("Nombre: ");
                    System.out.println(result.getString("nombre"));

                    System.out.print("Apellidos: ");
                    System.out.println(result.getString("apellidos"));

                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        }
        
        public void borrarAlumno(){
            
            try {
                connect = DriverManager.getConnection(url);

                Statement st = (Statement) connect.createStatement();
                /*
                 // borra un usuario en concreto
                 st.execute("DELETE * FROM alumnos WHERE id='1'");

                // borra todos los usuarios
                st.execute("DELETE * FROM alumnos");

                // borra la tabla users
                st.execute("DELETE TABLE alumnos");
                */
            } catch (Throwable e)  {
                System.out.println("Ha fallado el borrado de datos");
                e.printStackTrace();
            } finally {
                try { connect.close(); }
            catch (Throwable t){}
            }

    }


