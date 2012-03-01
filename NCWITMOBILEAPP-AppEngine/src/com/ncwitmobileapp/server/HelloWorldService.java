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

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import java.util.Date;
import java.util.logging.Logger;

public class HelloWorldService {

  private static final Logger log = Logger.getLogger(HelloWorldService.class.getName());

  public HelloWorldService() {
  }

  public static String getMessage() {
    UserService userService = UserServiceFactory.getUserService();
    User user = userService.getCurrentUser();
    String message;
    if (user == null) {
      message = "No one is logged in!\nSent from App Engine at " + new Date();
    } else {
      message = "Hello, " + user.getEmail() + "!\nSent from App Engine at " + new Date();
    }
    log.info("Returning message \"" + message + "\"");
    return message;
  }
}
