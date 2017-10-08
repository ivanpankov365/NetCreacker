package com.netcracker.edu.java.tasks;

import static java.lang.System.out;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.netcracker.edu.java.tasks.CurriculumVitae.Phone;


public class CurriculumVitaeImpl implements CurriculumVitae{
	
	public static final String PHONE_PATTERN = 
			"(\\(?([1-9][0-9]{2})\\)?[-. ]*)?([1-9][0-9]{2})[-. ]*(\\d{2})[-. ]*(\\d{2})(\\s*ext\\.?\\s*([0-9]+))?";
	public static final String AREA_INT_PATTERN = 
			"\\d{1,}";//
	public static final String AREA_PATTERN = 
			"(\\(?([1-9][0-9]{2})\\)?[-. ]*)";
	public static final String EXTENSION0_PATTERN = 
			"ext[0-9]+";
	public static final String EXTENSION1_PATTERN = 
			"ext.[0-9]+|ext [0-9]";

	
	private String CVtext =  new String();
	
	List<Helper> helpList = new LinkedList<Helper>();
	
	LinkedList<String> hideListXXXtext = new LinkedList<String>();
	LinkedList<String> hideListCodetext = new LinkedList<String>();
	
	LinkedList<String> hideListXXXphone = new LinkedList<String>();
	LinkedList<String> hideListCodephone = new LinkedList<String>();
	
	

	@Override
	public void setText(String text) {
		CVtext = text;
		hideListCodetext.clear();
		hideListXXXtext.clear();
		hideListCodephone.clear();
		hideListXXXphone.clear();
	}

	@Override
	public String getText() throws IllegalStateException {
		if(CVtext == null) {
			throw new IllegalStateException("CV not Seted");
		}
		return CVtext;
	}

	@Override
	public List<Phone> getPhones() throws IllegalStateException {
		if(CVtext == null){
			throw new IllegalStateException("CV not Seted");
		}
		
		
		
		
		List<Phone> phoneList = new LinkedList<Phone>();
		
		boolean areaFlag = false;
		boolean extFlag = false;
		int start = 0;
		int end = 0;
		
		int EXT = -1;
		int areaCode = -1;
		
		String phoneNumber = new String();
		Pattern p = Pattern.compile(PHONE_PATTERN);
	    Matcher m = p.matcher(this.CVtext);
	    while (m.find()) {
	    	start = m.start();
	    	end = m.end();
	    	String src = m.group(); //Result
	      out.println(src);
	    	
	    	//int count = src.replace("[^0-9]", "").length();
	    	
	    	//out.println(count);
	    	
	      	//  if(src.length()>=12) {
	      
	        	Pattern p_area = Pattern.compile(AREA_INT_PATTERN);
			    Matcher m_area = p_area.matcher(src);
			    Pattern p_area_int = Pattern.compile(AREA_PATTERN);
			    Matcher m_area_int = p_area_int.matcher(src);
			    
			    Pattern p_ext = Pattern.compile(EXTENSION0_PATTERN);
			    Matcher m_ext = p_ext.matcher(src);
			    
			    if(m_ext.find()) {
			    	String ext = m_ext.group();
			    	out.println(ext);
			    	src = src.substring(0, m_ext.start());
			    	EXT = Integer.parseInt(ext.substring(3));
			    	
			    }
			    
			    p_ext = Pattern.compile(EXTENSION1_PATTERN);
			    m_ext = p_ext.matcher(src);
			    
			    if(m_ext.find()) {
			    	String ext = m_ext.group();
			    	out.println(ext);
			    	src = src.substring(0, m_ext.start());
			    	EXT = Integer.parseInt(ext.substring(4));
			    }
			    
			    if (m_area.find()) {
			    	String src_area = m_area.group(); //Result
			        //out.println(src_area);
			    	if(m_area_int.find()) {
			    		String src_area_int = m_area_int.group();
			    		phoneNumber = src.substring(src_area_int.length());
			    	}
			    	else {
			    		phoneNumber = src.substring(src_area.length());
			    	}
			        areaCode = Integer.parseInt(src_area);
			       
			        
			        phoneList.add(new Phone(phoneNumber,areaCode,EXT)) ;
			        helpList.add(new Helper(start, end));
			        EXT = -1;
			        areaCode = -1;
			    }			    
			    
			    
	    //    }
	      //  else {
	     //   	phoneList.add(new Phone(src)) ;
	     //   }
	        
		    
	    }
	    
		
		
		
	    
		//System.out.println(phoneList);
		
		return phoneList;
	}

	@Override
	public String getFullName() throws NoSuchElementException, IllegalStateException {
		if(CVtext == null) {
			throw new IllegalStateException("CV not Seted");
		}
		
		String regexp = "[A-Z][a-z\\.]+ [A-Z][a-z\\.]+ [A-Z][a-z\\.]+|[A-Z][a-z\\.]+ [A-Z][a-z\\.]+";
		
		Pattern p = Pattern.compile(regexp);
	    Matcher m = p.matcher(this.CVtext);
	    if (m.find()) {
	    	String src = m.group(); //Result
	    	return src;
	    }
	   /* else {
	    	regexp = "[A-Z][a-z]+[a-z\\.] [A-Z][a-z]+[a-z\\.]";
	    	
	    	p = Pattern.compile(regexp);
		    m = p.matcher(this.CVtext);
		    if (m.find()) {
		    	String src = m.group(); //Result
		    	return src;
		    }
		    else {
		    	throw new NoSuchElementException();
		    }*/
	    //}
	    else {
	    	throw new NoSuchElementException();
	    }
	}

	@Override
	public String getFirstName() throws NoSuchElementException, IllegalStateException {
		if(CVtext == null) {
			throw new IllegalStateException("CV not Seted");
		}
	
		String FullName = this.getFullName();
		String regexp = "[A-Z][a-z\\.]+";
    	
		Pattern p = Pattern.compile(regexp);
	    Matcher m = p.matcher(FullName);
	    if (m.find()) {
	    	String FirstName = m.group(); //Result
	    	return FirstName;
	    }
	    else {
	    	throw new IllegalStateException();
	    }
		
	}

	@Override
	public String getMiddleName() throws NoSuchElementException, IllegalStateException {
		if(CVtext == null) {
			throw new IllegalStateException("CV not Seted");
		}
	
		String FullName = this.getFullName();
		
		String regexp3 = "[A-Z][a-z\\.]+ [A-Z][a-z\\.]+ [A-Z][a-z\\.]+";
		String regexp2 = "[A-Z][a-z\\.]+ [A-Z][a-z\\.]+";
		String regexp1 = "[A-Z][a-z\\.]+";
    	
		Pattern p = Pattern.compile(regexp3);
	    Matcher m = p.matcher(FullName);
	    if (m.find()) {
	    	String Name = m.group(); //Result
	    	
	    	p = Pattern.compile(regexp2);
		    m = p.matcher(FullName);
		    if(m.find()) {
		    	Name = m.group();
		    	
		    }
		    else {
		    	throw new IllegalStateException();
		    }
	    	
	    	p = Pattern.compile(regexp1);
		    m = p.matcher(FullName);
		    if(m.find()) {
		    	String FirstName = m.group();
		    	String MiddleName = Name.substring(m.end()+1);
		    	return MiddleName;
		    }
		    else {
		    	throw new IllegalStateException();
		    }
	    	
	    }
	    else {
	    	p = Pattern.compile(regexp2);
		    m = p.matcher(FullName);
		    if(m.find()) {
		    	return null;
		    }
		    else {
		    	throw new IllegalStateException();
		    }
		    
	    }
	}

	@Override
	public String getLastName() throws NoSuchElementException, IllegalStateException {
		if(CVtext == null) {
			throw new IllegalStateException("CV not Seted");
		}
	
		String FullName = this.getFullName();
		
		String regexp3 = "[A-Z][a-z\\.]+ [A-Z][a-z\\.]+ [A-Z][a-z\\.]+";
		String regexp2 = "[A-Z][a-z\\.]+ [A-Z][a-z\\.]+";
		String regexp1 = "[A-Z][a-z\\.]+";
    	
		Pattern p = Pattern.compile(regexp3);
	    Matcher m = p.matcher(FullName);
	    if (m.find()) {
	    	String Name = m.group(); //Result
	    	
	    	p = Pattern.compile(regexp2);
		    m = p.matcher(FullName);
		    if(m.find()) {
		    	String Name2 = m.group();
		    	String LastString = Name.substring(Name2.length()+1);
		    	return LastString;
		    	
		    }
		    else {
		    	throw new IllegalStateException();
		    }
	    	
	    }
	    else {
	    	p = Pattern.compile(regexp2);
		    m = p.matcher(FullName);
		    if(m.find()) {
		    	String Name = m.group();
		    	
		    	p = Pattern.compile(regexp1);
			    m = p.matcher(FullName);
			    if(m.find()) {
			    	String FirstName = m.group();
			    	String MiddleName = Name.substring(m.end()+1);
			    	return MiddleName;
			    }
			    else {
			    	throw new IllegalStateException();
			    }
			    
			    
		    }
		    else {
		    	throw new IllegalStateException();
		    }
		    
	    }
	}

	@Override
	public void updateLastName(String newLastName) throws NoSuchElementException, IllegalStateException {
		
		if(CVtext == null) {
			throw new IllegalStateException("CV not Seted");
		}
		
		//String replaceFirst(String replacement);
		
		String LastName = getLastName();
		
		Pattern p = Pattern.compile(LastName);
	    Matcher m = p.matcher(this.CVtext);
	    
	    if (m.find()) {
	    	this.CVtext = m.replaceFirst(newLastName);
	    }
	    else {
	    	throw new IllegalStateException();
	    }
		
		
	}

	@Override
	public void updatePhone(Phone oldPhone, Phone newPhone) throws IllegalArgumentException, IllegalStateException {
		if(oldPhone == null || newPhone == null) {
			throw new IllegalArgumentException();
		}
		if(CVtext == null) {
			throw new IllegalStateException("CV not Seted");
		}
		boolean flagEx = false;
		int start = 0;
		int end = 0;
		
		List<Phone> PhoneList = new LinkedList();
		PhoneList = getPhones();
		int count = 0;
		int co = 0;
		for(Iterator<Phone> iter = PhoneList.iterator();iter.hasNext();) {
			Phone phone = iter.next();
			if(phone.equals(oldPhone)) {
				flagEx = true;
				count++;
				
				for(Iterator<Helper> it = helpList.iterator();iter.hasNext();) {
					Helper help = it.next();
					co++;
					if (co==count) {
						start = help.getStart();
						end = help.getEnd();
						
						break;
					}
					
				}
				
				String FirstPart = CVtext.substring(0,start);
				String LastPart = CVtext.substring(end);
				String MiddlePart = newPhone.toString();
				CVtext =  FirstPart+MiddlePart+LastPart;
			}
			
		}
		if(!flagEx) {
			throw new IllegalArgumentException();
		}
		
	}

	@Override
	public void hide(String piece) throws IllegalArgumentException, IllegalStateException {
		
		if(CVtext == null) {
			throw new IllegalStateException("CV not Seted");
		}
		
		if(piece == null) {
			throw new IllegalStateException();
		}
		
		
		
		String XXXcode = new String();
		Pattern p = Pattern.compile(piece);
	    Matcher m = p.matcher(this.CVtext);
	    
	    if(m.find()) {
	    	String Code = m.group();
	    	hideListCodetext.add(Code);
	    	char[] CharCode;
	    	CharCode = Code.toCharArray();
	    	
	    	for(int i = 0; i< Code.length(); i++) {
	    		if(CharCode[i]!=' '&& CharCode[i]!='.'&& CharCode[i]!=','&& CharCode[i]!='@') {
	    			CharCode[i] = 'X';
	    		}
	    	}
	    	
	    	XXXcode = new String(CharCode);
	    	hideListXXXtext.add(XXXcode);
	    }
	    else {
	    	throw new IllegalArgumentException();
	    }
	    
	    
	    p = Pattern.compile(piece);
	    m = p.matcher(this.CVtext);
	    
	    if(m.find()) {
	    	CVtext = m.replaceFirst(XXXcode);
	    }
	   out.println(hideListCodetext);
	   out.println(hideListXXXtext);
	}

	@Override
	public void hidePhone(String phone) throws IllegalArgumentException, IllegalStateException {
		
		if(CVtext == null) {
			throw new IllegalStateException("CV not Seted");
		}
		if(phone == null) {
			throw new IllegalStateException();
		}
		
		char[] ArrPhone;
    	ArrPhone = phone.toCharArray();
    	
    	String ArrPhoneNext = phone;
    	
		int j = 0;
    	
    	for(int i = 0; i<phone.length();i++) {
    
    		if(ArrPhone[i]=='(') {
    			
    			ArrPhoneNext = ArrPhoneNext.substring(0, i+j) + "\\" + ArrPhoneNext.substring(i+j);
    			j = j+1;
    		}
    		
    		if(ArrPhone[i]==')') {
    			ArrPhoneNext = ArrPhoneNext.substring(0, i+j) + "\\" + ArrPhoneNext.substring(i+j);
    			j = j+1;
    		}
    		
    	}
    	
		
			
		String XXXcode = new String();
		
		Pattern p = Pattern.compile(ArrPhoneNext);
	    Matcher m = p.matcher(this.CVtext);
	    
	    if(m.find()) {
	    	String Phone = m.group();
	    	hideListCodephone.add(Phone);
	    	char[] CharPhone;
	    	CharPhone = Phone.toCharArray();
	    	
	    	for(int i = 0; i< Phone.length(); i++) {
	    		if(CharPhone[i]=='0'|| CharPhone[i]=='1'|| CharPhone[i]=='2'|| CharPhone[i]=='3'||CharPhone[i]=='4'|| CharPhone[i]=='5'|| CharPhone[i]=='6'|| CharPhone[i]=='7'||CharPhone[i]=='8'|| CharPhone[i]=='9') {
	    			CharPhone[i] = 'X';
	    		}
	    	}
	    	
	    	XXXcode = new String(CharPhone);
	    	hideListXXXphone.add(XXXcode);
	    }
	    else {
	    	throw new IllegalArgumentException();
	    }
	    
	    p = Pattern.compile(ArrPhoneNext);
	    m = p.matcher(this.CVtext);
	    
	    if(m.find()) {
	    	CVtext = m.replaceFirst(XXXcode);
	    }
	    
	   out.println(hideListCodephone);
	   out.println(hideListXXXphone);
		
	}

	@Override
	public int unhideAll() throws IllegalStateException {

		if(CVtext == null) {
			throw new IllegalStateException("CV not Seted");
		}
		int count = 0;
		for(Iterator<String> iter = hideListXXXtext.iterator();iter.hasNext();) {
			count++;
			String XXXCode = iter.next();
			Pattern p = Pattern.compile(XXXCode);
		    Matcher m = p.matcher(this.CVtext);
		    
		    if(m.find()) {
		    	String FirstPart = CVtext.substring(0, m.start());
		    	String LastPart = CVtext.substring(m.end());
		    	CVtext = FirstPart+ hideListCodetext.getFirst() + LastPart;
		    	hideListCodetext.removeFirst();
		    }
		    
		}
		
		for(Iterator<String> iter = hideListXXXphone.iterator();iter.hasNext();) {
			count++;
			String XXXCode = iter.next();
			
			
			char[] ArrPhone;
	    	ArrPhone = XXXCode.toCharArray();
	    	
	    	String ArrPhoneNext = XXXCode;
	    	
			int j = 0;
	    	
	    	for(int i = 0; i<XXXCode.length();i++) {
	    
	    		if(ArrPhone[i]=='(') {
	    			
	    			ArrPhoneNext = ArrPhoneNext.substring(0, i+j) + "\\" + ArrPhoneNext.substring(i+j);
	    			j = j+1;
	    		}
	    		
	    		if(ArrPhone[i]==')') {
	    			ArrPhoneNext = ArrPhoneNext.substring(0, i+j) + "\\" + ArrPhoneNext.substring(i+j);
	    			j = j+1;
	    		}
	    		
	    	} 
	    	
			Pattern p = Pattern.compile(ArrPhoneNext);
		    Matcher m = p.matcher(this.CVtext);
		    
		    if(m.find()) {
		    	String FirstPart = CVtext.substring(0, m.start());
		    	String LastPart = CVtext.substring(m.end());
		    	CVtext = FirstPart+ hideListCodephone.getFirst() + LastPart;
		    	hideListCodephone.removeFirst();
		    }
		    
		}
		
		return count;
	}

	
	
	public static void main(String[] args) {
		
		CurriculumVitaeImpl CV = new CurriculumVitaeImpl();
		Scanner in = new Scanner(System.in);
		String text = in.nextLine();
		CV.setText(text);
		//System.out.println(CV.getText());
		//CV.getPhones();
		//System.out.println(CV.getFullName());
		
		//System.out.println(CV.getFirstName());
		//System.out.println(CV.getMiddleName());
		//System.out.println(CV.getLastName());
		//CV.updateLastName("Petrov");
		//System.out.println(CV.getLastName());
		//System.out.println(CV.getFullName());
		
		List<Phone> PhoneList = new LinkedList();
	    PhoneList = CV.getPhones();
	    out.println(PhoneList);
		//Phone p1 = ((LinkedList<Phone>) PhoneList).getFirst();
		//Phone p2 = ((LinkedList<Phone>) PhoneList).getLast();
		//
		//System.out.println(p1);
		//System.out.println(p2);
		
		//CV.updatePhone(p1,p2);
		//System.out.println(CV.getText());
		
		CV.hide("Junior Talented Student");
		System.out.println(CV.getText());
		CV.hidePhone("(1234) 5678 90");
		System.out.println(CV.getText());
		out.println(CV.unhideAll());
		System.out.println(CV.getText());
		out.println(CV.unhideAll());
		
	}
	
	
	static class Helper{
		// List <Phone> helpList = new LinkedList();
		private int start = 0;
		private int end = 0;
		
		public Helper(int start, int end){
			this.start = start;
			this.end = end;
		}
		public Helper(){
			this.start = 0;
			this.end = 0;
		}
		
		void setStart(int start) {
			this.start = start;
		}
		void setEnd(int end) {
			this.end = end;
		}
		int getStart() {
			return start;
		}
		int getEnd() {
			return end;
		}
		
	}
	
}
