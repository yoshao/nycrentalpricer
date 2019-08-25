# nycrentalpricer

## Inspiration##

As a New Yorker myself, looking for a new home is always a daunting experience: the possible over-priced listing price and unfamiliarity in the neighborhood making me uncomfortable to negotiate a better price with the landlord. Even after landing a place, one thing always puzzles me is whether I am overpaying my rent. 
Thus, we are introducing this App that will help renters in the Big Apple to gain confidence in the rental price. People will just need to enter the basic information about the rental unit, and they can visualize how much fair rental fee.

## What it does##
The App uses modern Machine Learning techniques to predict rental price in NYC based on Streeteasy data. User will just need to enter some apartment descriptions such as how many bedrooms or what neighborhood and the App will return the fair rental price for the user.

## How we built it##
1) An Andriod app which takes user input and predicts rental price 2) Backend model using Python to predict rental price using ML. Dataset: https://github.com/purcelba/streeteasy_scrape
 - Data Analysis Model
 - The Data Analytics Model deploys machine learning models to identify key drivers for the moving rental prices in one of the most expensive place in the world - New York City- location, room size, and room type. Based on model results, rental rates are predicted for various property scenarios. …

 - Android App

## Challenges we ran into##
We have ran into multiple challenges which includes:
- 1.	Time Constraint:
- Given we have other commitments in life, we can only convene and kick-off the project during weekends. Since we don’t each other before, we have to quickly align our objectives and start working productively from day 1.
- 2.	Python, Java, Android App integration:
- In this project, we used Python for data analytic and machine learning based model development. However, we face difficulties trying to output the analytical results in the Android app we built via Java. After multiple trials and errors, we have decided to output different combination of possible user choice on the rental information and their associate price in a CSV file. Then use java to read the output CSV file and loop up pricing according to user inputs.
- 3.	Data Scarcity
- Nowadays, lots of online real estate website stops sharing the rental details as a measure to protect their own IP. Therefore, we faces difficulties finding the right training data sets online. We eventually landed on some online data set from reliable data source that we can use to train the model.

## Accomplishments that we're proud of##
This App alleviates the pain associated with rental hunting and equips them with a simple tool that tells them the true worth of their rental units. It helps renters streamline the decision-making process through leveraging our entire rental big data base from multiple different known rental websites.
I am happy that this App can help real renters like me putting rental pain behind me.

## What we learned##
1.	How to conduct Data Analytics Model deploys machine learning models (linear regression and Lasso Regression) to identify key drivers of renting prices in New York City. Building a model is never easy, there so many things we need to consider:
a.	Whether the features we selected contains multicollinearity
b.	Whether the price is normally distributed and is there possible outliers
c.	Whether we the predicted result makes economic sense
2.	How to build an Android App:
a.	Before this project, none of us has imagined we are capable of building an App in 2 days. This forces us to learn quickly the logic of how to build an Android app and what tools we can leverage to do so. In addition, we are able to migrate what we learned about Java at school to this project.
3.	How to work with a team in a timely constraint manner:
a.	We become very productive and product focused. Everyone has contributed tremendously. We learned how to collaborate and assign sub-projects and ensure deliverables.

## What's next for NYC Rental Pricer##
The current App is still in Beta version. We look to add more features such as incorporating the seasonality in the calculation. In addition, we look to add more graphical interaction between and user and App. For example, we look to build a economical calculator letting the renter visualize whether it is more economically rational to rent or to buy properties.
 	 

## Authors
Junjie Qian
Yolanda
Wei Chen

