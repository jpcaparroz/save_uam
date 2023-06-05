import com.api.server.rmi.SaveService;
import com.api.server.rmi.modules.Filme;
import com.api.server.rmi.modules.FilmeUsuario;
import org.junit.jupiter.api.Test;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import static org.junit.jupiter.api.Assertions.*;

public class FilmesTest {

    @Test
    public void top250Test() throws Exception {

        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 18000);
        SaveService stub = (SaveService) registry.lookup("Save");

        int testResultT = 250;
        int testResultF = 1;

        int listSize = stub.getMelhoresFilmes().size();

        assertEquals(testResultT, listSize);
        assertNotEquals(testResultF, listSize);
    }

    @Test
    public void top1FilmTest() throws Exception {

        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 18000);
        SaveService stub = (SaveService) registry.lookup("Save");

        String filmName = "The Shawshank Redemption";
        String filmPoster ="https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_Ratio0.6716_AL_.jpg";
        int filmYear = 1994;

        Filme filmT = stub.getMelhoresFilmes().get(0);
        Filme filmF = stub.getMelhoresFilmes().get(1);

        assertEquals(filmName, filmT.getNomeFilme());
        assertEquals(filmPoster, filmT.getPosterFilme());
        assertEquals(filmYear, filmT.getAnoFilme());

        assertNotEquals(filmName, filmF.getNomeFilme());
        assertNotEquals(filmPoster, filmF.getPosterFilme());
        assertNotEquals(filmYear, filmF.getAnoFilme());
    }

    @Test
    public void searchFilmTest() throws Exception {

        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 18000);
        SaveService stub = (SaveService) registry.lookup("Save");

        String searchFilmName = "Joker";
        String filmNameT = "Joker";
        String filmNameF = "Test";

        String filmNameResult = stub.getFilme2(searchFilmName).get(0).getNomeFilme();

        assertEquals(filmNameT, filmNameResult);
        assertNotEquals(filmNameF, filmNameResult);
    }

    @Test
    public void saveFilmTest() throws Exception {

        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 18000);
        SaveService stub = (SaveService) registry.lookup("Save");

        // Criando filmeT
        FilmeUsuario filmeT = new FilmeUsuario();
        filmeT.setNomeFilme("Filme Tesste");
        filmeT.setAnoFilme(2023);
        filmeT.setPosterFilme("https//:www.teste.com.br");
        filmeT.setNotaFilme(5);

        // Criando usuario
        String email = "teste@teste.com";
        stub.cadastrar(email, "teste");

        assertTrue(stub.adicionarFilme(filmeT,email));

        // Excluindo usuario teste
        stub.excluirUsuario(email);
    }
}
