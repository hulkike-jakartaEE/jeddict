//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2014.01.21 at 01:52:19 PM IST
//
package io.github.jeddict.jpa.spec;

import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import org.eclipse.persistence.internal.jpa.metadata.inheritance.InheritanceMetadata;
import static io.github.jeddict.jcode.JPAConstants.INHERITANCE_FQN;
import io.github.jeddict.db.metadata.InheritanceSpecMetadata;
import io.github.jeddict.source.JavaSourceParserUtil;

/**
 *
 *
 * @Target({TYPE}) @Retention(RUNTIME) public @interface Inheritance {
 * InheritanceType strategy() default SINGLE_TABLE; }
 *
 *
 *
 * <p>
 * Java class for inheritance complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 *
 * <pre>
 * &lt;complexType name="inheritance">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="strategy" type="{http://java.sun.com/xml/ns/persistence/orm}inheritance-type" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "inheritance")
public class Inheritance {

    public Inheritance() {
    }

    @XmlAttribute
    protected InheritanceType strategy;

    public static Inheritance load(Element element) {
        AnnotationMirror annotationMirror = JavaSourceParserUtil.findAnnotation(element, INHERITANCE_FQN);
        Inheritance inheritance = null;
        if (annotationMirror != null) {
            inheritance = new Inheritance();
            inheritance.strategy = InheritanceType.load(element, annotationMirror);
        }
        return inheritance;
    }

    /**
     * Gets the value of the strategy property.
     *
     * @return possible object is {@link InheritanceType }
     *
     */
    public InheritanceType getStrategy() {
        return strategy;
    }

    /**
     * Sets the value of the strategy property.
     *
     * @param value allowed object is {@link InheritanceType }
     *
     */
    public void setStrategy(InheritanceType value) {
        this.strategy = value;
    }

    public InheritanceMetadata getAccessor() {
        InheritanceMetadata accessor = new InheritanceSpecMetadata();
        accessor.setStrategy(strategy.value());
        return accessor;
    }
    
    public static InheritanceMetadata getDefaultAccessor() {
        InheritanceMetadata accessor = new InheritanceSpecMetadata();
        accessor.setStrategy(InheritanceType.SINGLE_TABLE.value());
        return accessor;
    }
}
