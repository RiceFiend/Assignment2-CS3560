import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.*;
import java.util.*;
import java.awt.*;

//composite design pattern.

public class AddUser implements AddComponent 
{

    public static AddUser pointer = new AddUser();

    //Singleton pattern
    private AddUser() 
	{

    }

    public void add(String user) 
	{
        ArrayList<String> tempUsers = Twitter.pointer.getUsers();
        ArrayList<Long> tempTime = Twitter.pointer.getUserTime();
        ArrayList<Long> tempUpdate = Twitter.pointer.getUpdatedTime();
        int counter = Twitter.pointer.getUserCounter();

        tempUpdate.add((long) 0);
        User user1 = new User();
        Twitter.pointer.addToUsersSubject(user1);
        Follower observer = new Follower();
        Twitter.pointer.addToFollower(observer);
        counter++;
        Twitter.pointer.setUserCounter(counter);
        tempUsers.add(user);
        tempTime.add(System.currentTimeMillis());
        Twitter.pointer.setUserTime(tempTime);
        Twitter.pointer.setUsers(tempUsers);
        DefaultMutableTreeNode newUser = new DefaultMutableTreeNode(user);
        Twitter.pointer.addToTree(newUser);

        //ensures that any new user is an observer of itself
        ArrayList<String> temp = Twitter.pointer.getUsers();
        int holder = temp.indexOf(user);
        ArrayList<User> tempUser = Twitter.pointer.getUsersSubject();
        ArrayList<Follower> tempFollower = Twitter.pointer.getFollower();
        tempUser.get(holder).registerObserver(tempFollower.get(holder));
        Twitter.pointer.setUsersSubject(tempUser);
        Twitter.pointer.setFollower(tempFollower);

        ArrayList<DefaultListModel> models = Twitter.pointer.getModels();
        DefaultListModel model = new DefaultListModel();
        models.add(model);
        Twitter.pointer.setModels(models);
        ArrayList<User> usersSub = Twitter.pointer.getUsersSubject();
        ArrayList<Follower> followerObs = Twitter.pointer.getFollower();
        User a = new User();
        Follower b = new Follower();
        usersSub.add(a);
        followerObs.add(b);
        Twitter.pointer.setUsersSubject(usersSub);
        Twitter.pointer.setFollower(followerObs);


    }

    // this add method is called when a node in the tree is selected
    public void addUnder(DefaultMutableTreeNode node, String user) 
	{
        ArrayList<String> tempUsers = Twitter.pointer.getUsers();
        ArrayList<Long> tempTime = Twitter.pointer.getUserTime();
        ArrayList<Long> tempUpdate = Twitter.pointer.getUpdatedTime();

        int counter = Twitter.pointer.getUserCounter();

        tempUpdate.add((long) 0);
        counter++;
        Twitter.pointer.setUserCounter(counter);
        tempUsers.add(user);
        tempTime.add(System.currentTimeMillis());
        Twitter.pointer.setUserTime(tempTime);
        Twitter.pointer.setUsers(tempUsers);
        DefaultMutableTreeNode newUser = new DefaultMutableTreeNode(user);
        Twitter.pointer.addToSelectedGroup(node, newUser);

        // this chunk ensures that any new user is an observer of itself
        // so that any of their tweets will be included in their own feed
        ArrayList<String> temp = Twitter.pointer.getUsers();
        int holder = temp.indexOf(user);
        ArrayList<User> tempUser = Twitter.pointer.getUsersSubject();
        ArrayList<Follower> tempFollower = Twitter.pointer.getFollower();
        tempUser.get(holder).registerObserver(tempFollower.get(holder));
        Twitter.pointer.setUsersSubject(tempUser);
        Twitter.pointer.setFollower(tempFollower);

        ArrayList<DefaultListModel> models = Twitter.pointer.getModels();
        DefaultListModel model = new DefaultListModel();
        models.add(model);
        Twitter.pointer.setModels(models);
        ArrayList<User> usersSub = Twitter.pointer.getUsersSubject();
        ArrayList<Follower> followerObs = Twitter.pointer.getFollower();
        User a = new User();
        Follower b = new Follower();
        usersSub.add(a);
        followerObs.add(b);
        Twitter.pointer.setUsersSubject(usersSub);
        Twitter.pointer.setFollower(followerObs);
    
    }
}