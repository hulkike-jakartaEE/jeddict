/**
 * Copyright 2013-2018 the original author or authors from the Jeddict project (https://jeddict.github.io/).
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
package io.github.jeddict.jpa.spec.bean;

import io.github.jeddict.source.MemberExplorer;
import java.util.Optional;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "one-to-one-assoc")
@XmlRootElement
public class OneToOneAssociation extends SingleAssociationAttribute {

    public static OneToOneAssociation load(MemberExplorer member) {
        OneToOneAssociation attribute = new OneToOneAssociation();
        attribute.loadAttribute(member);

        Optional<BeanClass> beanClassOpt = member.getSource().findBeanClass(member.getTypeDeclaration());
        if (!beanClassOpt.isPresent()) {
            return null;
        }
        attribute.setConnectedClass(beanClassOpt.get());
        return attribute;
    }

}