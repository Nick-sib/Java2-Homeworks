package task2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javax.swing.text.View;
import java.awt.*;
import java.util.ArrayList;

public class CalcWindow {

    @FXML
    public Label curText;

    @FXML
    public Label ttlText;

    String num = "";
    char act = 0;
    ArrayList<Float> numbers = new ArrayList<>();
    ArrayList<Character> actions = new ArrayList<>();

    float calcResume() {
        float res = 0.0f;
        int i = 0;
        while (i < actions.size()) {
            switch (actions.get(i)) {
                case '*':
                    numbers.set(i, numbers.get(i) * numbers.get(i + 1));
                    numbers.remove(i+1);
                    actions.remove(i);
                    break;
                case '÷':
                    numbers.set(i, numbers.get(i) / numbers.get(i + 1));
                    numbers.remove(i+1);
                    actions.remove(i);
                    break;
                default: i++;
            }
        }
        i = 0;
        while (i < actions.size()) {
            switch (actions.get(i)) {
                case '+':
                    numbers.set(i, numbers.get(i) + numbers.get(i + 1));
                    numbers.remove(i + 1);
                    actions.remove(i);
                    break;
                case '-':
                    numbers.set(i, numbers.get(i) - numbers.get(i + 1));
                    numbers.remove(i + 1);
                    actions.remove(i);
                    break;
                default: i++;
            }
        }

        return numbers.get(0);
    }

    void fillTotalText(boolean addResum) {
        String s = "";
        for (int i = 0; i < Integer.min(numbers.size(), actions.size()); i++) {
            s = String.format("%s %s %s", s, numbers.get(i), actions.get(i));
        }
        if (numbers.size() > actions.size())
            s = String.format("%s %s", s, numbers.get(numbers.size()-1));
        if (numbers.size() < actions.size())
            s = String.format("%s %s", s, actions.get(actions.size()-1));
        if (addResum)
            s = s + " =";
        ttlText.setText(s);
    }

    public void btnClickNum(ActionEvent actionEvent) {
        num += ((javafx.scene.control.Button)  actionEvent.getSource()).getText();

        curText.setText(num);
        if (act != 0) {
            actions.add(act);
            fillTotalText(false);
            act = 0;
        }
    }

    public void btnClickAtn(ActionEvent actionEvent) {
        act = ((javafx.scene.control.Button)  actionEvent.getSource()).getText().charAt(0);

        curText.setText(String.valueOf(act));
        if (!num.equals("")) {
            numbers.add(Float.parseFloat(num));
            fillTotalText(false);
            num = "";
        }

    }

    public void btnClickResume(ActionEvent actionEvent) {
        if (!num.equals(""))
            numbers.add(Float.parseFloat(num));
        act = 0;
        num = "";
        fillTotalText(true);

        curText.setText(String.valueOf(calcResume()));
    }

    public void btnClickClear(ActionEvent actionEvent) {
        if (num.equals("")) {
            numbers.clear();
            actions.clear();
            ttlText.setText("");
        }
        num = "";
        curText.setText("0");
    }
}
