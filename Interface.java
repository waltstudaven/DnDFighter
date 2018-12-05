import components.ClassComboBox;
import components.RaceComboBox;
import layout.SpringUtilities;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


import javax.swing.*;
import javax.swing.plaf.basic.BasicSpinnerUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import javax.swing.SpringLayout;




public class Interface {
    private Race characterRace;
    private CharacterClass characterClass;
    protected int level;
    protected Character newCharacter;
    private HashMap<String, CharacterClass> allClasses;
    private HashMap<String, Race> allRaces;





    int Str, Dex, Con, Int, Wis, Char; //for Character Creation
    String race, charClass, charName; //for Character Creation
    MainMenu mm = new MainMenu();
    SelectMonster sm = new SelectMonster();
    ScrollBacking CharCreateOne = new ScrollBacking();
    public JPanel CharCreate1 = CharCreateOne.gui();
    public JPanel mainMenu = mm.gui();
    public JPanel selectMonster = sm.gui();
    public ArrayList<String> monsterList = new ArrayList<>();
    static CardLayout cl;
    JPanel homeContainer = new JPanel();


    private static HashMap allMonsters;
    Music music;
    static {
        allMonsters = new HashMap<Integer, Monster>();
        allMonsters.put(1, new Ezmerelda());
        allMonsters.put(2, new Thug());
    }

    public Interface() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        cl = new CardLayout(5,5);
        homeContainer.setLayout(cl);
        homeContainer.add(mainMenu, "Main Menu");
        homeContainer.add(selectMonster, "Select Monster");
        homeContainer.add(CharCreate1, "CharCreate1");


        allClasses = new HashMap<>();
        allRaces = new HashMap<>();
        allClasses.put("Fighter", new Fighter());
        allRaces.put("Human", new Human());


            music = new Music("rosey.wav");    /////////////////// change !!!!!!!!!!!!!!!!!!!!!!!!!!
            music.playLoop();


        }

    public void startGame(){
        cl.show(homeContainer, "Main Menu");
    }

    /**
     * Submit button prints out character string
     * back button sends user to "CharClassSetter"
     */
    public void addNameButtons(JPanel nameSetter, int Str, int Dex, int Con, int Int, int Wis, int Char, String race, String charClass){
        GridBagConstraints c = new GridBagConstraints();
        nameSetter.setLayout( new GridBagLayout());
        JLabel chooseName = new JLabel("What is your name?!");

        c.anchor = GridBagConstraints.PAGE_START;
        c.gridx = 0;
        c.gridy = 1;
        nameSetter.add(chooseName);

        JTextField tf = new JTextField("Enter Your Name!",20);
        c.gridy = GridBagConstraints.RELATIVE;
        nameSetter.add(tf, c);

        //add back button
        JButton back = new JButton("Back");
        back.addActionListener(e -> cl.show(homeContainer, "CharCreate2"));
        Color buttColor = Color.decode("#756b62");
        back.setBackground(buttColor);
        back.setFont(new Font("Verdana", 0, 30));
        back.setPreferredSize(new Dimension(115, 65));
        //back.setBounds(600,900,50,50);
        c.anchor = GridBagConstraints.LAST_LINE_END; //bootom of space
        c.gridx = 0;
        c.gridy = 2;
        nameSetter.add(back, c);

        //add Submit button
        JButton submit = new JButton("Submit");
        submit.addActionListener(e -> {
            charName = tf.getText();
            newCharacter = new Character(charName, allClasses.get(charClass), allRaces.get(race), 1, Str, Dex,
                    Con, Int, Wis, Char);
            newCharacter.getCharacterRace().setCharacter(newCharacter);
            newCharacter.getCharacterRace().editScores();


            //System.out.println(inputClass);
            newCharacter.getCharacterClass().setCharacter(newCharacter);
            newCharacter.getCharacterClass().setLvl(1);

            System.out.println(newCharacter);
            try {
                doFight();
            }catch(Exception excep){

            }


        });
        submit.setBackground(buttColor);
        submit.setFont(new Font("Verdana", 0, 30));
        submit.setPreferredSize(new Dimension(150, 65));
        //back.setBounds(600,900,50,50);
        c.anchor = GridBagConstraints.LAST_LINE_END; //bootom of space
        // c.insets = new Insets(0,0,0,0);
        c.gridx = 3;
        c.gridy = 3;
        nameSetter.add(submit, c);
    }

//    /**
//     * //not all characters will come here. Might go straight to name depending on class
//     *
//     * Submit button sends user to "nameSetter"
//     * back button sends user to "CharClassSetter"
//     */
//    public void addStyleButtons(JPanel styleSetter, int Str, int Dex, int Con, int Int, int Wis, int Char, String race, String charClass) {
//        styleSetter.setLayout(new GridBagLayout());
//        GridBagConstraints c = new GridBagConstraints();
//
//        StyleComboBox scb = new StyleComboBox(styleSetter);
//
//
//
//        //add back button
//        JButton back = new JButton("Back");
//        back.addActionListener(e -> cl.show(homeContainer, "CharClassSetter"));
//        Color buttColor = Color.decode("#756b62");
//        back.setBackground(buttColor);
//        back.setFont(new Font("Verdana", 0, 30));
//        back.setPreferredSize(new Dimension(115, 65));
//        //back.setBounds(600,900,50,50);
//        c.anchor = GridBagConstraints.LAST_LINE_END; //bootom of space
//        c.gridx = 0;
//        c.gridy = 2;
//        styleSetter.add(back, c);
//
//        //add Submit button
//        JButton submit = new JButton("Submit");
//        submit.addActionListener(e -> {
//            for(Component compon: ccb.getComponents()){
//                if(compon.getName() != null && compon.getName().equals("classList")){
//                    charClass = ((JComboBox)compon).getSelectedItem().toString();
//                }
//            }
//            ScrollBacking nameSetBacking = new ScrollBacking();
//            JPanel nameSetter = nameSetBacking.gui();
//            homeContainer.add(nameSetter, "nameSetter");
//            addNameButtons(nameSetter, Str, Dex, Con, Int, Wis, Char, race, charClass);
//
//            cl.show(homeContainer, "nameSetter");
//        });
//        submit.setBackground(buttColor);
//        submit.setFont(new Font("Verdana", 0, 30));
//        submit.setPreferredSize(new Dimension(150, 65));
//        //back.setBounds(600,900,50,50);
//        c.anchor = GridBagConstraints.LAST_LINE_END; //bootom of space
//        // c.insets = new Insets(0,0,0,0);
//        c.gridx = 3;
//        c.gridy = 3;
//        CharClassSetter.add(submit, c);
//    }

    /**
     * Second Page of Char Creations
     * Lets the User choose a Class
     * Submit Button sends User to "styleSetter"
     * Back Button Sends User to "CharClassSetter"
     *
     */
    public void addCharClassButtons(JPanel CharClassSetter, int Str, int Dex, int Con, int Int, int Wis, int Char, String race){
        GridBagConstraints c = new GridBagConstraints();


        CharClassSetter.setLayout(new GridBagLayout());
        ClassComboBox ccb = new ClassComboBox(CharClassSetter);



        //add back button
        JButton back = new JButton("Back");
        back.addActionListener(e -> cl.show(homeContainer, "CharCreate2"));
        Color buttColor = Color.decode("#756b62");
        back.setBackground(buttColor);
        back.setFont(new Font("Verdana", 0, 30));
        back.setPreferredSize(new Dimension(115, 65));
        //back.setBounds(600,900,50,50);
        c.anchor = GridBagConstraints.LAST_LINE_END; //bootom of space
        c.gridx = 0;
        c.gridy = 2;
        CharClassSetter.add(back, c);

        //add Submit button
        JButton submit = new JButton("Submit");
        submit.addActionListener(e -> {
            charClass = ccb.getSelectedClass();
//            for(Component compon: ccb.getComponents()){
//                if(compon.getName() != null && compon.getName().equals("classList")){
//                    charClass = ((JComboBox)compon).getSelectedItem().toString();
//                }
//            }
            ScrollBacking nameSetBacking = new ScrollBacking();
            JPanel nameSetter = nameSetBacking.gui();
            homeContainer.add(nameSetter, "nameSetter");
            addNameButtons(nameSetter, Str, Dex, Con, Int, Wis, Char, race, charClass);

            cl.show(homeContainer, "nameSetter");
        });
        submit.setBackground(buttColor);
        submit.setFont(new Font("Verdana", 0, 30));
        submit.setPreferredSize(new Dimension(150, 65));
        //back.setBounds(600,900,50,50);
        c.anchor = GridBagConstraints.LAST_LINE_END; //bootom of space
        // c.insets = new Insets(0,0,0,0);
        c.gridx = 3;
        c.gridy = 3;
        CharClassSetter.add(submit, c);
    }

    /**
     * Second Page of Char Creations
     * Lets the User choose a Race
     * Submit Button sends user to "CharClassSetter"
     * Back Button sends user to "CharCreate1"
     *
     */
    public void addCharCreate2Buttons(JPanel Creater2, int Str, int Dex, int Con, int Int, int Wis, int Char){
        Creater2.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = 3;
        c.gridheight = 3;
        Creater2.setLayout(new GridBagLayout());
//        JLabel lab = new JLabel("Choose A Race");
//        lab.setForeground(Color.black);
//        lab.setFont(new Font("Monotype Corsiva",0,125));
        //c.insets = new Insets(10,10,10,10);
        c.anchor = GridBagConstraints.PAGE_START;
        c.gridx = 1;
        c.gridy = 0;
        // Creater2.add(lab, c);
        RaceComboBox rcb = new RaceComboBox(Creater2);

        //add back button
        JButton back = new JButton("Back");
        back.addActionListener(e -> cl.show(homeContainer, "CharCreate1"));
        Color buttColor = Color.decode("#756b62");
        back.setBackground(buttColor);
        back.setFont(new Font("Verdana", 0, 30));
        back.setPreferredSize(new Dimension(115, 65));
        //back.setBounds(600,900,50,50);
        c.anchor = GridBagConstraints.LAST_LINE_END; //bootom of space
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(0,0,0,150);
        Creater2.add(back, c);

        //add Submit button
        JButton submit = new JButton("Submit");
        submit.addActionListener(e -> {
             race =  rcb.getSelectedRace();

            ScrollBacking CharClassSetBacking = new ScrollBacking();
            JPanel CharClassSetter = CharClassSetBacking.gui();
            homeContainer.add(CharClassSetter, "CharClassSetter");
            addCharClassButtons(CharClassSetter, Str, Dex, Con, Int, Wis, Char, race);
            cl.show(homeContainer, "CharClassSetter");
        });
        submit.setBackground(buttColor);
        submit.setFont(new Font("Verdana", 0, 30));
        submit.setPreferredSize(new Dimension(150, 65));
        //back.setBounds(600,900,50,50);
        c.anchor = GridBagConstraints.LAST_LINE_END; //bootom of space
        // c.insets = new Insets(0,0,0,0);
        c.gridx = 3;
        c.gridy = 3;
        Creater2.add(submit, c);
    }

    /**
     * Page that sets char attributes
     * Submit button sends user to "CharCreate2"
     * Back button sends user to "Main Menu"
     */
    public void addCharCreater1Buttons(){
        //set font/size of label
        JLabel lab = new JLabel("Enter your own attribute scores.");
        lab.setForeground(Color.black);
        lab.setFont(new Font("Monotype Corsiva",0,125));
        CharCreate1.add(lab);


        CharCreate1.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JPanel spinners = new JPanel( new SpringLayout());
        String[] labels = {"Available Points: ", "Strength: ", "Dexterity: ", "Constitution: ", "Intelligence: ", "Wisdom: ", "Charisma: "};
        JSpinner totalPoints = new JSpinner();
        for(int i =0; i<labels.length; i++) {
            if (i == 0) {
                totalPoints.setEditor(new JSpinner.DefaultEditor(totalPoints));
                totalPoints.setModel(new SpinnerNumberModel(72, 0, 72, 1));
                //makes up and down arrows Not Usable by User.
                totalPoints.setUI(new BasicSpinnerUI() {
                    protected Component createNextButton() {
                        return null;
                    }

                    protected Component createPreviousButton() {
                        return null;
                    }
                });
                totalPoints.setSize(totalPoints.getWidth() * 5,totalPoints.getHeight() * 4);
                totalPoints.setFont(new Font("Monotype Corsiva",0, 40));
                JLabel total = new JLabel(labels[i], JLabel.TRAILING);
                total.setFont(new Font("Monotype Corsiva", 0, 30));
                spinners.add(total);
                total.setLabelFor(total);
                totalPoints.setName("js "+labels[i]);
                spinners.add(totalPoints);
                totalPoints.setValue(72);

            } else {
                JLabel l = new JLabel(labels[i], JLabel.TRAILING);
                l.setFont(new Font("Monotype Corsiva", 0, 30));
                spinners.add(l);

                //creates a new Jspinner and sets the value to default (not changeable by text input)
                JSpinner iterator = new JSpinner();
                iterator.setEditor(new JSpinner.DefaultEditor(iterator));
                iterator.setModel(new SpinnerNumberModel(0, 0, 72, 1));
                iterator.setUI(new BasicSpinnerUI(){
                    protected Component createNextButton() {
                        JButton btnUP = (JButton) super.createNextButton();
                        for(ActionListener a : btnUP.getActionListeners()){
                            btnUP.removeActionListener(a);
                        };
                        btnUP.addActionListener(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if(!((Integer)iterator.getValue() + 1 > 72) && !((Integer)totalPoints.getValue() - 1 < 0)){
                                    iterator.setValue(iterator.getNextValue());
                                    totalPoints.setValue(totalPoints.getPreviousValue());
                                }
                            }
                        });
                        return btnUP;
                    }
                    protected Component createPreviousButton(){
                        JButton btnDown = (JButton)super.createPreviousButton();
                        for(ActionListener a : btnDown.getActionListeners()){
                            btnDown.removeActionListener(a);
                        };
                        btnDown.addActionListener(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e){
                                if(!((Integer)iterator.getValue() - 1 < 0) && !((Integer)totalPoints.getValue() + 1 > 72)){
                                    iterator.setValue(iterator.getPreviousValue());
                                    totalPoints.setValue(totalPoints.getNextValue());

                                }
                            }
                        });
                        return btnDown;
                    }
                });
                iterator.setSize(iterator.getWidth() * 5,iterator.getHeight() * 4);
                iterator.setFont(new Font("Monotype Corsiva",0, 40));
                //format size of numeric boxes
                Component mySpinnerEditor = iterator.getEditor();
                JFormattedTextField jftf = ((JSpinner.DefaultEditor)mySpinnerEditor).getTextField();
                jftf.setColumns(2);
                //add iterator to panel
                l.setLabelFor(iterator);
                iterator.setName("js " + labels[i]);
                spinners.add(iterator);
            }
        }
        SpringUtilities.makeCompactGrid(spinners, 7 , 2, 6, 6, 6, 6);
        Color backColor = Color.decode("#ECE392");

        c.fill = GridBagConstraints.CENTER;
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = 1;
        CharCreate1.add(spinners, c);

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
        CharCreate1.add(back, c);

        //add average attributes button
        JButton Avg = new JButton("Set Average Attributes");
        Avg.addActionListener(e ->{
            for(Component js: spinners.getComponents()) {
                if((js.getName() != null) && (js.getName().equalsIgnoreCase("js Strength: ") ||
                        js.getName().equalsIgnoreCase( "js Dexterity: ") ||
                        js.getName().equalsIgnoreCase("js Constitution: ") ||
                        js.getName().equalsIgnoreCase("js Intelligence: ") ||
                        js.getName().equalsIgnoreCase("js Wisdom: ") ||
                        js.getName().equalsIgnoreCase("js Charisma: "))){

                    ((JSpinner)js).setValue(12);
                } else if((js.getName()!=null) && (js.getName().equalsIgnoreCase("js Available Points: "))){
                    ((JSpinner)js).setValue(0);
                }
            }});
        Avg.setBackground(buttColor); //same color as back button
        Avg.setFont(new Font("Verdana", 0, 30));
        Avg.setPreferredSize(new Dimension(400, 100));
        c.anchor = GridBagConstraints.WEST; //bootom of space
        c.gridx = 0;
        c.gridy = 1;
        CharCreate1.add(Avg, c);

        //add Submit button
        JButton submit = new JButton("Submit");
        submit.addActionListener(e -> {
            //final att scores;
            for(Component js: spinners.getComponents()) {
                if((js.getName() != null) && (js.getName().equalsIgnoreCase("js Strength: "))){
                    Str = (int)((JSpinner)js).getValue();
                } else if((js.getName() != null) && js.getName().equalsIgnoreCase( "js Dexterity: ")){
                    Dex = (int)((JSpinner)js).getValue();
                } else if((js.getName() != null) && js.getName().equalsIgnoreCase("js Constitution: ")){
                    Con = (int)((JSpinner)js).getValue();
                } else if ((js.getName() != null) && js.getName().equalsIgnoreCase("js Intelligence: ")){
                    Int = (int)((JSpinner)js).getValue();
                } else if((js.getName() != null) && js.getName().equalsIgnoreCase("js Wisdom: ")){
                    Wis = (int)((JSpinner)js).getValue();
                } else if((js.getName() != null) && js.getName().equalsIgnoreCase("js Charisma: ")) {
                    Char = (int)((JSpinner)js).getValue();
                }
            }
            ScrollBacking CharCreateTwo = new ScrollBacking();
            JPanel CharCreate2 = CharCreateTwo.gui();
            homeContainer.add(CharCreate2, "CharCreate2");
            addCharCreate2Buttons(CharCreate2, Str, Dex, Con, Int, Wis, Char);
            cl.show(homeContainer, "CharCreate2");
        });
        submit.setBackground(buttColor);
        submit.setFont(new Font("Verdana", 0, 30));
        submit.setPreferredSize(new Dimension(150, 100));
        //back.setBounds(600,900,50,50);
        c.anchor = GridBagConstraints.EAST; //bootom of space
        c.gridx = 0;
        c.gridy = 1;
        CharCreate1.add(submit, c);

    }

    public void addMainMenuButtons(){
        mainMenu.setPreferredSize(new Dimension(mainMenu.getWidth(), mainMenu.getHeight()));
        JButton b1, b2;
        JLabel lab;

        //makes the button
        b1 = new JButton("Select Character");
        Color button = Color.decode("#ECE392");
        b1.setBackground(button);
        b1.setFont(new Font("Verdana", 0, 30));
        b1.addActionListener(e -> cl.show(homeContainer, "CharCreate1"));
        b1.setSize(b1.getPreferredSize());

        b2 = new JButton("Select Monster");
        b2.setBackground(button);
        b2.setFont(new Font("Verdana", 0, 30));
        JDialog jd = new JDialog();
        b2.addActionListener(e -> cl.show(homeContainer, "Select Monster"));
        b2.setSize(b2.getPreferredSize());


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
        lab.setSize(lab.getPreferredSize());
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

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        mainMenu.setMaximumSize(screenSize);

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

    public void doFight() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        this.newCharacter.setCurrentHp(this.newCharacter.getMaxHp());

        System.out.println("Who would you like to fight against? ");
        for (Object i: allMonsters.keySet()) {
            System.out.println("(" + (Integer)i + ") " + allMonsters.get((Integer) i));
        }
        Scanner scan = new Scanner(System.in);
        Integer monsterChoice = scan.nextInt();


        music.stop();

        Music music2 = new Music("king_pin.wav");
        music2.playLoop();


        Arena arena = new Arena( (Monster) allMonsters.get(monsterChoice), this.newCharacter);
    }
}
