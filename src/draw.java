
public class draw {
	
	public double total;
	public double ocio;
	public double servicios;
	public double comida;
	public double estudios;

	public draw(double ocio, double servicios, double comida, double estudios) {
		this.total = 0;
		this.ocio = ocio;
		this.servicios = servicios;
		this.comida = comida;
		this.estudios = estudios;
	}
	
	public void setTotal(){
		total = ocio+ servicios+ comida + estudios;
	}
	
	public double getPorcentaje(double d){
		double porcentaje= (d/total)*100;
		return porcentaje;
	}
	
}

