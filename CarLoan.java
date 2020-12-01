//Programming 12 - Car Loan
/*
@Trevor Liu

@12/01/2020

Program summary
This program takes in 4 inputs. The car loan price, the length in years, monthly interest rate, and downpayment. 
It validates the loan, and calculates how much monthly is needed.
*/

public class CarLoan{
  //Global Variables
  double carLoan;
  double loanLength;
  double interestRate;
  double downPayment;
    

  public CarLoan(double loanP, double lengthP, double interestP, double downPaymentP){ //Constructor 
    carLoan = loanP;
    loanLength = lengthP;
    interestRate = interestP;
    downPayment = downPaymentP;
  } //End of constructor



  //checkLoan function
  //Returns a boolean
  //checks to see if the loan is valid
  public static boolean checkLoan(double loan){ 
    if (loan > 0){
      return true;
    } else {
      System.err.println("Yikes man");
      System.out.println(loan);
      return false;
    }//end of if/else
  }//end of checkLoan function



  //checkLoanLength function
  //Returns boolean
  //checks to see if loan length is valid 
  public static boolean checkLoanLength(double loan){
    if (loan > 0){
      return true;
    } else {
      System.err.println("Yikers man");
      System.out.println(loan);
      return false;
    }//end of if/else
  }//end of checkLoan function



  //checkDownPayment function
  //returns a boolean
  //checks to see if the downpayment is smaller than the loan
  public static boolean checkDownPayment(double loan, double DownPay){
    if (DownPay < loan){
      return true;
    } else {
      System.err.println("lmao sure we'll take your money");
      return false;
    }
  }  



  //findMonthlyPayment function
  //returns monthly payment
  //Calculates the monthly payment
  public double findMonthlyPayment(){
   
    double monthlyBalance = (carLoan-downPayment)/(loanLength*12); //finds monthly balance
    double interest = monthlyBalance*interestRate/100; //finds interest

    return monthlyBalance + interest; //returns the total
  }



  //calculate function
  //parameter {CarLoan Object} - Car to be loaned
  //checks to see if loan is valid, and finds monthly payment
  public static void calculate(CarLoan loan){

    if(checkLoan(loan.carLoan)&&checkLoanLength(loan.loanLength)&&checkDownPayment(loan.carLoan, loan.downPayment)){

      System.out.println("Successful Loan!!");
      System.out.println("Your monthly payment is " +  loan.findMonthlyPayment());
    }
  }

  //Main
  public static void main(String[] args){

    CarLoan Chevy = new CarLoan(10000, 3, 5, 2000);//Creates instance
    calculate(Chevy); //runs calculate function

  }
}