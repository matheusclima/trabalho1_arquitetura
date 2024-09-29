package domain;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    
    private static Controller instance = null;
    private List<Banda> bandas = new ArrayList<Banda>();
    private Controller() {}

    public static synchronized Controller getInstance(){
		if (instance == null){
			instance = new Controller();
		}
		return instance;
	}

    public void adicionarBanda(Banda banda) {
        bandas.add(banda);
    }

    public void removerBanda(Banda banda) {
        bandas.remove(banda);
    }

    public List<Banda> getBandas() {
        return bandas;
    }

    public int getQuantidadeBandas() {
        return bandas.size();
    }

    public void setBandas(List<Banda> bandas) {
        this.bandas = bandas;
    }

    public void listarBandas() {
        for (Banda banda : bandas) {
            System.out.println(banda);
        }
    }

    public Banda buscarBanda(int id) {
        for (Banda banda : bandas) {
            if (banda.getId() == id) {
                return banda;
            }
        }
        return null;
    }

    public void deletarBanda(Banda banda) {
        bandas.remove(banda);
    }

    public void editarNomeBanda(Banda banda, String nome) {
        banda.setNome(nome);
    }
}
