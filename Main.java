
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import  java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;

public class Main
{
    JFrame window;
    Container con;
    JPanel titleNamePanel,startButtonPanel,MaintextPanel,choiceButtonPanel,playerPanel;
    JLabel titleNameLabel,hpLabel,hpLabelNumber,weaponLabel,weaponLabelNumber;
    Font titlefont = new Font("Times New Roman",Font.PLAIN,150);
    Font normalFont = new Font("kuch bhi",Font.PLAIN,50);
    Font  buttonFont = new Font("asdasda",Font.PLAIN,40);
    JButton startButton,choice1,choice2,choice3,choice4;
    JTextArea Maintextarea;
    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();
    int playerHP;
    String weapon,position;

    public static void main(String[] args)
    {
        new Main();
    }
    public Main()
    {
        window = new JFrame();
        window.setSize(1280,1024);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.red);
        window.setLayout(null);

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(120,100,1000,150);
        titleNamePanel.setBackground(Color.red);
        titleNameLabel = new JLabel("Adventure");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titlefont);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(350,400,500,500);
        startButtonPanel.setBackground(Color.red);

        startButton = new JButton("Start");
        startButton.setBackground(Color.red);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.addActionListener(tsHandler);
        startButton.setFocusPainted(false);



        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);
        window.add(titleNamePanel);
        window.add(startButtonPanel);
        window.setVisible(true);
    }
    public  void createGameScreen()
    {
        titleNamePanel.setVisible(false);
        startButton.setVisible(false);
        MaintextPanel = new JPanel();
        MaintextPanel.setBounds(50,270,1200,200);
        MaintextPanel.setBackground(Color.red);

        window.add(MaintextPanel);

        Maintextarea = new JTextArea("This is the main text area.jojasiodjoijlkjjjjjjjjjjjjjjjjjjjjjjjjj");
        Maintextarea.setBounds(50,270,1200,200);
        Maintextarea.setBackground(Color.red);
        Maintextarea.setForeground(Color.white);
        Maintextarea.setFont(normalFont);
        Maintextarea.setLineWrap(true);

        MaintextPanel.add(Maintextarea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(350,500,500,500);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setVisible(true);
        choiceButtonPanel.setLayout(new GridLayout(4,1));
        window.add(choiceButtonPanel);

        choice1 = new JButton("Choice 1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setVisible(true);
        choice1.setFocusPainted(false);
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("c1");
        choiceButtonPanel.add(choice1);

        choice2 = new JButton("Choice 2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choiceButtonPanel.add(choice2);
        choice2.setFocusPainted(false);
        choice2.setVisible(true);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("c2");

        choice3 = new JButton("choice 3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choiceButtonPanel.add(choice3);
        choice3.setFocusPainted(false);
        choice3.setVisible(true);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("c3");

        choice4 = new JButton("choice 4");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choiceButtonPanel.add(choice4);
        choice4.setFocusPainted(false);
        choice4.setVisible(true);
        choice4.addActionListener(choiceHandler);
        choice4.setActionCommand("c4");

        playerPanel = new JPanel();
        playerPanel.setBounds(80,15,1000,100);
        playerPanel.setBackground(Color.blue);
        playerPanel.setLayout(new GridLayout(1,4));
        window.add(playerPanel);

        hpLabel =new JLabel("HP : ");
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.black);
        playerPanel.add(hpLabel);

        hpLabelNumber = new JLabel();
        hpLabelNumber.setFont(normalFont);
        hpLabelNumber.setForeground(Color.black);
        playerPanel.add(hpLabelNumber);

        weaponLabel = new JLabel("Weapon : ");
        weaponLabel.setFont(normalFont);
        weaponLabel.setForeground(Color.black);
        playerPanel.add(weaponLabel);

        weaponLabelNumber = new JLabel();
        weaponLabelNumber.setFont(normalFont);
        weaponLabelNumber.setForeground(Color.black);
        playerPanel.add(weaponLabelNumber);

        playerSetup();










    }
    public void playerSetup()
    {
        playerHP = 15;
        weapon = "Knife";
        weaponLabelNumber.setText(weapon);
        hpLabelNumber.setText(""+playerHP);
        townGate();

    }

    public void townGate()
    {
        position = "townGate";
        Maintextarea.setText("You are at the gate of the the castle.\nWhat are you gonna do");
        choice1.setText("Talk to the guard");
        choice2.setText("attack the guard");
        choice3.setText("Leave");
        choice4.setText("");
    }
    public void talkGuard()
    {
        position = "talkGuard";
        Maintextarea.setText("Guard: Get lost commoners! \nyour are not allowed in the castle");
        choice1.setText("Go back");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    public void attackGuard()
    {
        position = "attackGuard";

        if(weapon.equals("Knife"))
        {
            Maintextarea.setText("Oh really you think you can beat me with that tiny blade\n(you get attacked recieve 10 damage)");
            playerHP = playerHP - 5;
            hpLabelNumber.setText("" + playerHP);

            choice1.setText("go Back");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        else
        {
            Maintextarea.setText("Player:get out of my way!(you killed the guard)");

            choice1.setText("go Back");
            choice2.setText("go Forward");
            choice3.setText("");
            choice4.setText("");
        }

    }
    public void toWhere()
    {
        position = "toWhere";
        Maintextarea.setText("Select the location to go");
        choice1.setText("Smith Shop");
        choice2.setText("Town gate");
        choice3.setText("");
        choice4.setText("");

    }
    public void smithShop()
    {
        position = "smithShop";
        Maintextarea.setText("Smith: What are you here for?");
        choice1.setText("I need a sword");
        choice2.setText("Go back");
        choice3.setText("");
        choice4.setText("");
    }
    public void smithShop1()
    {
        position = "smithShop1";
        Maintextarea.setText("Smith: Why do you need it");
        choice1.setText("Kill Dracula");
        choice2.setText("Raatien katni hain");
        choice3.setText("Go back");
        choice4.setText("");
    }
    public void killDracula()
    {
        position = "killDracula";
        Maintextarea.setText("Smith: Wow grape (You obtained the sword)");
        weapon = "Sword";
        weaponLabelNumber.setText(weapon);
        choice1.setText("go Back");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    public void Raat()
    {
        position = "Raat";
        Maintextarea.setText("Toota huwa saaz hun main");
        choice1.setText("go Back");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }


        public static void music() throws UnsupportedAudioFileException, IOException, LineUnavailableException{

            Scanner scanner = new Scanner(System.in);

            File file = new File("meow.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            

        }





    public class TitleScreenHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            createGameScreen();

        }


    }

    public class ChoiceHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String yourChoice = e.getActionCommand();

            switch (position)
            {
                case "townGate":
                switch (yourChoice)
                {
                    case "c1":talkGuard();break;
                    case "c2":attackGuard();break;
                    case "c3":toWhere();break;
                    case "c4":break;
                }
                break;
                case "talkGuard":
                    switch (yourChoice)
                    {
                        case "c1":townGate();break;
                        case "c2":break;
                        case "c3":break;
                        case "c4":break;
                    }
                   break;
                case "attackGuard":
                    switch (yourChoice)
                    {
                        case "c1":townGate();break;
                        case "c2":break;
                        case "c3":break;
                        case "c4":break;
                    }
                    break;
                case "toWhere":
                    switch (yourChoice)
                    {
                        case "c1":smithShop();break;
                        case "c2":townGate();break;
                        case "c3":break;
                        case "c4":break;
                    }
                    break;
                case "smithShop":
                    switch (yourChoice)
                    {
                        case "c1":smithShop1();break;
                        case "c2":toWhere();break;
                        case "c3":break;
                        case "c4":break;
                    }
                    break;
                case "smithShop1":
                    switch (yourChoice)
                    {
                        case "c1":killDracula();break;
                        case "c2":Raat();break;
                        case "c3":break;
                        case "c4":break;
                    }
                    break;
                case "killDracula":
                    switch (yourChoice)
                    {
                        case "c1":toWhere();break;
                        case "c2":;break;
                        case "c3":break;
                        case "c4":break;
                    }
                    break;
                case "Raat":
                    switch (yourChoice)
                    {
			

                        case "c1":try {
                                music();
                            } catch (UnsupportedAudioFileException ex) {
                                ex.printStackTrace();
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            } catch (LineUnavailableException ex) {
                                ex.printStackTrace();
                            }
				break;
                        case "c2":;break;
                        case "c3":break;
                        case "c4":break;
                    }
                    break;


            }

        }
    }


}