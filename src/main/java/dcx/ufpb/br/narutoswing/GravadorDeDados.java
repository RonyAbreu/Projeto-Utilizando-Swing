package dcx.ufpb.br.narutoswing;

import java.io.*;
import java.util.ArrayList;


public class GravadorDeDados {

    public ArrayList<Ninja> leitorDeNinjas() throws IOException{
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("arquivosNinjas.dat"))){
            return (ArrayList<Ninja>) ois.readObject();
        } catch (IOException e){
            throw new IOException("Não foi encontrado o arquivo onde os dados serão lidos!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Erro!",e);
        }
    }

    public void gravaNinjas(ArrayList<Ninja> ninjas) throws IOException{
       try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("arquivosNinjas.dat"))){
           oos.writeObject(ninjas);
       } catch (IOException e){
           throw new IOException("Não foi encontrado o arquivo onde os dados estão salvos!");
       }
    }
}
