package test;
import datos.Prestador;
import negocio.PrestadorABM;

public class TestPrestadorHBM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PrestadorABM prestador= new PrestadorABM();
		
		try {
			prestador.registrarPrestador("Rodro", "1234", "3fgd", "av araujo", true);
			//prestador.registrarPrestador("Marian", "1234", "3fgd", "av araujo", true);<---falla
			prestador.registrarPrestador("Nico", "1234", "ghrg", "av araujo", true);
			prestador.registrarPrestador("Lucas", "1234", "hola", "av araujo", true);
			prestador.eliminarPrestador(prestador.traerPrestador("hola").getIdUsuario());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Prestador p= prestador.traerPrestador("3fgd");
		p.setRazonSocial("buenas");
		
		try {
			prestador.modificarPrestador(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		p.setRazonSocial("ghrg");
		
		try {
			prestador.modificarPrestador(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

}
