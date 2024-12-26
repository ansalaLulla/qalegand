package utility;

import java.util.Random;

import com.github.javafaker.Faker;

public class RandomDataUtility {

	private static final Faker faker = new Faker();

    public static String getProductName() {
        return faker.commerce().productName();
    }
    
    public static String getProductQuantity() {
    	
    	int q = faker.number().numberBetween(1, 100);
    	return String.valueOf(q);
    }
    
    public static String getExpirationPeriod() {
      
        return String.valueOf(faker.number().numberBetween(1, 24));
    }

    public static String generateTaxPercentage() {
        // Generates a random numbers for tax percentage between 0 and 100
    	int t = faker.number().numberBetween(0, 100); 
        return String.valueOf(t);
    }
    
    public static String getProductCategory() {
        return faker.commerce().department();
    }

    public static double getProductPrice() {
        return Double.parseDouble(faker.commerce().price());
    }
    
    public static String getUserFullName() {
        return faker.name().fullName();
    }
    public static String getRandomEmail() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int length = 5;
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }
        String randomStringEmail = sb.toString() + "@gmail.com";
        return randomStringEmail;
        
    }
    
    public static String getUsername() {
        return faker.name().username();
    }
    
    public static String getPassword() {
        return faker.internet().password();
    }
    


}
