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

    @FXML
    public Label errorLabel;

    private int lettersAmount = 8;

    public void initialize() {
        errorLabel.setVisible(false);

        lettersAmountSlider.valueProperty().addListener((observable, oldVal, newVal) -> {
            lettersAmount = newVal.intValue();
            amountLabel.setText(Integer.toString(lettersAmount));
        });
    }

    public void selectNone(){
        numbersCheckbox.setSelected(false);
        bigLettersCheckbox.setSelected(false);
        smallLettersCheckbox.setSelected(false);
        specialSymbolsCheckbox.setSelected(false);
    }

    public void selectAll(){
        errorLabel.setVisible(false);
        numbersCheckbox.setSelected(true);
        bigLettersCheckbox.setSelected(true);
        smallLettersCheckbox.setSelected(true);
        specialSymbolsCheckbox.setSelected(true);
    }

    public void hideErrorLabel(){
        errorLabel.setVisible(false);
    }

    public void generatePassword(){
        String password = "";
        int lettersCreated = 0;

        boolean numbers = numbersCheckbox.isSelected();
        boolean bigLetters = bigLettersCheckbox.isSelected();
        boolean smallLetters = smallLettersCheckbox.isSelected();
        boolean specialSymbols = specialSymbolsCheckbox.isSelected();

        if(!numbers && !bigLetters && !smallLetters && !specialSymbols){
            errorLabel.setVisible(true);
            return;
        }

        while(lettersCreated != lettersAmount){
            password += generateLetter(numbers, bigLetters, smallLetters, specialSymbols);
            lettersCreated++;
        }

        passwordTextField.setText(password);
    }

    public char generateLetter(boolean numbers, boolean bigLetters, boolean smallLetters, boolean specialSymbols){
        /*
        Special Symbols - 33-47, 58-64, 91-96, 123-125
        Numbers         - 48-57
        BigLetters      - 65-90
        SmallLetters    - 97-122
         */
        return 65;
    }

}
