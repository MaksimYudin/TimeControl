package org.russianfeature;

import com.hibernate.crud.operations.HibernateUtil;
import com.utils.Config;
import com.utils.EnumAction;
import com.utils.ExcelReader;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.russianfeature.controllers.*;
import org.russianfeature.model.Student;

public class Main extends Application {

    private Stage primaryStage;
    private AnchorPane root;
    private AnchorPane currentWorkPlace;

    @Override
    public void start(Stage primaryStage) throws Exception{

        Config.setScreenProperty();

        this.primaryStage = primaryStage;

        initRoot();

        showMainWorkPlace();

    }


    public static void main(String[] args) {
        launch(args);
    }

    public void initRoot() {
        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/fxml/MainForm.fxml"));
            root = (AnchorPane) loader.load();

            primaryStage.setTitle("Time control BEST");
            primaryStage.setScene(new Scene(root, Config.MAIN_FORM_WIDTH, Config.MAIN_FORM_HEIGHT));
            primaryStage.show();

            MainFormController controller = loader.getController();
            controller.setMainApp(this);

        }catch (Exception e) {
            System.out.printf(e.toString());
        }
    }


    public void showMainWorkPlace() {

        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/fxml/MainWorkPlace.fxml"));
            AnchorPane workPlace = (AnchorPane) loader.load();

            //if (currentWorkPlace != null && currentWorkPlace.getId().equals(workPlace.getId()))
            if (isValidToShowWorkPlace(workPlace))
                return;

            root.getChildren().add(workPlace);
            workPlace.setId("mainWorkPlace");

            currentWorkPlace = workPlace;

            // Bind controller and main app
            MainWorkPlaceController controller = loader.getController();
            controller.setMainApp(this);
            controller.setPlaceProperty();


        } catch (IOException e) {
            System.out.printf(e.toString());
        }

    }

    public void showSettingsWorkPlace() {

        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/fxml/SettingsForm.fxml"));
            AnchorPane workPlace = (AnchorPane) loader.load();

            if (isValidToShowWorkPlace(workPlace))
                return;

            root.getChildren().add(workPlace);
            workPlace.setId("settingsWorkPlace");

            currentWorkPlace = workPlace;

            // Bind controller and main app
            SettingsFormController controller = loader.getController();
            controller.setMainApp(this);
            controller.setPlaceProperty();


        } catch (IOException e) {
            System.out.printf(e.toString());
        }

    }

    public void showDictionaryWorkPlace() {

        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/fxml/DictionaryForm.fxml"));
            AnchorPane workPlace = (AnchorPane) loader.load();

            if (isValidToShowWorkPlace(workPlace))
                return;

            root.getChildren().add(workPlace);
            workPlace.setId("dictionaryWorkPlace");

            currentWorkPlace = workPlace;

            // Bind controller and main app
            DictionaryFormController controller = loader.getController();
            controller.setMainApp(this);
            controller.setPlaceProperty();


        } catch (IOException e) {
            System.out.printf(e.toString());
        }

    }

    public void showGroupsWorkPlace() {

        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/fxml/GroupsForm.fxml"));
            AnchorPane workPlace = (AnchorPane) loader.load();

            if (isValidToShowWorkPlace(workPlace))
                return;

            root.getChildren().add(workPlace);
            workPlace.setId("groupsWorkPlace");

            currentWorkPlace = workPlace;

            // Bind controller and main app
            GroupsFormController controller = loader.getController();
            controller.setMainApp(this);
            controller.setPlaceProperty();


        } catch (IOException e) {
            System.out.printf(e.toString());
        }

    }

    public void showSheduleWorkPlace() {

        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/fxml/SheduleForm.fxml"));
            AnchorPane workPlace = (AnchorPane) loader.load();

            if (isValidToShowWorkPlace(workPlace))
                return;

            root.getChildren().add(workPlace);
            workPlace.setId("sheduleWorkPlace");

            currentWorkPlace = workPlace;

            // Bind controller and main app
            SheduleFormController controller = loader.getController();
            controller.setMainApp(this);
            controller.setPlaceProperty();


        } catch (IOException e) {
            System.out.printf(e.toString());
        }

    }

    public void showManualWorkPlace() {

        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/fxml/ManualForm.fxml"));
            AnchorPane workPlace = (AnchorPane) loader.load();

            if (isValidToShowWorkPlace(workPlace))
                return;

            root.getChildren().add(workPlace);
            workPlace.setId("manualWorkPlace");

            currentWorkPlace = workPlace;

            // Bind controller and main app
            ManualFormController controller = loader.getController();
            controller.setMainApp(this);
            controller.setPlaceProperty();


        } catch (IOException e) {
            System.out.printf(e.toString());
        }

    }

    public void showReportsWorkPlace() {

        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/fxml/ReportsForm.fxml"));
            AnchorPane workPlace = (AnchorPane) loader.load();

            if (isValidToShowWorkPlace(workPlace))
                return;

            root.getChildren().add(workPlace);
            workPlace.setId("reportsWorkPlace");

            currentWorkPlace = workPlace;

            // Bind controller and main app
            ReportsFormController controller = loader.getController();
            controller.setMainApp(this);
            controller.setPlaceProperty();


        } catch (IOException e) {
            System.out.printf(e.toString());
        }

    }

    public void showDictionaryStudentsMain() {

        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/fxml/StudentsListForm.fxml"));
            AnchorPane workPlace = (AnchorPane) loader.load();

            if (isValidToShowWorkPlace(workPlace))
                return;

            root.getChildren().add(workPlace);
            workPlace.setId("dictionaryStudentsMain");

            currentWorkPlace = workPlace;

            // Bind controller and main app
            StudentsListFormController controller = loader.getController();
            controller.setMainApp(this);
            controller.setPlaceProperty();


        } catch (IOException e) {
            System.out.printf(e.toString());
        }

    }

    public void showDictionaryStudentsAction(EnumAction action) {

        try {

            Stage studentDialogAction = new Stage();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/fxml/StudentEditForm.fxml"));
            AnchorPane studentAction = loader.load();

            studentAction.setId("dictionaryStudentsFormAction");

            // Bind controller and main app
            StudentEditFormController controller = loader.getController();
            controller.setMainApp(this);
            controller.setStage(studentDialogAction);
            controller.setAction(action);

            studentDialogAction.setScene(new Scene(studentAction));
            studentDialogAction.initOwner(primaryStage);
            studentDialogAction.initModality(Modality.APPLICATION_MODAL);
            studentDialogAction.showAndWait();


        } catch (IOException e) {
            System.out.printf(e.toString());
        }

    }

    public void removeWorkPlace(String NewPlaceId) {
        String currentWorkPalceId = this.getCurrentWorkPlace().getId();
        if (!currentWorkPalceId.equals(NewPlaceId)) {
            AnchorPane delPanel = (AnchorPane) this.getRoot().lookup("#" + currentWorkPalceId);
            this.getRoot().getChildren().remove(delPanel);
        }
    }

    boolean isValidToShowWorkPlace(AnchorPane workPlace) {
        return (currentWorkPlace != null && currentWorkPlace.getId().equals(workPlace.getId()));
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public AnchorPane getCurrentWorkPlace() {
        return currentWorkPlace;
    }

    public AnchorPane getRoot() {
        return root;
    }

    public void setCurrentWorkPlace(AnchorPane mainWorkPlace) {
        this.currentWorkPlace = mainWorkPlace;
    }
}
