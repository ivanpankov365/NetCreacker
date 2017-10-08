package com.netcracker.edu.java.tasks;
import java.util.*;

import java.lang.reflect.Array;

public class ComplexNumberImpl implements  ComplexNumber{
	public static void main(String[] args) {
		
		/*ComplexNumberImpl numb = new ComplexNumberImpl();
		ComplexNumberImpl tmp = new ComplexNumberImpl();
		numb.set("6-10i");
		tmp.set("8-6i");
		
		System.out.println(numb.getRe() + " "+ numb.getIm() + "i");
		System.out.println(tmp.getRe() + " "+ tmp.getIm() + "i");
		
		
		numb.multiply(tmp);
		System.out.println(numb.getRe() + " "+ numb.getIm() + "i");*/
		
		

	}
	
	double Re;
	double Im;
	
	public ComplexNumberImpl() {
		
	}

	@Override
	public double getRe() {
		return Re;
	}

	@Override
	public double getIm() {
		return Im;
	}

	@Override
	public boolean isReal() {
		if (Im==0) {
			return true;
		}
		else
		return false;
	}

	@Override
	public void set(double re, double im) {
		Re = re;
		Im = im;		
	}

	@Override
	public void set(String value) throws NumberFormatException {
		if (value.indexOf('i') != -1){ 
			if (Math.max(value.lastIndexOf('+'), value.lastIndexOf('-')) > 0){ 
			Re = Double.valueOf(value.substring(0, Math.max(value.lastIndexOf('+'), value.lastIndexOf('-')))); 
			if (value.substring(Math.max(value.lastIndexOf('+'), value.lastIndexOf('-'))).length() < 3) { 
			String s = value.replace('i', '1'); 
			Im = Double.valueOf(s.substring(Math.max(value.lastIndexOf('+'), value.lastIndexOf('-')))); 
			} else { 
			Im = Double.valueOf(value.substring(Math.max(value.lastIndexOf('+'), value.lastIndexOf('-')), value.length()-1)); 
			} 
			} else if (Math.max(value.lastIndexOf('+'), value.lastIndexOf('-')) == 0){ 
			Re = 0; 
			if (value.length() < 3) { 
			Im = Double.valueOf(value.replace('i', '1')); 
			} else { 
			Im = Double.valueOf(value.substring(0, value.length()-1)); 
			} 
			} else if (Math.max(value.lastIndexOf('+'), value.lastIndexOf('-')) < 0) { 
			Re = 0; 
			if (value.length() < 2) { 
			Im = Double.valueOf(value.replace('i', '1')); 
			} else { 
			Im = Double.valueOf(value.substring(0, value.length()-1)); 
			} 
			} 
			} else { 
			Re = Double.valueOf(value); 
			Im = 0; 
			} 
		
	}

	@Override
	public ComplexNumber copy() {
		ComplexNumberImpl tmp = new ComplexNumberImpl();
		tmp.Re = Re;
		tmp.Im = Im;
	   	return tmp;
	}

	@Override
	public ComplexNumber clone() throws CloneNotSupportedException {
		ComplexNumberImpl tmp = new ComplexNumberImpl();
		tmp.Re = Re;
		tmp.Im = Im;
	   	return tmp;
		//return (ComplexNumber) clone();
	}
	
	@Override
	public	String toString() {
		
		if(Re != 0) {
			if(Im != 0) {
			if(Im > 0) return String.valueOf(Re) + "+" + String.valueOf(Im) + "i";
			else return String.valueOf(Re)  + String.valueOf(Im) + "i";
			}
			else {
				return String.valueOf(Re);
			}
		}
		else if(Im != 0) {
			return String.valueOf(Im) + "i";
		}
		else return String.valueOf(Re) + "+" + String.valueOf(Im) + "i";
		
	}
	
	@Override
	public	boolean equals(Object other) {
		
		if (other instanceof ComplexNumber){ 
			if (((ComplexNumber)other).getRe() == Re && ((ComplexNumber)other).getIm() == Im){ 
			return true; 
			} else { 
			return false; 
			} 
			} else { 
			return false; 
			} 
	}
	
	@Override
	public int compareTo(ComplexNumber other) {
		double Y = Math.pow(other.getRe(), 2) + Math.pow(other.getIm(), 2);
		double X = Math.pow(Re, 2) + Math.pow(Im, 2);
		if(X<Y) return -1;
		else if(X>Y) return 1;
		else return 0;
	}

	@Override
	public void sort(ComplexNumber[] array) {
		Arrays.sort(array, new Comparator<ComplexNumber>() {
		        public int compare(ComplexNumber o1, ComplexNumber o2) {
		                return o1.compareTo(o2);
		        }
		});
		
	}

	@Override
	public ComplexNumber negate() {
		//ComplexNumberImpl tmp = new ComplexNumberImpl();
		Re = -Re;
		Im = - Im;		
		return this;
	}

	@Override
	public ComplexNumber add(ComplexNumber arg2) {
		Re = arg2.getRe()+Re;
		Im =  arg2.getIm()+Im;		
		return this;
	}

	@Override
	public ComplexNumber multiply(ComplexNumber arg2) {
		double TmpRe = Re*arg2.getRe()-Im*arg2.getIm();
		double TmpIm =  Re*arg2.getIm()+Im*arg2.getRe();
		Re = TmpRe;
		Im = TmpIm;
		return this;
	}

}


class Helper {
	double reH;
	double imH;
	boolean flagIm = true;
	boolean flagRe = true;
	
	public int help(char sign, String value) {
		int l = value.length();
		if(     (sign=='-' || sign=='+')&&
				value.charAt(1)!='0'&&value.charAt(1)!='1'
				&&value.charAt(1)!='2'&&value.charAt(1)!='3'
				&&value.charAt(1)!='4'&&value.charAt(1)!='5'
				&&value.charAt(1)!='6'&&value.charAt(1)!='7'
				&&value.charAt(1)!='8'&&value.charAt(1)!='9'
				&&value.charAt(1)!='i'&&value.charAt(1)!='.') {
			throw new NumberFormatException("Error Number Format");
		}
		else {
			int iter = 0, j=0;
			if(j == l-1) {
				reH = Double.parseDouble(value);
				return 0;
			}
			while((value.charAt(j+1)!= '+'&&value.charAt(j+1)!= '-'&&value.charAt(j+1)!= 'i')&&j<l) {
				j++;
				if(j == l-1) {
					reH = Double.parseDouble(value);
					return 0;
				}
			}
			if(j<l&&value.charAt(j+1)=='-') {
				if(sign == '-') {
					flagIm = false;
					String RE = value.substring(iter+1, j+1);
					if(sign == '-') reH = -Double.parseDouble(RE);
				}
				if(sign == '+') {
					flagIm = false;
					String RE = value.substring(iter+1, j+1);
					if(sign == '+') reH = Double.parseDouble(RE);
				}
				else {
					flagIm = false;
					String RE = value.substring(iter, j+1);
					reH = Double.parseDouble(RE);
				}
			}
			if(j<l&&value.charAt(j+1)=='+') {
				if(sign == '-') {
					flagIm = true;
					String RE = value.substring(iter+1, j+1);
					if(sign == '-') reH = -Double.parseDouble(RE);
				}
				if(sign == '+') {
					flagIm = true;
					String RE = value.substring(iter+1, j+1);
					if(sign == '+') reH = Double.parseDouble(RE);
				}
				else {
					flagIm = true;
					String RE = value.substring(iter, j+1);
					reH = Double.parseDouble(RE);
				}
			}
			if(j<l&&value.charAt(j+1)=='i') {
				if(sign == '-') {
					flagIm = false;
					String IM = value.substring(iter+1, j+1);
					if(IM.isEmpty()) IM = "1";
					imH = -Double.parseDouble(IM);
					if(j+1!=l-1) {
						throw new NumberFormatException("Error Number Format");
					}
					else {
						return 0;
					}
				}
				else if(sign == '+') {
					flagIm = true;
					String IM = value.substring(iter+1, j+1);
					if(IM.isEmpty()) IM = "1";
					imH = Double.parseDouble(IM);
					if(j+1!=l-1) {
						throw new NumberFormatException("Error Number Format");
					}
					else {
						j++;
					}
				}
				else {
						flagIm = true;
						String IM = value.substring(iter+1, j+1);
						if(IM.isEmpty()) IM = "1";
						imH = Double.parseDouble(IM);
						if(j+1!=l-1) {
							throw new NumberFormatException("Error Number Format");
						}
						else {
							j++;
						}
					
				}
					
			}
			if(j==l) {
				String RE = value.substring(iter+1, j+1);
				
				if(sign == '-') reH = -Double.parseDouble(RE);
				else reH = Double.parseDouble(RE);
				
			}
			else {
				iter = j+1;
				j++;
				while((value.charAt(j+1)!= '+'&&value.charAt(j+1)!= '-'&&value.charAt(j+1)!= 'i')&&j<l) {
					j++;
					if(j == l-1) {
						throw new NumberFormatException("Error Number Format");
					}
				}
				if(j<l&&value.charAt(j+1)=='i') {
					String IM = value.substring(iter+1, j+1);
					if(IM.isEmpty()) IM = "1";
					if(flagIm == true)imH = Double.parseDouble(IM);
					else imH = -Double.parseDouble(IM);
					if(j+1!=l-1) {
						throw new NumberFormatException("Error Number Format");
					}
					else {
						return 0;
					}
				}
			}
		}
		
		return 0;
	}
	
	
	
	public double getRe() {
		return reH;
	}
	
	
	public double getIm() {
		return imH;
	}
}