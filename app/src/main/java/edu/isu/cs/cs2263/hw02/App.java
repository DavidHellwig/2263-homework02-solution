/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package edu.isu.cs.cs2263.hw02;

import com.google.common.collect.Maps;
import edu.isu.cs.cs2263.hw02.data.Course;
import edu.isu.cs.cs2263.hw02.views.AppView;
import edu.isu.cs.cs2263.hw02.views.CoursesFormView;
import edu.isu.cs.cs2263.hw02.views.DisplayListView;
import edu.isu.cs.cs2263.hw02.views.WelcomeView;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import lombok.Getter;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.MaterialDesignF;
import org.kordamp.ikonli.materialdesign2.MaterialDesignP;
import java.util.Map;
import java.util.Optional;
import java.util.Vector;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App extends Application {
    private static final Logger logger = LogManager.getLogger(App.class);

    private Vector<Course> courses;
    private AppView currentView;
    private final Map<String, AppView> views;
    private BorderPane mainLayout;
    private ChoiceBox<String> depts;
    private Scene scene;

    public App() {
        views = Maps.newHashMap();
        views.put("Welcome", new WelcomeView(this));
        views.put("DisplayList", new DisplayListView(this));
        views.put("CourseForm", new CoursesFormView(this));

        currentView = views.get("Welcome");
        courses = new Vector<>();
    }

    /**
     * The main entry point for all JavaFX applications.
     * The start method is called after the init method has returned,
     * and after the system is ready for the application to begin running.
     *
     * <p>
     * NOTE: This method is called on the JavaFX Application Thread.
     * </p>
     *
     * @param primaryStage the primary stage for this application, onto which
     *                     the application scene can be set.
     *                     Applications may create other stages, if needed, but they will not be
     *                     primary stages.
     * @throws Exception if something goes wrong
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        logger.info("App Class launched");
        primaryStage.setTitle("Course View");

        Button display = new Button("Display (dept.)");
        display.setOnAction(event -> {
           displayList();
        });
        display.setGraphic(FontIcon.of(MaterialDesignF.FORMAT_LIST_TEXT, 20));

        Button newCourse = new Button("New Course");
        newCourse.setOnAction(event -> {
            showCourseForm();
        });
        newCourse.setGraphic(FontIcon.of(MaterialDesignP.PLAYLIST_PLUS, 20));

        Button exit = new Button("Exit");
        exit.setOnAction(event -> {
            exit();
        });
        exit.setGraphic(FontIcon.of(MaterialDesignP.POWER, 20));

        depts = new ChoiceBox<>();
        depts.setOnAction(event -> {
            int selectedIndex = depts.getSelectionModel().getSelectedIndex();
            // update the display button
        });
        for (int i = 0; i < Course.CODES.length; i++) {
            logger.info(Course.DEPTS[i] + " added to Depts");
            depts.getItems().add(String.format("%s (%s)", Course.DEPTS[i], Course.CODES[i]));
        }
        depts.getSelectionModel().select(0);

        mainLayout = new BorderPane();

        BorderPane exitPane = new BorderPane();
        exitPane.setPadding(new Insets(10,10,10,10));
        exitPane.setRight(exit);

        mainLayout.setBottom(exitPane);

        BorderPane choiceLayout = new BorderPane();
        choiceLayout.setPadding(new Insets(10,10,10,10));
        Label deptLbl = new Label("Departments: ");
        choiceLayout.setLeft(deptLbl);
        choiceLayout.setCenter(depts);
        BorderPane.setAlignment(depts, Pos.CENTER_LEFT);
        BorderPane.setAlignment(deptLbl, Pos.CENTER_RIGHT);

        HBox buttons = new HBox(10, display, newCourse);
        HBox.setMargin(display, new Insets(10, 0, 10, 10));
        HBox.setMargin(newCourse, new Insets(10, 10, 10, 0));

        BorderPane topLayout = new BorderPane();
        topLayout.setCenter(choiceLayout);
        topLayout.setRight(buttons);

        mainLayout.setTop(topLayout);

        mainLayout.setCenter(currentView.getView());

        scene = new Scene(mainLayout, 600, 300);
        primaryStage.setScene(scene);
        FontIcon fi = FontIcon.of(MaterialDesignF.FLASK_EMPTY, 32);

        primaryStage.show();
    }

    public Vector<Course> getCourses() {
        return courses;
    }

    private void setView(String viewName) {
        logger.info("setView() method called in App");
        mainLayout.getChildren().remove(currentView.getView());
        currentView = views.get(viewName);
        mainLayout.setCenter(currentView.getView());
        mainLayout.requestLayout();
    }

    public void showCourseForm() {
        setView("CourseForm");
        currentView.updateData();
    }

    public void displayList() {
        setView("DisplayList");
        currentView.updateData();
    }

    public void exit() {
        logger.info("Exit button clicked in App");
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setContentText("Are you sure you want to exit?");

        Optional<ButtonType> result = alert.showAndWait();
        result.ifPresent(btnType -> {
            if (btnType.getButtonData().isDefaultButton())
                logger.info("System exit called");
                System.exit(0);
        });
    }

    public int getSelectedDepartment() {
        logger.info("getSelectedDepartment() method called in App");
        return depts.getSelectionModel().getSelectedIndex();
    }

    public void showWelcome() {
        logger.info("showWelcome() method called in App");
        setView("Welcome");
    }

    public void addCourse(Course course) {
        logger.info("addCourse() method called in App");
        logger.info(course.toString() + "was added to courses");
        courses.add(course);

    }

    public static void main(String[] args) {
        Application.launch(args);
    }


}
