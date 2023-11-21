import java.sql.Connection;
import java.sql.DriverManager;

public class databaseManagement {

    //Insertar Usuario y contraseña
    private static String user = "prueba";
    private static String pass = "mipg";
    //Management para manejo de datos
    private  static  Connection connection;

    public static void initConnection(){ //Inicializar conexion
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/prueba1",user,pass);
            System.out.println("Conectado");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
