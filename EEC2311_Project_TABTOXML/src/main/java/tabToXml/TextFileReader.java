package tabToXml;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * This Class creates an object that has two String Lists, the original text  and the parsedTab text
 * @author Group15
 *
 */
public class TextFileReader {
	
	private File inputFile;
	static int numOfLines = 0;
	boolean isDrum;
	static String instrument;
	
	//Parsed text 
	public ArrayList<String> parsedTab = new ArrayList<String>();
	
	//Original text 
	private ArrayList<String> originalTab = new ArrayList<String>();

	//Read in the file
	public TextFileReader(String inputFile){
		this.inputFile = new File(inputFile);
		this.countLines();
		this.createparsedTab();

		this.detectInstrument();
	}
	public TextFileReader(File inputFile){
		this.inputFile = inputFile;
		this.countLines();
		this.createparsedTab();
		this.detectInstrument();
	}
	
	/**
	 * counts the number of lines for Instrument Detection
	 * also responsible for checking if the input provided is bad
	 */
	private void countLines(){
		Scanner sc = null;
		try {
			sc = new Scanner(inputFile);
			while(sc.hasNextLine()){	
				String next = sc.nextLine();
				//drum tab check
				if(next.contains("X") || next.contains("x") || next.contains("O") || next.contains("o"))  {
					isDrum = true;
				}
				//end of drum tab check
				if (next.contains("-") && next.contains("|")) {
					numOfLines ++;
					System.out.println(numOfLines);
				}
				else if( 0 < numOfLines )  // modified this line to cater to prevent crashing with spacing at the start
					break;
			}					
		}
		catch(FileNotFoundException e) {e.printStackTrace();}
		finally {sc.close();}
	}
	
	/**
	 * Creates a parsedTab array of the file in parsedTabTab variable
	 */
	public void createparsedTab(){
		Scanner sc = null;
		try {
			ArrayList<String> extracted  = new ArrayList<>();
			sc = new Scanner(inputFile);

			int index = 0;
			int startFrom;
			boolean key = false;
			String holder;
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				if (line.contains("-") && line.contains("|")) {
			
					if (index <= numOfLines) {
						
						if (key == false) {
							
							parsedTab.add(line);
							index++;
						}else if (key == true){
							holder = parsedTab.get(index);
							startFrom = line.indexOf('|') + 1;
							holder = holder + line.substring(startFrom, line.length());
							parsedTab.set(index, holder);
							index++;
						}
					}

				}
				if (index == numOfLines) {
					key = true;
					index = 0;
				}			
			}			
//=======
//			}
//			for(int i = 0; i < extracted.size(); i++) 
//			{
//				// check if tab has base note here
//				// if not set base note to default
//				// default tuning EADGBE
//				if(i >= 6) {
//				StringBuilder sb = new StringBuilder();
//				sb.append(parsedTab.get(i % 6));
//				sb.append(extracted.get(i).substring(2));
//				parsedTab.set(i%6, sb.toString());
//				}
//				else 
//				{
//					parsedTab.add(extracted.get(i));
//				}
//			}
//>>>>>>> refs/heads/Ayub_Features
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			sc.close();
		}
	}
	/**
	 * determines the instrument based on the number of lines
	 * still in progress
	 */
	public String detectInstrument(){	
		String instrument = "Unable to Identify";
		int lines = numOfLines/2;
		if(lines == 4 && isDrum == false ) {
			instrument = "Bass";
		}
		else if (lines == 6 && isDrum == false) {
			instrument = "Guitar";
		}
		else{
			instrument = "Drums";
		}
		//for now we just return guitar
		return instrument;
	}
	
	public int numberOfLines() {
		return numOfLines;
	}
	
	public static java.lang.String staffLines(){
		Integer count = numOfLines/2;
		java.lang.String lines = count.toString();
		
		return lines;
	}
	
	public static String sign(){
		String sign = "tab";
		if(instrument == "guitar") {
			//G for treble
			sign = "G";
		}
		else if (instrument == "bass") {
			//F for bass
			sign = "F";
		}
		else {
			//TAB for drums
			sign = "TAB";
		}
		return sign;
	}
	
	public static java.lang.String line(){
		java.lang.String line = "";
		if(instrument == "guitar") {
			//treble lies on 3rd string for guitar
			line = "3";
		}
		else if (instrument == "bass") {
			//bass clef lies on 1st string for bass
			line = "1";
		}
		else {
			//4 for drum tabs
			line = "4";
		}
		return line;
	}
		
//	/**
//	 * Creates a parsedTab array of the file in parsedTabTab variable
//	 */
//	private void createparsedTab(){
//		Scanner sc = null;
//		try {
//			sc = new Scanner(inputFile);
//			List<String> list = new ArrayList<>();
//			String previousLine = "";
//			
//			if (sc.hasNextLine()) {
//				previousLine = sc.nextLine();
//				list.add(previousLine);
//				parsedTabTab.add(list);
//				list = new ArrayList<>();	
//			}
//			
//			while(sc.hasNextLine()){
//				
//				String line = sc.nextLine();
//
//				if ((previousLine.contains("-") && previousLine.contains("|")) && (line.contains("-") && line.contains("|"))) {
//					list.add(line);
//					parsedTabTab.add(list);
//					list = new ArrayList<>();						
//				}		
//				previousLine = line;			
//			}		
//		}
//		catch(FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		finally {
//			sc.close();
//		}
//	}
	
	public String getParsedString() {
		StringBuilder sb = new StringBuilder();
		for(String s : parsedTab)
			sb.append(s.toString()+"\n");
		return sb.toString();
	}
	
	public ArrayList<String> getParsed(){
		return parsedTab;
	}

	
	/**
	 * Prints the original text file
	 * @return
	 */
	public String printOrginal() {
		StringBuilder sb = new StringBuilder();	
		try {
			Scanner sc = new Scanner(inputFile);
			while(sc.hasNextLine()) {
				sb.append(sc.nextLine()+"\n");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();	
	}
}