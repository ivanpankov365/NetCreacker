package ru.ncedu.java.tasks;

public class ControlFlowStatements1Impl implements ControlFlowStatements1 {
	
	public static void main(String[] args){
		ControlFlowStatements1Impl s = new ControlFlowStatements1Impl();
		
		int a[][];
		a = new int[8][5];
		a = s.initArray();
		
		s.getMinValue(a);
		
	}

	@Override
	public float getFunctionValue(float x) {
		if(x<=0) return 6-x;
		else return 2*(float)Math.sin(x);
	}

	@Override
	public String decodeWeekday(int weekday) {
		String str = new String();
		switch(weekday){
		case(1) : {
			return str = "Monday";
		}
		case(2) : {
			return str = "Tuesday";
		}
		case(3) : {
			return str = "Wednesday";
		}
		case(4) : {
			return str = "Thursday";
		}
		case(5) : {
			return str = "Friday";
		}
		case(6) : {
			return str = "Saturday";
		}
		case(7) : {
			return str = "Sunday";
		}
		default : {
			return str = "Error";
		}
		}
	}

	@Override
	public int[][] initArray() {
		int[][] array;
		array = new int[8][5];
		for(int i = 0; i<8; i++){
			for(int j = 0; j<5; j++){
				array[i][j] =  i*j;
			}
		}
		return array;
	}

	@Override
	public int getMinValue(int[][] array) {
		int n1 = array.length;
		int n2 = array[0].length;
		int min = 2147483647;
		for (int i = 0; i<n1; i++){
			for(int j = 0; j<n2; j++){
				if(array[i][j] < min){
					min = array[i][j];
				}
			
			}
		}
		return min;
	}

	@Override
	public BankDeposit calculateBankDeposit(double P) {
		
		BankDeposit a = new BankDeposit();
		double Sum = 1000;
		while(Sum <= 5000){
			Sum = Sum + Sum*P/100;
			a.years ++;
		}
		a.amount = Sum;
		return a;
	}

}

 class BankDeposit{
	/**
	 * Число полных лет, которые вклад пролежал в банке.
	 */
	public int years = 0;
	/**
	 * Размер вклада после {@link #years} лет.
	 */
	public double amount;

	@Override
	public String toString() {
		return years+" years: $"+amount;
	}
}