package dcx.ufpb.br.narutoswing;

import java.io.Serializable;
import java.util.Objects;

public class Ninja implements Serializable {
    private String nome;
    private String cla;
    private int poder;

    public Ninja(String nome, String cla, int poder){
        this.nome = nome;
        this.cla = cla;
        this.poder = poder;
    }

    @Override
    public String toString() {
        return "Ninja{" +
                "nome='" + nome + '\'' +
                ", cla='" + cla + '\'' +
                ", poder=" + poder +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ninja ninja = (Ninja) o;
        return nome.equals(ninja.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCla() {
        return cla;
    }

    public void setCla(String cla) {
        this.cla = cla;
    }

    public int getPoder() {
        return poder;
    }

    public void setPoder(int poder) {
        this.poder = poder;
    }
}
