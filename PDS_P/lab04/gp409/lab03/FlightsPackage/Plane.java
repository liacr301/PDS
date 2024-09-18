package lab04.gp409.lab03.FlightsPackage;

import java.lang.Character;
import java.text.ParseException;
import java.util.Arrays;

public class Plane {
    private int[][] touristsLayout;
    private int[][] executiveLayout;
    private int freeRowsT, freeRowsE;
    private int freeSeatsT, freeSeatsE;

    Plane(String dimensionsT, String dimensionsE) throws ParseException {
        String[] dimensionsTArray = dimensionsT.split("x");
        String[] dimensionsEArray = dimensionsE.split("x");
        if (dimensionsTArray.length != 2 || dimensionsEArray.length != 2) {
            throw new ParseException("Dimensoes invalidas!", 0);
        }
        int rowsT = Integer.parseInt(dimensionsTArray[0]);
        int columnsT = Integer.parseInt(dimensionsTArray[1]);
        int rowsE = Integer.parseInt(dimensionsEArray[0]);
        int columnsE = Integer.parseInt(dimensionsEArray[1]);
        touristsLayout = new int[rowsT][columnsT];
        executiveLayout = new int[rowsE][columnsE];
        freeRowsT = rowsT;
        freeRowsE = rowsE;
        freeSeatsT = rowsT * columnsT;
        freeSeatsE = rowsE * columnsE;
    }

    public int getFreeSeatsT() {
        return freeSeatsT;
    }

    public int getFreeSeatsE() {
        return freeSeatsE;
    }

    public int[][] getClassSeats(ClassType seatType) {
        switch (seatType) {
            case E -> {
                return this.executiveLayout;
            }
            default -> {
                return this.touristsLayout;
            }
        }
    }

    public boolean hasExecutiveSeats() {
        return this.executiveLayout.length != 0;
    }

    public Character seatPositionToLetter(int seatPositionInRow, ClassType seatType) {
        assert(seatPositionInRow >= 0 && seatPositionInRow < getClassSeats(seatType)[0].length);
        return (char) (seatPositionInRow + 65);
    }

    public int letterToSeatPosition(Character seat) {
        return (int) seat - 65;
    }

    public boolean canHoldReservation(ClassType type, int numberPassengers) {
        if (type == ClassType.E) {
            return numberPassengers <= freeSeatsE;
        } else {
            return numberPassengers <= freeSeatsT;
        }
    }

    public boolean hasFreeRows(ClassType type, int numberPassengers) {
        if (type == ClassType.E) {
            return  freeRowsE>0;
        } else {
            return  freeRowsT>0;
        }
    }

    public boolean hasFreeSeats(ClassType type, int numberPassengers) {
        if (type == ClassType.E) {
            return numberPassengers <= freeSeatsE;
        } else {
            return numberPassengers <= freeSeatsT;
        }
    }


    public void decrementFreeSeats(ClassType type) {
        if (type == ClassType.E) {
            freeSeatsE --;
        } else {
            freeSeatsT --;
        }
    }

    public void decrementFreeRows(ClassType type) {
        if (type == ClassType.E) {
            freeRowsE --;
        } else {
            freeRowsT --;
        }
    }

    public boolean setReservationSeats(ClassType type, int numberPassengers, Reservation rsv) {
        if (!canHoldReservation(type, numberPassengers)) {
            Reservation.reservationNum--;
            return false;
        }
        int[][] seatsSet = this.getClassSeats(type);
        while(numberPassengers>0 && hasFreeSeats(type, numberPassengers)){
            for (int i = 0; i < seatsSet.length; i++) {
                    if(hasFreeRows(type, numberPassengers))
                    {
                        if(Arrays.stream(seatsSet[i]).sum()!=0)
                            continue;
                        else
                            decrementFreeRows(type);
                    }
                    for (int j = 0; j < seatsSet[i].length; j++) {
                        if(seatsSet[i][j]==0 && numberPassengers>0){
                            rsv.addSeat(seatPositionToLetter(j, type), i);
                            seatsSet[i][j]=rsv.getReservationId();
                            decrementFreeSeats(type);
                            numberPassengers--;
                        }
                    }
            }
        }
        if(numberPassengers==0)
            return true;
        else
            Reservation.reservationNum--;
            return false;
    }
    public String getReservationMap(){
        StringBuilder sb = new StringBuilder();
        int allRows = touristsLayout.length + executiveLayout.length;
        int maxSeats = Math.max(touristsLayout[0].length, hasExecutiveSeats() ? executiveLayout[0].length : 0);
        sb.append("   ");
        for (int i = 0; i < allRows; i++) {
           sb.append(String.format("%0" + "2d  ", i+1));
        }
        sb.append("\n");

        for (int i = 0; i< maxSeats ; i++)
        {
            sb.append((char)(i+65)+"  ");
            if(hasExecutiveSeats())
            {
                for (int j = 0; j < executiveLayout.length; j++) {
                    if(i < executiveLayout[j].length){
                            sb.append(String.format("%-2d",executiveLayout[j][i]));
                            sb.append("  ");
                    }
                    else{
                        //spaces to align the rows if the executive layout has fewer seats than the tourist layout
                        sb.append("    ");
                    }
                }
            }

            for (int j = 0; j < touristsLayout.length; j++) {
                if(i < touristsLayout[j].length){
                    sb.append(String.format("%-2d",touristsLayout[j][i]));
                    sb.append("  ");
                }
                else{
                    sb.append("   ");
                }
            }

            sb.append("\n");
        }

        return sb.toString();
    }
    public boolean removeReservationSeats(int row, Character seat, ClassType type) {
        if (type == ClassType.E) {
            freeSeatsE ++;
        } else {
            freeSeatsT ++;
        }
        if (type == ClassType.E) {
            freeRowsE ++;
        } else {
            freeRowsT ++;
        }
        try {
            int[][] seatsSet = this.getClassSeats(type);
            int col = letterToSeatPosition(seat);
            seatsSet[row][col] = 0;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }
}