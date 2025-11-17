package Views;

import Controllers.WizzardController;
import Models.Wizard;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WizardViewSwing extends JFrame {

    private WizzardController controller;
    private JTable table;
    private JTextField txtName, txtAge, txtId;
    private DefaultTableModel model;

    public WizardViewSwing() {
        controller = new WizzardController();
        setTitle("🏰 Hogwarts - Gestion de magos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        // Panel principal
        JPanel panel = new JPanel(new BorderLayout());
        add(panel);

        // Botones
        JButton btnAdd = new JButton("Agregar ➕");
        JButton btnEdit = new JButton("Editar ✏️");
        JButton btnDelete = new JButton("Eliminar ❌");
        JButton btnRefresh = new JButton("Actualizar 🔄️");

        JPanel inputPanel = new JPanel(); // Panel para los botones por encima del panel principal


        panel.add(inputPanel, BorderLayout.SOUTH);

        // Tabla para magos
        model = new DefaultTableModel(new String[] {"ID", "Nombre", "Edad"},0);
        table = new JTable(model);
        panel.add(table);

        inputPanel.add(new JLabel("ID:"));
        txtId = new JTextField(5);
        inputPanel.add(txtId);
        inputPanel.add(new JLabel("Nombre:"));
        txtName = new JTextField(10);
        inputPanel.add(txtName);
        inputPanel.add(new JLabel("Edad:"));
        txtAge = new JTextField(5);
        inputPanel.add(txtAge);

        inputPanel.add(btnAdd);
        inputPanel.add(btnEdit);
        inputPanel.add(btnDelete);
        inputPanel.add(btnRefresh);


        // Eventos botones

        btnAdd.addActionListener(e -> {
            String name = txtName.getText().trim();
            int age = Integer.parseInt(txtAge.getText().trim());
            controller.addWizzard(name,age);

            try {
                loadData();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

        btnDelete.addActionListener(e -> {
            int id = Integer.parseInt(txtId.getText().trim());
            controller.deleteWizzard(id);
            try {
                loadData();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

        btnRefresh.addActionListener(e -> {
            try {
                loadData();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

        btnEdit.addActionListener(e -> {
            int id = Integer.parseInt(txtId.getText().trim());
            String name = txtName.getText().trim();
            int age = Integer.parseInt(txtAge.getText().trim());
            controller.updateWizzard(id, name, age);
            try {
                loadData();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });


        try {
            loadData();
        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    private void loadData() throws SQLException {
        model.setRowCount(0);
        List<Wizard> wizards = controller.listWizzardSwing();
        if (wizards != null){
            for (Wizard w : wizards){
                model.addRow(new Object[]{w.getId(),w.getName(),w.getAge()});
            }
        }

    }
}
