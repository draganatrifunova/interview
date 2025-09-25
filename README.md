STEPS TO START THE PROJECT
=====================






1) docker-compose up -d
2) Start SpringBoot application
3) go to  http://localhost:8080/swagger-ui/index.html    /    write commands about Book in console (in the same console where application is initialized)





CONSOLE EXAMPLE
===============






Enter command: 1)addBook  2)listBooks  3)updateBook  4)deleteBook  5)exit   
PROPER SYNTAX: addBook <isbn[String]> <title[String]> <author[String]> <publishedDate[LocalDate]> <availableCopies[int]>   
PROPER SYNTAX: listBooks   
PROPER SYNTAX: updateBook <isbn[String]> <title[String]> <author[String]> <publishedDate[LocalDate]> <availableCopies[int]>   
PROPER SYNTAX: deleteBook <isbn[String]>   
PROPER SYNTAX: exit   
addBook 123sd Nebo KocoRacin 2003-12-02 12   
Enter command: 1)addBook  2)listBooks  3)updateBook  4)deleteBook  5)exit   
PROPER SYNTAX: addBook <isbn[String]> <title[String]> <author[String]> <publishedDate[LocalDate]> <availableCopies[int]>   
PROPER SYNTAX: listBooks   
PROPER SYNTAX: updateBook <isbn[String]> <title[String]> <author[String]> <publishedDate[LocalDate]> <availableCopies[int]>   
PROPER SYNTAX: deleteBook <isbn[String]>   
PROPER SYNTAX: exit   
listBooks   
DisplayBookDto[isbn=123sd, title=Nebo, author=KocoRacin, publishedDate=2003-12-02, availableCopies=12]   
Enter command: 1)addBook  2)listBooks  3)updateBook  4)deleteBook  5)exit   
PROPER SYNTAX: addBook <isbn[String]> <title[String]> <author[String]> <publishedDate[LocalDate]> <availableCopies[int]>   
PROPER SYNTAX: listBooks   
PROPER SYNTAX: updateBook <isbn[String]> <title[String]> <author[String]> <publishedDate[LocalDate]> <availableCopies[int]>   
PROPER SYNTAX: deleteBook <isbn[String]>   
PROPER SYNTAX: exit      
exit
