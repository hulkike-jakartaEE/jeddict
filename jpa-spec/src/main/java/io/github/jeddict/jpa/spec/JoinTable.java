//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2014.01.21 at 01:52:19 PM IST
//
package io.github.jeddict.jpa.spec;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import static java.util.stream.Collectors.toList;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.eclipse.persistence.internal.jpa.metadata.tables.JoinTableMetadata;
import static io.github.jeddict.jcode.JPAConstants.JOIN_TABLE_FQN;
import io.github.jeddict.jpa.spec.validator.column.ForeignKeyValidator;
import io.github.jeddict.jpa.spec.validator.table.JoinTableValidator;
import io.github.jeddict.source.JavaSourceParserUtil;

/**
 *
 *
 * @Target({METHOD, FIELD}) @Retention(RUNTIME) public @interface JoinTable {
 * String name() default ""; String catalog() default ""; String schema()
 * default ""; JoinColumn[] joinColumns() default {}; JoinColumn[]
 * inverseJoinColumns() default {}; UniqueConstraint[] uniqueConstraints()
 * default {}; Index[] indexes() default {}; }
 *
 *
 *
 * <p>
 * Java class for join-table complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 *
 * <pre>
 * &lt;complexType name="join-table">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;sequence>
 *           &lt;element name="join-column" type="{http://xmlns.jcp.org/xml/ns/persistence/orm}join-column" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;element name="foreign-key" type="{http://xmlns.jcp.org/xml/ns/persistence/orm}foreign-key" minOccurs="0"/>
 *         &lt;/sequence>
 *         &lt;sequence>
 *           &lt;element name="inverse-join-column" type="{http://xmlns.jcp.org/xml/ns/persistence/orm}join-column" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;element name="inverse-foreign-key" type="{http://xmlns.jcp.org/xml/ns/persistence/orm}foreign-key" minOccurs="0"/>
 *         &lt;/sequence>
 *         &lt;element name="unique-constraint" type="{http://xmlns.jcp.org/xml/ns/persistence/orm}unique-constraint" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="index" type="{http://xmlns.jcp.org/xml/ns/persistence/orm}index" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="catalog" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="schema" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "join-table", propOrder = {
    "joinColumn",
    "foreignKey",
    "inverseJoinColumn",
    "inverseForeignKey",
    "uniqueConstraint",
    "index"
})
@XmlJavaTypeAdapter(value = JoinTableValidator.class)

public class JoinTable {

    @XmlElement(name = "join-column")
    private List<JoinColumn> joinColumn;
    @XmlElement(name = "fk")
    protected ForeignKey foreignKey;
    @XmlElement(name = "inverse-join-column")
    private List<JoinColumn> inverseJoinColumn;
    @XmlElement(name = "ifk")
    protected ForeignKey inverseForeignKey;
    @XmlElement(name = "unique-constraint")
    protected Set<UniqueConstraint> uniqueConstraint;
    protected List<Index> index;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "catalog")
    protected String catalog;
    @XmlAttribute(name = "schema")
    protected String schema;

    @XmlTransient
    private String generatedName;
    
    public static JoinTable load(Element element) {
        AnnotationMirror annotationMirror = JavaSourceParserUtil.findAnnotation(element, JOIN_TABLE_FQN);
        return JoinTable.load(element, annotationMirror);
    }

    public static JoinTable load(Element element, AnnotationMirror annotationMirror) {

        JoinTable joinTable = null;
        if (annotationMirror != null) {
            joinTable = new JoinTable();

            List joinColumnsAnnot = (List) JavaSourceParserUtil.findAnnotationValue(annotationMirror, "joinColumns");
            if (joinColumnsAnnot != null) {
                for (Object joinColumnObj : joinColumnsAnnot) {
                    joinTable.getJoinColumn().add(new JoinColumn().load(element, (AnnotationMirror) joinColumnObj));
                }
            }
            List inverseJoinColumnsAnnot = (List) JavaSourceParserUtil.findAnnotationValue(annotationMirror, "inverseJoinColumns");
            if (inverseJoinColumnsAnnot != null) {
                for (Object inverseJoinColumnsObj : inverseJoinColumnsAnnot) {
                    joinTable.getInverseJoinColumn().add(new JoinColumn().load(element, (AnnotationMirror) inverseJoinColumnsObj));
                }
            }
            List uniqueConstraintsAnnot = (List) JavaSourceParserUtil.findAnnotationValue(annotationMirror, "uniqueConstraints");
            if (uniqueConstraintsAnnot != null) {
                for (Object uniqueConstraintsObj : uniqueConstraintsAnnot) {
                    joinTable.getUniqueConstraint().add(UniqueConstraint.load(element, (AnnotationMirror) uniqueConstraintsObj));
                }
            }
            
            List indexesAnnot = (List) JavaSourceParserUtil.findAnnotationValue(annotationMirror, "indexes");
            if (indexesAnnot != null) {
                for (Object indexObj : indexesAnnot) {
                    joinTable.getIndex().add(Index.load(element, (AnnotationMirror) indexObj));
                }
            }

            joinTable.name = (String) JavaSourceParserUtil.findAnnotationValue(annotationMirror, "name");
            joinTable.catalog = (String) JavaSourceParserUtil.findAnnotationValue(annotationMirror, "catalog");
            joinTable.schema = (String) JavaSourceParserUtil.findAnnotationValue(annotationMirror, "schema");

            AnnotationMirror foreignKeyValue = (AnnotationMirror) JavaSourceParserUtil.findAnnotationValue(annotationMirror, "foreignKey");
            if (foreignKeyValue != null) {
                joinTable.foreignKey = ForeignKey.load(element, foreignKeyValue);
            }

            AnnotationMirror inverseForeignKeyValue = (AnnotationMirror) JavaSourceParserUtil.findAnnotationValue(annotationMirror, "inverseForeignKey");
            if (inverseForeignKeyValue != null) {
                joinTable.inverseForeignKey = ForeignKey.load(element, inverseForeignKeyValue);
            }

        }
        return joinTable;

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
    public ForeignKey getForeignKey() {
        if (foreignKey == null) {
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
    public void setForeignKey(ForeignKey value) {
        this.foreignKey = value;
    }

    /**
     * Gets the value of the inverseJoinColumn property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the inverseJoinColumn property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInverseJoinColumn().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JoinColumn }
     *
     *
     */
    public List<JoinColumn> getInverseJoinColumn() {
        if (inverseJoinColumn == null) {
            setInverseJoinColumn(new ArrayList<>());
        }
        return this.inverseJoinColumn;
    }

    /**
     * Gets the value of the inverseForeignKey property.
     *
     * @return possible object is {@link ForeignKey }
     *
     */
    public ForeignKey getInverseForeignKey() {
        if(inverseForeignKey==null){
            inverseForeignKey = new ForeignKey();
        }
        return inverseForeignKey;
    }

    /**
     * Sets the value of the inverseForeignKey property.
     *
     * @param value allowed object is {@link ForeignKey }
     *
     */
    public void setInverseForeignKey(ForeignKey value) {
        this.inverseForeignKey = value;
    }

    /**
     * Gets the value of the uniqueConstraint property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the uniqueConstraint property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUniqueConstraint().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UniqueConstraint }
     *
     *
     */
    public Set<UniqueConstraint> getUniqueConstraint() {
        if (uniqueConstraint == null) {
            uniqueConstraint = new LinkedHashSet<>();
        }
        return this.uniqueConstraint;
    }

    /**
     * Gets the value of the index property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the index property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIndex().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link Index }
     *
     *
     */
    public List<Index> getIndex() {
        if (index == null) {
            index = new ArrayList<>();
        }
        return this.index;
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

    /**
     * Gets the value of the catalog property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getCatalog() {
        return catalog;
    }

    /**
     * Sets the value of the catalog property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setCatalog(String value) {
        this.catalog = value;
    }

    /**
     * Gets the value of the schema property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getSchema() {
        return schema;
    }

    /**
     * Sets the value of the schema property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setSchema(String value) {
        this.schema = value;
    }

    public JoinTableMetadata getAccessor() {
        JoinTableMetadata accessor = new JoinTableMetadata();
        accessor.setName(name);
        accessor.setSchema(schema);
        accessor.setCatalog(catalog);
        accessor.setInverseJoinColumns(getInverseJoinColumn().stream().map(JoinColumn::getAccessor).collect(toList()));
        accessor.setJoinColumns(getJoinColumn().stream().map(JoinColumn::getAccessor).collect(toList()));
        if (ForeignKeyValidator.isNotEmpty(foreignKey)) {
            accessor.setForeignKey(foreignKey.getAccessor());
        }
        if (ForeignKeyValidator.isNotEmpty(inverseForeignKey)) {
            accessor.setInverseForeignKey(inverseForeignKey.getAccessor());
        }
        accessor.setUniqueConstraints(getUniqueConstraint().stream()
                .map(UniqueConstraint::getAccessor)
                .collect(toList()));
        accessor.setIndexes(getIndex().stream()
                .map(Index::getAccessor)
                .collect(toList()));
        return accessor;
    }

    /**
     * @param generatedName the generatedName to set
     */
    public void setGeneratedName(String generatedName) {
        this.generatedName = generatedName;
    }

    /**
     * @return the generatedName
     */
    public String getGeneratedName() {
        return generatedName;
    }

    /**
     * @param joinColumn the joinColumn to set
     */
    public void setJoinColumn(List<JoinColumn> joinColumn) {
        this.joinColumn = joinColumn;
    }

    /**
     * @param inverseJoinColumn the inverseJoinColumn to set
     */
    public void setInverseJoinColumn(List<JoinColumn> inverseJoinColumn) {
        this.inverseJoinColumn = inverseJoinColumn;
    }

    public void clear() {
        this.catalog = null;
        this.foreignKey = null;
        this.getIndex().clear();
        this.inverseForeignKey = null;
        this.getInverseJoinColumn().clear();
        this.getJoinColumn().clear();
        this.name = null;
        this.schema = null;
        this.getUniqueConstraint().clear();
    }
}
