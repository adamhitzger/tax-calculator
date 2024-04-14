package net.stredniskola.adamhitzger.it.files;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class FileController {
    @FXML
    private Text cista;

    @FXML
    private Text deti;

    @FXML
    private TextField hodnoceniInput;

    @FXML
    private TextField mzdaInput;

    @FXML
    private Text soc;

    @FXML
    private Text zaloha;

    @FXML
    private Text zdrav;

    private int kids =0;

    final double sleva = 2320.0;
    final double dite = 1267.0;
    final double dvedeti = 1617.0;
    final double vicedeti = 2017.0;

    final double socialni = 0.065;
    final double zdravotni = 0.045;
    final double dan = 0.15;

    @FXML
    void minus(ActionEvent event) {
        kids = Integer.parseInt(deti.getText());
        if(kids > 0) kids--;
        else kids = 3;
        deti.setText(Integer.toString(kids));
    }

    @FXML
    void plus(ActionEvent event) {
        deti.setText(Integer.toString(kids++));
    }

    @FXML
    void calculate(ActionEvent event) {
        double vypocet;
        double socialko;
        double zdravko;
        double hrubaMzda = Double.parseDouble(mzdaInput.getText());
        double ohodnoceni = Double.parseDouble(hodnoceniInput.getText());
        vypocet = hrubaMzda + ohodnoceni;
        socialko = vypocet*socialni;
        zdravko = vypocet*zdravotni;
        soc.setText(Double.toString(socialko) + "Kč");
        zdrav.setText(Double.toString(zdravko) + "Kč");
        double tax = vypocet * dan;
        vypocet = vypocet - zdravko - socialko;
        tax -= sleva;
        kids = Integer.parseInt(deti.getText());
        switch(kids){
            case 0:
                tax -= 0.0;
                break;
            case 1:
                tax -= dite;
                break;
            case 2:
                tax -= (dite + dvedeti);
                break;
            case 3:
                tax -= (dite + dvedeti+vicedeti);
                break;
            default:
                tax -= (dite + dvedeti + vicedeti + (kids-3 * vicedeti));
                break;
        }
        if(tax > 0){
            zaloha.setText(Double.toString(tax) + "Kč");
            vypocet -= tax;
        }else {
            tax = Math.abs(tax);
            zaloha.setText("Bonus: " + tax + "Kč");
            vypocet += tax;
        }


        cista.setText(Double.toString(vypocet) + "Kč");
    }
}