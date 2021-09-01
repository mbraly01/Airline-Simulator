# Airline Simulator
## Goal
The goal of this project is to find flights for passengers, assign them to those flights, and have a list of passengers who have boarded flights, as well as a list of passengers that have not.

## Classes
* Airport - this is a class that outlines the Airport object.
* Calculator - This class calculates the passengers boarding planes
* Flight - this is the class that defines the Flight object
* Generator - this class creates the csvs that contain passengers and flights
* Luggage - this class defines the luggage object
* Main - the class which executes the program
* Passenger - this class defines the Passenger object
* Plane - this class defines the plane object

## Project Details
The airports hold flights in and out. The flights are made up of planes (which dictate the amount of passengers and cargo a flight can handle), start locations, end locations, and distance. The Passenger object goes on planes. A double representing luggage weight is also assigned to the plane.

## Future Improvements
I am working on a way to assign passengers to connecting flights instead of having them be left over. I am also working to make airports more central to the flight assignment process. C++ would be a good language to rebuild this project in, as pointers could be useful when assigning passengers to flights.