/*
* Copyright 2011 Google Inc.
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
package com.ncwitmobileapp.client;

import com.google.gwt.animation.client.Animation;
import com.google.gwt.user.cellview.client.Header;
import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.RepeatingCommand;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.text.shared.SafeHtmlRenderer;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.RowStyles;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.Range;
import com.google.web.bindery.requestfactory.shared.Receiver;

import com.ncwitmobileapp.shared.TechicksmemberRequestFactory;
import com.ncwitmobileapp.shared.TechicksmemberProxy;
import com.ncwitmobileapp.shared.TechicksmemberRequest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UserPasswordWidget extends Composite {

 
  interface UserPasswordBinder extends UiBinder<Widget, UserPasswordWidget> {
  }

  public static final Comparator<? super TechicksmemberProxy> MEMBER_COMPARATOR = new Comparator<TechicksmemberProxy>() {
    public int compare(TechicksmemberProxy t0, TechicksmemberProxy t1) {
      // Sort by user name
         return t0.getUserName().compareTo(t1.getUserName());
    };

  };
  
  public static class UserPasswordTable extends CellTable<TechicksmemberProxy> {

    public Column<TechicksmemberProxy, String> passwordColumn;
    public Column<TechicksmemberProxy, String> deleteColumn;
    public Column<TechicksmemberProxy, String> usernameColumn;

    interface UserPasswordTableResources extends CellTable.Resources {
      @Source("UserPasswordTable.css")
      TableStyle cellTableStyle();
    }
    
    public class HTMLCell extends AbstractCell<String> {
		public HTMLCell() {
		}

		@Override
		public void render(Context context, String value, SafeHtmlBuilder sb) {
			if (value != null) {
				sb.appendHtmlConstant(value);
			}
		}
	}
  
    public class HTMLHeader extends Header<String> {
		private String html;

		public HTMLHeader(String html) {
			super(new HTMLCell());
			this.html = html;
		}

		@Override
		public String getValue() {
			return html;
		}
	}
    
    interface TableStyle extends CellTable.Style {
   
      String columnUserName();

      String columnPassword();

      String columnTrash();
    }

    private static UserPasswordTableResources resources = GWT.create(UserPasswordTableResources.class);

    public UserPasswordTable() {
      super(20, resources);

      usernameColumn = new Column<TechicksmemberProxy, String>(new TextCell()) {
        @Override
        public String getValue(TechicksmemberProxy object) {
          return object.getUserName();
        }
      };
            
      addColumn(usernameColumn, "Name");
      setColumnWidth(usernameColumn, 43.0, Unit.PCT);
      addColumnStyleName(0, "columnFill");
      addColumnStyleName(0, resources.cellTableStyle().columnUserName());

      passwordColumn =
          new Column<TechicksmemberProxy, String>(new TextCell()) {
            @Override
            public String getValue(TechicksmemberProxy object) {
            	return object.getUserPassword();
            }
          };
          
      addColumn(passwordColumn, "Password");
      setColumnWidth(passwordColumn, 42.0, Unit.PCT);
      addColumnStyleName(1, resources.cellTableStyle().columnPassword());

      ButtonCell buttonCell = new ButtonCell(new SafeHtmlRenderer<String>() {
        public SafeHtml render(String object) {
          return SafeHtmlUtils.fromTrustedString("<img src=\"delete.png\"></img>");
        }

        public void render(String object, SafeHtmlBuilder builder) {
          builder.append(render(object));
        }
      });

      deleteColumn = new Column<TechicksmemberProxy, String>(buttonCell) {
        @Override
        public String getValue(TechicksmemberProxy object) {
          return "\u2717"; // Ballot "X" mark
        }
      };
      addColumn(deleteColumn, "\u2717");
      setColumnWidth(deleteColumn, 5.0, Unit.PCT);
      addColumnStyleName(2, resources.cellTableStyle().columnTrash());
    }
  }
  
  class AndroidAnimation extends Animation {
    private static final int TOP = -50;
    private static final int BOTTOM = 150;
    Element element;

    public AndroidAnimation(Element element) {
      this.element = element;
    }

    @Override
    protected void onStart() {
      element.getStyle().setTop(TOP, Unit.PX);
    }

    @Override
    protected void onUpdate(double progress) {
      element.getStyle().setTop(TOP + (BOTTOM - TOP) * interpolate(progress), Unit.PX);
    }

    @Override
    protected void onComplete() {
      element.getStyle().setTop(TOP, Unit.PX);
    }
  }

  private static final int DELAY_MS = 1000;

  private static UserPasswordBinder uiBinder = GWT.create(UserPasswordBinder.class);

  @UiField
  Label userpasswordsignin;

  @UiField
  TextBox userPasswordInput;

  @UiField
  UserPasswordTable userPasswordTable;


  private final EventBus eventBus = new SimpleEventBus();
  private final TechicksmemberRequestFactory requestFactory = GWT
      .create(TechicksmemberRequestFactory.class);
  private List<TechicksmemberProxy> usernamePasswordList;

  public UserPasswordWidget() {
    initWidget(uiBinder.createAndBindUi(this));

    requestFactory.initialize(eventBus);

    ListDataProvider<TechicksmemberProxy> listDataProvider = new ListDataProvider<TechicksmemberProxy>();
    listDataProvider.addDataDisplay(userPasswordTable);
    usernamePasswordList = listDataProvider.getList();

    Element androidElement = getElement().getFirstChildElement().getFirstChildElement();
    final Animation androidAnimation = new AndroidAnimation(androidElement);

    userPasswordTable.setRowStyles(new RowStyles<TechicksmemberProxy>() {
      public String getStyleNames(TechicksmemberProxy row, int rowIndex) {
        Range visibleRange = userPasswordTable.getVisibleRange();
        int lastRow = visibleRange.getStart() + visibleRange.getLength() - 1;
        if (rowIndex == usernamePasswordList.size() - 1 || rowIndex == lastRow) {
          return "usernamePassword last";
        } else {
          return "usernamePassword";
        }
      }
    });

    userPasswordTable.deleteColumn.setFieldUpdater(new FieldUpdater<TechicksmemberProxy, String>() {
      public void update(int index, TechicksmemberProxy entry, String value) {
        TechicksmemberRequest request = requestFactory.techicksmemberRequest();
        request.deleteTechicksmember(entry).fire();
        usernamePasswordList.remove(entry);
      }
    });

    userPasswordInput.getElement().setPropertyString("placeholder", "Add new user/passwords here");

    userPasswordInput.addKeyUpHandler(new KeyUpHandler() {
      public void onKeyUp(KeyUpEvent event) {
    	int slashAt;
    	    	
        if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
          String input = userPasswordInput.getText();
          slashAt = input.indexOf((int)'/');
          if (slashAt >= 0) {
        	  String username = input.substring(0, slashAt);
        	  if (input.length()> (slashAt +1)) {
        		  String password = input.substring(slashAt+1);
        		  sendNewUsernamePasswordToServer(username, password);
        	  }
          }
          userPasswordInput.setText("");
          androidAnimation.run(400);
        }
      }
    });

    Scheduler.get().scheduleFixedDelay(new RepeatingCommand() {
      public boolean execute() {
        retrieveTechicksmembers();
        return true;
      }
    }, DELAY_MS);
  }

  private void retrieveTechicksmembers() {
    requestFactory.techicksmemberRequest().queryTechicksmembers().fire(new Receiver<List<TechicksmemberProxy>>() {
      @Override
      public void onSuccess(List<TechicksmemberProxy> members) {
        if (members.size() > 0) {
          userpasswordsignin.setText("Logged in as " + members.get(0).getEmailAddress());
        }

        // sort first
        ArrayList<TechicksmemberProxy> sortedMembers = new ArrayList<TechicksmemberProxy>(members);
        Collections.sort(sortedMembers, MEMBER_COMPARATOR);

        usernamePasswordList.clear();
        for (TechicksmemberProxy member : sortedMembers) {
          usernamePasswordList.add(member);
        }
      }
    });
  }

  /**
   * Send a new member to the server.
   */
  private void sendNewUsernamePasswordToServer(String username, String password) {
    TechicksmemberRequest request = requestFactory.techicksmemberRequest();
    TechicksmemberProxy techicksmember = request.create(TechicksmemberProxy.class);
    
    techicksmember.setUserName(username);
    techicksmember.setUserPassword(password);
    techicksmember.setNCWITmember(false);
    techicksmember.setBirthday(-1);
    techicksmember.setEmailAddress("");
    techicksmember.setReferralCode("");
    techicksmember.setSecurityAnswer("");
    techicksmember.setSecurityQuestion("");
    
    request.createTechicksmember(techicksmember).fire(new Receiver<TechicksmemberProxy>() {
        @Override
        public void onSuccess(TechicksmemberProxy member) {
        	usernamePasswordList.add(member);
        }
    });
  }
}