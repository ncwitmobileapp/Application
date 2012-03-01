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

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.dom.client.TextAreaElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.ServerFailure;

import com.ncwitmobileapp.client.MyRequestFactory.HelloWorldRequest;
import com.ncwitmobileapp.client.MyRequestFactory.MessageRequest;
import com.ncwitmobileapp.shared.MessageProxy;

public class NCWITMOBILEAPPWidget extends Composite {

  private static final int STATUS_DELAY = 4000;
  private static final String STATUS_ERROR = "status error";
  private static final String STATUS_NONE = "status none";
  private static final String STATUS_SUCCESS = "status success";

  interface NCWITMOBILEAPPUiBinder extends UiBinder<Widget, NCWITMOBILEAPPWidget> {
  }

  private static NCWITMOBILEAPPUiBinder uiBinder = GWT.create(NCWITMOBILEAPPUiBinder.class);

  @UiField
  TextAreaElement messageArea;

  @UiField
  InputElement recipientArea;

  @UiField
  DivElement status;

  @UiField
  Button sayHelloButton;

  @UiField
  Button sendMessageButton;

  /**
   * Timer to clear the UI.
   */
  Timer timer = new Timer() {
    @Override
    public void run() {
      status.setInnerText("");
      status.setClassName(STATUS_NONE);
      recipientArea.setValue("");
      messageArea.setValue("");
    }
  };

  private void setStatus(String message, boolean error) {
    status.setInnerText(message);
    if (error) {
      status.setClassName(STATUS_ERROR);
    } else {
      if (message.length() == 0) {
        status.setClassName(STATUS_NONE);
      } else {
        status.setClassName(STATUS_SUCCESS);
      }
    }

    timer.schedule(STATUS_DELAY);
  }

  public NCWITMOBILEAPPWidget() {
    initWidget(uiBinder.createAndBindUi(this));
    sayHelloButton.getElement().setClassName("send centerbtn");
    sendMessageButton.getElement().setClassName("send");

    final EventBus eventBus = new SimpleEventBus();
    final MyRequestFactory requestFactory = GWT.create(MyRequestFactory.class);
    requestFactory.initialize(eventBus);

    sendMessageButton.addClickHandler(new ClickHandler() {
    public void onClick(ClickEvent event) {
        String recipient = recipientArea.getValue();
        String message = messageArea.getValue();
        setStatus("Connecting...", false);
        sendMessageButton.setEnabled(false);

        // Send a message using RequestFactory
        MessageRequest request = requestFactory.messageRequest();
        MessageProxy messageProxy = request.create(MessageProxy.class);
        messageProxy.setRecipient(recipient);
        messageProxy.setMessage(message);
        Request<String> sendRequest = request.send().using(messageProxy);
        sendRequest.fire(new Receiver<String>() {
          @Override
          public void onFailure(ServerFailure error) {
            sendMessageButton.setEnabled(true);
            setStatus(error.getMessage(), true);
          }

          @Override
          public void onSuccess(String response) {
            sendMessageButton.setEnabled(true);
            setStatus(response, response.startsWith("Failure:"));
          }
        });
      }
    });

    sayHelloButton.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        sayHelloButton.setEnabled(false);
        HelloWorldRequest helloWorldRequest = requestFactory.helloWorldRequest();
        helloWorldRequest.getMessage().fire(new Receiver<String>() {
          @Override
          public void onFailure(ServerFailure error) {
            sayHelloButton.setEnabled(true);
            setStatus(error.getMessage(), true);
          }

          @Override
          public void onSuccess(String response) {
            sayHelloButton.setEnabled(true);
            setStatus(response, response.startsWith("Failure:"));
          }
        });
      }
    });
  }
}
