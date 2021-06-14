Step1:
Clone the application using the following command to your desired location

git clone https://github.com/karera1/stockData.git

Step 2:
cd inside the project

cd stockData


Step 3:
unpack all the Maven packages and run unit test
mvn -package

Step 4:
Run the application snapshot

java -jar /target/stockData-0.0.1-SNAPSHOT.jar

Step 5:
open a new browser and run the client using the following url

http://localhost:8080/

Note: currently this method is not working still working on resolving this issue. Need to pull the code to eclipse/Intellij and run it.
