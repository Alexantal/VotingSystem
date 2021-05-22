# Voting System

The purpose of this application is to assist a group of people 
(for instance, colleagues working in one company) in deciding on 
the restaurant they would like to go for lunch together. 
The decision on the restaurant is made by vote in the application.

There are two types of users: the admin and regular users.
All users can see list of available restaurants as well as their menu.
After reviewing the said information each user votes for the restaurant,
the user would like to go.

Each user can choose only one restaurant per day. He/she can
change his/her choice before 11:00 a.m. After 11:00 a.m. no change is possible.

The admin users can change the list of restaurants as well as their 
menu every day. They can correct the list by creating/editing or making 
enabled/disabled restaurants. They can also correct menu of each restaurant 
by creating/editing/deleting dishes. The admin users can also vote in 
the similar way as regular users.

At this stage an admin is not capable to create/edit/delete users in the application. 
The regular and admin users are pre-added in an application database.

To start using the application you need:
1. Save project from GitHub in the path: C:/Projects/VotingSystem;
2. Run Tomcat Server with url http://localhost:8080/votingsystem/ and with
   Deployment#Application context: /votingsystem;
3. Launch your web browser in url http://localhost:8080/votingsystem/;
4. Login as admin or user.

Admin email: admin@gmail.com | password: admin

User email: user@yandex.ru | password: password
