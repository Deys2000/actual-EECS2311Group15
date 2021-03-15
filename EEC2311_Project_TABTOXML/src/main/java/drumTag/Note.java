//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.02.25 at 11:44:40 AM EST 
//


package drumTag;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{}grace"/&gt;
 *         &lt;choice maxOccurs="unbounded"&gt;
 *           &lt;element ref="{}duration"/&gt;
 *           &lt;element ref="{}chord"/&gt;
 *           &lt;element ref="{}cue"/&gt;
 *           &lt;element ref="{}pitch"/&gt;
 *           &lt;element ref="{}rest"/&gt;
 *           &lt;element ref="{}tie"/&gt;
 *           &lt;element ref="{}unpitched"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element ref="{}instrument"/&gt;
 *         &lt;element ref="{}footnote"/&gt;
 *         &lt;element ref="{}level"/&gt;
 *         &lt;element ref="{}voice"/&gt;
 *         &lt;element ref="{}type"/&gt;
 *         &lt;element ref="{}dot"/&gt;
 *         &lt;element ref="{}accidental"/&gt;
 *         &lt;element ref="{}time-modification"/&gt;
 *         &lt;element ref="{}stem"/&gt;
 *         &lt;element ref="{}notehead"/&gt;
 *         &lt;element ref="{}notehead-text"/&gt;
 *         &lt;element ref="{}staff"/&gt;
 *         &lt;element ref="{}beam"/&gt;
 *         &lt;element ref="{}notations"/&gt;
 *         &lt;element ref="{}lyric"/&gt;
 *         &lt;element ref="{}play"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="attack" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" /&gt;
 *       &lt;attribute name="color" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="default-x" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" /&gt;
 *       &lt;attribute name="default-y" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" /&gt;
 *       &lt;attribute name="dynamics" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" /&gt;
 *       &lt;attribute name="end-dynamics" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" /&gt;
 *       &lt;attribute name="font-family" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="font-size" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="font-style" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="font-weight" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="pizzicato" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="print-dot" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="print-leger" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="print-lyric" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="print-object" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="print-spacing" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="relative-x" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" /&gt;
 *       &lt;attribute name="relative-y" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" /&gt;
 *       &lt;attribute name="release" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" /&gt;
 *       &lt;attribute name="time-only" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "grace",
    "durationOrChordOrCue",
    "instrument",
    "footnote",
    "level",
    "voice",
    "type",
    "dot",
    "accidental",
    "timeModification",
    "stem",
    "notehead",
    "noteheadText",
    "staff",
    "beam",
    "notations",
    "lyric",
    "play"
})
@XmlRootElement(name = "note")
public class Note {

    @XmlElement(required = true)
    protected Grace grace;
    @XmlElements({
        @XmlElement(name = "duration", type = BigDecimal.class),
        @XmlElement(name = "chord", type = Chord.class),
        @XmlElement(name = "cue", type = Cue.class),
        @XmlElement(name = "pitch", type = Pitch.class),
        @XmlElement(name = "rest", type = Rest.class),
        @XmlElement(name = "tie", type = Tie.class),
        @XmlElement(name = "unpitched", type = Unpitched.class)
    })
    protected List<Object> durationOrChordOrCue;
    @XmlElement(required = true)
    protected Instrument instrument;
    @XmlElement(required = true)
    protected Footnote footnote;
    @XmlElement(required = true)
    protected Level level;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected java.lang.String voice;
    @XmlElement(required = true)
    protected Type type;
    @XmlElement(required = true)
    protected Dot dot;
    @XmlElement(required = true)
    protected Accidental accidental;
    @XmlElement(name = "time-modification", required = true)
    protected TimeModification timeModification;
    @XmlElement(required = true)
    protected Stem stem;
    @XmlElement(required = true)
    protected Notehead notehead;
    @XmlElement(name = "notehead-text", required = true)
    protected NoteheadText noteheadText;
    @XmlElement(required = true)
    protected BigInteger staff;
    @XmlElement(required = true)
    protected Beam beam;
    @XmlElement(required = true)
    protected Notations notations;
    @XmlElement(required = true)
    protected Lyric lyric;
    @XmlElement(required = true)
    protected Play play;
    @XmlAttribute(name = "attack", required = true)
    protected BigDecimal attack;
    @XmlAttribute(name = "color", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected java.lang.String color;
    @XmlAttribute(name = "default-x", required = true)
    protected BigDecimal defaultX;
    @XmlAttribute(name = "default-y", required = true)
    protected BigDecimal defaultY;
    @XmlAttribute(name = "dynamics", required = true)
    protected BigDecimal dynamics;
    @XmlAttribute(name = "end-dynamics", required = true)
    protected BigDecimal endDynamics;
    @XmlAttribute(name = "font-family", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected java.lang.String fontFamily;
    @XmlAttribute(name = "font-size", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected java.lang.String fontSize;
    @XmlAttribute(name = "font-style", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected java.lang.String fontStyle;
    @XmlAttribute(name = "font-weight", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected java.lang.String fontWeight;
    @XmlAttribute(name = "id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected java.lang.String id;
    @XmlAttribute(name = "pizzicato", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected java.lang.String pizzicato;
    @XmlAttribute(name = "print-dot", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected java.lang.String printDot;
    @XmlAttribute(name = "print-leger", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected java.lang.String printLeger;
    @XmlAttribute(name = "print-lyric", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected java.lang.String printLyric;
    @XmlAttribute(name = "print-object", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected java.lang.String printObject;
    @XmlAttribute(name = "print-spacing", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected java.lang.String printSpacing;
    @XmlAttribute(name = "relative-x", required = true)
    protected BigDecimal relativeX;
    @XmlAttribute(name = "relative-y", required = true)
    protected BigDecimal relativeY;
    @XmlAttribute(name = "release", required = true)
    protected BigDecimal release;
    @XmlAttribute(name = "time-only", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected java.lang.String timeOnly;

    /**
     * Gets the value of the grace property.
     * 
     * @return
     *     possible object is
     *     {@link Grace }
     *     
     */
    public Grace getGrace() {
        return grace;
    }

    /**
     * Sets the value of the grace property.
     * 
     * @param value
     *     allowed object is
     *     {@link Grace }
     *     
     */
    public void setGrace(Grace value) {
        this.grace = value;
    }

    /**
     * Gets the value of the durationOrChordOrCue property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the durationOrChordOrCue property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDurationOrChordOrCue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BigDecimal }
     * {@link Chord }
     * {@link Cue }
     * {@link Pitch }
     * {@link Rest }
     * {@link Tie }
     * {@link Unpitched }
     * 
     * 
     */
    public List<Object> getDurationOrChordOrCue() {
        if (durationOrChordOrCue == null) {
            durationOrChordOrCue = new ArrayList<Object>();
        }
        return this.durationOrChordOrCue;
    }

    /**
     * Gets the value of the instrument property.
     * 
     * @return
     *     possible object is
     *     {@link Instrument }
     *     
     */
    public Instrument getInstrument() {
        return instrument;
    }

    /**
     * Sets the value of the instrument property.
     * 
     * @param value
     *     allowed object is
     *     {@link Instrument }
     *     
     */
    public void setInstrument(Instrument value) {
        this.instrument = value;
    }

    /**
     * Gets the value of the footnote property.
     * 
     * @return
     *     possible object is
     *     {@link Footnote }
     *     
     */
    public Footnote getFootnote() {
        return footnote;
    }

    /**
     * Sets the value of the footnote property.
     * 
     * @param value
     *     allowed object is
     *     {@link Footnote }
     *     
     */
    public void setFootnote(Footnote value) {
        this.footnote = value;
    }

    /**
     * Gets the value of the level property.
     * 
     * @return
     *     possible object is
     *     {@link Level }
     *     
     */
    public Level getLevel() {
        return level;
    }

    /**
     * Sets the value of the level property.
     * 
     * @param value
     *     allowed object is
     *     {@link Level }
     *     
     */
    public void setLevel(Level value) {
        this.level = value;
    }

    /**
     * Gets the value of the voice property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getVoice() {
        return voice;
    }

    /**
     * Sets the value of the voice property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setVoice(java.lang.String value) {
        this.voice = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link Type }
     *     
     */
    public Type getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link Type }
     *     
     */
    public void setType(Type value) {
        this.type = value;
    }

    /**
     * Gets the value of the dot property.
     * 
     * @return
     *     possible object is
     *     {@link Dot }
     *     
     */
    public Dot getDot() {
        return dot;
    }

    /**
     * Sets the value of the dot property.
     * 
     * @param value
     *     allowed object is
     *     {@link Dot }
     *     
     */
    public void setDot(Dot value) {
        this.dot = value;
    }

    /**
     * Gets the value of the accidental property.
     * 
     * @return
     *     possible object is
     *     {@link Accidental }
     *     
     */
    public Accidental getAccidental() {
        return accidental;
    }

    /**
     * Sets the value of the accidental property.
     * 
     * @param value
     *     allowed object is
     *     {@link Accidental }
     *     
     */
    public void setAccidental(Accidental value) {
        this.accidental = value;
    }

    /**
     * Gets the value of the timeModification property.
     * 
     * @return
     *     possible object is
     *     {@link TimeModification }
     *     
     */
    public TimeModification getTimeModification() {
        return timeModification;
    }

    /**
     * Sets the value of the timeModification property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeModification }
     *     
     */
    public void setTimeModification(TimeModification value) {
        this.timeModification = value;
    }

    /**
     * Gets the value of the stem property.
     * 
     * @return
     *     possible object is
     *     {@link Stem }
     *     
     */
    public Stem getStem() {
        return stem;
    }

    /**
     * Sets the value of the stem property.
     * 
     * @param value
     *     allowed object is
     *     {@link Stem }
     *     
     */
    public void setStem(Stem value) {
        this.stem = value;
    }

    /**
     * Gets the value of the notehead property.
     * 
     * @return
     *     possible object is
     *     {@link Notehead }
     *     
     */
    public Notehead getNotehead() {
        return notehead;
    }

    /**
     * Sets the value of the notehead property.
     * 
     * @param value
     *     allowed object is
     *     {@link Notehead }
     *     
     */
    public void setNotehead(Notehead value) {
        this.notehead = value;
    }

    /**
     * Gets the value of the noteheadText property.
     * 
     * @return
     *     possible object is
     *     {@link NoteheadText }
     *     
     */
    public NoteheadText getNoteheadText() {
        return noteheadText;
    }

    /**
     * Sets the value of the noteheadText property.
     * 
     * @param value
     *     allowed object is
     *     {@link NoteheadText }
     *     
     */
    public void setNoteheadText(NoteheadText value) {
        this.noteheadText = value;
    }

    /**
     * Gets the value of the staff property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getStaff() {
        return staff;
    }

    /**
     * Sets the value of the staff property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setStaff(BigInteger value) {
        this.staff = value;
    }

    /**
     * Gets the value of the beam property.
     * 
     * @return
     *     possible object is
     *     {@link Beam }
     *     
     */
    public Beam getBeam() {
        return beam;
    }

    /**
     * Sets the value of the beam property.
     * 
     * @param value
     *     allowed object is
     *     {@link Beam }
     *     
     */
    public void setBeam(Beam value) {
        this.beam = value;
    }

    /**
     * Gets the value of the notations property.
     * 
     * @return
     *     possible object is
     *     {@link Notations }
     *     
     */
    public Notations getNotations() {
        return notations;
    }

    /**
     * Sets the value of the notations property.
     * 
     * @param value
     *     allowed object is
     *     {@link Notations }
     *     
     */
    public void setNotations(Notations value) {
        this.notations = value;
    }

    /**
     * Gets the value of the lyric property.
     * 
     * @return
     *     possible object is
     *     {@link Lyric }
     *     
     */
    public Lyric getLyric() {
        return lyric;
    }

    /**
     * Sets the value of the lyric property.
     * 
     * @param value
     *     allowed object is
     *     {@link Lyric }
     *     
     */
    public void setLyric(Lyric value) {
        this.lyric = value;
    }

    /**
     * Gets the value of the play property.
     * 
     * @return
     *     possible object is
     *     {@link Play }
     *     
     */
    public Play getPlay() {
        return play;
    }

    /**
     * Sets the value of the play property.
     * 
     * @param value
     *     allowed object is
     *     {@link Play }
     *     
     */
    public void setPlay(Play value) {
        this.play = value;
    }

    /**
     * Gets the value of the attack property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAttack() {
        return attack;
    }

    /**
     * Sets the value of the attack property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAttack(BigDecimal value) {
        this.attack = value;
    }

    /**
     * Gets the value of the color property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getColor() {
        return color;
    }

    /**
     * Sets the value of the color property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setColor(java.lang.String value) {
        this.color = value;
    }

    /**
     * Gets the value of the defaultX property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDefaultX() {
        return defaultX;
    }

    /**
     * Sets the value of the defaultX property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDefaultX(BigDecimal value) {
        this.defaultX = value;
    }

    /**
     * Gets the value of the defaultY property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDefaultY() {
        return defaultY;
    }

    /**
     * Sets the value of the defaultY property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDefaultY(BigDecimal value) {
        this.defaultY = value;
    }

    /**
     * Gets the value of the dynamics property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDynamics() {
        return dynamics;
    }

    /**
     * Sets the value of the dynamics property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDynamics(BigDecimal value) {
        this.dynamics = value;
    }

    /**
     * Gets the value of the endDynamics property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getEndDynamics() {
        return endDynamics;
    }

    /**
     * Sets the value of the endDynamics property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setEndDynamics(BigDecimal value) {
        this.endDynamics = value;
    }

    /**
     * Gets the value of the fontFamily property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getFontFamily() {
        return fontFamily;
    }

    /**
     * Sets the value of the fontFamily property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setFontFamily(java.lang.String value) {
        this.fontFamily = value;
    }

    /**
     * Gets the value of the fontSize property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getFontSize() {
        return fontSize;
    }

    /**
     * Sets the value of the fontSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setFontSize(java.lang.String value) {
        this.fontSize = value;
    }

    /**
     * Gets the value of the fontStyle property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getFontStyle() {
        return fontStyle;
    }

    /**
     * Sets the value of the fontStyle property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setFontStyle(java.lang.String value) {
        this.fontStyle = value;
    }

    /**
     * Gets the value of the fontWeight property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getFontWeight() {
        return fontWeight;
    }

    /**
     * Sets the value of the fontWeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setFontWeight(java.lang.String value) {
        this.fontWeight = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setId(java.lang.String value) {
        this.id = value;
    }

    /**
     * Gets the value of the pizzicato property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getPizzicato() {
        return pizzicato;
    }

    /**
     * Sets the value of the pizzicato property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setPizzicato(java.lang.String value) {
        this.pizzicato = value;
    }

    /**
     * Gets the value of the printDot property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getPrintDot() {
        return printDot;
    }

    /**
     * Sets the value of the printDot property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setPrintDot(java.lang.String value) {
        this.printDot = value;
    }

    /**
     * Gets the value of the printLeger property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getPrintLeger() {
        return printLeger;
    }

    /**
     * Sets the value of the printLeger property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setPrintLeger(java.lang.String value) {
        this.printLeger = value;
    }

    /**
     * Gets the value of the printLyric property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getPrintLyric() {
        return printLyric;
    }

    /**
     * Sets the value of the printLyric property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setPrintLyric(java.lang.String value) {
        this.printLyric = value;
    }

    /**
     * Gets the value of the printObject property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getPrintObject() {
        return printObject;
    }

    /**
     * Sets the value of the printObject property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setPrintObject(java.lang.String value) {
        this.printObject = value;
    }

    /**
     * Gets the value of the printSpacing property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getPrintSpacing() {
        return printSpacing;
    }

    /**
     * Sets the value of the printSpacing property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setPrintSpacing(java.lang.String value) {
        this.printSpacing = value;
    }

    /**
     * Gets the value of the relativeX property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRelativeX() {
        return relativeX;
    }

    /**
     * Sets the value of the relativeX property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRelativeX(BigDecimal value) {
        this.relativeX = value;
    }

    /**
     * Gets the value of the relativeY property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRelativeY() {
        return relativeY;
    }

    /**
     * Sets the value of the relativeY property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRelativeY(BigDecimal value) {
        this.relativeY = value;
    }

    /**
     * Gets the value of the release property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRelease() {
        return release;
    }

    /**
     * Sets the value of the release property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRelease(BigDecimal value) {
        this.release = value;
    }

    /**
     * Gets the value of the timeOnly property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getTimeOnly() {
        return timeOnly;
    }

    /**
     * Sets the value of the timeOnly property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setTimeOnly(java.lang.String value) {
        this.timeOnly = value;
    }

}
