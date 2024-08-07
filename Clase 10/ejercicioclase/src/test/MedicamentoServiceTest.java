package test;

import dao.impl.DaoH2Medicamento;
import model.Medicamento;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.MedicamentoService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MedicamentoServiceTest {
    static final Logger logger = Logger.getLogger(MedicamentoServiceTest.class);
    MedicamentoService medicamentoService = new MedicamentoService(new DaoH2Medicamento());
    @BeforeAll
    static void crearTablas(){
        Connection connection = null;
        try{
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:./farmacia;INIT=RUNSCRIPT FROM 'create.sql'", "sa","sa");
        }catch (Exception e){
            logger.error(e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                logger.error(ex.getMessage());
            }
        }
    }

    @Test
    @DisplayName("Testear que un medicamento se guardo en la bd")
    void caso1(){
        //dado
        Medicamento medicamento = new Medicamento(555,"Loratadina","Bayer",12,250);
        // cuando
        Medicamento medicamentoDesdeLaDB = medicamentoService.guardarMedicamento(medicamento);
        //entonces
        assertNotNull(medicamentoDesdeLaDB.getId());
    }

    @Test
    @DisplayName("Testear la busqueda de un medicamento por nombre")
    void caso2(){
        //dado
        String nombre = "Ibupirac";
        // cuando
        Medicamento medicamentoDesdeLaDB = medicamentoService.buscarPorNombre(nombre.toUpperCase());
        //entonces
        assertEquals(nombre.toUpperCase(), medicamentoDesdeLaDB.getNombre());
    }

    @Test
    @DisplayName("Testear que me traiga todos los medicamentos guardados")
    void caso3(){
        //dado
        List<Medicamento> medicamentos = new ArrayList<>();
        //cuando
        medicamentos = medicamentoService.buscarTodos();
        //entonces
        //assertFalse(medicamentos.isEmpty());
        assertTrue(medicamentos.size()!= 0);

    }

}