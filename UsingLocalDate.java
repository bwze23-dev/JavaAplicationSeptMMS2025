import java.time.LocalDate;

public class UsingLocalDate{
	public static void main(String[] args){
		LocalDate todaysDate = LocalDate.now();
		LocalDate mybirthDate = LocalDate.of(2000,06,25);
		LocalDate resumptionDate = LocalDate.parse("2028-10-15");
		
		boolean isleapYear = resumptionDate.isleapYear();
		boolean isEqual = resumptionDate.equals(mybirthDate);
		
		System.out.printf("Today's date is %s%n",todaysDate);
		System.out.printf("My birth date is %s%n",mybirthDate);
		System.out.printf("The resumption Date is %s%n",resumptionDate);
		System.out.printf("Resumption year is %s%n",resumptionDate.getYear());
		System.out.printf("Resumption month is %s%n",resumptionDate.getMonth());
		System.out.printf("Resumption day is %s%n",resumptionDate.getDayOfMonth());
		System.out.printf("The resumption date is %s%n",resumptionDate.plusDays(10));
		System.out.printf("The party date will be %s%n",resumptionDate.plusMonths(5));
		System.out.printf("Resumption date is a leap year? %b%n",isleapYear);
		System.out.printf(" is %s%n",resumptionDate.mybirthDate,isEqual);
	}
}