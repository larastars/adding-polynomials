package Polynomials;

public class node {
	public int value = 0;
	public int expo = 0;
	public node()
	{
		value = 0;
		expo = 0;
	}
	public node(int a, int b)
	{
		value = a;
		expo = b;
	}
	public int getValue()
	{
		return value;
	}
	public int getExpo()
	{
		return expo;
	}
	public void setValue(int n)
	{
		value = n;
	}
	public void setExpo(int n)
	{
		expo = n;
	}
	

}
