
# 💼 Job Search Automation Framework

This project is a **Java Selenium automation framework** that scrapes **job details** from a job listing website based on a **user-specified keyword**, and writes the extracted data into an **Excel file** using the Apache POI library. 

Project is integrated with Jenkins, such that whenever a push is made to GitHub, the jenkins job runs and sends an Email to the Recipients with the Excel file attached to it.



---

## 📌 Features

* ✅ Built using **Selenium WebDriver**
* ✅ Implements **Page Object Model (POM)** for modular and maintainable code
* ✅ Searches job listings based on a **given keyword**
* ✅ Navigates through **multiple browser tabs**
* ✅ Extracts job-related details like:

  * ✅ Company Name
  * ✅ Email
  * ✅ Closing Date 
* ✅ Writes the extracted data into an **Excel (.xlsx)** file
* ✅ Uses **Apache POI** for Excel file handling
