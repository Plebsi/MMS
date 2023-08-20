package controller;

import au.edu.uts.ap.javafx.Controller;
import java.text.DecimalFormat;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import model.Membership;
import java.text.DecimalFormat;

public class MMSlipController extends Controller<Membership>  {
    public Membership getMembership(){
        return model;
    }
    public final DecimalFormat decimalplace = new DecimalFormat("#.00");
    @FXML private Text creditsT;
    @FXML private Text totalExpenseT;
    @FXML private Text GasDeducT;
    @FXML private Text DollarAvailT;
    @FXML private Text deductionT;
    @FXML private Text PayPerCredit;
    @FXML private Button closeBtn;


    @FXML private void initialize(){
        setCredits();
        setpayPerCredits();
        setTotalExpenseT();
        setGasDeducT();
        setDollarAvailT();
        setDeduction();
    }

    private String getCredits() {
        return Double.toString(model.gettotalCredits());
    }

    private void setCredits() {
        creditsT.setText(getCredits());
    }

    private String getpayPerCredits() {
        return Double.toString(model.getPayPerCredit());
    }

    private void setpayPerCredits() {
        PayPerCredit.setText(getpayPerCredits() + "0");
    }

    private String getExpense() {
        return Double.toString(model.getexpense());
    }

    private void setTotalExpenseT() {
        totalExpenseT.setText("$" + getExpense() + "0");
    }

    private String getGas() {
        return Double.toString(model.getGasdeductionRate());
    }

    private void setGasDeducT() {
        GasDeducT.setText(getGas());
    }

    private String getDollarAvailable() {
        return Double.toString(model.getDollarAvailable());
    }

    private void setDollarAvailT() {
        DollarAvailT.setText("$" + getDollarAvailable() + "0");
    }

    private String getDeduction() {
        return Double.toString(model.getdeductionRate());
    }

    private void setDeduction() {
        deductionT.setText(getDeduction());
    }

    public void CloseBtn(ActionEvent event) throws Exception{
        stage.close();
    }


}
