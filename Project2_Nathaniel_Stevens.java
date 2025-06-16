import java.util.Scanner; // Import the Scanner class for user input
import java.text.DecimalFormat; // Import DecimalFormat for formatting output

// The main public class for the application
public class Project2_Nathaniel_Stevens {

    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Create a DecimalFormat object to format numbers to two decimal places
        DecimalFormat df = new DecimalFormat("0.00");

        // --- Prompt for Policy Details ---
        System.out.print("Please enter the Policy Number: ");
        String policyNumber = scanner.nextLine();

        System.out.print("Please enter the Provider Name: ");
        String providerName = scanner.nextLine();

        System.out.print("Please enter the Policyholder’s First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Please enter the Policyholder’s Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Please enter the Policyholder’s Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character left by nextInt()

        System.out.print("Please enter the Policyholder’s Smoking Status (smoker/non-smoker): ");
        String smokingStatus = scanner.nextLine();

        System.out.print("Please enter the Policyholder’s Height (in inches): ");
        double height = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Please enter the Policyholder’s Weight (in pounds): ");
        double weight = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        // Close the scanner to prevent resource leaks
        scanner.close();

        // --- Create a Policy object using the collected data ---
        Policy policy = new Policy(policyNumber, providerName, firstName,
                                   lastName, age, smokingStatus,
                                   height, weight);

        // --- Display Policy Details and Calculated Values ---
        System.out.println("\nPolicy Number: " + policy.getPolicyNumber());
        System.out.println("Provider Name: " + policy.getProviderName());
        System.out.println("Policyholder’s First Name: " + policy.getFirstName());
        System.out.println("Policyholder’s Last Name: " + policy.getLastName());
        System.out.println("Policyholder’s Age: " + policy.getAge());
        System.out.println("Policyholder’s Smoking Status: " + policy.getSmokingStatus());
        System.out.println("Policyholder’s Height: " + df.format(policy.getHeight()) + " inches");
        System.out.println("Policyholder’s Weight: " + df.format(policy.getWeight()) + " pounds");

        // Calculate and display BMI and Policy Price
        System.out.println("Policyholder’s BMI: " + df.format(policy.calculateBMI()));
        System.out.println("Policy Price: $" + df.format(policy.calculatePolicyPrice()));
    }
}

// The Policy class, now nested within the same file.
// It is no longer public as only one public class is allowed per .java file.
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