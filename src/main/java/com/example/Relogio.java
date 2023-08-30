package com.example;

public class Relogio {

    private int hora;
    private int minuto;
    private int segundo;

    public Relogio() {
        this.hora = 0;
        this.minuto = 0;
        this.segundo = 0;
    }

    public void setHora(int hora) {
        if (hora < 0 || hora > 23) {
        	
        	this.hora = 0;
        	
            System.out.println ("Hora inválida.");
        }
        
        else {
        this.hora = hora;
        }
    }

    public void setMinuto(int minuto) {
    	
    	this.minuto = 0;
    			
        if (minuto < 0 || minuto > 59) {
        	System.out.println ("Minuto inválido.");
        }
        
        else {
        this.minuto = minuto;
        }
    }

    public void setSegundo(int segundo) {
    	
    	this.segundo = 0;
    	
        if (segundo < 0 || segundo > 59) {
        	System.out.println ("Segundo inválido.");
        }
        else {
        this.segundo = segundo;
        }
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", this.hora, this.minuto, this.segundo);
    }

    public int getHora() {
        return this.hora;
    }

    public int getSegundo() {
        return this.segundo;
    }

    public int getMinuto() {
        return this.minuto;
    }
    
    public void reiniciarMeiaNoite() {
        this.hora = 0;
        this.minuto = 0;
        this.segundo = 0;
    }

    public String marcarIntervalo(int horaInicio, int minutoInicio, int segundoInicio, int horaFim, int minutoFim, int segundoFim) {
        int segundosDecorridos = calcularSegundosDecorridos(horaInicio, minutoInicio, segundoInicio, horaFim, minutoFim, segundoFim);
        int horas = segundosDecorridos / 3600;
        int minutos = (segundosDecorridos % 3600) / 60;
        int segundos = segundosDecorridos % 60;
        return String.format("%02d:%02d:%02d", horas, minutos, segundos);
    }

    private int calcularSegundosDecorridos(int horaInicio, int minutoInicio, int segundoInicio, int horaFim, int minutoFim, int segundoFim) {
        int segundosInicio = horaInicio * 3600 + minutoInicio * 60 + segundoInicio;
        int segundosFim = horaFim * 3600 + minutoFim * 60 + segundoFim;
        return segundosFim - segundosInicio;
    }

    public String imprimeFormato24h() {
        return String.format("%02d:%02d:%02d", this.hora, this.minuto, this.segundo);
    }

    public String imprimeFormatoAMPM() {
        String ampm = this.hora < 12 ? "AM" : "PM";
        int horaFormato12h = this.hora > 12 ? this.hora - 12 : this.hora;
        if (horaFormato12h == 0) {
            horaFormato12h = 12;
        }
        return String.format("%02d:%02d:%02d %s", horaFormato12h, this.minuto, this.segundo, ampm);
    }

    public void atualizaTempo(int hora, int minuto, int segundo) {
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }
}


