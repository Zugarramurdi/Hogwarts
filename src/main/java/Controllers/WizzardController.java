package Controllers;

import Models.Wizard;
import Models.WizardDAO;

import java.sql.SQLException;
import java.util.List;

public class WizzardController {

    private WizardDAO wizardDAO;

    public WizzardController(){
        wizardDAO = new WizardDAO();
    }

    public void addWizzard(String name,int age,int house_id,int wand_id){
        //comprobar permisos
        //comprobar parametros (Verificacion en servidor)
        //transacciones
        try{
            Wizard wizard = new Wizard(name,age,house_id,wand_id);
            wizardDAO.create(wizard);
            System.out.println("✅ Mago agregado correctamente");
        }catch(SQLException e){
            System.out.printf("❌ Error al agregar mago: "+e.getMessage());
        }
    }

    public void listWizzards(){
        try{
            List<Wizard> wizards = wizardDAO.getAll();
            if(wizards.isEmpty()){
                System.out.println("❗ No hay magos registados");
            }else{
                for (Wizard w : wizards) {
                    System.out.println(w);
                }
            }

        }catch (SQLException e){
            System.out.println("❌ Error al listar magos: "+e.getMessage());
        }

    }
    public List<Wizard> listWizzardSwing()throws SQLException{
        List<Wizard> wizards = wizardDAO.getAll();
        if(wizards.isEmpty()) {
            throw new SQLException();
        }else{
            return wizards;
        }
    }

    public void updateWizzard(int id, String name,int age,int house_id,int wand_id){
        try{
            Wizard wizard = new Wizard(name,age,house_id,wand_id);
            wizard.setId(id);
            wizardDAO.update(wizard);
            System.out.println("✅ Mago actualizado con exito 🪄");

        }catch(SQLException e){
            System.out.println("❌ Error al actualizar mago: "+e.getMessage());
        }
    }

    public void deleteWizzard(int id){
        try{
            wizardDAO.delete(id);
            System.out.println("✅ Mago eliminado con exito 🚮");

        }catch(SQLException e){
            System.out.println("❌ Error al eliminar mago: "+e.getMessage());
        }
    }


}
