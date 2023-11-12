<b>Input Commands & Format</b>:

1. ADD_DRIVER <DRIVER_ID> <X_COORDINATE> <Y_COORDINATE>

- Create new driver object with constructor (id,x,y)
- push the driver in DriversDatabase
- at start driver status will be available

2. ADD_RIDER <RIDER_ID> <X_COORDINATE> <Y_COORDINATE>

- Create new rider object with constructor (id,x,y)
- push the driver in RidersDatabase

3. MATCH <RIDER_ID>

- Call getRiderById - Got the rider object
- Call matchDrivers function on that object
  (Clarify what happens here in more depth)
-> Driver matching algorithm:
  - Iterate over all drivers
    - If driver is IN-RIDE drop
    - Calculate distance between rider and driver
    - Driver.getDistanceFrom(x,y)
    - Maintain priority queue of least distance drivers with max length of 5  

4. START_RIDE <RIDE_ID> <N> <RIDER_ID>

- Check if valid ride_id is assigned, based on ridesDatabase
- getRiderById(riderId) get the matches arr
- check the validity of the N inputted
- If all valid 
  - Create the object Ride(rideId, riderId, driverId, xPos, yPos)
  - Update driver status to IN-RIDE
  - Update the ride status to START
  
5. STOP_RIDE <RIDE_ID> <DESTINATION_X_COORDINATE> <DESTINATION_Y_COORDINATE> <TIME_TAKEN_IN_MIN>
- If ride Id exists
- Check if valid ride_id is already stopped, 

- If all is valid
    - Update ride status as stopped
    - Update driver status as Available
    - update(destXCord,destYCord,timeTaken)

BILL <RIDE_ID>

- getRideByRideId(rideId).calculateBill()
- If ride is in START State - “RIDE_NOT_COMPLETED”
- getRideByRideId(rideId) == null - ‘INVALID_RIDE’
Print the total bill of the ride in the format ‘BILL <RIDE_ID> <DRIVER_ID> <AMOUNT>’. To calculate the total bill use the following formula:

Billing algorithm:
A base fare of ₹50 is charged for every ride.
An additional ₹6.5 is charged for every kilometer traveled.
An additional ₹2 is charged for every minute spent in the ride.
A service tax of 20% is added to the final amount.

