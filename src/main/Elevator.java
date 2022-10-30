package main;

public class Elevator {
    public static int current_floor=5;
    int destination_floor;

    private Elv_States State = new Elv_States();

    public Elevator (int destination_floor)
    {
        this.destination_floor=destination_floor;
        System.out.println("*** Destination floor is: "+ destination_floor);
        arrive_to_floor();
    }

    private void arrive_to_floor() {
        State.Current_State = State.Idle;

        if (current_floor < destination_floor) {
            go_up();
        } else if (current_floor > destination_floor) {
            go_down();
        } else
            exit();
    }

    private void go_up(){
        State.Current_State = State.Moving_up;
        if (current_floor < destination_floor) {
            current_floor++;
            System.out.println("Current floor: " + current_floor);
            go_up();
        } else {
            arrive_to_floor();
        }
    }

    private void go_down() {
        State.Current_State = State.Moving_down;
        if (current_floor > destination_floor) {
            current_floor--;
            System.out.println("Current floor: " + current_floor);
            go_down();
        } else {
            arrive_to_floor();
        }
    }

    private void exit(){
        State.Current_State = State.Idle;
        System.out.println("Arrived at floor: " + current_floor);
    }
}
