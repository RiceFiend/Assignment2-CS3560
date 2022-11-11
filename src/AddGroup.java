import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.*;
import java.util.*;
import java.awt.*;

//composite design pattern.
public class AddGroup implements AddComponent 
{

    public static AddGroup pointer = new AddGroup();

    //Singleton pattern
    private AddGroup() 
	{

    }
    //if-else statement to ensure if the group ID exists, or is null/empty
    public void add(String group) 
	{
        ArrayList<String> tempGroups = Twitter.pointer.getGroups();

        if (tempGroups.contains(group) || group == null || group.length() == 0) 
		{

            JFrame frame2 = new JFrame("Error");
            JLabel label = new JLabel("This group ID already exists or is invalid.");

            JPanel panel = new JPanel(new BorderLayout(5, 5));
            BoxLayout box = new BoxLayout(panel, BoxLayout.X_AXIS);

            panel.setLayout(box);
            panel.add(label);
            panel.setAlignmentX(Component.CENTER_ALIGNMENT);

            frame2.add(panel);
            frame2.setSize(300, 100);
            frame2.setVisible(true);
            frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }

        else 
		{
            String grouptxt = " (GROUP)";
            group = group + grouptxt;
            tempGroups.add(group);
            Twitter.pointer.setGroups(tempGroups);
            DefaultMutableTreeNode newGroup = new DefaultMutableTreeNode(group);
            Twitter.pointer.addToTree(newGroup);
            Twitter.pointer.addGroupNode(newGroup);
        }
    }

    // this add method is called when a node in the tree is selected
    public void addUnder(DefaultMutableTreeNode node, String group) 
	{
        ArrayList<String> tempGroups = Twitter.pointer.getGroups();

        if (tempGroups.contains(group) || group == null || group.length() == 0) 
		{

            JFrame frame2 = new JFrame("Error");
            JLabel label = new JLabel("This group ID already exists or is invalid.");

            JPanel panel = new JPanel(new BorderLayout(5, 5));
            BoxLayout box = new BoxLayout(panel, BoxLayout.X_AXIS);

            panel.setLayout(box);
            panel.add(label);
            panel.setAlignmentX(Component.CENTER_ALIGNMENT);

            frame2.add(panel);
            frame2.setSize(300, 100);
            frame2.setVisible(true);
            frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }

        else 
		{
            String grouptxt = " (GROUP)";
            group = group + grouptxt;
            tempGroups.add(group);
            Twitter.pointer.setGroups(tempGroups);
            DefaultMutableTreeNode newGroup = new DefaultMutableTreeNode(group);
            Twitter.pointer.addToSelectedGroup(node, newGroup);
            Twitter.pointer.addGroupNode(newGroup);
        }
    }
}