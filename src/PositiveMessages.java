import java.util.ArrayList;

public class PositiveMessages implements TwitterComponents 
{

    private float positiveMessages;

    public PositiveMessages() 
	{
        ArrayList<String> temp = Twitter.pointer.getMessages();
        float messageTotal = temp.size();
        float positiveTotal = 0;

        for (int i = 0; i < messageTotal; i++)
		 {
            if (temp.get(i).contains("good") || temp.get(i).contains("great") || temp.get(i).contains("cool")
                    || temp.get(i).contains("awesome")) 
			{
                positiveTotal++;
            }
        }

        if (positiveTotal > 0) 
		{
            setPositiveMessages((positiveTotal / messageTotal));
        }

    }

    public float getPositiveMessages() 
	{
        return this.positiveMessages;
    }

    public void setPositiveMessages(float positiveMessages) 
	{
        this.positiveMessages = positiveMessages;
    }

    @Override
    public void accept(Visitor visitor) 
	{
        visitor.visitPositiveMessages(this);
    }
}