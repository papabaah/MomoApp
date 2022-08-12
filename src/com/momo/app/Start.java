package com.momo.app;

import com.momo.model.Gender;
import com.momo.model.MomoTransaction;
import com.momo.model.TransactionType;
import com.momo.model.User;
import com.momo.util.DBAccess;

import java.util.List;

public class Start {
  public static void main(String[] args) throws Exception {
    createUsers();
    createMomoTransaction();
  }

  public static void createMomoTransaction() throws Exception {
    int userId = 2;
    String phone = "0203450982";
    TransactionType ttype = TransactionType.deposit;
    Double amt = 5.20;
    Double ppercent = 0.02;
    Double tamt = amt + (amt * ppercent);

    MomoTransaction mtrans = new MomoTransaction(phone, ttype, amt);
    mtrans.setPercentProfit(ppercent);
    mtrans.setTotalAmount(tamt);
    mtrans.setUserId(userId);

    DBAccess dao = new DBAccess();
    dao.saveTransaction(mtrans);
    dao.saveTransaction(mtrans);

    List<MomoTransaction> listMomo = dao.findAllTransactions();
    for (MomoTransaction m : listMomo)
      System.out.println(m.toString());

  }


  public static void createUsers() throws Exception {
    System.out.println("Lets create some Users.....");

    String fullName1 = "Mike Legend";
    Gender gender1 = Gender.male;
    String location1 = "EN-340-2905";

    String fullName2 = "Vero She";
    Gender gender2 = Gender.female;
    String location2 = "EN-025-2065";



    User user1 = new User(fullName1, gender1, location1);
    User user2 = new User(fullName2, gender2, location2);

    System.out.println("Before Saving.....");
    System.out.println(user1.toString());
    System.out.println(user2.toString());


    DBAccess dao = new DBAccess();
    dao.saveUser(user1);
    dao.saveUser(user2);

    System.out.println("After Saving users......");

    List<User> listUsers = dao.findAllUsers();
    for(User u : listUsers) {
      System.out.println(u.toString());
    }
  }
}
