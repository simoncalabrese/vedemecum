package frontend;

import api.dto.StrumentationDto;
import ejb.service.StrumentationService;
import api.utils.Enumerators;
import api.utils.UtilDate;
import api.utils.UtilValue;
import frontend.Dispatcher.ViewDispatcher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;

/**
 * Created by user on 22/09/16.
 */
public class StrumentationController {
    StrumentationService strumentationService = new StrumentationService();
    ViewDispatcher dispatcher = ViewDispatcher.getDispatcher();


    @FXML
    private TableView<StrumentationDto> table;

    @FXML
    private TableColumn<StrumentationDto, String> idCol;

    @FXML
    private TableColumn<StrumentationDto, String> desCol;

    @FXML
    private TableColumn<StrumentationDto, String> modelCol;

    @FXML
    private TableColumn<StrumentationDto, String> marcCol;

    @FXML
    private TableColumn<StrumentationDto, String> totCol;

    @FXML
    private TableColumn<StrumentationDto, String> dtCol;

    @FXML
    private Label idLabel;

    @FXML
    private TextField desText;

    @FXML
    private TextField modelText;

    @FXML
    private TextField marcText;

    @FXML
    private TextField totText;

    @FXML
    private DatePicker date;

    @FXML
    void btnAdd() {
        StrumentationDto dto = validDto();
        if (dto != null) {
            if (strumentationService.insertStrumentation(dto)) {
                populateTable();
            } else {
                dispatcher.alert(Enumerators.Alert.INSERT, "Strumentazioni");
            }
        } else {
            dispatcher.alert(Enumerators.Alert.VALUES, null);
        }

    }

    private StrumentationDto validDto() {
        StrumentationDto dto = new StrumentationDto();
        dto.setIdStrumentazione(UtilValue.isNumeric(idLabel.getText(), Integer::valueOf)
                ? idLabel.getText()
                : null);
        dto.setDesStrumentazione(desText.getText() != ""
                ? desText.getText().toUpperCase()
                : "");

        dto.setMarcaStrumentazione(marcText.getText() != ""
                ? marcText.getText().toUpperCase()
                : "");
        dto.setModelloStrumentazione(modelText.getText() != ""
                ? modelText.getText().toUpperCase()
                : "");
        dto.setPezzi(UtilValue.isNumeric(totText.getText(), Integer::valueOf)
                ? totText.getText()
                : null);
        dto.setDtAcquisto(date.getValue() != null
                ? UtilDate.toString(date.getValue())
                : null);
        return dto;
    }

    @FXML
    void btnDel() {
        if (UtilValue.isNumeric(idLabel.getText(), Integer::valueOf)) {
            if (strumentationService.deleteStrumentation(Integer.valueOf(idLabel.getText()))) {
                populateTable();
                cleanText();
            } else {
                dispatcher.alert(Enumerators.Alert.DELETE, "Impianti");
            }
        }else {
            dispatcher.alert(Enumerators.Alert.SELECTIONROW, null);
        }
    }

    @FXML
    void btnEdit() {
        if (UtilValue.isNumeric(idLabel.getText(),Integer::valueOf)) {
            StrumentationDto dto = validDto();
            if (dto != null) {
                if (strumentationService.updateStrumentation(dto)) {
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
            StrumentationDto spaceDto = table.getItems().get(table.getSelectionModel().getSelectedIndex());
            idLabel.setText(spaceDto.getIdStrumentazione());
            desText.setText(spaceDto.getDesStrumentazione());
            marcText.setText(spaceDto.getMarcaStrumentazione());
            modelText.setText(spaceDto.getModelloStrumentazione());
            totText.setText(spaceDto.getPezzi());
            date.setValue(UtilDate.toDate(spaceDto.getDtAcquisto()));
            table.getSelectionModel().clearSelection();
        } else {
            System.out.println(idLabel.getText());
            if (UtilValue.isNumeric(idLabel.getText(), Integer::valueOf)) {
                cleanText();
            }
        }
    }

    private void cleanText() {
        idLabel.setText("");
        desText.setText("");
        modelText.setText("");
        marcText.setText("");
        totText.setText("");
        date.setValue(null);
    }

    @FXML
    void initialize() {
        idCol.setCellValueFactory(strumentation -> strumentation.getValue().idStrumentazioneProperty());
        desCol.setCellValueFactory(strumentation -> strumentation.getValue().desStrumentazioneProperty());
        modelCol.setCellValueFactory(strumentation -> strumentation.getValue().modelloStrumentazioneProperty());
        marcCol.setCellValueFactory(strumentation -> strumentation.getValue().marcaStrumentazioneProperty());
        totCol.setCellValueFactory(strumentation -> strumentation.getValue().pezziProperty());
        dtCol.setCellValueFactory(strumentation -> strumentation.getValue().dtAcquistoProperty());
        populateTable();
    }

    private void populateTable() {
        ObservableList<StrumentationDto> lists = FXCollections.observableArrayList();
        List<StrumentationDto> strumentationDto = strumentationService.getAllStrumentation();
        strumentationDto.forEach(lists::add);
        table.setItems(lists);
    }
}
