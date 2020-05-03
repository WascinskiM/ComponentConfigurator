
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;



import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Configurator extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        ConfiguratorHelper configuratorHelper = new ConfiguratorHelper();


        //create Configuration Progress Bar
        ProgressBar configuratorBar = new ProgressBar();
        configuratorBar.setLayoutX(250);
        configuratorBar.setLayoutY(450);
        configuratorBar.setMinHeight(20);
        configuratorBar.setMinWidth(500);
        configuratorBar.setProgress(0.0);

        //BarDescription
        Label progressLabel = new Label("Progres konfiguracji sprzetu");
        progressLabel.setLayoutX(420);
        progressLabel.setLayoutY(430);


        //addComponents
        Processor Intel9900k = new Processor("Intel", "Core i7 9900k", 350, 85, 70);
        Processor Ryzen3700x = new Processor("AMD", "Ryzen 3700x", 250, 75, 65);
        Processor Ryzen3600 = new Processor("AMD", "Ryzen 3600", 150, 70, 55);
        Processor Ryzen3800 = new Processor("AMD", "Ryzen 3800", 450, 89, 85);
        Processor Intel9400f = new Processor("Intel", "Core i5 9400F", 170, 62, 50);
        ArrayList<Processor> processors = new ArrayList<>();
        processors.add(Intel9900k);
        processors.add(Ryzen3700x);
        processors.add(Ryzen3600);
        processors.add(Ryzen3800);
        processors.add(Intel9400f);

        GraphicCard Rtx2060s = new GraphicCard("Nvidia", "Rtx 2060 Super 8 Gb", 450, 75, 220);
        GraphicCard Xt5700 = new GraphicCard("AMD", "Xt5700 8Gb", 350, 61, 240);
        GraphicCard Rtx2070s = new GraphicCard("Nvidia", "Rtx 2070 Super 8Gb", 650, 85, 260);
        ArrayList<GraphicCard> graphicCards = new ArrayList<>();
        graphicCards.add(Rtx2060s);
        graphicCards.add(Xt5700);
        graphicCards.add(Rtx2070s);

        Ram GoodRamIdidium = new Ram("Good Ram", "IdidiumPro 3200 MHZ", 80, 3200);
        Ram Ballistix = new Ram("Ballistix ", "BloodSport 3000 MHZ", 85, 3000);
        Ram Corssair = new Ram("Corssair", "Vengance 2600 MHZ", 100, 2600);
        ArrayList<Ram> rams = new ArrayList<>();
        rams.add(GoodRamIdidium);
        rams.add(Ballistix);
        rams.add(Corssair);


        MotherBoard GigabyteB450 = new MotherBoard("Gigabyte", " Aorus B450", 100, true, false);
        MotherBoard GamingPlus = new MotherBoard("Msi", " GamingPlus B450", 120, true, false);
        MotherBoard GigabyteZ390 = new MotherBoard("Gigabyte", " Aorus z390", 150, false, true);
        MotherBoard GigabyteZ370 = new MotherBoard("Asus", " Taichi z390", 250, false, true);
        ArrayList<MotherBoard> motherBoards = new ArrayList<>();
        motherBoards.add(GigabyteB450);
        motherBoards.add(GamingPlus);
        motherBoards.add(GigabyteZ390);
        motherBoards.add(GigabyteZ370);


        ListView<MotherBoard> motherBoardListView = new ListView();
        Label choseMotherBoard = new Label("Wybierz plyte glowna");
        choseMotherBoard.setVisible(false);
        choseMotherBoard.setLayoutX(560);
        choseMotherBoard.setLayoutY(10);

        motherBoardListView.setLayoutX(550);
        motherBoardListView.setLayoutY(30);
        motherBoardListView.setMaxHeight(200);
        motherBoardListView.setMaxWidth(150);
        motherBoardListView.setVisible(false);
        motherBoardListView.setCellFactory(param -> new ListCell<MotherBoard>() {
            @Override
            protected void updateItem(MotherBoard item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null || item.getModel() == null) {
                    setText("");
                } else {
                    setText(item.getModel());
                }
            }
        });
        //Create stream


        Label choseProcessor = new Label("Wybierz procesor z listy");
        choseProcessor.setLayoutX(25);
        choseProcessor.setLayoutY(10);

        ListView<Processor> processorListView = new ListView<>();
        processorListView.getItems().addAll(processors);
        processorListView.setLayoutX(20);
        processorListView.setLayoutY(30);
        processorListView.setMaxHeight(200);
        processorListView.setMaxWidth(150);

        processorListView.setCellFactory(param -> new ListCell<Processor>() {
            @Override
            protected void updateItem(Processor item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null || item.getModel() == null) {
                    setText("");
                } else {
                    setText(item.getModel());
                }
            }
        });

        Label choseGraphicCard = new Label("Wybierz karte graficzna");
        choseGraphicCard.setLayoutX(210);
        choseGraphicCard.setLayoutY(10);
        choseGraphicCard.setVisible(false);


        ListView<GraphicCard> graphicCardListView = new ListView<>();
        graphicCardListView.getItems().addAll(graphicCards);
        graphicCardListView.setLayoutX(200);
        graphicCardListView.setLayoutY(30);
        graphicCardListView.setMaxHeight(200);
        graphicCardListView.setMaxWidth(150);
        graphicCardListView.setVisible(false);
        graphicCardListView.setCellFactory(param -> new ListCell<GraphicCard>() {
            @Override
            protected void updateItem(GraphicCard item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null || item.getModel() == null) {
                    setText("");
                } else {
                    setText(item.getModel());
                }
            }
        });

        Label choseRam = new Label("Wybierz pamiec Ram");
        choseRam.setLayoutX(390);
        choseRam.setLayoutY(10);
        choseRam.setVisible(false);

        ListView ramListView = new ListView();
        ramListView.getItems().addAll(rams);
        ramListView.setLayoutX(380);
        ramListView.setLayoutY(30);
        ramListView.setMaxHeight(200);
        ramListView.setMaxWidth(150);
        ramListView.setVisible(false);
        ramListView.setCellFactory(param -> new ListCell<Ram>() {
            @Override
            protected void updateItem(Ram item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null || item.getModel() == null) {
                    setText("");
                } else {
                    setText(item.getModel());
                }
            }
        });


        TableView configurationTable = new TableView();
        configurationTable.setEditable(true);

        TableColumn processorColumn = new TableColumn("Procesor");
        processorColumn.setMinWidth(150);
        TableColumn graphicCardColumn = new TableColumn("Karta Graficzna");
        graphicCardColumn.setMinWidth(150);
        TableColumn ramColumn = new TableColumn("Pamiec Ram");
        ramColumn.setMinWidth(150);
        TableColumn motherBoardColumn = new TableColumn("Plyta Glowna");
        motherBoardColumn.setMinWidth(150);
        configurationTable.getColumns().addAll(processorColumn, graphicCardColumn, ramColumn, motherBoardColumn);
        configurationTable.setLayoutX(200);
        configurationTable.setLayoutY(250);
        configurationTable.setMinHeight(100);
        configurationTable.setMinWidth(600);
        configurationTable.setMaxHeight(110);
        configurationTable.setMaxWidth(410);
        configurationTable.setVisible(false);


        processorListView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                graphicCardListView.setVisible(true);
                choseGraphicCard.setVisible(true);
                configuratorBar.setProgress(0.2);
                configuratorHelper.setProcessor(processors.get(newValue.intValue()));
//                System.out.println("Wybrano:" + processors.get(newValue.intValue()).getModel());

            }
        });


        graphicCardListView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                ramListView.setVisible(true);
                configuratorBar.setProgress(0.4);
                choseRam.setVisible(true);
                configuratorHelper.setGraphicCard(graphicCards.get(newValue.intValue()));
            }
        });

        ramListView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                motherBoardListView.setVisible(true);
                configuratorBar.setProgress(0.6);
                choseMotherBoard.setVisible(true);

                if (configuratorHelper.getProcessor().getProducent() == "Intel") {
                    List<MotherBoard> IntelMotherboards = motherBoards.stream().filter(g -> g.isIntelcompability()).collect(Collectors.toList());
//                    for (MotherBoard s : IntelMotherboards)
//                        System.out.println(s.getModel());
                    motherBoardListView.getItems().addAll(IntelMotherboards);

                } else if (configuratorHelper.getProcessor().getProducent() == "AMD") {
                    List<MotherBoard> AmdMotherboards = motherBoards.stream().filter(g -> g.isAmdcompability()).collect(Collectors.toList());

                    motherBoardListView.getItems().addAll(AmdMotherboards);

                }


            }

        });

        motherBoardListView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                configuratorBar.setProgress(0.8);
                configurationTable.setVisible(true);
            }
        });

        Group group = new Group();
        group.getChildren().add(configuratorBar);
        group.getChildren().add(processorListView);
        group.getChildren().add(graphicCardListView);
        group.getChildren().add(choseProcessor);
        group.getChildren().add(ramListView);
        group.getChildren().add(choseGraphicCard);
        group.getChildren().add(choseRam);
        group.getChildren().add(progressLabel);
        group.getChildren().add(motherBoardListView);
        group.getChildren().add(choseMotherBoard);
        group.getChildren().add(configurationTable);
        Scene scene = new Scene(group, 1000, 500);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
