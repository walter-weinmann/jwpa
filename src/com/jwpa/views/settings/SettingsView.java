package com.jwpa.views.settings;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class SettingsView extends VerticalLayout implements View {

    private final TextField username = new TextField("Your name:");
    private final TextField email = new TextField("Your email:");
    private final PasswordField password = new PasswordField("New password");

    private final Button save = new Button("Save changes");
    private final Button cancel = new Button("Cancel changes");
    private final Button recipes = new Button("Your recipes");

    public SettingsView() {
        super();

        for (Component c : new Component[] { username, email, password, save,
                cancel, recipes }) {
            this.addComponent(c);
        }

    }

    @Override
    public void enter(ViewChangeEvent event) {
        // TODO Auto-generated method stub

    }

}
