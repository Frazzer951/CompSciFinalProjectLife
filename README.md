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



        // Once an adult it will ask you if you want to go to college untill you say yes
        // Todo Give price amount option
        if (age >= 18 && p.getCollege() == false) {

            System.out.println("Do you want to go to college? Type \'1\' for yes, and \'0\' for no: ");
            String school = Answers.next();
            if (school.equals("1")) {
                p.wentToCollege(0.0);
            }
        }

    }
