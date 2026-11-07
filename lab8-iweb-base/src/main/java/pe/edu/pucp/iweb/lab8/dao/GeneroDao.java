package pe.edu.pucp.iweb.lab8.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.*;

import pe.edu.pucp.iweb.lab8.beans.Genero;

public class GeneroDao extends BaseDao { // TODO: heredar de BaseDao

    /**
     * Ejercicio 2: todos los géneros ordenados por nombre.
     */
    public ArrayList<Genero> listar() {
        // TODO
        ArrayList<Genero> lista = new ArrayList<>();
        String sql = "SELECT * FROM clases WHERE idGenero = ? ORDER BY nombre ";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idGenero);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Genero c = new Genero();
                    c.setIdGenero(  rs.getInt("idGenero"));
                    c.setNombre(rs.getString("nombre"));

                    listar().add(c);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return new ArrayList<>();
    }
}
