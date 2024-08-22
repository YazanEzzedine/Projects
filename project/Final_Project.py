from fitness_util import meal_plan,bmi,average_steps,goals,calBurn #import each function from the util file
print('*********** Fitness Application  ***********') 
print("Make sure your choice is in CAPITAL LETTERS!")
print("Available Options:")
#decided to make the menu in the main and used if statements to call each method function.
#each statement prompts the user if they would like to try another option, and after typing yes they will. If they type no, they exit the program.
choice=(input("\n.[B] BMI calculator\n.[M] Make a meal plan\n.[AVG] Calculate your average steps\n.[G] Put in your fitness goals\n.[CAL] Calculate calories burned\n.[E] To exit the application "))
while choice!='E':
    if choice=="B":
        bmi()
        choice2=input("Would you like to open the menu and choose another option?: ")
    elif choice=="M":
      meal_plan()
      choice2=input("Would you like to open the menu and choose another option?: ")
    elif choice=="AVG":
      average_steps()
      choice2=input("Would you like to open the menu and choose another option?: ")
    elif choice=="G":
      goals()
      choice2=input("Would you like to open the menu and choose another option?: ")
    elif choice=="CAL":
      calBurn()
      choice2=input("Would you like to open the menu and choose another option?: ")
    if choice2==("yes"):
      choice=(input("Available Options:\n.[B] BMI calculator\n.[M] Make a meal plan\n.[AVG] Calculate your average steps\n.[G] Put in your fitness goals\n.[CAL] Calculate calories burned\n.[E] To exit the application "))
    else:
      break
print("You've exited the program, thanks for using the fitness app!")