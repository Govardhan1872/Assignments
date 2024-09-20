package Studentsdetails;

import java.util.Scanner;

public class studentControl {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("enter the no.of colleges:");
		int n=scan.nextInt();
		String[][]arr=new String[n][];
		int i=0;
		while(i<=n-1) {
			System.out.println("enter the students in each college");
			arr[i]=new String[scan.nextInt()];
			i++;
		}
		scan.nextLine();
		i=0;
		while(i<=arr.length-1) {
			int j=0;
			while(j<=arr[i].length-1) {
				System.out.println("the college"+(i+1)+"student"+(j+1)+"is:");
				arr[i][j]=scan.nextLine();
				j++;
			}
			i++;
		}
		i=0;
		while(i<=arr.length-1) {
			int j=0;
			while(j<=arr[i].length-1) {
				System.out.println("the college"+(i+1)+"student"+(j+1)+"is:"+arr[i][j]);
				j++;
			}
			System.out.println();
			i++;
		}
	}

}



   