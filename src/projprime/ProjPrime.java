/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projprime;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author KHANYA_YOLANDA
 */
public class ProjPrime {

    static Scanner input=new Scanner(System.in);
    public static boolean isPrimeIter(int n1){
    if(n1>0){
        boolean r=true;
        int i=2;
        while((r==true)&&(i<n1)){
            r=((n1%i)!=0);
            i++;
        }
        return r;
    }else
        return false;
}
   
     public static boolean isPrimeRec(int n1,int d){
        if (n1>=2){
            if(d==1){
                return true;
            }else
                if((n1%d)==0){
                    return false;
                }else
                    return isPrimeRec(n1,d-1);
        }else
            return false;
     }
      public static Stack<Integer> PrimesIter(int n1){
          Stack<Integer> r = new Stack<Integer>();
        if(n1>=2){
            for(int i=2;i<=n1;i++){
                if(isPrimeIter(i)==true){
                  r.push(i);
                }
            }
            return r;
        }
        return r;
      }
            
    public static Stack<Integer> PrimesRec(int n1){
          Stack<Integer> rn1 = new Stack<Integer>();
          Stack<Integer> rpredn1 = new Stack<Integer>();
          if(n1>=2){
              if(n1==2){
                  rn1.push(n1);
                  return rn1;
              }else{
                  rpredn1=PrimesRec(n1-1);
              if(isPrimeRec(n1,n1-1)==true){
                  rpredn1.push(n1);
              }
            }
              return rpredn1;
          }else
              return rn1;
    }
     
    public static void main(String []args){
        Stack<Integer>fi=new Stack<Integer>();
        Stack<Integer>fr=new Stack<Integer>();
        while(true){
            String mess="\nAn integer greater than 1 please";
            System.out.println(mess);
             String s=input.next();
            int n=Integer.parseInt(s);
            if(((s.isEmpty()==false)&&(n>=2))==true){
                n=Integer.parseInt(s);
                fi=PrimesIter(n);
                fr=PrimesRec(n);
                System.out.println("Prime numbers less or equal to "+n);
                System.out.println("Iterative method :"+fi);
                System.out.println("Recursive methode :"+fr);
            }
        }
    }
}

