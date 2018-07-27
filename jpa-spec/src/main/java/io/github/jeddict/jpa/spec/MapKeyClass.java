//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2014.01.21 at 01:52:19 PM IST
//
package io.github.jeddict.jpa.spec;

import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.type.DeclaredType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import static io.github.jeddict.jcode.JPAConstants.MAP_KEY_CLASS_FQN;
import io.github.jeddict.source.JAREAnnotationLoader;
import io.github.jeddict.source.JavaSourceParserUtil;

/**
 *
 *
 * @Target({METHOD, FIELD}) @Retention(RUNTIME) public @interface MapKeyClass {
 * Class value(); }
 *
 *
 *
 * <p>
 * Java class for map-key-class complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 *
 * <pre>
 * &lt;complexType name="map-key-class">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="class" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "map-key-class")
public class MapKeyClass implements JAREAnnotationLoader {

    @XmlAttribute(name = "class", required = true)
    protected String clazz;
    
        
    @Override
    public MapKeyClass load(Element element, AnnotationMirror annotationMirror) {
        if (annotationMirror == null) {
            annotationMirror = JavaSourceParserUtil.findAnnotation(element, MAP_KEY_CLASS_FQN);
        }
        MapKeyClass mapKeyClass = null;
        if (annotationMirror != null) {
            mapKeyClass = this;
            DeclaredType declaredType = (DeclaredType) JavaSourceParserUtil.findAnnotationValue(annotationMirror, "value");
            if (declaredType != null) {
                mapKeyClass.clazz = declaredType.asElement().getSimpleName().toString();
            }
        }
        return mapKeyClass;
    }
    
    public static DeclaredType getDeclaredType(Element element) {
         AnnotationMirror   annotationMirror = JavaSourceParserUtil.findAnnotation(element, MAP_KEY_CLASS_FQN);
        if (annotationMirror != null) {
             return (DeclaredType) JavaSourceParserUtil.findAnnotationValue(annotationMirror, "value");
        }
        return null;
    }

    /**
     * Gets the value of the clazz property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getClazz() {
        return clazz;
    }

    /**
     * Sets the value of the clazz property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setClazz(String value) {
        this.clazz = value;
    }

}
