package edu.wpi.cs3733.D23.teamQ.db.impl;
import edu.wpi.cs3733.D23.teamQ.db.dao.GenDao;
import edu.wpi.cs3733.D23.teamQ.db.obj.Account;
import edu.wpi.cs3733.D23.teamQ.db.obj.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDaoImpl implements GenDao<Account, String>{
    static final String url = "jdbc:postgresql://database.cs.wpi.edu:5432/teamqdb";
    static final String user = "teamq";
    static final String password = "teamq140";

    public static Connection connect() {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return con;
    }

    private List<Person> People = new ArrayList<Person>();

    public Person retrieveRow(String IDNum) {
        populate();
        int index = this.getIndex(IDNum);
        return People.get(index);
    }



    public boolean updateRow(String uname, Person personWithNewChanges) {
        populate();
        boolean result = false;
        Connection con = GenDao.connect();
        String newFN = personWithNewChanges.getFirstName();
        String newLN = personWithNewChanges.getLastName();
        String newTitle = personWithNewChanges.getTitle();
        int newPN = personWithNewChanges.getPhoneNumber();

        try {
            String query =
                    "UPDATE person SET firstName = ?, lastName = ?, title = ?, phoneNumber= ? WHERE username = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, newFN);
            pst.setString(2, newLN);
            pst.setString(3, newTitle);
            pst.setInt(4, newPN);

            int rs = pst.executeUpdate();
            if (rs == 1) {
                result = true;
                int index = this.getIndex(uname);
                People.get(index).setFirstName(newFN);
                People.get(index).setLastName(newLN);
                People.get(index).setTitle(newTitle);
                People.get(index).setPhone(newPN);
                System.out.println("Updated successfully!");
            } else {
                System.out.println("Failed to update.");
            }
            con.close();
            pst.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public boolean deleteRow(String uname) {
        populate();
        boolean result = false;
        Connection con = GenDao.connect();
        try {
            String query = "DELETE FROM account WHERE username = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, uname);
            int rs = pst.executeUpdate();
            if (rs == 1) {
                result = true;
                int index = this.getIndex(uname);
                accounts.remove(index);
                System.out.println("Account deleted successful!");
            } else {
                System.out.println("Failed to delete your account.");
            }
            con.close();
            pst.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public boolean addRow(Account a) {
        populate();
        String uname = a.getUsername();
        String pass = a.getPassword();
        String email = a.getEmail();
        int q1 = a.getSecurityQuestion1();
        int q2 = a.getSecurityQuestion2();
        String a1 = a.getSecurityAnswer1();
        String a2 = a.getSecurityAnswer2();
        boolean result = false;
        Connection con = GenDao.connect();
        try {
            String query =
                    "INSERT INTO account (username, password, email, security_question_1, security_question_2, security_answer_1, security_answer_2) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, uname);
            pst.setString(2, pass);
            pst.setString(3, email);
            pst.setInt(4, q1);
            pst.setInt(5, q2);
            pst.setString(6, a1);
            pst.setString(7, a2);
            int rs = pst.executeUpdate();
            if (rs == 1) {
                result = true;
                accounts.add(a);
                System.out.println("Account created successful!");
            } else {
                System.out.println("Failed to create your account.");
            }
            con.close();
            pst.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public List<Account> getAllRows() {
        populate();
        return accounts;
    }

    public boolean populate() {
        Connection con = GenDao.connect();
        try {
            String query = "SELECT * FROM account";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Account a;
                a =
                        new Account(
                                rs.getString("username"),
                                rs.getString("password"),
                                rs.getString("email"),
                                rs.getInt("security_question_1"),
                                rs.getInt("security_question_2"),
                                rs.getString("security_answer_1"),
                                rs.getString("security_answer_2"));
                accounts.add(a);
            }
            con.close();
            st.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public int getIndex(String uname) {
        populate();
        for (int i = 0; i < accounts.size(); i++) {
            Account a = accounts.get(i);
            if (a.getUsername().equals(uname)) {
                return i;
            }
        }
        return -1;
    }

    public List<Integer> getIndexes(String email) {
        populate();
        List<Integer> is = new ArrayList<Integer>();
        for (int i = 0; i < accounts.size(); i++) {
            Account a = accounts.get(i);
            if (a.getEmail().equals(email)) {
                is.add(i);
            }
        }
        return is;
    }

}
