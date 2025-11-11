package Views;

import Controllers.WizzardController;

import java.util.Scanner;

public class WizardView {

    private final WizzardController controller;
    private final Scanner sc;

    public WizardView(){
        controller = new WizzardController();
        sc = new Scanner(System.in);
    }

    public void showMenu(){
        int opcion;
        do{
            System.out.println("\n **** 🪄Bienvenido a Hogwarts🪄 ****");
            System.out.println("1. Listar magos");
            System.out.println("2. Agregar mago");
            System.out.println("3. Actualizar mago");
            System.out.println("4. Eliminar mago");
            System.out.println("0. Salir");
            System.out.println("Elige una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();
            switch(opcion){
                case 1 -> controller.listWizzards();
                case 2 -> addWizzard();
                case 3 -> updateWizzard();
                case 4 -> deletWizzard();
                case 0 -> System.out.println("👋👋");
                default -> System.out.println("❌ esa opcion no es valida");
            }

        }while (opcion != 0);
    }

    private void addWizzard(){
        System.out.println("Nombre: ");
        String name = sc.nextLine();
        System.out.println("Edad: ");
        int age = sc.nextInt();
        System.out.println("ID casa: ");
        int houseId = sc.nextInt();
        System.out.println("ID varita: ");
        int wandId = sc.nextInt();
        controller.addWizzard(name, age, houseId, wandId);

    }

    private void updateWizzard(){
        System.out.println("ID del mago a actualizar: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Nuevo nombre: ");
        String name = sc.nextLine();
        System.out.println("Nueva edad: ");
        int age = sc.nextInt();
        System.out.println("Nuevo ID casa: ");
        int houseId = sc.nextInt();
        System.out.println("Nuevo ID varita: ");
        int wandId = sc.nextInt();
        controller.updateWizzard(id, name, age, houseId, wandId);

    }

    private void deletWizzard(){
        System.out.println("ID del mago a eliminar: ");
        int id = sc.nextInt();
        controller.deleteWizzard(id);

    }



}
