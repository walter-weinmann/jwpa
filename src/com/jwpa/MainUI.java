package com.jwpa;

import java.util.Spliterator;
import java.util.function.Consumer;

import javax.servlet.annotation.WebServlet;

import com.jwpa.views.food.FoodView;
import com.jwpa.views.register.RegisterView;
import com.jwpa.views.search.SearchView;
import com.jwpa.views.settings.SettingsView;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("JWPATheme")
@Title("xxxTitel")
public class MainUI extends UI {

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = MainUI.class)
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected final void init(final VaadinRequest request) {
        final VerticalLayout layout = new VerticalLayout();
        final CssLayout topBar = new CssLayout();
        final CssLayout viewLayout = new CssLayout();

        layout.addComponent(topBar);
        layout.addComponent(viewLayout);

        this.setContent(layout);

        final Navigator navigator = new Navigator(this, viewLayout);

        navigator.addView("food", FoodView.class);
        navigator.addView("register", RegisterView.class);
        navigator.addView("settings", SettingsView.class);
        navigator.addView("search", SearchView.class);
        navigator.addView("", SearchView.class);

        for (final String s : new String[] { "food", "register", "settings",
                "search" }) {
            topBar.addComponent(this.createNavigationButton(s, navigator));
        }

        topBar.addComponent(this.createLoginForm());
    }

    private Button createNavigationButton(final String state,
            final Navigator navigator) {
        return new Button("Go to " + state, new Button.ClickListener() {

            @Override
            public void buttonClick(final ClickEvent event) {
                navigator.navigateTo(state);

            }
        });
    }

    private Component createLoginForm() {
        final GridLayout loginForm = new GridLayout(2, 2);

        final TextField email = new TextField("Email");
        final PasswordField password = new PasswordField("Pasword");

        final Button login = new Button("Log in");
        final Button forgot = new Button("Forgot password");

        login.addClickListener(new Button.ClickListener() {

            @Override
            public void buttonClick(final ClickEvent event) {
                Notification.show("Logging in is not yet supported.",
                        Notification.Type.ERROR_MESSAGE);

            }
        });

        forgot.addClickListener(new Button.ClickListener() {

            @Override
            public void buttonClick(final ClickEvent event) {
                UI.getCurrent().addWindow(new PasswortResetWindow());

            }
        });

        loginForm.addComponent(email);
        loginForm.addComponent(password);
        loginForm.addComponent(login);
        loginForm.addComponent(forgot);

        return loginForm;
    }

    @Override
    public void forEach(final Consumer<? super Component> action) {
        // TODO Auto-generated method stub

    }

    @Override
    public final Spliterator<Component> spliterator() {
        // TODO Auto-generated method stub
        return null;
    }

}