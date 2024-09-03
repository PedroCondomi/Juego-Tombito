import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import ddf.minim.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class tpfinal extends PApplet {

//Pedrito Condomí



Minim minim;
AudioPlayer  musik1, musik2, musik3, musikini;
AudioSample jumpin, losing, winin;

PImage Nivel1, Nivel2, Nivel3, playerder, playerizq, inicio, pasarlvl2, pasarlvl3, perder, ganar, platcor, platlar;
int salto, back, paso;
boolean caer;
float rectX, rectY, rectmovX, rectmovY, pYfall, fondoX, fondoY;
float plat1X, plat1Y;
float plat2X, plat2Y;
float plat3X, plat3Y;
float plat4X, plat4Y;
float plat1mov, plat2mov, plat3mov, plat4mov;


public void setup () {
  minim = new Minim(this);
  
  back = 1;
  platcor = loadImage ("platcor.gif");
  platlar = loadImage ("platlar.gif");
  playerder = loadImage ("pengder.gif"); //64x30 px
  playerizq = loadImage ("pengizq.gif"); //64x30 px
  inicio = loadImage ("pantalla inicio.gif");
  pasarlvl2 =loadImage ("pantalla nivel 2.gif");
  pasarlvl3 = loadImage ("pantalla nivel 3.gif");
  perder = loadImage ("pantalla perdiste.gif");
  ganar =loadImage ("pantalla ganaste.gif");
  Nivel1 = loadImage ("nivel1200.gif");
  Nivel2 = loadImage ("nivel20.gif");
  Nivel3 = loadImage ("lvl3.gif");
  winin = minim.loadSample ("gane.mp3");
  losing = minim.loadSample ("perdi.mp3");
  jumpin = minim.loadSample ("salte.mp3");
  jumpin.setGain(-5);
  musikini = minim.loadFile ("iniciost.mp3");
  musikini.loop();
  musik3 = minim.loadFile ("musica3.mp3");
  musik2 = minim.loadFile ("musica2.mp3");
  musik1 = minim.loadFile ("musica1.mp3");
  caer = false;
  rectX = 70;
  rectY = 680;
  paso = 0;
  fondoX= 0;
  fondoY = 0;
  rectmovX = 2.3f;
  rectmovY = -10.2f;
  salto = 2;  
  pYfall =0.4f;
  plat1X = 980;
  plat1Y = 310;
  plat2X = 480;
  plat2Y = 310;
  plat3X = 406;
  plat3Y = 605;
  plat4X = 838;
  plat4Y = 20;
  plat1mov = 1.5f;
  plat2mov = 1.5f;
  plat3mov = 1.5f;
  plat4mov = 1.5f;
}

public void draw () {
  if (paso == 0) {
    Inicio();
  }
  if (paso == 1) {
    Level1();
  }
  if (paso == 2) {
    Perder();
  }
  if (paso == 3) {
    Iniciolvl2();
  }
  if (paso == 4) {
    Level2();
  }
  if (paso == 5) {
    Perder();
  }
  if (paso == 6) {
    Iniciolvl3();
  }
  if (paso == 7) {
    Level3();
  }
  if (paso == 8) {
    Perder();
  }
  if (paso == 9) {
    Ganar();
  }
}




public void keyPressed() {
  if ((keyCode == UP) && (caer == false)) {
    if (salto == 0) {
      jumpin.trigger();
    }

    salto = 1;
  }
  if (keyCode == LEFT) {
    rectmovX = -2.3f;
  }
  if (keyCode == RIGHT) {
    rectmovX = 2.3f;
  }

  if (key == 'l') {
    paso = paso + 1;
    if (paso == 4) {
      rectX = 1100;
      rectY = 640;
    }
    if (paso == 1) {
      musikini.pause();
      musik1.loop();
    }
    if (paso == 4) {
      musikini.pause();
      musik1.pause();
      musik2.loop();
    }
    if (paso == 7) {
      musikini.pause();
      musik1.pause();
      musik2.pause();
      musik3.loop();
    }
  }
  if (paso == 2) {
    if (key == 'r') {
      paso = 1;
      rectX = 70;
      rectY = 680;
    }
  }
  if (paso == 5) {
    if (key == 'r') {
      paso = 4;
      rectX = 1100;
      rectY = 640;
    }
  }
  if (paso == 8) {
    if (key == 'r') {
      paso = 7;
      rectX = 1180;
      rectY = 665;
    }
  }
  if (paso == 0) {
    if (key == 's') {
      paso = 1;
      rectX = 70;
      rectY = 680;
      musikini.pause();
      musik1.loop();
    }
  }
  if (paso == 3) {
    if (key == 's') {
      paso = 4;
      rectX = 1100;
      rectY = 640;
      musikini.pause();
      musik1.pause();
      musik2.loop();
    }
  }
  if (paso == 6) {
    if (key == 's') {
      paso = 7;
      rectX = 1180;
      rectY = 665;
      musikini.pause();
      musik1.pause();
      musik2.pause();
      musik3.loop();
    }
  }
}
public void Inicio(){
  imageMode(CORNER);
  image (inicio,0,0);
}
public void Level2() {
  background (189,243,255);
  imageMode (CORNER);
  image (Nivel2, fondoX, fondoY);
  noStroke ();
  fill (200, 0, 0);
  imageMode (CENTER);
  if (rectmovX <= -2.3f) {
    image (playerizq, rectX, rectY, 64, 30);
  }
  if (rectmovX >= 2.3f) {
    image (playerder, rectX, rectY, 64, 30);
  }
  rectX = rectX + rectmovX;

  //salto
  if (salto == 1) {
    if ((get(PApplet.parseInt(rectX), PApplet.parseInt(rectY-19)) == color (0)) //colisión arriba
      || (get(PApplet.parseInt(rectX), PApplet.parseInt(rectY-19)) == color (255))
      || (get(PApplet.parseInt(rectX), PApplet.parseInt(rectY-19)) == color (94, 179, 255))
      || (get(PApplet.parseInt(rectX), PApplet.parseInt(rectY-19)) == color (156, 223, 255))) { 
      rectmovY =0.4f;
    }
    rectmovY = rectmovY + 0.4f;
    rectY = rectY + rectmovY;
  }




  if ((get(PApplet.parseInt(rectX), PApplet.parseInt(rectY+16)) == color (0))  //colisión abajo
    || (get(PApplet.parseInt(rectX), PApplet.parseInt(rectY+16)) == color (255))
    || (get(PApplet.parseInt(rectX), PApplet.parseInt(rectY+16)) == color (94, 179, 255))
    || (get(PApplet.parseInt(rectX), PApplet.parseInt(rectY+16)) == color (156, 223, 255))) { 
    salto = 0;
    rectmovY = -10.2f;
  } else {
  }

  if ((salto == 0) && (get(PApplet.parseInt(rectX), PApplet.parseInt(rectY+17)) == color (189,243,255))) { //caer
    caer = true;
  } else {
    caer = false; //no caer
    pYfall = 0.4f;
  }

  if (caer == true) {
    rectY = rectY + pYfall; //caer
    pYfall = pYfall + 0.4f;
  }




  //mov lateral
  if ((get(PApplet.parseInt (rectX +27), PApplet.parseInt(rectY)) == color (0)) 
    || (get(PApplet.parseInt (rectX +27), PApplet.parseInt(rectY)) == color (255))
    || (get(PApplet.parseInt (rectX +27), PApplet.parseInt(rectY)) == color (94, 179, 255))
    || (get(PApplet.parseInt (rectX +27), PApplet.parseInt(rectY)) == color (156, 223, 255))) { //colisión derecha
    if (rectmovX == 2.3f) {
      rectmovX = -2.3f;
    }
  }
  if ((get(PApplet.parseInt (rectX -27), PApplet.parseInt(rectY)) == color (0)) 
    || (get(PApplet.parseInt (rectX -27), PApplet.parseInt(rectY)) == color (255))
    || (get(PApplet.parseInt (rectX -27), PApplet.parseInt(rectY)) == color (94, 179, 255))
    || (get(PApplet.parseInt (rectX -27), PApplet.parseInt(rectY)) == color (156, 223, 255))) { //colisión izquierda
    if (rectmovX == -2.3f) {
      rectmovX = 2.3f;
    }
  }
   if ((get(PApplet.parseInt (rectX +25), PApplet.parseInt(rectY)) == color (0, 0, 107)) 
    || (get(PApplet.parseInt (rectX +25), PApplet.parseInt(rectY)) == color (71, 0, 194))
    || (get(PApplet.parseInt (rectX +25), PApplet.parseInt(rectY)) == color (20, 30, 107))) { //colisión derecha espina
    paso = paso + 1;
    losing.trigger();
  }
  if ((get(PApplet.parseInt (rectX -25), PApplet.parseInt(rectY)) == color (0, 0, 107)) 
    || (get(PApplet.parseInt (rectX -25), PApplet.parseInt(rectY)) == color (71, 0, 194))
    || (get(PApplet.parseInt (rectX -25), PApplet.parseInt(rectY)) == color (20, 30, 107))) { //colisión izquierda espina 
    paso = paso + 1;
    losing.trigger();
  }
  if ((get(PApplet.parseInt (rectX), PApplet.parseInt(rectY+16)) == color (0, 0, 107)) 
    || (get(PApplet.parseInt (rectX), PApplet.parseInt(rectY+16)) == color (71, 0, 194))
    || (get(PApplet.parseInt (rectX), PApplet.parseInt(rectY+16)) == color (20, 30, 107))) { //colisión abajo espina
    paso = paso + 1;
    losing.trigger();
  }
  if ((get(PApplet.parseInt (rectX), PApplet.parseInt(rectY-19)) == color (0, 0, 107)) 
    || (get(PApplet.parseInt (rectX), PApplet.parseInt(rectY-19)) == color (71, 0, 194))
    || (get(PApplet.parseInt (rectX), PApplet.parseInt(rectY-19)) == color (20, 30, 107))) { //colisión arriba espina
    paso = paso + 1;
    losing.trigger();
  }
  
  if ((get(PApplet.parseInt (rectX -26), PApplet.parseInt(rectY)) == color (178,196,75)) 
    || (get(PApplet.parseInt (rectX -26), PApplet.parseInt(rectY)) == color (0,112,139))
    || (get(PApplet.parseInt (rectX -26), PApplet.parseInt(rectY)) == color (41,163,188))
    || (get(PApplet.parseInt (rectX -26), PApplet.parseInt(rectY)) == color (125,229,230))
    || (get(PApplet.parseInt (rectX -26), PApplet.parseInt(rectY)) == color (55,211,229))
    || (get(PApplet.parseInt (rectX -26), PApplet.parseInt(rectY)) == color (0,185,215))
    || (get(PApplet.parseInt (rectX -26), PApplet.parseInt(rectY)) == color (44,163,187))) { //colisión izquierda iglu
     paso = paso + 2;
    winin.trigger();
  }
  if ((get(PApplet.parseInt (rectX), PApplet.parseInt(rectY+16)) == color (178,196,75)) 
    || (get(PApplet.parseInt (rectX), PApplet.parseInt(rectY+16)) == color (0,112,139))
    || (get(PApplet.parseInt (rectX), PApplet.parseInt(rectY+16)) == color (41,163,188))
    || (get(PApplet.parseInt (rectX), PApplet.parseInt(rectY+16)) == color (125,229,230))
    || (get(PApplet.parseInt (rectX), PApplet.parseInt(rectY+16)) == color (55,211,229))
    || (get(PApplet.parseInt (rectX), PApplet.parseInt(rectY+16)) == color (0,185,215))
    || (get(PApplet.parseInt (rectX), PApplet.parseInt(rectY+16)) == color (44,163,187))) { //colisión abajo iglu
   paso = paso + 2;
    winin.trigger();
  }
if ((get(PApplet.parseInt (rectX), PApplet.parseInt(rectY-19)) == color (178,196,75)) 
    || (get(PApplet.parseInt (rectX), PApplet.parseInt(rectY-19)) == color (0,112,139))
    || (get(PApplet.parseInt (rectX), PApplet.parseInt(rectY-19)) == color (41,163,188))
    || (get(PApplet.parseInt (rectX), PApplet.parseInt(rectY-19)) == color (125,229,230))
    || (get(PApplet.parseInt (rectX), PApplet.parseInt(rectY-19)) == color (55,211,229))
    || (get(PApplet.parseInt (rectX), PApplet.parseInt(rectY-19)) == color (0,185,215))
    || (get(PApplet.parseInt (rectX), PApplet.parseInt(rectY-19)) == color (44,163,187))) { //colisión arriba iglu
     paso = paso + 2;
    winin.trigger();
  }
}
public void Level3 () {
  background (189,243,255);
  imageMode (CORNER);
  image (Nivel3, fondoX, fondoY);
  noStroke ();
  fill (200, 0, 0);
  imageMode (CENTER);

  image (platlar, plat1X, plat1Y);
  image (platlar, plat2X, plat2Y);
  image (platlar, plat3X, plat3Y);
  image (platcor, plat4X, plat4Y);
  if (rectmovX <= -2.3f) {
    image (playerizq, rectX, rectY, 64, 30);
  }
  if (rectmovX >= 2.3f) {
    image (playerder, rectX, rectY, 64, 30);
  }

  rectX = rectX + rectmovX;
  plat1X = plat1X + plat1mov;
  plat2X = plat2X + plat2mov;
  plat3X = plat3X + plat3mov;
  plat4X = plat4X + plat4mov;

  if (plat1X >= 1075) {
    plat1mov = -1.5f;
  }
  if (plat1X <= 880) {
    plat1mov = 1.5f;
  }

  if (plat2X >= 525) {
    plat2mov = -1.5f;
  }
  if (plat2X <= 420) {
    plat2mov = 1.5f;
  }
  if (plat3X >= 530) {
    plat3mov = -1.5f;
  }
  if (plat3X <= 250) {
    plat3mov = 1.5f;
  }
  if (plat4X >= 1000) {
    plat4mov = -1.5f;
  }
  if (plat4X <= 800) {
    plat4mov = 1.5f;
  }






  //salto
  if (salto == 1) {
    if ((get(PApplet.parseInt(rectX), PApplet.parseInt(rectY-19)) == color (0)) //colisión arriba
      || (get(PApplet.parseInt(rectX), PApplet.parseInt(rectY-19)) == color (255))
      || (get(PApplet.parseInt(rectX), PApplet.parseInt(rectY-19)) == color (94, 179, 255))
      || (get(PApplet.parseInt(rectX), PApplet.parseInt(rectY-19)) == color (154, 133, 255))
      || (get(PApplet.parseInt(rectX), PApplet.parseInt(rectY-19)) == color (178, 194, 255))
      || (get(PApplet.parseInt(rectX), PApplet.parseInt(rectY-19)) == color (156, 223, 255))) { 
      rectmovY =0.4f;
    }
    rectmovY = rectmovY + 0.4f;
    rectY = rectY + rectmovY;
  }




  if ((get(PApplet.parseInt(rectX), PApplet.parseInt(rectY+16)) == color (0))  //colisión abajo
    || (get(PApplet.parseInt(rectX), PApplet.parseInt(rectY+16)) == color (255))
    || (get(PApplet.parseInt(rectX), PApplet.parseInt(rectY+16)) == color (94, 179, 255))
    || (get(PApplet.parseInt(rectX), PApplet.parseInt(rectY+16)) == color (154, 133, 255))
    || (get(PApplet.parseInt(rectX), PApplet.parseInt(rectY+16)) == color (178, 194, 255))
    || (get(PApplet.parseInt(rectX), PApplet.parseInt(rectY+16)) == color (156, 223, 255))) { 
    salto = 0;
    rectmovY = -10.2f;
  } else {
  }

  if ((salto == 0) && (get(PApplet.parseInt(rectX), PApplet.parseInt(rectY+17)) == color (189,243,255))) { //caer
    caer = true;
  } else {
    caer = false; //no caer
    pYfall = 0.4f;
  }

  if (caer == true) {
    rectY = rectY + pYfall; //caer
    pYfall = pYfall + 0.4f;
  }




  //mov lateral
  if ((get(PApplet.parseInt (rectX +27), PApplet.parseInt(rectY)) == color (0)) 
    || (get(PApplet.parseInt (rectX +27), PApplet.parseInt(rectY)) == color (255))
    || (get(PApplet.parseInt (rectX +27), PApplet.parseInt(rectY)) == color (94, 179, 255))
    || (get(PApplet.parseInt(rectX +27), PApplet.parseInt(rectY)) == color (154, 133, 255))
    || (get(PApplet.parseInt(rectX +27), PApplet.parseInt(rectY)) == color (178, 194, 255))
    || (get(PApplet.parseInt (rectX +27), PApplet.parseInt(rectY)) == color (156, 223, 255))) { //colisión derecha
    if (rectmovX == 2.3f) {
      rectmovX = -2.3f;
    }
  }
  if ((get(PApplet.parseInt (rectX -27), PApplet.parseInt(rectY)) == color (0)) 
    || (get(PApplet.parseInt (rectX -27), PApplet.parseInt(rectY)) == color (255))
    || (get(PApplet.parseInt (rectX -27), PApplet.parseInt(rectY)) == color (94, 179, 255))
    || (get(PApplet.parseInt(rectX -27), PApplet.parseInt(rectY)) == color (154, 133, 255))
    || (get(PApplet.parseInt(rectX -27), PApplet.parseInt(rectY)) == color (178, 194, 255))
    || (get(PApplet.parseInt (rectX -27), PApplet.parseInt(rectY)) == color (156, 223, 255))) { //colisión izquierda
    if (rectmovX == -2.3f) {
      rectmovX = 2.3f;
    }
  }

  if ((get(PApplet.parseInt (rectX +25), PApplet.parseInt(rectY)) == color (0, 0, 107)) 
    || (get(PApplet.parseInt (rectX +25), PApplet.parseInt(rectY)) == color (71, 0, 194))
    || (get(PApplet.parseInt (rectX +25), PApplet.parseInt(rectY)) == color (20, 30, 107))) { //colisión derecha espina
    paso = paso + 1;
    losing.trigger();
  }
  if ((get(PApplet.parseInt (rectX -25), PApplet.parseInt(rectY)) == color (0, 0, 107)) 
    || (get(PApplet.parseInt (rectX -25), PApplet.parseInt(rectY)) == color (71, 0, 194))
    || (get(PApplet.parseInt (rectX -25), PApplet.parseInt(rectY)) == color (20, 30, 107))) { //colisión izquierda espina 
    paso = paso + 1;
    losing.trigger();
  }
  if ((get(PApplet.parseInt (rectX), PApplet.parseInt(rectY+16)) == color (0, 0, 107)) 
    || (get(PApplet.parseInt (rectX), PApplet.parseInt(rectY+16)) == color (71, 0, 194))
    || (get(PApplet.parseInt (rectX), PApplet.parseInt(rectY+16)) == color (20, 30, 107))) { //colisión abajo espina
    paso = paso + 1;
    losing.trigger();
  }
  if ((get(PApplet.parseInt (rectX), PApplet.parseInt(rectY-19)) == color (0, 0, 107)) 
    || (get(PApplet.parseInt (rectX), PApplet.parseInt(rectY-19)) == color (71, 0, 194))
    || (get(PApplet.parseInt (rectX), PApplet.parseInt(rectY-19)) == color (20, 30, 107))) { //colisión arriba espina
    paso = paso + 1;
    losing.trigger();
  }

  if ((get(PApplet.parseInt (rectX -26), PApplet.parseInt(rectY)) == color (178, 196, 75)) 
    || (get(PApplet.parseInt (rectX -26), PApplet.parseInt(rectY)) == color (0, 112, 139))
    || (get(PApplet.parseInt (rectX -26), PApplet.parseInt(rectY)) == color (41, 163, 188))
    || (get(PApplet.parseInt (rectX -26), PApplet.parseInt(rectY)) == color (125, 229, 230))
    || (get(PApplet.parseInt (rectX -26), PApplet.parseInt(rectY)) == color (55, 211, 229))
    || (get(PApplet.parseInt (rectX -26), PApplet.parseInt(rectY)) == color (0, 185, 215))
    || (get(PApplet.parseInt (rectX -26), PApplet.parseInt(rectY)) == color (44, 163, 187))) { //colisión izquierda iglu
    paso = paso + 2;
    winin.trigger();
  }
  if ((get(PApplet.parseInt (rectX), PApplet.parseInt(rectY+16)) == color (178, 196, 75)) 
    || (get(PApplet.parseInt (rectX), PApplet.parseInt(rectY+16)) == color (0, 112, 139))
    || (get(PApplet.parseInt (rectX), PApplet.parseInt(rectY+16)) == color (41, 163, 188))
    || (get(PApplet.parseInt (rectX), PApplet.parseInt(rectY+16)) == color (125, 229, 230))
    || (get(PApplet.parseInt (rectX), PApplet.parseInt(rectY+16)) == color (55, 211, 229))
    || (get(PApplet.parseInt (rectX), PApplet.parseInt(rectY+16)) == color (0, 185, 215))
    || (get(PApplet.parseInt (rectX), PApplet.parseInt(rectY+16)) == color (44, 163, 187))) { //colisión abajo iglu
    paso = paso + 2;
    winin.trigger();
  }
  if ((get(PApplet.parseInt (rectX), PApplet.parseInt(rectY-19)) == color (178, 196, 75)) 
    || (get(PApplet.parseInt (rectX), PApplet.parseInt(rectY-19)) == color (0, 112, 139))
    || (get(PApplet.parseInt (rectX), PApplet.parseInt(rectY-19)) == color (41, 163, 188))
    || (get(PApplet.parseInt (rectX), PApplet.parseInt(rectY-19)) == color (125, 229, 230))
    || (get(PApplet.parseInt (rectX), PApplet.parseInt(rectY-19)) == color (55, 211, 229))
    || (get(PApplet.parseInt (rectX), PApplet.parseInt(rectY-19)) == color (0, 185, 215))
    || (get(PApplet.parseInt (rectX), PApplet.parseInt(rectY-19)) == color (44, 163, 187))) { //colisión arriba iglu
    paso = paso + 2;
    winin.trigger();
  }
}
public void Level1 () {
  background (189,243,255);
  imageMode(CORNER);
  image (Nivel1, fondoX, fondoY);
  noStroke ();
  fill (200, 0, 0);
  imageMode (CENTER);

  if (rectmovX <= -2.3f) {
    image (playerizq, rectX, rectY, 64, 30);
  }
  if (rectmovX >= 2.3f) {
    image (playerder, rectX, rectY, 64, 30);
  }
  rectX = rectX + rectmovX;

  //salto
  if (salto == 1) {
    if ((get(PApplet.parseInt(rectX), PApplet.parseInt(rectY-19)) == color (0)) //colisión arriba
      || (get(PApplet.parseInt(rectX), PApplet.parseInt(rectY-19)) == color (255))
      || (get(PApplet.parseInt(rectX), PApplet.parseInt(rectY-19)) == color (95, 179, 255))
      || (get(PApplet.parseInt(rectX), PApplet.parseInt(rectY-19)) == color (156, 223, 255))) { 
      rectmovY =0.4f;
    }
    rectmovY = rectmovY + 0.4f;
    rectY = rectY + rectmovY;
  }




  if ((get(PApplet.parseInt(rectX), PApplet.parseInt(rectY+16)) == color (0))  //colisión abajo
    || (get(PApplet.parseInt(rectX), PApplet.parseInt(rectY+16)) == color (255))
    || (get(PApplet.parseInt(rectX), PApplet.parseInt(rectY+16)) == color (95, 179, 255))
    || (get(PApplet.parseInt(rectX), PApplet.parseInt(rectY+16)) == color (156, 223, 255))) { 
    salto = 0;
    rectmovY = -10.2f;
  } else {
  }

  if ((salto == 0) && (get(PApplet.parseInt(rectX), PApplet.parseInt(rectY+17)) == color (189,243,255))) { //caer
    caer = true;
  } else {
    caer = false; //no caer
    pYfall = 0.4f;
  }

  if (caer == true) {
    rectY = rectY + pYfall; //caer
    pYfall = pYfall + 0.4f;
  }




  //mov lateral
  if ((get(PApplet.parseInt (rectX +27), PApplet.parseInt(rectY)) == color (0)) 
    || (get(PApplet.parseInt (rectX +27), PApplet.parseInt(rectY)) == color (255))
    || (get(PApplet.parseInt (rectX +27), PApplet.parseInt(rectY)) == color (95, 179, 255))
    || (get(PApplet.parseInt (rectX +27), PApplet.parseInt(rectY)) == color (156, 223, 255))) { //colisión derecha
    if (rectmovX == 2.3f) {
      rectmovX = -2.3f;
    }
  }
  if ((get(PApplet.parseInt (rectX -27), PApplet.parseInt(rectY)) == color (0)) 
    || (get(PApplet.parseInt (rectX -27), PApplet.parseInt(rectY)) == color (255))
    || (get(PApplet.parseInt (rectX -27), PApplet.parseInt(rectY)) == color (95, 179, 255))
    || (get(PApplet.parseInt (rectX -27), PApplet.parseInt(rectY)) == color (156, 223, 255))) { //colisión izquierda
    if (rectmovX == -2.3f) {
      rectmovX = 2.3f;
    }
  }


  if ((get(PApplet.parseInt (rectX +25), PApplet.parseInt(rectY)) == color (0, 0, 107)) 
    || (get(PApplet.parseInt (rectX +25), PApplet.parseInt(rectY)) == color (71, 0, 194))
    || (get(PApplet.parseInt (rectX +25), PApplet.parseInt(rectY)) == color (20, 30, 107))) { //colisión derecha espina
    paso = paso + 1;
    losing.trigger();
  }
  if ((get(PApplet.parseInt (rectX -25), PApplet.parseInt(rectY)) == color (0, 0, 107)) 
    || (get(PApplet.parseInt (rectX -25), PApplet.parseInt(rectY)) == color (71, 0, 194))
    || (get(PApplet.parseInt (rectX -25), PApplet.parseInt(rectY)) == color (20, 30, 107))) { //colisión izquierda espina
    paso = paso + 1;
    losing.trigger();
  }
  if ((get(PApplet.parseInt (rectX), PApplet.parseInt(rectY+16)) == color (0, 0, 107)) 
    || (get(PApplet.parseInt (rectX), PApplet.parseInt(rectY+16)) == color (71, 0, 194))
    || (get(PApplet.parseInt (rectX), PApplet.parseInt(rectY+16)) == color (20, 30, 107))) { //colisión abajo espina
    paso = paso + 1;
    losing.trigger();
  }
  if ((get(PApplet.parseInt (rectX), PApplet.parseInt(rectY-19)) == color (0, 0, 107)) 
    || (get(PApplet.parseInt (rectX), PApplet.parseInt(rectY-19)) == color (71, 0, 194))
    || (get(PApplet.parseInt (rectX), PApplet.parseInt(rectY-19)) == color (20, 30, 107))) { //colisión arriba espina
    paso = paso + 1;
    losing.trigger();
  }
  if ((get(PApplet.parseInt (rectX +26), PApplet.parseInt(rectY)) == color (178,196,75)) 
    || (get(PApplet.parseInt (rectX +26), PApplet.parseInt(rectY)) == color (0,112,139))
    || (get(PApplet.parseInt (rectX +26), PApplet.parseInt(rectY)) == color (41,163,188))
    || (get(PApplet.parseInt (rectX +26), PApplet.parseInt(rectY)) == color (125,229,230))
    || (get(PApplet.parseInt (rectX +26), PApplet.parseInt(rectY)) == color (55,211,229))
    || (get(PApplet.parseInt (rectX +26), PApplet.parseInt(rectY)) == color (0,185,215))
    || (get(PApplet.parseInt (rectX +26), PApplet.parseInt(rectY)) == color (44,163,187))) { //colisión derecha iglu
    paso = paso + 2;
    winin.trigger();
  }
  
  if ((get(PApplet.parseInt (rectX -26), PApplet.parseInt(rectY)) == color (178,196,75)) 
    || (get(PApplet.parseInt (rectX -26), PApplet.parseInt(rectY)) == color (0,112,139))
    || (get(PApplet.parseInt (rectX -26), PApplet.parseInt(rectY)) == color (41,163,188))
    || (get(PApplet.parseInt (rectX -26), PApplet.parseInt(rectY)) == color (125,229,230))
    || (get(PApplet.parseInt (rectX -26), PApplet.parseInt(rectY)) == color (55,211,229))
    || (get(PApplet.parseInt (rectX -26), PApplet.parseInt(rectY)) == color (0,185,215))
    || (get(PApplet.parseInt (rectX -26), PApplet.parseInt(rectY)) == color (44,163,187))) { //colisión izquierda iglu
     paso = paso + 2;
    winin.trigger();
  }
  if ((get(PApplet.parseInt (rectX), PApplet.parseInt(rectY+16)) == color (178,196,75)) 
    || (get(PApplet.parseInt (rectX), PApplet.parseInt(rectY+16)) == color (0,112,139))
    || (get(PApplet.parseInt (rectX), PApplet.parseInt(rectY+16)) == color (41,163,188))
    || (get(PApplet.parseInt (rectX), PApplet.parseInt(rectY+16)) == color (125,229,230))
    || (get(PApplet.parseInt (rectX), PApplet.parseInt(rectY+16)) == color (55,211,229))
    || (get(PApplet.parseInt (rectX), PApplet.parseInt(rectY+16)) == color (0,185,215))
    || (get(PApplet.parseInt (rectX), PApplet.parseInt(rectY+16)) == color (44,163,187))) { //colisión abajo iglu
   paso = paso + 2;
    winin.trigger();
  }
if ((get(PApplet.parseInt (rectX), PApplet.parseInt(rectY-19)) == color (178,196,75)) 
    || (get(PApplet.parseInt (rectX), PApplet.parseInt(rectY-19)) == color (0,112,139))
    || (get(PApplet.parseInt (rectX), PApplet.parseInt(rectY-19)) == color (41,163,188))
    || (get(PApplet.parseInt (rectX), PApplet.parseInt(rectY-19)) == color (125,229,230))
    || (get(PApplet.parseInt (rectX), PApplet.parseInt(rectY-19)) == color (55,211,229))
    || (get(PApplet.parseInt (rectX), PApplet.parseInt(rectY-19)) == color (0,185,215))
    || (get(PApplet.parseInt (rectX), PApplet.parseInt(rectY-19)) == color (44,163,187))) { //colisión arriba iglu
     paso = paso + 2;
    winin.trigger();
  }
}
public void Iniciolvl2(){
  imageMode (CORNER);
  image (pasarlvl2,0,0);
}

public void Iniciolvl3(){
  imageMode (CORNER);
  image (pasarlvl3,0,0);
}


public void Ganar(){
  imageMode (CORNER);
  image (ganar,0,0);
}

public void Perder(){
   imageMode (CORNER);
  image (perder,0,0);
  
}
  public void settings() {  size (1280, 720); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "tpfinal" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
