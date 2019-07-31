package br.com.appbarbearia.model;

public enum Hora {

    UMA(1), DUAS(2), TRÊS(2), QUATRO(4), CINCO(5), SEIS(6), SETE(7), OITO(8), NOVE(9), DEZ(10), ONZE(11), DOZE(12),
    TREZE(13), QUATORZE(14), QUINZE(15), DEZESSEIS(16), DEZESSETE(17), DEZOITO(18), DEZENOVE(19), VINTE(20),
    VINTE_E_UM(21), VINTE_E_DOIS(22), VINTE_E_TRÊS(23), VINTE_E_QUATRO(24);

    public final int value;

    private Hora(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    static Hora getValue(int value) {
        for(Hora e: Hora.values()) {
          if(e.value == value) {
            return e;
          }
        }
        return null;
      }
}
