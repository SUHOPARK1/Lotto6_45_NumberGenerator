package com.example.demo.//*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class Lotto6_45 {
	
	public static void main(String[] args) {

        Lotto6_45 ts = new Lotto6_45();

	}

 static HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();

 static HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();

    String pick() { //6개 번호 랜덤 뽑기 메소드

        Set<Integer> set = new HashSet<Integer>();

        

        while(set.size() < 6){ //6번 반복

            Double d = Math.random() * 45 + 1; //1~45 랜덤숫자 생성

            int key = d.intValue();

            set.add(key);

            h.put(key, h.get(key)+1);

            

        }

        List<Integer> list = new ArrayList<Integer>(set);

        Collections.sort(list);

        return list.toString(); //배열 출력(6개씩)

    }

    void max(){

     Set<Integer> keys = h.keySet();

     Iterator<Integer> it = keys.iterator();

     int key_temp = 0;

     int max = 0;

     while(it.hasNext()){

      int key = it.next();

      int value = h.get(key);

      if(max < value){

       max = value;

       key_temp = key;

      }

     }

     m.put(key_temp, max);

     h.remove(key_temp);

    }

    

    



    Lotto6_45(){ //생성자

     for(int i=1;i<46; i++){ 

      h.put(i, 0);

     }

     

     Scanner scan = new Scanner(System.in);

     System.out.println("뽑을 횟수를 입력하세요.");

     int n = scan.nextInt();

     

     for (int i=1; i<=n; i++) { //n번 뽑기

            System.out.println("try "+ i + " : " + pick());

        }  

     

     Set<Integer> keys = h.keySet();

        Iterator<Integer> it = keys.iterator();

        while(it.hasNext()){

         int key = it.next();

         int value = h.get(key);

         System.out.print("[" + key + "=" + value + "번] ");

         if(key!=0 && key%10==0){System.out.println();} 

      if(key<10){System.out.print(" ");} 

        }   

        for(int i=0; i<6; i++){ //최대값 6개 넣기

         max();

        }

        System.out.println();

        System.out.print("추천번호 : * ");

        Set<Integer> keys2 = m.keySet();

        Iterator<Integer> it2 = keys2.iterator();

        while(it2.hasNext()){

         int key2 = it2.next();

         int value2 = m.get(key2);

         System.out.print(key2 + " ");

        }

        System.out.print(" * ");

    } 

    

	

}
