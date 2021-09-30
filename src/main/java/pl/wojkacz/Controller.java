package pl.wojkacz;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.concurrent.ThreadLocalRandom;

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

        int rand = ThreadLocalRandom.current().nextInt(1, 5);

        if(rand == 1 && specialSymbols){
            rand = ThreadLocalRandom.current().nextInt(1, 5);
            switch (rand){
                case 1:
                    return (char)(33 + ThreadLocalRandom.current().nextInt(0, 15));
                case 2:
                    return (char)(58 + ThreadLocalRandom.current().nextInt(0, 7));
                case 3:
                    return (char)(91 + ThreadLocalRandom.current().nextInt(0, 6));
                case 4:
                    return (char)(123 + ThreadLocalRandom.current().nextInt(0, 3));
            }
        }

        else if(rand == 2 && numbers){
            return (char)(48 + ThreadLocalRandom.current().nextInt(0, 10));
        }

        else if(rand == 3 && bigLetters){
            return (char)(65 + ThreadLocalRandom.current().nextInt(0, 26));
        }

        else if(rand == 4 && smallLetters){
            return (char)(97 + ThreadLocalRandom.current().nextInt(0, 26));
        }

        return generateLetter(numbers, bigLetters, smallLetters, specialSymbols);
    }

}
