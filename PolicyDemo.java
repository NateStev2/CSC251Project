import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;

public class PolicyDemo {
    public static void main(String[] args) throws IOException {
        // Declare variables
        String policyNumber;
        String providerName;
        String firstName;
        String lastName;
        int age;
        String smokingStatus;
        double height;
        double weight;

        int numSmokers = 0;
        int numNonSmokers = 0;

        // ArrayList to store Policy objects
        ArrayList<Policy> policyList = new ArrayList<Policy>();

        // Create and open the file
        File file = new File("PolicyInformation.txt");
        Scanner inputFile = new Scanner(file);

        // Process all information in the file
        while (inputFile.hasNext()) {
            policyNumber = inputFile.nextLine();
            providerName = inputFile.nextLine();
            firstName = inputFile.nextLine();
            lastName = inputFile.nextLine();
            age = inputFile.nextInt();
            inputFile.nextLine(); // Consume the newline character
            smokingStatus = inputFile.nextLine();
            height = inputFile.nextDouble();
            weight = inputFile.nextDouble();

            // Make sure we haven't hit the end of the file before trying to skip the blank line
            if (inputFile.hasNext()) {
                inputFile.nextLine(); // Consume the remaining newline after reading weight
            }
            if (inputFile.hasNext()) { // This accounts for the blank line between records
                inputFile.nextLine();
            }

            // Create a PolicyHolder object
            PolicyHolder currentPolicyHolder = new PolicyHolder(firstName, lastName, age, smokingStatus, height, weight);

            // Create a Policy object and add it to our ArrayList
            policyList.add(new Policy(policyNumber, providerName, currentPolicyHolder));
        }

        // Close the file
        inputFile.close();

        // Print out information about each Policy object
        for (Policy policy : policyList) {
            System.out.println(policy); // Implicitly calls the toString method of Policy
            
            // Keep track of the number of smokers and non-smokers
            if (policy.getPolicyHolder().getSmokingStatus().equalsIgnoreCase("smoker")) {
                numSmokers++;
            } else {
                numNonSmokers++;
            }
        }

        // Print out the total number of Policy objects created
        System.out.println("The number of policies created: " + Policy.getNumberOfPolicies());
        System.out.println("The number of policyholders with a smoker status: " + numSmokers);
        System.out.println("The number of policyholders with a non-smoker status: " + numNonSmokers);
    }
}