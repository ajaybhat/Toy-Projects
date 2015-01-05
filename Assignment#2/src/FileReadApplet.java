import javax.swing.*;
import java.applet.Applet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by ABhat on 11 Aug 2014 - 11/08/14.
 */
public class FileReadApplet extends Applet implements ActionListener {
    JPanel panel;
    JButton openFile;

    JTextArea textArea;
    JFileChooser fileChooser = new JFileChooser();

    public void init() {
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    try {
                        JPanel panel = getPanel();

                        add(panel);
                    } catch (Exception e2) {
                    }
                }
            });
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(this, "Error in opening and reading file");
        }
    }

    public JPanel getPanel() throws Exception {
        panel = new JPanel();
        textArea = new JTextArea();
        openFile = new JButton("Open and Read File");


        System.out.println();
        panel.setBounds(200, 400, 500, 500);
        textArea.setBounds(100, 100, 400, 400);
        openFile.setBounds(100, 300, 50, 150);
        panel.add(openFile);
        panel.add(textArea);

        openFile.addActionListener(this);

        //    panel.show();
        return panel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == openFile) {
            if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {

                File selectedFile = fileChooser.getSelectedFile();
                try {
                    BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(selectedFile)));
                    String text = "", line;
                    while ((line = input.readLine()) != null)
                        text += line + "\n";
                    System.out.println(text);
                    textArea.setText(text);
                } catch (Exception e1) {

                }
            }

        }
    }
}