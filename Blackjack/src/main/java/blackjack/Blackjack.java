/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.awt.BorderLayout;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author mazz
 */
public class Blackjack //extends Application {
{
 /*   @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    } *\

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
       // launch(args);
       Deck deck = new Deck();
        deck.buildDeck();
        Card card = deck.drawCard();
        String plzwork = card.toString();
        System.out.println(plzwork);
        String sizeoflist = Integer.toString(deck.listSize());
        System.out.println(sizeoflist);
        
        JFrame window = new JFrame("Card Image");
        window.setSize(400, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        
        JPanel content = new JPanel(new BorderLayout());
        
        JLabel cardcontent = new JLabel(new ImageIcon(card.getCardImage()));
        cardcontent.setSize(300, 400);
        
        content.add(cardcontent);
        window.add(content);
        
        deck.buildDeck();
        sizeoflist = Integer.toString(deck.listSize());
        System.out.println(sizeoflist);
        
    }
    
}
