package view;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.*;
import service.ConfiguratorHelper;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
        Processor intel9900k = new Processor(Producer.Intel, "Core i7 9900k", 350, 85, 70);
        Processor ryzen3700x = new Processor(Producer.Amd, "Ryzen 3700x", 250, 75, 65);
        Processor ryzen3600 = new Processor(Producer.Amd, "Ryzen 3600", 150, 70, 55);
        Processor ryzen3800 = new Processor(Producer.Amd, "Ryzen 3800", 450, 89, 85);
        Processor intel9400f = new Processor(Producer.Intel, "Core i5 9400F", 170, 62, 50);
        ArrayList<Processor> processors = new ArrayList<>();
        processors.add(intel9900k);
        processors.add(ryzen3700x);
        processors.add(ryzen3600);
        processors.add(ryzen3800);
        processors.add(intel9400f);

        GraphicCard rtx2060s = new GraphicCard("Nvidia", "Rtx 2060 Super 8 Gb", 450, 75, 220);
        GraphicCard xt5700 = new GraphicCard("AMD", "Xt5700 8Gb", 350, 61, 240);
        GraphicCard rtx2070s = new GraphicCard("Nvidia", "Rtx 2070 Super 8Gb", 650, 85, 260);
        ArrayList<GraphicCard> graphicCards = new ArrayList<>();
        graphicCards.add(rtx2060s);
        graphicCards.add(xt5700);
        graphicCards.add(rtx2070s);

        Ram goodRamIdidium = new Ram("Good model.Ram", "IdidiumPro 3200 MHZ", 80, 3200);
        Ram ballistix = new Ram("Ballistix ", "BloodSport 3000 MHZ", 85, 3000);
        Ram corssair = new Ram("Corssair", "Vengance 2600 MHZ", 100, 2600);
        ArrayList<Ram> rams = new ArrayList<>();
        rams.add(goodRamIdidium);
        rams.add(ballistix);
        rams.add(corssair);


        MotherBoard gigabyteB450 = new MotherBoard("Gigabyte", " Aorus B450", 100, Socket.Am );
        MotherBoard gamingPlus = new MotherBoard("Msi", " GamingPlus B450", 120, Socket.Am);
        MotherBoard gigabyteZ390 = new MotherBoard("Gigabyte", " Aorus z390", 150,Socket.Lga);
        MotherBoard gigabyteZ370 = new MotherBoard("Asus", " Taichi z390", 250,Socket.Lga);
        ArrayList<MotherBoard> motherBoards = new ArrayList<>();
        motherBoards.add(gigabyteB450);
        motherBoards.add(gamingPlus);
        motherBoards.add(gigabyteZ390);
        motherBoards.add(gigabyteZ370);


        ListView<MotherBoard> motherBoardListView = new ListView<MotherBoard>();
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


        Label choseProcessorLabel = new Label("Wybierz procesor z listy");
        choseProcessorLabel.setLayoutX(25);
        choseProcessorLabel.setLayoutY(10);

        ListView<Processor> processorListView = new ListView<Processor>();
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

        Label choseGraphicCardLabel = new Label("Wybierz karte graficzna");
        choseGraphicCardLabel.setLayoutX(210);
        choseGraphicCardLabel.setLayoutY(10);
        choseGraphicCardLabel.setVisible(false);


        ListView<GraphicCard> graphicCardListView = new ListView<GraphicCard>();
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

        Label choseRamLabel = new Label("Wybierz pamiec model.Ram");
        choseRamLabel.setLayoutX(390);
        choseRamLabel.setLayoutY(10);
        choseRamLabel.setVisible(false);

        ListView ramListView = new ListView<ListView>();
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

        TableColumn processor = new TableColumn("processor");
        processor.setCellValueFactory(new PropertyValueFactory<>("model"));



        TableColumn graphicCardColumn = new TableColumn("graphicCard");
        TableColumn ramColumn = new TableColumn("ram");
        TableColumn motherBoardColumn = new TableColumn("Plyta Glowna");
        configurationTable.getColumns().addAll(processor, graphicCardColumn, ramColumn, motherBoardColumn);

        motherBoardColumn.setMinWidth(150);
        ramColumn.setMinWidth(150);
        processor.setMinWidth(150);
        graphicCardColumn.setMinWidth(150);

        configurationTable.getItems().addAll(Collections.singleton(configuratorHelper));




//        configurationTable.getItems().add(new Processor(Producer.Intel, "Core i7 9900k", 350, 85, 70));
//        processorColumn.setCellValueFactory(new PropertyValueFactory<>("getModel"));
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
                choseGraphicCardLabel.setVisible(true);
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
                choseRamLabel.setVisible(true);
                configuratorHelper.setGraphicCard(graphicCards.get(newValue.intValue()));
            }
        });

        ramListView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                motherBoardListView.setVisible(true);
                configuratorBar.setProgress(0.6);
                choseMotherBoard.setVisible(true);

                if (configuratorHelper.getProcessor().getProducer().equals(Producer.Intel)) {
                    List<MotherBoard> IntelMotherboards = motherBoards.stream()
                            .filter(g -> g.getSocket().equals(Socket.Lga))
                            .collect(Collectors.toList());
//                    for (model.MotherBoard s : IntelMotherboards)
//                        System.out.println(s.getModel());
                    motherBoardListView.getItems().addAll(IntelMotherboards);

                } else if (configuratorHelper.getProcessor().getProducer().equals(Producer.Amd)) {
                    List<MotherBoard> AmdMotherboards = motherBoards.stream().
                            filter(g -> g.getSocket().equals(Socket.Am))
                            .collect(Collectors.toList());

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
        group.getChildren().add(choseProcessorLabel);
        group.getChildren().add(ramListView);
        group.getChildren().add(choseGraphicCardLabel);
        group.getChildren().add(choseRamLabel);
        group.getChildren().add(progressLabel);
        group.getChildren().add(motherBoardListView);
        group.getChildren().add(choseMotherBoard);
        group.getChildren().add(configurationTable);
        Scene scene = new Scene(group, 1000, 500);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
