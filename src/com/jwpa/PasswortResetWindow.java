package com.jwpa;

import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

@SuppressWarnings("serial")
public class PasswortResetWindow extends Window {

    public PasswortResetWindow() {
        super();

        final TextField email = new TextField("Enter your email address");
        final Button cancel = new Button("Close", new Button.ClickListener() {

            @Override
            public void buttonClick(final ClickEvent event) {
                close();

            }
        });

        final Button confirm = new Button("Reset password",
                new Button.ClickListener() {

                    @Override
                    public void buttonClick(final ClickEvent event) {
                        if (!email.getValue().isEmpty()) {
                            close();
                            Notification.show("Password changed",
                                    "We have sent the instructions on how to "
                                            + "reset the password through mail",
                                    Notification.Type.WARNING_MESSAGE);
                        }

                    }
                });

        final VerticalLayout contents = new VerticalLayout(email,
                new HorizontalLayout(cancel, confirm));

        this.setContent(contents);
        this.setModal(true);
        this.center();
    }

    public PasswortResetWindow(final String caption) {
        super(caption);
        // TODO Auto-generated constructor stub
    }

    public PasswortResetWindow(final String caption, final Component content) {
        super(caption, content);
        // TODO Auto-generated constructor stub
    }

}
