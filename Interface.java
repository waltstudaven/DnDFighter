import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Interface {
    MainMenu mm = new MainMenu();
    SelectMonster sm = new SelectMonster();
    public JPanel mainMenu = mm.gui();
    public JPanel selectMonster = sm.gui();
    public ArrayList<String> monsterList = new ArrayList<>();
    static CardLayout cl;
    JPanel homeContainer = new JPanel();

    public Interface(){
        cl = new CardLayout(5,5);
        homeContainer.setLayout(cl);
        homeContainer.add(mainMenu, "Main Menu");
        homeContainer.add(selectMonster, "Select Monster");
    }

    public void startGame(){
        cl.show(homeContainer, "Main Menu");
    }

    public void addMainMenuButtons(){
        JButton b1, b2;
        JLabel lab;

        //makes the button
        b1 = new JButton("Select Character");
        Color button = Color.decode("#ECE392");
        b1.setBackground(button);
        b1.setFont(new Font("Verdana", 0, 30));
        b2 = new JButton("Select Monster");
        b2.setBackground(button);
        b2.setFont(new Font("Verdana", 0, 30));
        JDialog jd = new JDialog();
        b2.addActionListener(e -> cl.show(homeContainer, "Select Monster"));

        //makes the label (not necessary)
        lab = new JLabel("MONSTER FIGHTER");

        //set font/size of label
        lab.setForeground(Color.white);
        lab.setFont(new Font("Monotype Corsiva",0,150));

        //centers buttons in middle of panel
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10,10,10,10);

        c.gridx=1;
        c.gridy=0;
        //c.weighty = ;
        c.anchor = GridBagConstraints.PAGE_START;
        mainMenu.add(lab,c);





        //set axis for first button
        //add first button

        c.gridx = 1;
        c.gridy = 1;
        c.weighty=0;
        c.anchor = GridBagConstraints.CENTER;
        mainMenu.add(b1,c);

        //add second button in a lower coordinate
        c.gridx = 1;
        c.gridy = 2;
        mainMenu.add(b2,c);

    }
    public void addSelectMonsterButtons(){
        selectMonster.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();



        JPanel monsterGrid = new JPanel( new GridLayout(0,3, 200, 50));
        Color backColor = Color.decode("#ECE392");
        monsterGrid.setBackground(backColor);

        monsterList.add("Wolf");
        monsterList.add("Thug");
        monsterList.add("Tree");
        monsterList.add("Small Child");
        monsterList.add("Wraith");
        monsterList.add("Vampire");
        monsterList.add("Kamadan");
        monsterList.add("Ghost");
        monsterList.add("Boar");
        //makes the button
        for(String monster : monsterList){
            JButton button = new JButton(monster);
            Color buttColor = Color.decode("#756b62");
            button.setBackground(buttColor);
            button.setFont(new Font("Verdana", 0, 30));

            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println(monster);
                }
            });
            monsterGrid.add(monster, button);
        }


        JScrollPane monsterScroller = new JScrollPane(monsterGrid, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        // monsterScroller.setLayout(new BoxLayout());
        //monsterScroller.setBounds(365,250,1200,500);
        //centers the JScrollPanel monsterScroller
        c.fill = GridBagConstraints.CENTER;
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = 1;
        // c.weighty = 1.0;
        selectMonster.add(monsterScroller, c);

        //add back button
        JButton back = new JButton("Back");
        back.addActionListener(e -> cl.show(homeContainer, "Main Menu"));
        Color buttColor = Color.decode("#756b62");
        back.setBackground(buttColor);
        back.setFont(new Font("Verdana", 0, 30));
        back.setPreferredSize(new Dimension(150, 100));
        //back.setBounds(600,900,50,50);
        c.anchor = GridBagConstraints.PAGE_END; //bootom of space
        c.gridx = 0;
        c.gridy = 2;
        //c.weighty = 0.00000000000000001;
        selectMonster.add(back, c);
    }
}
