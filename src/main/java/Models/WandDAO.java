package Models;

import DataBase.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WandDAO {

    private Connection conn;

    public WandDAO() {
        conn = DBConnection.getConnection();
    }

    public void create(Wand wand) throws SQLException {
        String sql = "INSERT INTO wand (wood, core, length) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, wand.getWood());
        ps.setString(2, wand.getCore());
        ps.setDouble(3, wand.getLength());
        ps.executeUpdate();
        ps.close();

    }

    public List<Wand> getAll() throws SQLException {
        List<Wand> list = new ArrayList<>();
        Statement st = conn.createStatement();
        String sql = "SELECT * FROM wand";
        ResultSet rs = st.executeQuery(sql);

        while(rs.next()){
            list.add(new Wand((rs.getInt("id")),rs.getString("wood"), rs.getString("core"), rs.getDouble("length")));
        }
        rs.close();
        return list;
    }

    public Wand getById(int id) throws SQLException {
        String sql = "SELECT * FROM wand WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        Wand w = null;
        if(rs.next()){
            w = new Wand(rs.getInt("id"),rs.getString("wood"), rs.getString("core"), rs.getDouble("length"));
        }
        rs.close();
        ps.close();
        return w;
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM wand WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
    }


}
