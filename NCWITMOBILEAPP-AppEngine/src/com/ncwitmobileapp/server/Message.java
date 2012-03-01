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
package com.ncwitmobileapp.server;

import java.util.logging.Logger;

import javax.servlet.ServletContext;

public class Message {

  private static final Logger log = Logger.getLogger(Message.class.getName());

  private final ServletContext context;

  String recipient;

  String message;

  public Message(ServletContext context) {
    this.context = context;
  }

  public String getRecipient() {
    return recipient;
  }

  public String getMessage() {
    return message;
  }

  public String send() {
    log.info("send " + this);
    try {
      return SendMessage.sendMessage(context, recipient, message);
    } catch (Exception e) {
      return "Failure: Got exception in send: " + e.getMessage();
    }
  }

  public void setRecipient(String recipient) {
    this.recipient = recipient;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public String toString() {
    return "Message [recipient=" + recipient + ", message=" + message + "]";
  }
}
