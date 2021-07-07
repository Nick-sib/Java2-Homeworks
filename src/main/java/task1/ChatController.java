package task1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ChatController {

    ObservableList<String> langs = FXCollections.observableArrayList();

    @FXML
    public ListView listMessages;

    @FXML
    public TextField txtMessageInput;

    @FXML
    public Button btnSendMessage;

    @FXML
    private void initialize() {
        listMessages.setItems(langs);
    }

    public void msgSend(ActionEvent actionEvent) {
        String msg = txtMessageInput.getText().trim();
        if (!msg.equals("")) {
            //для проверки обрезаем пробелы вначале вконце но добавляем полный текст
            langs.add(txtMessageInput.getText());
            txtMessageInput.clear();
        }
    }


}
