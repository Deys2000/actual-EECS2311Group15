//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.02.25 at 11:44:40 AM EST 
//


package musicXML;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element ref="{}miscellaneous-field"/&gt;
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
    "miscellaneousField"
})
@XmlRootElement(name = "miscellaneous")
public class Miscellaneous {

    @XmlElement(name = "miscellaneous-field", required = true)
    protected MiscellaneousField miscellaneousField;

    /**
     * Gets the value of the miscellaneousField property.
     * 
     * @return
     *     possible object is
     *     {@link MiscellaneousField }
     *     
     */
    public MiscellaneousField getMiscellaneousField() {
        return miscellaneousField;
    }

    /**
     * Sets the value of the miscellaneousField property.
     * 
     * @param value
     *     allowed object is
     *     {@link MiscellaneousField }
     *     
     */
    public void setMiscellaneousField(MiscellaneousField value) {
        this.miscellaneousField = value;
    }

}
