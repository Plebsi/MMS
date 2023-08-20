package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Memberships;
import model.SuperMarket;
import model.Membership;
import model.MMS;
import model.MMSreport;




public class SuperMarketController extends Controller<SuperMarket> {
    Memberships memberships = new Memberships();
    SuperMarket superMarket = new SuperMarket();

    public final SuperMarket getSupermarket() {
        return model;
    }

    @FXML private TableView<Membership> membershipsTv;
    @FXML private Button addBtn;
    @FXML private Button deleteBtn;
    @FXML private Button selectBtn;
    @FXML private Button slipBtn;
    @FXML private Button reportBtn;
    @FXML private Button closeBtn;


    @FXML private TextField nameText;
    @FXML private TextField emailText;
    @FXML private TableColumn<Memberships, String> nameColumn;
    @FXML private TableColumn<Memberships, String> emailColumn;
    @FXML private TableColumn<Memberships, String> phoneColumn;
    private String getName() {
        return nameText.getText();
    }

    private String getEmail() {
        return emailText.getText();
    }


    @FXML private void initialize(){

        nameText.textProperty().addListener(Event -> getSupermarket().filterList(getName(), "0"));
        emailText.textProperty().addListener(Event -> getSupermarket().filterList("0", getEmail()));

        membershipsTv.getSelectionModel().selectedItemProperty().addListener((observer, oldValue, newValue) -> deleteBtn.setDisable(newValue == null));
        membershipsTv.getSelectionModel().selectedItemProperty().addListener((observer, oldValue, newValue) -> selectBtn.setDisable(newValue == null));
        membershipsTv.getSelectionModel().selectedItemProperty().addListener((observer, oldValue, newValue) -> slipBtn.setDisable(newValue == null));

    }

    public void pressSelect(ActionEvent event) throws Exception{
        Membership m = membershipsTv.getSelectionModel().getSelectedItem();
        String name = m.getName();
        Stage s20 = new Stage();
        s20.getIcons().add(new Image("/view/edit.png"));
        ViewLoader.showStage(m, "/view/Membership.fxml", "Accessing File: " + name, s20);

    }

    private Membership getSelectedMembership() {
        return membershipsTv.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void pressSlip(ActionEvent event) throws Exception{
        Image icon = new Image(getClass().getResourceAsStream("/view/edit.png"));
        Stage slipStage = new Stage();
        slipStage.getIcons().add(icon);
        ViewLoader.showStage(getSelectedMembership(), "/view/slip.fxml", getSelectedMembership().getName() + " SLIP Report", slipStage);
    }

    @FXML
    private void pressReport(ActionEvent event) throws Exception{
        Stage reportS = new Stage();
        reportS.getIcons().add(new Image("/view/uts.jpeg"));
        ViewLoader.showStage(new MMS(model), "/view/mms.fxml", "MMS Report", reportS);
    }

    @FXML
    private void pressDelete() {
        model.removeMembership(membershipsTv.getSelectionModel().getSelectedItem());
    }

    public void pressAdd(ActionEvent event) throws Exception{
        Membership membership = new Membership("","","","","",0.0);
        Stage s = new Stage();
        ViewLoader.showStage(membership, "/view/Membership.fxml", "Adding New Membership", s);
        s.getIcons().add(new Image("/view/edit.png"));

    }


    @FXML public void prsclose(ActionEvent event) throws Exception{
        stage.close();
    }

}
