
package frontend;


import api.dto.SpaceDto;
import ejb.service.SpaceService;
import api.utils.Enumerators;
import api.utils.UtilValue;
import frontend.Dispatcher.ViewDispatcher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.List;

public class SpaceController {
    SpaceService spaceService = new SpaceService();
    ViewDispatcher dispatcher = ViewDispatcher.getDispatcher();


    @FXML
    private TableView<SpaceDto> table;
    @FXML
    private TableColumn<SpaceDto, String> idCol;
    @FXML
    private TableColumn<SpaceDto, String> desCol;
    @FXML
    private TableColumn<SpaceDto, String> addressCol;
    @FXML
    private TableColumn<SpaceDto, String> roomCol;
    @FXML
    private TableColumn<SpaceDto, String> doorCol;
    @FXML
    private TableColumn<SpaceDto, String> windowCol;

    @FXML
    private Label idText;

    @FXML
    private TextField desText;

    @FXML
    private TextField addressText;

    @FXML
    private TextField roomText;

    @FXML
    private TextField doorText;

    @FXML
    private TextField windowText;

    @FXML
    void btnAdd() {
        SpaceDto spaceDto = validDto();
        if (spaceDto != null) {
            if (spaceService.insertSpace(spaceDto)) {
                populateTable();
            } else {
                dispatcher.alert(Enumerators.Alert.INSERT, "Impianti");
            }
        } else {
            dispatcher.alert(Enumerators.Alert.VALUES, null);
        }

    }

    @FXML
    void btnDel() {
        if (UtilValue.isNumeric(idText.getText(), Integer::valueOf)) {
            if (spaceService.deleteSpace(Integer.valueOf(idText.getText()))) {
                populateTable();
            } else {
                dispatcher.alert(Enumerators.Alert.DELETE, "Impianti");
            }
        }else {
            dispatcher.alert(Enumerators.Alert.SELECTIONROW, null);
        }
    }

    @FXML
    void btnEdit() {
        if (UtilValue.isNumeric(idText.getText(),Integer::valueOf)) {
            SpaceDto spaceDto = validDto();
            if (spaceDto != null) {
                if (spaceService.upadteSpace(spaceDto)) {
                    populateTable();
                    cleanText();
                } else {
                    dispatcher.alert(Enumerators.Alert.UPDATE, "Impianti");
                }
            } else {
                dispatcher.alert(Enumerators.Alert.VALUES, null);
            }
        } else {
            dispatcher.alert(Enumerators.Alert.SELECTIONROW, null);
        }
    }

    @FXML
    void btnHome() {
        dispatcher.dispatch(Enumerators.viewsPath.HOMEPAGE.getPath());
    }


    @FXML
    void gridAssign() {
        if (table.getSelectionModel().getSelectedIndex() >= 0) {
            SpaceDto spaceDto = table.getItems().get(table.getSelectionModel().getSelectedIndex());
            idText.setText(spaceDto.getIdSpace());
            desText.setText(spaceDto.getDesSpace());
            addressText.setText(spaceDto.getAddressSpace());
            roomText.setText(spaceDto.getAmntRoom());
            doorText.setText(spaceDto.getAmntDoor());
            windowText.setText(spaceDto.getAmntWindow());
            table.getSelectionModel().clearSelection();
        } else {
            if (UtilValue.isNumeric(idText.getText(), Integer::valueOf)) {
                cleanText();
            }
        }
    }

    private void cleanText() {
        idText.setText("");
        desText.setText("");
        addressText.setText("");
        roomText.setText("");
        doorText.setText("");
        windowText.setText("");
    }


    @FXML
    void initialize() {
        idText.setVisible(false);
        idCol.setCellValueFactory(param -> param.getValue().idSpaceProperty());
        desCol.setCellValueFactory(param -> param.getValue().desSpaceProperty());
        addressCol.setCellValueFactory(param -> param.getValue().addressSpaceProperty());
        roomCol.setCellValueFactory(param -> param.getValue().amntRoomProperty());
        doorCol.setCellValueFactory(param -> param.getValue().amntDoorProperty());
        windowCol.setCellValueFactory(param -> param.getValue().amntWindowProperty());
        populateTable();

    }

    private void populateTable() {
        List<SpaceDto> spaceDto = spaceService.getAllSpace();
        ObservableList<SpaceDto> lists = FXCollections.observableArrayList();
        spaceDto.forEach(lists::add);
        table.setItems(lists);
    }

    private SpaceDto validDto() {
        SpaceDto spaceDto = new SpaceDto();
        spaceDto.setIdSpace(UtilValue.isNumeric(idText.getText(), Integer::valueOf)
                ? idText.getText()
                : null);
        spaceDto.setDesSpace(desText.getText() != ""
                ? desText.getText().toUpperCase()
                : "");

        spaceDto.setAddressSpace(addressText.getText() != ""
                ? addressText.getText().toUpperCase()
                : "");
        if (UtilValue.isNumeric(roomText.getText(), Integer::valueOf)) {
            spaceDto.setAmntRoom(roomText.getText());
        } else {
            dispatcher.alert(Enumerators.Alert.VALUESNOTVALID, "numero stanze");
            return null;
        }

        if (UtilValue.isNumeric(doorText.getText(), Integer::valueOf)) {
            spaceDto.setAmntDoor(doorText.getText());
        } else {
            dispatcher.alert(Enumerators.Alert.VALUESNOTVALID, "numero porte");
            return null;
        }
        if (UtilValue.isNumeric(windowText.getText(), Integer::valueOf)) {
            spaceDto.setAmntWindow(windowText.getText());
        } else {
            dispatcher.alert(Enumerators.Alert.VALUESNOTVALID, "nuemro finestre");
            return null;
        }
        return spaceDto;
    }


}