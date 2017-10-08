package ru.ncedu.java.tasks;
import java.util.*;

public class ArrayVectorImpl implements ArrayVector {
	
	public static void main(String[] args){
		//double elements[] = new double[]{1,2,3,4,5};
		//ArrayVectorImpl vec = new ArrayVectorImpl();
		//vec.set(1,2.4,3.9,4,5.0);
		//int l = vec.getSize();
		//System.out.println(l);
		//vec.set(8,8);
		
		
		
		
	}
    double[] array;
    public ArrayVectorImpl() {
	}
	@Override
	public void set(double... elements) {
		if(elements.length==0){
			System.out.println("Error1");
		}
		else{
			//double[] array = new double[elements.length];
			array = new double[elements.length];
			for(int i=0;i< elements.length; i++){
				array[i] = elements[i];
			}
			
		}
		
		
	}

	@Override
	public double[] get() {
		return array;
	}

	@Override
	public ArrayVector clone() {
		
		ArrayVectorImpl tmp = new ArrayVectorImpl();
		tmp.array = array.clone();
		return tmp;
	}

	@Override
	public int getSize() {
		return array.length;
	}

	@Override
	public void set(int index, double value) {
		if (index >= 0){ 
			if(index < array.length) 
				array[index] = value; 
			else{ 
			double[] D = new double[index+1]; 
			for (int i = 0; i < array.length; i++){ 
			D[i] = array[i]; 
			} 
			D[index] = value; 
			array = new double[index+1]; 
			this.set(D);} 

			}
	}

	@Override
	public double get(int index) throws ArrayIndexOutOfBoundsException {
		 	
		    if (index>=array.length) {
		       throw new ArrayIndexOutOfBoundsException("Array Index Out of Bounds");
		    }
		    else 
		return array[index];
	}

	@Override
	public double getMax() {
		double Max = -32768;
		for (int i = 0; i< array.length; i++) {
			if(array[i]>Max) {
				Max = array[i];
			}
		}
		return Max;
	}

	@Override
	public double getMin() {
		double Min = 32767;
		for (int i = 0; i< array.length; i++) {
			if(array[i]<Min) {
				Min = array[i];
			}
		}
		return Min;
	}

	@Override
	public void sortAscending() {
		Arrays.sort(array);
		
	}

	@Override
	public void mult(double factor) {
		for (int i = 0; i< array.length; i++) {
			array[i]=array[i]*factor;
		}
		
	}

	@Override
	public ArrayVector sum(ArrayVector anotherVector) {
		double[] tmp = anotherVector.get();
		if(array.length>= anotherVector.getSize()) {
			for(int i = 0; i< tmp.length; i++) {
				array[i]=array[i]+ tmp[i];
			}
		}
		else {
			for(int i = 0; i< array.length; i++) {
				array[i]=array[i]+ tmp[i];
			}
		}
		
		ArrayVectorImpl temp = new ArrayVectorImpl();
		temp.array = array.clone();
		return temp;
	}

	@Override
	public double scalarMult(ArrayVector anotherVector) {
		double[] tmp = anotherVector.get();
		double S =0;
		if(array.length>= anotherVector.getSize()) {
			for(int i = 0; i< tmp.length; i++) {
				S = S+array[i]* tmp[i];
				
			}
		}
		else {
			for(int i = 0; i< array.length; i++) {
				S = S+array[i]+ tmp[i];
			}
		}
		
		return S;
	}

	@Override
	public double getNorm() {
		double S =0;
		for(int i = 0; i< array.length; i++) {
			S = S+array[i]* array[i];
			
		}
		return Math.sqrt(S);
	}

}
