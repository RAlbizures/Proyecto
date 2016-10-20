
public class draw {
	public double total;
	public double ocio;
	public double servicios;
	public double comida;
	public double estudios;
	
	public void setTotal(double ocio, double servicios, double comida, double estudios){
		total = ocio+ servicios+ comida + estudios;
	}
	
	public double getDatosOcio(double ocio){
		double porcentaje= (ocio/total)*100;
		return porcentaje;
	}
	
	public double getDatoServicio(double servicio){
		double porcentaje = (servicio/total)*100;
		return porcentaje;
	}
	
	public double getDatoComida(double comida){
		double porcentaje= (ocio/total)*100;
		return porcentaje;
	}
	
	public double getDatoEstudios(double estudios){
		double porcentaje= (estudios/total)*100;
		return porcentaje;
	}
}
