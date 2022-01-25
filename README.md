# airplane.seating.algorithm
Airplane Seating Algorithm project that helps seat audiences in a flight by Spring Boot

Statement:
    Write a program that helps seat audiences in a flight based on the following input and rules.

    Rules:
        • Always seat passengers starting from the front row to back, starting from the left to the right.
        • Fill aisle seats first followed by window seats followed by center seats (any order in center seats).
        
Input to the program will be:
    • A 2D array that represents the rows and columns [[3,4], [4,5], [2,3], [3,4]]. This 2D array is just an example. 
    • Number of passengers waiting in queue.

For more details look into the [PDF File]() 
    
Steps to run the program

1. Use this command to run the server
   `./mvnw spring-boot:run`
            OR
   run the main file **AirplanseSeatingAlgorithmApplication**

2. Pass this configurations for example **[[3,4], [4,5], [2,3], [3,4]]**.
3. Then pass the number of passengers like **30**.
