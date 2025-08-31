# Student Ranking App – Beta Group of UBIT

🎓 **Student Ranking and Seat Number Lookup Web Application**

---

## Table of Contents


* [Contributors](#Contributors)
* [Project Overview](#project-overview)
* [Demo](#demo)
* [CSV Example](#CSV Example)
* [Technologies Used](#technologies-used)
* [Installation & Running](#installation--running)

---

## Contributors

- **Syed Muhammad Ashad Matlub**
- **Sheikh Anas Rashid** 
- **Syed Muhib Farooq**
- **Hasnian Saboor**
- **Ali Shaikh**
- **Dr. Humera Tariq** – Guidance & Mentorship

---

## Project Overview

This project is a **Student Ranking and Seat Number Lookup Web Application** developed by **Beta Group of UBIT**.

The app allows users to:

1. Search for a student by their **Seat Number**.
2. Display the **student details** including **Name, Marks, and Rank**.

It is designed to provide a **clean, responsive, and user-friendly interface**, perfect for viewing results on both desktop and mobile devices.

The project was created as part of the **Object-Oriented Programming (OOP) course** under **Dr. Humera Tariq**, Department of Computer Science, UBIT.

---


## Demo

You can view the live project here:

[**Student Ranking App – Railway Deployment**](https://rankingapp-production-0997.up.railway.app/)

---

## CSV Example

The application reads data from a **CSV file (`results.csv`)** stored in `src/main/resources/`.

**Sample CSV format**:

```csv
University of Karachi
S.no,Seat no,Name,Marks,Seat no
1,B24110006143,Syed Muhammad Ashad Matlub,19,1
2,B24110006131,Sheikh Anas Rashid,18.5,2
3,B24110006146,Syed Muhib Farooq,18,3
4,B24110006051,Hasnian Saboor,17.5,4
5,B24110006019,Ali Shaikh,17,5
```

---

## Technologies Used

* **Backend:** Java, Spring Boot (REST APIs & MVC)
* **Frontend:** HTML, CSS and javaScript
* **Deployment:** Railway.app (Free Hosting)
* **CSV Processing:** Java `BufferedReader` & `ClassPathResource`

---

## Installation & Running

1. Clone the repository:

```bash
git clone https://github.com/muhib29/Ranking_App.git
cd Ranking_App
```

2. Make sure **Java 21** is installed.

3. Build and run the project:

```bash
./mvnw spring-boot:run
```

4. Open in browser:

```
http://localhost:8080
```
