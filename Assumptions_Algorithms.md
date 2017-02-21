# Class Diagram

![Alt text](src/main/resources/CTMUml.png?raw=true "Class Diagram")

##Conference
* Class for maintaining entire sessions & collection of presentation to be planned in each session
* Order of session is maintained - since ArrayList is used for maintaining Session

##Session
* Class for storing individual session & collection of talk to be presented.
* Each session has it's own range of allowed duration 

###BreakSession
* Extends Session class with it's own set of properties assigned.
* scheduleSession is not implmeneted - as break session dont have presentation
* Session with no presentation or empty presentation object

###PresentationSession
* Collection of presentation is mandatory
* Custom implemented algorithm for scheduling presentation within each session.

##CTMInputReader
* Custom Input Reader class - based on constructor call with filename/without file name, input will be read from console or specified file
* Reads line input (presentation) entry is predefined format & creates Presentation object for each valid input line.

##CTMOutputWriter
* Custom Output writer class - based on filename specified while creating object, output will be flushed to console or file.

##CommonUtils & StringUtils
* Commonly used utility methods which can be reused across project

##CTMScheduler
* 
