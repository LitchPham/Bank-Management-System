package driverPackage;
import classPackage.*;
import java.util.Scanner;

public class Driver {
  private static Scanner keyboard = new Scanner(System.in);
  public static void main(String[] args) {
    Bank obj = new Bank();
    obj.load();
    try{
      System.out.println("********************Welcome to Our Bank********************");
      do{
        System.out.println("Please choose one of the option below.");
        String option[] = {"Create a new account.","Deposit Money","Withdraw money from existing accounts.","Transfer money.","Print all existing account"};

        int choice = 0;
        for(int i = 0; i<option.length;i++){
          System.out.printf("%d. %s\n",i+1,option[i]);
        }
        choice = keyboard.nextInt();
        switch(choice){
          case 1:
            obj.create_new_acc();
            break;
          case 2:
            obj.deposit_money();
            break;
          case 3:
            obj.withdraw_money();
            break;
          case 4:
            obj.transfer_money();
            break;
          case 5:
            obj.print_acc();
            break;
          case 6:
            obj.save();
            System.out.println("\nData saved to file \"BankRecord.txt\"");
            System.exit(1);
            break;
        }
      }while(true);
    }catch(Exception e){
      System.out.println(e);
    }
  }
}
