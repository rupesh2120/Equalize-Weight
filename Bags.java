package com.codeVita.sectionD;

import java.util.*;

public class Bags {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of bags");
		int bags = sc.nextInt();
		List<int []> listOfBags = new ArrayList<int []>(bags);
		for(int i=0;i<bags;i++)
		{
			System.out.println("Enter number of goods in bag "+(i+1));
			int goods = sc.nextInt();
			int[] good  = new int[goods];
			System.out.println("Enter weights of each good");
			for(int j=0; j<goods; j++)
			{
				good[j] = sc.nextInt();
			}
			listOfBags.add(good);
		}
		printListOfBags(listOfBags);
	}
	public static void printListOfBags(List<int []> listOfBags)
	{
		int sz = listOfBags.size();
		int[] sumOfBags= new int[sz];
		int diff = 0;
		for(int i = 0; i<listOfBags.size(); i++)
		{
			for(int j = 0; j< listOfBags.get(i).length; j++)
			{
				sumOfBags[i] += listOfBags.get(i)[j];
			}
		}
		int totalSum=0;
		for(int i=0; i<sumOfBags.length; i++)
		{
			totalSum +=sumOfBags[i];
		}
		int avgWeight = (totalSum)/(listOfBags.size());
		for(int i = 0; i<listOfBags.size(); i++)
		{
			boolean[] bags=new boolean[3];
			if(sumOfBags[i]!=avgWeight)
			{
				bags[i]=true;
				if(sumOfBags[i] < avgWeight)
				{
				for(int m = 0; m< listOfBags.get(i).length; m++)
				{
					int found = 0;
					int toSwap=0;
					int temp=0;
					if(found == 1)
						break;
					if(listOfBags.get(i).length==1)
					{
						diff = avgWeight;
					}
					else
						diff = avgWeight - listOfBags.get(i)[m];
					
					for(int j = 0 ; j< listOfBags.size(); j++)
					{
						if(j == i)
							continue;
						for(int k = 0; k< listOfBags.get(j).length; k++)
						{
							if(listOfBags.get(i).length==1)
							{
								if(diff == listOfBags.get(j)[k])
								{
									found = 1;
									temp=listOfBags.get(j)[k];
									listOfBags.get(j)[k]=listOfBags.get(i)[m];
									break;
								}
							}
							else
							{
								if(diff == listOfBags.get(j)[k])
								{
									found = 1;
									toSwap = sumOfBags[i]-listOfBags.get(i)[m];
									temp=listOfBags.get(j)[k];
									listOfBags.get(j)[k]=toSwap;
									break;
								}
							}
						}
						
					}
					if(found==1)
					{
						for(int n = 0; n< listOfBags.get(i).length; n++)
						{
							if(listOfBags.get(i).length==1)
								listOfBags.get(i)[n]= temp;
							else if(toSwap == listOfBags.get(i)[n])
								listOfBags.get(i)[n]= temp;
						}
					}
					found = 0;	
				}
				}
				
			}
				
		}
		for(int i = 0; i<listOfBags.size(); i++)
		{
			for(int j = 0; j< listOfBags.get(i).length; j++)
			{
				Arrays.sort(listOfBags.get(i));
			}
		}
		Collections.sort(listOfBags, new Comparator<int[]>() {
		    public int compare(int[] bag1, int[] bag2) {
		        return Integer.compare(bag1[bag1.length-1],bag2[bag2.length-1]);
		    }
		});
		for (int[] is : listOfBags) {
            System.out.println(Arrays.toString(is));
        }

	}
	
}
