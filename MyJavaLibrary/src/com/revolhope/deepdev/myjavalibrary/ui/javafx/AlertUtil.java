package com.revolhope.deepdev.myjavalibrary.ui.javafx;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.util.Pair;

/**
 * Class to provide methods for launch alerts and dialogs
 * @author deepdev
 */
public class AlertUtil
{
    private static Alert alert;
    
    /**
     * Method to show an alert. AlertType parameter must be set, other parameters can be null.
     * @param alertType AlertType enumeration of the alert. Can not be null.
     * @param title String representing title of the alert.
     * @param header String containing the header of the alert.
     * @param content String containing the content of the alert.
     */
    public static void show(AlertType alertType, String title, String header, String content)
    {
        alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
    /**
     * Method to show an error alert. It have AlertType = Error and, if title is null, it will be "Error" by default.
     * @param title String representing title of the alert. If it is null, it will be "Error"
     * @param header String containing the header of the alert.
     * @param content String containing the content of the alert.
     */
    public static void showError(String title, String header, String content)
    {
        alert = new Alert(AlertType.ERROR);
        alert.setTitle(title == null ? "Error" : title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
    /**
     *  Method to launch question alert.
     *  @param alertType AlertType of the alert. If it is null, it's value will be CONFIRMATION
     *  @param title String containing the title of the alert. If it is null, it's value will be "Confirmation"
     *  @param header String containing the header of the alert.
     *  @param content String containing the content of the alert.
     *  @param textButtonTrue String containing the text of the button that on click will return true. If it is null it will be "OK"
     *  @param textButtonFalse String containing the text of the button that on click will return false. If it is null it will be "Cancel"
     *  @return True if button clicked was the buttonTrue given, false otherwise.
     */
    public static boolean showQuestion(AlertType alertType, String title, String header, String content, String textButtonTrue, String textButtonFalse)
    {
        alert = new Alert(alertType == null ? AlertType.CONFIRMATION : alertType);
        alert.setTitle(title == null ? "Confirmation" : title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        
        ButtonType buttonTrue = new ButtonType(textButtonTrue == null ? "Ok" : textButtonTrue);
        ButtonType buttonFalse = new ButtonType(textButtonFalse == null ? "Cancel" : textButtonFalse);
        alert.getButtonTypes().setAll(buttonFalse, buttonTrue);
        Optional<ButtonType> result = alert.showAndWait();
        return result.get() == buttonTrue;
    }
    
    /**
     *  Method to launch question alert.
     *  @param alertType AlertType of the alert. If it is null, it's value will be CONFIRMATION
     *  @param title String containing the title of the alert. If it is null, it's value will be "Pick an option"
     *  @param header String containing the header of the alert.
     *  @param content String containing the content of the alert.
     *  @param textButtons String... containing the text of the buttons representing all choices. The button cancel is by default, do not include!
     *  @return Index of button clicked. May return -1 if button click have been "Cancel" or -404 in strange case, see method source.
     */
    public static int showMultiQuestion(AlertType alertType, String title, String header, String content, String... textButtons)
    {
        alert = new Alert(alertType == null ? AlertType.CONFIRMATION : alertType);
        alert.setTitle(title == null ? "Pick an option" : title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        
        ArrayList<ButtonType> buttons = new ArrayList<>();
        for (String bt : textButtons)
        {
            buttons.add(new ButtonType(bt));
        }
        ButtonType cancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
        buttons.add(cancel);
        alert.getButtonTypes().setAll(buttons);
        
        Optional<ButtonType> result = alert.showAndWait();
        ButtonType resultButton = result.get();
        for (ButtonType bt : buttons)
        {
            if (bt == resultButton && bt != cancel)
            {
                return buttons.indexOf(bt);
            }
            else if (bt == resultButton && bt == cancel)
            {
                return -1;
            }
        }
        
        return -404;
    }
    
    /**
     *  Method to launch an Exception alert.
     *  @param title String containing the title of the alert, if it's null, it will be "Error - Exception thrown".
     *  @param header String containing the header of the alert, if it's null, it will be the type of the parameter exception.
     *  @param content String containing the content of the alert, if it's null, it will be the result of method getMessage() from exception given.
     *  @param exc Exception to be shown in the alert. It can not be null.
     */
    public static void showException(String title, String header, Exception exc)
    {
        if (exc == null) return;
        alert = new Alert(AlertType.ERROR);
        alert.setTitle(title == null ? "Error - Exception thrown" : title);
        alert.setHeaderText(header == null ? exc.getClass().getSimpleName() : header);
        alert.setContentText(exc.getMessage());
        
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        exc.printStackTrace(pw);
        String exceptionText = sw.toString();

        Label label = new Label("The exception stacktrace was:");

        TextArea textArea = new TextArea(exceptionText);
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);

        alert.getDialogPane().setExpandableContent(expContent);
        alert.showAndWait();
    }
    
    /**
     *  Method to launch a basic text input dialog.
     *  @param title String containing the title of the dialog. No default value if given is null.
     *  @param header String containing the header of the dialog. No default value if given is null.
     *  @param content String containing the content of the dialog. No default value if given is null.
     *  @param textBoxInitialValue String containing the initial value of the text box. If it is null it will be empty.
     *  @return String containing the input set on the text box. If result is not present, it will return an empty String, do not return Null value in anyway.
     */
    public static String showDialogTextInput(String title, String header, String content, String textBoxInitialValue)
    {
        TextInputDialog dialog = new TextInputDialog(textBoxInitialValue == null ? "" : textBoxInitialValue);
        dialog.setTitle(title);
        dialog.setHeaderText(header);
        dialog.setContentText(content);

        Optional<String> result = dialog.showAndWait();
        return result.isPresent() ? result.get() : "";
    }
    
    /**
     *  Method to launch a basic choice box dialog.
     *  @param title String containing the title of the dialog. If it is null value is "Pick an option".
     *  @param header String containing the header of the dialog. No default value if given is null.
     *  @param content String containing the content of the dialog. No default value if given is null.
     *  @param choiceboxInitialValue String containing the initial value of the choice box. If it is null it will the first element of the choices list.
     *  @param choices List<String> containing all the possible choices of the dialog.
     *  @param needBlankValue Boolean, if it is true, a blank value will be added to choices.
     *  @param blankValue String Optional value, only needed if needBlankValue is true. Text of the blank value, in case needBlankValue is true and blankValue is no set, by default it will be an empty String
     *  @return String containing the choice box value. If result is not present, it will return an empty String, do not return Null value in anyway.
     */
    public static String showDialogChoiceBox(String title, String header, String content, String choiceboxInitialValue, List<String> choices, boolean needBlankValue, String blankValue)
    {
        ChoiceDialog<String> dialog;
        if (needBlankValue)
        {
            ArrayList<String> list = new ArrayList<>();
            list.addAll(choices);
            list.add(0, blankValue == null ? "" : blankValue);
            dialog = new ChoiceDialog<>(choiceboxInitialValue, list);
        }
        else
        {
            dialog = new ChoiceDialog<>(choiceboxInitialValue, choices);
        }
        
        dialog.setTitle(title == null ? "Pick an option" : title);
        dialog.setHeaderText(header);
        dialog.setContentText(content);
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent())
        {
            return result.get();
        }
        else
        {
            return "";
        }
    }
    
    /**
     *  Method to launch a basic login dialog. It does not make any validation, it's just an input dialog.
     *  @param title String containing the title of the dialog. If it is null the default value will be "Login"
     *  @param header String containing the header of the dialog. If it is null there is no default value.
     *  @param iconUrl String URL of the resource. It may be null.
     *  @param userLabel String containing the label for User, i.e.: user: / user name: / email: / etc.
     *  @param pwdLabel String containing the label for Password, i.e.: password: / email: / token: / etc.
     *  @param userPlaceholder String containing a placeholder for the User text box. If it is null, there won't be any value.
     *  @param pwdPlaceholder String containing a placeholder for the Password text box. If it is null, there won't be any value.
     *  @return Pair<String, String> if value is present: <user, password>. Null value will be returned otherwise.
     */
    public static Pair<String, String> showBasicLogin(String title, String header, String iconUrl, String userLabel, String pwdLabel, 
                                                      String userPlaceholder, String pwdPlaceholder)
    {
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle(title == null ? "Login" : title);
        dialog.setHeaderText(header);

        if (iconUrl != null)
        {
            dialog.setGraphic(new ImageView(iconUrl));
        }
        
        ButtonType loginButtonType = new ButtonType("Login", ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField username = new TextField();
        if (userPlaceholder != null)
        {
            username.setPromptText(userPlaceholder);
        }
        PasswordField password = new PasswordField();
        if (pwdPlaceholder != null)
        {
            password.setPromptText(pwdPlaceholder);
        }

        grid.add(new Label(userLabel == null ? "Username:" : userLabel), 0, 0);
        grid.add(username, 1, 0);
        grid.add(new Label(pwdLabel == null ? "Password:" : pwdLabel), 0, 1);
        grid.add(password, 1, 1);

        // Enable/Disable login button depending on whether a user name was entered.
        Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
        loginButton.setDisable(true);

        dialog.getDialogPane().setContent(grid);
        Platform.runLater(() -> username.requestFocus());

        // Convert the result to a user name-password-pair when the login button is clicked.
        dialog.setResultConverter(dialogButton -> 
        {
            if (dialogButton == loginButtonType)
            {
                return new Pair<>(username.getText(), password.getText());
            }
            return null;
        });

        Optional<Pair<String, String>> result = dialog.showAndWait();
        
        if (result.isPresent())
        {
        	return result.get();
        }
        else
        {
        	return null;
        }
    }
}
