import dcx.ufpb.br.narutoswing.*;
import dcx.ufpb.br.narutoswing.Ninja;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AldeiaTest {

    @Test
    public void metodosNinjaTest(){
        AldeiaDeNinjas aldeia = new AldeiaDeNinjas();
        Ninja naruto = new Ninja("Naruto","Uzumaki",1200);
        try {
            aldeia.cadastrarNinja("Naruto","Uzumaki",1200);
            aldeia.cadastrarNinja("Sasuke","Uchiha",1000);
        } catch (NinjaJaExisteException e) {
            throw new RuntimeException("Ou esse ninja já existe no sistema, ou ele é inválido!",e);
        }

        try {
            aldeia.pesquisaNinja("Naruto");
            System.out.println("Esse ninja existe: " + naruto.getNome());
        } catch (NinjaInexistenteException e) {
            throw new RuntimeException("Ninja não existe!",e);
        }

        boolean existeNaruto = aldeia.existeNinja("Naruto");
        assertEquals("Naruto",naruto.getNome());
        assertEquals("Uzumaki",naruto.getCla());
        assertEquals(1200,naruto.getPoder());
        assertTrue(existeNaruto);

    }

}
