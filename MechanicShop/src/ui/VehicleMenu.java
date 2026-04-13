package ui;
import java.util.Scanner;
import database.VehicleDAO;

public class VehicleMenu {
    Scanner input = new Scanner(System.in);
    VehicleDAO dao = new VehicleDAO();

    public void start(){
        int choice=0;
        while(choice!=3){
            System.out.println("\n1 Add Vehicle");
            System.out.println("2 Show Vehicles");
            System.out.println("3 Exit");
            System.out.print("Choice: ");
            choice=input.nextInt();
            input.nextLine();
            if(choice==1){ add(); }
            else if(choice==2){ dao.showVehicles(); }
            else if(choice==3){ System.out.println("Bye"); }
            else { System.out.println("Wrong choice"); }
        }
    }

    private void add(){
        System.out.print("Id: "); int id=input.nextInt(); input.nextLine();
        System.out.print("Make: "); String make=input.nextLine();
        System.out.print("Model: "); String model=input.nextLine();
        dao.addVehicle(id,make,model);
    }
}