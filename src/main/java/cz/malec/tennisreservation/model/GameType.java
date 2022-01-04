package cz.malec.tennisreservation.model;

public enum GameType {
    SINGLES(0), DOUBLES(1);
    
    private int num;

    GameType(int num) {
        this.num = num;
    }
        
    public static GameType get(int num) {
        if(num < 0 || num >= GameType.values().length) {
            return null;
        }
        return GameType.values()[num];
    }
    
    public int getValue() {
        return this.num;
    }
}