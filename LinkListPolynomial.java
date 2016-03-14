package Polynomials;

import java.util.LinkedList;

public class LinkListPolynomial implements PolynomialInterface {

	private ListNode front;
	private ListNode rear;
	private ListNode front1;
	private ListNode rear1;
	private ListNode front2;
	private ListNode rear2;
	private ListNode frontFinal;
	private ListNode rearFinal;
	private int [] array = new int [100];
	
	public LinkListPolynomial()
	{
		this.front = null;
		this.rear = null;
	}
	
	public LinkListPolynomial(String s1) 
	{
		s1 = sort(s1);
		clearArray();
		String value = "";
		String expo = "";
		boolean isValue = true;
		boolean isExpo = false;
		
		try
		{
			for (int i = 0; i <= s1.length()+1; i++)
			{	
				String num = s1.charAt(i)+"";
				if ((isInteger(num)||num.equals("-")||num.equals("+"))&&(isValue))
				{
					value = value + num;
					isExpo = false;
				}
				else if (num.equals("x"))
				{
					isExpo = true;
				}
				else if (num.equals("^"))
				{
					isValue = false;
				}
				else if (isInteger(num))
				{
					expo = expo + num;
				}
				else if (num.equals("-")||(num.equals("+")))
				{
					isValue = true;
					isExpo = false;
					//constructor [counter] = new node(Integer.parseInt(value), Integer.parseInt(expo));
					addLast (Integer.parseInt(value), Integer.parseInt(expo));
					value = num;
					expo = "";
				}
			}
		}
		catch(StringIndexOutOfBoundsException e)
		{
			if (isExpo == true)
			{
				if (expo.equals(""))
				{
					//constructor [counter] = new node (Integer.parseInt(value), 1);
					addLast (Integer.parseInt(value), 1);
				}
				else
				{
					//constructor [counter] = new node (Integer.parseInt(value), Integer.parseInt(expo));
					addLast (Integer.parseInt(value), Integer.parseInt(expo));
					
				}
			}
			else
			{
				//constructor [counter] = new node (Integer.parseInt(value), 0);
				addLast (Integer.parseInt(value), 0);
				
			}
		}
	}
	public void clearArray()
	{
		for (int i =0; i <= array.length-1;i++)
		{
			array [i] = 0;
		}
		
	}
	public String sort (String s1)
	{
		String value = "";
		String expo = "";
		boolean isValue = true;
		boolean isExpo = false;
		try
		{
			for (int i = 0; i <= s1.length()+1; i++)
			{	
				String num = s1.charAt(i)+"";
				if ((isInteger(num)||num.equals("-")||num.equals("+"))&&(isValue))
				{
					value = value + num;
					isExpo = false;
				}
				else if (num.equals("x"))
				{
					isExpo = true;
				}
				else if (num.equals("^"))
				{
					isValue = false;
				}
				else if (isInteger(num))
				{
					expo = expo + num;
				}
				else if (num.equals("-")||(num.equals("+")))
				{
					isValue = true;
					isExpo = false;
					array [Integer.parseInt(expo)] = Integer.parseInt(value);
					value = num;
					expo = "";
				}
			}
		}
		catch(StringIndexOutOfBoundsException e)
		{
			if (isExpo == true)
			{
				if (expo.equals(""))
				{
					array [1] = Integer.parseInt(value);
				}
				else
				{
					array [Integer.parseInt(expo)] = Integer.parseInt(value);
				}
			}
			else
			{
				array [0] = Integer.parseInt(value);
				
			}
		}
		String a = "";
		for (int i=0; i <= array.length-1; i++)
			{
				String num = array[i] + "";
				if (!num.equals("0"))
				{
					if(!((num).charAt(0)+"").equals("-"))
					{
						num = "+" + num;
					}
					a = num + "x^" + i + a;
				}
			}
		
		return a;
	}
	
	public void showList()
	{
		ListNode position = front;
		while (position != null)
		{
			System.out.println("Value = " + position.getCoefficient() + " Expo = " + position.getExponent());
			position = position.getLink();
		}
	}
	
	public void addFirst(int a, int b)
	{
		front = new ListNode(a, b, front);
		
		
	}
	public void addLast(int a, int b)
	{
		ListNode position = new ListNode(a, b, null);
		if (rear == null)
		{
			front =  position;
			rear = front;
		}
		else
		{
			rear.setLink(position);
			rear = position;
		}
		
	
	}
	public void add1(int a, int b)
	{
		ListNode position = new ListNode(a, b, null);
		if (rear1 == null)
		{
			front1 =  position;
			rear1 = front1;
		}
		else
		{
			rear1.setLink(position);
			rear1 = position;
		}
	}
	
	public void add2(int a, int b)
	{
		ListNode position = new ListNode(a, b, null);
		if (rear2 == null)
		{
			front2 =  position;
			rear2 = front2;
		}
		else
		{
			rear2.setLink(position);
			rear2 = position;
		}
	}
	public void addFinal(int a, int b)
	{
		ListNode position = new ListNode(a, b, null);
		if (rearFinal == null)
		{
			frontFinal =  position;
			rearFinal = frontFinal;
		}
		else
		{
			rearFinal.setLink(position);
			rearFinal = position;
		}
		
	}
	
	public boolean isInteger(String s)
	{
		if (s.equals("0")||s.equals("1")||s.equals("2")||s.equals("3")||s.equals("4")||s.equals("5")||
			s.equals("6")||s.equals("7")||s.equals("8")||s.equals("9"))
		{
			return true;
		}
		else
			return false;
	}
	public void setList1(String s1)
	{
		String value = "";
		String expo = "";
		boolean isValue = true;
		boolean isExpo = false;
		
		try
		{
			for (int i = 0; i <= s1.length()+1; i++)
			{	
				String num = s1.charAt(i)+"";
				if ((isInteger(num)||num.equals("-")||num.equals("+"))&&(isValue))
				{
					value = value + num;
					isExpo = false;
				}
				else if (num.equals("x"))
				{
					isExpo = true;
				}
				else if (num.equals("^"))
				{
					isValue = false;
				}
				else if (isInteger(num))
				{
					expo = expo + num;
				}
				else if (num.equals("-")||(num.equals("+")))
				{
					isValue = true;
					isExpo = false;
					add1 (Integer.parseInt(value), Integer.parseInt(expo));
					value = num;
					expo = "";
				}
			}
		}
		catch(StringIndexOutOfBoundsException e)
		{
			if (isExpo == true)
			{
				if (expo.equals(""))
				{
					add1 (Integer.parseInt(value), 1);
				}
				else
				{
					add1 (Integer.parseInt(value), Integer.parseInt(expo));	
				}
			}
			else
			{
				add1 (Integer.parseInt(value), 0);
			}
		}
	}
	
	public void setList2(String s1)
	{
		String value = "";
		String expo = "";
		boolean isValue = true;
		boolean isExpo = false;
		
		try
		{
			for (int i = 0; i <= s1.length()+1; i++)
			{	
				String num = s1.charAt(i)+"";
				if ((isInteger(num)||num.equals("-")||num.equals("+"))&&(isValue))
				{
					value = value + num;
					isExpo = false;
				}
				else if (num.equals("x"))
				{
					isExpo = true;
				}
				else if (num.equals("^"))
				{
					isValue = false;
				}
				else if (isInteger(num))
				{
					expo = expo + num;
				}
				else if (num.equals("-")||(num.equals("+")))
				{
					isValue = true;
					isExpo = false;
					add2 (Integer.parseInt(value), Integer.parseInt(expo));
					value = num;
					expo = "";
				}
			}
		}
		catch(StringIndexOutOfBoundsException e)
		{
			if (isExpo == true)
			{
				if (expo.equals(""))
				{
					add2 (Integer.parseInt(value), 1);
				}
				else
				{
					add2 (Integer.parseInt(value), Integer.parseInt(expo));	
				}
			}
			else
			{
				add2 (Integer.parseInt(value), 0);
			}
		}
		
	}
	
	public PolynomialInterface add(PolynomialInterface other)
	{
		setList1(this+"");
		setList2(other+"");
		
		int num1 = 0;
		int num2 = 0;
		
		while (true)
		{
			try {num1 = front1.getExponent();}
			catch (NullPointerException e)
			{
				break;
			}
			try {num2 = front2.getExponent();}
			catch (NullPointerException e)
			{
				break;
			}
			

			if (num1 > num2)
			{
				addFinal(front1.getCoefficient(), front1.getExponent());
				front1 = front1.getLink();
			}
			else if (num2 > num1)
			{
				addFinal(front2.getCoefficient(), front2.getExponent());
				front2 = front2.getLink();
			}
			else
			{
				try
				{
					if ((front1.getCoefficient() + front2.getCoefficient()) != 0)
					{
						addFinal((front1.getCoefficient()+front2.getCoefficient()), num1);
					}
					front1 = front1.getLink();
					front2 = front2.getLink();
				}
				catch (NullPointerException e)
				{
					break;
				}
			}
		}

		String a = "";
		try
		{
			ListNode position = frontFinal;
			while (position != null)
			{
				String value = position.getCoefficient() +"";
				if(!((value).charAt(0)+"").equals("-"))
				{
					value = "+" + value;
				}
				
				a = a + value + "x^" + position.getExponent();
				position = position.getLink();
			}
		}
		catch(NullPointerException e)
		{
			
		}
		clearAll();
		return new LinkListPolynomial(a);
	}
	public void clearAll()
	{
		front1 = null;
		rear1 = null;
		front2 = null;
		rear2 = null;
		frontFinal = null;
		rearFinal = null;
		try
		{
			while(true)
			{
				ListNode temp = front1.getLink();
				front1.setLink(null);
				front1 = temp;
				
			}
			
		}
		catch (NullPointerException e){}
		try
		{
			while(true)
			{
				ListNode temp = front2.getLink();
				front2.setLink(null);
				front2 = temp;
			}
			
		}
		catch (NullPointerException e){}
		try
		{
			while(true)
			{
				ListNode temp = frontFinal.getLink();
				frontFinal.setLink(null);
				frontFinal = temp;
			}
			
		}
		catch (NullPointerException e){}
	}
	
	@Override
	public PolynomialInterface subtract(PolynomialInterface other)
	{
		setList1(this+"");
		setList2(other+"");
		
		int num1 = 0;
		int num2 = 0;
	
		while (true)
		{
			try {num1 = front1.getExponent();}
			catch (NullPointerException e)
			{
				break;
			}
			try {num2 = front2.getExponent();}
			catch (NullPointerException e)
			{
				break;
			}
			

			if (num1 > num2)
			{
				addFinal(front1.getCoefficient(), front1.getExponent());
				front1 = front1.getLink();
			}
			else if (num2 > num1)
			{
				addFinal(front2.getCoefficient(), front2.getExponent());
				front2 = front2.getLink();
			}
			else
			{
				try
				{
					if ((front1.getCoefficient() - front2.getCoefficient()) != 0)
					{
						addFinal((front1.getCoefficient() - front2.getCoefficient()), num1);
					}
					front1 = front1.getLink();
					front2 = front2.getLink();
				}
				catch (NullPointerException e)
				{
					break;
				}
			}
		}

		String a = "";
		try
		{
			ListNode position = frontFinal;
			while (position != null)
			{
				String value = position.getCoefficient() +"";
				if(!((value).charAt(0)+"").equals("-"))
				{
					value = "+" + value;
				}
				
				a = a + value + "x^" + position.getExponent();
				position = position.getLink();
			}
		}
		catch(NullPointerException e)
		{
			
		}
		clearAll();
		return new LinkListPolynomial(a);
	}

	@Override
	public void readPolynomial() {
		// TODO Auto-generated method stub

	}
	public String toString()
	{
		ListNode position = front;
		String a = "";
		while (position != null)
		{
			String value = position.getCoefficient() +"";
			if(!((value).charAt(0)+"").equals("-"))
			{
				value = "+" + value;
			}
			
			a = a + value + "x^" + position.getExponent();
			position = position.getLink();
		}
		return a;
	}

	
	
}
