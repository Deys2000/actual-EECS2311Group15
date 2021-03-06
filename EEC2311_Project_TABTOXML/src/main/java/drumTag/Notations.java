//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.02.25 at 11:44:40 AM EST 
//


package drumTag;

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
 *         &lt;element ref="{}footnote"/&gt;
 *         &lt;element ref="{}level"/&gt;
 *         &lt;element ref="{}tied"/&gt;
 *         &lt;element ref="{}slur"/&gt;
 *         &lt;element ref="{}tuplet"/&gt;
 *         &lt;element ref="{}glissando"/&gt;
 *         &lt;element ref="{}slide"/&gt;
 *         &lt;element ref="{}ornaments"/&gt;
 *         &lt;element ref="{}technical"/&gt;
 *         &lt;element ref="{}articulations"/&gt;
 *         &lt;element ref="{}dynamics"/&gt;
 *         &lt;element ref="{}fermata"/&gt;
 *         &lt;element ref="{}arpeggiate"/&gt;
 *         &lt;element ref="{}non-arpeggiate"/&gt;
 *         &lt;element ref="{}accidental-mark"/&gt;
 *         &lt;element ref="{}other-notation"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="print-object" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "footnote",
    "level",
    "tied",
    "slur",
    "tuplet",
    "glissando",
    "slide",
    "ornaments",
    "technical",
    "articulations",
    "dynamics",
    "fermata",
    "arpeggiate",
    "nonArpeggiate",
    "accidentalMark",
    "otherNotation"
})
@XmlRootElement(name = "notations")
public class Notations {

    @XmlElement(required = true)
    protected Footnote footnote;
    @XmlElement(required = true)
    protected Level level;
    @XmlElement(required = true)
    protected Tied tied;
    @XmlElement(required = true)
    protected Slur slur;
    @XmlElement(required = true)
    protected Tuplet tuplet;
    @XmlElement(required = true)
    protected Glissando glissando;
    @XmlElement(required = true)
    protected Slide slide;
    @XmlElement(required = true)
    protected Ornaments ornaments;
    @XmlElement(required = true)
    protected Technical technical;
    @XmlElement(required = true)
    protected Articulations articulations;
    @XmlElement(required = true)
    protected Dynamics dynamics;
    @XmlElement(required = true)
    protected Fermata fermata;
    @XmlElement(required = true)
    protected Arpeggiate arpeggiate;
    @XmlElement(name = "non-arpeggiate", required = true)
    protected NonArpeggiate nonArpeggiate;
    @XmlElement(name = "accidental-mark", required = true)
    protected AccidentalMark accidentalMark;
    @XmlElement(name = "other-notation", required = true)
    protected OtherNotation otherNotation;
    @XmlAttribute(name = "id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected java.lang.String id;
    @XmlAttribute(name = "print-object", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected java.lang.String printObject;

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
     * Gets the value of the tied property.
     * 
     * @return
     *     possible object is
     *     {@link Tied }
     *     
     */
    public Tied getTied() {
        return tied;
    }

    /**
     * Sets the value of the tied property.
     * 
     * @param value
     *     allowed object is
     *     {@link Tied }
     *     
     */
    public void setTied(Tied value) {
        this.tied = value;
    }

    /**
     * Gets the value of the slur property.
     * 
     * @return
     *     possible object is
     *     {@link Slur }
     *     
     */
    public Slur getSlur() {
        return slur;
    }

    /**
     * Sets the value of the slur property.
     * 
     * @param value
     *     allowed object is
     *     {@link Slur }
     *     
     */
    public void setSlur(Slur value) {
        this.slur = value;
    }

    /**
     * Gets the value of the tuplet property.
     * 
     * @return
     *     possible object is
     *     {@link Tuplet }
     *     
     */
    public Tuplet getTuplet() {
        return tuplet;
    }

    /**
     * Sets the value of the tuplet property.
     * 
     * @param value
     *     allowed object is
     *     {@link Tuplet }
     *     
     */
    public void setTuplet(Tuplet value) {
        this.tuplet = value;
    }

    /**
     * Gets the value of the glissando property.
     * 
     * @return
     *     possible object is
     *     {@link Glissando }
     *     
     */
    public Glissando getGlissando() {
        return glissando;
    }

    /**
     * Sets the value of the glissando property.
     * 
     * @param value
     *     allowed object is
     *     {@link Glissando }
     *     
     */
    public void setGlissando(Glissando value) {
        this.glissando = value;
    }

    /**
     * Gets the value of the slide property.
     * 
     * @return
     *     possible object is
     *     {@link Slide }
     *     
     */
    public Slide getSlide() {
        return slide;
    }

    /**
     * Sets the value of the slide property.
     * 
     * @param value
     *     allowed object is
     *     {@link Slide }
     *     
     */
    public void setSlide(Slide value) {
        this.slide = value;
    }

    /**
     * Gets the value of the ornaments property.
     * 
     * @return
     *     possible object is
     *     {@link Ornaments }
     *     
     */
    public Ornaments getOrnaments() {
        return ornaments;
    }

    /**
     * Sets the value of the ornaments property.
     * 
     * @param value
     *     allowed object is
     *     {@link Ornaments }
     *     
     */
    public void setOrnaments(Ornaments value) {
        this.ornaments = value;
    }

    /**
     * Gets the value of the technical property.
     * 
     * @return
     *     possible object is
     *     {@link Technical }
     *     
     */
    public Technical getTechnical() {
        return technical;
    }

    /**
     * Sets the value of the technical property.
     * 
     * @param value
     *     allowed object is
     *     {@link Technical }
     *     
     */
    public void setTechnical(Technical value) {
        this.technical = value;
    }

    /**
     * Gets the value of the articulations property.
     * 
     * @return
     *     possible object is
     *     {@link Articulations }
     *     
     */
    public Articulations getArticulations() {
        return articulations;
    }

    /**
     * Sets the value of the articulations property.
     * 
     * @param value
     *     allowed object is
     *     {@link Articulations }
     *     
     */
    public void setArticulations(Articulations value) {
        this.articulations = value;
    }

    /**
     * Gets the value of the dynamics property.
     * 
     * @return
     *     possible object is
     *     {@link Dynamics }
     *     
     */
    public Dynamics getDynamics() {
        return dynamics;
    }

    /**
     * Sets the value of the dynamics property.
     * 
     * @param value
     *     allowed object is
     *     {@link Dynamics }
     *     
     */
    public void setDynamics(Dynamics value) {
        this.dynamics = value;
    }

    /**
     * Gets the value of the fermata property.
     * 
     * @return
     *     possible object is
     *     {@link Fermata }
     *     
     */
    public Fermata getFermata() {
        return fermata;
    }

    /**
     * Sets the value of the fermata property.
     * 
     * @param value
     *     allowed object is
     *     {@link Fermata }
     *     
     */
    public void setFermata(Fermata value) {
        this.fermata = value;
    }

    /**
     * Gets the value of the arpeggiate property.
     * 
     * @return
     *     possible object is
     *     {@link Arpeggiate }
     *     
     */
    public Arpeggiate getArpeggiate() {
        return arpeggiate;
    }

    /**
     * Sets the value of the arpeggiate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Arpeggiate }
     *     
     */
    public void setArpeggiate(Arpeggiate value) {
        this.arpeggiate = value;
    }

    /**
     * Gets the value of the nonArpeggiate property.
     * 
     * @return
     *     possible object is
     *     {@link NonArpeggiate }
     *     
     */
    public NonArpeggiate getNonArpeggiate() {
        return nonArpeggiate;
    }

    /**
     * Sets the value of the nonArpeggiate property.
     * 
     * @param value
     *     allowed object is
     *     {@link NonArpeggiate }
     *     
     */
    public void setNonArpeggiate(NonArpeggiate value) {
        this.nonArpeggiate = value;
    }

    /**
     * Gets the value of the accidentalMark property.
     * 
     * @return
     *     possible object is
     *     {@link AccidentalMark }
     *     
     */
    public AccidentalMark getAccidentalMark() {
        return accidentalMark;
    }

    /**
     * Sets the value of the accidentalMark property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccidentalMark }
     *     
     */
    public void setAccidentalMark(AccidentalMark value) {
        this.accidentalMark = value;
    }

    /**
     * Gets the value of the otherNotation property.
     * 
     * @return
     *     possible object is
     *     {@link OtherNotation }
     *     
     */
    public OtherNotation getOtherNotation() {
        return otherNotation;
    }

    /**
     * Sets the value of the otherNotation property.
     * 
     * @param value
     *     allowed object is
     *     {@link OtherNotation }
     *     
     */
    public void setOtherNotation(OtherNotation value) {
        this.otherNotation = value;
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

}
