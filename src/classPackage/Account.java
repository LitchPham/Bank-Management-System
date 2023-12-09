package classPackage;

public class Account {
  private String name;
  private int accNumber;
  private String pin;
  private double amount;

  public Account(){
    name = " ";
    pin = " ";
    accNumber = 0;
    amount = 1000;
  }
  public Account(String name, int accNumber, String pin, double amount){
    this.name = name;
    this.accNumber = accNumber;
    this.pin = pin;
    this.amount = amount;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getAccNumber() {
    return accNumber;
  }
  public void setAccNumber(int accNumber) {
    this.accNumber = accNumber;
  }
  public String getPin() {
    return pin;
  }
  public void setPin(String pin) {
    this.pin = pin;
  }
  public double getAmount() {
    return amount;
  }
  public void setAmount(double amount) {
    this.amount = amount;
  }

  
}
