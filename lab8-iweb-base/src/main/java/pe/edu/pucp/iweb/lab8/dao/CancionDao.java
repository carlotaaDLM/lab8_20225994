package pe.edu.pucp.iweb.lab8.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.*;
import java.util.ArrayList;

import pe.edu.pucp.iweb.lab8.beans.Cancion;

public class CancionDao extends BaseDao{ // TODO: heredar de BaseDao

    /**
     * Ejercicio 2: todas las canciones (con el nombre de su género, JOIN),
     * ordenadas por título. Use PreparedStatement.
     */
    public ArrayList<Cancion> listar() {
        // TODO
        ArrayList<Cancion> lista = new ArrayList<>();
        String sql = "SELECT * FROM clases WHERE idCancion = ? ORDER BY ";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idCancion);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Cancion c = new Cancion();
                    c.setIdCancion(rs.getInt("id_cancion"));
                    c.setTitulo(rs.getString("titulo"));
                    c.setArtista(rs.getString("artista"));
                    c.setDuracionSeg(rs.getInt("duracion_seg"));
                    c.setAnio(rs.getInt("anio"));
                    c.setGenero(rs.get("genero"));
                    listar().add(c);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }



    /**
     * Ejercicio 2: la canción con ese id, o null si no existe.
     */
    public Cancion buscarPorId(int idCancion) {
        // TODO
        return null;
    }

    /**
     * Ejercicio 2: INSERT de una canción nueva (PreparedStatement).
     */
    public void crear(Cancion cancion) {
        // TODO
    }

    /**
     * Ejercicio 2: UPDATE de una canción existente (PreparedStatement).
     */
    public void actualizar(Cancion cancion) {
        // TODO
    }

    /**
     * Ejercicio 3: DELETE por id (PreparedStatement).
     */
    public void eliminar(int idCancion) {
        // TODO
    }
}
