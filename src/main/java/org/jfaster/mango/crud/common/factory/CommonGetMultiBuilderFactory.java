/*
 * Copyright 2014 mango.jfaster.org
 *
 * The Mango Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package org.jfaster.mango.crud.common.factory;

import org.jfaster.mango.crud.CrudMeta;
import org.jfaster.mango.crud.common.builder.CommonBuilder;
import org.jfaster.mango.crud.common.builder.CommonGetBuilder;
import org.jfaster.mango.util.reflect.DynamicTokens;
import org.jfaster.mango.util.reflect.TypeToken;

import java.lang.reflect.Type;

/**
 * @author ash
 */
public class CommonGetMultiBuilderFactory extends CommonBuilderFactory {

  @Override
  String expectedMethodName() {
    return "getMulti";
  }

  @Override
  Type expectedReturnType(Class<?> entityClass) {
    return DynamicTokens.listToken(TypeToken.of(entityClass)).getType();
  }

  @Override
  Type expectedParameterType(Class<?> entityClass, Class<?> idClass) {
    return DynamicTokens.listToken(TypeToken.of(idClass)).getType();
  }

  @Override
  CommonBuilder createCommonBuilder(CrudMeta cm) {
    return new CommonGetBuilder(cm.getColumnId(), cm.getColumns(), true);
  }

}
