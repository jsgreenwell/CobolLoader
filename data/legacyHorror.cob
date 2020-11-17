IDENTIFICATION DIVISION.
PROGRAM-ID.  StudentWriter.
AUTHOR.  Some Old Dude.
* This writes records
* Seriously!? Do you even know how annoying no comments are
* In 46 year old programs that are still in use!?!?!?!?

ENVIRONMENT DIVISION.
INPUT-OUTPUT SECTION.
FILE-CONTROL.
    SELECT student-file ASSIGN TO "STUDENTS.DAT"
		ORGANIZATION IS LINE SEQUENTIAL.

DATA DIVISION.
FILE SECTION.
    fd data-file
          LABEL RECORDS ARE STANDARD
          DATA RECORD IS data-rec.
       01 data-rec.
          05 data-id                   pic 9(12).
          05 data-filler               pic X(01).
          05 data-name.
              03 student-name          pic X(22).
              03 student-initials      pic XXX.
          05 data-filler              pic X(01).
          05 data-dob.
              03 birth-year           pic 9(4).
              03 MOBirth              pic 99.
              03 DOBirth              pic 99.
          05  CourseCode              pic X(4).

PROCEDURE DIVISION.
Begin.
    OPEN OUTPUT student-file
    DISPLAY "Enter student information.  Enter nothing to end."

    PERFORM UNTIL studentinfo = SPACES
       WRITE studentinfo
       PERFORM GetStudentInfo
    END-PERFORM
    CLOSE student-file
    STOP RUN.

GetStudentInfo.
    DISPLAY "Enter - StudId, Surname, Initials, YOB, MOB, DOB, Course, Gender"
    DISPLAY "[__________________________________]"
    ACCEPT  studentinfo.