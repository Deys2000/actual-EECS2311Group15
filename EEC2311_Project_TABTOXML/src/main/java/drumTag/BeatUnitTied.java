//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.02.25 at 11:44:40 AM EST 
//


package drumTag;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element ref="{}beat-unit"/&gt;
 *         &lt;element ref="{}beat-unit-dot"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "beatUnit",
    "beatUnitDot"
})
@XmlRootElement(name = "beat-unit-tied")
public class BeatUnitTied {

    @XmlElement(name = "beat-unit", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected java.lang.String beatUnit;
    @XmlElement(name = "beat-unit-dot", required = true)
    protected BeatUnitDot beatUnitDot;

    /**
     * Gets the value of the beatUnit property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getBeatUnit() {
        return beatUnit;
    }

    /**
     * Sets the value of the beatUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setBeatUnit(java.lang.String value) {
        this.beatUnit = value;
    }

    /**
     * Gets the value of the beatUnitDot property.
     * 
     * @return
     *     possible object is
     *     {@link BeatUnitDot }
     *     
     */
    public BeatUnitDot getBeatUnitDot() {
        return beatUnitDot;
    }

    /**
     * Sets the value of the beatUnitDot property.
     * 
     * @param value
     *     allowed object is
     *     {@link BeatUnitDot }
     *     
     */
    public void setBeatUnitDot(BeatUnitDot value) {
        this.beatUnitDot = value;
    }

}
