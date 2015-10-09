package capaDatos;

import java.util.ArrayList;
import java.sql.*;
import entidades.*;

public class CapaDatos {

	public int nuevoJuego(int jugador1, int jugador2) {
		
		ResultSet rs=null;
		PreparedStatement stmt=null;

		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into juego(jugador1, jugador2,turno) values (?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS
				   );
			stmt.setInt(1, jugador1);
			stmt.setInt(2, jugador2);
			stmt.setInt(3, 0);
			stmt.execute();

			rs=stmt.getGeneratedKeys();
			
			if(rs!=null && rs.next()){
				return rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			
			try {
				if(rs!=null ) rs.close();
				if(stmt != null) stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			FactoryConexion.getInstancia().releaseConn();
		}
		return 0;
	}

	public ArrayList<Pieza> cargarJuego(int nroJuego){
		ArrayList<Pieza> piezas = new ArrayList<Pieza>();
		ResultSet rs=null;
		PreparedStatement stmt=null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"select nropieza, color, columna, fila from piezas where nrojuego = ?"
					);
			stmt.setInt(1, nroJuego);
			rs = stmt.executeQuery();
			if(rs !=null){
				while (rs.next()){
					Pieza newpieza=null;
					switch (rs.getInt("nropieza")){
					case 1: newpieza = new Rey(rs.getInt("color"), rs.getInt("fila"), rs.getInt("columna"));
					break;
					case 2: newpieza = new Dama(rs.getInt("color"), rs.getInt("fila"), rs.getInt("columna"));
					break;
					case 3: newpieza = new Torre(rs.getInt("color"), rs.getInt("fila"), rs.getInt("columna"));
					break;
					case 4: newpieza = new Alfil(rs.getInt("color"), rs.getInt("fila"), rs.getInt("columna"));
					break;
					case 5: newpieza = new Caballo(rs.getInt("color"), rs.getInt("fila"), rs.getInt("columna"));
					break;
					case 6: newpieza = new Peon(rs.getInt("color"), rs.getInt("fila"), rs.getInt("columna"));
					break;
					}
					piezas.add(newpieza);
				}
				
			}
			return piezas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				if(rs!=null)rs.close();
				if(stmt!=null) stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			FactoryConexion.getInstancia().releaseConn();
		}
		return piezas;
	}
	
	public void actualizarTurno(int turno, int nroJuego){
		PreparedStatement stmt=null;

		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"update juego set turno = ? where nrojuego = ?");
			stmt.setInt(1, turno);
			stmt.setInt(2, nroJuego);
			stmt.executeUpdate();
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			
			try {
				if(stmt != null) stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			FactoryConexion.getInstancia().releaseConn();
		}		
	}
	
	public void eliminarJuego(int nroJuego) {
		PreparedStatement stmt=null;
		try {
			stmt = 	FactoryConexion.getInstancia().getConn().prepareStatement(
					"delete from pieza where nrojuego = ?"
					);
			stmt.setInt(1, nroJuego);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				if(stmt!=null) stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			FactoryConexion.getInstancia().releaseConn();
		}
		
		
	}
		
	public void guardarJuego(int nroJuego, ArrayList<Pieza> piezas){
		ResultSet rs=null;
		PreparedStatement stmt=null;
		for (Pieza i: piezas){
			try {
				stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
						"insert into piezas (nrojuego, nropieza, color, columna, fila) values (?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS
						);
				stmt.setInt(1, nroJuego);
				stmt.setInt(2, i.getNroPieza());
				stmt.setInt(3, i.getColor());
				stmt.setInt(4, i.getColumna());
				stmt.setInt(5, i.getFila());
				stmt.execute();
				
				rs=stmt.getGeneratedKeys();
			}
			catch (SQLException e){
				e.printStackTrace();
			}
			finally{
				
				try {
					if(rs!=null ) rs.close();
					if(stmt != null) stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				FactoryConexion.getInstancia().releaseConn();
			}

		}
	}

	public int getTurno(int nroJuego) {
		ResultSet rs=null;
		PreparedStatement stmt=null;
		try {
			stmt = 	FactoryConexion.getInstancia().getConn().prepareStatement(
					"select turno from juego where nrojuego = ?"
					);
			stmt.setInt(1, nroJuego);
			rs = stmt.executeQuery();
			if(rs !=null && rs.next()){
				return rs.getInt("turno");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				if(rs!=null)rs.close();
				if(stmt!=null) stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			FactoryConexion.getInstancia().releaseConn();
		}
		return 1;
	}
	

}
