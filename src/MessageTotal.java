//this class contains the messageTotal variable, which the size of the messages ArrayList from the Twitter class.
public class MessageTotal implements TwitterComponents 
{
    private int messageTotal = Twitter.pointer.getMessages().size();

    public int getMessageTotal() 
	{
        return this.messageTotal;
    }

    public void setMessageTotal(int messageTotal)
	{
        this.messageTotal = messageTotal;
    }

    @Override
    public void accept(Visitor visitor) 
	{
        visitor.visitMessageTotal(this);
    }

}