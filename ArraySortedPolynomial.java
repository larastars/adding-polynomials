package Polynomials;

public class ArraySortedPolynomial implements PolynomialInterface {
	public node finalAnswer [] = new node [100];
	public node constructor [] = new node [100];
	public node secondPoly [] = new node [100];
	public node firstPoly [] = new node [100];
	public int counter = 0;
	
	public ArraySortedPolynomial(String s1) 
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
					constructor [counter] = new node(Integer.parseInt(value), Integer.parseInt(expo));
					counter++;
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
					constructor [counter] = new node (Integer.parseInt(value), 1);
					counter++;
				}
				else
				{
					constructor [counter] = new node (Integer.parseInt(value), Integer.parseInt(expo));
					counter++;
				}
			}
			else
			{
				constructor [counter] = new node (Integer.parseInt(value), 0);
				counter ++;
			}
		}
		counter = 0;
		
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
	@Override
	
	public PolynomialInterface add(PolynomialInterface other) 
	{
		setArray(this+"", firstPoly);
		setArray(other+"", secondPoly);
		int num1 = 0;
		int num2 = 0;
		int f = 0;
		int s = 0;
		int d = 0;
		
		while (true)
		{
			try {num1 = firstPoly[f].getExpo();}
			catch (NullPointerException e)
			{
				break;
			}
			try {num2 = secondPoly[s].getExpo();}
			catch (NullPointerException e)
			{
				break;
			}
			

			if (num1 > num2)
			{
				//add num1 to answer
				//add num1 while it's greater than num2
				finalAnswer[d] = firstPoly[f];
				d++;
				f++;
			}
			else if (num2 > num1)
			{
				//add num2 to answer
				//add num1 while it's greater than num2
				finalAnswer[d] = secondPoly[s];
				s++;
				d++;
			}
			else
			{
				//add them and add to answer
				try
				{
					if ((firstPoly[f].getValue() + secondPoly[s].getValue()) != 0)
					{
						finalAnswer[d] = new node((firstPoly[f].getValue() + secondPoly[s].getValue()), num1);
						d++;
					}
					s++;
					f++;
				}
				catch (NullPointerException e)
				{
					break;
				}
			}
		}

		String a = "";
		String b = "";
		try
		{
			for (int i=0; i <= finalAnswer.length-1; i++)
			{
				String value = finalAnswer[i].getValue() + "";
				if(!((value).charAt(0)+"").equals("-"))
				{
					value = "+" + value;
				}
				if (finalAnswer[i].getValue() != 0)
				{
					a = value + "x^" + finalAnswer[i].getExpo();
					b = b + a;
				}
				
			}
		}
		catch(NullPointerException e)
		{
			
		}
		clearArrays(firstPoly, secondPoly, finalAnswer);
		return new ArraySortedPolynomial(b);
	}

	private void clearArrays(node[] firstPoly2, node[] secondPoly2, node[] finalAnswer2)
	{
		for (int i =0; i <= firstPoly2.length-1;i++)
		{
			try
			{
				firstPoly2 [i].setValue(0);
				firstPoly2 [i].setExpo(0);
				secondPoly2 [i].setValue(0);
				secondPoly2 [i].setExpo(0);
				finalAnswer2 [i].setValue(0);
				finalAnswer2 [i].setExpo(0);
			}
			catch (NullPointerException e)
			{
				
			}
			
		}
	}
	private void setArray(String s1, node[] array) 
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
					array [counter] = new node(Integer.parseInt(value), Integer.parseInt(expo));
					counter++;
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
					array [counter] = new node (Integer.parseInt(value), 1);
					counter++;
				}
				else
				{
					array [counter] = new node (Integer.parseInt(value), Integer.parseInt(expo));
					counter++;
				}
			}
			else
			{
				array [counter] = new node (Integer.parseInt(value), 0);
				counter ++;
			}
		}
		counter = 0;
		
	}
	@Override
	public PolynomialInterface subtract(PolynomialInterface other) 
	{
		setArray(this+"", firstPoly);
		setArray(other+"", secondPoly);
		int num1 = 0;
		int num2 = 0;
		int f = 0;
		int s = 0;
		int d = 0;
		
		while (true)
		{
			try {num1 = firstPoly[f].getExpo();}
			catch (NullPointerException e)
			{
				break;
			}
			try {num2 = secondPoly[s].getExpo();}
			catch (NullPointerException e)
			{
				break;
			}
			

			if (num1 > num2)
			{
				//add num1 to answer
				//add num1 while it's greater than num2
				finalAnswer[d] = firstPoly[f];
				d++;
				f++;
			}
			else if (num2 > num1)
			{
				//add num2 to answer
				//add num1 while it's greater than num2
				finalAnswer[d] = secondPoly[s];
				s++;
				d++;
			}
			else
			{
				//add them and add to answer
				try
				{
					if ((firstPoly[f].getValue() - secondPoly[s].getValue()) != 0)
					{
						finalAnswer[d] = new node((firstPoly[f].getValue() - secondPoly[s].getValue()), num1);
						d++;
					}
					s++;
					f++;
				}
				catch (NullPointerException e)
				{
					break;
				}
			}
		}

		String a = "";
		String b = "";
		try
		{
			for (int i=0; i <= finalAnswer.length-1; i++)
			{
				String value = finalAnswer[i].getValue() + "";
				if(!((value).charAt(0)+"").equals("-"))
				{
					value = "+" + value;
				}
				if (finalAnswer[i].getValue() != 0)
				{
					a = value + "x^" + finalAnswer[i].getExpo();
					b = b + a;
				}
				
			}
		}
		catch(NullPointerException e)
		{
			
		}
		clearArrays(firstPoly, secondPoly, finalAnswer);
		return new ArraySortedPolynomial(b);
	}
	

	@Override
	public void readPolynomial() {
		// TODO Auto-generated method stub

	}
	public String toString()
	{
		String a = "";
		String b = "";
		try
		{
			for (int i=0; i <= constructor.length-1; i++)
			{
				String value = constructor[i].getValue() + "";
				if(!((value).charAt(0)+"").equals("-"))
				{
					value = "+" + value;
				}
				a = value + "x^" + constructor[i].getExpo();
				b = b + a;
			}
		}
		catch(NullPointerException e)
		{
			
		}
		
		
		return b;
	}


}
