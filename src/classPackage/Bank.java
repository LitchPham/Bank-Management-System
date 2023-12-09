package classPackage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class Bank {
  private static Scanner keyboard = new Scanner(System.in);
  ArrayList<Account> list = new ArrayList<>();
  public void create_new_acc() {
    System.out.println("Enter your username: ");
    String userName = keyboard.nextLine();
    System.out.println("Enter a new account number: ");
    int accountNumber = keyboard.nextInt();
    System.out.println("Enter your pin number: ");
    String pin = keyboard.next();
    System.out.println("Enter your initial deposit: ");
    double amount = keyboard.nextInt();
    Account newAcc = new Account(userName,accountNumber,pin,amount);
    list.add(newAcc);
  }

  public void deposit_money() {
    System.out.println("Enter your account number.");
    int accNumber = keyboard.nextInt();
    System.out.println("Enter your pin number.");
    String pin = keyboard.next();
    System.out.println("Enter the amount you want to deposit: ");
    double amount = keyboard.nextDouble();
    int counter = -1;
    for(int index = 0; index<list.size();index++){
      if(list.get(index).getAccNumber() == accNumber && list.get(index).getPin().equals(pin)){
        list.get(index).setAmount(list.get(index).getAmount() +  amount);
        counter = index;
      }
    }
    if(counter == -1){
      System.out.println("Account not found!");
    }
  }

  public void withdraw_money() {
    System.out.println("Enter your account number.");
    int accNumber =  keyboard.nextInt();
    System.out.println("Enter your pin number.");
    String pin = keyboard.next();
    System.out.println("Enter the amount you want to withdraw: ");
    double amount = keyboard.nextDouble();
    int counter = -1;
    for(int index  =0; index<list.size();index++){
      if(list.get(index).getAccNumber() == accNumber && list.get(index).getPin().equals(pin)){
        list.get(index).setAmount(list.get(index).getAmount()-amount);
        counter = index;
      }
    }
    if(counter == -1){
      System.out.println("Account not found!");
    }
  }

  public void transfer_money() {
    System.out.println("Enter the sender account number.");
    int s_acc = keyboard.nextInt();
    System.out.println("Enter the sender pin number.");
    String s_pin = keyboard.next();
    System.out.println("Enter the amount for transferring.");
    double s_amount = keyboard.nextDouble();

    int s_counter = -1;
    for(int index = 0; index<list.size();index++){
      if(list.get(index).getAccNumber() == s_acc && list.get(index).getPin().equals(s_pin)){
        s_counter = index;
      }
    }
    if(s_counter == -1){
      System.out.println("Account not found!");
    }
    System.out.println("Enter the reciever account number.");
    int r_acc = keyboard.nextInt();
    int r_counter = 1;
    for(int index = 0;index<list.size();index++){
      if(list.get(index).getAccNumber() == r_acc){
        r_counter = index;
      }
    }
    if(r_counter == -1){
      System.out.println("Account not found!");
    }
    
    if(list.get(s_counter).getAmount()> s_amount){
      list.get(s_counter).setAmount(list.get(s_counter).getAmount()-s_amount);
      list.get(r_counter).setAmount(list.get(r_counter).getAmount() + s_amount);
    }
  }

  public void print_acc() {
    for (int i = 0; i < list.size(); i++)
	  {
      System.out.println("\nName: " + list.get(i).getName());
      System.out.println("Account number: " + list.get(i).getAccNumber());
      System.out.println("Balance " + list.get(i).getAmount());
	  }
  }

  public void load() {
    try{
      FileInputStream fis = new FileInputStream("BankRecord.txt");
      ObjectInputStream in = new ObjectInputStream(fis);
      while (true) {
        Account temp = (Account) in.readObject();
        if(temp == null){
          break;
        }
        list.add(temp);       
      }
      fis.close();
    }catch(Exception e){
    }
  }
  public void save() {
    try{
      FileOutputStream fos = new FileOutputStream("BankRecord.txt");
      ObjectOutputStream out = new ObjectOutputStream(fos);
      for(int index = 0; index<list.size();index++){
        out.writeObject(list.get(index));
      }
      fos.close();
    }catch(Exception e){
    }
  }
  
}
