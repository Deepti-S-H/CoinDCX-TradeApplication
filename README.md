# CoinDCX-TradeApplication

Overview:
This Java application connects to the CoinDCX WebSocket API to fetch real-time cryptocurrency trading data. It allows users to specify trigger prices for buying and selling, and automatically prepares the necessary payloads for order operations when market conditions are met.


Requirements
Java 8 or later(I have used Vs code if u are comfortable with eclipse go for it)
Maven 3.6.0 or later
Red hat dependency analytics (install it from extensions)


SetUp Instructions:  
Step-1: Clone this repository to your local machine using the following command:
   git clone https://github.com/Deepti-S-H/CoinDCX-TradeApplication.git 
Step-2:Navigate to the project directory and run the following Maven commands to build the project:
  * cd CoinDCX-TradeApplication
  * mvn clean install
(If u are facing any difficulty in building the project try the below command after successfully installing the maven
  * mvn archetype:generate
  * maven-archetype-quickstart
  * Define groupId:com.example,artifactId:mavenproject,version:1.0-SNAPSHOT,package:com.example.mavenproject)
Step-3:You can run the application via the command line using Maven:
 * mvn exec:java


How to Use:
Enter your trigger buy price and trigger sell price in the GUI.
The application will start fetching real-time market prices.
When the current price hits the trigger points, the application will prepare the buy/sell order payloads and display them in the output area.

	
Technologies Used:
Java: The programming language used to build the application.
Maven: Used for project build and dependency management.
WebSocket: For real-time data fetching from CoinDCX.
Jackson: For JSON parsing and handling.
Swing: To create a simple graphical user interface (GUI).


Future Improvements:
Add automated order execution.
Add support for multiple trading pairs.
Add a more advanced user interface with charts and notifications.


