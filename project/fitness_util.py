def bmi():
    #The BMI calculatori is a calculator that takes in your height and weight and returns the BMI by calculating your weight and height by the BMI formula
    print("***********BMI Calculator***********")
    weight=float(input("Enter how much you weigh in pounds: "))
    height=float(input("Enter your height in feet: "))
    #converting the height from feet to inches
    heightFeet=height*12
    #BMI formula
    bmiTotal=(weight*703)/(heightFeet*heightFeet)
    print("Your BMI is: ", "{:0.2f}.".format(bmiTotal))
    return bmiTotal


def meal_plan():
     items = {}
     #reading in the food menu txt file and creating the key for it which is the name of each food item so user can search and validate it
     fp=open('Food_Menu.txt','r')
     char=fp.readlines()
     fp.close()
     for info in char:
            key, calories= info.strip("\n").split(",")
            items[key]=[calories]
     print("***********Meal Plan***********")
     print("Enter 3 items from this dictionary to add to your meal plan, and that will be your meal for the day!")
     totalCalories=0
     #printing each menu item with their associated calorie count using a for loop
     #using if statements to validate the 3 meal choices, and giving them an error if it's not in the dictionary.
     for key in items:
        print(key+ ' - '+items[key][0])
     meal1=input("Enter meal item #1: ")
     if(meal1 in items.keys()):
         search=True
         print("The item: "+meal1+" was added to your menu!")
     else:
         print("The item wasn't found!")  
         meal1="Not on Menu!"  
     meal2=input("Enter meal item #2: ")
     if(meal2 in items.keys()):
         search=True
         print("The item: "+meal2+" was added to your menu!")
     else:
         print("The item wasn't found!")     
         meal2="Not on Menu!"  
     meal3=input("Enter meal item #3: ")
     if(meal3 in items.keys()):
         search=True
         print("The item: "+meal2+" was added to your menu!")
     else:
         print("The item wasn't found!")   
         meal3="Not on Menu!"   
    #final output for the meal plan function which shows the 3 meals chosen, and if it's not on the menu it will prompt that it is not on the menu.
     print("Your chosen meal plan is: \n*",meal1,"\n*",meal2,"\n*",meal3)   
     return items


def average_steps():
    #start of the average steps calculator
    print("***********Average Steps***********")
    print("Over the course of 5 days, please enter the amount of steps you've had for each day.")
    counter=0
    #created a counter in order to highlight which days you're entering steps for
    sum=0
    for x in range(5):
        counter+=1
        print("day:", counter)
        steps=int(input("Enter the steps for this day: "))
        sum= steps+sum
    #average is found by dividing the sum by the total of days walked
    average=sum/5
    print("Your average amount of steps over the span of 5 days is: ",average)


def goals():
    print("***********Fitness Goals***********")
    fitness_goal=(input("Please enter your fitness goal(Gaining muscle, losing weight, getting leaner): "))
    weight1=float(input("Please enter your current weight in lb's: "))
    weight2=float(input("Please enter your target weight in lb's: "))
    #used two if statements to see whether the user was aiming to gain weight, or lose weight, with two different printable outcomes depending on what ther user enters.
    if (weight1<weight2):
        targetWeight=weight2-weight1
        print("***********Fitness Goals***********")
        print("\n* Your current fitness goal is to: ",fitness_goal,"\n* With a current weight of: ",weight1,"\n* A target weight of: ",weight2,"\n* In order to reach your target weight, you will have to gain: ",targetWeight,"lb's")
    elif(weight1>weight2):
        targetWeight=weight1-weight2
        print("***********Fitness Goals***********")
        print("Your current fitness goal is to: ",fitness_goal,"\n* With a current weight of: ",weight1,"\n* A target weight of: ",weight2,"\n* In order to reach your target weight, you will have to lose: ",targetWeight,"lb's")


def calBurn():
     print("***********Calorie Burn Calculator***********")
     weight=float(input("Please enter your current weight in lb's: "))
     workout=input("Please enter your workout, choose from either biking, yoga, or running: ")
     timeSpent=int(input("Please enter your time spent doing the workout in minutes: "))
     #took in the weight, and either biking, yoga, or running in order to calculate the amount of calories burnt
     #Each workout burns a different amount of calories so I used if statements to seperate them and each has their own formula.
     if workout==("yoga"):
         kg=weight*0.45359237
         yogaCaloriesPerMin=(2.5*kg*3.5)/200 
         yogaCaloriesTotal=yogaCaloriesPerMin*timeSpent
         print("***********Calorie Burn Calculator: Yoga***********")
         print("* You burn: ","{:0.2f}.".format(yogaCaloriesPerMin)," Per minute\n*","You burned: ","{:0.2f}.".format(yogaCaloriesTotal)," total.")
     elif workout==("running"):
         kg=weight*0.45359237
         runningCaloriesPerMin=(11*kg*3.5)/200 
         runningCaloriesTotal=runningCaloriesPerMin*timeSpent
         print("***********Calorie Burn Calculator: Running***********")
         print("* You burn: ","{:0.2f}.".format(runningCaloriesPerMin)," Per minute\n*","You burned: ","{:0.2f}.".format(runningCaloriesTotal)," total.")
     elif workout==("biking"):
         kg=weight*0.45359237
         bikingCaloriesPerMin=(4.5*kg*3.5)/200 
         bikingCaloriesTotal=bikingCaloriesPerMin*timeSpent
         print("***********Calorie Burn Calculator: Biking***********")
         print("* You burn: ","{:0.2f}.".format(bikingCaloriesPerMin)," Per minute\n*","You burned: ","{:0.2f}.".format(bikingCaloriesTotal)," total.")
        #else statement for if the user types in none of the choices.
     else:
         print("Try again while entering either: biking, yoga, or running")


