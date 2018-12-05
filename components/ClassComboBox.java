

package components;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.MalformedURLException;
import javax.swing.*;

/*
 * ComboBoxDemo.java uses these additional files:
 *   images/Bird.gif
 *   images/Cat.gif
 *   images/Dog.gif
 *   images/Rabbit.gif
 *   images/Pig.gif
 */
public class ClassComboBox extends JPanel
        implements ActionListener {
    JLabel pictureLeft;
    JLabel pictureRight;
    JComboBox classList;

    public ClassComboBox(JPanel Creater) {
        super(new BorderLayout());

        String[] classStrings = {"Fighter"};

        //Create the combo box, select the item at index 4.
        //Indices start at 0, so 4 specifies the pig.
        classList = new JComboBox(classStrings);
        classList.setName("classList");
        classList.setSelectedIndex(0);
        classList.addActionListener(this);

        //Set up the picture.
        pictureLeft = new JLabel();
        pictureRight = new JLabel();
        pictureLeft.setFont(pictureLeft.getFont().deriveFont(Font.ITALIC));
        pictureRight.setFont(pictureRight.getFont().deriveFont(Font.ITALIC));
        pictureLeft.setHorizontalAlignment(JLabel.CENTER);
        pictureRight.setHorizontalAlignment(JLabel.CENTER);
        updateLabel(classStrings[classList.getSelectedIndex()]);
        pictureLeft.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        pictureRight.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));


        //The preferred size is hard-coded to be the width of the
        //widest image and the height of the tallest image + the border.
        //A real program would compute this.
        //pictureLeft.setPreferredSize(new Dimension(200, 500));
        //pictureRight.setPreferredSize(new Dimension(300, 600));

        JPanel pictureHolder = new JPanel();
        JPanel rightPictureHolder = new JPanel();
        rightPictureHolder.setPreferredSize(new Dimension(367,550));

        pictureLeft.setPreferredSize(new Dimension(367,550));

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10,10,10,10);

        c.anchor = GridBagConstraints.WEST;
        Creater.add(pictureLeft, c);

        c.anchor = GridBagConstraints.CENTER;
        Creater.add(classList, c);

        c.anchor = GridBagConstraints.EAST;
        Creater.add(pictureRight, c);


        //setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }

    /**
     * Listens to the combo box.
     */
    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox) e.getSource();
        String raceName = (String) cb.getSelectedItem();
        updateLabel(raceName);
    }

    public String getSelectedClass(){
        return classList.getSelectedItem().toString();
    }

    private Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }

    protected void updateLabel(String name) {
        final String dir = System.getProperty("user.dir");

        ImageIcon iconLeft = createImageIcon(dir + "\\DnDFighter\\data\\" + name + "Male.png");
        ImageIcon iconRight = createImageIcon(dir + "\\DnDFighter\\data\\" + name + "Female.png");
        // pictureLeft.setIcon(iconLeft);
        pictureLeft.setIcon(new ImageIcon(getScaledImage(iconLeft.getImage(), 367, 550)));
        // pictureRight.setIcon(iconRight);
        pictureRight.setIcon(new ImageIcon(getScaledImage(iconRight.getImage(), 367, 550)));

        pictureLeft.setToolTipText("A drawing of a Male " + name.toLowerCase());
        pictureRight.setToolTipText("A drawing of a Female " + name.toLowerCase());

        if (iconLeft != null) {
            pictureLeft.setText(null);
        } else {
            pictureLeft.setText("Image not found");
        }
        if (iconRight != null) {
            pictureRight.setText(null);
        } else {
            pictureRight.setText("Image not found");
        }
    }

    /**
     * Returns an ImageIcon, or null if the path was invalid.
     */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = RaceComboBox.class.getResource(path);
        try {
            imgURL = new File(path).toURI().toURL();
            if (imgURL != null) {
                return new ImageIcon(imgURL);
            } else {
                System.err.println("Couldn't find file: " + path);
                return null;
            }
        } catch (MalformedURLException mal) {
            if (imgURL != null) {
                return new ImageIcon(imgURL);
            } else {
                System.err.println("Couldn't find file: " + path);
                return null;
            }
        }

    }
}
