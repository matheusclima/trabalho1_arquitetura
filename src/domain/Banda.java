package domain;
import java.util.*;


public class Banda {
    private int id;
    private String nome;
    private String genero;
    private List<String> integrantes;
    private int anoDeFormacao;

    public Banda(int id, String nome, String genero, List<String> integrantes, int anoDeFormacao) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.integrantes = integrantes;
        this.anoDeFormacao = anoDeFormacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public List<String> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(List<String> integrantes) {
        this.integrantes = integrantes;
    }

    public int getAnoDeFormacao() {
        return anoDeFormacao;
    }

    public void setAnoDeFormacao(int anoDeFormacao) {
        this.anoDeFormacao = anoDeFormacao;
    }

    @Override
    public String toString() {
        return "id = " + id + ", Nome = " + nome +  ", Genero = " + genero + ", Integrantes = "
                + integrantes + ", Ano de Formação = " + anoDeFormacao;
    }
}
