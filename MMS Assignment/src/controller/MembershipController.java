package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;

import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Membership;
import model.Memberships;
import javafx.scene.control.cell.PropertyValueFactory;
import model.SuperMarket;
import model.MMS;
import javafx.scene.text.Text;

public class MembershipController extends Controller<Membership>  {

    Memberships memberships = new Memberships();

    public final Membership getMembership(){
        return model;
    }

    public final DecimalFormat decimal2 = new DecimalFormat("#.00");

    @FXML private TextField nameText;
    @FXML private TextField emailText;
    @FXML private TextField phoneText;
    @FXML private TextField addressText;
    @FXML private TextField idText;

    @FXML private Text typeT;
    @FXML private TextField expenseText;
    @FXML private Button addButton;
    @FXML private Button updateButton;

    @FXML private void initialize(){
        if(model.getName().equals("")){
            updateButton.setDisable(true);
        }
        else{
            addButton.setDisable(true);
        }
        nameText.setText(model.getName());
        emailText.setText(model.getEmail());
        phoneText.setText(model.getPhone());
        addressText.setText(model.getAddress());
        idText.setText(model.getID());
        expenseText.setText(String.valueOf(model.getexpense()));

    }

    @FXML public void prsAdd(ActionEvent event) throws Exception{    // this does not work, because of this there is no error window
        Membership membership = new Membership(nameText.getText(),
                emailText.getText(),
                phoneText.getText(),
                addressText.getText(),
                idText.getText(),
                Double.parseDouble(expenseText.getText()));
        memberships.addMembership(membership);
        stage.close();


    }
    @FXML public void prsUpdate(ActionEvent event) throws Exception{
        model.updateDetails(nameText.getText(),
                emailText.getText(),
                phoneText.getText(),
                addressText.getText(),
                idText.getText(),
                Double.parseDouble(expenseText.getText()));
        stage.close();
    }

    @FXML
    private void close(ActionEvent event) {
        stage.close();
    }

}
