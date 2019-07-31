package br.com.appbarbearia.model;

public enum Minutos {

    QUINZE_MINUTOS(15), TRINTA_MINUTOS(30), QUARENTA_E_CINCO_MINUTOS(45);

    public final int value;

    private Minutos(int value){
        this.value = value;
    }

    public int getValue() { 
        return value; 
    }

    static Minutos getValue(int value) {
        for(Minutos e: Minutos.values()) {
          if(e.value == value) {
            return e;
          }
        }
        return null;
      }
}