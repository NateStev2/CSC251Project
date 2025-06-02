public class Project_Nathaniel_Stevens {

    // --- Attributes (Instance Variables) ---
    private String policyNumber;
    private String providerName;
    private String policyholderFirstName;
    private String policyholderLastName;
    private int policyholderAge;
    private String smokingStatus; // "smoker" or "non-smoker"
    private double policyholderHeight; // in inches
    private double policyholderWeight; // in pounds

    // --- Constructors ---

    /**
     * No-arg constructor.
     * Sets default values for all policy attributes.
     */
    public Policy() {
        this.policyNumber = "N/A";
        this.providerName = "N/A";
        this.policyholderFirstName = "N/A";
        this.policyholderLastName = "N/A";
        this.policyholderAge = 0;
        this.smokingStatus = "non-smoker"; // Default to non-smoker
        this.policyholderHeight = 0.0;
        this.policyholderWeight = 0.0;
    }

    /**
     * Parameterized constructor.
     * Initializes all policy attributes with the provided arguments.
     *
     * @param policyNumber The unique policy number.
     * @param providerName The name of the insurance provider.
     * @param policyholderFirstName The first name of the policyholder.
     * @param policyholderLastName The last name of the policyholder.
     * @param policyholderAge The age of the policyholder.
     * @param smokingStatus The smoking status of the policyholder ("smoker" or "non-smoker").
     * @param policyholderHeight The height of the policyholder in inches.
     * @param policyholderWeight The weight of the policyholder in pounds.
     */
    public Policy(String policyNumber, String providerName, String policyholderFirstName,
                  String policyholderLastName, int policyholderAge, String smokingStatus,
                  double policyholderHeight, double policyholderWeight) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.policyholderFirstName = policyholderFirstName;
        this.policyholderLastName = policyholderLastName;
        this.policyholderAge = policyholderAge;
        this.smokingStatus = smokingStatus;
        this.policyholderHeight = policyholderHeight;
        this.policyholderWeight = policyholderWeight;
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
    public String getPolicyholderFirstName() {
        return policyholderFirstName;
    }

    /**
     * Retrieves the policyholder's last name.
     * @return The policyholder's last name.
     */
    public String getPolicyholderLastName() {
        return policyholderLastName;
    }

    /**
     * Retrieves the policyholder's age.
     * @return The policyholder's age.
     */
    public int getPolicyholderAge() {
        return policyholderAge;
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
    public double getPolicyholderHeight() {
        return policyholderHeight;
    }

    /**
     * Retrieves the policyholder's weight.
     * @return The policyholder's weight in pounds.
     */
    public double getPolicyholderWeight() {
        return policyholderWeight;
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
     * @param policyholderFirstName The new first name.
     */
    public void setPolicyholderFirstName(String policyholderFirstName) {
        this.policyholderFirstName = policyholderFirstName;
    }

    /**
     * Sets the policyholder's last name.
     * @param policyholderLastName The new last name.
     */
    public void setPolicyholderLastName(String policyholderLastName) {
        this.policyholderLastName = policyholderLastName;
    }

    /**
     * Sets the policyholder's age.
     * @param policyholderAge The new age.
     */
    public void setPolicyholderAge(int policyholderAge) {
        this.policyholderAge = policyholderAge;
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
     * @param policyholderHeight The new height in inches.
     */
    public void setPolicyholderHeight(double policyholderHeight) {
        this.policyholderHeight = policyholderHeight;
    }

    /**
     * Sets the policyholder's weight.
     * @param policyholderWeight The new weight in pounds.
     */
    public void setPolicyholderWeight(double policyholderWeight) {
        this.policyholderWeight = policyholderWeight;
    }

    // --- Calculation Methods ---

    /**
     * Calculates and returns the Body Mass Index (BMI) of the policyholder.
     * BMI = (Policyholder’s Weight * 703) / (Policyholder’s Height^2)
     *
     * @return The calculated BMI.
     */
    public double calculateBMI() {
        // Ensure height is not zero to avoid division by zero
        if (policyholderHeight <= 0) {
            return 0.0; // Or throw an IllegalArgumentException
        }
        return (policyholderWeight * 703) / (policyholderHeight * policyholderHeight);
    }

    /**
     * Calculates and returns the total price of the insurance policy.
     * The price is based on a base fee and additional fees for age, smoking status, and BMI.
     *
     * Base Fee: $600
     * Age Fee: +$75 if policyholder is over 50 years old.
     * Smoking Fee: +$100 if policyholder is a smoker.
     * BMI Fee: +(BMI - 35) * 20 if BMI is over 35.
     *
     * @return The total calculated insurance policy price.
     */
    public double calculateInsurancePrice() {
        double price = 600.0; // Base fee

        // Additional fee for age
        if (policyholderAge > 50) {
            price += 75.0;
        }

        // Additional fee for smoking status
        if (smokingStatus.equalsIgnoreCase("smoker")) {
            price += 100.0;
        }

        // Additional fee for BMI
        double bmi = calculateBMI(); // Always calculate fresh BMI to avoid stale data
        if (bmi > 35) {
            price += (bmi - 35) * 20.0;
        }

        return price;
    }
}