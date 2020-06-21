

DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS library;


CREATE TABLE IF NOT EXISTS library (
 library_id INT AUTO_INCREMENT PRIMARY KEY,
  library_name VARCHAR(50) NOT NULL,
  library_address VARCHAR(50) NOT NULL
);

INSERT INTO library (library_id,library_name, library_address) VALUES
  (1,'US Libray of Congress', 'Washington'),
  (2,'British Library', 'London'), 
  (3,'New York Library','New York');


CREATE TABLE IF NOT EXISTS books (
  isbn VARCHAR(250)  PRIMARY KEY,
  book_title VARCHAR(250) NOT NULL,
  publisher VARCHAR(250) NOT NULL,
  author VARCHAR(250) NOT NULL,
  published_year INT NOT NULL, 
  library INT NOT NULL,  
  CONSTRAINT FK_LIBRARY_NAME FOREIGN KEY (library) REFERENCES library(library_id)
);
 

INSERT INTO books (isbn, book_title, publisher,author,published_year,library) VALUES
  ('978-1-891830-71-6', 'Paradis Lost', 'Stenyachov','Homer',100,1),
  ('978-1-218211-11-6', 'ALice in Wonderland', 'Oxford','Lewis Caroll',1896,3),
  ('568-1-675256-71-6', 'War Machine', 'Mgraw Hill','H.G. Wells',1905,1);