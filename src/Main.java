import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.*;
import java.awt.*;

class GUI extends JFrame{

    public GUI(){
        initGUI();

        this.setTitle("Laboratorio JVES");
        this.setSize(800,800);
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void initGUI(){

    }

}


public class Main {
    public static void main(String[] args) {
        databaseManagement.initConnection();
        EventQueue.invokeLater(()-> {
            GUI miProjectGUI = new GUI();
        });

    }
}