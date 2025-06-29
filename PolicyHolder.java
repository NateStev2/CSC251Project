public class PolicyHolder {
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus;
    private double height;
    private double weight;

    /**
     * No-arg constructor that explicitly initializes all fields
     */
    public PolicyHolder() {
        firstName = "";
        lastName = "";
        age = 0;
        smokingStatus = "";
        height = 0;
        weight = 0;
    }

    /**
     * Constructor that accepts arguments for each field
     * @param fName The Policyholder's first name
     * @param lName The Policyholder's last name
     * @param a The Policyholder's age
     * @param sStatus The Policyholder's smoking status
     * @param h The Policyholder's height
     * @param w The Policyholder's weight
     */
    public PolicyHolder(String fName, String lName, int a, String sStatus, double h, double w) {
        firstName = fName;
        lastName = lName;
        age = a;
        smokingStatus = sStatus;
        height = h;
        weight = w;
    }

    // Getters

    /**
     * @return The Policyholder's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return The Policyholder's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return The Policyholder's age
     */
    public int getAge() {
        return age;
    }

    /**
     * @return The Policyholder's smoking status
     */
    public String getSmokingStatus() {
        return smokingStatus;
    }

    /**
     * @return The Policyholder's height
     */
    public double getHeight() {
        return height;
    }

    /**
     * @return The Policyholder's weight
     */
    public double getWeight() {
        return weight;
    }

    // Setters

    /**
     * @param fName The Policyholder's first name
     */
    public void setFirstName(String fName) {
        firstName = fName;
    }

    /**
     * @param lName The Policyholder's last name
     */
    public void setLastName(String lName) {
        lastName = lName;
    }

    /**
     * @param a The Policyholder's age
     */
    public void setAge(int a) {
        age = a;
    }

    /**
     * @param sStatus The Policyholder's smoking status
     */
    public void setSmokingStatus(String sStatus) {
        smokingStatus = sStatus;
    }

    /**
     * @param h The Policyholder's height
     */
    public void setHeight(double h) {
        height = h;
    }

    /**
     * @param w The Policyholder's weight
     */
    public void setWeight(double w) {
        weight = w;
    }

    /**
     * Calculates the Policyholder's BMI
     * @return The BMI of the Policyholder
     */
    public double getBMI() {
        final double CONVFACTOR = 703;
        return (weight * CONVFACTOR) / (height * height);
    }

    /**
     * Returns a string representation of the PolicyHolder object.
     * @return A string containing the policyholder's details.
     */
    @Override
    public String toString() {
        return "Policyholder's First Name: " + firstName +
               "\nPolicyholder's Last Name: " + lastName +
               "\nPolicyholder's Age: " + age +
               "\nPolicyholder's Smoking Status: " + smokingStatus +
               "\nPolicyholder's Height: " + String.format("%.1f", height) + " inches" +
               "\nPolicyholder's Weight: " + String.format("%.1f", weight) + " pounds" +
               "\nPolicyholder's BMI: " + String.format("%.2f", getBMI());
    }
}