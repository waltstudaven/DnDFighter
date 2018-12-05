
/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

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
public class RaceComboBox extends JPanel
        implements ActionListener {
    JLabel pictureLeft;
    JLabel pictureRight;

    public RaceComboBox(JPanel Creater) {
        super(new BorderLayout());

        String[] raceStrings = {"Human", "Druid"};

        //Create the combo box, select the item at index 4.
        //Indices start at 0, so 4 specifies the pig.
        JComboBox raceList = new JComboBox(raceStrings);
        raceList.setName("raceList");
        raceList.setSelectedIndex(0);
        raceList.addActionListener(this);

        //Set up the picture.
        pictureLeft = new JLabel();
        pictureRight = new JLabel();
        pictureLeft.setFont(pictureLeft.getFont().deriveFont(Font.ITALIC));
        pictureRight.setFont(pictureRight.getFont().deriveFont(Font.ITALIC));
        pictureLeft.setHorizontalAlignment(JLabel.CENTER);
        pictureRight.setHorizontalAlignment(JLabel.CENTER);
        updateLabel(raceStrings[raceList.getSelectedIndex()]);
        pictureLeft.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        pictureRight.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));


        //The preferred size is hard-coded to be the width of the
        //widest image and the height of the tallest image + the border.
        //A real program would compute this.
        //pictureLeft.setPreferredSize(new Dimension(200, 500));
        //pictureRight.setPreferredSize(new Dimension(300, 600));

//        JPanel pictureHolder = new JPanel();
//        JPanel rightPictureHolder = new JPanel();
//        rightPictureHolder.setPreferredSize(new Dimension(347,520));

        pictureLeft.setPreferredSize(new Dimension(347,520));

        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = 3;
        c.gridheight = 3;
        c.insets = new Insets(50,50,5,50);

        c.anchor = GridBagConstraints.LINE_START;
        Creater.add(pictureLeft, c);

        c.anchor = GridBagConstraints.CENTER;
        Creater.add(raceList, c);

        c.anchor = GridBagConstraints.LINE_END;
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
        pictureLeft.setIcon(new ImageIcon(getScaledImage(iconLeft.getImage(), 347, 520)));
        pictureRight.setIcon(new ImageIcon(getScaledImage(iconRight.getImage(), 347, 520)));

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