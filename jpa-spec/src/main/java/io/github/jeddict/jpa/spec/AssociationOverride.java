//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2014.01.21 at 01:52:19 PM IST
//
package io.github.jeddict.jpa.spec;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import static io.github.jeddict.jcode.JPAConstants.ASSOCIATION_OVERRIDES_FQN;
import static io.github.jeddict.jcode.JPAConstants.ASSOCIATION_OVERRIDE_FQN;
import io.github.jeddict.jpa.spec.extend.JoinColumnHandler;
import io.github.jeddict.source.JavaSourceParserUtil;

/**
 *
 *
 * @Target({TYPE, METHOD, FIELD}) @Retention(RUNTIME) public @interface
 * AssociationOverride { String name(); JoinColumn[] joinColumns() default{};
 * JoinTable joinTable() default @JoinTable; }
 *
 *
 *
 * <p>
 * Java class for association-override complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 *
 * <pre>
 * &lt;complexType name="association-override">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;sequence>
 *             &lt;element name="join-column" type="{http://xmlns.jcp.org/xml/ns/persistence/orm}join-column" maxOccurs="unbounded" minOccurs="0"/>
 *             &lt;element name="foreign-key" type="{http://xmlns.jcp.org/xml/ns/persistence/orm}foreign-key" minOccurs="0"/>
 *           &lt;/sequence>
 *           &lt;element name="join-table" type="{http://xmlns.jcp.org/xml/ns/persistence/orm}join-table" minOccurs="0"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "association-override", propOrder = {
    "description",
    "joinColumn",
    "foreignKey",
    "joinTable"
})
//@XmlJavaTypeAdapter(value=AssociationValidator.class)
public class AssociationOverride implements Comparable<AssociationOverride>, JoinColumnHandler {

    protected String description;
    @XmlElement(name = "join-column")
    private List<JoinColumn> joinColumn;
    @XmlElement(name = "fk")
    protected ForeignKey foreignKey;
    @XmlElement(name = "join-table")
    protected JoinTable joinTable;
    @XmlAttribute(name = "name", required = true)
    protected String name;

    private static AssociationOverride loadAssociation(Element element, AnnotationMirror annotationMirror) {
        AssociationOverride associationOverride = null;
        if (annotationMirror != null) {
            associationOverride = new AssociationOverride();
            associationOverride.name = (String) JavaSourceParserUtil.findAnnotationValue(annotationMirror, "name");

            List joinColumnsAnnot = (List) JavaSourceParserUtil.findAnnotationValue(annotationMirror, "joinColumns");
            if (joinColumnsAnnot != null) {
                for (Object joinColumnObj : joinColumnsAnnot) {
                    associationOverride.getJoinColumn().add(new JoinColumn().load(element, (AnnotationMirror) joinColumnObj));
                }
            }

            AnnotationMirror joinTableAnnot = (AnnotationMirror) JavaSourceParserUtil.findAnnotationValue(annotationMirror, "joinTable");
            if (joinTableAnnot != null) {
                associationOverride.joinTable = JoinTable.load(element, joinTableAnnot);
            }
            
            AnnotationMirror foreignKeyValue = (AnnotationMirror) JavaSourceParserUtil.findAnnotationValue(annotationMirror, "foreignKey");
            if (foreignKeyValue != null) {
                associationOverride.foreignKey = ForeignKey.load(element, foreignKeyValue);
            }

        }
        return associationOverride;
    }

    public static Set<AssociationOverride> load(Element element) {
        Set<AssociationOverride> associationOverrides = new TreeSet<>();

        AnnotationMirror associationOverridesMirror = JavaSourceParserUtil.findAnnotation(element, ASSOCIATION_OVERRIDES_FQN);
        if (associationOverridesMirror != null) {
            List associationOverridesMirrorList = (List) JavaSourceParserUtil.findAnnotationValue(associationOverridesMirror, "value");
            if (associationOverridesMirrorList != null) {
                for (Object associationOverrideObj : associationOverridesMirrorList) {
                    associationOverrides.add(AssociationOverride.loadAssociation(element, (AnnotationMirror) associationOverrideObj));
                }
            }
        } else {
            associationOverridesMirror = JavaSourceParserUtil.findAnnotation(element, ASSOCIATION_OVERRIDE_FQN);
            if (associationOverridesMirror != null) {
                associationOverrides.add(AssociationOverride.loadAssociation(element, associationOverridesMirror));
            }
        }

        return associationOverrides;
    }

    /**
     * Gets the value of the description property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the joinColumn property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the joinColumn property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getJoinColumn().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JoinColumn }
     *
     *
     */
    @Override
    public List<JoinColumn> getJoinColumn() {
        if (joinColumn == null) {
            setJoinColumn(new ArrayList<>());
        }
        return this.joinColumn;
    }

    /**
     * Gets the value of the foreignKey property.
     *
     * @return possible object is {@link ForeignKey }
     *
     */
    @Override
    public ForeignKey getForeignKey() {
        if(foreignKey==null){
            foreignKey = new ForeignKey();
        }
        return foreignKey;
    }

    /**
     * Sets the value of the foreignKey property.
     *
     * @param value allowed object is {@link ForeignKey }
     *
     */
    @Override
    public void setForeignKey(ForeignKey value) {
        this.foreignKey = value;
    }

    /**
     * Gets the value of the joinTable property.
     *
     * @return possible object is {@link JoinTable }
     *
     */
    @Override
    public JoinTable getJoinTable() {
        if (joinTable == null) {
            joinTable = new JoinTable();
        }
        return joinTable;
    }

    /**
     * Sets the value of the joinTable property.
     *
     * @param value allowed object is {@link JoinTable }
     *
     */
    @Override
    public void setJoinTable(JoinTable value) {
        this.joinTable = value;
    }

    /**
     * Gets the value of the name property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setName(String value) {
        this.name = value;
    }

    @Override
    public int compareTo(AssociationOverride associationOverride) {
        return this.name.compareTo(associationOverride.getName());
    }

    /**
     * @param joinColumn the joinColumn to set
     */
    public void setJoinColumn(List<JoinColumn> joinColumn) {
        this.joinColumn = joinColumn;
    }

    @Override
    public void addJoinColumn(JoinColumn joinColumn_In) {
        if (joinColumn == null) {
            joinColumn = new ArrayList<>();
        }
        joinColumn.add(joinColumn_In);
    }

    @Override
    public void removeJoinColumn(JoinColumn joinColumn_In) {
        if (joinColumn == null) {
            joinColumn = new ArrayList<>();
        }
        joinColumn.remove(joinColumn_In);
    }

}
