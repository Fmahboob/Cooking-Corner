# **Cooking Corner**

### Introduction
In this app Customer can find food recipes. This also has a shopping list. They can find cooking tips also. Customer can change font size and layout View.

### Description
*	In home fragment it has all about the app, app logo and name of our app.
*	In Recycler View all recipes from API key will come and show recipe name , recipe image, recipe category and the instructions of the recipe.
*	There will be shopping Fragment which have Shopping list from database. It has Item names, Item prices and Quantities. Shopping list can be CRUD.
*	In Shopping Fragment, we have 2 more buttons that can delete, and update our shopping list also fab button will add the the list. 
*	The fab button on shopping list Fragment can show grocery stores near me location.
*	In settings menu we have font size and Layout.
*	We have a credit page.
*	We will use timer intent, web intent, and map intent.
*	In recipe fragment we have fab button to go for web intent.
*	In shopping list wee have a button to go for map intent.



### Authors

| 		Name          |     Account |      Email         |
| ----------------  | ------------| ------------------ |
| Farina Mahhboob   | Fmahboob    | W0766260@myscc.ca
| Komathy Mugunthan | KomathyTS   | W0759301@myscc.ca


     Home Screen
 
![image](https://user-images.githubusercontent.com/91429784/156242035-9fe52012-185f-4bcd-85ea-a07960518bf1.png)

     Settings Menu

![image](https://user-images.githubusercontent.com/91429784/156242092-e25237e8-4b99-47e7-b1b1-38f3de3c3c75.png)


    Recycler View       
    
![image](https://user-images.githubusercontent.com/91429784/156243117-7c1f27d1-dd0c-4fc6-9ad9-ef11d5567791.png)

    Recipe Fragment
    
![image](https://user-images.githubusercontent.com/91429784/156243270-655f0221-9e85-4c24-9e18-b3dfd5d1ea60.png)

      View Pager 2 - Favourite Recipe

![image](https://user-images.githubusercontent.com/91429784/156243397-477162c5-10d2-47fd-8458-edc46373f848.png)

      Shopping List
![image](https://user-images.githubusercontent.com/91429784/156243458-61bc5e11-db01-493c-82ab-f44316137b26.png)



Screen shots of the Application

![Screenshot 2022-04-20 171302](https://user-images.githubusercontent.com/91429784/164325429-95a825c4-e7da-4821-8519-b797ae975064.png)


![Screenshot 2022-04-20 171427](https://user-images.githubusercontent.com/91429784/164325578-63594387-9d5c-4051-a101-da70b4d95c7b.png)


![image](https://user-images.githubusercontent.com/91429784/164325659-d6d75763-410f-4e82-a2d9-5474ba4c5601.png)


![image](https://user-images.githubusercontent.com/91429784/164325873-2a95049e-daa8-49da-952b-fa3447d6a020.png)

![image](https://user-images.githubusercontent.com/91429784/164325914-478a908c-0c05-4707-9dfa-240bd432bb55.png)

![image](https://user-images.githubusercontent.com/91429784/164325950-b3be2bec-e4c3-4f2c-a8c4-89e6d68de63e.png)

![tabStyle](https://user-images.githubusercontent.com/91558787/164366479-77a4817c-3601-45bb-9499-0e47d8986155.JPG)

### Applied Techniques

* The application is created using navigation drawer activity.
* Recipe is Created using recycler view and taking data from Json through API key.
* Shopping List is in database that can be CRUD.it is in recycler View
* Tips is created by View pager2.
* Can change font and Layout in settings
* Used Animations and transition
### Compatibility


##### Target SDK
* minSDK 21
* maxSDK 31

##### Enable Java 8
*     compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
##### Dependencies
*   implementation 'androidx.preference:preference:1.1.1'
*   implent Volley.
*   Implement Picaso.

##### Permissions
* Permission for android
* Permission for timer.


### Install and build

* Clone the repo
* Open the project in Android Studio
* Build and run


### License

MIT License

Copyright (c) [2021] [Farina Mahboob] [Komathy Mugunthan]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.




