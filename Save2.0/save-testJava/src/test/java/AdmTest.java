import com.api.server.rmi.SaveService;
import org.junit.jupiter.api.Test;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import static org.junit.jupiter.api.Assertions.*;

public class AdmTest {

    @Test
    public void loginAdmTest() throws Exception {

        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 18000);
        SaveService stub = (SaveService) registry.lookup("Save");

        String emailT = "root@admin.com";
        String emailF = "testAdminFalse";

        assertTrue(stub.login(emailT));
        assertFalse(stub.login(emailF));
    }

    @Test
    public void usuarioAdminTest() throws Exception {

        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 18000);
        SaveService stub = (SaveService) registry.lookup("Save");

        String adminNameT = "admin";
        String adminNameF = "adminFalse";

        assertEquals(adminNameT,stub.getUsuario("root@admin.com").getNome());
        assertNotEquals(adminNameF,stub.getUsuario("root@admin.com").getNome());
    }

    @Test
    public void excluirUsuarioTest() throws Exception {

        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 18000);
        SaveService stub = (SaveService) registry.lookup("Save");

        String nomeT = "testTrue";
        String emailT = "testTrue";

        String emailF = "testFalse";

        //Criando usuário
        stub.cadastrar(emailT, nomeT);

        //Excluindo usuário
        assertTrue(stub.excluirUsuario(emailT));

        //Tentativa de excluir usuário inexistente
        assertFalse(stub.excluirUsuario(emailF));
    }
}
