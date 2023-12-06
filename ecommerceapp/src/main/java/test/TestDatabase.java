package test;

import data.UserDB;
import jakarta.persistence.EntityManager;
import model.User;
import util.DBUtil;

public class TestDatabase {
    public static void main(String[] args) {
        // Tạo một đối tượng User mới
        User newUser = new User();
        newUser.setFirstName("Nguyen");
        newUser.setLastName("Van A");
        newUser.setEmail("email@example.com");
        newUser.setPassword("securepassword");
        UserDB.insert(newUser);
        
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            User retrievedUser = em.find(User.class, newUser.getUserId());
            if (retrievedUser != null) {
                System.out.println("User was successfully added!");
                System.out.println("User Name: " + retrievedUser.getFirstName() + " " + retrievedUser.getLastName());
            } else {
                System.out.println("User was not added.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
