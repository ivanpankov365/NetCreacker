package ru.ncedu.java.tasks;

public class ControlFlowStatements3Impl implements ControlFlowStatements3{
	
	public static void main(String[] args){
		//ControlFlowStatements3Impl s = new ControlFlowStatements3Impl();
		//System.out.println("First\n");
		//System.out.println(s.getFunctionValue(-1));
		//System.out.println(s.getFunctionValue(1.5));
		//System.out.println(s.getFunctionValue(5));
		//System.out.println("Second\n");
		//System.out.println(s.decodeSeason(1));
		//System.out.println(s.decodeSeason(2));
		//System.out.println(s.decodeSeason(3));
		//System.out.println(s.decodeSeason(4));
		//System.out.println(s.decodeSeason(5));
		//System.out.println(s.decodeSeason(6));
		//System.out.println(s.decodeSeason(7));
		//System.out.println(s.decodeSeason(8));
		//System.out.println(s.decodeSeason(9));
		//System.out.println(s.decodeSeason(10));
		//System.out.println(s.decodeSeason(11));
		//System.out.println(s.decodeSeason(12));
		//System.out.println("Fird\n");
		//long a[][];
		//a = new long[8][5];
		//a = s.initArray();
		//System.out.println("Fourth\n");
		
		//System.out.println(s.getMaxProductIndex(a));
		//System.out.println("Fifth\n");
		//System.out.println(s.calculateLineSegment(10,3));
	}
	
	public ControlFlowStatements3Impl(){ 
		
	}

	@Override
	public double getFunctionValue(double x) {
		if(x<=0) return -x;
		else if(x<2) return Math.pow(x,2);
		else return 4;
	}

	@Override
	public String decodeSeason(int monthNumber) {
		String str = new String();
		switch(monthNumber){
		case(1) : {
			return str = "Winter";
		}
		case(2) : {
			return str = "Winter";
		}
		case(3) : {
			return str = "Spring";
		}
		case(4) : {
			return str = "Spring";
		}
		case(5) : {
			return str = "Spring";
		}
		case(6) : {
			return str = "Summer";
		}
		case(7) : {
			return str = "Summer";
		}
		case(8) : {
			return str = "Summer";
		}
		case(9) : {
			return str = "Autumn";
		}
		case(10) : {
			return str = "Autumn";
		}
		case(11) : {
			return str = "Autumn";
		}
		case(12) : {
			return str = "Winter";
		}
		default : {
			return str = "Error";
		}
		}
	}

	@Override
	public long[][] initArray() {
		long[][] array;
		array = new long[8][5];
		for(int i = 0; i<8; i++){
			for(int j = 0; j<5; j++){
				array[i][j] = (long) Math.pow((Math.abs(i-j)), 5);
			}
		}
		return array;
	}

	@Override
	public int getMaxProductIndex(long[][] array) {
		int n1 = array.length;
		int n2 = array[0].length;
		long P=0,tmp=1;
		int ind = 0;;
		for (int i = 0; i<n1; i++){
			tmp=1;
			for(int j = 0; j<n2; j++){
				tmp = tmp*array[i][j];
			}
			if(Math.abs(tmp) > P){
				P = Math.abs(tmp);
				ind = i;
			}
		}
		return ind;
	}

	@Override
	public float calculateLineSegment(float A, float B) {
		float s = A%B;
		return s;
	}

}

