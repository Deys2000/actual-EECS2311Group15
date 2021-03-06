package tabToXml;

import java.util.ArrayList;
import java.util.List;

public class GuitarParser {
	
	// Default Tunings (from higher to lower)
	final String[] defaultGuitarTunings = {"E4", "B3", "G3", "D3", "A2", "E2"}; // NEW - Billy
	final String[] defaultBassTunings = {"G2", "D2", "A1", "E1"}; // NEW - Billy
	
	// all the arrays to contain information gathered by the notes

	public ArrayList<String> notes = new ArrayList<>();
	public ArrayList<String> alterArr = new ArrayList<>();
	public ArrayList<String> fretString = new ArrayList<>();
	public ArrayList<String> fretNum = new ArrayList<>();
	public ArrayList<String> durationArr = new ArrayList<String>();
	public ArrayList<String> typeArr = new ArrayList<String>();
	public  ArrayList<String> chords = new ArrayList<String>();
	public  ArrayList<String> handp = new ArrayList<String>();
	public ArrayList<String> graceArr = new ArrayList<String>();

	public TextFileReader tfr;
	
	public ArrayList<String> tuning = new ArrayList<String>(); // DONE-> changed from static array to dynamic, it will be passed the instruments by textfilereader

	private int padding = 1; // number of dashes used for padding, should be 0 or 1
	
	private int divisions = 4; //current default is 4
	
	public GuitarParser(TextFileReader tfrPassed) throws Exception {
		tfr = tfrPassed;
		
		// GETTING TUNINGS // 
		
		// Dynamic Setting of Tunings from TextFileReader
		this.tuning = tfr.getStringChars();
		int tempIterator = 0;
		
		for(int i = 0; i < tfr.getStringChars().size(); i++) {
			// if no characters in tab for tuning
			if( tfr.getStringChars().get(i) == null) {
				// set default tuning of Bass
				if (tfr.getDetectedInstrument() == "Bass") {
					this.tuning.set(i, this.defaultBassTunings[tempIterator%4]);
					System.out.println("Added " + defaultBassTunings[tempIterator%4] + " at line " + (i+1) );
				}
				// set default tuning of Guitar
				else {
					this.tuning.set(i, this.defaultGuitarTunings[tempIterator%6]);
					System.out.println("Added " + defaultGuitarTunings[tempIterator%6] + " at line " + (i+1) );
				}
			}
			
			else {
				//assign numbers to Letters only tunings given by user (E -> E4 for example)
				String tempString = this.tuning.get(i);
				if (tempString.replaceAll("[a-zA-Z]","").length() == 0) { // there is no number
					if (tfr.getDetectedInstrument() == "Bass") {
						this.tuning.set(i, this.tuning.get(i) + this.defaultBassTunings[tempIterator%4].substring(1));
					}
					else {
						this.tuning.set(i, this.tuning.get(i) + this.defaultGuitarTunings[tempIterator%6].substring(1));
					}
				}
			}
			
			tempIterator++;
		}		
	
		System.out.println("TFR Determined > "+this.tuning);
		
		// FINISHED GETTING TUNINGS ----------------------------------------------
		
		translateParsed(tfr.getParsed());
		parseToRhythm(tfr.getParsed());

	}
	public GuitarParser(ArrayList<String> tab) throws Exception {
		//tuning = tfr.getStringChars();
		tuning.add("E4"); tuning.add("B3"); tuning.add("G3"); tuning.add("D3"); tuning.add("A2"); tuning.add("E2");

		
		translateParsed(tab);
		parseToRhythm(tab);		
	}

	// WHY ARE THESE METHODS COMMENTED OUT? DO WE NEED THEM?
	
	//    public static String removeCharAt(String str, int pos) {
	//    	return str.substring(0, pos) + str.substring(pos + 1);
	//    }

	//    public int columnLength(ArrayList<String> parsedTab) {
	//    	String shortString = parsedTab.get(0);
	//    	
	//    	for (String elem : parsedTab) {
	//    		if (elem.length() < shortString.length()) {
	//    			shortString = elem;
	//    		}
	//    	}
	//    	
	//    	return shortString.length();
	//    }

	/*This method takes the input file and parses that into a 2d array. 
	 *The result of that 2d array is used to obtain the fret and chord/note
	 *using the translate() method above. */    
	public void translateParsed(ArrayList<String> parsedTab) throws Exception {

		int row = parsedTab.size();	
		int next = parsedTab.get(0).length();
//		next = parsedTab.get(0).length(); //Adjust the lenght of the current line of the tablature
		char fret2 = '\0';
		String tmp = "";
	
		int cal = 0;
		int j = 0;
			// go through each column
			for (j = 0; j < next; j++) {			
				String fretStringValue = "";
				String fretNumVar = "";   // reset the fret string checker on the iteration of each new column
				String chord = ""; 		// clear value of note before every column
				
				// go through each row
				for(int i = 0; i < row; i++) {

					next = parsedTab.get(i).length(); //Adjust the lenght of the current line of the tablature
					String fretStringVar = ""; //This is the number  of the current string for a Guitar the string are numbered from 1-6
					
					fret2 = parsedTab.get(i).charAt(j);					
					int fret = Character.getNumericValue(fret2);
					
					if ((fret2 >= '0' && fret2 <= '9') && (j > 0 && j < next)) {
						if (parsedTab.get(i).charAt(j+1) >= '0' && parsedTab.get(i).charAt(j+1) <= '9') {
							continue;
						}
					}
					
					if (fret2 >= '0' && fret2 <= '9') {
						fretStringValue = ""; //Used for concatenating two single numbers to make a double digit number
						tmp = "";
						
						// make regular note 
						if (chord.isEmpty() && fretNumVar.isEmpty() && fretStringVar.isEmpty()) {
							
							//fret is the number
							if (parsedTab.get(i).charAt(j-1) >= '0' && parsedTab.get(i).charAt(j-1) <= '9') {
								fretStringValue =  String.valueOf(parsedTab.get(i).charAt(j-1)) + String.valueOf(parsedTab.get(i).charAt(j));
								fret = Integer.parseInt(fretStringValue);
//								parsedTab.set(i, removeCharAt(parsedTab.get(i), j-1));							
							}else {
								fretStringValue = fret + "";
							}
						
							if (fret <= 24) {
								chord = translate(tuning.get(i), fret);
								fretNumVar = fretStringValue;
								if (parsedTab.get(i).charAt(j+1) == 'p' || parsedTab.get(i).charAt(j+1) == 'P') {
									fretNumVar = fretNumVar + "p";
								}
								if (parsedTab.get(i).charAt(j-2) == 'p' || parsedTab.get(i).charAt(j-2) == 'P' || parsedTab.get(i).charAt(j-1) == 'p' || parsedTab.get(i).charAt(j-1) == 'P') {
									fretNumVar = "p" + fretNumVar;
								}
								if (parsedTab.get(i).charAt(j+1) == 'h' || parsedTab.get(i).charAt(j+1) == 'H') {
									fretNumVar = fretNumVar + "h";
								}
								if (parsedTab.get(i).charAt(j-2) == 'h' || parsedTab.get(i).charAt(j-2) == 'H' || parsedTab.get(i).charAt(j-1) == 'h' || parsedTab.get(i).charAt(j-1) == 'H') {
									fretNumVar = "h" + fretNumVar;
								}
								//---
								if (parsedTab.get(i).charAt(j+1) == 's' || parsedTab.get(i).charAt(j+1) == 'S') {
									fretNumVar = fretNumVar + "s";
								}
								if (parsedTab.get(i).charAt(j-2) == 's' || parsedTab.get(i).charAt(j-2) == 's' || parsedTab.get(i).charAt(j-1) == 's' || parsedTab.get(i).charAt(j-1) == 's') {
									fretNumVar = "s" + fretNumVar;
								}
								//---
								if (parsedTab.get(i).charAt(j+1) == '/') {
									fretNumVar = fretNumVar + "/";
								}
								if (parsedTab.get(i).charAt(j-2) == '/' || parsedTab.get(i).charAt(j-1) == '/') {
									fretNumVar = "/" + fretNumVar;
								}
								if (parsedTab.get(i).charAt(j+1) == '\\' || parsedTab.get(i).charAt(j+1) == '\\') {
									fretNumVar = fretNumVar + "\\";
								}
								if (parsedTab.get(i).charAt(j-2) == '\\' || parsedTab.get(i).charAt(j-1) == '\\') {
									fretNumVar = "\\" + fretNumVar;
								}
								//----
								if ((parsedTab.get(i).charAt(j-2) == '[' || parsedTab.get(i).charAt(j-1) == '[') && parsedTab.get(i).charAt(j+1) == ']') {
									fretNumVar = "[" + fretNumVar + "]";
								}
								if ((parsedTab.get(i).charAt(j-2) == '{' || parsedTab.get(i).charAt(j-1) == '{') && parsedTab.get(i).charAt(j+1) == '}') {
									fretNumVar = "[" + fretNumVar + "]";
								}
								if ((parsedTab.get(i).charAt(j-2) == '(' || parsedTab.get(i).charAt(j-1) == '(') && parsedTab.get(i).charAt(j+1) == ')') {
									fretNumVar = "[" + fretNumVar + "]";
								}							

								if (((parsedTab.get(i).charAt(j+1) == 'b') || (parsedTab.get(i).charAt(j+1) == 'r')) && ((parsedTab.get(i).charAt(j+2) >= '0') && (parsedTab.get(i).charAt(j+2) <= '9')) && (j < next)) {
									String var2;
									if ((parsedTab.get(i).charAt(j+3) >= '0') && (parsedTab.get(i).charAt(j+3) <= '9')) {
										var2 = "" + parsedTab.get(i).charAt(j+2) + parsedTab.get(i).charAt(j+3);
									}
									else {
										var2 =  "" + parsedTab.get(i).charAt(j+2);
									}
									int var1 =  Character.getNumericValue(fret2);
									int n = Integer.parseInt(var2) - var1;
									fretNumVar = fretNumVar + "b" + n;
//									fretNumVar = "[" + fretNumVar + "]";
								}
								
//								else {fretNumVar = fretStringValue;}	
								cal = i + 1;
								fretStringVar = cal + "";
							}
							
						}else { // make a chord note
//							notes.remove(notes.size() - 1);
//							fretNum.remove(fretNum.size() - 1);
							//fretString.remove(fretString.size()-1);
							
//							notes.add(chord);
//							fretNum.add(fretNumVar);
							//fretString.add(fretStringVar);
							
							if (parsedTab.get(i).charAt(j-1) >= '0' && parsedTab.get(i).charAt(j-1) <= '9') {
								fretStringValue =  String.valueOf(parsedTab.get(i).charAt(j-1)) + String.valueOf(parsedTab.get(i).charAt(j));
								fret = Integer.parseInt(fretStringValue);
//								parsedTab.set(i, removeCharAt(parsedTab.get(i), j-1));
							}else {
								fretStringValue = fret + "";
							}
							
							
							
							if (fret <= 24) {
								chord = "+" + translate(tuning.get(i), fret);
								fretNumVar = fretStringValue;
								if (parsedTab.get(i).charAt(j+1) == 'p' || parsedTab.get(i).charAt(j+1) == 'P') {
									fretNumVar = fretNumVar + "p";
								}
								if (parsedTab.get(i).charAt(j-2) == 'p' || parsedTab.get(i).charAt(j-2) == 'P' || parsedTab.get(i).charAt(j-1) == 'p' || parsedTab.get(i).charAt(j-1) == 'P') {
									fretNumVar = "p" + fretNumVar;
								}
								if (parsedTab.get(i).charAt(j+1) == 'h' || parsedTab.get(i).charAt(j+1) == 'H') {
									fretNumVar = fretNumVar + "h";
								}
						        if (parsedTab.get(i).charAt(j-2) == 'h' || parsedTab.get(i).charAt(j-2) == 'H' || parsedTab.get(i).charAt(j-1) == 'h' || parsedTab.get(i).charAt(j-1) == 'H') {
									fretNumVar = "h" + fretNumVar;
								}
						        
						        //---
								if (parsedTab.get(i).charAt(j+1) == 's' || parsedTab.get(i).charAt(j+1) == 'S') {
									fretNumVar = fretNumVar + "s";
								}
								if (parsedTab.get(i).charAt(j-2) == 's' || parsedTab.get(i).charAt(j-2) == 's' || parsedTab.get(i).charAt(j-1) == 's' || parsedTab.get(i).charAt(j-1) == 's') {
									fretNumVar = "s" + fretNumVar;
								}
								//---
			
								if (parsedTab.get(i).charAt(j+1) == '/') {
									fretNumVar = fretNumVar + "/";
								}
								if (parsedTab.get(i).charAt(j-2) == '/' || parsedTab.get(i).charAt(j-1) == '/') {
									fretNumVar = "/" + fretNumVar;
								}
								if (parsedTab.get(i).charAt(j+1) == '\\' || parsedTab.get(i).charAt(j+1) == '\\') {
									fretNumVar = fretNumVar + "\\";
								}
								if (parsedTab.get(i).charAt(j-2) == '\\' || parsedTab.get(i).charAt(j-1) == '\\') {
									fretNumVar = "\\" + fretNumVar;
								}
								//----
								if ((parsedTab.get(i).charAt(j-2) == '[' || parsedTab.get(i).charAt(j-1) == '[') && parsedTab.get(i).charAt(j+1) == ']') {
									fretNumVar = "[" + fretNumVar + "]";
								}
								if ((parsedTab.get(i).charAt(j-2) == '{' || parsedTab.get(i).charAt(j-1) == '{') && parsedTab.get(i).charAt(j+1) == '}') {
									fretNumVar = "[" + fretNumVar + "]";
								}
								if ((parsedTab.get(i).charAt(j-2) == '(' || parsedTab.get(i).charAt(j-1) == '(') && parsedTab.get(i).charAt(j+1) == ')') {
									fretNumVar = "[" + fretNumVar + "]";
								}

								if (((parsedTab.get(i).charAt(j+1) == 'b') || (parsedTab.get(i).charAt(j+1) == 'r')) && ((parsedTab.get(i).charAt(j+2) >= '0') && (parsedTab.get(i).charAt(j+2) <= '9')) && (j < next)) {
									String var2;
									if ((parsedTab.get(i).charAt(j+3) >= '0') && (parsedTab.get(i).charAt(j+3) <= '9')) {
										var2 = "" + parsedTab.get(i).charAt(j+2) + parsedTab.get(i).charAt(j+3);
									}
									else {
										var2 =  "" + parsedTab.get(i).charAt(j+2);
									}
									int var1 =  Character.getNumericValue(fret2);
									int n = Integer.parseInt(var2) - var1;
									fretNumVar = fretNumVar + "b" + n;
//									fretNumVar = "[" + fretNumVar + "]";
								}
								
//						        else {fretNumVar = fretStringValue;}							
								fretStringVar = cal + "";
							}								
						} 
						
//						if (!fretNumVar.isEmpty() && !chord.isEmpty() && !fretStringVar.isEmpty()) {
//							if (parsedTab.get(i).charAt(j+1) == 'p' || parsedTab.get(i).charAt(j+1) == 'P') {
//								fretNumVar = fretStringValue + "p";
//							}else if (parsedTab.get(i).charAt(j-1) == 'p' || parsedTab.get(i).charAt(j-1) == 'P') {
//								fretNumVar = "p" + fretStringValue;
//							}else if (parsedTab.get(i).charAt(j+1) == 'h' || parsedTab.get(i).charAt(j+1) == 'H') {
//								fretNumVar = fretStringValue + "h";
//							}else if (parsedTab.get(i).charAt(j-1) == 'h' || parsedTab.get(i).charAt(j-1) == 'H') {
//								fretNumVar = "h" + fretStringValue;
//							}
//						}
										
								
						addToLists(chord, fretNumVar, String.valueOf(i+1), null);
	
					}
					else if (fret2 == '|') {
						if (tmp.isEmpty()) {
							tmp = fret2 + "";
							addToLists(tmp, tmp, tmp, tmp);

						}
					}

				}
			}
		
			removeFromLists(notes.size() - 1, fretNum.size() - 1, fretString.size()-1, alterArr.size()-1);

			addToLists("||", "||", "||", "||");

		//cleaning up the + in the chords and making a chords list
		for( int i = 0; i < notes.size(); i++) {
			if(notes.get(i).charAt(0) == '+'){
    			notes.set(i, notes.get(i).substring(1));
				chords.add("true");
    		}
    		else if( notes.get(i).charAt(0) == '|') {
    			chords.add("|");
    		}
    		else {
    			chords.add("false");
    		}
    	}
		
		for( int i = 0; i < fretNum.size(); i++) {
			
				if ((fretNum.get(i).charAt(0) >= '0' && fretNum.get(i).charAt(0) <= '9') ^ (fretNum.get(i).charAt(fretNum.get(i).length()-1) >= '0' && fretNum.get(i).charAt(fretNum.get(i).length()-1) <= '9')) {
					if(fretNum.get(i).charAt(0) == 'p'){
						fretNum.set(i, fretNum.get(i).substring(1));
						handp.add("pstop");
		    		}
					else if(fretNum.get(i).charAt(0) == 'h'){
						fretNum.set(i, fretNum.get(i).substring(1));
						handp.add("hstop"); //h10
		    		}
					else if(fretNum.get(i).charAt(fretNum.get(i).length()-1) == 'p'){
						fretNum.set(i, fretNum.get(i).substring(0, fretNum.get(i).length()-1));
						handp.add("pstart"); //11p
		    		}
					else if(fretNum.get(i).charAt(fretNum.get(i).length()-1) == 'h'){
						fretNum.set(i, fretNum.get(i).substring(0, fretNum.get(i).length()-1));
						handp.add("hstart"); //11h
		    		}
					else if(fretNum.get(i).charAt(fretNum.get(i).length()-1) == '/'){
						fretNum.set(i, fretNum.get(i).substring(0, fretNum.get(i).length()-1));
						handp.add("astart"); //11h
		    		}
					else if(fretNum.get(i).charAt(fretNum.get(i).length()-1) == '\\'){
						fretNum.set(i, fretNum.get(i).substring(0, fretNum.get(i).length()-1));
						handp.add("dstart"); //11h
		    		}
					else if(fretNum.get(i).charAt(0) == '\\'){
						fretNum.set(i, fretNum.get(i).substring(1));
						handp.add("dstop"); //h10
		    		}
					else if(fretNum.get(i).charAt(0) == '/'){
						fretNum.set(i, fretNum.get(i).substring(1));
						handp.add("astop"); //h10
		    		}
					
					//----------
					else if(fretNum.get(i).charAt(0) == 's'){
						fretNum.set(i, fretNum.get(i).substring(1));
						handp.add("sstop"); 
		    		}
					else if(fretNum.get(i).charAt(fretNum.get(i).length()-1) == 's'){
						fretNum.set(i, fretNum.get(i).substring(0, fretNum.get(i).length()-1));
						handp.add("sstart"); 
		    		}
					//---------
				}
//				else if (!((fretNum.get(i).charAt(0) >= '0' && fretNum.get(i).charAt(0) <= '9') ^ (fretNum.get(i).charAt(fretNum.get(i).length()-1) >= '0' && fretNum.get(i).charAt(fretNum.get(i).length()-1) <= '9'))) {
				else if (fretNum.get(i).charAt(0) == 'p' && fretNum.get(i).charAt(fretNum.get(i).length()-1) == 'h') {
						fretNum.set(i, fretNum.get(i).substring(1));
						fretNum.set(i, fretNum.get(i).substring(0, fretNum.get(i).length()-1));
						handp.add("PstopHstart");
						
				}
				else if (fretNum.get(i).charAt(0) == 'h' && fretNum.get(i).charAt(fretNum.get(i).length()-1) == 'p') {
					fretNum.set(i, fretNum.get(i).substring(1));
					fretNum.set(i, fretNum.get(i).substring(0, fretNum.get(i).length()-1));
					handp.add("HstopPstart");
				}
				else if (fretNum.get(i).charAt(0) == 'h' && fretNum.get(i).charAt(fretNum.get(i).length()-1) == 'h') {
					fretNum.set(i, fretNum.get(i).substring(1));
					fretNum.set(i, fretNum.get(i).substring(0, fretNum.get(i).length()-1));
					handp.add("HstopHstart");
				}
				else if (fretNum.get(i).charAt(0) == 'p' && fretNum.get(i).charAt(fretNum.get(i).length()-1) == 'p') {
					fretNum.set(i, fretNum.get(i).substring(1));
					fretNum.set(i, fretNum.get(i).substring(0, fretNum.get(i).length()-1));
					handp.add("PstopPstart");
				}		
				//-------
				else if (fretNum.get(i).charAt(0) == '/' && fretNum.get(i).charAt(fretNum.get(i).length()-1) == '\\') {
					fretNum.set(i, fretNum.get(i).substring(1));
					fretNum.set(i, fretNum.get(i).substring(0, fretNum.get(i).length()-1));
					handp.add("AstopDstart");
					
				}
				else if (fretNum.get(i).charAt(0) == '\\' && fretNum.get(i).charAt(fretNum.get(i).length()-1) == '/') {
					fretNum.set(i, fretNum.get(i).substring(1));
					fretNum.set(i, fretNum.get(i).substring(0, fretNum.get(i).length()-1));
					handp.add("DstopAstart");
				}
				else if (fretNum.get(i).charAt(0) == '/' && fretNum.get(i).charAt(fretNum.get(i).length()-1) == '/') {
					fretNum.set(i, fretNum.get(i).substring(1));
					fretNum.set(i, fretNum.get(i).substring(0, fretNum.get(i).length()-1));
					handp.add("AstopAstart");
				}
				else if (fretNum.get(i).charAt(0) == '\\' && fretNum.get(i).charAt(fretNum.get(i).length()-1) == '\\') {
					fretNum.set(i, fretNum.get(i).substring(1));
					fretNum.set(i, fretNum.get(i).substring(0, fretNum.get(i).length()-1));
					handp.add("DstopDstart");
				}
				//----------
				
				//-----------
				else if (fretNum.get(i).charAt(0) == '[' && fretNum.get(i).charAt(fretNum.get(i).length()-1) == ']') {
					fretNum.set(i, fretNum.get(i).substring(1));
					fretNum.set(i, fretNum.get(i).substring(0, fretNum.get(i).length()-1));
					handp.add("Nharmonics");	
				}
				//----
//				else if ((fretNum.get(i).charAt(0) >= '0') && (fretNum.get(i).charAt(0) <= '9') && (fretNum.get(i).charAt(fretNum.get(i).length()-1) >= '0') && (fretNum.get(i).charAt(fretNum.get(i).length()-1) <= '9') ) {
				else if (fretNum.get(i).contains("b")){
					int findIndex = fretNum.get(i).indexOf("b") + 1;
					
					String useIndex = fretNum.get(i).substring(findIndex);
					handp.add("b"+useIndex);
					fretNum.set(i,fretNum.get(i).substring(0,findIndex-1));
				}
				//----
				
				else if( fretNum.get(i).charAt(0) == '|') {
	    			handp.add("|");
	    		}
	    		else {
	    			handp.add("neutral");
	    		}
				
    	}
			
		// chords - add the double bars later
	}

	public void addToLists(String note, String ft, String fs, String al) {
		notes.add(note);
		fretNum.add(ft);
		fretString.add(fs);
		
		if (al != null) {
			alterArr.add(al);
		}

	}

	public void removeFromLists(int note, int ft, int fs, int al) {
		notes.remove(note);
		fretNum.remove(ft);
		fretString.remove(fs);
		alterArr.remove(al);
	}


	/**
     * Generates duration and type arrays from parsed array
     * @param parsedTab - a formatted tab (arrayList of Strings)
     */
public void parseToRhythm(ArrayList<String> parsedTab) {
    	
//    	// For Debugging
//    	for(int i = 0; i < parsedTab.size(); i++) {
//    		System.out.println(parsedTab.get(i));
//    	}
        
        int counter = 0; // iterates horizontally
        
        int measure = 0; // current measure
        int beats = 4; // beats in current measure
        int beatType = 4; // beat type of current measure
        int dashNum = 17; // number of dashes in curretn measure
        int dashPerBeat = 0; // number of dashes per beat
        int dashLength = 0; // noteLength of each dash // DO WE NEED THIS???
        
        int noteLength = 0; // in 16th notes NEEDS TO BE CHANGED
        int lines = parsedTab.size(); // number of lines in staff
        int currentLine = 0;
        int prevChordNum = 0; // number of notes in previous chord
        int curChordNum = 0; // number of notes in current chord
        
        boolean isDoubleDigit = false;
        
        int graceNoteNum = 0; // number of tracked grace notes, for backtracking to note before the grace notes start
        int graceNoteLength = 0; // note length of tracked grace notes, in 16th notes
        int graceNoteCounter = 0; // counter of previously tracked grace note
        boolean trackingGrace = false; // if we are tracking grace notes
        
        while (counter < parsedTab.get(0).length()) { 
            
            currentLine = 0;
            
            // Skip "|" and padding "-"
            if (parsedTab.get(0).charAt(counter) == '|') {
            	
            	// assign measure attributes to variables
            	if (measure < tfr.getAttributesPerMeasure().size()) {
            		beats = tfr.getAttributesPerMeasure().get(measure).getBeats();
            		beatType = tfr.getAttributesPerMeasure().get(measure).getBeattype();
            		dashNum = tfr.getAttributesPerMeasure().get(measure).getDashes();
            		System.out.println("Measure " + (measure + 1) + ": beats = " + beats + " beattype = " + beatType + " dashes = " + dashNum);
            		measure++;
            	}
            	
            	// Determine Divisions
            	dashNum -= padding;
            	divisions = (dashNum / beats) * (beatType / 4); // CHECK FOR DIFFERENT CASES TO SEE IF THIS WORKS
            	
                // Assuming note lengths end at barlines
                if(noteLength != 0) {
                	// Add all tracked notes to arrays
                	while (prevChordNum > 0) {
	                    durationArr.add("" + noteLength);
	                    typeArr.add(durationToType(noteLength, divisions));
	                    prevChordNum--;
                	}
                	
                	// since we have reached end of measure, reset and stop counting noteLength
                    noteLength = 0;
                }
                
                // finish tracking grace notes
                if(trackingGrace) {
                	// Add grace note length to note before grace note start
        			int replaceIndex = durationArr.size() - graceNoteNum - 2;
        			durationArr.set(replaceIndex, "" + (Integer.parseInt(durationArr.get(replaceIndex)) + graceNoteLength));
        			typeArr.set(replaceIndex, durationToType(Integer.parseInt(durationArr.get(replaceIndex)), divisions));
        			
        			// Repeat above step for all notes part of a chord, if note before grace note start is a chord note
        			while (chords.get(replaceIndex) ==  "true") {
        				replaceIndex--;
        				durationArr.set(replaceIndex, "" + (Integer.parseInt(durationArr.get(replaceIndex)) + graceNoteLength));
            			typeArr.set(replaceIndex, durationToType(Integer.parseInt(durationArr.get(replaceIndex)), divisions));
        			}
        			
        			// replace all grace note durations with null and set grace tag
        			while (graceNoteNum > 0) {
        				replaceIndex = durationArr.size() - graceNoteNum - 1;
        				durationArr.set(replaceIndex, "-1");

        				graceArr.add("true");	
        				graceNoteNum--;
        			}
        			
        			// Add tag for current note (which is not a grace note)
        			graceArr.add("false"); 
        			
        			// Stop tracking grace notes and reset graceNoteLength
        			trackingGrace = false;
        			graceNoteLength = 0;
                }
                
                // Check for Double Barlines
                if(counter + 1 < parsedTab.get(0).length() && parsedTab.get(0).charAt(counter + 1) == '|') {
                	durationArr.add("||");
                    typeArr.add("||");
                    graceArr.add("||");
                    counter++;
                }
                else {
	                durationArr.add("|");
	                typeArr.add("|");
	                graceArr.add("|");
                }
                counter += padding; // skipping both '|' and padding '-', if padding exists
            }
                    
            // Should be run before encountering the first note/chord in a measure
            else if (prevChordNum == 0) {
            	
            	// Assume Frets are Single digit
                while(currentLine < lines) {
                	
                	// Add all notes to a chord
                    if(Character.isDigit(parsedTab.get(currentLine).charAt(counter))) {
                    	
                    	// check if fret is doubledigit
                    	if(Character.isDigit(parsedTab.get(currentLine).charAt(counter + 1))) {
                    		isDoubleDigit = true;
                    	}
                    	
                    	// starts counting noteLength, should only be done once
                    	if (prevChordNum == 0) {
                    		noteLength++;
                    	}
                    	
                        prevChordNum++;
                    }
                    
                    currentLine++;
                }
                
                // If DoubleDigit frets, recount using one's place, and determine grace tags
                if (isDoubleDigit) {
                	int totalFretNum = 0;
                	currentLine = 0;
                	
                	while (currentLine < lines) {
                		if(Character.isDigit(parsedTab.get(currentLine).charAt(counter + 1))) {
                			totalFretNum++;
                			
                			// check if fret is grace note (start)
    	                	if(parsedTab.get(currentLine).charAt(counter - 1) == 'g') {
    	
    	                		// System.out.println("Starting to Track Grace Notes Now"); // For Debugging
    	                		trackingGrace = true;
    	                		graceNoteCounter = counter; 
    	                		// account for double digit frets
    	                		if (isDoubleDigit)
    	            				graceNoteCounter++;
    	                	}
    	                	else {
    	                		graceArr.add("false");
    	                	}
                		}
                		
                		currentLine++;
                	}
                	
                	prevChordNum = totalFretNum;
                	
                	counter++;
                	isDoubleDigit = false;
                }
                // If SingleDigits frets, determine grace tags
                else {
                	currentLine = 0;
                	
                	while (currentLine < lines) {
                		if (Character.isDigit(parsedTab.get(currentLine).charAt(counter))) {
		                	// check if fret is grace note (start)
		                	if(parsedTab.get(currentLine).charAt(counter - 1) == 'g') {
		
		                		// System.out.println("Starting to Track Grace Notes Now"); // For Debugging
		                		trackingGrace = true;
		                		graceNoteCounter = counter; 
		                		// account for double digit frets
		                		if (isDoubleDigit)
		            				graceNoteCounter++;
		                	}
		                	else {
		                		graceArr.add("false");
		                	}
                		}
	                	
	                	currentLine++;
                	}
                }
            }
            
            // Should be run after encountering the first note/chord in a measure
            else {
            	            	
            	// Check for Single Digit Frets
                while(currentLine < lines) {
                    
                	// Adds all previous chord notes to arrays, then adds current notes to current chord
                    if(Character.isDigit(parsedTab.get(currentLine).charAt(counter))) {
                    	
                    	// check if fret is doubledigit
                    	if(Character.isDigit(parsedTab.get(currentLine).charAt(counter+1))) {
                    		isDoubleDigit = true;
                    	}
                    	
                    	// Adding tracked notes to arrays
                    	while (prevChordNum > 0) {
	                        durationArr.add("" + noteLength);
	                        typeArr.add(durationToType(noteLength, divisions));
	                        prevChordNum--;
                    	}
                    	
                    	// reset note Length
                        noteLength = 0;
                        curChordNum++;
                    }
                    
                    currentLine++;
                }

                // If DoubleDigit frets, recount using one's place
                if(isDoubleDigit) {
                                	
                	int totalFretNum = 0;
                	currentLine = 0;
                	
                	while (currentLine < lines) {
                		if(Character.isDigit(parsedTab.get(currentLine).charAt(counter + 1))) {
                			totalFretNum++;
                			
                			// check if fret is grace note
                        	if(trackingGrace) {
                        		// if fret continues grace note
                        		if (checkGraceContinue(parsedTab.get(currentLine).charAt(counter - 1)) && (counter - graceNoteCounter == 2)) {
                        			graceNoteNum++;
                        			graceNoteLength += 2;
                        			graceNoteCounter = counter;
                        		}
                        		// end grace note and add to arrays
                        		else {
                        			// Add grace note length to note before grace note start
                        			int replaceIndex = durationArr.size() - graceNoteNum - 2;
                        			durationArr.set(replaceIndex, "" + (Integer.parseInt(durationArr.get(replaceIndex)) + graceNoteLength));
                        			typeArr.set(replaceIndex, durationToType(Integer.parseInt(durationArr.get(replaceIndex)), divisions));
                        			
                        			// Repeat above step for all notes part of a chord, if note before grace note start is a chord note
                        			while (chords.get(replaceIndex) ==  "true") {
                        				replaceIndex--;
                        				durationArr.set(replaceIndex, "" + (Integer.parseInt(durationArr.get(replaceIndex)) + graceNoteLength));
                            			typeArr.set(replaceIndex, durationToType(Integer.parseInt(durationArr.get(replaceIndex)), divisions));
                        			}
                        			
                        			// replace all grace note durations with null and set grace tag
                        			while (graceNoteNum > 0) {
                        				replaceIndex = durationArr.size() - graceNoteNum - 1;
                        				durationArr.set(replaceIndex, "-1");

                        				graceArr.add("true");		
                        				graceNoteNum--;
                        			}
                        			
                        			// Add tag for previous note (which is not a grace note)
                        			graceArr.add("false"); 
                        			
                        			// Stop tracking grace notes
                        			if (parsedTab.get(currentLine).charAt(counter - 1) == 'g') {
                            			graceNoteCounter = counter;
                            			// account for double digit frets
                            			if (isDoubleDigit)
                            				graceNoteCounter++;
                            		}
                        			else {
                        				// Stop tracking grace notes
                        				trackingGrace = false;
                        				
                        				// Add tag for current note
                        				graceArr.add("false");
                        			}
                        			// reset graceNoteLength
                        			graceNoteLength = 0;
                        		}
                        	}
                        	// if not tracking grace note
                        	else if (parsedTab.get(currentLine).charAt(counter - 1) == 'g'){
                        		// System.out.println("Starting to Track Grace Notes Now"); // For Debugging
                        		trackingGrace = true;
                        		graceNoteCounter = counter;
                        		// account for double digit frets
                        		if (isDoubleDigit)
                    				graceNoteCounter++;
                        	}
                        	else {
                        		graceArr.add("false");
                        	}
                		}
                		
                		currentLine++;
                	}
                	
                	curChordNum = totalFretNum;
                	
                	// increment counter and reset isDoubleDigit
                	counter++;
                	isDoubleDigit = false;
                }
                else {
                	
                	currentLine = 0;
                	
                	while (currentLine < lines) {
                		if(Character.isDigit(parsedTab.get(currentLine).charAt(counter))) {
                			
                			// check if fret is grace note
                        	if(trackingGrace) {
                        		// if fret continues grace note
                        		if (checkGraceContinue(parsedTab.get(currentLine).charAt(counter - 1)) && (counter - graceNoteCounter == 2)) {
                        			graceNoteNum++;
                        			graceNoteLength += 2;
                        			graceNoteCounter = counter;
                        		}
                        		// end grace note and add to arrays
                        		else {
                        			// Add grace note length to note before grace note start
                        			int replaceIndex = durationArr.size() - graceNoteNum - 2;
                        			durationArr.set(replaceIndex, "" + (Integer.parseInt(durationArr.get(replaceIndex)) + graceNoteLength));
                        			typeArr.set(replaceIndex, durationToType(Integer.parseInt(durationArr.get(replaceIndex)), divisions));
                        			
                        			// Repeat above step for all notes part of a chord, if note before grace note start is a chord note
                        			while (chords.get(replaceIndex) ==  "true") {
                        				replaceIndex--;
                        				durationArr.set(replaceIndex, "" + (Integer.parseInt(durationArr.get(replaceIndex)) + graceNoteLength));
                            			typeArr.set(replaceIndex, durationToType(Integer.parseInt(durationArr.get(replaceIndex)), divisions));
                        			}
                        			
                        			// replace all grace note durations with null and set grace tag
                        			while (graceNoteNum > 0) {
                        				replaceIndex = durationArr.size() - graceNoteNum - 1;
                        				durationArr.set(replaceIndex, "-1");

                        				graceArr.add("true");		
                        				graceNoteNum--;
                        			}
                        			
                        			// Add tag for previous note (which is not a grace note)
                        			graceArr.add("false"); 
                        			
                        			// Stop tracking grace notes
                        			if (parsedTab.get(currentLine).charAt(counter - 1) == 'g') {
                            			graceNoteCounter = counter;
                            			// account for double digit frets
                            			if (isDoubleDigit)
                            				graceNoteCounter++;
                            		}
                        			else {
                        				// Stop tracking grace notes
                        				trackingGrace = false;
                        				
                        				// Add tag for current note
                        				graceArr.add("false");
                        			}
                        			// reset graceNoteLength
                        			graceNoteLength = 0;
                        		}
                        	}
                        	// if not tracking grace note
                        	else if (parsedTab.get(currentLine).charAt(counter - 1) == 'g'){
                        		// System.out.println("Starting to Track Grace Notes Now"); // For Debugging
                        		trackingGrace = true;
                        		graceNoteCounter = counter;
                        		// account for double digit frets
                        		if (isDoubleDigit)
                    				graceNoteCounter++;
                        	}
                        	else {
                        		graceArr.add("false");
                        	}
                		}
                		
                		currentLine++;
                	}
                }
 
                // if there are notes in the current chord, copy them to previous chord and empty current chord
                if(curChordNum != 0) {
                	prevChordNum = curChordNum;
                	curChordNum = 0;
                }
                
                // increase note length by 1
                noteLength++; 

            }
            
            counter++;
        }
        
    }
    
    private boolean checkGraceContinue(char c) {
    	
    	boolean result = false;
    	
    	if (c == 'h' || c == 'p' || c == '/' || c == '\\' || c == 's') {
    		result = true;
    	}
    	
    	return result;
    }
    
    /**
     * CARRIED OVER FROM RHYTHM PARSER CLASS
     * returns the word representation of the duration amount
     * The method that calls this should throw an error if result is "unknown"
     * @param duration
     * @param divisions
     * @return
     */
    private String durationToType(int duration, int divisions) {
        
        double durOverDiv = (double) duration / divisions;
        String result = "";
        
        // Can't use switch since durOverDiv is double type
        if (durOverDiv >= 4.0) {
            result = "whole";
        }
        else if (durOverDiv >= 3.0) {	// note in musicXML needs <dot/> tag
        	result = "dotted half";
        }
        else if (durOverDiv >= 2.0) {
            result = "half";
        }
        else if (durOverDiv >= 1.5) {	// note in musicXML needs <dot/> tag
            result = "dotted quarter";
        }
        else if (durOverDiv >= 1.0) {
            result = "quarter";
        }
        else if (durOverDiv >= 0.75) {	// note in musicXML needs <dot/> tag
            result = "dotted eighth";
        }
        else if (durOverDiv >= 0.5) {
            result = "eighth";
        }
        else if (durOverDiv >= 0.25) {
            result = "16th";
        }
        else {
        	result = "16th"; //default, should be set to "unknown"
        	// Should throw minor error
        }
        
        return result;
    }    
    
	/**
	 * Converts a Note
	 * C > C#/Db > D > D#/Eb > E > F > F#/Gb > G > G#/Ab > A > A#/Bb > B > Loops back to C
	 * @param Note
	 * @return
	 * @throws Exception 
	 */

	public String translate(String string, int fret) throws Exception{
		if(fret > 24)
			throw new Exception("The fret must be between 1 and 24 (inclusive)");


		String[] table = {"C","C#","D","D#","E","F","F#","G","G#","A","A#","B"};			
		//find location in table
		int location = 0;
		for(int i = 0; i < table.length; i++) {
			if(string.substring(0,1).equals(table[i])) {
				location = i;
				break;
			}
		}

		int startingOctave = Integer.parseInt(string.substring(1));
		int octave = startingOctave;
		while(fret > 0) {
			location++;
			fret--;
			if(location == table.length) {
				location = 0;
				octave++;
			}
		}

		// Determining Alter - Hardcoded for C major
		if (table[location].length() == 2) { // check if # is part of the note
			alterArr.add("1");
		}
		else {
			alterArr.add(null);
		}

		String newNote = table[location].substring(0,1)+octave;
		return newNote;
	}
	
	// GETTER METHODS TO SEND EACH OF THE ARRAYS OF INFORMATION TO XMLGEN 
	public ArrayList<String> getNotes(){return notes;}	
	public ArrayList<String> getAlters() {return alterArr;}
	public ArrayList<String> getFretStrings(){return fretString;}
	public ArrayList<String> getFretNums(){ return fretNum;}
	public ArrayList<String> getTypeArr(){return this.typeArr;}
	public ArrayList<String> getDurationArr(){return this.durationArr;}
	public ArrayList<String> getChordArr(){return this.chords;}
	public ArrayList<String> getHandPArr(){	return handp;}
	public ArrayList<String> getGraceArr(){return graceArr;}

}
