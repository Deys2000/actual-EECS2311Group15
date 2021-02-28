//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.02.25 at 11:44:40 AM EST 
//


package musicXML;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element ref="{}identification"/&gt;
 *         &lt;element ref="{}part-name"/&gt;
 *         &lt;element ref="{}part-name-display"/&gt;
 *         &lt;element ref="{}part-abbreviation"/&gt;
 *         &lt;element ref="{}part-abbreviation-display"/&gt;
 *         &lt;element ref="{}group"/&gt;
 *         &lt;element ref="{}score-instrument"/&gt;
 *         &lt;element ref="{}midi-device"/&gt;
 *         &lt;element ref="{}midi-instrument"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "identification",
    "partName",
    "partNameDisplay",
    "partAbbreviation",
    "partAbbreviationDisplay",
    "group",
    "scoreInstruments",
    "midiDevice",
    "midiInstrument"
})
@XmlRootElement(name = "score-part")
public class ScorePart {

    @XmlElement(required = true)
    protected Identification identification;
    @XmlElement(name = "part-name", required = true)
    protected PartName partName;
    @XmlElement(name = "part-name-display", required = true)
    protected PartNameDisplay partNameDisplay;
    @XmlElement(name = "part-abbreviation", required = true)
    protected PartAbbreviation partAbbreviation;
    @XmlElement(name = "part-abbreviation-display", required = true)
    protected PartAbbreviationDisplay partAbbreviationDisplay;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected java.lang.String group;
    @XmlElement(name = "score-instrument", required = true)
    protected ArrayList<ScoreInstrument> scoreInstruments;
    @XmlElement(name = "midi-device", required = true)
    protected MidiDevice midiDevice;
    @XmlElement(name = "midi-instrument", required = true)
    protected MidiInstrument midiInstrument;
    @XmlAttribute(name = "id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected java.lang.String id;



    public ScorePart(){}
    public ScorePart(java.lang.String id, java.lang.String partname)
    {
        this.id = id;
        this.partName = new PartName(partname);
    }
    /**
     * Gets the value of the identification property.
     * 
     * @return
     *     possible object is
     *     {@link Identification }
     *     
     */
    public Identification getIdentification() {
        return identification;
    }

    /**
     * Sets the value of the identification property.
     * 
     * @param value
     *     allowed object is
     *     {@link Identification }
     *     
     */
    public void setIdentification(Identification value) {
        this.identification = value;
    }

    /**
     * Gets the value of the partName property.
     * 
     * @return
     *     possible object is
     *     {@link PartName }
     *     
     */
    public PartName getPartName() {
        return partName;
    }

    /**
     * Sets the value of the partName property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartName }
     *     
     */
    public void setPartName(PartName value) {
        this.partName = value;
    }

    /**
     * Gets the value of the partNameDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link PartNameDisplay }
     *     
     */
    public PartNameDisplay getPartNameDisplay() {
        return partNameDisplay;
    }

    /**
     * Sets the value of the partNameDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartNameDisplay }
     *     
     */
    public void setPartNameDisplay(PartNameDisplay value) {
        this.partNameDisplay = value;
    }

    /**
     * Gets the value of the partAbbreviation property.
     * 
     * @return
     *     possible object is
     *     {@link PartAbbreviation }
     *     
     */
    public PartAbbreviation getPartAbbreviation() {
        return partAbbreviation;
    }

    /**
     * Sets the value of the partAbbreviation property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartAbbreviation }
     *     
     */
    public void setPartAbbreviation(PartAbbreviation value) {
        this.partAbbreviation = value;
    }

    /**
     * Gets the value of the partAbbreviationDisplay property.
     * 
     * @return
     *     possible object is
     *     {@link PartAbbreviationDisplay }
     *     
     */
    public PartAbbreviationDisplay getPartAbbreviationDisplay() {
        return partAbbreviationDisplay;
    }

    /**
     * Sets the value of the partAbbreviationDisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartAbbreviationDisplay }
     *     
     */
    public void setPartAbbreviationDisplay(PartAbbreviationDisplay value) {
        this.partAbbreviationDisplay = value;
    }

    /**
     * Gets the value of the group property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getGroup() {
        return group;
    }

    /**
     * Sets the value of the group property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setGroup(java.lang.String value) {
        this.group = value;
    }

    /**
     * Gets the value of the scoreInstrument property.
     * 
     * @return
     *     possible object is
     *     {@link ScoreInstrument }
     *     
     */
    public ScoreInstrument getScoreInstrument(int i) {
        return scoreInstruments.get(i);
    }

    /**
     * Sets the value of the scoreInstrument property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScoreInstrument }
     *     
     */
//    public void setScoreInstrument(ScoreInstrument value) {
//        this.scoreInstrumentX = value;
//    }
    public void addScoreInstrument(ScoreInstrument si) {
    	this.scoreInstruments.add(si);
    }

    /**
     * Gets the value of the midiDevice property.
     * 
     * @return
     *     possible object is
     *     {@link MidiDevice }
     *     
     */
    public MidiDevice getMidiDevice() {
        return midiDevice;
    }

    /**
     * Sets the value of the midiDevice property.
     * 
     * @param value
     *     allowed object is
     *     {@link MidiDevice }
     *     
     */
    public void setMidiDevice(MidiDevice value) {
        this.midiDevice = value;
    }

    /**
     * Gets the value of the midiInstrument property.
     * 
     * @return
     *     possible object is
     *     {@link MidiInstrument }
     *     
     */
    public MidiInstrument getMidiInstrument() {
        return midiInstrument;
    }

    /**
     * Sets the value of the midiInstrument property.
     * 
     * @param value
     *     allowed object is
     *     {@link MidiInstrument }
     *     
     */
    public void setMidiInstrument(MidiInstrument value) {
        this.midiInstrument = value;
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

}
