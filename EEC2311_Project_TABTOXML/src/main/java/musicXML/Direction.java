//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.02.25 at 11:44:40 AM EST 
//


package musicXML;

import java.math.BigInteger;
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
 *         &lt;element ref="{}direction-type"/&gt;
 *         &lt;element ref="{}offset"/&gt;
 *         &lt;element ref="{}footnote"/&gt;
 *         &lt;element ref="{}level"/&gt;
 *         &lt;element ref="{}voice"/&gt;
 *         &lt;element ref="{}staff"/&gt;
 *         &lt;element ref="{}sound"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="directive" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="placement" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "directionType",
    "offset",
    "footnote",
    "level",
    "voice",
    "staff",
    "sound"
})
@XmlRootElement(name = "direction")
public class Direction {

    @XmlElement(name = "direction-type", required = true)
    protected DirectionType directionType;
    @XmlElement(required = true)
    protected Offset offset;
    @XmlElement(required = true)
    protected Footnote footnote;
    @XmlElement(required = true)
    protected Level level;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected java.lang.String voice;
    @XmlElement(required = true)
    protected BigInteger staff;
    @XmlElement(required = true)
    protected Sound sound;
    @XmlAttribute(name = "directive", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected java.lang.String directive;
    @XmlAttribute(name = "id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected java.lang.String id;
    @XmlAttribute(name = "placement", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected java.lang.String placement;

    /**
     * Gets the value of the directionType property.
     * 
     * @return
     *     possible object is
     *     {@link DirectionType }
     *     
     */
    public DirectionType getDirectionType() {
        return directionType;
    }

    /**
     * Sets the value of the directionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link DirectionType }
     *     
     */
    public void setDirectionType(DirectionType value) {
        this.directionType = value;
    }

    /**
     * Gets the value of the offset property.
     * 
     * @return
     *     possible object is
     *     {@link Offset }
     *     
     */
    public Offset getOffset() {
        return offset;
    }

    /**
     * Sets the value of the offset property.
     * 
     * @param value
     *     allowed object is
     *     {@link Offset }
     *     
     */
    public void setOffset(Offset value) {
        this.offset = value;
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
     * Gets the value of the sound property.
     * 
     * @return
     *     possible object is
     *     {@link Sound }
     *     
     */
    public Sound getSound() {
        return sound;
    }

    /**
     * Sets the value of the sound property.
     * 
     * @param value
     *     allowed object is
     *     {@link Sound }
     *     
     */
    public void setSound(Sound value) {
        this.sound = value;
    }

    /**
     * Gets the value of the directive property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getDirective() {
        return directive;
    }

    /**
     * Sets the value of the directive property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setDirective(java.lang.String value) {
        this.directive = value;
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
     * Gets the value of the placement property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getPlacement() {
        return placement;
    }

    /**
     * Sets the value of the placement property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setPlacement(java.lang.String value) {
        this.placement = value;
    }

}