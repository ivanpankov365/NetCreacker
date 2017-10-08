package ru.ncedu.java.tasks;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.lang.System.*;

public class WordCounterImpl implements WordCounter{
	
	private String Text =  new String();
	

	@Override
	public void setText(String text) {
		this.Text = text;		
	}
	

	@Override
	public String getText() {
		if(this.Text.isEmpty()) {
			return null;
		}
		return this.Text;
	}

	@Override
	public Map<String, Long> getWordCounts() throws IllegalStateException {
		
		if(Text == null) {
			throw new IllegalStateException("CV not Seted");
		}
		
		TreeMap<String, Long> list = new TreeMap<String, Long>();
		
		String regex = "(\\s+)?\\S+(\\s*)?";
		Pattern p = Pattern.compile(regex);
	    Matcher m = p.matcher(this.Text);
	    while(m.find()) {
	    	String word = m.group();
	    	
	    	
	    	word = word.toLowerCase().trim();
	    	if(list.containsKey(word)) {
	    		Long v = list.get(word) ;
	    		
	    		//Long tmp = (Long)v;
	    		
	    		list.remove(word);
	    		list.put(word, v+1);
	    	}
	    	else {
	    		list.put(word,(long) 1);
	    	}
	    	
	    	//out.println(word);
	    }
		
		
		return list;
	}

	@Override
	public List<Entry<String, Long>> getWordCountsSorted() throws IllegalStateException {
		if(Text == null) {
			throw new IllegalStateException("CV not Seted");
		}
		
		List<Entry<String, Long>> list = new LinkedList<Entry<String, Long>>();
		
		Map<String, Long> hash = new TreeMap<String, Long>();
		hash = this.getWordCounts();
		
		for (Entry<String, Long> entry: hash.entrySet()) {
			//String tmp = entry.getKey();
			//Long TMP = entry.getValue();
			list.add(entry);
			
		}
		
		
		return list;
	}

	@Override
	public List<Entry<String, Long>> sortWordCounts(Map<String, Long> orig) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
		WordCounterImpl Text = new WordCounterImpl();
		Scanner in = new Scanner(System.in);
		String text = in.nextLine();
		Text.setText(text);
		Map list = new HashMap< String, Long>();
		
		list = Text.getWordCounts();
		out.println(list);
		
		List<Entry<String, Long>> list1 = new LinkedList<Entry<String, Long>>();
		list1 = Text.getWordCountsSorted();
		out.println(list1);
		
		
	}

}
