package com.company;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.iam.IamClient;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);
        System.out.println("AWS Access Key ID [None]:");
        String accessKeyId = input.nextLine();
        System.out.println("AWS Secret Access Key [None]:");
        String secretAccessKey = input.nextLine();
        System.out.println("Default region name [None]:");
        String regionName = input.nextLine();
        System.out.println("Default output format [None]:");
        String outputFormat = input.nextLine();

        StaticCredentialsProvider provider = StaticCredentialsProvider.create(AwsBasicCredentials.create(accessKeyId, secretAccessKey));

        IamClient iam = IamClient.builder().credentialsProvider(provider).region(Region.of(regionName)).build();

        System.out.println(iam.listUsers().toString());



    }
}
