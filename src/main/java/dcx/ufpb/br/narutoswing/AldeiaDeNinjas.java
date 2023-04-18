package dcx.ufpb.br.narutoswing;

import java.util.*;

public class AldeiaDeNinjas implements MetodosNinja {
    private ArrayList<Ninja> ninjas;

    public AldeiaDeNinjas(ArrayList<Ninja> ninjas){
        this.ninjas = ninjas;
    }

    public AldeiaDeNinjas(){
        this(new ArrayList<>());
    }

    @Override
    public void cadastrarNinja(String nome, String cla, int poder) throws NinjaJaExisteException {
        if(existeNinja(nome)){
            throw new NinjaJaExisteException("Esse Ninja já foi cadastrado! Tente novamente com Outro Ninja.");
        } else {
            this.ninjas.add(new Ninja(nome,cla,poder));
        }
    }

    @Override
    public ArrayList<Ninja> pesquisaNinja(String nome) throws NinjaInexistenteException{
        ArrayList<Ninja> ninjaAchado = new ArrayList<>();
        for(Ninja c : this.ninjas){
            if(c.getNome().equals(nome)){
                ninjaAchado.add(c);
            }
        }
        if(ninjaAchado.size()==0){
            throw new NinjaInexistenteException("Não foi encontrado nenhum ninja com o nome: "+nome);
        } else{
            return ninjaAchado;
        }
    }

    @Override
    public void removeNinja(String nome) throws NinjaInexistenteException{
        for(Ninja n: this.ninjas){
            if(n.getNome().equals(nome)){
                ninjas.remove(n);
                break;
            }
            throw new NinjaInexistenteException("Não existe nenhum ninja cadastrado com esse Nome!");
        }
    }

    @Override
    public boolean existeNinja(String nome) {
        for (Ninja n : this.ninjas) {
            if (n.getNome().equals(nome)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public ArrayList<Ninja> getNinjas() {
        return this.ninjas;
    }

}
