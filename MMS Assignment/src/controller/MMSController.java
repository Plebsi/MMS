package controller;


import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import model.MMSreport;
import model.Memberships;
import model.MMS;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import java.text.DecimalFormat;



public class MMSController extends Controller<MMS> {

    public MMS getMMS(){
        return model;
    }

   /*  DecimalFormat decimal2 = new DecimalFormat("#.00");

    @FXML
    private TableView<MMSreport> mmsTv;
    @FXML
    private Text totalExpense;
    @FXML
    private Text AvgGasDeductionRate;
    @FXML
    private Text AvgPayPerCredit;
    @FXML
    private Text totalCredits;
    @FXML
    private Text AvgDeductionRate;
    @FXML
    private Text totalDollarAvailable;


    @FXML
    private void initialize() {
    }*/


    public void pressCloseBtn(ActionEvent event) throws Exception{
        stage.close();
    }

}
