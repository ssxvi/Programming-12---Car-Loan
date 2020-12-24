//Programming 12 - Car Loan
/*
@Trevor Liu

@12/01/2020

Program summary
This program takes in 4 inputs. The car loan price, the length in years, monthly interest rate, and downpayment. 
It validates the loan, and calculates how much monthly is needed.


Elements used!
static variables
system.err.println
syste
*/

import java.util.Scanner;


public class CarLoan{
  //Global Variables
  double carLoan;
  double loanLength;
  double interestRate;
  double downPayment;

  //Temporary Variables
  static double carLoanT;
  static double loanLengthT;
  static double interestRateT;
  static double downPaymentT;
    

  //Constructor
  public CarLoan(double loanP, double lengthP, double interestP, double downPaymentP){  
    carLoan = loanP;
    loanLength = lengthP;
    interestRate = interestP;
    downPayment = downPaymentP;
  } //End of constructor




  //checkLoan function
  //Returns a boolean
  //checks to see if the loan is valid
  public static boolean checkLoan(double loan){ 
    if (loan > 0){ //Checks to see if input is greater than 0
      return true;
    } else {
      System.err.println("Yikes man");
      System.out.println(loan);
      return false;
    }//end of if/else
  }//end of checkLoan function



  

  //checkDownPayment function
  //returns a boolean
  //checks to see if the downpayment is smaller than the loan
  public static boolean checkDownPayment(double DownPay, double loan){
    if (DownPay < loan){ //Checks to see if input is greater than inital payment
      return true;
    } else {
      System.err.println("lmao sure we'll take your money, make sure downpayment is less than inital payment");
      return false;
    } //end of if/else
  }//end of checkDownPayment function







  //checkLoanLength function
  //Returns boolean
  //checks to see if loan length is valid 
  public static boolean checkLoanLength(double loan){
    if (loan > 0){ //Checks to see if input is greater than 0
      return true;
    } else {
      System.err.println("Yikers man that loan is too small");
      System.out.println(loan);
      return false;
    }//end of if/else
  }//end of checkLoan function



  //findMonthlyPayment function
  //returns monthly payment
  //Calculates the monthly payment
  public double findMonthlyPayment(){
   
    double monthlyBalance = (carLoan-downPayment)/(loanLength*12); //finds monthly balance
    double interest = (monthlyBalance*interestRate/100); //finds interest -> additional brackets aren't needed since all operators are * and /

    return monthlyBalance + interest; //returns the total
  }//end of findMonthlyPayment function





  //calculate function
  //parameter {CarLoan Object} - Car to be loaned
  //checks to see if loan is valid, and finds monthly payment
  //Summarizes users inputs
  public static void calculate(CarLoan loan){

    if(checkLoan(loan.carLoan)&&checkLoanLength(loan.loanLength)&&checkDownPayment(loan.downPayment, loan.carLoan)){
      //Confirmation
      System.out.println("Successful Loan!!");
      System.out.println("Your monthly payment is " +  loan.findMonthlyPayment() + " dollars!");
      System.out.println();

      //Exit UI
      System.out.println("Summary of your inputs!");
      System.out.println();
      System.out.println("Car Loan price: " + loan.carLoan);
      System.out.println();
      System.out.println("Car Loan length: " + loan.loanLength);
      System.out.println();
      System.out.println("Downpayment: " + loan.downPayment);
      System.out.println();
      System.out.println("Interest rate: " + loan.interestRate);
      System.out.println();
      System.out.println("Thank you for using our program!");
      System.out.println();
    } else {
      System.err.println("You broke something real fking back I changed this so you the inputs actually have to match so idk what you did buddy");
    }//End of if/else statement

  }//End of calculator







  //getUserNumber function
  /*
  Uses Scanner to get the user number and check to see if there is an error

  Returns
  userNumber {Double} - the number the user submitted
  */
  public static double getUserNumber(){

    Scanner testObj = new Scanner(System.in); //Creates new scanner object
    double userNumber = 0;
    do {

      try { //Will try to run code below

        userNumber = testObj.nextDouble(); //tries to assign the input as a double
      

        //User Message
        System.out.println();
        System.out.println("The number you put in was " + userNumber);

        //breaks out of try
        break;

      } catch (Exception e){ //if there is any error, this code runs instead

        System.err.println("Input Invalid! Try again!");
        System.out.println();

      } finally { //runs after catch

        testObj.nextLine(); //makes the scanner check the next line

      }//end of catch/try/finally

    } while (true);

    //testObj.close(); //closes the scanner - taking this out makes the program run idk why but it works so I'm not complaining

    return userNumber; //returns the number
  }//end of userNumber function







  //frontUI function
  /*
  Prints UI for the beginning the program
  */
  public static void frontUI(){

    System.out.println("Welcome your Carloan Calculator!");
    System.out.println();
    System.out.println("A Car loan has 4 components!");
    System.out.println("The total cost of the car, the loan length in years, the interest rate in percentage, and the downpayment!");
    System.out.println();

  
  } //end of frontUI function


  //getInput function
  //These do statements were originally part of one big function for abstraction with switch statements and cool datatypes but that took too long as was too tiring especially with how the scope worked so this is easier
  //Each one just adds an additional condition that will force the input to repeat if the condition isn't met, as well as assigning the temporary values the user input
  public static void getInput(){

    //car loan cost
    do {
      System.out.print("Input your car cost here! ");
      carLoanT = getUserNumber(); //assigns temporary value to use input


      //checks to make sure value is valid
      if (checkLoan(carLoanT)){ 
        System.out.println("Your car costs " + carLoanT + " dollars.");
        System.out.println();
        break;
      } //End of if

    } while(true);  //End of do-while
  


    //loan length
    do {
      System.out.print("Input your car loan length here! ");
      loanLengthT = getUserNumber();


      //checks to make sure value is valid
      if (checkLoan(loanLengthT)){  
        System.out.println("Your loan lasts " + loanLengthT + " years");
        System.out.println();
        break;
      } //End of if

    } while(true);  //End of do-while



    //Interest can be whatever people want it to be
    System.out.print("Input your interest rate here! ");
    interestRateT = getUserNumber();
    System.out.println("Your interest rate was " + interestRateT + "%");
    System.out.println();


    //Downpayment
    do {

      System.out.print("Input your downpayment here! ");
      downPaymentT = getUserNumber();

      //checks to make sure value is valid
      if (checkDownPayment(downPaymentT, carLoanT)){
        System.out.println("Your downpayment is " + downPaymentT + " dollars");
        System.out.println();
        break;
      } //End of if

    } while(true);  //End of do-while
    
  }//End of getInput funciton



  //Main
  public static void main(String[] args){

    //Beginning UI
    frontUI();

    //Gets user input
    getInput();

    //Creates instance
    CarLoan Car = new CarLoan(carLoanT, loanLengthT, interestRateT, downPaymentT);

    //runs calculate function + built-in exit UI
    calculate(Car); 

  } //end of the main


}//end of the class


/*
Notes
abstraction could be better but I made it work ok

this is not my best quality work I apologize I'm working on the next project which fancy jframe UI and almost completely forgot about this because I was deciding if I was going to use jframe for this


Test code!

CarLoan test = new CarLoan(10000, 3, 5, 2000);

checkDownPayment(2, 1); -> fails because loan is smaller than payment



*/