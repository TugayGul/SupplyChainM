# SupplyChainManagement

## Summary

  JavaServer page(jsp) web application with connected database, proper driver and rest api.

### Motivation and Process
  I never used Spring Boot or jakarta or java to write a web app before I start. My previous knowledge was limited to general backend structures comes from Django and DRF. However, I saw this task/challenge as a learning oppurtunity. That's why I tried to do it.
  
  I spent 4-6 hours per day for 5 days overall. Most of the time I focused on reading docs, understanding Spring Boot 3. I think the documentation is prepared poorly and it is not helpful if you don't know the Spring Boot. However, once you see the structure it is quite easy to write your application based on your needs. Addition to this, versioning and recent updates that Spring Boot got (Spring Boot 3 and especially Spring-security) made the process even complicated. As a junior, when changing main components of the framework, docs should be updated regarding those changes. While searching stackoverflow I saw many experienced developers faced this issue for last few months. 
  
  I tried to achieve one goal of each different type of tasks in the project. What I mean is that, it was important for me to avoid using tool like lombok or hibernate. I wanted to write whole of it with least dependency but I realized object relational mapping (orm) makes things much more easier. So, I stopped my first project which I already wrote some of plain sql queries. I stopped working on that repository in case I can continue it for some later time. I also didn't merge any of my testing branches but I poorly named them. The reason behind is that I wanted to keep every change and commits to able to see my previous mistakes if I could satisfy whole requirements. At the current stage I just merged my last work to main branch.

[previous attempt](https://github.com/sondertg/SupplyChainManagement)


### Project Summary

  Develop a supply-chain management system.

### Requirements and Results

![firefox_IKMqVgnrtw](https://user-images.githubusercontent.com/51514616/213921843-f0e4c4f2-b77d-4890-8b7a-4f25ecaf0ef8.png)
![firefox_SpsC8EJOii](https://user-images.githubusercontent.com/51514616/213924957-9667a910-0d8e-499a-8287-77b3262a5123.png)


- Created the model properly and connected to DB, db test written.

- Created Rest Api endpoints, tested them without authentication by using Postman, all were working. Added the collection.

- Skipped adding image table to product table. This is because I already included one to many relationship between product and invoices. Adding images to products has same relationship. I could create another table with image paths and image id as a primary key and product id as a foreign key to the product table.

- I also couldn't complete frontend with full functionality but I created home, login and register pages that cover basic requirements of the project. I also wrote related api endpoints that satisfy all requirements but each of them require to be connected to html actions/buttons and pages. Still, since I was able to connect one endpoint to the front, this was enough for me. 

- One main problem which I am still not sure if I solved is authentication. Given password while building the aplication and `user` as username, I can reach all endpoints by using basic auth. However, I couldnt deactivate default authentication of Spring-security. Probably, there was a some sort of configuration command should be added to `application.properties` but I didn't spent enough time to solve it. I just wrote `CustomUserDetailsService` to create two diferent roles based on the information saved in user table in `is_retailer` column. If i would figure out how to create the layer between api endpoints and frontend I think I could easily solve this.

- And lastly, I couldn't secure the application. JWT or OAuth 2 is better but since I was trying to learn, I thought I should start with basic auth. My customlogin page is working fine. I can login by using credentials recored in user table. However, I couldn't replace default authentication roles and filterchain with mine. 

- Following the methodology that one goal from each different type of task, I tried to wrote user integration test and unit test. Both seems are fine but I am not sure how to include user repository to the test. Probably might require writing queries or using methods of hibernate.

## TODOs/Further Plans
- I left a lot of TODO comments if I continue this in later time. Also, some methods I implemented are redundant but I didn't remova them to see whole development process and my mistakes at the end.

- I planned to dockerizing it and using a jenkins or nginx or even maybe a cloud service from aws but these are also postponed.

