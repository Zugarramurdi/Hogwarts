package Models;


import DataBase.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WizardDAO {

    private Connection conn;

    public WizardDAO() { conn = DBConnection.getConnection(); }

    public void create(Wizard wizard) throws SQLException {
        String sql = "INSERT INTO wizard (name, age, house_id, wand_id) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, wizard.getName());
        ps.setInt(2, wizard.getAge());
        ps.setInt(3, wizard.getHouseId());
        ps.setInt(4, wizard.getWandId());
        ps.executeUpdate();
        ps.close();
    }

    public List<Wizard> getAll() throws SQLException {
        List<Wizard> list = new ArrayList<>();
        Statement st = conn.createStatement();
        String sql = "SELECT * FROM wizard";
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            list.add(new Wizard(rs.getInt("id"),(rs.getString("name")),(rs.getInt("age")),(rs.getInt("house_id")),(rs.getInt("wand_id"))));

        }
        rs.close();
        st.close();
        return list;
    }

    public Wizard getById(int id) throws SQLException {
        String sql = "SELECT * FROM wizard WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        Wizard wiz = null;
        if (rs.next()) {
            wiz = new Wizard((rs.getInt("id")),(rs.getString("name")),(rs.getInt("age")),(rs.getInt("house_id")),(rs.getInt("wand_id")));
        }
        rs.close();
        ps.close();
        return wiz;
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM wizard WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
    }
}
