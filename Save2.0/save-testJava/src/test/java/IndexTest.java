import com.api.server.rmi.SaveService;
import org.junit.jupiter.api.Test;

import java.rmi.registry.*;
import java.rmi.registry.Registry;

import static org.junit.jupiter.api.Assertions.*;

public class IndexTest {

    @Test
    public void cadastroTest() throws Exception {

        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 18000);
        SaveService stub = (SaveService) registry.lookup("Save");

        String nomeT = "testTrue";
        String emailT = "testTrue@email.com";

        String nomeF ="admin";
        String emailF = "root@admin.com";

        assertTrue(stub.cadastrar(emailT, nomeT));
        assertFalse(stub.cadastrar(emailF, nomeF));


        stub.excluirUsuario(emailT);
    }

    @Test
    public void loginTest() throws Exception {

        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 18000);
        SaveService stub = (SaveService) registry.lookup("Save");

        String emailT = "root@admin.com";
        String emailF = "testFalse@email.com";

        assertTrue(stub.login(emailT));
        assertFalse(stub.login(emailF));
    }

}
