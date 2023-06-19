package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

       // 숫자 받고
       String str = reader.readLine();
       int num = Integer.parseInt(str);
       // 문자열 만들고	   
       
       // 포문 돌리고
       for (int i = 1; i <= num/4; i++) {
		 str = str + "long ";
	}
       System.out.println(str + "int");
       
       

   


    }
}
