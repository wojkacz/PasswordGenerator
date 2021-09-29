package pl.wojkacz;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {

    @FXML
    public Slider lettersAmountSlider;

    @FXML
    public Label amountLabel;

    @FXML
    public CheckBox numbersCheckbox;

    @FXML
    public CheckBox bigLettersCheckbox;

    @FXML
    public CheckBox smallLettersCheckbox;

    @FXML
    public CheckBox specialSymbolsCheckbox;

    @FXML
    public TextField passwordTextField;

    public void initialize() {
        lettersAmountSlider.valueProperty().addListener((observable, oldVal, newVal) -> {
            amountLabel.setText(Integer.toString(newVal.intValue()));
        });
    }

    public void selectNone(){
        numbersCheckbox.setSelected(false);
        bigLettersCheckbox.setSelected(false);
        smallLettersCheckbox.setSelected(false);
        specialSymbolsCheckbox.setSelected(false);
    }

    public void selectAll(){
        numbersCheckbox.setSelected(true);
        bigLettersCheckbox.setSelected(true);
        smallLettersCheckbox.setSelected(true);
        specialSymbolsCheckbox.setSelected(true);
    }

    public void generatePassword(){
        String password = "TestPassword!";
        passwordTextField.setText(password);
    }

}
