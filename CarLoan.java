public class CarLoan{
  double carLoan;
  double loanLength;
  double interestRate;
  double downPayment;
    

  public CarLoan(double loanP, double lengthP, double interestP, double downPaymentP){
    carLoan = loanP;
    loanLength = lengthP;
    interestRate = interestP;
    downPayment = downPaymentP;

  }



  public static boolean checkLoan(double loan){
    if (loan > 0){
      return true;
    } else {
      System.err.println("Yikes man");
      System.out.println(loan);
      return false;
    }
  }

  public static boolean checkLoanLength(double loan){
    if (loan > 0){
      return true;
    } else {
      System.err.println("Yikers man");
      System.out.println(loan);
      return false;
    }
  }

  public static boolean checkDownPayment(double loan, double DownPay){
    if (DownPay < loan){
      return true;
    } else {
      System.err.println("lmao sure we'll take your money");
      return false;
    }
  }  

  public double findMonthlyPayment(){
   
    double monthlyBalance = (carLoan-downPayment)/(loanLength*12);
    double interest = monthlyBalance*interestRate/100;

    return monthlyBalance + interest;
  }

  public static void calculate(CarLoan loan){
    if(checkLoan(loan.carLoan)&&checkLoanLength(loan.loanLength)&&checkDownPayment(loan.carLoan, loan.downPayment)){

      System.out.println("Successful Loan!!");
      System.out.println("Your monthly payment is " +  loan.findMonthlyPayment());
    }
  }

  public static void main(String[] args){
    CarLoan Chevy = new CarLoan(10000, 3, 5, 2000);
    calculate(Chevy);

  }



}