class Coach{

    int coachNumber;
    int passengers;
    Coach next;
    Coach prev;

    Coach(int coachNumber, int passengers) {
        this.coachNumber = coachNumber;
        this.passengers = passengers;
        this.next = null;
        this.prev = null;
    }

    // 1. 

    public void addCoachAtEnd(int coachNumber, int passengers) {

        Coach newCoach = new Coach(coachNumber, passengers);

        Coach current = this;
        
        while (current.next != null) {
            current = current.next;
        }
        
        current.next = newCoach;
        newCoach.prev = current;
    }

    // 2. 

    public Coach removeCoachByNumber(int coachNumber) {

        Coach current = this;
        
        if (current.coachNumber == coachNumber) {
            if (current.next != null) {
                current.next.prev = null;
            }
            return current.next; 
        }
        
        while (current != null) {
            if (current.coachNumber == coachNumber) {

                if (current.prev != null) {
                    current.prev.next = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                }
                break;
            }
            current = current.next;
        }
        
        return this; 
    }

    // 3. 

    public void displayBackward() {
        Coach current = this;
        
        while (current.next != null) {
            current = current.next;
        }
        
        System.out.println("Displaying all coaches backward:");
        while (current != null) {
            System.out.println("Coach: " + current.coachNumber + ", Passengers: " + current.passengers);
            current = current.prev;
        }
    }
}