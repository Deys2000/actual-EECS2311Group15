package tabToXml;

import java.util.ArrayList;

//NEEDS TO BE MODULAR SO THAT EVERYTHING IS NOT HAPPENING IN THE CONSTRUCTOR
//ALSO NEEDS A COUPLE OF TAGS THAT ARE MISSING
//NEED TO COMPLETE THE INSTRUMENT LIST AS WELL
//LOOK INTO MAKING THE NOTE AND MEASURE CLASS PRIVATE

public class DrumParser2 {
	ArrayList<DrumMeasure> measures;
	ArrayList<DrumStringInfo> tabStrings;
	
	// we will pass 3 pieces of information when creating an object of this class
	// they will all be contained within one object hopefully a MEASURE object of sorts 
	// 1 - a list of measures
	// 2 - a list of corresponding attributes for each measure
	// 3 - additional meta-information
	public DrumParser2() throws Exception {
		
		// WE WILL ASSUME THE FOLLOWING IS THE FORMAT OF OUR INFORMATION (precondition is that all must be same length)
		// 1 List of Measures
		ArrayList<ArrayList<String>> exampleInput = new ArrayList<ArrayList<String>>();
		ArrayList<String> m1 = new ArrayList<>();
		m1.add("|X---------------|");
		m1.add("|----o---o---o---|");
		m1.add("|----o--o-o--o---|");
		m1.add("|o--o----o-oo--o-|");
		ArrayList<String> m2 = new ArrayList<>();
		m2.add("|X---------------|");
		m2.add("|----o---o---o---|");
		m2.add("|----o--o-o--o---|");
		m2.add("|o--o----o-oo--o-|");		
		exampleInput.add(m1);
		exampleInput.add(m2);
		// 2 - List of corresponding attributes
		ArrayList<DrumAttribute> drumAttributes = new ArrayList<>();
		DrumAttribute da = new DrumAttribute(4,0,4,4,"percussion", 2);
		drumAttributes.add(da);
		drumAttributes.add(da);
		// 3 - additional meta info
		// The strings
		ArrayList<String> instruments = new ArrayList<>();
		instruments.add("C");
		instruments.add("HH");
		instruments.add("S");
		instruments.add("BD");
		
		/////////////////////////////
		// CONSTRUCTOR BEGINS HERE //
		/////////////////////////////
		
		// BASIC SEQUENCE OF THINGS TO DO
		
		// PREPROCESSING
		// decide which instruments are voice 1 and voice 2
		// make into 2 vertical static arrays called voice 1 and voice 2
		// EXTRACTING INFO
		// go through voice 1, and create the note objects
		// backup
		// go through voice 2, and create the note objects
		// repeat the process above for each measure
		
		// initialize lists
		this.tabStrings = new ArrayList<>();
		this.measures = new ArrayList<>();
		
		// setup the information for each string
		this.setDrumStringInfo(instruments);
				
		ArrayList<String> currentMeasure; // holds a single measure from the list of list of strings
		DrumAttribute currentAttribute; // hold a single attributes object
		String instrument; // holds the current string character

		DrumMeasure currentMeasureObject;
		//go through every measure
		for(int m = 0; m < exampleInput.size(); m++) {
			currentMeasure = exampleInput.get(m); // getting the measure
			currentAttribute = drumAttributes.get(m); // getting the attributes for the measure above
			int voice;
			
			//decide which instruments are voice 1 and voice 2
			ArrayList<String> voice1Lines = new ArrayList<>(); 
			ArrayList<String> voice2Lines = new ArrayList<>(); 
			ArrayList<DrumStringInfo> voice1StringsInfo = new ArrayList<>();
			ArrayList<DrumStringInfo> voice2StringsInfo = new ArrayList<>();
			// go through each measure preparing information
			for( int i = 0; i < currentMeasure.size(); i++) {
				instrument = instruments.get(i); // get instrument character
				voice = this.returnVoice(instrument); // figure out which voice it belongs to
				
				if(voice == 1) {
					voice1Lines.add(currentMeasure.get(i)); // if it belongs to voice 1, then put in voice one list
					voice1StringsInfo.add(this.tabStrings.get(i));
					System.out.println(i +">>>>" + currentMeasure.get(i));
				}
				else {
					voice2Lines.add(currentMeasure.get(i)); // otherwise put into voice two list
					voice2StringsInfo.add(this.tabStrings.get(i));
					System.out.println(i + ">>>>" + currentMeasure.get(i));
				}
			}			
			//make temporary vertical array for voice 1 and voice 2 both
			String[] verticalVoice1 = this.transpose(voice1Lines);
			String[] verticalVoice2 = this.transpose(voice2Lines);
			
			int measureNumber = (m+1);
			currentMeasureObject = new DrumMeasure(measureNumber); 
			// go through voice 1 and make notes for this measure
			this.setNotes(verticalVoice1, currentAttribute, voice1StringsInfo, currentMeasureObject);						
			//backup
			this.setBackup(currentAttribute.getBeats()*currentAttribute.getBeattype(), currentMeasureObject);
			// go through voice 2
			this.setNotes(verticalVoice2, currentAttribute, voice2StringsInfo, currentMeasureObject);		
			// append the measure into the list of global measures
			measures.add(currentMeasureObject);
		}			
					
		
		
		//TESTER METHOD FOR THE PROCESS ABOVE		
		System.out.println("\nPARSED INFORMATION BELOW \n");
		for(int i = 0; i < measures.size(); i++ ) {
			System.out.println(measures.get(i)+"\n");
		}
		//there seems to be incorrect information with regards to the duration (and type since it is dependent)
		// extra measure object is created but need not be used
		// Things are working for the most part :)
		
		System.out.println(this.getDrumTabStrings().toString());
		
	} // END OF CONSTRUCTOR
	
	private ArrayList<DrumStringInfo> getDrumTabStrings() {
		return this.tabStrings;
	}

	private void setBackup(int duration, DrumMeasure currentMeasureObject) {
		currentMeasureObject.addNote(new DrumNote(duration)); 
	}
	
	
	private void setNotes (String[] tab, DrumAttribute da, ArrayList<DrumStringInfo> dsi, DrumMeasure current) {
		int beat = da.getBeats(); int beattype = da.getBeattype(); // some default declarations for now
		int p = 0;
			
		for(int i = 0; i < tab.length;  i++) {
			String pruneBars = tab[i].replaceAll("\\|", "");
			String pruneDash  = tab[i].replaceAll("\\-", "");
			System.out.println("PRUNED:" + pruneBars + " ~ " + pruneDash);
			if( pruneBars.length()==0) // skip the whole process because we are at the the vertical barlines				
				; // DO NOTHING
			
			// else if you are at a beat multiple spot and if no note exists here, make a rest note
			else if( p%beat == 0 && pruneDash.length()==0) {
				//look ahead to get duration
				int duration = 1;
				for(int j = 1;j <= beat; j++) {
					String pruneDash2 = tab[i+j].replaceAll("\\-", "");
					if(pruneDash2.length() == 0)		
						duration++;
					else								
						break;
				}
				// create rest note, parameters are stringInfo duration voice beat beattype 
				current.addNote(new DrumNote(dsi.get(0),duration, beat, beattype));
			}
			// you are at a non-beat-multiple spot
			// note exists here, make an unpitched note
			else {
				//look ahead to get duration
				int duration = 1;
				for(int j = 1;j <= beat; j++) {
					String pruneDash2  = tab[i].replaceAll("\\-", "");
					if( (p+j)%beat != 0 && pruneDash2.length()==0) // the columns ahead must be empty and not a beat multiple column
						duration++;
					else
						break;
				}
				// loop to make notes for every element in the column
				boolean chord = false;
				for(int j = 0; j < tab[i].length(); j++ ) {
					//if a note exists at that spot make a note
					if(tab[i].charAt(j) != '-') {
						// create unpitched note, parameters are stringInfo ,duration, voice, beat,beattype and whether its a chord or not
						String notehead = ""+tab[i].charAt(j);
						current.addNote(new DrumNote(dsi.get(j),duration,notehead, beat, beattype, chord));
						chord = true;
					}

				}
			}
			// move up in reading the tab lines
			p++;
		}
	}
	
	private void setDrumStringInfo( ArrayList<String> instruments) throws Exception {
		for(String s: instruments)
			tabStrings.add(new DrumStringInfo(s));
	}
	
	/**
	 * Transposes a given measure for pre-processing in the constructor
	 * Not meant for use elsewhere
	 * @param currentMeasure
	 * @return
	 */
	private String[] transpose (ArrayList<String> currentMeasure) {
		String[] vertical = new String[0];
		if(currentMeasure.size() < 1) return vertical; // error handling if the currentmeasure is empty
		
		vertical = new String[currentMeasure.get(0).length()];
		for(int i = 0; i < currentMeasure.get(0).length(); i++) {
			String col = "";
			for(int j = 0; j < currentMeasure.size(); j++ )
				col = col + currentMeasure.get(j).charAt(i);
			vertical[i] = col;
		}
		// if you would like to view the output yourself, uncomment below
		System.out.println("\nTRANSPOSED ARRAY BELOW \n");
		for(int i = 0; i < vertical.length; i++)
			System.out.println(vertical[i]);
		return vertical;
	}
	
	/**
	 * This method will return whether the passed instrument belongs to voice 1 or voice 2
	 * @param instrumentInitials
	 * @return
	 */
	private int returnVoice( String instrumentInitials) {
		switch(instrumentInitials) {
		case "C": return 1;
		case "HH": return 1;
		case "S": return 1;
		case "BD": return 2;
		default: return 1;
		}
	}

}

class DrumAttribute{
	
	public int getDivisions() {return divisions;}
	public int getFifths() {return fifths;}
	public int getBeats() {return beats;}
	public int getBeattype() {return beattype;}
	public String getSign() {return sign;}
	public int getLine() {return line;}

	// perhaps set default values
	int divisions = 4;
	int fifths = 0;
	int beats = 4;
	int beattype = 4;
	String sign = "percussion";
	int line = 2;
	
	public DrumAttribute( int d, int f, int b, int bt, String s, int l) {
		this.divisions = d;
		this.fifths = f;
		this.beats = b;
		this.beattype = bt;
		this.sign = s;
		this.line = l;
	}
}

class DrumStringInfo{
	//gets the information of the instrument given its symbol on the tab line
	//name, id, step, octave, stem
	String name, id, step, octave, stem, notehead, voice; // i have realized the notehad property is incorrect? perhaps not dunno
	
	public DrumStringInfo(String symbol) throws Exception {			
	
	switch(symbol) {
		
		case "BD":
			name = "Bass Drum 1";
			id = "P1-I36";
			step = "F";
			octave = "4";
			stem = "down";	
			notehead = "o";
			voice = "2";
			break;
			
		case "C":
			name = "Crash Cymbal";
			id = "P1-I50";
			step = "A";
			octave = "5";
			stem = "up";			
			notehead = "x";
			voice = "1";
			break;
			
		case "S":
			name = "Snare";
			id = "P1-I39";
			step = "C";
			octave = "5";
			stem = "up";		
			notehead = "o";
			voice = "1";
			break;
			
		case "HH":
			name = "Closed Hi-Hat"; // High hat in doc
			id = "P1-I43";
			step = "G";
			octave = "5";
			stem = "up";		
			notehead = "x";
			voice = "1";
			break;
		
		// Ask Billy for advice when uncommenting the instruments below
			
//		case "B2":
//			name = "Bass Drum 2";
//			id = "P1-I37";
//			step = "";
//			octave = "";
//			stem = "";		
//			notehead = "";
//			break;
//		case "SS":
//			name = "Side Stick";
//			id = "P1-I38";
//			step = "";
//			octave = "";
//			stem = "";		
//			notehead = "";
//			break;
//		case "LFT":
//			name = "Low Floor Tom";
//			id = "P1-I42";
//			step = "";
//			octave = "";
//			stem = "";		
//			notehead = "";
//			break;
//		case "HFT":
//			name = "High Floor Tom";
//			id = "P1-I44";
//			step = "";
//			octave = "";
//			stem = "";		
//			notehead = "";
//			break;
//		case "PHH":
//			name = "Pedal Hi-Hat";
//			id = "P1-I45";
//			step = "";
//			octave = "";
//			stem = "";		
//			notehead = "";
//			break;
		case "LT":
			name = "Low Tom";
			id = "P1-146";
			step = "D";
			octave = "5";
			stem = "up";		
			notehead = "x";
			voice = "1";
			break;
//		case "OHH":
//			name = "Open Hi-Hat";
//			id = "P1-I47";
//			step = "";
//			octave = "";
//			stem = "";
//			notehead = "";
//			break;
		case "MT":
			name = "Low-Mid Tom";
			id = "P1-I48";
			step = "E";
			octave = "5";
			stem = "up";			
			notehead = "x";
			voice = "1";
			break;
//		case "HMT":
//			name = "Hi-Mid Tom";
//			id = "P1-I49";
//			step = "";
//			octave = "";
//			stem = "";			
//			notehead = "";
//			break;
//		case "HT":
//			name = "High Tom";
//			id = "P1-I51";
//			step = "";
//			octave = "";
//			stem = "";			
//			notehead = "";
//			break;
//		case "RC":
//			name = "Ride Cymbal";
//			id = "P1-I52";
//			step = "";
//			octave = "";
//			stem = "";			
//			notehead = "";
//			break;
//		case "CC":
//			name = "Chinese Cymbal";
//			id = "P1-I53";
//			step = "";
//			octave = "";
//			stem = "";
//			notehead = "";
//			break;
//		case "RB":
//			name = "Ride Bell";
//			id = "P1-I54";
//			step = "";
//			octave = "";
//			stem = "";			
//			notehead = "";
//			break;			
//		case "T":
//			name = "Tambourine";
//			id = "P1-I54";
//			step = "";
//			octave = "";
//			stem = "";			
//			notehead = "";
//			break;			
//		case "SC":
//			name = "Splash Cymbal";
//			id = "P1-I56";
//			step = "";
//			octave = "";
//			stem = "";			
//			notehead = "";
//			break;		
//		case "CB":
//			name = "Cowbell";
//			id = "P1-I57";
//			step = "";
//			octave = "";
//			stem = "";
//			notehead = "";
//			break;			
//		case "C2":
//			name = "Crash Cymbal 2";
//			id = "P1-I58";
//			step = "";
//			octave = "";
//			stem = "";			
//			notehead = "";
//			break;
//		case "R2":
//			name = "Ride Cymbal 2";
//			id = "P1-I60";
//			step = "";
//			octave = "";
//			stem = "";
//			notehead = "";
//			break;
//		case "OHC":
//			name = "Open Hi Conga";
//			id = "P1-I64";
//			step = "";
//			octave = "";
//			stem = "";			
//			notehead = "";
//			break;
//		case "LC":
//			name = "Low Conga";
//			id = "P1-I64";
//			step = "";
//			octave = "";
//			stem = "";
//			notehead = "";
//			break;
					
		default:
			throw new Exception("Unrecognizable Instrument");
			//throw some incorrect stuff exception later
//			name = "Closed Hi-Hat"; // High hat in doc
//			id = "P1-I43";
//			step = "G";
//			octave = "5";
//			stem = "up";		
//			notehead = "x";
			// the values above are just default to prevent crashing
	}
		
	}
	
	public String getInstrumentName() {return this.name;}
	public String getInstrumentId() {return id;}
	public String getDisplayStep() {return step;}
	public String getDisplayOctave() {return octave;}
	public String getStem() {return stem;}
	public String getNotehead() {return notehead;}		
	public String getVoice() {return voice;}

}

//|||||||||||||||||||||| MEASURE CLASS |||||||||||||||||||||||||||
class DrumMeasure{
	int measureNumber;
	ArrayList<DrumNote> notes = new ArrayList<DrumNote>();
	public DrumMeasure(int measureNumber) {
		this.measureNumber = measureNumber;
	}
	public void addNote(DrumNote note) {
		this.notes.add(note);
	}
	public ArrayList<DrumNote> getNotes(){
		return notes;
	}
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Measure: " + measureNumber + "\n" );
		for(DrumNote n: notes)
			sb.append(n + "\n");
		return sb.toString();
	}
}


class DrumNote {
	String unpitchedOrRestOrBackup = null;
	String displayStep = null;
	String displayOctave = null;
	int duration = 0;
	String instrumentID = null;
	String voice = "1";
	String type = null;
	String stem = null;
	String notehead = null;
	boolean chord = false;
	
	// constructor for the backup note ( backup is not really a note, but we treat it as one for simplicity )
	public DrumNote(int duration) {
		this.unpitchedOrRestOrBackup = "backup";
		this.duration = duration;
	}
	
	//constructor for rest note
	public DrumNote(DrumStringInfo stringInfo, int duration, int beat, int beattype) {
		this.unpitchedOrRestOrBackup = "rest";
		this.duration = duration;
		this.voice = stringInfo.getVoice();  // hardcoded to 2 for now, but it should be determined
		this.type = getType(beat*beattype/duration);
	}
	
	//constructor for unpitched note
	public DrumNote(DrumStringInfo stringInfo , int duration, String notehead, int beat, int beattype, boolean chord ){
		this.unpitchedOrRestOrBackup = "unpitched";
		this.displayOctave = stringInfo.getDisplayOctave();
		this.displayStep = stringInfo.getDisplayStep();
		this.instrumentID = stringInfo.getInstrumentId();
		this.duration = duration;
		this.voice = stringInfo.getVoice();
		this.type = getType(beat*beattype/duration);
		this.stem = stringInfo.getStem();
		this.notehead = notehead; //stringInfo.getNotehead();
		this.chord = chord;
	}	
	private String getType(int val) {
		if( val <= 1)
			return "whole";
		else if(val <= 2 )
			return "half";
		else if( val <= 4)
			return "quarter";
		else if ( val <= 8)
			return "eighth";
		else if (val <= 16)
			return "16th";
		else if ( val <= 32)
			return "32nd";
		else if (val <= 64)
			return "64th";
		else 
			return "128th";
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Unpitched or Rest: " + this.unpitchedOrRestOrBackup);
		sb.append(", Display-Step: " + this.displayStep);
		sb.append(", Display-Octave: " + this.displayOctave);
		sb.append(", Duration: " + this.duration);
		sb.append(", Instrument ID: " + this.instrumentID);
		sb.append(", Voice: " + this.voice);
		sb.append(", Type: " + this.type);
		sb.append(", Stem: " + this.stem);
		sb.append(", Notehead: " + this.notehead);
		sb.append(", Chord: " + this.chord);
		return sb.toString();
	}
	
	public String getUnpitchedOrRest() {return unpitchedOrRestOrBackup;}
	public String getDisplayStep() {return displayStep;}
	public String getDisplayOctave() {return displayOctave;}
	public int getDuration() {return duration;}
	public String getInstrumentID() {return instrumentID;}
	public String getVoice() {	return voice;}
	public String getType() {return type;}
	public String getStem() {return stem;}
	public String getNotehead() {return notehead;}
	public boolean getChord() {	return chord;}
	
	
}