# CompSciFinalProjectLife
# Text Adventure Life

TODO:

    Story Class:
        [] Add Random Events Based on age range (Getting Robbed, Getting Promotion, Getting Fired, House Burning Down, Ect.)
            -We need to have the random evens be based on your age range, and if you have a job or not
        [x] Add Job System/Allowance
            -You will have an allowance till you are 16, then you must get a job
        [] Add College Option, need to impliment college methos/class that will have an effect on money and happiness and stuff
        [] Add DEBUG Options (So we can go in and test that it all works)
        [] Add Options for year start (needs more detail, please put your ideas below)
            Ideas- 
        [/] Health Degredations and Repair (Add hospital option when health is low) 
                Hospital option finish
        [] Add more option in the job class
        [] Put choices back in investment method, recently redon and need to be finished
        [] Redo random chances to be based on age
        [X] make job interviews not a 100% chance
        [] make a "house option" with taking away a rent from the balance/income each month;
        [] Comment on all the methods and class declaring what everything does.



Old yearStart:
// Year Start Function
    public void yearStart() {

        // Makes new Scanner Class
        Scanner Answers = new Scanner(System.in);

        // Prints out needed info
        System.out.println("Your age is " + age);
        System.out.println("Your age group is " + ageGroup);
        System.out.println("Your health is " + p.getHealth());
        System.out.println("Your Balance is " + p.getBal());

        // Investment Choice
        if (age >= 16) {
            int chance = (int) Math.random() * 100;
            System.out.println("You have the opportunity to invest your money with a " + chance
                    + "% chance of success, do you want to invest? Type \'1\' for yes, and \'0\' for no: ");
            String answer = Answers.next();
            if (answer.equals("1")) {
                System.out.println(
                        "How much would you like to invest, you have $" + p.getBal() + " in your bank account");
                int amt = Answers.nextInt();

                p.removeMoney(amt);
                invest(amt, chance);

            }
        }
        if (age >= 18) {
            System.out.println("Would you like to go to the club? \'1\' for yes, and \'0\' for no: ");
            String club = Answers.next();
            if (club.equals("1")) {
                System.out.println("You went to the club with your friends and drank " + Run.inBetween(1, 20)
                        + " bottles of beer and threw up in the bathroom.");
            }
        }

        // Suicide Option
        if (p.getHappiness() <= 20) {
            System.out.println(
                    "You are reaching a state of depression. Would you like to kill yourself? \'1\' for yes, and \'0\' for no: ");
            String suicide = Answers.next();
            if (suicide.equals("1")) {
                int suicideOption = (int) Run.inBetween(0, 4);
                if (suicideOption == 1) {
                    System.out.println(
                            "You couldn\'t take the pain anymore. You have decided to go outside and walk into oncoming traffic and get hit by a double-decker bus. You were sent to the hospital but didn\'t survive.");
                } else if (suicideOption == 2) {
                    System.out.println(
                            "You have decided to take the easy way out. You go to a local Walmart store and buy 10 feet of rope. You come back home and tie a noose on your ceiling fan. You kick off the chair you stand on and then suddenly everything goes black.");
                } else if (suicideOption == 3) {
                    System.out.println(
                            "You have made the choice to take the easy way out. You go to your kitchen and grab a chef knife from the drawer. You walk to your bathroom and sit in the tub. Tears fill your eyes as you do the deed of slitting your wrists until you are no more.");
                }
            }
        }

        // Applying for a job
        if (age >= 16 && !career.hasJob()) {
            System.out.println("Would you like to apply for a job? \'1\' for yes, and \'0\' for no: ");
            int apply = Answers.nextInt();
            if (apply == 1) {
                career.jobOptions();
            }
        }

        // Once an adult it will ask you if you want to go to college untill you say yes
        // Todo Give price amount option
        if (age >= 18 && p.getCollege() == false) {

            System.out.println("Do you want to go to college? Type \'1\' for yes, and \'0\' for no: ");
            String school = Answers.next();
            if (school.equals("1")) {
                p.wentToCollege(0.0);
            }
        }

        // Closes the scanner class
        Answers.close();
    }
