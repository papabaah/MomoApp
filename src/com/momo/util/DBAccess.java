package com.momo.util;

import com.momo.model.Gender;
import com.momo.model.MomoTransaction;
import com.momo.model.TransactionType;
import com.momo.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBAccess {
  private final String CONNECTIONDRIVER = "com.mysql.cj.jdbc.Driver";
  private final String DBNAME = "db_csdemo";
  private final String USERNAME = "csab";
  private final String PASSWORD = "12345";
  private final String HOST = "localhost";

  private Connection connection = null;
  private PreparedStatement prepStatement = null;
  private ResultSet resultSet = null;

  public DBAccess() throws Exception {
    Class.forName(CONNECTIONDRIVER);
    connection = DriverManager.getConnection(getUrl());
  }

  public int saveUser(User user) throws SQLException {
    String query = "INSERT INTO user(fullname, gender, location, dateCreated, dateModified) values(?, ?, ?, ?, ?)";
    prepStatement = connection.prepareStatement(query);
    prepStatement.setString(1, user.getFullName());
    prepStatement.setString(2, user.getGender().toString());
    prepStatement.setString(3, user.getLocation());
    prepStatement.setTimestamp(4, user.getDateCreated());
    prepStatement.setTimestamp(5, user.getDateModified());
    return prepStatement.executeUpdate();
  }

  public int saveTransaction(MomoTransaction transaction) throws SQLException {
    String query = "INSERT INTO momotransaction(cusNumber, transType, amount, profitPercent, totalAmout, transactionDate, userId) values(?, ?, ?, ?, ?, ?, ?)";
    prepStatement = connection.prepareStatement(query);
    prepStatement.setString(1, transaction.getCusNumber());
    prepStatement.setString(2, transaction.getTransType().toString());
    prepStatement.setDouble(3, transaction.getAmount());
    prepStatement.setDouble(4, transaction.getPercentProfit());
    prepStatement.setDouble(5, transaction.getTotalAmount());
    prepStatement.setTimestamp(6, transaction.getTransactionDate());
    prepStatement.setInt(7, transaction.getUserId());
    return prepStatement.executeUpdate();
  }

  public List<MomoTransaction> findAllTransactions() throws SQLException {
    String query = "SELECT * FROM momotransaction";
    prepStatement = connection.prepareStatement(query);
    resultSet = prepStatement.executeQuery();
    return getMomoTrans();
  }

  public List<User> findAllUsers() throws SQLException {
    String query = "SELECT * FROM user";
    prepStatement = connection.prepareStatement(query);
    resultSet = prepStatement.executeQuery();
    return getUsers();
  }


  private List<MomoTransaction> getMomoTrans() throws SQLException {
    List<MomoTransaction> listMomo = new ArrayList<>();
    while (resultSet.next()) {

      MomoTransaction mt = new MomoTransaction();
      mt.setId(resultSet.getLong("id"));
      mt.setCusNumber(resultSet.getString("cusNumber"));
      mt.setTransType(TransactionType.valueOf(resultSet.getString("transType")));
      mt.setAmount(resultSet.getDouble("amount"));
      mt.setPercentProfit(resultSet.getDouble("profitPercent"));
      mt.setTotalAmount(resultSet.getDouble("totalAmout"));
      mt.setTransactionDate(resultSet.getTimestamp("transactionDate"));
      mt.setUserId(resultSet.getInt("userId"));

      listMomo.add(mt);
    }
    return listMomo;
  }

  private List<User> getUsers() throws SQLException {
    List<User> listUsers = new ArrayList<>();
    while (resultSet.next()) {

      User user = new User();
      user.setId(resultSet.getInt("id"));
      user.setFullName(resultSet.getString("fullName"));
      user.setGender(Gender.valueOf(resultSet.getString("gender")));
      user.setLocation(resultSet.getString("location"));
      user.setDateCreated(resultSet.getTimestamp("dateCreated"));
      user.setDateModified(resultSet.getTimestamp("dateModified"));

      listUsers.add(user);
    }
    return listUsers;
  }

  private String getUrl() {
    return "jdbc:mysql://" + USERNAME + ":"+ PASSWORD + "@" + HOST + "/" + DBNAME;
  }

  private void close() throws Exception {
    if(!connection.equals(null))
      connection.close();

    if(!prepStatement.equals(null))
      prepStatement.close();

    if(!resultSet.equals(null))
      resultSet.close();
  }

}
