# Algorithm
This algorithm forms cubset of array for given set of array with non-repeative unique combination. Calculate total sum of duration for each collection of duration. If sum of minutes falls within the acceptable range of duration for session; then corresponding presentation collection is assigned to the session.  
####Sample Data

```java
Array[] = {0,1,2,3}  
//1: Subset array combination for above sample array whould be
0  
1  
2  
3  
0 1  
0 2  
0 3  
1 2  
1 3  
2 3  
0 1 2  
0 1 3  
0 2 3  
//2: Sum of minutes for each sub array is calculated
//3: Check whether it falls with session time duration
```
>This algorithm is faster - since we are validating each subarray against session duration; it doesn't need to start from first point for each session. Also we are marking a presentation as **Scheduled** once it is added to session. It reduces the combination of subarray count drastically & improves performance of this algorithm.  

**Based on the scheduling algorithm order of presentation in each session would be decided. Since this algorithm follows *Brute Force* based scheduling algorithm it gives different order of presentation output. But Duration range for each session specified is enforced in scheduling**  


# Class Diagram

![Alt text](src/main/resources/CTMUml.png?raw=true "Class Diagram")

###Conference
* Class for maintaining entire sessions & collection of presentation to be planned in each session
* Order of session is maintained - since ArrayList is used for maintaining Session

###Session
* Class for storing individual session & collection of talk to be presented.
* Each session has it's own range of allowed duration 

####BreakSession
* Extends Session class with it's own set of properties assigned.
* scheduleSession is not implmeneted - as break session dont have presentation
* Session with no presentation or empty presentation object

####PresentationSession
* Collection of presentation is mandatory
* Custom implemented algorithm for scheduling presentation within each session.

###CTMInputReader
* Custom Input Reader class - based on constructor call with filename/without file name, input will be read from console or specified file
* Reads line input (presentation) entry is predefined format & creates Presentation object for each valid input line.

###CTMOutputWriter
* Custom Output writer class - based on filename specified while creating object, output will be flushed to console or file.

###CommonUtils & StringUtils
* Commonly used utility methods which can be reused across project

###CTMScheduler
* Scheduler algorithm defined above is implmented & will prepare collection of presentation based on allowed range of duration of corresponding session.
