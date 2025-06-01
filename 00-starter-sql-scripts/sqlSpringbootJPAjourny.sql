-- DELETE FROM student_tracker.student WHERE id > 0;
SELECT first_name, last_name, email  FROM student_tracker.student;

-- sets the next value for the AUTO_INCREMENT column (usually the id) to 1
-- it removes all data permanently
TRUNCATE TABLE student_tracker.student;
ALTER TABLE student_tracker.student AUTO_INCREMENT = 1 ;



SELECT * FROM student_tracker.student;