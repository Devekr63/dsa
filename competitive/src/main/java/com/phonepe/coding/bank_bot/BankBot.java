package com.phonepe.coding.bank_bot;

import java.util.Arrays;

public class BankBot {

    public static void main(String[] args) {
        int[] balance  =  {10,100,20,50,30};
        String[] request = {"withdraw 2 10", "transfer 5 1 20",  "deposit 5 20",  "transfer 3 4 15"};
        requestHandler(balance, request);
        for(int amt:balance){
            System.out.print(amt+" ");
        }

        System.out.println();
        System.out.println(Arrays.toString(balance));
    }

    private static void requestHandler(int[] balance, String[] reqs){
        int accounts = balance.length;
        for(String req : reqs){

//            String action = req.split(" ")[0];
            switch (req.split(" ")[0]){
                case "withdraw" -> {
//                    System.out.println(action);

                    int accNo = Integer.parseInt(req.split(" ")[1])-1;
                    int amount = Integer.parseInt(req.split(" ")[2]);


                    if(validAccount(accNo, accounts) &&
                            sufficientBalance(balance[accNo], amount))
                    {
                        System.out.println(accNo+"->"+amount);
                        balance[accNo] -= amount;
                    }
                }
                case "transfer" -> {
//                    System.out.println(action);

                    int debitAcc = Integer.parseInt(req.split(" ")[1])-1;
                    int creditAcc = Integer.parseInt(req.split(" ")[2])-1;
                    int amount = Integer.parseInt(req.split(" ")[3]);



                    if(validAccount(debitAcc, accounts) &&
                            validAccount(creditAcc, accounts) &&
                            sufficientBalance(balance[debitAcc], amount)){
                        System.out.println(debitAcc+"->"+creditAcc+" : "+amount);
                        balance[debitAcc] -= amount;
                        balance[creditAcc] += amount;
                    }
                }
                case "deposit" -> {
//                    System.out.println(action);

                    int accNo = Integer.parseInt(req.split(" ")[1])-1;
                    int amount = Integer.parseInt(req.split(" ")[2]);



                    if(validAccount(accNo, accounts)){
                        System.out.println(accNo+"->"+amount);
                        balance[accNo] += amount;
                    }
                }
            }
        }
    }

    private static boolean sufficientBalance(int currBalance, int amount){
        return currBalance - amount >= 0;
    }

    private static boolean validAccount(int accNo, int accounts){
        if(accNo < 0) return false;
        return accNo < accounts;
//        return false ? accNo<0 :
//                true ? accNo<accounts : false;
    }
}
