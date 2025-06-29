public class Policy {
    private String policyNumber;
    private String providerName;
    private PolicyHolder policyHolder; // Composition: Policy has a PolicyHolder

    private static int numberOfPolicies = 0; // Static field to track policy count

    /**
     * No-arg constructor that explicitly initializes all fields
     */
    public Policy() {
        policyNumber = "";
        providerName = "";
        policyHolder = new PolicyHolder(); // Initialize the PolicyHolder object
        numberOfPolicies++; // Increment the static counter
    }

    /**
     * Constructor that accepts arguments for each field and a PolicyHolder object
     * @param pNumber The Policy number
     * @param pName The Policy Provider's Name
     * @param holder A PolicyHolder object representing the policyholder
     */
    public Policy(String pNumber, String pName, PolicyHolder holder) {
        policyNumber = pNumber;
        providerName = pName;
        // Deep copy for security to prevent external modification of the PolicyHolder object
        policyHolder = new PolicyHolder(holder.getFirstName(), holder.getLastName(),
                                        holder.getAge(), holder.getSmokingStatus(),
                                        holder.getHeight(), holder.getWeight());
        numberOfPolicies++; // Increment the static counter
    }

    // Getters

    /**
     * @return The Policy Number
     */
    public String getPolicyNumber() {
        return policyNumber;
    }

    /**
     * @return The Policy Provider's Name
     */
    public String getProviderName() {
        return providerName;
    }

    /**
     * @return A PolicyHolder object (deep copy for security)
     */
    public PolicyHolder getPolicyHolder() {
        // Return a new PolicyHolder object with the same data to prevent security holes
        return new PolicyHolder(policyHolder.getFirstName(), policyHolder.getLastName(),
                                policyHolder.getAge(), policyHolder.getSmokingStatus(),
                                policyHolder.getHeight(), policyHolder.getWeight());
    }

    /**
     * @return The total number of Policy objects created
     */
    public static int getNumberOfPolicies() {
        return numberOfPolicies;
    }

    // Setters

    /**
     * @param pNumber The Policy Number
     */
    public void setPolicyNumber(String pNumber) {
        policyNumber = pNumber;
    }

    /**
     * @param pName The Policy Provider's name
     */
    public void setProviderName(String pName) {
        providerName = pName;
    }

    /**
     * @param holder A PolicyHolder object to set for this policy (deep copy for security)
     */
    public void setPolicyHolder(PolicyHolder holder) {
        // Deep copy for security to prevent external modification of the PolicyHolder object
        policyHolder = new PolicyHolder(holder.getFirstName(), holder.getLastName(),
                                        holder.getAge(), holder.getSmokingStatus(),
                                        holder.getHeight(), holder.getWeight());
    }

    /**
     * Calculates the Policy's price
     * @return The price of the Policy
     */
    public double getPrice() {
        final double BASE_PRICE = 600;
        final double ADDITIONAL_FEE_AGE = 75;
        final double ADDITIONAL_FEE_SMOKING = 100;
        final double ADDITIONAL_FEE_PER_BMI = 20;

        final int AGE_THRESHOLD = 50;
        final int BMI_THRESHOLD = 35;

        double price = BASE_PRICE;

        if (policyHolder.getAge() > AGE_THRESHOLD) {
            price += ADDITIONAL_FEE_AGE;
        }

        if (policyHolder.getSmokingStatus().equalsIgnoreCase("smoker")) {
            price += ADDITIONAL_FEE_SMOKING;
        }

        if (policyHolder.getBMI() > BMI_THRESHOLD) {
            price += ((policyHolder.getBMI() - BMI_THRESHOLD) * ADDITIONAL_FEE_PER_BMI);
        }

        return price;
    }

    /**
     * Returns a string representation of the Policy object.
     * @return A string containing the policy details and the associated policyholder's details.
     */
    @Override
    public String toString() {
        return "Policy Number: " + policyNumber +
               "\nProvider Name: " + providerName +
               "\n" + policyHolder.toString() + // Implicitly calls PolicyHolder's toString
               "\nPolicy Price: $" + String.format("%.2f", getPrice()) + "\n";
    }
}