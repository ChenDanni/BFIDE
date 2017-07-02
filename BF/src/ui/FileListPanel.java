package ui;

import ui.Listener.FileOpenActionListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by cdn on 17/6/25.
 */
public class FileListPanel {

    JFrame frame;
    FileOpenActionListener fileOpenActionListener;
    public JButton conform;
    public JButton cancel;

    public FileListPanel(String[] files){
        frame = new JFrame();
        fileOpenActionListener = new FileOpenActionListener(frame);
        frame.setLayout(new FlowLayout());
        JPanel filePanel = new JPanel();
        filePanel.setLayout(null);
        filePanel.setLayout(new BoxLayout(filePanel,BoxLayout.Y_AXIS));
        for (String file : files){
            JLabel f = new JLabel(file,SwingConstants.CENTER);
            f.setSize(new Dimension(10,50));
            f.addMouseListener(fileOpenActionListener);
            filePanel.add(f);
        }
//        filePanel.setSize(200,250);
//        filePanel.setBorder(BorderFactory.createLineBorder(Color.black));
        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new GridLayout(1,2));
        conform = new JButton("OK");
        cancel = new JButton("cancel");
        conform.addMouseListener(fileOpenActionListener);
        cancel.addMouseListener(fileOpenActionListener);
        btnPanel.add(cancel);
        btnPanel.add(conform);

        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.add(filePanel,BorderLayout.CENTER);
        p.setSize(190,100);
        frame.setLayout(new BorderLayout());
        frame.add(p,BorderLayout.CENTER);
        frame.add(btnPanel,BorderLayout.SOUTH);
        frame.setSize(200,150);
//        frame.setSize(200,300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
