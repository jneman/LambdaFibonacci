LambdaFibonacci
Overview

LambdaFibonacci is an AWS Lambda function written in Java that generates the first n Fibonacci numbers.

This project was chosen to demonstrate that Java functions can run successfully in a serverless AWS Lambda environment. It is a Serverless Application, designed to run without managing servers and respond to events. This project also shows how Java applications can be packaged, deployed, and executed in a serverless architecture.

This project demonstrates:

Serverless computing using AWS Lambda
Java 17 application development
Maven-based build and packaging
Features
Generates Fibonacci sequence up to n terms
Input validation to prevent integer overflow
Packaged as a deployable fat JAR for AWS Lambda
Input Constraints

The function enforces the following constraints:

n > 0
n < 48
Reason for Constraint

Java’s int type has a maximum value of 2,147,483,647.
When n >= 48, the sum of Fibonacci numbers exceeds this limit, causing integer overflow and resulting in incorrect (negative) values.

Example
Input (Event JSON)
{
  "n": 10
}
Output
[0, 1, 1, 2, 3, 5, 8, 13, 21, 34]
Project Structure
src/
├── main/
│   ├── java/com/example/
│   │   └── LambdaFibonacci.java
│   └── resources/
│       └── application.properties
├── test/
│   └── java/com/example/
│       └── TestLambdaFibonacci.java
pom.xml
Build Instructions
Prerequisites
Java 17
Maven
Build the Project

Run the following command from the root directory:

mvn clean package -DskipTests
Build Output

After the build completes, the .jar files will be located in:

target/

The target folder will contain two JAR files:

A standard JAR (smaller size)
A fat JAR (larger size)

Important: For AWS Lambda deployment, you must use the fat JAR (the larger file), because it includes all required dependencies.

AWS Lambda Deployment
Log in to AWS Management Console
Navigate to AWS Lambda
Click Create function
Select:
Runtime: Java 17
Upload the fat JAR file from the target/ directory
Fill out the Handler field in the Code tab. Set it to:
com.example.LambdaFibonacci::handleRequest
Deploy the function
Testing in AWS Lambda
Go to your deployed Lambda function in the AWS Console
Click on the Test tab
Supply an Event JSON similar to the following:
{
  "n": 5
}
Click Test to execute the Lambda function and view the results
Why Use AWS Lambda?

AWS Lambda is a serverless computing service that allows you to run code without provisioning or managing servers. Its advantages include:

No server management: You don’t need to manage operating systems or infrastructure.
Automatic scaling: Lambda automatically scales your application in response to the number of requests.
Cost-efficient: You pay only for the compute time your function consumes, measured in milliseconds.
Event-driven: Lambda functions can be triggered by various AWS services such as S3, DynamoDB, API Gateway, and CloudWatch events.
Easy deployment: Upload a JAR, ZIP, or container image, and Lambda handles the runtime execution environment.

This project is a Serverless Application, showing how Java code can be executed in AWS Lambda in response to events, without managing servers. It demonstrates the integration of Java applications with a serverless architecture.

How It Works

AWS Lambda runs each function in its own isolated container, similar to a standalone Docker container. When you create a Lambda function:

Packaging: AWS packages your function into a container.
Execution: The container is executed on AWS-managed servers across multiple regions.
Resource Allocation: Each container is allocated the necessary RAM and CPU, which you can configure in the Lambda settings.
Billing: After execution, AWS calculates the cost based on allocated memory × execution duration. You are charged only for the compute resources consumed while the function runs.

This architecture allows serverless, event-driven execution without managing servers, and ensures you only pay for the compute time your function actually uses.

Repository

https://github.com/jneman/LambdaFibonacci

Author

J Neman

