package capaNegocio;

import capaDatos.CapaDatos;

public class CapaNegocio {
	
	private CapaDatos capaDatos = new CapaDatos();
	private Juego juego=null;
	
	public void nuevoJuego(String StrJugador1,String StrJugador2) throws NumberFormatException {
		int nroJuego;
		int jugador1;
		int jugador2;
		try {
			jugador1 = Integer.parseInt(StrJugador1);
			jugador2 = Integer.parseInt(StrJugador2);
			//nroJuego=capaDatos.nuevoJuego(jugador1,jugador2);
			juego = new Juego(1,jugador1,jugador2);
			juego.iniciarJuego();
		}
		catch (NumberFormatException e){
			throw e;
		}
	}
	
	public void guardarJuego() throws NullPointerException{
		if (juego==null){
			throw new NullPointerException("No hay juego iniciado");
		}
		capaDatos.actualizarTurno(juego.getTurno(), juego.getNroJuego());
		capaDatos.eliminarJuego(juego.getNroJuego());
		capaDatos.guardarJuego(juego.getNroJuego(), juego.getPiezas());
	}
	
	public void cargarJuego(String nroJuego){
		try{
			int cargar = Integer.parseInt(nroJuego);
			juego = new Juego();
			juego.setTurno(capaDatos.getTurno(cargar));
			juego.cargarJuego(capaDatos.cargarJuego(cargar));
		}
		catch (NumberFormatException e){
			throw e;
		}
	}
	
	public String movimiento(String strFromColumna, String strFromFila, String strToColumna, String strToFila) throws NullPointerException,Exception{
		try{
			if (juego==null){
				throw new NullPointerException("No hay juego iniciado");
			}			
			int fromColumna = (int) strFromColumna.charAt(0)-96;
			int fromFila = Integer.parseInt(strFromFila);			
			int toColumna = (int) strFromColumna.charAt(0)-96;
			int toFila = Integer.parseInt(strToFila);
			if (confirmarFilaColumna(toFila)&&confirmarFilaColumna(toColumna)&&confirmarFilaColumna(fromFila)&&confirmarFilaColumna(fromColumna)){
				int r = juego.confirmarPieza(fromColumna, fromFila, toColumna, toFila);
				switch (r){
				case 1: return strFromColumna+strFromFila+" -> "+strToColumna+strToFila+ "; Turno "+juego.getStrTurno();
				case 2: 
					juego = null;
					return "Rey capturado. Ganador jugador "+juego.getStrTurno();
				default: break;
				}
			}
			return "Movimiento no valido";
			
			
		}
		catch (NumberFormatException e){
			throw e;
		}		
	}
	
	public String confirmarPiezas() throws NullPointerException{
		if (juego==null){
			throw new NullPointerException("No hay juego iniciado");
		}
		return juego.confirmarPiezas();
	}
	
	private boolean confirmarFilaColumna(int filaColumna){
		if(filaColumna>0&&filaColumna<9){
			return true;
		}
		return false;
	}
}
