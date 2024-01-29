import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.lang.Math;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

abstract class Bank {               //abstract
    public abstract void bankName();
    Scanner input = new Scanner(System.in);
    public void checkType() {
        System.out.println("     Login or Create New Account");
        System.out.println("Press 1 --> Login\nPress 2 --> Create New Account");
        System.out.print("Enter here : ");
        int userInput = input.nextInt();
        if(userInput ==1) {
            LoginUser login1 = new LoginUser();
            login1.getInput();
        }
        else if(userInput ==2) {
            NewUser newU1 = new NewUser();
            newU1.getInput();
        }
        else {
            System.out.println("Press Valid Number");
        }
    }
}               
class CBCbank extends Bank {        //inheritance
    public void bankName() {
        System.out.println("    *****************************  ");
        System.out.println("         - - CBC Bank - -");
        System.out.println("Welcome to the CBC Online Banking App");
        System.out.println("*************************************");
        System.out.println("\n");
        System.out.println("*     *************************     *");
    }
}        
class User {
    protected String userName;
    public String testUserName;
    protected int userPassword;
    protected int randomAccNum;
    public void getInput(){}
    Scanner scn = new Scanner(System.in);
    protected int tempRandomAcc;
    public void delay(){        //delay function for modify UI
        try {
            System.out.print("  ."); Thread.sleep(200);
            System.out.print("   ."); Thread.sleep(300);
            System.out.print("   ."); Thread.sleep(100);
            System.out.print("   ."); Thread.sleep(75);
            System.out.print("   ."); Thread.sleep(125);
            System.out.print("   ."); Thread.sleep(500);
            System.out.print("   ."); Thread.sleep(100);
            System.out.print("   ."); Thread.sleep(400);
            System.out.print("   ."); Thread.sleep(200);
        }
        catch(InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public int randomAcc(){         //Generate random Account number
        randomAccNum = (int)(Math.random()*(9999-1000+1)+1000);
        return randomAccNum;
    }

}                       
class LoginUser extends User {

    public void getInput() {    //polymorphism
        System.out.println(" ");
        System.out.println("*     *************************     *");
        System.out.println("         - Login Details -");
        System.out.println("*          Saving Account           *");
        System.out.print("Enter User Name      : CBCS_");
        userName = scn.next();
        System.out.print("Enter 4 pin Password : ");
        userPassword = scn.nextInt();
        if(userPassword>=1000 && userPassword<=9999) {
            delay();
            System.out.println(" ");
            System.out.println("       - Login Successfully ! -");
            System.out.println("*     *************************     *");
            System.out.print("Press 5 --> To Access Your Account ");
            int input = scn.nextInt();
            if (input == 5) {
                delay();
                System.out.println(" ");
                Account acc1 = new Account();       //Create New Account
                acc1.showAccNum(userPassword);
                acc1.body();
            } else {
                System.out.println("Enter Valid Number");
                getInput();
            }
        }
        else {
            System.out.println("Enter Valid Pin Number");
            getInput();
        }
    }

}      
class NewUser extends User{
    public void getInput() {    //Polymorphism
        System.out.println(" ");
        System.out.println("*     *************************     *");
        System.out.println("         - Customer Details -");
        System.out.print("Enter Your Name      : ");
        userName = scn.next();
        System.out.print("Enter 4 pin Password : ");
        userPassword = scn.nextInt();
            if(userPassword>=1000 && userPassword<=9999){
                System.out.print("Press 5 --> Create New Account ");
                int in = scn.nextInt();
                if (in == 5) {
                    delay();
                    System.out.println("\n*     *************************     *");
                    System.out.println("Account created successfully !");
                    System.out.println(" ");
                    System.out.println("Your User Name    : CBCS_" + userName);
                    System.out.println("Your Account Type : Saving");
                    tempRandomAcc = randomAcc();
                    System.out.println("Your Account No   : xxxx xxxx xxxx " + tempRandomAcc);
                    System.out.print("Press 5 --> To Access Your Account ");
                    int input = scn.nextInt();
                    delay();
                    System.out.println(" ");
                    Account acc2 = new Account();
                    acc2.newUserBonus(tempRandomAcc);
                    acc2.body();
                } else {
                    System.out.println("Enter Valid Number");
                    getInput();
                }
            }
            else {
                System.out.println("Enter Valid Pin Number");
                getInput();
            }
    }
}         
class Account {
    Scanner in = new Scanner(System.in);
    private int accNum;
    private double balance;
    private int userChoice;
    private double amount;
    private int transAccNo;
    boolean end = false;
    public void newUserBonus(int accNo){
        this.accNum = accNo;
        System.out.println("\n");
        System.out.println("_________________________________________");
        System.out.println(" *       *************************       *");
        System.out.println("Saving Account Number : xxxx xxxx xxxx "+accNo);
        System.out.println(" *       *************************       *");
        System.out.println("\n   New User Bonus added to Your Account");
        balance = 1000;
    }
    public void showAccNum(int accNo){      //polymorphism
        this.accNum = accNo;
        System.out.println("\n");
        System.out.println("_________________________________________");
        System.out.println(" *       *************************       *");
        System.out.println("Saving Account Number : xxxx xxxx xxxx "+accNo);
        System.out.println(" *       *************************       *");
        balance = accNum + 1000;
    }
    public void body(){
        do{
            System.out.println("");
            System.out.println("Your Account Balance");
            System.out.println("\tRs. "+balance);
            System.out.println("````````````````````");
            System.out.println("Press 1 - Deposit money");
            System.out.println("Press 2 - Withdraw money");
            System.out.println("Press 3 - Money Transfer");
            System.out.print("Press Number (Press 0 to Exit) --> ");
            userChoice = in.nextInt();
            switch (userChoice) {
                case 1:
                    System.out.println("");
                    System.out.print("Amount to Deposit : Rs.");
                    amount = in.nextDouble();
                    if (amount <= 0) {
                        System.out.println("Can't deposit non-positive amount. Please Try again...");
                        System.out.println("*     *************************     *");
                    }
                    else {
                        balance = balance + amount;
                        System.out.println("Rs. " +amount+ " has been Deposited.");
                        System.out.println("*     *************************     *");
                    }
                    break;
                case 2 :
                    System.out.println("");
                    System.out.print("Amount to Withdraw : Rs.");
                    amount = in.nextDouble();
                    if (amount <= 0 || amount > balance) {
                        System.out.println("Sorry, Withdrawal can't be completed. Please Try again...");
                        System.out.println("*     *************************     *");
                    }
                    else {
                        balance = balance - amount;
                        System.out.println("Rs. " +amount+ " has been Withdrawn.");
                        System.out.println("*     *************************     *");
                    }
                    break;
                case 3 :
                    System.out.println("");
                    System.out.println("Money Transfer");
                    System.out.println("                           (Last 4 digit)");
                    System.out.print(  "Receiver's Account number : ");
                    transAccNo = in.nextInt();
                    System.out.print(  "Amount                    : Rs.");
                    amount = in.nextFloat();
                    if (amount <= 0 || amount > balance) {
                        System.out.println("Sorry, Payment can't be completed. Please Try again...");
                        System.out.println("*     *************************     *");
                    }
                    else {
                        balance = balance - amount;
                        System.out.println("Transfer Completed !");
                        System.out.println("*     *************************     *");
                    }
                    break;

                case 0:
                    end = true;
                    break;
                default:
                    System.out.println("Wrong choice.");
                    break;
            }
        }
        while (!end);
        {
            System.out.println("\n  Thank you for using our service !");
            System.out.println("*     *************************     *");
            FileW f1 = new FileW();
            f1.setAccDetails(balance, accNum);
            f1.createFile();
        }
    }
}                    
class FileW {       //File Handling
    private String uName;
    private int accNum;
    private double accBalance;
    public void setAccDetails(double accBalance, int accNum){
        this.accBalance = accBalance;
        this.accNum = accNum;
    }
    public void createFile(){
        try {
            File file = new File("UserInfo.txt");
            FileWriter myWriter = new FileWriter(file, true);
            PrintWriter pw = new PrintWriter(myWriter);
            System.out.println(" ");
            myWriter.write("Account Number  : xxxx xxxx xxxx ");
            pw.print(accNum);
            myWriter.write("\nAccount Balance : Rs. ");
            pw.print(accBalance);
            myWriter.write("\n\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}                     
public class Main {
    public static void main(String[] args) {
        CBCbank b1 = new CBCbank();
        b1.bankName(); b1.checkType();
    }
}
