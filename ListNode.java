package Polynomials;

public class ListNode {
	private int coefficient;
	private int exponent;
	private ListNode link;
	public int next;
	
	public ListNode()
	{
		this.coefficient = 0;
		this.exponent =0;
		this.link = null;
		this.next= 0;
	}

	public ListNode (int value, int expo, int next)
	{
		this.coefficient = value;
		this.exponent = expo;
		this.next = next;
	}
	public ListNode (int value, int expo, ListNode link)
	{
		this.coefficient = value;
		this.exponent = expo;
		this.link = link;
	}
	public int getNext()
	{
		return next;
	}
	public void setNext(int a)
	{
		next = a;
	}
	public ListNode getLink()
	{
		return link;
	}
	public void setLink(ListNode a)
	{
		link = a;
	}
	
	public int getCoefficient()
	{
		return coefficient;
	}
	public int getExponent()
	{
		return exponent;
	}
	public void setCoefficient(int n)
	{
		coefficient = n;
	}
	public void setExponent(int n)
	{
		exponent = n;
	}
	public void setInArray(int a, int b)
	{
		coefficient = a;
		exponent = b;
	}
	public String toString()
	{
		String a = "Value= " + getCoefficient() + "  Expo= " + getExponent();
		return a;
		
	}
}
