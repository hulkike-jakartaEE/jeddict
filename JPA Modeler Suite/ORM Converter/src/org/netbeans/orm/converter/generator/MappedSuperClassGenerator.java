/**
 * Copyright [2014] Gaurav Gupta
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.netbeans.orm.converter.generator;

import java.util.ArrayList;
import java.util.logging.Logger;
import org.netbeans.jpa.modeler.spec.Attributes;
import org.netbeans.jpa.modeler.spec.MappedSuperclass;
import org.netbeans.orm.converter.compiler.ClassDefSnippet;
import org.netbeans.orm.converter.compiler.VariableDefSnippet;
import org.netbeans.orm.converter.generator.managed.ManagedClassDefSnippet;
import org.netbeans.orm.converter.util.ClassHelper;
import org.netbeans.orm.converter.util.ORMConvLogger;

public class MappedSuperClassGenerator extends ClassGenerator<ManagedClassDefSnippet> {

    private static Logger logger = ORMConvLogger.getLogger(MappedSuperClassGenerator.class);

    private MappedSuperclass mappedSuperclass = null;

    public MappedSuperClassGenerator(MappedSuperclass parsedMappedSuperclass,String packageName) {
        super(new ManagedClassDefSnippet());
        this.mappedSuperclass = parsedMappedSuperclass;
        this.packageName = packageName;
    }

    @Override
    public ManagedClassDefSnippet getClassDef() {

        //--BEGIN ---- TODOs:
        /*
         * Commented -- revist for Phase 3
         *
         ParsedAccessType accessType = parsedMappedSuperclass..getAccess();
         * parsedMappedSuperclass.isMetaDataComplete()

         */
        //----END TODO ---------
        //Classlevel annotations
        processIdClass(mappedSuperclass.getIdClass());
        processEntityListeners(mappedSuperclass.getEntityListeners());

        processDefaultExcludeListeners(
                mappedSuperclass.getExcludeDefaultListeners());
        processExcludeSuperclassListeners(
                mappedSuperclass.getExcludeSuperclassListeners());

        //Attributes -- Method level annotations
        Attributes parsedAttributes = mappedSuperclass.getAttributes();

        if (parsedAttributes != null) {
            processEmbeddedId(parsedAttributes.getEmbeddedId());
            if (parsedAttributes.getEmbeddedId() == null) {
                processId(parsedAttributes.getId());
            }
            processBasic(parsedAttributes.getBasic());
            processTransient(parsedAttributes.getTransient());
            processElementCollection(parsedAttributes.getElementCollection());

            processEmbedded(parsedAttributes.getEmbedded());

            processManyToMany(parsedAttributes.getManyToMany());
            processManyToOne(parsedAttributes.getManyToOne());
            processOneToMany(parsedAttributes.getOneToMany());
            processOneToOne(parsedAttributes.getOneToOne());
            processVersion(parsedAttributes.getVersion());
        }

        //Class decorations
        ClassHelper classHelper = new ClassHelper(mappedSuperclass.getClazz());
        classHelper.setPackageName(packageName);
        classDef.setAbstractClass(mappedSuperclass.getAbstract());
        classDef.setInterfaces(mappedSuperclass.getInterfaces());
        if(mappedSuperclass.getSuperclass()!=null){
        ClassHelper superClassHelper = new ClassHelper(mappedSuperclass.getSuperclass().getClazz());
        classDef.setSuperClassName(superClassHelper.getFQClassName());
        }

        classDef.setVariableDefs(new ArrayList<VariableDefSnippet>(variables.values()));
        classDef.setClassName(classHelper.getFQClassName());
        
        classDef.setPackageName(classHelper.getPackageName());

        classDef.setMappedSuperClass(true);
        classDef.setAnnotation(mappedSuperclass.getAnnotation());
        
        classDef.setXmlRootElement(mappedSuperclass.getXmlRootElement());
        return classDef;
    }
}
