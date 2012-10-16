// Automatically Generated -- DO NOT EDIT
// com.ncwitmobileapp.shared.TechicksmemberRequestFactory
package com.ncwitmobileapp.shared;
import java.util.Arrays;
import com.google.web.bindery.requestfactory.vm.impl.OperationData;
import com.google.web.bindery.requestfactory.vm.impl.OperationKey;
public final class TechicksmemberRequestFactoryDeobfuscatorBuilder extends com.google.web.bindery.requestfactory.vm.impl.Deobfuscator.Builder {
{
withOperation(new OperationKey("Rpr84edFY8ys6uY$gFE2PFQHt5Q="),
  new OperationData.Builder()
  .withClientMethodDescriptor("(Lcom/ncwitmobileapp/shared/TechicksmemberProxy;)Lcom/google/web/bindery/requestfactory/shared/Request;")
  .withDomainMethodDescriptor("(Lcom/ncwitmobileapp/server/Techicksmember;)Lcom/ncwitmobileapp/server/Techicksmember;")
  .withMethodName("createTechicksmember")
  .withRequestContext("com.ncwitmobileapp.shared.TechicksmemberRequest")
  .build());
withOperation(new OperationKey("aTkjXi7Z47SXEQYbycMrcuYBSM0="),
  new OperationData.Builder()
  .withClientMethodDescriptor("(Ljava/lang/String;)Lcom/google/web/bindery/requestfactory/shared/Request;")
  .withDomainMethodDescriptor("(Ljava/lang/String;)Lcom/ncwitmobileapp/server/Techicksmember;")
  .withMethodName("readTechicksmember")
  .withRequestContext("com.ncwitmobileapp.shared.TechicksmemberRequest")
  .build());
withOperation(new OperationKey("ociXdSeU2uRdvx$z8pL$nANaVrw="),
  new OperationData.Builder()
  .withClientMethodDescriptor("(Ljava/lang/String;Ljava/lang/String;)Lcom/google/web/bindery/requestfactory/shared/Request;")
  .withDomainMethodDescriptor("(Ljava/lang/String;Ljava/lang/String;)Lcom/ncwitmobileapp/server/Techicksmember;")
  .withMethodName("getAuthenticatedTechicksmember")
  .withRequestContext("com.ncwitmobileapp.shared.TechicksmemberRequest")
  .build());
withOperation(new OperationKey("4O4IbWNw2_6sa9iOnLf0_XDoK7I="),
  new OperationData.Builder()
  .withClientMethodDescriptor("()Lcom/google/web/bindery/requestfactory/shared/Request;")
  .withDomainMethodDescriptor("()Ljava/util/List;")
  .withMethodName("queryTechicksmembers")
  .withRequestContext("com.ncwitmobileapp.shared.TechicksmemberRequest")
  .build());
withOperation(new OperationKey("mAlmNu2q438e5mQYnIXinCSEyRk="),
  new OperationData.Builder()
  .withClientMethodDescriptor("(Lcom/ncwitmobileapp/shared/TechicksmemberProxy;)Lcom/google/web/bindery/requestfactory/shared/Request;")
  .withDomainMethodDescriptor("(Lcom/ncwitmobileapp/server/Techicksmember;)Lcom/ncwitmobileapp/server/Techicksmember;")
  .withMethodName("updateTechicksmember")
  .withRequestContext("com.ncwitmobileapp.shared.TechicksmemberRequest")
  .build());
withOperation(new OperationKey("k2EzWQRK5fOQBcT2uS7l7g3t9Zw="),
  new OperationData.Builder()
  .withClientMethodDescriptor("(Lcom/ncwitmobileapp/shared/TechicksmemberProxy;)Lcom/google/web/bindery/requestfactory/shared/Request;")
  .withDomainMethodDescriptor("(Lcom/ncwitmobileapp/server/Techicksmember;)V")
  .withMethodName("deleteTechicksmember")
  .withRequestContext("com.ncwitmobileapp.shared.TechicksmemberRequest")
  .build());
withRawTypeToken("Axo8oDO64jLCLzTYs1uUjByPzQA=", "com.ncwitmobileapp.shared.AwardProxy");
withRawTypeToken("yofBttdTy9JEjAC72qGT7500u8s=", "com.ncwitmobileapp.shared.TechicksmemberProxy");
withRawTypeToken("8KVVbwaaAtl6KgQNlOTsLCp9TIU=", "com.google.web.bindery.requestfactory.shared.ValueProxy");
withRawTypeToken("FXHD5YU0TiUl3uBaepdkYaowx9k=", "com.google.web.bindery.requestfactory.shared.BaseProxy");
withClientToDomainMappings("com.ncwitmobileapp.server.Award", Arrays.asList("com.ncwitmobileapp.shared.AwardProxy"));
withClientToDomainMappings("com.ncwitmobileapp.server.Techicksmember", Arrays.asList("com.ncwitmobileapp.shared.TechicksmemberProxy"));
}}
