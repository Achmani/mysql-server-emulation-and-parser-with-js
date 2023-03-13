package id.mit.chrono.server.util;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

	public static String getPatternString(Object[] patterns){
		
		String or = "";
		for(int i=0; i<patterns.length; i++){
			
			if(!or.isEmpty()){
				or += "|";
			}
			
			or += "(%s)";
		}
		
		return String.format(or,patterns);
	}
	
	public static String removeDoubleSpace(String string){
		String result = string;
		
		while(result.indexOf("  ") != -1){
			result = result.replaceAll("  ", " ");
		}
		
		return result;
	}
	
	public static ArrayList<ArrayList<String>> getTabData(String[] header, String data){
		
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		
		String line;
		boolean found = false;
		int[] hPos = new int[header.length];
		int[] hLength = new int[header.length];
		
		try (BufferedReader br = new BufferedReader(new StringReader(data))) {
		    
			/* loop until found the header line */
			while ((line = br.readLine()) != null) {
				
				found = true;
				
		    	for (int i = 0; i < header.length; i++) {
					
		    		if(!line.matches(".*" + header[i] + ".*")){
						found = false;
						break;
					}
					
//					System.out.println("Found1: " + header[i]);
				}
		    	
		    	/* if found, then process the data */
		    	if(found){
		    		
		    		/* loop and find matches */
		    		for (int i = 0; i < header.length; i++) {
//		    			System.out.println("--\n"+line+"\n--\n");
//		    			System.out.println("check: " + header[i]);
		    			
						Pattern p = Pattern.compile(header[i] + "[ ]*"); // add space (as needed) in the end
						Matcher matcher = p.matcher(line);
						
						if(matcher.find()){
							hPos[i] = matcher.start(0);
							hLength[i] = matcher.group(0).length();
							
//							System.out.println("Found2: " + header[i] + ": " + matcher.group() + ": pos => " + hPos[i] + ", l => " + hLength[i]);
						}
						else{
//							System.out.println("Not Found2: " + header[i]);
						}
					}
		    		
		    		break;
		    	}
		    }
			
			/* read the data */
			while (found && (line = br.readLine()) != null) {
				
//				System.out.println("~+~+~+~+~+~" + line.length() + "+~+~+~+~~+");
//				System.out.println(line);
//				System.out.println("|||||||||||");

				/* skip too-short data */
				if(line.length()<hPos[hPos.length-1]){
					continue;
				}
				
//				System.out.println("~+~+~+~+~+~+~+~+~+~~+");
				
				ArrayList<String> item = new ArrayList<String>();
				
				for (int i = 0; i < hPos.length; i++) {
//					System.out.println("" + line.length() + "\t" + hPos[i] + "\t" + hLength[i]);
//					System.out.println(line.substring(hPos[i], hPos[i] + hLength[i]));

					if(i != (hPos.length-1)){

						item.add(line.substring(hPos[i], hPos[i] +hLength[i]));
					}
					else{

						item.add(line.substring(hPos[i]));
					}
				}

				result.add(item);
			}
		}
		catch(Exception e){}

		return result;
	}
}
