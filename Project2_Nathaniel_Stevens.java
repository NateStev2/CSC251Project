import java.io.File; // Import the File class for file operations
import java.io.FileNotFoundException; // Import this to handle file not found errors
import java.util.ArrayList; // Import ArrayList to store Policy objects dynamically
import java.util.List; // Import List interface
import java.util.Scanner; // Import the Scanner class for reading from file
import java.text.DecimalFormat; // Import DecimalFormat for formatting output

/**
 * The main public class for the insurance policy application.
 * This class reads policy information from a text file, creates Policy objects,
 * stores them, and then displays details and calculated statistics.
 */
public class Project2_Nathaniel_Stevens {

    public static void main(String[] args) {
        // Create a DecimalFormat object to format numbers to two decimal places
        DecimalFormat df = new DecimalFormat("0.00");

        // Use a List to store Policy objects. ArrayList is chosen for its dynamic size.
        List<Policy> policyList = new ArrayList<>();

        // Define the name of the input file
        String fileName = "PolicyInformation.txt";

        // Try-with-resources statement to ensure the Scanner is closed automatically
        try (Scanner fileScanner = new Scanner(new File(fileName))) {
            // Loop as long as there are more lines in the file
            while (fileScanner.hasNextLine()) {
                // Read all 8 pieces of information for one policy
                String policyNumber = fileScanner.nextLine();
                String providerName = fileScanner.nextLine();
                String firstName = fileScanner.nextLine();
                String lastName = fileScanner.nextLine();
                int age = Integer.parseInt(fileScanner.nextLine()); // Convert String to int
                String smokingStatus = fileScanner.nextLine();
                double height = Double.parseDouble(fileScanner.nextLine()); // Convert String to double
                double weight = Double.parseDouble(fileScanner.nextLine()); // Convert String to double

                // Create a Policy object with the read data
                Policy policy = new Policy(policyNumber, providerName, firstName,
                                           lastName, age, smokingStatus,
                                           height, weight);

                // Add the created Policy object to the list
                policyList.add(policy);
            }
        } catch (FileNotFoundException e) {
            // Handle the case where the specified file does not exist
            System.out.println("Error: The file '" + fileName + "' was not found.");
            System.out.println("Please make sure the file is in the same directory as the program.");
            return; // Exit the program if the file is not found
        } catch (NumberFormatException e) {
            // Handle cases where age, height, or weight cannot be parsed to numbers
            System.out.println("Error reading data from file: Invalid number format encountered.");
            System.out.println("Please check the data types in your PolicyInformation.txt file.");
            return; // Exit if there's a parsing error
        }

        // --- Display Policy Details and Calculated Values for each policy ---
        System.out.println("--- Insurance Policy Details ---");
        System.out.println("Total Policies Loaded: " + policyList.size() + "\n");

        int smokerCount = 0;
        int nonSmokerCount = 0;
        double totalAge = 0;
        double totalBMI = 0;
        double totalPolicyPrice = 0;

        // Iterate through the list of policies and display their details
        for (Policy policy : policyList) {
            System.out.println("Policy Number: " + policy.getPolicyNumber());
            System.out.println("Provider Name: " + policy.getProviderName());
            System.out.println("Policyholder’s First Name: " + policy.getFirstName());
            System.out.println("Policyholder’s Last Name: " + policy.getLastName());
            System.out.println("Policyholder’s Age: " + policy.getAge());
            System.out.println("Policyholder’s Smoking Status: " + policy.getSmokingStatus());
            System.out.println("Policyholder’s Height: " + df.format(policy.getHeight()) + " inches");
            System.out.println("Policyholder’s Weight: " + df.format(policy.getWeight()) + " pounds");

            // Calculate and display BMI and Policy Price for the current policy
            double currentBMI = policy.calculateBMI();
            double currentPolicyPrice = policy.calculatePolicyPrice();
            System.out.println("Policyholder’s BMI: " + df.format(currentBMI));
            System.out.println("Policy Price: $" + df.format(currentPolicyPrice));
            System.out.println("-------------------------------------");

            // Accumulate data for statistics
            if (policy.getSmokingStatus().equalsIgnoreCase("smoker")) {
                smokerCount++;
            } else {
                nonSmokerCount++;
            }
            totalAge += policy.getAge();
            totalBMI += currentBMI;
            totalPolicyPrice += currentPolicyPrice;
        }

        // --- Display Statistics ---
        System.out.println("\n--- Policy Statistics ---");
        System.out.println("Number of Policyholders who are smokers: " + smokerCount);
        System.out.println("Number of Policyholders who are non-smokers: " + nonSmokerCount);

        // Calculate and display averages, handling division by zero if list is empty
        if (!policyList.isEmpty()) {
            System.out.println("Average age of all Policyholders: " + df.format(totalAge / policyList.size()));
            System.out.println("Average BMI of all Policyholders: " + df.format(totalBMI / policyList.size()));
            System.out.println("Average Policy Price: $" + df.format(totalPolicyPrice / policyList.size()));
        } else {
            System.out.println("No policies loaded to calculate averages.");
        }
    }
}

/**
 * The Policy class represents an insurance policy with details about the policy
 * and the policyholder. It includes methods for calculating BMI and policy price.
 */
class Policy {
    // Attributes of the insurance policy
    private String policyNumber;
    private String providerName;
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus; // "smoker" or "non-smoker"
    private double height;        // in inches
    private double weight;        // in pounds

    /**
     * No-argument constructor for the Policy class.
     * Sets default values for all policy attributes.
     */
    public Policy() {
        this.policyNumber = "N/A";
        this.providerName = "N/A";
        this.firstName = "N/A";
        this.lastName = "N/A";
        this.age = 0;
        this.smokingStatus = "non-smoker";
        this.height = 0.0;
        this.weight = 0.0;
    }

    /**
     * Constructor for the Policy class that accepts arguments for all attributes.
     *
     * @param policyNumber    The unique policy number.
     * @param providerName    The name of the insurance provider.
     * @param firstName       The policyholder's first name.
     * @param lastName        The policyholder's last name.
     * @param age             The policyholder's age.
     * @param smokingStatus   The policyholder's smoking status ("smoker" or "non-smoker").
     * @param height          The policyholder's height in inches.
     * @param weight          The policyholder's weight in pounds.
     */
    public Policy(String policyNumber, String providerName, String firstName,
                  String lastName, int age, String smokingStatus,
                  double height, double weight) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.smokingStatus = smokingStatus;
        this.height = height;
        this.weight = weight;
    }

    // --- Accessor (Getter) Methods ---

    /**
     * Retrieves the policy number.
     * @return The policy number.
     */
    public String getPolicyNumber() {
        return policyNumber;
    }

    /**
     * Retrieves the provider name.
     * @return The provider name.
     */
    public String getProviderName() {
        return providerName;
    }

    /**
     * Retrieves the policyholder's first name.
     * @return The policyholder's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Retrieves the policyholder's last name.
     * @return The policyholder's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Retrieves the policyholder's age.
     * @return The policyholder's age.
     */
    public int getAge() {
        return age;
    }

    /**
     * Retrieves the policyholder's smoking status.
     * @return The policyholder's smoking status.
     */
    public String getSmokingStatus() {
        return smokingStatus;
    }

    /**
     * Retrieves the policyholder's height.
     * @return The policyholder's height in inches.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Retrieves the policyholder's weight.
     * @return The policyholder's weight in pounds.
     */
    public double getWeight() {
        return weight;
    }

    // --- Mutator (Setter) Methods ---

    /**
     * Sets the policy number.
     * @param policyNumber The new policy number.
     */
    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    /**
     * Sets the provider name.
     * @param providerName The new provider name.
     */
    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    /**
     * Sets the policyholder's first name.
     * @param firstName The new first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets the policyholder's last name.
     * @param lastName The new last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Sets the policyholder's age.
     * @param age The new age.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Sets the policyholder's smoking status.
     * @param smokingStatus The new smoking status ("smoker" or "non-smoker").
     */
    public void setSmokingStatus(String smokingStatus) {
        this.smokingStatus = smokingStatus;
    }

    /**
     * Sets the policyholder's height.
     * @param height The new height in inches.
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Sets the policyholder's weight.
     * @param weight The new weight in pounds.
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    // --- Calculation Methods ---

    /**
     * Calculates and returns the Body Mass Index (BMI) of the policyholder.
     * BMI = (Policyholder’s Weight * 703) / (Policyholder’s Height^2)
     *
     * @return The calculated BMI.
     */
    public double calculateBMI() {
        // Ensure height is not zero to prevent division by zero
        if (height == 0) {
            return 0.0; // Or throw an IllegalArgumentException
        }
        return (weight * 703) / (height * height);
    }

    /**
     * Calculates and returns the total price of the insurance policy.
     * The price is based on a base fee and additional fees for age,
     * smoking status, and BMI.
     *
     * @return The calculated policy price.
     */
    public double calculatePolicyPrice() {
        double policyPrice = 600.0; // Base fee

        // Additional fee for age
        if (age > 50) {
            policyPrice += 75.0;
        }

        // Additional fee for smoking status (case-insensitive check)
        if (smokingStatus.equalsIgnoreCase("smoker")) {
            policyPrice += 100.0;
        }

        // Additional fee for BMI
        double bmi = calculateBMI(); // Get the current BMI
        if (bmi > 35) {
            policyPrice += (bmi - 35) * 20;
        }

        return policyPrice;
    }
}