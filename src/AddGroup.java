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
        ArrayList<Long> tempTime = Twitter.pointer.getGroupTime();

        String grouptxt = " (GROUP)";
        group = group + grouptxt;
        tempGroups.add(group);
        tempTime.add(System.currentTimeMillis());
        Twitter.pointer.setGroupTime(tempTime);
        Twitter.pointer.setGroups(tempGroups);
        DefaultMutableTreeNode newGroup = new DefaultMutableTreeNode(group);
        Twitter.pointer.addToTree(newGroup);
        Twitter.pointer.addGroupNode(newGroup);
        }

    // this add method is called when a node in the tree is selected
    public void addUnder(DefaultMutableTreeNode node, String group) 
	{
        ArrayList<String> tempGroups = Twitter.pointer.getGroups();

        ArrayList<Long> tempTime = Twitter.pointer.getGroupTime();

        String grouptxt = " (GROUP)";
        group = group + grouptxt;
        tempGroups.add(group);
        tempTime.add(System.currentTimeMillis());
        Twitter.pointer.setGroupTime(tempTime);
        Twitter.pointer.setGroups(tempGroups);
        DefaultMutableTreeNode newGroup = new DefaultMutableTreeNode(group);
        Twitter.pointer.addToSelectedGroup(node, newGroup);
        Twitter.pointer.addGroupNode(newGroup);
    }
}