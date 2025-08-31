# Student Ranking App – Beta Group of UBIT

🎓 **Student Ranking and Seat Number Lookup Web Application**

---

## Table of Contents

* [Project Overview](#project-overview)
* [Features](#features)
* [Demo](#demo)
* [CSV Example](#csv-example)
* [Technologies Used](#technologies-used)
* [Installation & Running](#installation--running)
* [Acknowledgment](#acknowledgment)
* [License](#license)

---

## Project Overview

This project is a **Student Ranking and Seat Number Lookup Web Application** developed by **Beta Group of UBIT**.

The app allows users to:

1. Search for a student by their **Seat Number**.
2. Display the **student details** including **Name, Marks, and Rank**.

It is designed to provide a **clean, responsive, and user-friendly interface**, perfect for viewing results on both desktop and mobile devices.

The project was created as part of the **Object-Oriented Programming (OOP) course** under **Dr. Humaira Tariq**, Department of Computer Science, UBIT.

---

## Features

* Search students by Seat Number
* Automatically assigns **Rank** based on CSV order
* Responsive UI for desktop and mobile
* Mobile-friendly cards to display student results
* No need to display all students—privacy-focused
* Clean and modern design

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
B24110006143: Syed Muhammad Ashad Matlub
B24110006131: Sheikh Anas Rashid
B24110006146: Syed Muhib Farooq
B24110006051: Hasnian Saboor
B24110006019: Ali Shaikh
```

**Notes:**

* First two lines are skipped automatically.
* Rank is calculated from 1 onwards based on CSV order.
* Only the **search result** is displayed in the UI.

---

## Technologies Used

* **Backend:** Java, Spring Boot (REST APIs & MVC)
* **Frontend:** HTML, CSS, Thymeleaf
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

---

## Usage

1. Enter the **Seat Number** in the input field.
2. Click **Search**.
3. Student details including **Name, Marks, and Rank** will appear in a card below.

---

## Acknowledgment

Special thanks to **Dr. Humaira Tariq**, OOP course instructor, for guidance and support.
This project was developed by **Beta Group of UBIT**.

---

## License

This project is **open-source** for educational purposes.
