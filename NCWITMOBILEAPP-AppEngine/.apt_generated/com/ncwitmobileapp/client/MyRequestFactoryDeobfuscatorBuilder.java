// Automatically Generated -- DO NOT EDIT
// com.ncwitmobileapp.client.MyRequestFactory
package com.ncwitmobileapp.client;
import java.util.Arrays;
import com.google.web.bindery.requestfactory.vm.impl.OperationData;
import com.google.web.bindery.requestfactory.vm.impl.OperationKey;
public final class MyRequestFactoryDeobfuscatorBuilder extends com.google.web.bindery.requestfactory.vm.impl.Deobfuscator.Builder {
{
withOperation(new OperationKey("113$ektVMf1rQOsaA0WabzjEU00="),
  new OperationData.Builder()
  .withClientMethodDescriptor("()Lcom/google/web/bindery/requestfactory/shared/InstanceRequest;")
  .withDomainMethodDescriptor("()Ljava/lang/String;")
  .withMethodName("send")
  .withRequestContext("com.ncwitmobileapp.client.MyRequestFactory$MessageRequest")
  .build());
withOperation(new OperationKey("VC3ymr$Lq1iejM_raahkEko8KFw="),
  new OperationData.Builder()
  .withClientMethodDescriptor("()Lcom/google/web/bindery/requestfactory/shared/Request;")
  .withDomainMethodDescriptor("()Ljava/lang/String;")
  .withMethodName("getMessage")
  .withRequestContext("com.ncwitmobileapp.client.MyRequestFactory$HelloWorldRequest")
  .build());
withOperation(new OperationKey("9pqN9CPTF1i$3uTlyuW68LVlVng="),
  new OperationData.Builder()
  .withClientMethodDescriptor("()Lcom/google/web/bindery/requestfactory/shared/InstanceRequest;")
  .withDomainMethodDescriptor("()V")
  .withMethodName("register")
  .withRequestContext("com.ncwitmobileapp.client.MyRequestFactory$RegistrationInfoRequest")
  .build());
withOperation(new OperationKey("R06iT2IdKd_$Kom2eZCBjbcihlI="),
  new OperationData.Builder()
  .withClientMethodDescriptor("()Lcom/google/web/bindery/requestfactory/shared/InstanceRequest;")
  .withDomainMethodDescriptor("()V")
  .withMethodName("unregister")
  .withRequestContext("com.ncwitmobileapp.client.MyRequestFactory$RegistrationInfoRequest")
  .build());
withRawTypeToken("8KVVbwaaAtl6KgQNlOTsLCp9TIU=", "com.google.web.bindery.requestfactory.shared.ValueProxy");
withRawTypeToken("FXHD5YU0TiUl3uBaepdkYaowx9k=", "com.google.web.bindery.requestfactory.shared.BaseProxy");
withRawTypeToken("Lpq7rMVoIj0Cw3PaHOOyKTV6BM4=", "com.ncwitmobileapp.shared.MessageProxy");
withRawTypeToken("WYq4f1vwp32fziX8HxZ$VT16N84=", "com.ncwitmobileapp.shared.RegistrationInfoProxy");
withClientToDomainMappings("com.ncwitmobileapp.server.Message", Arrays.asList("com.ncwitmobileapp.shared.MessageProxy"));
withClientToDomainMappings("com.ncwitmobileapp.server.RegistrationInfo", Arrays.asList("com.ncwitmobileapp.shared.RegistrationInfoProxy"));
}}
