public class Driver 
{

    // Driver class calls main method of Twitter class, which calls Admin Control
    public static void main(String[] args) 
	{
        // Singleton design reference to instance of Twitter class (Admin Control Panel)
        Twitter.pointer.main();

    }
}