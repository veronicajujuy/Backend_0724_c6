import org.apache.log4j.Logger;

import java.sql.*;

public class Main {
    public static final Logger logger = Logger.getLogger(Main.class);
    public static final String CREATE = "DROP TABLE ANIMALES IF EXISTS; CREATE TABLE ANIMALES (" +
            "ID INT AUTO_INCREMENT PRIMARY KEY, TIPO VARCHAR(50) NOT NULL," +
            "NOMBRE VARCHAR(50) NOT NULL) ";

    public static final String INSERT = "INSERT INTO ANIMALES VALUES (DEFAULT, 'GATO', 'GARFIELD')," +
            "(DEFAULT, 'GATO', 'MICHI'),(DEFAULT, 'PERRO', 'FIRULAIS'),(DEFAULT, 'PERRO', 'ODIE')," +
            "(DEFAULT, 'PERICO', 'GERMAN')";

    public static final String SELECT_ALL = "SELECT * FROM ANIMALES";

    public static void main(String[] args) {
        Connection connection = null;
        try{
            connection = getConnection();
            Statement statement = connection.createStatement();
            //CREAR TABLA
            statement.execute(CREATE);
            //INSERTAR DATOS
            statement.execute(INSERT);
            //TRAEMOS DATOS
            ResultSet resultSet = statement.executeQuery(SELECT_ALL);
            // MOSTRAR DATOS
            while (resultSet.next()){
                logger.info("animal: "+ resultSet.getInt(1)+ " "+
                        resultSet.getString(2)+" "+ resultSet.getString(3));
            }

        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:./clase8","sa","sa");
    }
}
//ID  TIPO  NOMBRE
//1   GATO  PEPE
//2   PERRO FIRU
