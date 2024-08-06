import db.H2Connection;
import model.Cuenta;
import org.apache.log4j.Logger;

import java.sql.*;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);
    private static final String CREATE = "DROP TABLE CUENTAS IF EXISTS;" +
            "CREATE TABLE CUENTAS (ID INT AUTO_INCREMENT PRIMARY KEY," +
            "NROCUENTA VARCHAR(25) NOT NULL, NOMBRE VARCHAR(25) NOT NULL," +
            "SALDO DECIMAL(7,2) NOT NULL)";
    private static final String INSERT = "INSERT INTO CUENTAS VALUES (DEFAULT,?,?,?)";

    private static final String SELECT_ALL = "SELECT * FROM CUENTAS";
    private static final String UPDATE = "UPDATE CUENTAS SET SALDO=? WHERE ID=?";

    public static void main(String[] args) {
        Connection connection = null;
        Cuenta cuenta = new Cuenta("456788","pepito.mp", 1500);
        Cuenta cuentaDesdeDb = null;
        try{
            connection = H2Connection.getConnection();
            Statement statement = connection.createStatement();
            //CREAR LA TABLA CUENTAS
            statement.execute(CREATE);
            // insertar datos en la tabla
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, cuenta.getNroCuenta());
            preparedStatement.setString(2, cuenta.getNombre());
            preparedStatement.setDouble(3, cuenta.getSaldo());
            preparedStatement.executeUpdate();
            //traer los datos de la base de datos
            ResultSet resultSet = statement.executeQuery(SELECT_ALL);
            while (resultSet.next()){
                Integer id = resultSet.getInt(1);
                String nroCuenta = resultSet.getString(2);
                String nombre = resultSet.getString(3);
                double saldo = resultSet.getDouble(4);
                cuentaDesdeDb = new Cuenta(id, nroCuenta, nombre,saldo);
            }
            logger.info(cuentaDesdeDb);
            // crear una transaccion
            connection.setAutoCommit(false);
            try {
                preparedStatement = connection.prepareStatement(UPDATE);
                preparedStatement.setDouble(1, cuentaDesdeDb.getSaldo() + 15);
                preparedStatement.setInt(2, cuentaDesdeDb.getId());
                preparedStatement.execute();
                //int division = 7/0;
                connection.commit();
                cuentaDesdeDb.setSaldo(cuentaDesdeDb.getSaldo()+15);
            } catch (Exception e){
                logger.error("se ejecuto el rollback" +e.getMessage());
                connection.rollback();
            } finally {
                connection.setAutoCommit(true);
            }
            //traer los datos de la base de datos
            resultSet = statement.executeQuery(SELECT_ALL);
            while (resultSet.next()){
                Integer id = resultSet.getInt(1);
                String nroCuenta = resultSet.getString(2);
                String nombre = resultSet.getString(3);
                double saldo = resultSet.getDouble(4);
                cuentaDesdeDb = new Cuenta(id, nroCuenta, nombre,saldo);
            }
            logger.info(cuentaDesdeDb);

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
}
