/*******************************************************************************
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.ncwitmobileapp.client;
//to be changed
import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.RequestFactory;
import com.google.web.bindery.requestfactory.shared.ServiceName;

import com.ncwitmobileapp.shared.MessageProxy;
import com.ncwitmobileapp.shared.RegistrationInfoProxy;

public interface MyRequestFactory extends RequestFactory {

  @ServiceName("com.ncwitmobileapp.server.HelloWorldService")
  public interface HelloWorldRequest extends RequestContext {
    /**
     * Retrieve a "Hello, World" message from the server.
     */
    Request<String> getMessage();
  }

  @ServiceName("com.ncwitmobileapp.server.RegistrationInfo")
  public interface RegistrationInfoRequest extends RequestContext {
    /**
     * Register a device for C2DM messages.
     */
    InstanceRequest<RegistrationInfoProxy, Void> register();

    /**
     * Unregister a device for C2DM messages.
     */
    InstanceRequest<RegistrationInfoProxy, Void> unregister();
  }

  @ServiceName("com.ncwitmobileapp.server.Message")
  public interface MessageRequest extends RequestContext {
    /**
     * Send a message to a device using C2DM.
     */
    InstanceRequest<MessageProxy, String> send();
  }

  HelloWorldRequest helloWorldRequest();

  RegistrationInfoRequest registrationInfoRequest();

  MessageRequest messageRequest();
}
