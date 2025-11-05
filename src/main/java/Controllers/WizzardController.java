package Controllers;

import Models.Wizard;
import Models.WizardDAO;

import java.sql.SQLException;

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


}
