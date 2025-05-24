# PRACTICAL PROJECT

## Objectives

- Develop a program that fulfills the prerequisites listed in the assignment description.
- Each task must build upon the previous one with the appropriate modifications.
- Code comments are encouraged and will be evaluated.
- Code optimization will be evaluated.
- The program must compile and run without errors.
- The solution must be implemented using the Java programming language.
- You must apply the features covered during the course.
- The program must take into account that users may not always provide valid input.
- Submit the assignment in Microsoft Teams, as a zipped folder named: `PE_StudentName`.

---

## Getting Started

After completing your Software Developer course, you were contacted by the renowned film review company IMDV©.  
This company reviews films so users can browse their platform and discover the best and worst films of all time.  
You are required to develop a program that can analyze, search, and manage their movie review business.  
This company stores all reviews and films in a CSV file with the following header fields:

- `idFilme`: Unique film identifier
- `tituloFilme`: Movie title
- `rating`: Rating assigned (0 - 10)
- `duracao`: Duration in minutes
- `ano`: Year of release
- `estudio`: Studio that produced the film
- `realizador`: Director
- `genero`: Genre (e.g., Action, Sci-fi, Fantasy, etc.)


In addition, login credentials for the administrative part of the program are stored in a separate CSV file with the following header fields:

- `Username`: login name
- `Password`: access password for the user

At the start of the program, the user must specify the type of user (ADMIN or CLIENT).
- The **ADMIN** can add new ratings, view statistics, etc.
- The **CLIENT** can register, browse, and search for movies.

If ADMIN is selected, access must be validated through the login credentials file.  
You must create two menus allowing users to select the actions they want based on their user type.  
Menu options must follow the pattern: exercise number followed by its description.  
(Use functions/methods whenever appropriate—this will be valued.)

Once an option is selected, the menu must repeat until the user selects the exit option.

---

### ADMIN MENU

1. **View Files**: Display the content of the Ratings file in the console.
2. **Total Ratings**: Print the total number of ratings assigned.
3. **Print All Studios**: Print a list of all studios that have been reviewed (no duplicates).

---

### CLIENT MENU

1. **New Registration**: Simulate registering a new platform user (using variables and Scanner).  
   Ask the user for their information (username, contact, email) and then display a success message:


2. **Print Catalog**: Print all reviewed movies (no duplicates), along with their ratings.
3. **Print Graphic Catalogs**: Choose a movie from the list of graphically designed titles (Harry Potter, Interstellar, Lord of The Rings, Star Wars), then display the content of the corresponding file.
4. **Print Best Studio**: Show the studio with the highest average rating.
5. **Print Worst Studio**: Show the studio with the lowest average rating.
6. **Print Most Recent Review**: Display the most recently added review.
7. **Develop a Quiz**: Create a quiz based on the provided file. All questions must appear, and the user must select an answer for each. At the end, display the score.
8. **Print Studio Catalog**: Given a studio name, print all genres and corresponding films. (Preferably with visual formatting.)
9. **Print Genre Catalog**: Given a genre, print all studios and their corresponding films. (Preferably with the same visual formatting as the previous point.)

---

When the user (ADMIN or CLIENT) exits the program, a Copyright
file must be printed to the console. You must modify this file to assign the credits to yourself.  
Feel free to choose another ASCII border style.  
(Example site for ASCII Borders: [https://www.asciiart.eu/art-and-design/borders](https://www.asciiart.eu/art-and-design/borders))

---

**Project developed for the subject Structured Programming as part of the Software Developer program at CESAE.**

**Mentor: Vitor Santos**



