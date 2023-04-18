package dcx.ufpb.br.narutoswing;

import java.util.ArrayList;

public interface MetodosNinja {
    void cadastrarNinja(String nome, String cla, int poder) throws NinjaJaExisteException;
    ArrayList<Ninja> pesquisaNinja(String nome) throws NinjaInexistenteException;
    void removeNinja(String nome)throws NinjaInexistenteException;
    boolean existeNinja(String nome);
    ArrayList<Ninja> getNinjas();
}
