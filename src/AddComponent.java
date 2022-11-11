import javax.swing.tree.DefaultMutableTreeNode;

public interface AddComponent 
{
	void add(String a);
	void addUnder(DefaultMutableTreeNode node, String a);
}
