import java.time.LocalDate;

public class DispositivoInteligente {

	private LocalDate fecha;
	private Fabricante fabricante;
	
	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public Fabricante getFabricante() {
		return this.fabricante;
	}
}
