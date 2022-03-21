# Platzi App Clone For Android 👾👾👾

Hi Stranger! this is the plazi clon app, i create this proyect based on the oficial app of Platzi and i try to recreate it for myself 

## The app contains

- DI with Dagger Hilt
- Clean Architecture
- MVVM
- Testing with Mockk
- Data binding 
- Navigation
- Live Data
- Connection with firebase to get the data through APIs

## The Creation Process

I began this app from scratch and i first take some screenshots of the official app and begin to analyze the components from each layout that i was going create

![WhatsApp Image 2022-03-20 at 9 27 57 PM](https://user-images.githubusercontent.com/41975283/159197963-eb8d292b-ea61-45d1-856d-e0cdaed7d14a.jpeg)

After that i began to think what design pattern i was going to use, i was chosen the MVVM because is the recommended design pattern by google and it gives me the possibility to reutilize code and use coroutines in a more comfortable way.

For the dependency injection i choose Dagger Hilt because i'm more familiar with it than with koin.

The most funny part of creating this project was use the firebase real time database because i'm familiar with consume APIs but i don't create the APIs often. For this project i was populate the data in the firebase database and get the json that the app will consume. The app gets the information of the Achievements,Lessons,Paths and podcasts from here

![image](https://user-images.githubusercontent.com/41975283/159198703-2ccc9242-fddc-4983-b9d4-da9a093e1054.png)

And the Json looks like this:

![image](https://user-images.githubusercontent.com/41975283/159198821-d9a3e4e9-12d0-4848-96a1-25f426e0f5dd.png)

To manage the video in the app i use the [Oficial Youtube Player API](https://developers.google.com/youtube/android/player?hl=es) and for the podcast section i use the default media player of android, in the beggining i was getting the podcasts from firebase but i reach the quota and i was have to use a local files.


## Images

<p float="left">
  <img src="https://user-images.githubusercontent.com/41975283/159196230-77cc034d-4c52-4230-9aae-10e0e4335196.png" width="220" height="500" />
  <img src="https://user-images.githubusercontent.com/41975283/159196242-96205a8f-6d96-436f-b5fb-5c47cd2d33cc.png"  width="220" height="500" />
  <img src="https://user-images.githubusercontent.com/41975283/159196413-ba8d8ec2-9cee-4e3c-8c0c-4c89a17b5216.png" width="220" height="500" />
 </p>
 
 
 <p float="left">
  <img src="https://user-images.githubusercontent.com/41975283/159196464-d3aa59b1-61fe-4362-ad77-9f6e653c608f.jpeg" width="220" height="500" />
  <img src="https://user-images.githubusercontent.com/41975283/159196466-4bc2bea3-c54e-49a9-a416-ee05b8d4f7c5.jpeg"  width="220" height="500" />
  <img src="https://user-images.githubusercontent.com/41975283/159196467-19db2e0d-4858-43e2-b0ed-dc0ed85a4c26.jpeg" width="220" height="500" />
 </p>
