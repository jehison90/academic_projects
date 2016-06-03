/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.awt.Color;
import java.util.Random;

/**
 *
 * @author estudiantes
 */
public class Bolita implements Runnable{
    private int posX;
    private int posY;
    private int diametro;
    private Color color;
    private int limiteDerecho;
    private int limiteInferior;
    private int incrementoX;
    private int incrementoY;
    private boolean moviendose;
    private boolean pausado;
    
    private Thread hiloMovimiento;

    public Bolita() {
        posX = 0;
        posY = 0;
        incrementoX = 1;
        incrementoY = 1;
        limiteDerecho = 200;
        limiteInferior = 200;
        
        Random randomGenerator = new Random();
        int red = randomGenerator.nextInt(256);
        int green = randomGenerator.nextInt(256);
        int blue = randomGenerator.nextInt(256);
        color = new Color(red, green, blue);
        diametro = 15;
        moviendose = true;
        pausado = false;
    }

    public boolean isPausado() {
        return pausado;
    }

    public void setPausado(boolean pausado) {
        this.pausado = pausado;
    }
        
    public void mover(){
        if(pausado){
            return;
        }
        
        if(posX >= (limiteDerecho-diametro)){
            incrementoX = -1;
        }        
        if(posX < 0){
            incrementoX = 1;
        }
        
        if(posY >= (limiteInferior-diametro)){
            incrementoY = -1;
        }        
        if(posY < 0){
            incrementoY = 1;
        }
        
        posX += incrementoX;
        posY += incrementoY;
    }

    @Override
    public void run() {
        while(moviendose){
            mover();
            esperar();
        }
    }

    private void esperar() {
        try {
            Thread.sleep(60);
        } catch (InterruptedException ex) {
        }
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getDiametro() {
        return diametro;
    }

    public void setDiametro(int diametro) {
        this.diametro = diametro;
    }

    public int getLimiteDerecho() {
        return limiteDerecho;
    }

    public void setLimiteDerecho(int limiteDerecho) {
        this.limiteDerecho = limiteDerecho;
    }

    public int getLimiteInferior() {
        return limiteInferior;
    }

    public void setLimiteInferior(int limiteInferior) {
        this.limiteInferior = limiteInferior;
    }

    public int getIncrementoX() {
        return incrementoX;
    }

    public void setIncrementoX(int incrementoX) {
        this.incrementoX = incrementoX;
    }

    public int getIncrementoY() {
        return incrementoY;
    }

    public void setIncrementoY(int incrementoY) {
        this.incrementoY = incrementoY;
    }

    public boolean isMoviendose() {
        return moviendose;
    }

    public void setMoviendose(boolean moviendose) {
        this.moviendose = moviendose;
    }
    
    public void iniciarMovimiento(){
        hiloMovimiento = new Thread(this);
        moviendose = true;
        hiloMovimiento.start();
    }

    public Color getColor() {
        return color;
    }

    
    
}
